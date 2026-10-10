package com.disabngo.blockynexus.view.fragment.tribehas;

import android.content.Context;
import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.center.entity.TribeCenter;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeHasModel.java */
/* JADX INFO: loaded from: classes2.dex */
class P extends OnResponseListener<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f11983a;

    P(Context context) {
        this.f11983a = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(this.f11983a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f11983a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Long l) {
        TribeCenter.newInstance().tribeGolds.set(l);
    }
}
