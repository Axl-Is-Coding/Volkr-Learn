package com.disabngo.blockynexus.e.b.W.a;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.RankingOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.RankInfoResponse;

/* JADX INFO: compiled from: ActiveRankPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener<PageData<RankInfoResponse>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f9482c;

    k(n nVar, int i, OnResponseListener onResponseListener) {
        this.f9482c = nVar;
        this.f9480a = i;
        this.f9481b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9481b.onError(i, str);
        RankingOnError.showErrorTip(this.f9482c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9481b.onServerError(i);
        RankingOnError.showOnServerError(this.f9482c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<RankInfoResponse> pageData) {
        if (pageData == null) {
            AppToastUtils.showShortNegativeTipToast(this.f9482c.context, R.string.item_rank_page_list_empty);
        } else if (this.f9480a != 0) {
            this.f9481b.onSuccess(pageData);
        } else {
            this.f9482c.a((PageData<RankInfoResponse>) pageData);
            this.f9481b.onSuccess(pageData);
        }
    }
}
