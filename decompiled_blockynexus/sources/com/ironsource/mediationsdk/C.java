package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2354i;

/* JADX INFO: compiled from: ISDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C f14631a = new C();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2354i f14632b = null;

    private C() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public void b(String str) {
        if (this.f14632b != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC2382z(this, str));
        }
    }

    public void c(String str) {
        if (this.f14632b != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC2380y(this, str));
        }
    }

    public void d(String str) {
        if (this.f14632b != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC2376w(this, str));
        }
    }

    public static C a() {
        return f14631a;
    }

    public void b(String str, com.ironsource.mediationsdk.logger.b bVar) {
        if (this.f14632b != null) {
            new Handler(Looper.getMainLooper()).post(new A(this, str, bVar));
        }
    }

    public void a(String str, com.ironsource.mediationsdk.logger.b bVar) {
        if (this.f14632b != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC2378x(this, str, bVar));
        }
    }

    public void a(String str) {
        if (this.f14632b != null) {
            new Handler(Looper.getMainLooper()).post(new B(this, str));
        }
    }
}
