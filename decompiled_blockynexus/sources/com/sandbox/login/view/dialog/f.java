package com.sandbox.login.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sandbox.login.R;
import com.sandbox.login.c.p;
import com.sandboxol.center.config.MessageToken;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.center.listener.ISuccessListener;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.utils.CommonHelper;

/* JADX INFO: compiled from: RegisterFinishDialog.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ISuccessListener f15987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p f15989c;

    public f(Context context, ISuccessListener iSuccessListener, String str) {
        super(context);
        this.f15987a = iSuccessListener;
        this.f15988b = str;
    }

    public /* synthetic */ void a(View view) {
        ISuccessListener iSuccessListener = this.f15987a;
        if (iSuccessListener != null) {
            iSuccessListener.onSuccess();
        }
        dismiss();
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Messenger.getDefault().sendNoMsg(MessageToken.TOKEN_REGISTER_FINISH_DIALOG_CLOSE);
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog
    protected void init(final Context context) {
        super.init(context);
        this.f15989c = (p) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.login_dialog_app_register_finish, (ViewGroup) null, false);
        setContentView(this.f15989c.getRoot());
        this.f15989c.f15670d.setText(context.getResources().getString(R.string.login_account_register_finish_account, AccountCenter.newInstance().account.get()));
        this.f15989c.g.setText(context.getResources().getString(R.string.login_account_register_finish_userId, AccountCenter.newInstance().userId.get() + ""));
        if (AccountCenter.newInstance().password.get() == null || "".equals(AccountCenter.newInstance().password.get())) {
            this.f15989c.f15671e.setVisibility(8);
        } else {
            this.f15989c.f15671e.setText(context.getResources().getString(R.string.login_account_register_finish_password, AccountCenter.newInstance().password.get()));
        }
        this.f15989c.f15667a.setOnClickListener(new View.OnClickListener() { // from class: com.sandbox.login.view.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15977a.a(view);
            }
        });
        this.f15989c.f15668b.setOnClickListener(new View.OnClickListener() { // from class: com.sandbox.login.view.dialog.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f15978a.a(context, view);
            }
        });
    }

    @Override // com.sandboxol.common.dialog.FullScreenDialog, android.app.Dialog
    public void show() {
        super.show();
        p pVar = this.f15989c;
        if (pVar != null) {
            pVar.f15672f.setText(this.f15988b + "");
        }
    }

    public /* synthetic */ void a(Context context, View view) {
        ISuccessListener iSuccessListener = this.f15987a;
        if (iSuccessListener != null) {
            iSuccessListener.onSuccess();
        }
        a(context, this.f15989c);
    }

    private void a(Context context, p pVar) {
        CommonHelper.screenPic(context, AccountCenter.newInstance().account.get(), pVar.f15669c);
        AppToastUtils.showShortPositiveTipToast(context, R.string.login_account_register_finish_save_success);
        dismiss();
    }
}
