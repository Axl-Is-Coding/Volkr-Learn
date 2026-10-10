package com.disabngo.blockynexus.e.b.ba;

import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: ResetPasswordViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f9664a;

    g(h hVar) {
        this.f9664a = hVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9664a.i.set(true);
        AppToastUtils.showShortNegativeTipToast(this.f9664a.f9666b, R.string.account_password_set_password_failed);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9664a.i.set(true);
        ServerOnError.showOnServerError(this.f9664a.f9666b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AccountCenter.newInstance().hasPassword.set(true);
        AccountCenter.putAccountInfo();
        AppToastUtils.showShortPositiveTipToast(this.f9664a.f9666b, R.string.account_password_set_password_success);
        LoginManager.logoutOnModifyPwd(this.f9664a.f9666b, Long.parseLong(this.f9664a.f9668d), true);
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_RESET_PASSWORD);
    }
}
