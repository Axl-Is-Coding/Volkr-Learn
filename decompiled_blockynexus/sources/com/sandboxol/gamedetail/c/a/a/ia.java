package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class ia implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f17994b;

    ia(va vaVar, Game game) {
        this.f17994b = vaVar;
        this.f17993a = game;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f17994b.a(this.f17993a.getGameId());
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        this.f17994b.k = true;
        if (this.f17994b.i) {
            this.f17994b.b(this.f17993a);
        }
    }
}
