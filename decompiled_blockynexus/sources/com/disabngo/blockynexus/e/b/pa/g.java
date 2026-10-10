package com.disabngo.blockynexus.e.b.pa;

import com.disabngo.blockynexus.web.error.TribeOnError;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeMessageItemViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f10055a;

    g(i iVar) {
        this.f10055a = iVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10055a.f10059c.set(true);
        TribeOnError.showErrorTip(((ListItemViewModel) this.f10055a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10055a.f10059c.set(true);
        ServerOnError.showOnServerError(((ListItemViewModel) this.f10055a).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        this.f10055a.E();
    }
}
