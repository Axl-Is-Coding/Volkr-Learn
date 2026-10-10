package com.disabngo.blockynexus.e.b.f;

import android.app.Activity;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.BindOnError;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.entity.AccountCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.f.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BindPhoneViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0847h extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0848i f9758a;

    C0847h(C0848i c0848i) {
        this.f9758a = c0848i;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        BindOnError.showErrorTip(this.f9758a.f9759a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9758a.f9759a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(this.f9758a.f9759a, R.string.bind_phone_bind_success);
        ReportDataAdapter.onEvent(this.f9758a.f9759a, EventConstant.MORE_MOI_SUC);
        AccountCenter.newInstance().telephone.set(this.f9758a.f9760b.getPhone());
        AccountCenter.putAccountInfo();
        ((Activity) this.f9758a.f9759a).finish();
    }
}
