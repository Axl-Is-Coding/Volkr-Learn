package com.sandbox.login.f.a.e;

import android.content.Context;
import com.sandbox.login.LoginService;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.messenger.Messenger;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: AccountRecordModel.java */
/* JADX INFO: loaded from: classes2.dex */
class p extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ boolean f15869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f15870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ q f15871c;

    p(q qVar, boolean z, Context context) {
        this.f15871c = qVar;
        this.f15869a = z;
        this.f15870b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(this.f15870b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f15870b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        if (this.f15869a) {
            Messenger.getDefault().sendNoMsg("token.close.back.arrow");
        } else {
            new LoginService().forceReLogin(this.f15870b);
        }
    }
}
