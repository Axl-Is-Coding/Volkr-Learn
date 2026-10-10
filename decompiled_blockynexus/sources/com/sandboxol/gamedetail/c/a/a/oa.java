package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class oa implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f18020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f18021b;

    oa(va vaVar, Game game) {
        this.f18021b = vaVar;
        this.f18020a = game;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f18021b.a(this.f18020a.getGameId());
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        this.f18021b.b(this.f18020a);
    }
}
