package com.disabngo.blockynexus.view.activity.discover;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: DiscoverGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class h implements com.sandboxol.greendao.a.c<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f10574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ m f10576d;

    h(m mVar, int i, int i2, OnResponseListener onResponseListener) {
        this.f10576d = mVar;
        this.f10573a = i;
        this.f10574b = i2;
        this.f10575c = onResponseListener;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        this.f10576d.a(this.f10573a, this.f10574b, (List<Game>) list, (OnResponseListener<PageData<Game>>) this.f10575c);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        this.f10576d.a(this.f10573a, this.f10574b, (OnResponseListener<PageData<Game>>) this.f10575c);
    }
}
