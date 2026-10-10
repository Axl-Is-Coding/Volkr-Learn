package com.disabngo.blockynexus.e.b.W.c;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.RankingOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.RankInfoResponse;

/* JADX INFO: compiled from: GdiamondRankPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<PageData<RankInfoResponse>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f9554c;

    j(n nVar, int i, OnResponseListener onResponseListener) {
        this.f9554c = nVar;
        this.f9552a = i;
        this.f9553b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9553b.onError(i, str);
        RankingOnError.showErrorTip(this.f9554c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9553b.onServerError(i);
        RankingOnError.showOnServerError(this.f9554c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<RankInfoResponse> pageData) {
        if (pageData == null) {
            AppToastUtils.showShortNegativeTipToast(this.f9554c.context, R.string.item_rank_page_list_empty);
        } else if (this.f9552a != 0) {
            this.f9553b.onSuccess(pageData);
        } else {
            this.f9554c.a((PageData<RankInfoResponse>) pageData);
            this.f9553b.onSuccess(pageData);
        }
    }
}
