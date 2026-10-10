package com.sandbox.login.view.activity.login;

import android.app.Activity;
import android.content.Context;
import com.sandbox.login.LoginService;
import com.sandbox.login.R;
import com.sandbox.login.view.dialog.ReloginTipDialog;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.dao.OnDaoResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: LoginModel.java */
/* JADX INFO: loaded from: classes2.dex */
class t extends OnDaoResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f15952a;

    t(u uVar) {
        this.f15952a = uVar;
    }

    static /* synthetic */ void a(Context context) {
        new LoginService().forceReLogin(context);
        ((Activity) context).finish();
    }

    @Override // com.sandboxol.common.base.dao.OnDaoResponseListener
    public void onError(int i, String str) {
        ((Activity) this.f15952a.f15954b).finish();
    }

    @Override // com.sandboxol.common.base.dao.OnDaoResponseListener
    public void onSuccess(Object obj) {
        u uVar = this.f15952a;
        if (!uVar.f15953a) {
            new LoginService().forceReLogin(this.f15952a.f15954b);
            ((Activity) this.f15952a.f15954b).finish();
            return;
        }
        Context context = uVar.f15954b;
        String string = context.getString(R.string.login_reset_password_success);
        final Context context2 = this.f15952a.f15954b;
        new ReloginTipDialog(context, string, new ReloginTipDialog.IClickRelogin() { // from class: com.sandbox.login.view.activity.login.a
            @Override // com.sandbox.login.view.dialog.ReloginTipDialog.IClickRelogin
            public final void onClickRelogin() {
                t.a(context2);
            }
        }).show();
        ReportDataAdapter.onEvent(this.f15952a.f15954b, EventConstant.TOKEN_INVALID_PASSWORD);
    }
}
