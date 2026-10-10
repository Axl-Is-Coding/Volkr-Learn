package com.disabngo.blockynexus.e.b.W.b;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.RankingOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.RankInfoResponse;

/* JADX INFO: compiled from: ClanRankPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends OnResponseListener<PageData<RankInfoResponse>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f9514c;

    i(n nVar, int i, OnResponseListener onResponseListener) {
        this.f9514c = nVar;
        this.f9512a = i;
        this.f9513b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9513b.onError(i, str);
        RankingOnError.showErrorTip(this.f9514c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9513b.onServerError(i);
        RankingOnError.showOnServerError(this.f9514c.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<RankInfoResponse> pageData) {
        if (pageData == null) {
            AppToastUtils.showShortNegativeTipToast(this.f9514c.context, R.string.item_rank_page_list_empty);
        } else if (this.f9512a != 0) {
            this.f9513b.onSuccess(pageData);
        } else {
            this.f9514c.a((PageData<RankInfoResponse>) pageData);
            this.f9513b.onSuccess(pageData);
        }
    }
}
