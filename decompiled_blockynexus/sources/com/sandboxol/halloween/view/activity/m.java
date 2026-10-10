package com.sandboxol.halloween.view.activity;

import android.content.Context;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.halloween.entity.HalloweenInfoResponse;
import com.sandboxol.halloween.view.activity.n;

/* JADX INFO: compiled from: HalloweenModel.java */
/* JADX INFO: loaded from: classes4.dex */
class m extends OnResponseListener<HalloweenInfoResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n.a f18666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18667b;

    m(n.a aVar, Context context) {
        this.f18666a = aVar;
        this.f18667b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(HalloweenInfoResponse halloweenInfoResponse) {
        n.a aVar;
        if (halloweenInfoResponse == null || (aVar = this.f18666a) == null) {
            return;
        }
        aVar.a(halloweenInfoResponse);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        com.sandboxol.halloween.web.h.a(this.f18667b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18667b, i);
    }
}
