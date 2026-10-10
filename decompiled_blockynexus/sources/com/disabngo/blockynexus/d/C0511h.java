package com.disabngo.blockynexus.d;

import android.text.TextUtils;
import com.sandboxol.center.download.entity.DownloadInfoCenter;
import com.sandboxol.center.utils.CommonUtils;
import com.sandboxol.greendao.c.U;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.GameDiskCacheInfo;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: com.disabngo.blockynexus.d.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DiskManageUtils.java */
/* JADX INFO: loaded from: classes2.dex */
class C0511h implements com.sandboxol.greendao.a.c<List<Game>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ GameDiskCacheInfo f7227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f7228b;

    C0511h(GameDiskCacheInfo gameDiskCacheInfo, CountDownLatch countDownLatch) {
        this.f7227a = gameDiskCacheInfo;
        this.f7228b = countDownLatch;
    }

    @Override // com.sandboxol.greendao.a.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(List<Game> list) {
        if (list != null && list.size() > 0) {
            for (Game game : list) {
                if (game != null && !TextUtils.isEmpty(game.getGameId()) && CommonUtils.isNewEngineCommonGame(game.getGameId())) {
                    game.getLatestResVersions().setGresVersion(0L);
                    U.newInstance().c(game);
                    DownloadInfoCenter.getInstance().getTotalGameProgressInfoMap().remove(this.f7227a.getGameId());
                    DownloadInfoCenter.getInstance().getGameProgressInfoMap().remove(this.f7227a.getGameId());
                }
            }
        }
        this.f7228b.countDown();
    }

    @Override // com.sandboxol.greendao.a.c
    public void onError(int i, String str) {
        this.f7228b.countDown();
    }
}
