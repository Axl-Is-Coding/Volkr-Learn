package com.sandboxol.decorate.view.fragment.dress;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: DressPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
class ha extends OnResponseListener<List<ShopRecommendDecorationInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ List f17428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ia f17430c;

    ha(ia iaVar, List list, OnResponseListener onResponseListener) {
        this.f17430c = iaVar;
        this.f17428a = list;
        this.f17429b = onResponseListener;
    }

    static /* synthetic */ int a(SingleDressInfo singleDressInfo, SingleDressInfo singleDressInfo2) {
        return -((int) (singleDressInfo.getId() - singleDressInfo2.getId()));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f17429b.onSuccess(this.f17428a);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17429b.onSuccess(this.f17428a);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<ShopRecommendDecorationInfo> list) {
        List<SingleDressInfo> listE = com.sandboxol.decorate.f.b.e(list);
        List list2 = this.f17428a;
        if (list2 == null || list2.size() <= 0) {
            ArrayList arrayList = new ArrayList();
            if (listE != null && listE.size() > 0) {
                arrayList.addAll(listE);
            }
            com.sandboxol.decorate.manager.j.c().a(this.f17430c.f17432a, arrayList);
            this.f17429b.onSuccess(arrayList);
            return;
        }
        Collections.sort(this.f17428a, new Comparator() { // from class: com.sandboxol.decorate.view.fragment.dress.h
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ha.a((SingleDressInfo) obj, (SingleDressInfo) obj2);
            }
        });
        com.sandboxol.decorate.f.b.a((List<SingleDressInfo>) this.f17428a);
        com.sandboxol.decorate.f.b.c(this.f17428a);
        if (listE != null && listE.size() > 0) {
            this.f17428a.addAll(listE);
        }
        com.sandboxol.decorate.manager.j.c().a(this.f17430c.f17432a, this.f17428a);
        this.f17429b.onSuccess(this.f17428a);
    }
}
