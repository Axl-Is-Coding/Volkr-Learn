package com.disabngo.blockynexus.view.fragment.more;

import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.StarCodeUser;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: MoreViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class G extends OnResponseListener<StarCodeUser> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MoreViewModel f11844a;

    G(MoreViewModel moreViewModel) {
        this.f11844a = moreViewModel;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(StarCodeUser starCodeUser) {
        if (starCodeUser != null) {
            AccountCenter.newInstance().setStarCodeUserDisable(starCodeUser.getDisable());
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f11844a.f11846a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11844a.f11846a, i);
    }
}
