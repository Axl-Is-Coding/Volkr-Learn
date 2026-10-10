package com.disabngo.blockynexus.e.b.j;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.RechargeEntity;
import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: CashApplyViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<RechargeEntity> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f9850a;

    j(k kVar) {
        this.f9850a = kVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f9850a.f9851a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9850a.f9851a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(RechargeEntity rechargeEntity) {
        AppToastUtils.showLongPositiveTipToast(this.f9850a.f9851a, R.string.cash_apply_success);
        BillingManager.getInstance().updateUserMoney(this.f9850a.f9851a);
        ReportDataAdapter.onEvent(this.f9850a.f9851a, EventConstant.STAR_STATE_APPLYSCC, this.f9850a.f9853c + "");
    }
}
