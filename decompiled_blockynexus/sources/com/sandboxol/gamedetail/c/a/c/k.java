package com.sandboxol.gamedetail.c.a.c;

import android.content.Context;
import com.sandboxol.center.entity.CampaignRank;
import com.sandboxol.center.entity.RankInfo;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.interfaces.OnDataListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.pagerv.PageData;

/* JADX INFO: compiled from: GameDetailRankPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
class k extends OnResponseListener<RankInfo<CampaignRank>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f18087a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f18088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ l f18089c;

    k(l lVar, int i, OnResponseListener onResponseListener) {
        this.f18089c = lVar;
        this.f18087a = i;
        this.f18088b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(RankInfo<CampaignRank> rankInfo) {
        final PageData<CampaignRank> pageData = rankInfo.getPageData();
        if (this.f18087a != 0) {
            this.f18088b.onSuccess(pageData);
            return;
        }
        h hVar = new h();
        Context context = ((DefaultListModel) this.f18089c).context;
        String str = this.f18089c.f18090a;
        String str2 = this.f18089c.f18091b;
        final OnResponseListener onResponseListener = this.f18088b;
        hVar.a(context, str, str2, new OnDataListener() { // from class: com.sandboxol.gamedetail.c.a.c.b
            @Override // com.sandboxol.common.interfaces.OnDataListener
            public final void onSuccess(Object obj) {
                k.a(pageData, onResponseListener, (CampaignRank) obj);
            }
        });
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f18088b.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f18089c).context, i);
        this.f18088b.onServerError(i);
    }

    static /* synthetic */ void a(PageData pageData, OnResponseListener onResponseListener, CampaignRank campaignRank) {
        campaignRank.setFirst(true);
        pageData.getData().add(0, campaignRank);
        onResponseListener.onSuccess(pageData);
    }
}
