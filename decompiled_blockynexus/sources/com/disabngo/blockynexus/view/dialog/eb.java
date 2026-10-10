package com.disabngo.blockynexus.view.dialog;

import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.download.entity.GameProgressInfo;
import com.sandboxol.center.utils.GameIdRemarkUtils;

/* JADX INFO: compiled from: UploadNewGameDialog.java */
/* JADX INFO: loaded from: classes2.dex */
class eb implements io.reactivex.w<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ UploadNewGameDialog f11552a;

    eb(UploadNewGameDialog uploadNewGameDialog) {
        this.f11552a = uploadNewGameDialog;
    }

    @Override // io.reactivex.w
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Long l) {
    }

    @Override // io.reactivex.w
    public void onComplete() {
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(GameIdRemarkUtils.singleGameToHallGame(this.f11552a.k));
        if (gameProgressInfo != null) {
            gameProgressInfo.getIsAnimEnd().set(true);
        }
    }

    @Override // io.reactivex.w
    public void onError(Throwable th) {
        GameProgressInfo gameProgressInfo = DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().get(GameIdRemarkUtils.singleGameToHallGame(this.f11552a.k));
        if (gameProgressInfo != null) {
            gameProgressInfo.getIsAnimEnd().set(true);
        }
    }

    @Override // io.reactivex.w
    public void onSubscribe(io.reactivex.disposables.b bVar) {
    }
}
