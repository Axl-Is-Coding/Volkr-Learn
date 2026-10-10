package com.sandboxol.gamedetail.c.a.a;

import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;

/* JADX INFO: compiled from: GameDetailEnterGameLogic.java */
/* JADX INFO: loaded from: classes3.dex */
class L implements io.reactivex.w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ M f17919a;

    L(M m) {
        this.f17919a = m;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
    }

    @Override // io.reactivex.w
    public void onComplete() {
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(this.f17919a.g.getGameId());
        if (gameProgressInfo != null) {
            gameProgressInfo.getIsAnimEnd().set(true);
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(this.f17919a.g.getGameId());
        if (gameProgressInfo != null) {
            gameProgressInfo.getIsAnimEnd().set(true);
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
