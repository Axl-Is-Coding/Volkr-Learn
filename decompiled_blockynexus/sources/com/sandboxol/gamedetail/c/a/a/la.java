package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: compiled from: GameResDownloadManager.java */
/* JADX INFO: loaded from: classes3.dex */
class la implements io.reactivex.w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Game f18009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ va f18010b;

    la(va vaVar, Game game) {
        this.f18010b = vaVar;
        this.f18009a = game;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
    }

    @Override // io.reactivex.w
    public void onComplete() {
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(this.f18009a.getGameId());
        if (gameProgressInfo != null) {
            gameProgressInfo.getIsAnimEnd().set(true);
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(this.f18009a.getGameId());
        if (gameProgressInfo != null) {
            gameProgressInfo.getIsAnimEnd().set(true);
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
