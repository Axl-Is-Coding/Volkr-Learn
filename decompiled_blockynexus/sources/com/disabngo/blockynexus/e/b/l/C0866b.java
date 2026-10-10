package com.disabngo.blockynexus.e.b.l;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.l.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CategoryGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0866b extends OnResponseListener<PageData<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9890b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0868d f9891c;

    C0866b(C0868d c0868d, int i, OnResponseListener onResponseListener) {
        this.f9891c = c0868d;
        this.f9889a = i;
        this.f9890b = onResponseListener;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        this.f9890b.onError(i, str);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        this.f9890b.onServerError(i);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(PageData<Game> pageData) {
        if (pageData.getData() != null && pageData.getData().size() > 0) {
            this.f9891c.a((PageData<Game>) pageData, this.f9889a);
            this.f9891c.f9895a = pageData.getTotalPage();
        }
        if (this.f9891c.f9896b.containsKey(Integer.valueOf(this.f9889a)) && ((Boolean) this.f9891c.f9896b.get(Integer.valueOf(this.f9889a))).booleanValue()) {
            return;
        }
        this.f9891c.a(this.f9889a, (PageData<Game>) pageData, (OnResponseListener<PageData<Game>>) this.f9890b);
    }
}
