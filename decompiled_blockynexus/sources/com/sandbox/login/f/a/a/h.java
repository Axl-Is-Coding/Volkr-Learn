package com.sandbox.login.f.a.a;

import android.os.Build;
import android.util.Log;
import com.sandbox.login.R;
import com.sandboxol.center.view.dialog.TwoTextButtonDialog;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: SetAccountViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f15765a;

    h(i iVar) {
        this.f15765a = iVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        if (bool.booleanValue()) {
            new TwoTextButtonDialog(this.f15765a.f15766a).setDetailText(this.f15765a.f15766a.getString(R.string.login_set_account_confirm, this.f15765a.f15767b)).setListener(new TwoTextButtonDialog.OnTwoButtonDialogClickListener() { // from class: com.sandbox.login.f.a.a.a
                @Override // com.sandboxol.center.view.dialog.TwoTextButtonDialog.OnTwoButtonDialogClickListener
                public final void onClick() {
                    this.f15758a.a();
                }
            }).show();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15765a.f15771f.f15607a.setHelperTextColor(this.f15765a.f15766a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15765a.f15771f.f15607a.setHelperText(this.f15765a.f15766a.getString(R.string.base_set_account_exits));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i != 1013) {
            this.f15765a.f15771f.f15607a.setHelperText("");
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15765a.f15771f.f15607a.setHelperTextColor(this.f15765a.f15766a.getColorStateList(R.color.login_tips_color_1));
        }
        this.f15765a.f15771f.f15607a.setHelperText(this.f15765a.f15766a.getString(R.string.base_set_account_error));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f15765a.f15771f.f15607a.setHelperText("");
        Log.e("error", "code :" + i);
    }

    public /* synthetic */ void a() {
        g.a(this.f15765a.f15766a, this.f15765a.f15767b, this.f15765a.f15768c);
    }
}
