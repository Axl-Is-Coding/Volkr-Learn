package com.sandbox.login;

import android.app.Activity;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.moduleInfo.pay.BroadcastType;
import com.sandboxol.center.view.dialog.TwoTextButtonDialog;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.TemplateHelper;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.messager.MessagerClient;

/* JADX INFO: compiled from: LoginService.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f15914a;

    j(k kVar) {
        this.f15914a = kVar;
    }

    public /* synthetic */ void a(Activity activity) {
        this.f15914a.f15917c.onSetPassword(activity, activity.getString(R.string.login_account_safe_set_password));
    }

    public /* synthetic */ void b(Activity activity) {
        this.f15914a.f15917c.onSetPassword(activity, activity.getString(R.string.login_account_safe_set_password));
        ReportDataAdapter.onEvent(activity, EventConstant.ENTER_CLICK_SETPASSWORD);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 12001) {
            k kVar = this.f15914a;
            if (kVar.f15916b) {
                new LoginService().switchAccount(this.f15914a.f15915a);
            } else {
                Activity activity = kVar.f15915a;
                TemplateHelper.startTemplateForResult(activity, com.sandbox.login.f.a.e.h.class, activity.getString(R.string.login_switch_account), 0);
            }
        } else {
            UserOnError.showErrorTip(this.f15914a.f15915a, i);
        }
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15914a.f15915a, i);
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
    }

    static /* synthetic */ void a(boolean z, Activity activity) {
        if (z) {
            new LoginService().switchAccount(activity);
        } else {
            TemplateHelper.startTemplateForResult(activity, com.sandbox.login.f.a.e.h.class, activity.getString(R.string.login_switch_account), 0);
        }
        ReportDataAdapter.onEvent(activity, EventConstant.ENTER_CLICK_CONTINUE);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Long l) {
        MessagerClient.getIns().sendMsg0(BroadcastType.BROADCAST_CLOSE_LOADING_DIALOG);
        if (l.longValue() > 500) {
            TwoTextButtonDialog detailText = new TwoTextButtonDialog(this.f15914a.f15915a).setDetailText(this.f15914a.f15915a.getString(R.string.login_has_not_password_tips_2));
            final Activity activity = this.f15914a.f15915a;
            detailText.setListener(new TwoTextButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandbox.login.d
                @Override // com.sandboxol.center.view.dialog.TwoTextButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f15703a.a(activity);
                }
            }).show();
            return;
        }
        TwoTextButtonDialog leftButtonText = new TwoTextButtonDialog(this.f15914a.f15915a).setDetailText(this.f15914a.f15915a.getString(R.string.login_has_not_password_tips_3)).setLeftButtonText(R.string.login_continue_change_account_tips);
        k kVar = this.f15914a;
        final boolean z = kVar.f15916b;
        final Activity activity2 = kVar.f15915a;
        TwoTextButtonDialog rightButtonText = leftButtonText.setLeftListener(new TwoTextButtonDialog.OnTwoButtonDialogLeftClickListener() { // from class: com.sandbox.login.b
            @Override // com.sandboxol.center.view.dialog.TwoTextButtonDialog.OnTwoButtonDialogLeftClickListener
            public final void onLeftClick() {
                j.a(z, activity2);
            }
        }).setRightButtonText(R.string.login_set_password_tips);
        final Activity activity3 = this.f15914a.f15915a;
        rightButtonText.setListener(new TwoTextButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandbox.login.c
            @Override // com.sandboxol.center.view.dialog.TwoTextButtonDialog.OnTwoButtonDialogClickListener
            public final void onClick() {
                this.f15599a.b(activity3);
            }
        }).show();
    }
}
