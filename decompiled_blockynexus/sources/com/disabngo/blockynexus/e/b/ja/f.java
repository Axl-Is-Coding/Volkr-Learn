package com.disabngo.blockynexus.e.b.ja;

import android.content.Context;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: ShareModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f9859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ g f9860b;

    f(g gVar, Context context) {
        this.f9860b = gVar;
        this.f9859a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f9859a, R.string.share_reward_failed);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f9859a, R.string.share_reward_failed);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(this.f9859a, R.string.share_reward_success);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        SharedUtils.putBoolean(this.f9859a, "share.success.email" + AccountCenter.newInstance().userId.get(), true);
    }
}
