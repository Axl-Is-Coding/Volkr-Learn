package com.sandboxol.greendao.c;

import com.sandboxol.greendao.c.C;
import com.sandboxol.greendao.entity.Game;
import com.sandboxol.greendao.entity.ResourceLatestVersionData;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: GameDetailDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
class T implements C.a<Game> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ CountDownLatch f18450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ U f18451b;

    T(U u, CountDownLatch countDownLatch) {
        this.f18451b = u;
        this.f18450a = countDownLatch;
    }

    @Override // com.sandboxol.greendao.c.C.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(Game game) {
        this.f18450a.countDown();
    }

    @Override // com.sandboxol.greendao.c.C.a
    public void onError(Throwable th) {
        this.f18450a.countDown();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.sandboxol.greendao.c.C.a
    public Game onExecute() {
        List<Game> listLoadAll = this.f18451b.getDao().loadAll();
        if (listLoadAll == null || listLoadAll.size() <= 0) {
            return null;
        }
        for (Game game : listLoadAll) {
            if (game != null) {
                game.setLatestResVersions(new ResourceLatestVersionData());
                this.f18451b.getDao().update(game);
            }
        }
        return null;
    }
}
