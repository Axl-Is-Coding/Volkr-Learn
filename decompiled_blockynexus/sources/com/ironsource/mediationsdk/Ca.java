package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.sdk.InterfaceC2355j;

/* JADX INFO: compiled from: RVDemandOnlyListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class Ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Ca f14633a = new Ca();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private InterfaceC2355j f14634b = null;

    private Ca() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public void b(String str) {
        if (this.f14634b != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC2381ya(this, str));
        }
    }

    public void c(String str) {
        if (this.f14634b != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC2379xa(this, str));
        }
    }

    public void d(String str) {
        if (this.f14634b != null) {
            new Handler(Looper.getMainLooper()).post(new Ba(this, str));
        }
    }

    public void e(String str) {
        if (this.f14634b != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC2375va(this, str));
        }
    }

    public static Ca a() {
        return f14633a;
    }

    public void b(String str, com.ironsource.mediationsdk.logger.b bVar) {
        if (this.f14634b != null) {
            new Handler(Looper.getMainLooper()).post(new za(this, str, bVar));
        }
    }

    public void a(String str, com.ironsource.mediationsdk.logger.b bVar) {
        if (this.f14634b != null) {
            new Handler(Looper.getMainLooper()).post(new RunnableC2377wa(this, str, bVar));
        }
    }

    public void a(String str) {
        if (this.f14634b != null) {
            new Handler(Looper.getMainLooper()).post(new Aa(this, str));
        }
    }
}
