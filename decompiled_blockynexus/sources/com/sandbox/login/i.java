package com.sandbox.login;

import android.content.Context;
import com.sandbox.login.entity.AccountRecordResult;
import com.sandbox.login.view.dialog.ReloginTipDialog;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: LoginService.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener<AccountRecordResult> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f15912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LoginService f15913b;

    i(LoginService loginService, Context context) {
        this.f15913b = loginService;
        this.f15912a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(AccountRecordResult accountRecordResult) {
        if (accountRecordResult != null) {
            final Context context = this.f15912a;
            new ReloginTipDialog(context, accountRecordResult, new ReloginTipDialog.IClickRelogin() { // from class: com.sandbox.login.a
                @Override // com.sandbox.login.view.dialog.ReloginTipDialog.IClickRelogin
                public final void onClickRelogin() {
                    this.f15591a.a(context);
                }
            }).show();
            ReportDataAdapter.onEvent(this.f15912a, EventConstant.TOKEN_INVALID_CONFLICT);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f15912a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        UserOnError.showErrorTip(this.f15912a, i);
    }

    public /* synthetic */ void a(Context context) {
        this.f15913b.forceReLogin(context);
    }
}
