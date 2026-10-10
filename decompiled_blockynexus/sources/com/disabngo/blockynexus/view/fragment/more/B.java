package com.disabngo.blockynexus.view.fragment.more;

import android.content.Context;
import android.util.Log;
import com.sandboxol.center.AccountManager;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.c.P;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: MoreModel.java */
/* JADX INFO: loaded from: classes2.dex */
class B extends OnResponseListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ C f11840b;

    B(C c2, Context context) {
        this.f11840b = c2;
        this.f11839a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        user.setAccessToken(AccountCenter.newInstance().token.get());
        AccountManager.getInstance().onUpdateAcount(this.f11839a, user);
        P.newInstance().a(AccountCenter.newInstance().getMyInfo());
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Log.e("updateUserInfo", str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.e("updateUserInfo", String.valueOf(i));
    }
}
