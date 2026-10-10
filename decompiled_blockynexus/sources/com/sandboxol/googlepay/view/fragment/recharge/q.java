package com.sandboxol.googlepay.view.fragment.recharge;

import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.router.moduleInfo.pay.PaySignatureInfo;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: RechargeModel.java */
/* JADX INFO: loaded from: classes3.dex */
class q extends OnResponseListener<PaySignatureInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f18381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f18382b;

    q(t tVar, Context context) {
        this.f18382b = tVar;
        this.f18381a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(PaySignatureInfo paySignatureInfo) {
        this.f18382b.a(this.f18381a, BaseModuleApp.getBaseModuleApp().getThirdPartPayUrl() + "?lang=" + CommonHelper.getLanguage() + "&signature=" + paySignatureInfo.getSignature() + "&nickName=" + AccountCenter.newInstance().nickName.get() + "&vip=" + AccountCenter.newInstance().vip.get() + "&userId=" + AccountCenter.newInstance().userId.get() + "&picUrl=" + AccountCenter.newInstance().picUrl.get());
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }
}
