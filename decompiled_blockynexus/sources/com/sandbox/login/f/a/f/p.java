package com.sandbox.login.f.a.f;

import android.content.Context;
import com.sandbox.login.R;
import com.sandbox.login.f.a.f.q;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.router.manager.SandboxReportManager;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.center.router.moduleInfo.report.ReportEventType;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: StepModel.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f15900a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SetPasswordForm f15901b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ q.b f15902c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ q f15903d;

    p(q qVar, Context context, SetPasswordForm setPasswordForm, q.b bVar) {
        this.f15903d = qVar;
        this.f15900a = context;
        this.f15901b = setPasswordForm;
        this.f15902c = bVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f15900a, R.string.login_account_password_set_password_failed);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15900a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AccountCenter.newInstance().nickName.set(this.f15900a.getString(R.string.more_fragment_visitor));
        AccountCenter.newInstance().account.set(this.f15900a.getString(R.string.base_more_user_no_account));
        AccountCenter.newInstance().login.set(true);
        AccountCenter.newInstance().hasPassword.set(true);
        AccountCenter.newInstance().renewPassword.set(this.f15901b.getPassword());
        AccountCenter.newInstance().setPassword(this.f15901b.getPassword());
        AccountCenter.putAccountInfo();
        LoginManager.onUpdatePassword(this.f15901b.getUserId() + "", this.f15901b.getAccount(), this.f15901b.getPassword());
        SharedUtils.putBoolean(this.f15900a, StringConstant.IS_SAFE_SETTING_GUIDE, true);
        SandboxReportManager.onEvent(ReportEvent.USER_SET_PASS, ReportEventType.USER_FIRST_BEHAVIOR, "android", "1");
        this.f15902c.a(this.f15901b);
    }
}
