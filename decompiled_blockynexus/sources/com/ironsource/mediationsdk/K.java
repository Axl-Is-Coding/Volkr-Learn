package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2360o;

/* JADX INFO: compiled from: ISListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final K f14670a = new K();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2360o f14671b = null;

    private K() {
    }

    public synchronized void b(com.ironsource.mediationsdk.logger.b bVar) {
        if (this.f14671b != null) {
            new Handler(Looper.getMainLooper()).post(new I(this, bVar));
        }
    }

    public synchronized void c() {
        if (this.f14671b != null) {
            new Handler(Looper.getMainLooper()).post(new G(this));
        }
    }

    public synchronized void d() {
        if (this.f14671b != null) {
            new Handler(Looper.getMainLooper()).post(new F(this));
        }
    }

    public synchronized void e() {
        if (this.f14671b != null) {
            new Handler(Looper.getMainLooper()).post(new D(this));
        }
    }

    public synchronized void f() {
        if (this.f14671b != null) {
            new Handler(Looper.getMainLooper()).post(new H(this));
        }
    }

    public static synchronized K a() {
        return f14670a;
    }

    public synchronized void a(InterfaceC2360o interfaceC2360o) {
        this.f14671b = interfaceC2360o;
    }

    public synchronized void b() {
        if (this.f14671b != null) {
            new Handler(Looper.getMainLooper()).post(new J(this));
        }
    }

    public synchronized void a(com.ironsource.mediationsdk.logger.b bVar) {
        if (this.f14671b != null) {
            new Handler(Looper.getMainLooper()).post(new E(this, bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }
}
