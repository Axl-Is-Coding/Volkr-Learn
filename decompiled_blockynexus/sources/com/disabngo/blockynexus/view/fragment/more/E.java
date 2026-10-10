package com.disabngo.blockynexus.view.fragment.more;

import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: MoreViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class E extends OnResponseListener<RechargeEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ MoreViewModel f11842a;

    E(MoreViewModel moreViewModel) {
        this.f11842a = moreViewModel;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f11842a.f11846a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11842a.f11846a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(RechargeEntity rechargeEntity) {
        ReportDataAdapter.onEvent(this.f11842a.f11846a, EventConstant.STAR_CLICK_STARSINFO_CONVERT_SUC);
        BillingManager.getInstance().updateUserMoney(this.f11842a.f11846a, true);
    }
}
