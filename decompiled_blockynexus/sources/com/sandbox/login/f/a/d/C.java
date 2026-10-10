package com.sandbox.login.f.a.d;

import android.os.Build;
import com.sandbox.login.R;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: MakeRoleViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C extends OnResponseListener<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f15800a;

    C(E e2) {
        this.f15800a = e2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 7020) {
            E e2 = this.f15800a;
            e2.d(e2.f15806d.getString(R.string.login_account_error_7020));
        } else if (i == 1003) {
            E e3 = this.f15800a;
            e3.d(e3.f15806d.getString(R.string.login_account_error_1003));
        }
        this.f15800a.h = true;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        this.f15800a.h = false;
        if (Build.VERSION.SDK_INT >= 23) {
            this.f15800a.f15805c.G.setHelperTextColor(this.f15800a.f15806d.getColorStateList(R.color.login_hint_2));
        }
        this.f15800a.f15805c.G.setHelperText(this.f15800a.f15806d.getString(R.string.login_name_fine_tips));
    }
}
