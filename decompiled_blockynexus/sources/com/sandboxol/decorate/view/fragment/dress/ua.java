package com.sandboxol.decorate.view.fragment.dress;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.config.CommonMessageToken;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.decorate.entity.DressGuideInfo;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: DressViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
class ua extends OnResponseListener<DressGuideInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ va f17462a;

    ua(va vaVar) {
        this.f17462a = vaVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(DressGuideInfo dressGuideInfo) {
        MessagerClient.getIns().sendMsg0(CommonMessageToken.COMMON_CLOSE_LOADING_DIALOG);
        new com.sandboxol.decorate.view.dialog.d(this.f17462a.f17464a, dressGuideInfo.getDressShopGuideConfigMap()).show();
        this.f17462a.g = dressGuideInfo.getDressShopGuideConfigMap();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f17462a.f17464a, i);
    }
}
