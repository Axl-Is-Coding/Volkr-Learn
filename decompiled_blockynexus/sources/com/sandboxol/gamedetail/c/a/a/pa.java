package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class pa implements com.sandboxol.file.d.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f18023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f18024b;

    pa(va vaVar, Game game) {
        this.f18024b = vaVar;
        this.f18023a = game;
    }

    @Override // com.sandboxol.file.d.g
    public void error(Throwable th) {
        this.f18024b.a(this.f18023a.getGameId());
    }

    @Override // com.sandboxol.file.d.g
    public /* synthetic */ void success() {
        com.sandboxol.file.d.f.a(this);
    }
}
