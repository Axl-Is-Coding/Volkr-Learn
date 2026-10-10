package com.disabngo.blockynexus.e.b.M;

import com.sandboxol.center.entity.StarCodeUserIncomeInfo;
import com.sandboxol.center.entity.StarCodeUserIncomePageData;
import com.sandboxol.center.web.UserOnError;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import com.sandboxol.common.widget.rv.pagerv.PageData;

/* JADX INFO: compiled from: IncomePageListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends OnResponseListener<StarCodeUserIncomePageData<StarCodeUserIncomeInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f9350b;

    e(f fVar, OnResponseListener onResponseListener) {
        this.f9350b = fVar;
        this.f9349a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(StarCodeUserIncomePageData<StarCodeUserIncomeInfo> starCodeUserIncomePageData) {
        if (starCodeUserIncomePageData == null || starCodeUserIncomePageData.getData() == null) {
            this.f9349a.onSuccess(new PageData());
            return;
        }
        this.f9350b.f9351a.set(Double.valueOf(starCodeUserIncomePageData.getTodayProfit()));
        starCodeUserIncomePageData.getData().setData(this.f9350b.a((PageData<StarCodeUserIncomeInfo>) starCodeUserIncomePageData.getData()));
        this.f9349a.onSuccess(starCodeUserIncomePageData.getData());
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        UserOnError.showErrorTip(((DefaultListModel) this.f9350b).context, i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f9350b).context, i);
    }
}
