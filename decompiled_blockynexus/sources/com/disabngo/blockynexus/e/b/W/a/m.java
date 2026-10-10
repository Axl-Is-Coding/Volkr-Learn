package com.disabngo.blockynexus.e.b.W.a;

import com.disabngo.blockynexus.web.error.RankingOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.RankInfoResponse;

/* JADX INFO: compiled from: ActiveRankPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends OnResponseListener<RankInfoResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f9486a;

    m(n nVar) {
        this.f9486a = nVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(RankInfoResponse rankInfoResponse) {
        this.f9486a.f9490d.set(rankInfoResponse);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        RankingOnError.showErrorTip(this.f9486a.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        RankingOnError.showOnServerError(this.f9486a.context, i);
    }
}
