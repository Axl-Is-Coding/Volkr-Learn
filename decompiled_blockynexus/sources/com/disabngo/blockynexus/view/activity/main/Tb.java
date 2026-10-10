package com.disabngo.blockynexus.view.activity.main;

import android.content.Context;
import com.sandboxol.center.entity.VipSubInfo;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.utils.VipDataManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class Tb extends OnResponseListener<VipSubInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f10840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ bc f10841b;

    Tb(bc bcVar, Context context) {
        this.f10841b = bcVar;
        this.f10840a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VipSubInfo vipSubInfo) {
        VipDataManager.getInstance().setVipSubInfo(vipSubInfo);
        BillingManager.getInstance().updateUserMoney(this.f10840a);
        Messenger.getDefault().sendNoMsg("token.refresh.vip.info");
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.subscribe.bottom.list");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
