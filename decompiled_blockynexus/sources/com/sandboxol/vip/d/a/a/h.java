package com.sandboxol.vip.d.a.a;

import com.sandboxol.center.router.moduleInfo.pay.VipProductResponse;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: SubscribeBottomDialog.java */
/* JADX INFO: loaded from: classes4.dex */
class h extends OnResponseListener<VipProductResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ j f19051a;

    h(j jVar) {
        this.f19051a = jVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VipProductResponse vipProductResponse) {
        VipDataManager.getInstance().setVipProductResponse(vipProductResponse);
        j jVar = this.f19051a;
        jVar.f19056d.set(Boolean.valueOf(com.sandboxol.vip.c.a.d(jVar.f19053a)));
        j jVar2 = this.f19051a;
        jVar2.f19054b.set(com.sandboxol.vip.c.a.a(jVar2.f19056d.get().booleanValue(), this.f19051a.f19053a));
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.subscribe.bottom.list");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
