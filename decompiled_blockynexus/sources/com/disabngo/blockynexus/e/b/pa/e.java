package com.disabngo.blockynexus.e.b.pa;

import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeMessageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f10053a;

    e(i iVar) {
        this.f10053a = iVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10053a.E();
        TribeOnError.showErrorTip(((ListItemViewModel) this.f10053a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10053a.f10059c.set(true);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f10053a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        this.f10053a.E();
    }
}
