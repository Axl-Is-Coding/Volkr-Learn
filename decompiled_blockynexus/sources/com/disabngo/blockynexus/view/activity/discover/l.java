package com.disabngo.blockynexus.view.activity.discover;

import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.common.widget.rv.pagerv.TypePageData;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: DiscoverGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class l implements com.sandboxol.greendao.a.c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ TypePageData f10588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f10589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ m f10590c;

    l(m mVar, TypePageData typePageData, int i) {
        this.f10590c = mVar;
        this.f10588a = typePageData;
        this.f10589b = i;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(String str) {
        PageData pageInfo = this.f10588a.getPageInfo();
        for (int i = 0; i < pageInfo.getData().size(); i++) {
            ((Game) pageInfo.getData().get(i)).setCurrentSize(i);
            ((Game) pageInfo.getData().get(i)).setCurrentPage(this.f10589b);
            ((Game) pageInfo.getData().get(i)).setTypeId(this.f10588a.getTypeId());
        }
        this.f10590c.f10595e.a(pageInfo.getData());
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
