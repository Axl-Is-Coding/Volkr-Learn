package com.disabngo.blockynexus.view.fragment.tribeno;

import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.sandboxol.common.base.model.DefaultListModel;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.web.error.ServerOnError;
import java.util.List;

/* JADX INFO: compiled from: TribeNoListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener<List<TribeRecommendation>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f12040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ l f12041b;

    k(l lVar, OnResponseListener onResponseListener) {
        this.f12041b = lVar;
        this.f12040a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f12040a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        ServerOnError.showOnServerError(((DefaultListModel) this.f12041b).context, i);
        this.f12040a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<TribeRecommendation> list) {
        TribeRecommendation tribeRecommendation = new TribeRecommendation();
        tribeRecommendation.setFirst(true);
        list.add(0, tribeRecommendation);
        this.f12040a.onSuccess(list);
    }
}
