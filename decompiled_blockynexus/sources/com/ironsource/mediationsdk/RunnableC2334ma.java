package com.ironsource.mediationsdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.mediationsdk.ProgIsManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.ma, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgIsManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2334ma implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgIsManager f14869a;

    RunnableC2334ma(ProgIsManager progIsManager) {
        this.f14869a = progIsManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14869a.j = "";
        StringBuilder sb = new StringBuilder();
        long time = this.f14869a.q - (new Date().getTime() - this.f14869a.p);
        if (time > 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC2332la(this), time);
            return;
        }
        this.f14869a.a(2000, (Object[][]) null);
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (ProgIsSmash progIsSmash : this.f14869a.f14710d.values()) {
            if (!this.f14869a.f14708b.b(progIsSmash)) {
                if (progIsSmash.y()) {
                    Map<String, Object> mapZ = progIsSmash.z();
                    if (mapZ != null) {
                        map.put(progIsSmash.r(), mapZ);
                        sb.append(progIsSmash.s() + progIsSmash.r() + ",");
                    }
                } else {
                    arrayList.add(progIsSmash.r());
                    sb.append(progIsSmash.s() + progIsSmash.r() + ",");
                }
            }
        }
        if (map.size() == 0 && arrayList.size() == 0) {
            this.f14869a.a(2300, new Object[][]{new Object[]{"errorCode", 1005}, new Object[]{"duration", 0}});
            this.f14869a.c("makeAuction() failed - No candidates available for auctioning");
            CallbackThrottler.a().a(new com.ironsource.mediationsdk.logger.b(1005, "No candidates available for auctioning"));
            this.f14869a.a(2110, new Object[][]{new Object[]{"errorCode", 1005}});
            this.f14869a.a(ProgIsManager.MEDIATION_STATE.STATE_READY_TO_LOAD);
            return;
        }
        this.f14869a.a(2310, new Object[][]{new Object[]{"ext1", sb.toString()}});
        int iA = com.ironsource.mediationsdk.utils.m.a().a(2);
        if (this.f14869a.n != null) {
            this.f14869a.n.a(com.ironsource.mediationsdk.utils.c.c().a(), map, arrayList, this.f14869a.o, iA);
        }
    }
}
