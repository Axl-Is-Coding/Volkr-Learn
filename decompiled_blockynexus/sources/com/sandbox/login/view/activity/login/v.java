package com.sandbox.login.view.activity.login;

import android.content.Context;
import com.sandbox.login.R;
import com.sandbox.login.view.activity.login.y;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.router.moduleInfo.report.ReportEvent;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.HttpUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: LoginModel.java */
/* JADX INFO: loaded from: classes2.dex */
class v extends OnResponseListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f15956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LoginRegisterAccountForm f15957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ y.a f15958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ y f15959d;

    v(y yVar, Context context, LoginRegisterAccountForm loginRegisterAccountForm, y.a aVar) {
        this.f15959d = yVar;
        this.f15956a = context;
        this.f15957b = loginRegisterAccountForm;
        this.f15958c = aVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        this.f15959d.a(this.f15956a, user, this.f15957b, this.f15958c);
        ReportDataAdapter.onEvent(this.f15956a, "acc_login_suc");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 102) {
            this.f15958c.a(this.f15956a.getString(R.string.login_account_not_exist));
            ReportDataAdapter.onEvent(this.f15956a, ReportEvent.ACC_LOGIN_FAIL_ID);
            this.f15959d.b(this.f15956a);
        } else if (i == 108) {
            this.f15958c.b(this.f15956a.getString(R.string.login_change_password_wrong));
            ReportDataAdapter.onEvent(this.f15956a, ReportEvent.ACC_LOGIN_FAIL_PASSW);
            this.f15959d.b(this.f15956a);
        } else {
            if (i == 1002) {
                this.f15959d.a(this.f15956a, (User) new com.google.gson.j().a(str, User.class), this.f15957b, this.f15958c);
                return;
            }
            Context context = this.f15956a;
            AppToastUtils.showShortNegativeTipToast(context, context.getString(R.string.connect_error_code, Integer.valueOf(i)));
            ReportDataAdapter.onEvent(this.f15956a, ReportEvent.ACC_LOGIN_FAIL, str);
            this.f15958c.a();
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15956a, i);
        this.f15958c.a();
        ReportDataAdapter.onEvent(this.f15956a, ReportEvent.ACC_LOGIN_FAIL, i + HttpUtils.getHttpErrorMsg(this.f15956a, i));
    }
}
