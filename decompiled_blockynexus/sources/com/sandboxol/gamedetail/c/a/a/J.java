package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.router.moduleInfo.game.EngineEnv;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailEnterGameLogic.java */
/* JADX INFO: loaded from: classes3.dex */
class J implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ M f17917b;

    J(M m, Game game) {
        this.f17917b = m;
        this.f17916a = game;
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
        this.f17917b.q = this.f17916a.getLatestResVersions().getCresVersion() == EngineEnv.loadCommonResVersion(this.f17917b.f17920a, this.f17916a.getIsNewEngine(), this.f17916a.getIsUgc());
        if (!this.f17917b.t) {
            com.sandboxol.greendao.c.U.newInstance().a(this.f17916a);
        }
        M m = this.f17917b;
        if (m.q && m.s) {
            m.c();
        }
    }
}
