package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class ma implements com.sandboxol.greendao.a.c<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f18014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f18015b;

    ma(va vaVar, Game game) {
        this.f18015b = vaVar;
        this.f18014a = game;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        if (game == null) {
            this.f18015b.f18041a.a(this.f18014a.getGameId(), EngineEnv.getEngineVersion(this.f18014a.getIsNewEngine(), this.f18014a.getIsUgc()), new ca(this));
        } else {
            this.f18015b.c(game);
        }
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        if (this.f18015b.f18043c != null) {
            this.f18015b.f18043c.a(false);
        }
    }
}
