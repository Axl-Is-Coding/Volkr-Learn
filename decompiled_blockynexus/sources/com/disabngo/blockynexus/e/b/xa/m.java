package com.disabngo.blockynexus.e.b.xa;

import com.sandboxol.common.widget.rv.pagerv.PageData;
import com.sandboxol.greendao.c.F;
import com.sandboxol.greendao.entity.VideoInfo;

/* JADX INFO: compiled from: VideoRecommendPageListModel.java */
/* JADX INFO: loaded from: classes.dex */
class m implements com.sandboxol.greendao.a.c<VideoInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ F f10336a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PageData f10337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ n f10338c;

    m(n nVar, F f2, PageData pageData) {
        this.f10338c = nVar;
        this.f10336a = f2;
        this.f10337b = pageData;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(VideoInfo videoInfo) {
        this.f10336a.a(this.f10337b.getData());
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
    }
}
