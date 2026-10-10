package com.sandboxol.googlepay.view.fragment.recharge;

import android.content.Context;
import androidx.databinding.ObservableField;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.ReportDataAdapter;

/* JADX INFO: compiled from: RechargeModel.java */
/* JADX INFO: loaded from: classes3.dex */
class s extends OnResponseListener<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ObservableField f18385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ t f18387c;

    s(t tVar, ObservableField observableField, Context context) {
        this.f18387c = tVar;
        this.f18385a = observableField;
        this.f18386b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Boolean bool) {
        this.f18385a.set(bool);
        if (bool.booleanValue()) {
            ReportDataAdapter.onEvent(this.f18386b, EventConstant.THIRDPAY_ENTERTIME);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f18385a.set(false);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f18385a.set(false);
    }
}
