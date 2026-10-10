package com.disabngo.blockynexus.e.b.ra;

import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRank;
import com.sandboxol.center.entity.RankInfo;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.utils.DateUtils;

/* JADX INFO: compiled from: TribeRankPageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class j extends OnResponseListener<RankInfo<TribeRank>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ k f10137b;

    j(k kVar, OnResponseListener onResponseListener) {
        this.f10137b = kVar;
        this.f10136a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(RankInfo<TribeRank> rankInfo) {
        this.f10137b.a((RankInfo<TribeRank>) rankInfo);
        long remainTime = rankInfo.getRemainTime();
        if (remainTime != 0) {
            this.f10137b.f10140c.set(((DefaultListModel) this.f10137b).context.getString(R.string.tribe_rank_time, Long.valueOf(DateUtils.getDayTime(remainTime)), Long.valueOf(DateUtils.getHourTime(remainTime))));
        }
        this.f10136a.onSuccess(rankInfo.getPageData());
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10136a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10136a.onServerError(i);
    }
}
