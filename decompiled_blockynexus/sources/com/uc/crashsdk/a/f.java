package com.uc.crashsdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile HandlerThread f20499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile HandlerThread f20500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile HandlerThread f20501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Handler f20502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Handler f20503f;
    private static Handler g;
    private static Handler h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f20498a = !f.class.desiredAssertionStatus();
    private static final HashMap<Object, Object[]> i = new HashMap<>();

    public static Handler a(int i2) {
        if (i2 == 0) {
            if (f20499b == null) {
                a();
            }
            return f20502e;
        }
        if (i2 == 1) {
            if (f20500c == null) {
                b();
            }
            return f20503f;
        }
        if (i2 == 2) {
            if (g == null) {
                g = new Handler(Looper.getMainLooper());
            }
            return g;
        }
        if (i2 == 3) {
            if (h == null) {
                c();
            }
            return h;
        }
        throw new RuntimeException("unknown thread type: " + i2);
    }

    public static boolean b(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return false;
        }
        synchronized (i) {
            objArr = i.get(runnable);
        }
        return objArr != null;
    }

    private static synchronized void c() {
        if (f20501d == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKAnrHandler", 0);
            f20501d = handlerThread;
            handlerThread.start();
            h = new Handler(f20501d.getLooper());
        }
    }

    private static synchronized void b() {
        if (f20500c == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKNormalHandler", 0);
            f20500c = handlerThread;
            handlerThread.start();
            f20503f = new Handler(f20500c.getLooper());
        }
    }

    public static boolean a(int i2, Runnable runnable, long j) {
        Handler handlerA;
        if (runnable == null || (handlerA = a(i2)) == null) {
            return false;
        }
        e eVar = new e(10, new Object[]{runnable});
        synchronized (i) {
            i.put(runnable, new Object[]{eVar, Integer.valueOf(i2)});
        }
        return handlerA.postDelayed(eVar, j);
    }

    public static void a(int i2, Object[] objArr) {
        if (i2 != 10) {
            if (!f20498a) {
                throw new AssertionError();
            }
        } else {
            if (!f20498a && objArr == null) {
                throw new AssertionError();
            }
            Runnable runnable = (Runnable) objArr[0];
            synchronized (i) {
                if (i.get(runnable) != null) {
                    i.remove(runnable);
                }
            }
            runnable.run();
        }
    }

    public static boolean a(int i2, Runnable runnable) {
        return a(i2, runnable, 0L);
    }

    public static void a(Runnable runnable) {
        Object[] objArr;
        if (runnable == null) {
            return;
        }
        synchronized (i) {
            objArr = i.get(runnable);
        }
        if (objArr == null) {
            return;
        }
        int iIntValue = ((Integer) objArr[1]).intValue();
        Handler handler = null;
        if (iIntValue == 0) {
            handler = f20502e;
        } else if (iIntValue == 1) {
            handler = f20503f;
        } else if (iIntValue == 2) {
            handler = g;
        }
        if (handler != null) {
            handler.removeCallbacks((Runnable) objArr[0]);
        }
        synchronized (i) {
            if (i.get(runnable) != null) {
                i.remove(runnable);
            }
        }
    }

    private static synchronized void a() {
        if (f20499b == null) {
            HandlerThread handlerThread = new HandlerThread("CrashSDKBkgdHandler", 10);
            f20499b = handlerThread;
            handlerThread.start();
            f20502e = new Handler(f20499b.getLooper());
        }
    }
}
