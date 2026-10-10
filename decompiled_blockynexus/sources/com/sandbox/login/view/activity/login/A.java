package com.sandbox.login.view.activity.login;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.sandbox.login.R;
import com.sandbox.login.view.activity.login.y;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.center.utils.Helper;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.messenger.Messenger;

/* JADX INFO: compiled from: LoginViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class A implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f15918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LoginRegisterAccountForm f15919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ D f15920c;

    A(D d2, Context context, LoginRegisterAccountForm loginRegisterAccountForm) {
        this.f15920c = d2;
        this.f15918a = context;
        this.f15919b = loginRegisterAccountForm;
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void a(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15920c.f15925b.h.setHelperTextColor(this.f15920c.f15924a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15920c.f15925b.h.setHelperText(str);
        this.f15920c.g.set(false);
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void b(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15920c.f15925b.j.setHelperTextColor(this.f15920c.f15924a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15920c.f15925b.j.setHelperText(str);
        this.f15920c.g.set(false);
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void onSuccess() {
        if (this.f15920c.f15929f) {
            ReportDataAdapter.onEvent(this.f15918a, EventConstant.AVAILABLE_ID_LOGIN_SUC);
        }
        ReportDataAdapter.onEvent(this.f15918a, "acc_login_suc", Helper.isInteger(this.f15919b.getUid()) ? "ID" : "Account");
        this.f15920c.g.set(false);
        if (this.f15918a instanceof Activity) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_SUCCESS_START_MAIN);
        }
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void a() {
        this.f15920c.g.set(false);
    }
}
