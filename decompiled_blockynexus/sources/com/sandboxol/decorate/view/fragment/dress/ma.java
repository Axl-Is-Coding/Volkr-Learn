package com.sandboxol.decorate.view.fragment.dress;

import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: DressSuitPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
class ma extends OnResponseListener<List<SuitDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17443a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ oa f17444b;

    ma(oa oaVar, OnResponseListener onResponseListener) {
        this.f17444b = oaVar;
        this.f17443a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f17443a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17443a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SuitDressInfo> list) {
        this.f17444b.a(list, this.f17443a);
    }
}
