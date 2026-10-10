package com.disabngo.blockynexus.e.b.ua;

import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeTaskPageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f10209a;

    k(m mVar) {
        this.f10209a = mVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        TribeOnError.showErrorTip(((ListItemViewModel) this.f10209a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((ListItemViewModel) this.f10209a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        this.f10209a.f10212b.set(1);
    }
}
