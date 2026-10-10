package com.disabngo.blockynexus.e.b.ea;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: SecretEmailVerifyViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f9743a;

    h(k kVar) {
        this.f9743a = kVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f9743a.f9747a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9743a.f9747a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(this.f9743a.f9747a, R.string.bind_phone_code_send_success);
    }
}
