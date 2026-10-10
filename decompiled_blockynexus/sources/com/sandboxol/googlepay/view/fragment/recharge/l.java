package com.sandboxol.googlepay.view.fragment.recharge;

import com.sandboxol.center.entity.ProductEntity;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: RechargeItem2ListModel.java */
/* JADX INFO: loaded from: classes3.dex */
class l extends OnResponseListener<List<ProductEntity>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f18375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ o f18376b;

    l(o oVar, OnResponseListener onResponseListener) {
        this.f18376b = oVar;
        this.f18375a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f18375a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f18375a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<ProductEntity> list) {
        this.f18376b.b(list);
        o oVar = this.f18376b;
        oVar.a(oVar.f18380b);
        this.f18375a.onSuccess(this.f18376b.f18380b);
    }
}
