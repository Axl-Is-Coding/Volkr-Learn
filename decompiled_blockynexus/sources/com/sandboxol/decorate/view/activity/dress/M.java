package com.sandboxol.decorate.view.activity.dress;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: DressShopPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
class M extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ N f17243b;

    M(N n, OnResponseListener onResponseListener) {
        this.f17243b = n;
        this.f17242a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f17242a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17242a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        this.f17242a.onSuccess(this.f17243b.a((List<SingleDressInfo>) list));
    }
}
