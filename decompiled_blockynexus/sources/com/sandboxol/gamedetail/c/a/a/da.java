package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class da implements com.sandboxol.file.d.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f17977b;

    da(va vaVar, Game game) {
        this.f17977b = vaVar;
        this.f17976a = game;
    }

    @Override // com.sandboxol.file.d.g
    public void error(Throwable th) {
        this.f17977b.a(this.f17976a.getGameId());
    }

    @Override // com.sandboxol.file.d.g
    public /* synthetic */ void success() {
        com.sandboxol.file.d.f.a(this);
    }
}
