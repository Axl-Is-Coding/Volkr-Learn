package com.disabngo.blockynexus.view.activity.discover;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: DiscoverGameModel.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements com.sandboxol.greendao.a.c<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f10577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f10578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnResponseListener f10579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ m f10580d;

    i(m mVar, int i, int i2, OnResponseListener onResponseListener) {
        this.f10580d = mVar;
        this.f10577a = i;
        this.f10578b = i2;
        this.f10579c = onResponseListener;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        this.f10580d.a(this.f10577a, this.f10578b, (List<Game>) list, (OnResponseListener<PageData<Game>>) this.f10579c);
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        this.f10580d.a(this.f10577a, this.f10578b, (OnResponseListener<PageData<Game>>) this.f10579c);
    }
}
