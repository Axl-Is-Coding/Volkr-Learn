package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.TimerTask;

/* JADX INFO: compiled from: WaterfallLifeCycleHolder.java */
/* JADX INFO: loaded from: classes2.dex */
class Xa extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f14744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ya f14745b;

    Xa(Ya ya, String str) {
        this.f14745b = ya;
        this.f14744a = str;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, Ya.f14747a + " removing waterfall with id " + this.f14744a + " from memory", 1);
            this.f14745b.f14748b.remove(this.f14744a);
            com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.INTERNAL, Ya.f14747a + " waterfall size is currently " + this.f14745b.f14748b.size(), 1);
        } finally {
            cancel();
        }
    }
}
