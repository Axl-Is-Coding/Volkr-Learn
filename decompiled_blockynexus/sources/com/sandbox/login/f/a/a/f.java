package com.sandbox.login.f.a.a;

import android.app.Activity;
import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandbox.login.R;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.listener.ISuccessListener;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: SetAccountModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f15762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f15763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Context f15764c;

    f(ObservableField observableField, String str, Context context) {
        this.f15762a = observableField;
        this.f15763b = str;
        this.f15764c = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f15762a.set(false);
        if (i == 101) {
            AppToastUtils.showShortPositiveTipToast(this.f15764c, R.string.base_set_account_exits);
        } else if (i == 1013) {
            AppToastUtils.showShortPositiveTipToast(this.f15764c, R.string.base_set_account_error);
        } else {
            if (i != 1014) {
                return;
            }
            AppToastUtils.showShortPositiveTipToast(this.f15764c, R.string.base_set_account_set);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f15762a.set(false);
        ServerOnError.showOnServerError(this.f15764c, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        this.f15762a.set(false);
        AccountCenter.newInstance().account.set(this.f15763b);
        LoginManager.onUpdateAccount(AccountCenter.newInstance().userId.get() + "", this.f15763b);
        AppToastUtils.showShortPositiveTipToast(this.f15764c, R.string.base_set_account_success);
        Context context = this.f15764c;
        final Activity activity = (Activity) context;
        activity.getClass();
        LoginManager.showRegisterFinishDialog(context, new ISuccessListener() { // from class: com.sandbox.login.f.a.a.d
            @Override // com.sandboxol.center.listener.ISuccessListener
            public final void onSuccess() {
                activity.finish();
            }
        }, this.f15764c.getString(R.string.login_result_setting_success));
        ReportDataAdapter.onEvent(this.f15764c, EventConstant.PASSWORD_USERNAME_DONE);
    }
}
