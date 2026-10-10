package com.sandbox.login.f.a.d;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandbox.login.f.a.d.v;
import com.sandboxol.center.AccountManager;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.SetPasswordForm;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: MakeRoleModel.java */
/* JADX INFO: loaded from: classes2.dex */
class u extends OnResponseListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f15837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SetPasswordForm f15838b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ v.a f15839c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ObservableField f15840d;

    u(Context context, SetPasswordForm setPasswordForm, v.a aVar, ObservableField observableField) {
        this.f15837a = context;
        this.f15838b = setPasswordForm;
        this.f15839c = aVar;
        this.f15840d = observableField;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        AccountManager.getInstance().onRegisterFinish(this.f15837a, user);
        if (this.f15838b != null) {
            LoginManager.onSaveUser(this.f15838b.getAccount() + "", this.f15838b.getPassword(), user);
        } else {
            LoginManager.onUpdateUser(user);
        }
        this.f15839c.onSuccess();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 1001) {
            UserApi.updateUserInfo(this.f15837a, new t(this));
        } else {
            UserOnError.showErrorTip(this.f15837a, i);
            this.f15840d.set(false);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15837a, i);
        ReportDataAdapter.onEvent(this.f15837a, EventConstant.BUILDWIN_CLICK_CONFIRM, "onServerError");
        this.f15840d.set(false);
    }
}
