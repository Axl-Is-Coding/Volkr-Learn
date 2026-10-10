package com.disabngo.blockynexus.e.b.e;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.e.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindEmailViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0838j extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0839k f9730a;

    C0838j(C0839k c0839k) {
        this.f9730a = c0839k;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f9730a.f9731a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9730a.f9731a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(this.f9730a.f9731a, R.string.bind_phone_bind_success);
        ReportDataAdapter.onEvent(this.f9730a.f9731a, EventConstant.MORE_EMAIL_SUC);
        AccountCenter.newInstance().email.set(this.f9730a.f9733c.getEmail());
        AccountCenter.putAccountInfo();
        ((Activity) this.f9730a.f9731a).finish();
    }
}
