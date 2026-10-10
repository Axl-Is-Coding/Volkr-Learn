package bolts;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: AndroidExecutors.java */
/* JADX INFO: loaded from: classes.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f2816a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f2817b = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final int f2818c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int f2819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f2820e = new a();

    /* JADX INFO: compiled from: AndroidExecutors.java */
    private static class a implements Executor {
        private a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    static {
        int i = f2817b;
        f2818c = i + 1;
        f2819d = (i * 2) + 1;
    }

    private b() {
    }

    public static ExecutorService a() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f2818c, f2819d, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        a(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    public static Executor b() {
        return f2816a.f2820e;
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        if (Build.VERSION.SDK_INT >= 9) {
            threadPoolExecutor.allowCoreThreadTimeOut(z);
        }
    }
}
