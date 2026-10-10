package com.sandboxol.decorate.view.fragment.dress;

import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: DressPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
class ga extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ia f17426b;

    ga(ia iaVar, OnResponseListener onResponseListener) {
        this.f17426b = iaVar;
        this.f17425a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f17425a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17425a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        if (this.f17426b.f17432a != 0) {
            this.f17426b.a(list, this.f17425a);
            return;
        }
        Collections.sort(list, new com.sandboxol.decorate.f.a());
        com.sandboxol.decorate.f.b.a(list);
        com.sandboxol.decorate.f.b.c(list);
        com.sandboxol.decorate.manager.j.c().a(this.f17426b.f17432a, list);
        this.f17425a.onSuccess(list);
    }
}
