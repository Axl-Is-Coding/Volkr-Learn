package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class qa implements com.sandboxol.file.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f18026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f18027b;

    qa(va vaVar, Game game) {
        this.f18027b = vaVar;
        this.f18026a = game;
    }

    @Override // com.sandboxol.file.d.c
    public /* synthetic */ void onComplete(Progress progress) {
        com.sandboxol.file.d.b.a(this, progress);
    }

    @Override // com.sandboxol.file.d.c
    public void onError(Throwable th) {
        this.f18027b.a(this.f18026a.getGameId());
    }

    @Override // com.sandboxol.file.d.c
    public /* synthetic */ void onNext(Progress progress) {
        com.sandboxol.file.d.b.b(this, progress);
    }

    @Override // com.sandboxol.file.d.c
    public /* synthetic */ void onSubscribe(Throwable th) {
        com.sandboxol.file.d.b.a(this, th);
    }
}
