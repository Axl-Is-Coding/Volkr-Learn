package com.sandbox.login.f.a.e;

import com.sandbox.login.LoginService;
import com.sandboxol.common.base.dao.OnDaoResponseListener;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;

/* JADX INFO: compiled from: AccountRecordItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnDaoResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f15860a;

    k(l lVar) {
        this.f15860a = lVar;
    }

    @Override // com.sandboxol.common.base.dao.OnDaoResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.dao.OnDaoResponseListener
    public void onSuccess(Object obj) {
        new LoginService().switchAccount(((ListItemViewModel) this.f15860a.f15861a).context);
    }
}
