package com.disabngo.blockynexus.e.b.W.a;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.RankingOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.RankInfoResponse;

/* JADX INFO: compiled from: ActiveRankPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends OnResponseListener<PageData<RankInfoResponse>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f9485c;

    l(n nVar, int i, OnResponseListener onResponseListener) {
        this.f9485c = nVar;
        this.f9483a = i;
        this.f9484b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9484b.onError(i, str);
        RankingOnError.showErrorTip(this.f9485c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9484b.onServerError(i);
        RankingOnError.showOnServerError(this.f9485c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<RankInfoResponse> pageData) {
        if (pageData == null) {
            AppToastUtils.showShortNegativeTipToast(this.f9485c.context, R.string.item_rank_page_list_empty);
        } else if (this.f9483a != 0) {
            this.f9484b.onSuccess(pageData);
        } else {
            this.f9485c.a((PageData<RankInfoResponse>) pageData);
            this.f9484b.onSuccess(pageData);
        }
    }
}
