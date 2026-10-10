package com.disabngo.blockynexus.e.b.s;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.s.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: EmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0920i extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0921j f10161a;

    C0920i(C0921j c0921j) {
        this.f10161a = c0921j;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f10161a.f10162a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10161a.f10162a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(this.f10161a.f10162a, R.string.bind_phone_unbind_success);
        AccountCenter.newInstance().email.set("");
        AccountCenter.putAccountInfo();
        ((Activity) this.f10161a.f10162a).finish();
    }
}
