package com.disabngo.blockynexus.view.activity.friends;

import com.sandboxol.center.router.manager.DressManager;
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.List;

/* JADX INFO: compiled from: FriendInfoViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class L extends OnResponseListener<List<SingleDressInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ M f10652a;

    L(M m) {
        this.f10652a = m;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10652a.q.set(true);
        com.sandboxol.decorate.web.u.a(this.f10652a.f10653a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10652a.q.set(true);
        ServerOnError.showOnServerError(this.f10652a.f10653a, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<SingleDressInfo> list) {
        for (SingleDressInfo singleDressInfo : list) {
            this.f10652a.s.put(Long.valueOf(singleDressInfo.getTypeId()), singleDressInfo.getResourceId());
        }
        DressManager.handleOnesies(list, this.f10652a.s, null, false);
        this.f10652a.p();
        this.f10652a.q.set(true);
    }
}
