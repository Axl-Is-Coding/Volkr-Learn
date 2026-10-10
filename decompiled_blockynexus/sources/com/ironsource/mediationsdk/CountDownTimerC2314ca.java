package com.ironsource.mediationsdk;

import android.os.CountDownTimer;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import java.util.Iterator;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ca, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MediationInitializer.java */
/* JADX INFO: loaded from: classes2.dex */
class CountDownTimerC2314ca extends CountDownTimer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC2316da f14805a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CountDownTimerC2314ca(RunnableC2316da runnableC2316da, long j, long j2) {
        super(j, j2);
        this.f14805a = runnableC2316da;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        if (this.f14805a.f14807a.j) {
            return;
        }
        this.f14805a.f14807a.j = true;
        Iterator it = this.f14805a.f14807a.q.iterator();
        while (it.hasNext()) {
            ((MediationInitializer.b) it.next()).a("noInternetConnection");
        }
        com.ironsource.mediationsdk.logger.c.c().b(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No internet connection", 1);
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        if (j <= 45000) {
            this.f14805a.f14807a.y = true;
            Iterator it = this.f14805a.f14807a.q.iterator();
            while (it.hasNext()) {
                ((MediationInitializer.b) it.next()).a();
            }
        }
    }
}
