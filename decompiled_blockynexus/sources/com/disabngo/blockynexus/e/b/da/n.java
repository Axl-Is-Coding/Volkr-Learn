package com.disabngo.blockynexus.e.b.da;

import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: compiled from: ScrapMainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class n extends OnResponseListener<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f9714a;

    n(o oVar) {
        this.f9714a = oVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Integer num) {
        this.f9714a.k.set(num);
    }
}
