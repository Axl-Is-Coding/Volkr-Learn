package com.sandbox.login;

import android.app.Activity;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.view.dialog.TwoTextButtonDialog;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.TemplateHelper;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: LoginService.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Activity f15915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f15916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LoginService f15917c;

    k(LoginService loginService, Activity activity, boolean z) {
        this.f15917c = loginService;
        this.f15915a = activity;
        this.f15916b = z;
    }

    public /* synthetic */ void a(Activity activity) {
        this.f15917c.onSetPassword(activity, activity.getString(R.string.login_account_safe_set_password));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i != 12001) {
            UserOnError.showErrorTip(this.f15915a, i);
        } else if (this.f15916b) {
            new LoginService().switchAccount(this.f15915a);
        } else {
            Activity activity = this.f15915a;
            TemplateHelper.startTemplateForResult(activity, com.sandbox.login.f.a.e.h.class, activity.getString(R.string.login_switch_account), 0);
        }
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15915a, i);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Long l) {
        if (l.longValue() <= 0) {
            com.sandbox.login.web.b.b(this.f15915a, "2", new j(this));
            return;
        }
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        TwoTextButtonDialog detailText = new TwoTextButtonDialog(this.f15915a).setDetailText(this.f15915a.getString(R.string.login_has_not_password_tips_2));
        final Activity activity = this.f15915a;
        detailText.setListener(new TwoTextButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandbox.login.e
            @Override // com.sandboxol.center.view.dialog.TwoTextButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f15741a.a(activity);
            }
        }).show();
    }
}
