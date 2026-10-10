package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.common.base.web.OnResponseListener;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class ca extends OnResponseListener<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ma f17973a;

    ca(ma maVar) {
        this.f17973a = maVar;
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        if (game == null) {
            if (this.f17973a.f18015b.f18043c != null) {
                this.f17973a.f18015b.f18043c.a(false);
            }
        } else {
            if (game.getLatestResVersions() != null) {
                game.getLatestResVersions().setGresVersion(0L);
            }
            this.f17973a.f18015b.c(game);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onError(int i, String str) {
        if (this.f17973a.f18015b.f18043c != null) {
            this.f17973a.f18015b.f18043c.a(false);
        }
    }

    @Override // com.sandboxol.common.base.web.OnResponseListener
    public void onServerError(int i) {
        if (this.f17973a.f18015b.f18043c != null) {
            this.f17973a.f18015b.f18043c.a(false);
        }
    }
}
