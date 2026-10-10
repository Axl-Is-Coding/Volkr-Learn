package com.sandboxol.gamedetail.service;

import android.content.Context;
import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.gamedetail.c.a.a.Z;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailService.java */
/* JADX INFO: loaded from: classes3.dex */
class a extends OnResponseListener<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f18112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f18113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ GameDetailService f18114c;

    a(GameDetailService gameDetailService, Context context, String str) {
        this.f18114c = gameDetailService;
        this.f18112a = context;
        this.f18113b = str;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        new Z(this.f18112a).a(this.f18113b, game);
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
    }
}
