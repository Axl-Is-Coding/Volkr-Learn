package com.ironsource.mediationsdk;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.qa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ProgRvManager.java */
/* JADX INFO: loaded from: classes2.dex */
class RunnableC2342qa implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgRvManager f14963a;

    RunnableC2342qa(ProgRvManager progRvManager) {
        this.f14963a = progRvManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14963a.d("makeAuction()");
        this.f14963a.p = "";
        this.f14963a.r = new Date().getTime();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (ProgRvSmash progRvSmash : this.f14963a.f14714b.values()) {
            progRvSmash.F();
            if (!this.f14963a.h.b(progRvSmash)) {
                if (progRvSmash.y()) {
                    Map<String, Object> mapZ = progRvSmash.z();
                    if (mapZ != null) {
                        map.put(progRvSmash.r(), mapZ);
                        sb.append(progRvSmash.s() + progRvSmash.r() + ",");
                    }
                } else {
                    arrayList.add(progRvSmash.r());
                    sb.append(progRvSmash.s() + progRvSmash.r() + ",");
                }
            }
        }
        if (map.keySet().size() == 0 && arrayList.size() == 0) {
            this.f14963a.a(1301, new Object[][]{new Object[]{"errorCode", 1005}, new Object[]{"duration", 0}});
            this.f14963a.d("makeAuction() failed - No candidates available for auctioning");
            this.f14963a.e();
            return;
        }
        this.f14963a.d("makeAuction() - request waterfall is: " + ((Object) sb));
        this.f14963a.b(1000);
        this.f14963a.b(1300);
        this.f14963a.c(1310, new Object[][]{new Object[]{"ext1", sb.toString()}});
        this.f14963a.m.a(com.ironsource.mediationsdk.utils.c.c().a(), map, arrayList, this.f14963a.n, this.f14963a.q);
    }
}
