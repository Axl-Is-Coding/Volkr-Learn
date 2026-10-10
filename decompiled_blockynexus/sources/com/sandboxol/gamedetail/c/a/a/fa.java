package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class fa implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17983a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f17984b;

    fa(va vaVar, Game game) {
        this.f17984b = vaVar;
        this.f17983a = game;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f17984b.a(this.f17983a.getGameId());
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        this.f17984b.i = this.f17983a.getLatestResVersions().getCresVersion() == EngineEnv.loadCommonResVersion(this.f17984b.f18042b, this.f17983a.getIsNewEngine(), this.f17983a.getIsUgc());
        if (this.f17984b.i && this.f17984b.k) {
            this.f17984b.b(this.f17983a);
        }
    }
}
