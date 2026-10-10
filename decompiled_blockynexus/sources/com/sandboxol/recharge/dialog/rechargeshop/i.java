package com.sandboxol.recharge.dialog.rechargeshop;

import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.VideoStarConfig;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: RechargeShopDialog.java */
/* JADX INFO: loaded from: classes4.dex */
class i extends OnResponseListener<VideoStarConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f18869a;

    i(k kVar) {
        this.f18869a = kVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VideoStarConfig videoStarConfig) {
        if (videoStarConfig != null) {
            AccountCenter.newInstance().setRate(videoStarConfig.getRate());
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(((FullScreenDialog) this.f18869a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((FullScreenDialog) this.f18869a).context, i);
    }
}
