package com.disabngo.blockynexus.view.activity.main;

import android.util.Log;
import com.sandboxol.common.base.web.OnResponseListener;

/* JADX INFO: renamed from: com.disabngo.blockynexus.view.activity.main.zb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MainModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C1073zb extends OnResponseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ bc f10998a;

    C1073zb(bc bcVar) {
        this.f10998a = bcVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        Log.e("dailyLifeInfo", "failed");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        Log.e("dailyLifeInfo", "failed");
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(Object obj) {
        Log.e("dailyLifeInfo", "success");
    }
}
