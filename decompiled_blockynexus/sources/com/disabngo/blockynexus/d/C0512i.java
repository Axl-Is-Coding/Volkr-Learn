package com.disabngo.blockynexus.d;

import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.greendao.c.U;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: com.disabngo.blockynexus.d.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiskManageUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class C0512i implements com.sandboxol.greendao.a.c<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GameDiskCacheInfo f7229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f7230b;

    C0512i(GameDiskCacheInfo gameDiskCacheInfo, CountDownLatch countDownLatch) {
        this.f7229a = gameDiskCacheInfo;
        this.f7230b = countDownLatch;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        if (game != null) {
            game.getLatestResVersions().setGresVersion(0L);
            U.newInstance().c(game);
            DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().remove(this.f7229a.getGameId());
            DownloadInfoCenter.getInstance().getGameProgressInfoMap().remove(this.f7229a.getGameId());
        }
        this.f7230b.countDown();
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        this.f7230b.countDown();
    }
}
