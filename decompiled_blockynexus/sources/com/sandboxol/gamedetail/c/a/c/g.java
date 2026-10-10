package com.sandboxol.gamedetail.c.a.c;

import android.content.Context;
import com.sandboxol.center.entity.CampaignRank;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.web.error.ServerOnError;

/* JADX INFO: compiled from: GameDetailRankModel.java */
/* JADX INFO: loaded from: classes3.dex */
class g extends OnResponseListener<CampaignRank> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnDataListener f18083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Context f18084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f18085c;

    g(h hVar, OnDataListener onDataListener, Context context) {
        this.f18085c = hVar;
        this.f18083a = onDataListener;
        this.f18084b = context;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(CampaignRank campaignRank) {
        this.f18083a.onSuccess(campaignRank);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(this.f18084b, i);
    }
}
