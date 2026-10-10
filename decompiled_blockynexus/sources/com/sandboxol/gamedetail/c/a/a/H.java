package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailEnterGameLogic.java */
/* JADX INFO: loaded from: classes3.dex */
class H implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ M f17913b;

    H(M m, Game game) {
        this.f17913b = m;
        this.f17912a = game;
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void error(Throwable th) {
        com.sandboxol.file.d.d.a(this, th);
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        this.f17913b.q = this.f17912a.getLatestResVersions().getCresVersion() == EngineEnv.loadCommonResVersion(this.f17913b.f17920a, this.f17912a.getIsNewEngine(), this.f17912a.getIsUgc());
        M m = this.f17913b;
        if (m.q && m.r) {
            m.c();
        }
    }
}
