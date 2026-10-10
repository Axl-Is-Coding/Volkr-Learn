package com.sandboxol.vip.view.fragment.main;

import androidx.databinding.ObservableField;
import com.sandboxol.center.router.moduleInfo.pay.VipProductResponse;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: PrivilegeCenterModel.java */
/* JADX INFO: loaded from: classes4.dex */
class o extends OnResponseListener<VipProductResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f19102a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ p f19103b;

    o(p pVar, ObservableField observableField) {
        this.f19103b = pVar;
        this.f19102a = observableField;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VipProductResponse vipProductResponse) {
        VipDataManager.getInstance().setVipProductResponse(vipProductResponse);
        ObservableField observableField = this.f19102a;
        if (observableField != null) {
            observableField.set(true);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
