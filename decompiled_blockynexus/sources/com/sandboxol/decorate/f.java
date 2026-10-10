package com.sandboxol.decorate;

import android.content.Context;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.decorate.web.u;
import java.util.List;

/* JADX INFO: compiled from: DressService.java */
/* JADX INFO: loaded from: classes3.dex */
class f extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f17152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DressService f17153c;

    f(DressService dressService, OnResponseListener onResponseListener, Context context) {
        this.f17153c = dressService;
        this.f17151a = onResponseListener;
        this.f17152b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        u.a(this.f17152b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f17152b, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        this.f17151a.onSuccess(list);
    }
}
