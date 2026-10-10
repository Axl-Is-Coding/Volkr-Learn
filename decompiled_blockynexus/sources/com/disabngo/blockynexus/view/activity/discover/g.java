package com.disabngo.blockynexus.view.activity.discover;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: DiscoverGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class g implements com.sandboxol.greendao.a.c<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f10570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ m f10572d;

    g(m mVar, int i, int i2, OnResponseListener onResponseListener) {
        this.f10572d = mVar;
        this.f10569a = i;
        this.f10570b = i2;
        this.f10571c = onResponseListener;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        this.f10572d.a(this.f10569a, this.f10570b, (List<Game>) list, (OnResponseListener<PageData<Game>>) this.f10571c);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        this.f10572d.a(this.f10569a, this.f10570b, (OnResponseListener<PageData<Game>>) this.f10571c);
    }
}
