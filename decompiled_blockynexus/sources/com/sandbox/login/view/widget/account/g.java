package com.sandbox.login.view.widget.account;

import android.content.Context;
import com.sandbox.login.R;
import com.sandboxol.common.base.viewmodel.ViewModel;

/* JADX INFO: compiled from: AccountSelectViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f16008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f16009b = new d();

    public g(Context context) {
        this.f16008a = new e(context, R.string.login_account_no_data);
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        super.onDestroy();
    }
}
