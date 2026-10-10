package com.disabngo.blockynexus.e.b.T;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;

/* JADX INFO: compiled from: PhoneViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f9453a;

    g(h hVar) {
        this.f9453a = hVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (i == 109) {
            AppToastUtils.showShortNegativeTipToast(this.f9453a.f9454a, R.string.bind_phone_unbind_error);
        } else if (i != 110) {
            AppToastUtils.showShortNegativeTipToast(this.f9453a.f9454a, this.f9453a.f9454a.getString(R.string.connect_error_code, Integer.valueOf(i)));
        } else {
            AppToastUtils.showShortNegativeTipToast(this.f9453a.f9454a, R.string.bind_phone_never_bind_phone);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        AppToastUtils.showShortNegativeTipToast(this.f9453a.f9454a, this.f9453a.f9454a.getString(R.string.connect_error_code, Integer.valueOf(i)));
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortNegativeTipToast(this.f9453a.f9454a, R.string.bind_phone_unbind_success);
        AccountCenter.newInstance().telephone.set("");
        AccountCenter.putAccountInfo();
        ((Activity) this.f9453a.f9454a).finish();
    }
}
