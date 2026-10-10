package com.sandbox.login.view.activity.login;

import android.app.Activity;
import android.content.Context;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: LoginModel.java */
/* JADX INFO: loaded from: classes2.dex */
class u extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f15953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f15954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ y f15955c;

    u(y yVar, boolean z, Context context) {
        this.f15955c = yVar;
        this.f15953a = z;
        this.f15954b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f15954b, i);
        ((Activity) this.f15954b).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15954b, i);
        ((Activity) this.f15954b).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        LoginManager.onClearUserPassword(AccountCenter.newInstance().userId.get() + "", new t(this));
    }
}
