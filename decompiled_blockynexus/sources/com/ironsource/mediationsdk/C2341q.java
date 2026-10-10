package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.DemandOnlySmash;
import java.util.Date;
import java.util.TimerTask;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DemandOnlyIsSmash.java */
/* JADX INFO: loaded from: classes2.dex */
class C2341q extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DemandOnlyIsSmash f14962a;

    C2341q(DemandOnlyIsSmash demandOnlyIsSmash) {
        this.f14962a = demandOnlyIsSmash;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.f14962a.b("load timed out state=" + this.f14962a.q());
        if (this.f14962a.a(DemandOnlySmash.SMASH_STATE.LOAD_IN_PROGRESS, DemandOnlySmash.SMASH_STATE.NOT_LOADED)) {
            this.f14962a.l.a(new com.ironsource.mediationsdk.logger.b(1052, "load timed out"), this.f14962a, new Date().getTime() - this.f14962a.m);
        }
    }
}
