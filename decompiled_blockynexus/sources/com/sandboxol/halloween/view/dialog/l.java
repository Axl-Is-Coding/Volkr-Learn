package com.sandboxol.halloween.view.dialog;

import com.sandboxol.center.router.manager.BillingManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.halloween.R;

/* JADX INFO: compiled from: HalloweenCurrencyDialog.java */
/* JADX INFO: loaded from: classes4.dex */
class l extends OnResponseListener<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f18693a;

    l(m mVar) {
        this.f18693a = mVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f18693a.f18696c = false;
        com.sandboxol.halloween.web.h.a(((FullScreenDialog) this.f18693a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f18693a.f18696c = false;
        ServerOnError.showOnServerError(((FullScreenDialog) this.f18693a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Integer num) {
        BillingManager.getInstance().updateUserMoney(((FullScreenDialog) this.f18693a).context);
        this.f18693a.f18696c = false;
        if (this.f18693a.f18697d != null) {
            this.f18693a.f18697d.a(num.intValue());
            AppToastUtils.showShortPositiveTipToast(((FullScreenDialog) this.f18693a).context, ((FullScreenDialog) this.f18693a).context.getString(R.string.halloween_exchange_successful_tips));
            this.f18693a.dismiss();
        }
    }
}
