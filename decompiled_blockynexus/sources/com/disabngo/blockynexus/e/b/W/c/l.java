package com.disabngo.blockynexus.e.b.W.c;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.RankingOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.RankInfoResponse;

/* JADX INFO: compiled from: GdiamondRankPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends OnResponseListener<PageData<RankInfoResponse>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9559b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f9560c;

    l(n nVar, int i, OnResponseListener onResponseListener) {
        this.f9560c = nVar;
        this.f9558a = i;
        this.f9559b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9559b.onError(i, str);
        RankingOnError.showErrorTip(this.f9560c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9559b.onServerError(i);
        RankingOnError.showOnServerError(this.f9560c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<RankInfoResponse> pageData) {
        if (pageData == null) {
            AppToastUtils.showShortNegativeTipToast(this.f9560c.context, R.string.item_rank_page_list_empty);
        } else if (this.f9558a != 0) {
            this.f9559b.onSuccess(pageData);
        } else {
            this.f9560c.a((PageData<RankInfoResponse>) pageData);
            this.f9559b.onSuccess(pageData);
        }
    }
}
