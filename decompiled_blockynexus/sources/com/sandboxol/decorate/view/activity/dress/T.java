package com.sandboxol.decorate.view.activity.dress;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DressShopRecommendPageListModel.java */
/* JADX INFO: loaded from: classes3.dex */
class T extends OnResponseListener<List<ShopRecommendDecorationInfo>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f17255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ U f17256b;

    T(U u, OnResponseListener onResponseListener) {
        this.f17256b = u;
        this.f17255a = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f17255a.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f17255a.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<ShopRecommendDecorationInfo> list) {
        if (list == null) {
            this.f17255a.onSuccess(new ArrayList());
            return;
        }
        for (ShopRecommendDecorationInfo shopRecommendDecorationInfo : list) {
            if (shopRecommendDecorationInfo.getShopSuitDecorationInfo() != null) {
                shopRecommendDecorationInfo.getShopSuitDecorationInfo().setDecorationInfoList(shopRecommendDecorationInfo.getShopSuitDecorationInfo().getShopDecorationInfos());
            }
        }
        com.sandboxol.decorate.manager.j.d().b(list);
        this.f17255a.onSuccess(this.f17256b.a((List<ShopRecommendDecorationInfo>) list));
    }
}
