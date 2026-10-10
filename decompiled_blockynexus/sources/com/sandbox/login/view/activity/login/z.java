package com.sandbox.login.view.activity.login;

import android.app.Activity;
import android.content.Context;
import com.sandbox.login.view.activity.login.y;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: LoginViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class z extends OnResponseListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f15965a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LoginRegisterAccountForm f15966b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ D f15967c;

    z(D d2, Context context, LoginRegisterAccountForm loginRegisterAccountForm) {
        this.f15967c = d2;
        this.f15965a = context;
        this.f15966b = loginRegisterAccountForm;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        this.f15967c.g.set(false);
        new y().a(this.f15965a, user, this.f15966b, (y.a) null);
        ReportDataAdapter.onEvent(this.f15965a, "acc_login_suc");
        ReportDataAdapter.onEvent(this.f15965a, EventConstant.AVAILABLE_ID_LOGIN_SUC);
        ReportDataAdapter.onEvent(this.f15965a, EventConstant.LOGIN_GUS_SUC);
        if (this.f15965a instanceof Activity) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_SUCCESS_START_MAIN);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f15967c.g.set(false);
        UserOnError.showErrorTip(this.f15965a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f15967c.g.set(false);
        ServerOnError.showOnServerError(this.f15965a, i);
    }
}
