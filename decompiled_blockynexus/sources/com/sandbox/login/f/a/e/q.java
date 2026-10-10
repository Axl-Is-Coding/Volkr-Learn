package com.sandbox.login.f.a.e;

import android.content.Context;
import com.sandbox.login.LoginService;
import com.sandbox.login.R;
import com.sandbox.login.entity.UserRecord;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.view.dialog.OneTextButtonDialog;
import com.sandboxol.center.view.dialog.TwoTextButtonDialog;
import com.sandboxol.center.web.UserApi;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.msg.RefreshMsg;

/* JADX INFO: compiled from: AccountRecordModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {
    public void a(final Context context, final UserRecord userRecord, final boolean z) {
        if (userRecord == null) {
            return;
        }
        final boolean z2 = userRecord.getUid().equals(String.valueOf(AccountCenter.newInstance().userId.get())) || userRecord.getUid().equals(AccountCenter.newInstance().account.get());
        if (z2 && !AccountCenter.newInstance().hasPassword.get().booleanValue()) {
            new TwoTextButtonDialog(context).setDetailText(context.getString(R.string.login_has_not_password_tips)).setListener(new TwoTextButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandbox.login.f.a.e.f
                @Override // com.sandboxol.center.view.dialog.TwoTextButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    Context context2 = context;
                    new LoginService().onSetPassword(context2, context2.getString(R.string.login_account_safe_set_password));
                }
            }).show();
        } else if (userRecord.isHasPassword()) {
            new TwoTextButtonDialog(context).setDetailText(z2 ? context.getString(R.string.login_delete_self_account_tips) : context.getString(R.string.login_delete_account_tips)).setListener(new TwoTextButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandbox.login.f.a.e.e
                @Override // com.sandboxol.center.view.dialog.TwoTextButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f15850a.a(userRecord, z2, context, z);
                }
            }).show();
        } else {
            new OneTextButtonDialog(context).setDetailText(context.getString(R.string.login_pls_login_and_set_password)).show();
        }
    }

    public /* synthetic */ void a(UserRecord userRecord, boolean z, Context context, boolean z2) {
        com.sandbox.login.a.b.a().a(userRecord);
        Messenger.getDefault().send(RefreshMsg.create(), "token.refresh.record.account.list");
        if (z) {
            UserApi.logout(context, new p(this, z2, context));
        }
        Messenger.getDefault().send(userRecord.getUid(), "token.delete.account");
        AppToastUtils.showShortPositiveTipToast(context, R.string.login_delete_account_success_tips);
    }
}
