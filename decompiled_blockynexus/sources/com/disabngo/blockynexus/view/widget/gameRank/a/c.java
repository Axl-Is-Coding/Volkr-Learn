package com.disabngo.blockynexus.view.widget.gameRank.a;

import com.sandboxol.center.entity.GameRankingInfo;
import com.sandboxol.common.base.web.OnResponseListener;
import java.util.List;

/* JADX INFO: compiled from: GameSelectModel.java */
/* JADX INFO: loaded from: classes.dex */
class c extends OnResponseListener<List<GameRankingInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f12089a;

    c(OnResponseListener onResponseListener) {
        this.f12089a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        OnResponseListener onResponseListener = this.f12089a;
        if (onResponseListener != null) {
            onResponseListener.onError(i, str);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        OnResponseListener onResponseListener = this.f12089a;
        if (onResponseListener != null) {
            onResponseListener.onServerError(i);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<GameRankingInfo> list) {
        List unused = d.f12090a = list;
        OnResponseListener onResponseListener = this.f12089a;
        if (onResponseListener != null) {
            onResponseListener.onSuccess(list);
        }
    }
}
