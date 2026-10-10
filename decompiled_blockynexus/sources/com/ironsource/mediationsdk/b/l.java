package com.ironsource.mediationsdk.b;

import android.os.Handler;
import android.os.HandlerThread;

/* JADX INFO: compiled from: SuperLooper.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static l f14788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f14789b = new a(l.class.getSimpleName());

    /* JADX INFO: compiled from: SuperLooper.java */
    private class a extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Handler f14790a;

        a(String str) {
            super(str);
            setUncaughtExceptionHandler(new com.ironsource.mediationsdk.logger.g());
        }

        Handler a() {
            return this.f14790a;
        }

        void b() {
            this.f14790a = new Handler(getLooper());
        }
    }

    private l() {
        this.f14789b.start();
        this.f14789b.b();
    }

    public static synchronized l a() {
        if (f14788a == null) {
            f14788a = new l();
        }
        return f14788a;
    }

    public synchronized void a(Runnable runnable) {
        if (this.f14789b == null) {
            return;
        }
        Handler handlerA = this.f14789b.a();
        if (handlerA != null) {
            handlerA.post(runnable);
        }
    }
}
