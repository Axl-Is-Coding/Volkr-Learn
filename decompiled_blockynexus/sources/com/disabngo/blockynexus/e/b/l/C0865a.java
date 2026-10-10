package com.disabngo.blockynexus.e.b.l;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.l.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CategoryGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0865a implements com.sandboxol.greendao.a.c<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f9885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f9886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f9887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ C0868d f9888d;

    C0865a(C0868d c0868d, int i, int i2, OnResponseListener onResponseListener) {
        this.f9888d = c0868d;
        this.f9885a = i;
        this.f9886b = i2;
        this.f9887c = onResponseListener;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        PageData pageData = new PageData();
        pageData.setPageNo(this.f9885a);
        pageData.setPageSize(this.f9886b);
        if (list == null || list.size() <= 0) {
            this.f9888d.f9896b.put(Integer.valueOf(this.f9885a), false);
        } else {
            this.f9888d.f9896b.put(Integer.valueOf(this.f9885a), true);
            pageData.setData(list);
        }
        if (this.f9888d.f9895a <= 0) {
            pageData.setTotalPage(this.f9885a + 2);
        } else {
            pageData.setTotalPage(this.f9888d.f9895a);
        }
        this.f9888d.a(this.f9885a, (PageData<Game>) pageData, (OnResponseListener<PageData<Game>>) this.f9887c);
        this.f9888d.a(this.f9885a, this.f9886b, (OnResponseListener<PageData<Game>>) this.f9887c);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        this.f9887c.onError(i, str);
        this.f9888d.a(this.f9885a, this.f9886b, (OnResponseListener<PageData<Game>>) this.f9887c);
    }
}
