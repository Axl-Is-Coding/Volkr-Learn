package com.sandbox.login.f.a.b;

import android.app.Activity;
import com.sandbox.login.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.TemplateHelper;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: ChangePasswordViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f15777a;

    g(h hVar) {
        this.f15777a = hVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f15777a.f15778a, R.string.login_account_password_set_password_failed);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15777a.f15778a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        if (this.f15777a.f15783f.get().booleanValue()) {
            TemplateHelper.startTemplate(this.f15777a.f15778a, com.sandbox.login.f.a.a.e.class, this.f15777a.f15778a.getString(R.string.login_more_set_account));
        }
        AccountCenter.newInstance().hasPassword.set(true);
        AccountCenter.newInstance().setPassword(this.f15777a.f15781d.getPassword());
        LoginManager.onUpdatePassword(this.f15777a.f15781d.getUserId() + "", AccountCenter.newInstance().account.get(), this.f15777a.f15781d.getPassword());
        AccountCenter.putAccountInfo();
        AppToastUtils.showShortPositiveTipToast(this.f15777a.f15778a, R.string.login_account_password_set_password_success);
        SandboxReportManager.onEvent(ReportEvent.USER_SET_PASS, ReportEventType.USER_FIRST_BEHAVIOR, "android", "1");
        ((Activity) this.f15777a.f15778a).finish();
    }
}
