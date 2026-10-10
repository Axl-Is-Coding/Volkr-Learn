package com.bumptech.glide.load.engine.c;

import android.text.TextUtils;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: GlideExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f4537a = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile int f4538b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ExecutorService f4539c;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: GlideExecutor.java */
    static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4546a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c f4547b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f4548c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f4549d;

        b(String str, c cVar, boolean z) {
            this.f4546a = str;
            this.f4547b = cVar;
            this.f4548c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            com.bumptech.glide.load.engine.c.b bVar;
            bVar = new com.bumptech.glide.load.engine.c.b(this, runnable, "glide-" + this.f4546a + "-thread-" + this.f4549d);
            this.f4549d = this.f4549d + 1;
            return bVar;
        }
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    public interface c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f4550a = new com.bumptech.glide.load.engine.c.c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f4551b = new d();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f4552c = new e();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f4553d = f4551b;

        void a(Throwable th);
    }

    a(ExecutorService executorService) {
        this.f4539c = executorService;
    }

    public static int a() {
        if (f4538b == 0) {
            f4538b = Math.min(4, g.a());
        }
        return f4538b;
    }

    public static C0062a b() {
        int i = a() >= 4 ? 2 : 1;
        C0062a c0062a = new C0062a(true);
        c0062a.a(i);
        c0062a.a("animation");
        return c0062a;
    }

    public static a c() {
        return b().a();
    }

    public static C0062a d() {
        C0062a c0062a = new C0062a(true);
        c0062a.a(1);
        c0062a.a("disk-cache");
        return c0062a;
    }

    public static a e() {
        return d().a();
    }

    public static C0062a f() {
        C0062a c0062a = new C0062a(false);
        c0062a.a(a());
        c0062a.a("source");
        return c0062a;
    }

    public static a g() {
        return f().a();
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f4537a, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b("source-unlimited", c.f4553d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f4539c.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f4539c.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f4539c.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f4539c.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f4539c.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f4539c.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f4539c.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f4539c.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f4539c.submit(runnable);
    }

    public String toString() {
        return this.f4539c.toString();
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GlideExecutor.java */
    public static final class C0062a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f4540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4541b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4542c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f4543d = c.f4553d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f4544e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f4545f;

        C0062a(boolean z) {
            this.f4540a = z;
        }

        public C0062a a(int i) {
            this.f4541b = i;
            this.f4542c = i;
            return this;
        }

        public C0062a a(String str) {
            this.f4544e = str;
            return this;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f4544e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f4541b, this.f4542c, this.f4545f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f4544e, this.f4543d, this.f4540a));
                if (this.f4545f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f4544e);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.f4539c.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f4539c.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.f4539c.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f4539c.submit(callable);
    }
}
