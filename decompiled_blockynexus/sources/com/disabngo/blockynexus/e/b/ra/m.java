package com.disabngo.blockynexus.e.b.ra;

import com.disabngo.blockynexus.entity.TribeRank;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: TribeRankViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends OnResponseListener<TribeRank> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f10148a;

    m(n nVar) {
        this.f10148a = nVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TribeRank tribeRank) {
        this.f10148a.f10152d.set(tribeRank);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f10148a.f10149a, i);
    }
}
