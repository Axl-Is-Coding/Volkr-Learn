package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Date;
import java.util.TimerTask;

/* JADX INFO: compiled from: RewardedVideoSmash.java */
/* JADX INFO: loaded from: classes2.dex */
class Oa extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Pa f14701a;

    Oa(Pa pa) {
        this.f14701a = pa;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        synchronized (this.f14701a) {
            cancel();
            if (this.f14701a.v != null) {
                String str = "Timeout for " + this.f14701a.r();
                this.f14701a.q.b(IronSourceLogger.IronSourceTag.INTERNAL, str, 0);
                this.f14701a.a(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                long time = new Date().getTime() - this.f14701a.x;
                if (this.f14701a.w.compareAndSet(true, false)) {
                    this.f14701a.a(1200, new Object[][]{new Object[]{"errorCode", 1025}, new Object[]{"duration", Long.valueOf(time)}});
                    this.f14701a.a(1212, new Object[][]{new Object[]{"errorCode", 1025}, new Object[]{"reason", str}, new Object[]{"duration", Long.valueOf(time)}});
                } else {
                    this.f14701a.a(1208, new Object[][]{new Object[]{"errorCode", 1025}, new Object[]{"duration", Long.valueOf(time)}});
                }
                this.f14701a.v.a(false, this.f14701a);
            }
        }
    }
}
