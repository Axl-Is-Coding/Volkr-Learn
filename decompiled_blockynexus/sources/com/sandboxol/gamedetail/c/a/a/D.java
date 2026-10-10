package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.entity.AppEngineResourceUpdateResult;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: GameDetailDataLogic.java */
/* JADX INFO: loaded from: classes3.dex */
class D extends OnResponseListener<List<AppEngineResourceUpdateResult>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ E f17902b;

    D(E e2, Game game) {
        this.f17902b = e2;
        this.f17901a = game;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onSuccess(List<AppEngineResourceUpdateResult> list) {
        this.f17902b.a((List<AppEngineResourceUpdateResult>) list);
        this.f17902b.g.a(this.f17902b.i, list, this.f17901a);
    }
}
