package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class ha implements com.sandboxol.file.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f17989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f17990b;

    ha(va vaVar, Game game) {
        this.f17990b = vaVar;
        this.f17989a = game;
    }

    @Override // com.sandboxol.file.d.c
    public /* synthetic */ void onComplete(Progress progress) {
        com.sandboxol.file.d.b.a(this, progress);
    }

    @Override // com.sandboxol.file.d.c
    public void onError(Throwable th) {
        this.f17990b.a(this.f17989a.getGameId());
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
