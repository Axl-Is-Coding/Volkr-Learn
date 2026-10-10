package com.disabngo.blockynexus.view.activity.discover;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.TypePageData;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: DiscoverGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class k extends OnResponseListener<TypePageData<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f10587c;

    k(m mVar, int i, OnResponseListener onResponseListener) {
        this.f10587c = mVar;
        this.f10585a = i;
        this.f10586b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(TypePageData<Game> typePageData) {
        if (typePageData != null) {
            PageData<Game> pageInfo = typePageData.getPageInfo();
            if (pageInfo != null && pageInfo.getData() != null && pageInfo.getData().size() > 0) {
                this.f10587c.a((TypePageData<Game>) typePageData, this.f10585a);
                this.f10587c.f10594d.put(Long.valueOf(this.f10587c.f10592b), Integer.valueOf(typePageData.getPageInfo().getTotalPage()));
            }
            if (this.f10587c.f10593c.containsKey(Integer.valueOf(this.f10585a)) && ((Boolean) this.f10587c.f10593c.get(Integer.valueOf(this.f10585a))).booleanValue()) {
                return;
            }
            this.f10586b.onSuccess(typePageData.getPageInfo());
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f10586b.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f10586b.onServerError(i);
    }
}
