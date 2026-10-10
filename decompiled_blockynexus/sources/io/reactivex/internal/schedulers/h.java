package io.reactivex.internal.schedulers;

import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SchedulerPoolFactory.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f22685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f22686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final AtomicReference<ScheduledExecutorService> f22687c = new AtomicReference<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Map<ScheduledThreadPoolExecutor, Object> f22688d = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SchedulerPoolFactory.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f22689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f22690b;

        a() {
        }

        void a(Properties properties) {
            if (properties.containsKey("rx2.purge-enabled")) {
                this.f22689a = Boolean.parseBoolean(properties.getProperty("rx2.purge-enabled"));
            } else {
                this.f22689a = true;
            }
            if (!this.f22689a || !properties.containsKey("rx2.purge-period-seconds")) {
                this.f22690b = 1;
                return;
            }
            try {
                this.f22690b = Integer.parseInt(properties.getProperty("rx2.purge-period-seconds"));
            } catch (NumberFormatException unused) {
                this.f22690b = 1;
            }
        }
    }

    /* JADX INFO: compiled from: SchedulerPoolFactory.java */
    static final class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (ScheduledThreadPoolExecutor scheduledThreadPoolExecutor : new ArrayList(h.f22688d.keySet())) {
                if (scheduledThreadPoolExecutor.isShutdown()) {
                    h.f22688d.remove(scheduledThreadPoolExecutor);
                } else {
                    scheduledThreadPoolExecutor.purge();
                }
            }
        }
    }

    static {
        Properties properties = System.getProperties();
        a aVar = new a();
        aVar.a(properties);
        f22685a = aVar.f22689a;
        f22686b = aVar.f22690b;
        a();
    }

    public static void a() {
        a(f22685a);
    }

    static void a(boolean z) {
        if (!z) {
            return;
        }
        while (true) {
            ScheduledExecutorService scheduledExecutorService = f22687c.get();
            if (scheduledExecutorService != null) {
                return;
            }
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge"));
            if (f22687c.compareAndSet(scheduledExecutorService, scheduledExecutorServiceNewScheduledThreadPool)) {
                b bVar = new b();
                int i = f22686b;
                scheduledExecutorServiceNewScheduledThreadPool.scheduleAtFixedRate(bVar, i, i, TimeUnit.SECONDS);
                return;
            }
            scheduledExecutorServiceNewScheduledThreadPool.shutdownNow();
        }
    }

    public static ScheduledExecutorService a(ThreadFactory threadFactory) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        a(f22685a, scheduledExecutorServiceNewScheduledThreadPool);
        return scheduledExecutorServiceNewScheduledThreadPool;
    }

    static void a(boolean z, ScheduledExecutorService scheduledExecutorService) {
        if (z && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
            f22688d.put((ScheduledThreadPoolExecutor) scheduledExecutorService, scheduledExecutorService);
        }
    }
}
