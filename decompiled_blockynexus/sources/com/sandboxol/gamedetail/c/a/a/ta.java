package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.file.entity.Progress;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class ta implements com.sandboxol.file.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f18035a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f18036b;

    ta(va vaVar, Game game) {
        this.f18036b = vaVar;
        this.f18035a = game;
    }

    @Override // com.sandboxol.file.d.c
    public /* synthetic */ void onComplete(Progress progress) {
        com.sandboxol.file.d.b.a(this, progress);
    }

    @Override // com.sandboxol.file.d.c
    public void onError(Throwable th) {
        this.f18036b.a(this.f18035a.getGameId());
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
