package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.Game;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: GameDetailDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class U extends B {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static U f18452b;

    private U(String str) {
        super(str);
    }

    public static synchronized U newInstance() {
        if (f18452b == null) {
            f18452b = new U("bm-game-detail-db");
        }
        return f18452b;
    }

    public void b(String str, com.sandboxol.greendao.a.c<Game> cVar) {
        postSync(new Q(this, str, cVar));
    }

    public void c(com.sandboxol.greendao.a.c<List<Game>> cVar) {
        postSync(new S(this, cVar));
    }

    public void b() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        postSync(new T(this, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void c(Game game) {
        getDao().insertOrReplace(game);
    }
}
