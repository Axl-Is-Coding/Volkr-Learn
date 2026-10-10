package com.sandboxol.decorate.view.fragment.dress;

import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: DressSuitPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
class na extends OnResponseListener<List<ShopRecommendDecorationInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f17446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17447b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ oa f17448c;

    na(oa oaVar, List list, OnResponseListener onResponseListener) {
        this.f17448c = oaVar;
        this.f17446a = list;
        this.f17447b = onResponseListener;
    }

    static /* synthetic */ int a(SuitDressInfo suitDressInfo, SuitDressInfo suitDressInfo2) {
        return -((int) (suitDressInfo.getSuitId() - suitDressInfo2.getSuitId()));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f17447b.onSuccess(this.f17446a);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17447b.onSuccess(this.f17446a);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<ShopRecommendDecorationInfo> list) {
        List<SuitDressInfo> listF = com.sandboxol.decorate.f.b.f(list);
        List list2 = this.f17446a;
        if (list2 == null) {
            ArrayList arrayList = new ArrayList();
            if (listF != null && listF.size() > 0) {
                arrayList.addAll(listF);
            }
            com.sandboxol.decorate.manager.j.c().a(arrayList);
            this.f17447b.onSuccess(arrayList);
            return;
        }
        Collections.sort(list2, new Comparator() { // from class: com.sandboxol.decorate.view.fragment.dress.q
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return na.a((SuitDressInfo) obj, (SuitDressInfo) obj2);
            }
        });
        com.sandboxol.decorate.f.b.b(this.f17446a);
        com.sandboxol.decorate.f.b.d(this.f17446a);
        if (listF != null && listF.size() > 0) {
            this.f17446a.addAll(listF);
        }
        com.sandboxol.decorate.manager.j.c().a(this.f17446a);
        this.f17447b.onSuccess(this.f17446a);
    }
}
