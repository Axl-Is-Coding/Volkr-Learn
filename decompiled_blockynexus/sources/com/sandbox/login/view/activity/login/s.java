package com.sandbox.login.view.activity.login;

import android.app.Activity;
import android.content.Context;
import com.sandbox.login.view.activity.login.y;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.router.base.OnBaseResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: LoginModel.java */
/* JADX INFO: loaded from: classes2.dex */
class s implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f15949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnBaseResponseListener f15950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ y f15951c;

    s(y yVar, Context context, OnBaseResponseListener onBaseResponseListener) {
        this.f15951c = yVar;
        this.f15949a = context;
        this.f15950b = onBaseResponseListener;
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void a(String str) {
        AppToastUtils.showShortNegativeTipToast(this.f15949a, str);
        OnBaseResponseListener onBaseResponseListener = this.f15950b;
        if (onBaseResponseListener != null) {
            onBaseResponseListener.onError(-1, str);
        }
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void b(String str) {
        AppToastUtils.showShortNegativeTipToast(this.f15949a, str);
        OnBaseResponseListener onBaseResponseListener = this.f15950b;
        if (onBaseResponseListener != null) {
            onBaseResponseListener.onError(-1, str);
        }
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void onSuccess() {
        OnBaseResponseListener onBaseResponseListener = this.f15950b;
        if (onBaseResponseListener != null) {
            onBaseResponseListener.onSuccess("");
        }
        if (this.f15949a instanceof Activity) {
            Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_LOGIN_SUCCESS_START_MAIN);
        }
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void a() {
        OnBaseResponseListener onBaseResponseListener = this.f15950b;
        if (onBaseResponseListener != null) {
            onBaseResponseListener.onError(-1, "");
        }
    }
}
