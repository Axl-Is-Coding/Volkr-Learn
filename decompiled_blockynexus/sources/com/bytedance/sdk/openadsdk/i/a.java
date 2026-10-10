package com.bytedance.sdk.openadsdk.i;

import com.bytedance.sdk.openadsdk.utils.o;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: TTExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f6983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f6984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f6985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile ThreadPoolExecutor f6986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile ScheduledExecutorService f6987f;
    private static ConcurrentHashMap<String, b> g;
    private static final ConcurrentHashMap<String, b> h = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, b> i = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, b> j = new ConcurrentHashMap<>();
    private static final AtomicBoolean k = new AtomicBoolean();

    private a() {
        if (k.get()) {
            return;
        }
        a(false);
    }

    public static void a(boolean z) {
        if (k.get()) {
            return;
        }
        f6983b = d.a();
        f6984c = d.b();
        f6987f = d.c();
        f6986e = d.e();
        if (z) {
            f6985d = d.d();
            g = new ConcurrentHashMap<>();
        }
        k.set(true);
    }

    private void c() {
        if (f6985d == null) {
            f6985d = d.d();
            g = new ConcurrentHashMap<>();
        }
    }

    public ExecutorService b() {
        return f6983b;
    }

    public void b(final Runnable runnable, int i2) {
        if (runnable == null) {
            if (o.c()) {
                o.e("", "executeDefaultTask -> runnable param is not be null");
            }
        } else if (f6984c != null) {
            f6984c.execute(new b(i2) { // from class: com.bytedance.sdk.openadsdk.i.a.2
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    public static a a() {
        if (f6982a == null) {
            synchronized (a.class) {
                if (f6982a == null) {
                    f6982a = new a();
                }
            }
        }
        return f6982a;
    }

    public void a(final Runnable runnable, int i2) {
        if (runnable == null) {
            if (o.c()) {
                o.e("", "executeAIDLTask -> runnable param is not be null");
            }
        } else {
            c();
            f6985d.execute(new b(i2) { // from class: com.bytedance.sdk.openadsdk.i.a.1
                @Override // java.lang.Runnable
                public void run() {
                    runnable.run();
                }
            });
        }
    }

    public ScheduledFuture<?> a(Runnable runnable, long j2) {
        if (runnable == null) {
            if (o.c()) {
                o.e("", "delayExecuteTask->runnable param is not be null");
            }
            return null;
        }
        if (j2 <= 0) {
            f6987f.execute(runnable);
            return null;
        }
        return f6987f.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }
}
