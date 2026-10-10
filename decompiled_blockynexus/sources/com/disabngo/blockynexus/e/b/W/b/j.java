package com.disabngo.blockynexus.e.b.W.b;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.RankingOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.RankInfoResponse;

/* JADX INFO: compiled from: ClanRankPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<PageData<RankInfoResponse>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f9517c;

    j(n nVar, int i, OnResponseListener onResponseListener) {
        this.f9517c = nVar;
        this.f9515a = i;
        this.f9516b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9516b.onError(i, str);
        RankingOnError.showErrorTip(this.f9517c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9516b.onServerError(i);
        RankingOnError.showOnServerError(this.f9517c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<RankInfoResponse> pageData) {
        if (pageData == null) {
            AppToastUtils.showShortNegativeTipToast(this.f9517c.context, R.string.item_rank_page_list_empty);
        } else if (this.f9515a != 0) {
            this.f9516b.onSuccess(pageData);
        } else {
            this.f9517c.a((PageData<RankInfoResponse>) pageData);
            this.f9516b.onSuccess(pageData);
        }
    }
}
