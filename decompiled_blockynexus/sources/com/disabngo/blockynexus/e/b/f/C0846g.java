package com.disabngo.blockynexus.e.b.f;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.f.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindPhoneViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0846g extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0848i f9757a;

    C0846g(C0848i c0848i) {
        this.f9757a = c0848i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f9757a.f9759a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9757a.f9759a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(this.f9757a.f9759a, R.string.bind_phone_code_send_success);
    }
}
