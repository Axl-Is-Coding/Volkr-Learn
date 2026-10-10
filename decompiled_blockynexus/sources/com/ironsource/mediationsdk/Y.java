package com.ironsource.mediationsdk;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: LWSProgRvManager.java */
/* JADX INFO: loaded from: classes2.dex */
class Y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LWSProgRvManager f14746a;

    Y(LWSProgRvManager lWSProgRvManager) {
        this.f14746a = lWSProgRvManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14746a.d("makeAuction()");
        this.f14746a.j = new Date().getTime();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for (LWSProgRvSmash lWSProgRvSmash : this.f14746a.o.values()) {
            if (!this.f14746a.p.b(lWSProgRvSmash) && this.f14746a.f14680b.b(lWSProgRvSmash)) {
                if (lWSProgRvSmash.y()) {
                    Map<String, Object> mapA = lWSProgRvSmash.A();
                    if (mapA != null) {
                        map.put(lWSProgRvSmash.r(), mapA);
                        sb.append(lWSProgRvSmash.s() + lWSProgRvSmash.r() + ",");
                    }
                } else {
                    arrayList.add(lWSProgRvSmash.r());
                    sb.append(lWSProgRvSmash.s() + lWSProgRvSmash.r() + ",");
                }
            }
        }
        if (map.keySet().size() == 0 && arrayList.size() == 0) {
            this.f14746a.a(1301, new Object[][]{new Object[]{"errorCode", 1005}, new Object[]{"duration", 0}});
            this.f14746a.d("makeAuction() failed - No candidates available for auctioning");
            this.f14746a.e();
            return;
        }
        this.f14746a.d("makeAuction() - request waterfall is: " + ((Object) sb));
        this.f14746a.b(1000);
        this.f14746a.b(1300);
        this.f14746a.c(1310, new Object[][]{new Object[]{"ext1", sb.toString()}});
        this.f14746a.g.a(com.ironsource.mediationsdk.utils.c.c().a(), map, arrayList, this.f14746a.f14684f, this.f14746a.q);
    }
}
