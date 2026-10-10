package com.sandbox.login.f.a.e;

import android.app.Activity;
import com.sandbox.login.entity.UserRecord;
import com.sandbox.login.view.activity.login.y;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.LoginRegisterAccountForm;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.greendao.entity.User;

/* JADX INFO: compiled from: AccountRecordItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<User> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f15859a;

    j(m mVar) {
        this.f15859a = mVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(User user) {
        this.f15859a.f15863b.set(false);
        m mVar = this.f15859a;
        mVar.f15862a.set(((UserRecord) ((ListItemViewModel) mVar).item).getUid());
        LoginRegisterAccountForm loginRegisterAccountForm = new LoginRegisterAccountForm();
        loginRegisterAccountForm.setUid(((UserRecord) ((ListItemViewModel) this.f15859a).item).getUid());
        loginRegisterAccountForm.setPassword(((UserRecord) ((ListItemViewModel) this.f15859a).item).getPassword());
        new y().a(((ListItemViewModel) this.f15859a).context, user, loginRegisterAccountForm, (y.a) null);
        ReportDataAdapter.onEvent(((ListItemViewModel) this.f15859a).context, EventConstant.SWITCH_ACC_SUC);
        ((Activity) ((ListItemViewModel) this.f15859a).context).setResult(100);
        if (((Activity) ((ListItemViewModel) this.f15859a).context).isFinishing()) {
            return;
        }
        ((Activity) ((ListItemViewModel) this.f15859a).context).finish();
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f15859a.f15863b.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f15859a.f15863b.set(false);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f15859a).context, i);
    }
}
