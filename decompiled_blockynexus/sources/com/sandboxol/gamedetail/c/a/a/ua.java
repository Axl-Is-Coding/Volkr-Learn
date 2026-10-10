package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.utils.SharedUtils;
import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class ua implements com.sandboxol.file.d.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f18038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f18039b;

    ua(va vaVar, Game game) {
        this.f18039b = vaVar;
        this.f18038a = game;
    }

    @Override // com.sandboxol.file.d.e
    public void error(Throwable th) {
        this.f18039b.a(this.f18038a.getGameId());
    }

    @Override // com.sandboxol.file.d.e
    public /* synthetic */ void progress(Progress progress) {
        com.sandboxol.file.d.d.a(this, progress);
    }

    @Override // com.sandboxol.file.d.e
    public void success() {
        boolean z = this.f18038a.getLatestResVersions().getGresVersion() == SharedUtils.getLong(this.f18039b.f18042b, SharedConstant.NEW_ENGINE_COMMON_GAME_VERSION);
        if (this.f18039b.i && z) {
            this.f18039b.b(this.f18038a);
        }
    }
}
