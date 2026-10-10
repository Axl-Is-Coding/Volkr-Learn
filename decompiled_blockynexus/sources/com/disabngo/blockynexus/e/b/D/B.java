package com.disabngo.blockynexus.e.b.D;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.GroupOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GroupInfoModel.java */
/* JADX INFO: loaded from: classes2.dex */
class B extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C f9157a;

    B(C c2) {
        this.f9157a = c2;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        GroupOnError.showErrorTip(this.f9157a.f9158a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f9157a.f9158a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        AppToastUtils.showShortPositiveTipToast(this.f9157a.f9158a, R.string.send);
    }
}
