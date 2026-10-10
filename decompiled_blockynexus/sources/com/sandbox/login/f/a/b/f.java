package com.sandbox.login.f.a.b;

import com.sandbox.login.R;
import com.sandbox.login.view.activity.login.y;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: ChangePasswordViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f15776a;

    f(h hVar) {
        this.f15776a = hVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 108) {
            AppToastUtils.showShortNegativeTipToast(this.f15776a.f15778a, R.string.login_change_password_wrong);
        } else {
            ServerOnError.showOnServerError(this.f15776a.f15778a, i);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15776a.f15778a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        ReportDataAdapter.onEvent(this.f15776a.f15778a, EventConstant.MORE_CHPASS_SUC);
        new y().a(this.f15776a.f15778a, AccountCenter.newInstance().userId.get().longValue(), true);
    }
}
