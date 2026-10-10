package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.AbstractSmash;
import java.util.TimerTask;

/* JADX INFO: compiled from: InterstitialSmash.java */
/* JADX INFO: loaded from: classes2.dex */
class N extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f14699a;

    N(P p) {
        this.f14699a = p;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        cancel();
        P p = this.f14699a;
        if (p.f14596a != AbstractSmash.MEDIATION_STATE.INIT_PENDING || p.v == null) {
            return;
        }
        this.f14699a.a(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
        this.f14699a.v.b(com.ironsource.mediationsdk.utils.g.a("Timeout", "Interstitial"), this.f14699a);
    }
}
