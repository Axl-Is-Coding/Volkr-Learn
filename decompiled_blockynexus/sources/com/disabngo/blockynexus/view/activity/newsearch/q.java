package com.disabngo.blockynexus.view.activity.newsearch;

import androidx.databinding.ObservableField;
import com.disabngo.blockynexus.entity.RecommendFriendEntity;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: SearchRecommendListModel.java */
/* JADX INFO: loaded from: classes2.dex */
class q extends OnResponseListener<List<RecommendFriendEntity>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f11031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f11032b;

    q(r rVar, OnResponseListener onResponseListener) {
        this.f11032b = rVar;
        this.f11031a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f11032b.i.set(true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f11032b.i.set(true);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<RecommendFriendEntity> list) {
        this.f11031a.onSuccess(list);
        this.f11032b.i.set(true);
        ObservableField<Boolean> observableField = this.f11032b.k;
        if (observableField != null) {
            observableField.set(false);
        }
        this.f11032b.a();
    }
}
