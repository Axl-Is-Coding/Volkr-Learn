package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class ea implements com.sandboxol.file.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f17980b;

    ea(va vaVar, Game game) {
        this.f17980b = vaVar;
        this.f17979a = game;
    }

    @Override // com.sandboxol.file.d.c
    public /* synthetic */ void onComplete(Progress progress) {
        com.sandboxol.file.d.b.a(this, progress);
    }

    @Override // com.sandboxol.file.d.c
    public void onError(Throwable th) {
        this.f17980b.a(this.f17979a.getGameId());
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
