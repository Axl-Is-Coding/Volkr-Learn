package com.sandbox.login.f.a.d;

import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: MakeRoleViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class A extends OnResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f15798a;

    A(E e2) {
        this.f15798a = e2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f15798a.f15806d, i);
        Messenger.getDefault().sendNoMsg("token.close.login");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15798a.f15806d, i);
        Messenger.getDefault().sendNoMsg("token.close.login");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(String str) {
        if (this.f15798a.f15808f != null) {
            this.f15798a.f15808f.setPicUrl(str);
        }
        this.f15798a.L();
    }
}
