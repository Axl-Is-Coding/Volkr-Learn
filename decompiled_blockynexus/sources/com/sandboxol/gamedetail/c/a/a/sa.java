package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class sa implements com.sandboxol.file.d.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f18032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f18033b;

    sa(va vaVar, Game game) {
        this.f18033b = vaVar;
        this.f18032a = game;
    }

    @Override // com.sandboxol.file.d.g
    public void error(Throwable th) {
        this.f18033b.a(this.f18032a.getGameId());
    }

    @Override // com.sandboxol.file.d.g
    public /* synthetic */ void success() {
        com.sandboxol.file.d.f.a(this);
    }
}
