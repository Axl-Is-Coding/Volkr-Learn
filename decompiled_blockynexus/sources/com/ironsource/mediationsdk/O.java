package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.AbstractSmash;
import java.util.Date;
import java.util.TimerTask;

/* JADX INFO: compiled from: InterstitialSmash.java */
/* JADX INFO: loaded from: classes2.dex */
class O extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ P f14700a;

    O(P p) {
        this.f14700a = p;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        cancel();
        P p = this.f14700a;
        if (p.f14596a != AbstractSmash.MEDIATION_STATE.LOAD_PENDING || p.v == null) {
            return;
        }
        this.f14700a.a(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
        this.f14700a.v.a(com.ironsource.mediationsdk.utils.g.c("Timeout"), this.f14700a, new Date().getTime() - this.f14700a.w);
    }
}
