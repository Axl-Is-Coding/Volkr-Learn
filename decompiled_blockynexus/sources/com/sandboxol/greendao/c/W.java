package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: GameDiscoverAppreciateDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class W extends B {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static W f18457b;

    W(String str) {
        super(str);
    }

    public static synchronized W newInstance() {
        if (f18457b == null) {
            f18457b = new W("bm-game-discover-appreciate-db");
        }
        return f18457b;
    }

    public void a(int i, long j, com.sandboxol.greendao.a.c<List<Game>> cVar) {
        post(new V(this, j, i, cVar));
    }
}
