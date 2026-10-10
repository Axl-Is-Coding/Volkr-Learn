package com.disabngo.blockynexus.e.b.l;

import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.c.ha;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: renamed from: com.disabngo.blockynexus.e.b.l.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CategoryGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class C0867c implements com.sandboxol.greendao.a.c<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ PageData f9892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f9893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ C0868d f9894c;

    C0867c(C0868d c0868d, PageData pageData, int i) {
        this.f9894c = c0868d;
        this.f9892a = pageData;
        this.f9893b = i;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(String str) {
        for (int i = 0; i < this.f9892a.getData().size(); i++) {
            ((Game) this.f9892a.getData().get(i)).setCurrentSize(i);
            ((Game) this.f9892a.getData().get(i)).setCurrentPage(this.f9893b);
        }
        ha.newInstance().a(this.f9892a.getData());
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
