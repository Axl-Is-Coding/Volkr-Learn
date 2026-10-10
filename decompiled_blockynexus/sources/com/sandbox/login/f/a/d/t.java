package com.sandbox.login.f.a.d;

import android.util.Log;
import com.sandboxol.center.AccountManager;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: MakeRoleModel.java */
/* JADX INFO: loaded from: classes2.dex */
class t extends OnResponseListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ u f15836a;

    t(u uVar) {
        this.f15836a = uVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        user.setPassword(AccountCenter.newInstance().renewPassword.get());
        AccountManager.getInstance().onRegisterFinish(this.f15836a.f15837a, user);
        this.f15836a.f15839c.onSuccess();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Log.e("updateUserInfo", "" + str);
        this.f15836a.f15840d.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.e("updateUserInfo", String.valueOf(i));
        this.f15836a.f15840d.set(false);
    }
}
