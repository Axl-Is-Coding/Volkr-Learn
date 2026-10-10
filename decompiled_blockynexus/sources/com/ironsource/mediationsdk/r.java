package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.DemandOnlySmash;
import java.util.Date;
import java.util.TimerTask;

/* JADX INFO: compiled from: DemandOnlyRvSmash.java */
/* JADX INFO: loaded from: classes2.dex */
class r extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DemandOnlyRvSmash f14964a;

    r(DemandOnlyRvSmash demandOnlyRvSmash) {
        this.f14964a = demandOnlyRvSmash;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14964a.b("load timed out state=" + this.f14964a.q());
        if (this.f14964a.a(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
            this.f14964a.l.a(new com.ironsource.mediationsdk.logger.b(1055, "load timed out"), this.f14964a, new Date().getTime() - this.f14964a.m);
        }
    }
}
