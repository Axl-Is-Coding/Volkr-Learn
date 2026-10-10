package com.disabngo.blockynexus.view.activity.main;

import android.util.Log;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.yb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C1070yb extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bc f10992a;

    C1070yb(bc bcVar) {
        this.f10992a = bcVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Log.e("uploadDeviceId", "onError");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.e("uploadDeviceId", "onServerError");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        Log.e("uploadDeviceId", "onSuccess");
    }
}
