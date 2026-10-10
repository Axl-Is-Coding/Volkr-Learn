package com.disabngo.blockynexus.e.b.ea;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.center.entity.SecurityVerifyResponse;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: SecretEmailVerifyViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener<SecurityVerifyResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f9744a;

    i(k kVar) {
        this.f9744a = kVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(SecurityVerifyResponse securityVerifyResponse) {
        if (!securityVerifyResponse.isFlag()) {
            AppToastUtils.showShortNegativeTipToast(this.f9744a.f9747a, R.string.verify_email_fail);
        } else {
            AppToastUtils.showShortPositiveTipToast(this.f9744a.f9747a, R.string.verify_pass);
            this.f9744a.a(securityVerifyResponse);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f9744a.f9747a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9744a.f9747a, i);
    }
}
