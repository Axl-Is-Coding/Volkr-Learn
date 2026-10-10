package com.disabngo.blockynexus.view.activity.thirdproxy;

import com.sandboxol.center.router.base.OnBaseResponseListener;

/* JADX INFO: compiled from: ThirdProxyActivity.java */
/* JADX INFO: loaded from: classes2.dex */
class b extends OnBaseResponseListener<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ThirdProxyActivity f11126a;

    b(ThirdProxyActivity thirdProxyActivity) {
        this.f11126a = thirdProxyActivity;
    }

    @Override // com.sandboxol.center.router.base.OnBaseResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(String str) {
        this.f11126a.finish();
    }

    @Override // com.sandboxol.center.router.base.OnBaseResponseListener
    public void onError(int i, String str) {
    }
}
