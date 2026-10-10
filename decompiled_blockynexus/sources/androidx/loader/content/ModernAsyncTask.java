package androidx.loader.content;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static b f1625d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadFactory f1622a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final BlockingQueue<Runnable> f1623b = new LinkedBlockingQueue(10);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Executor f1624c = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f1623b, f1622a);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile Executor f1626e = f1624c;
    private volatile Status h = Status.PENDING;
    final AtomicBoolean i = new AtomicBoolean();
    final AtomicBoolean j = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c<Params, Result> f1627f = new e(this);
    private final FutureTask<Result> g = new f(this, this.f1627f);

    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    private static class a<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ModernAsyncTask f1628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Data[] f1629b;

        a(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f1628a = modernAsyncTask;
            this.f1629b = dataArr;
        }
    }

    private static class b extends Handler {
        b() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.f1628a.a(aVar.f1629b[0]);
            } else {
                if (i != 2) {
                    return;
                }
                aVar.f1628a.b((Object[]) aVar.f1629b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class c<Params, Result> implements Callable<Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Params[] f1630a;

        c() {
        }
    }

    ModernAsyncTask() {
    }

    private static Handler d() {
        b bVar;
        synchronized (ModernAsyncTask.class) {
            if (f1625d == null) {
                f1625d = new b();
            }
            bVar = f1625d;
        }
        return bVar;
    }

    protected abstract Result a(Params... paramsArr);

    public final boolean a() {
        return this.i.get();
    }

    protected void b() {
    }

    protected void b(Result result) {
        b();
    }

    protected void b(Progress... progressArr) {
    }

    protected void c() {
    }

    protected void c(Result result) {
    }

    void e(Result result) {
        if (this.j.get()) {
            return;
        }
        d(result);
    }

    public final boolean a(boolean z) {
        this.i.set(true);
        return this.g.cancel(z);
    }

    public final ModernAsyncTask<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.h != Status.PENDING) {
            int i = g.f1641a[this.h.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i != 2) {
                throw new IllegalStateException("We should never reach this state");
            }
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
        this.h = Status.RUNNING;
        c();
        this.f1627f.f1630a = paramsArr;
        executor.execute(this.g);
        return this;
    }

    Result d(Result result) {
        d().obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    void a(Result result) {
        if (a()) {
            b(result);
        } else {
            c(result);
        }
        this.h = Status.FINISHED;
    }
}
