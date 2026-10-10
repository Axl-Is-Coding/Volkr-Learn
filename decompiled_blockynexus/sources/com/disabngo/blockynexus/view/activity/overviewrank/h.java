package com.disabngo.blockynexus.view.activity.overviewrank;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.web.error.RankingOnError;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.greendao.entity.RankHomePageInfoResponse;

/* JADX INFO: compiled from: OverViewRankListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h extends OnResponseListener<RankHomePageInfoResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f11046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f11047b;

    h(i iVar, OnResponseListener onResponseListener) {
        this.f11047b = iVar;
        this.f11046a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(RankHomePageInfoResponse rankHomePageInfoResponse) {
        if ("overall".equals(this.f11047b.f11048a)) {
            this.f11047b.f11049b.set("");
        } else {
            long remainingTime = rankHomePageInfoResponse.getRemainingTime();
            if (remainingTime > 0) {
                this.f11047b.f11049b.set(this.f11047b.context.getString(R.string.rank_update_time, Long.valueOf(DateUtils.getDayTime(remainingTime)), Long.valueOf(DateUtils.getHourTime(remainingTime))));
            }
        }
        this.f11046a.onSuccess(rankHomePageInfoResponse.getTopRankInfos());
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        RankingOnError.showErrorTip(this.f11047b.context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        RankingOnError.showOnServerError(this.f11047b.context, i);
    }
}
