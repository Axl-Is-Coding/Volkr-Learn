package com.sandbox.login.f.a.b;

import android.content.Context;
import com.sandboxol.center.entity.ChangePasswordForm;
import com.sandboxol.common.base.model.IDefaultModel;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: ChangePasswordModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements IDefaultModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ChangePasswordForm f15775a;

    public e(ChangePasswordForm changePasswordForm) {
        this.f15775a = changePasswordForm;
    }

    @Override // com.sandboxol.common.base.model.IDefaultModel
    public void loadData(Context context, OnResponseListener onResponseListener) {
        com.sandbox.login.web.b.a(context, this.f15775a, onResponseListener);
    }
}
