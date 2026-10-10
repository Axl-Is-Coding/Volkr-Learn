package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

/* JADX INFO: compiled from: RVListenerWrapper.java */
/* JADX INFO: loaded from: classes2.dex */
public class La {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final La f14686a = new La();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ironsource.mediationsdk.sdk.U f14687b = null;

    private La() {
    }

    public synchronized void b() {
        if (this.f14687b != null) {
            new Handler(Looper.getMainLooper()).post(new Ea(this));
        }
    }

    public synchronized void c() {
        if (this.f14687b != null) {
            new Handler(Looper.getMainLooper()).post(new Ha(this));
        }
    }

    public synchronized void d() {
        if (this.f14687b != null) {
            new Handler(Looper.getMainLooper()).post(new Da(this));
        }
    }

    public synchronized void e() {
        if (this.f14687b != null) {
            new Handler(Looper.getMainLooper()).post(new Ga(this));
        }
    }

    public static synchronized La a() {
        return f14686a;
    }

    public synchronized void a(com.ironsource.mediationsdk.sdk.U u) {
        this.f14687b = u;
    }

    public synchronized void b(com.ironsource.mediationsdk.model.l lVar) {
        if (this.f14687b != null) {
            new Handler(Looper.getMainLooper()).post(new Ia(this, lVar));
        }
    }

    public synchronized void a(boolean z) {
        if (this.f14687b != null) {
            new Handler(Looper.getMainLooper()).post(new Fa(this, z));
        }
    }

    public synchronized void a(com.ironsource.mediationsdk.logger.b bVar) {
        if (this.f14687b != null) {
            new Handler(Looper.getMainLooper()).post(new Ja(this, bVar));
        }
    }

    public synchronized void a(com.ironsource.mediationsdk.model.l lVar) {
        if (this.f14687b != null) {
            new Handler(Looper.getMainLooper()).post(new Ka(this, lVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }
}
