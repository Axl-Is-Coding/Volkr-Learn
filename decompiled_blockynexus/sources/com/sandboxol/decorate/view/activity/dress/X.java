package com.sandboxol.decorate.view.activity.dress;

import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: DressShopSuitPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
class X extends OnResponseListener<List<SuitDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Y f17266b;

    X(Y y, OnResponseListener onResponseListener) {
        this.f17266b = y;
        this.f17265a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f17265a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17265a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SuitDressInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.f17266b.b(list);
        Y y = this.f17266b;
        List<SuitDressInfo> listA = y.a((List<SuitDressInfo>) list);
        Y.c(y, listA);
        com.sandboxol.decorate.manager.j.d().a(listA);
        this.f17265a.onSuccess(listA);
    }
}
