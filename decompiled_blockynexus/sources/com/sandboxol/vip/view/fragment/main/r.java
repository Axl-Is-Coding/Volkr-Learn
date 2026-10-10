package com.sandboxol.vip.view.fragment.main;

import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: PrivilegeCenterViewModel.java */
/* JADX INFO: loaded from: classes4.dex */
class r extends OnResponseListener<VipSubInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ s f19109a;

    r(s sVar) {
        this.f19109a = sVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VipSubInfo vipSubInfo) {
        VipDataManager.getInstance().setVipSubInfo(vipSubInfo);
        this.f19109a.b(vipSubInfo);
        this.f19109a.a(vipSubInfo);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        ServerOnError.showOnServerError(this.f19109a.f19110a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f19109a.f19110a, i);
    }
}
