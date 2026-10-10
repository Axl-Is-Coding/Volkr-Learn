package com.disabngo.blockynexus.view.fragment.more;

import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.VideoStarConfig;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: MoreViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class F extends OnResponseListener<VideoStarConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MoreViewModel f11843a;

    F(MoreViewModel moreViewModel) {
        this.f11843a = moreViewModel;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VideoStarConfig videoStarConfig) {
        if (videoStarConfig != null) {
            this.f11843a.k.set(videoStarConfig);
            AccountCenter.newInstance().setRate(videoStarConfig.getRate());
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f11843a.f11846a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11843a.f11846a, i);
    }
}
