package com.sandboxol.googlepay.view.fragment.recharge;

import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.VideoStarConfig;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: RechargeViewModel.java */
/* JADX INFO: loaded from: classes3.dex */
class u extends OnResponseListener<VideoStarConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ w f18388a;

    u(w wVar) {
        this.f18388a = wVar;
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
        UserOnError.showErrorTip(this.f18388a.f18390a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18388a.f18390a, i);
    }
}
