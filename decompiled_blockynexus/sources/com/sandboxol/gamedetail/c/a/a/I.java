package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameDetailEnterGameLogic.java */
/* JADX INFO: loaded from: classes3.dex */
class I implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ M f17915b;

    I(M m, Game game) {
        this.f17915b = m;
        this.f17914a = game;
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
        boolean z = this.f17914a.getLatestResVersions().getGresVersion() == SharedUtils.getLong(this.f17915b.f17920a, SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION);
        M m = this.f17915b;
        if (m.q && z) {
            m.c();
        }
    }
}
