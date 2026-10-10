package com.sandbox.login.f.a.d;

import com.sandbox.login.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: MakeRoleViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class B extends OnResponseListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f15799a;

    B(E e2) {
        this.f15799a = e2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        AccountCenter.newInstance().sex.set(Integer.valueOf(user.getSex()));
        AccountCenter.newInstance().birthday.set(user.getBirthday());
        AccountCenter.newInstance().picUrl.set(user.getPicUrl());
        AccountCenter.putAccountInfo();
        LoginManager.onUpdateUser(user);
        this.f15799a.f15806d.finish();
        Messenger.getDefault().sendNoMsg("token.close.login");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        AppToastUtils.showShortNegativeTipToast(this.f15799a.f15806d, this.f15799a.f15806d.getString(R.string.connect_error_code, new Object[]{Integer.valueOf(i)}));
        Messenger.getDefault().sendNoMsg("token.close.login");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15799a.f15806d, i);
        Messenger.getDefault().sendNoMsg("token.close.login");
    }
}
