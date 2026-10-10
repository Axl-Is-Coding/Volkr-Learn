package com.sandboxol.decorate.view.activity.dress;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: DressShopPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
class L extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f17239a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17240b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ N f17241c;

    L(N n, long j, OnResponseListener onResponseListener) {
        this.f17241c = n;
        this.f17239a = j;
        this.f17240b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f17240b.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17240b.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        if (list != null) {
            N n = this.f17241c;
            List<SingleDressInfo> listB = n.b(list);
            N.a(n, (List) listB, false);
            com.sandboxol.decorate.manager.j.d().a((int) this.f17239a, listB);
            this.f17240b.onSuccess(listB);
        }
    }
}
