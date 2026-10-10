package io.grpc;

import com.google.common.base.m;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes5.dex */
public class Context {
    private final boolean canBeCancelled;
    private final boolean cascadesCancellation;
    private final Object[][] keyValueEntries;
    private ArrayList<ExecutableListener> listeners;
    private final Context parent;
    private CancellationListener parentListener;
    private static final Logger LOG = Logger.getLogger(Context.class.getName());
    private static final Object[][] EMPTY_ENTRIES = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);
    private static final Key<Deadline> DEADLINE_KEY = new Key<>("deadline");
    public static final Context ROOT = new Context(null);
    private static final ThreadLocal<Context> localContext = new ThreadLocal<Context>() { // from class: io.grpc.Context.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Context initialValue() {
            return Context.ROOT;
        }
    };

    public interface CancellationListener {
        void cancelled(Context context);
    }

    private class ExecutableListener implements Runnable {
        private final Executor executor;
        private final CancellationListener listener;

        /* JADX INFO: Access modifiers changed from: private */
        public void deliver() {
            try {
                this.executor.execute(this);
            } catch (Throwable th) {
                Context.LOG.log(Level.INFO, "Exception notifying context listener", th);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.listener.cancelled(Context.this);
        }

        private ExecutableListener(Executor executor, CancellationListener cancellationListener) {
            this.executor = executor;
            this.listener = cancellationListener;
        }
    }

    public static class Key<T> {
        private final T defaultValue;
        private final String name;

        Key(String str) {
            this(str, null);
        }

        public T get() {
            return get(Context.current());
        }

        public String toString() {
            return this.name;
        }

        Key(String str, T t) {
            m.a(str);
            this.name = str;
            this.defaultValue = t;
        }

        public T get(Context context) {
            T t = (T) context.lookup(this);
            return t == null ? this.defaultValue : t;
        }
    }

    private class ParentListener implements CancellationListener {
        private ParentListener() {
        }

        @Override // io.grpc.Context.CancellationListener
        public void cancelled(Context context) {
            Context context2 = Context.this;
            if (context2 instanceof CancellableContext) {
                ((CancellableContext) context2).cancel(context.cancellationCause());
            } else {
                context2.notifyAndClearListeners();
            }
        }
    }

    public static Context current() {
        Context context = localContext.get();
        return context == null ? ROOT : context;
    }

    public static Executor currentContextExecutor(final Executor executor) {
        return new Executor() { // from class: io.grpc.Context.1CurrentContextExecutor
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                executor.execute(Context.current().wrap(runnable));
            }
        };
    }

    public static <T> Key<T> key(String str) {
        return new Key<>(str);
    }

    public static <T> Key<T> keyWithDefault(String str, T t) {
        return new Key<>(str, t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object lookup(Key<?> key) {
        int i = 0;
        while (true) {
            Object[][] objArr = this.keyValueEntries;
            if (i >= objArr.length) {
                Context context = this.parent;
                if (context == null) {
                    return null;
                }
                return context.lookup(key);
            }
            if (key.equals(objArr[i][0])) {
                return this.keyValueEntries[i][1];
            }
            i++;
        }
    }

    public void addListener(CancellationListener cancellationListener, Executor executor) {
        m.a(cancellationListener);
        m.a(executor);
        if (this.canBeCancelled) {
            ExecutableListener executableListener = new ExecutableListener(executor, cancellationListener);
            synchronized (this) {
                if (isCancelled()) {
                    executableListener.deliver();
                } else if (this.listeners == null) {
                    this.listeners = new ArrayList<>();
                    this.listeners.add(executableListener);
                    this.parent.addListener(this.parentListener, MoreExecutors.a());
                } else {
                    this.listeners.add(executableListener);
                }
            }
        }
    }

    public Context attach() {
        Context contextCurrent = current();
        localContext.set(this);
        return contextCurrent;
    }

    public <V> V call(Callable<V> callable) throws Exception {
        Context contextAttach = attach();
        try {
            return callable.call();
        } finally {
            detach(contextAttach);
        }
    }

    boolean canBeCancelled() {
        return this.canBeCancelled;
    }

    public Throwable cancellationCause() {
        Context context = this.parent;
        if (context == null || !this.cascadesCancellation) {
            return null;
        }
        return context.cancellationCause();
    }

    public void detach(Context context) {
        m.a(context);
        if (context.attach() != this) {
            LOG.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
    }

    public Executor fixedContextExecutor(final Executor executor) {
        return new Executor() { // from class: io.grpc.Context.1FixedContextExecutor
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                executor.execute(Context.this.wrap(runnable));
            }
        };
    }

    public Context fork() {
        return new Context(this);
    }

    public Deadline getDeadline() {
        return DEADLINE_KEY.get(this);
    }

    public boolean isCancelled() {
        Context context = this.parent;
        if (context == null || !this.cascadesCancellation) {
            return false;
        }
        return context.isCancelled();
    }

    boolean isCurrent() {
        return current() == this;
    }

    int listenerCount() {
        int size;
        synchronized (this) {
            size = this.listeners == null ? 0 : this.listeners.size();
        }
        return size;
    }

    void notifyAndClearListeners() {
        if (this.canBeCancelled) {
            synchronized (this) {
                if (this.listeners == null) {
                    return;
                }
                ArrayList<ExecutableListener> arrayList = this.listeners;
                this.listeners = null;
                for (int i = 0; i < arrayList.size(); i++) {
                    if (!(arrayList.get(i).listener instanceof ParentListener)) {
                        arrayList.get(i).deliver();
                    }
                }
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    if (arrayList.get(i2).listener instanceof ParentListener) {
                        arrayList.get(i2).deliver();
                    }
                }
                this.parent.removeListener(this.parentListener);
            }
        }
    }

    public void removeListener(CancellationListener cancellationListener) {
        if (this.canBeCancelled) {
            synchronized (this) {
                if (this.listeners != null) {
                    int size = this.listeners.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        }
                        if (this.listeners.get(size).listener == cancellationListener) {
                            this.listeners.remove(size);
                            break;
                        }
                        size--;
                    }
                    if (this.listeners.isEmpty()) {
                        this.parent.removeListener(this.parentListener);
                        this.listeners = null;
                    }
                }
            }
        }
    }

    public void run(Runnable runnable) {
        Context contextAttach = attach();
        try {
            runnable.run();
        } finally {
            detach(contextAttach);
        }
    }

    public CancellableContext withCancellation() {
        return new CancellableContext();
    }

    public CancellableContext withDeadline(Deadline deadline, ScheduledExecutorService scheduledExecutorService) {
        m.a(deadline, "deadline");
        m.a(scheduledExecutorService, "scheduler");
        return new CancellableContext(deadline, scheduledExecutorService);
    }

    public CancellableContext withDeadlineAfter(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return withDeadline(Deadline.after(j, timeUnit), scheduledExecutorService);
    }

    public <V> Context withValue(Key<V> key, V v) {
        return new Context(this, new Object[][]{new Object[]{key, v}});
    }

    public <V1, V2> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2) {
        return new Context(this, new Object[][]{new Object[]{key, v1}, new Object[]{key2, v2}});
    }

    public Runnable wrap(final Runnable runnable) {
        return new Runnable() { // from class: io.grpc.Context.2
            @Override // java.lang.Runnable
            public void run() {
                Context contextAttach = Context.this.attach();
                try {
                    runnable.run();
                } finally {
                    Context.this.detach(contextAttach);
                }
            }
        };
    }

    public static final class CancellableContext extends Context {
        private Throwable cancellationCause;
        private boolean cancelled;
        private ScheduledFuture<?> pendingDeadline;
        private final Context uncancellableSurrogate;

        private static Object[][] deriveDeadline(Context context, Deadline deadline) {
            Deadline deadline2 = (Deadline) Context.DEADLINE_KEY.get(context);
            return (deadline2 == null || deadline.isBefore(deadline2)) ? new Object[][]{new Object[]{Context.DEADLINE_KEY, deadline}} : Context.EMPTY_ENTRIES;
        }

        @Override // io.grpc.Context
        public Context attach() {
            return this.uncancellableSurrogate.attach();
        }

        public boolean cancel(Throwable th) {
            boolean z;
            synchronized (this) {
                z = true;
                if (this.cancelled) {
                    z = false;
                } else {
                    this.cancelled = true;
                    if (this.pendingDeadline != null) {
                        this.pendingDeadline.cancel(false);
                        this.pendingDeadline = null;
                    }
                    this.cancellationCause = th;
                }
            }
            if (z) {
                notifyAndClearListeners();
            }
            return z;
        }

        @Override // io.grpc.Context
        public Throwable cancellationCause() {
            if (isCancelled()) {
                return this.cancellationCause;
            }
            return null;
        }

        @Override // io.grpc.Context
        public void detach(Context context) {
            this.uncancellableSurrogate.detach(context);
        }

        public void detachAndCancel(Context context, Throwable th) {
            try {
                detach(context);
            } finally {
                cancel(th);
            }
        }

        @Override // io.grpc.Context
        public boolean isCancelled() {
            synchronized (this) {
                if (this.cancelled) {
                    return true;
                }
                if (!super.isCancelled()) {
                    return false;
                }
                cancel(super.cancellationCause());
                return true;
            }
        }

        @Override // io.grpc.Context
        public boolean isCurrent() {
            return this.uncancellableSurrogate.isCurrent();
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private CancellableContext(Context context) {
            super(Context.EMPTY_ENTRIES, true);
            this.uncancellableSurrogate = new Context(Context.EMPTY_ENTRIES);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private CancellableContext(Context context, Deadline deadline, ScheduledExecutorService scheduledExecutorService) {
            super(deriveDeadline(context, deadline), true);
            if (Context.DEADLINE_KEY.get(this) == deadline) {
                final TimeoutException timeoutException = new TimeoutException("context timed out");
                if (!deadline.isExpired()) {
                    this.pendingDeadline = deadline.runOnExpiration(new Runnable() { // from class: io.grpc.Context.CancellableContext.1
                        @Override // java.lang.Runnable
                        public void run() {
                            CancellableContext.this.cancel(timeoutException);
                        }
                    }, scheduledExecutorService);
                } else {
                    cancel(timeoutException);
                }
            }
            this.uncancellableSurrogate = new Context(Context.EMPTY_ENTRIES);
        }
    }

    public <V1, V2, V3> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2, Key<V3> key3, V3 v3) {
        return new Context(this, new Object[][]{new Object[]{key, v1}, new Object[]{key2, v2}, new Object[]{key3, v3}});
    }

    public <C> Callable<C> wrap(final Callable<C> callable) {
        return new Callable<C>() { // from class: io.grpc.Context.3
            @Override // java.util.concurrent.Callable
            public C call() throws Exception {
                Context contextAttach = Context.this.attach();
                try {
                    return (C) callable.call();
                } finally {
                    Context.this.detach(contextAttach);
                }
            }
        };
    }

    private Context(Context context) {
        this.parentListener = new ParentListener();
        this.parent = context;
        this.keyValueEntries = new Object[][]{new Object[]{DEADLINE_KEY, null}};
        this.cascadesCancellation = false;
        this.canBeCancelled = false;
    }

    private Context(Context context, Object[][] objArr) {
        this.parentListener = new ParentListener();
        this.parent = context;
        this.keyValueEntries = objArr;
        this.cascadesCancellation = true;
        Context context2 = this.parent;
        this.canBeCancelled = context2 != null && context2.canBeCancelled;
    }

    private Context(Context context, Object[][] objArr, boolean z) {
        this.parentListener = new ParentListener();
        this.parent = context;
        this.keyValueEntries = objArr;
        this.cascadesCancellation = true;
        this.canBeCancelled = z;
    }
}
