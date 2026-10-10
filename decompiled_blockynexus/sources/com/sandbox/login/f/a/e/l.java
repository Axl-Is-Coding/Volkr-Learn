package com.sandbox.login.f.a.e;

import android.app.Activity;
import com.sandbox.login.R;
import com.sandbox.login.entity.UserRecord;
import com.sandbox.login.view.activity.login.y;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.router.manager.LoginManager;
import com.sandboxol.center.view.dialog.OneTextButtonDialog;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: AccountRecordItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f15861a;

    l(m mVar) {
        this.f15861a = mVar;
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void a(String str) {
        this.f15861a.f15863b.set(false);
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void b(String str) {
        this.f15861a.f15863b.set(false);
        new OneTextButtonDialog(((ListItemViewModel) this.f15861a).context).setDetailText(((ListItemViewModel) this.f15861a).context.getString(R.string.login_password_expire_tips)).setListener(new OneTextButtonDialog.OneButtonDialogListener() { // from class: com.sandbox.login.f.a.e.a
            @Override // com.sandboxol.center.view.dialog.OneTextButtonDialog.OneButtonDialogListener
            public final void onClick() {
                this.f15845a.b();
            }
        }).show();
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void onSuccess() {
        ReportDataAdapter.onEvent(((ListItemViewModel) this.f15861a).context, EventConstant.AVAILABLE_ID_LOGIN_SUC);
        m mVar = this.f15861a;
        mVar.f15862a.set(((UserRecord) ((ListItemViewModel) mVar).item).getUid());
        ReportDataAdapter.onEvent(((ListItemViewModel) this.f15861a).context, EventConstant.SWITCH_ACC_SUC);
        this.f15861a.f15863b.set(false);
        ((Activity) ((ListItemViewModel) this.f15861a).context).setResult(100);
        if (((Activity) ((ListItemViewModel) this.f15861a).context).isFinishing()) {
            return;
        }
        ((Activity) ((ListItemViewModel) this.f15861a).context).finish();
    }

    @Override // com.sandbox.login.view.activity.login.y.a
    public void a() {
        this.f15861a.f15863b.set(false);
    }

    public /* synthetic */ void b() {
        LoginManager.onClearUserPassword(((UserRecord) ((ListItemViewModel) this.f15861a).item).getUserId(), new k(this));
    }
}
