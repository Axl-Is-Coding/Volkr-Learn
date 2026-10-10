package com.disabngo.blockynexus.e.b.T;

import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: PhoneViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f9452a;

    f(h hVar) {
        this.f9452a = hVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        switch (i) {
            case 103:
                AppToastUtils.showShortNegativeTipToast(this.f9452a.f9454a, R.string.bind_phone_phone_has_been_bind);
                break;
            case 104:
                AppToastUtils.showShortNegativeTipToast(this.f9452a.f9454a, R.string.bind_phone_no_bind_phone);
                break;
            case 105:
                AppToastUtils.showShortNegativeTipToast(this.f9452a.f9454a, R.string.bind_phone_send_code_failed);
                break;
            case 106:
                AppToastUtils.showShortNegativeTipToast(this.f9452a.f9454a, R.string.bind_phone_user_has_bind);
                break;
            default:
                AppToastUtils.showShortNegativeTipToast(this.f9452a.f9454a, this.f9452a.f9454a.getString(R.string.connect_error_code, Integer.valueOf(i)));
                break;
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f9452a.f9454a, this.f9452a.f9454a.getString(R.string.connect_error_code, Integer.valueOf(i)));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(this.f9452a.f9454a, R.string.bind_phone_code_send_success);
    }
}
