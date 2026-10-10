package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: BoltsExecutors.java */
/* JADX INFO: loaded from: classes.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final g f2828a = new g();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ExecutorService f2829b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ScheduledExecutorService f2830c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f2831d;

    /* JADX INFO: compiled from: BoltsExecutors.java */
    private static class a implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadLocal<Integer> f2832a;

        private a() {
            this.f2832a = new ThreadLocal<>();
        }

        private int a() {
            Integer num = this.f2832a.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() - 1;
            if (iIntValue == 0) {
                this.f2832a.remove();
            } else {
                this.f2832a.set(Integer.valueOf(iIntValue));
            }
            return iIntValue;
        }

        private int b() {
            Integer num = this.f2832a.get();
            if (num == null) {
                num = 0;
            }
            int iIntValue = num.intValue() + 1;
            this.f2832a.set(Integer.valueOf(iIntValue));
            return iIntValue;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                if (b() <= 15) {
                    runnable.run();
                } else {
                    g.a().execute(runnable);
                }
            } finally {
                a();
            }
        }
    }

    private g() {
        this.f2829b = !c() ? Executors.newCachedThreadPool() : b.a();
        this.f2830c = Executors.newSingleThreadScheduledExecutor();
        this.f2831d = new a();
    }

    public static ExecutorService a() {
        return f2828a.f2829b;
    }

    static Executor b() {
        return f2828a.f2831d;
    }

    private static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }
}
