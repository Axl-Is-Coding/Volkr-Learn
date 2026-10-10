package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class ra implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f18029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f18030b;

    ra(va vaVar, Game game) {
        this.f18030b = vaVar;
        this.f18029a = game;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f18030b.a(this.f18029a.getGameId());
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        this.f18030b.i = this.f18029a.getLatestResVersions().getCresVersion() == EngineEnv.loadCommonResVersion(this.f18030b.f18042b, this.f18029a.getIsNewEngine(), this.f18029a.getIsUgc());
        if (this.f18030b.i && this.f18030b.j) {
            this.f18030b.b(this.f18029a);
        }
    }
}
