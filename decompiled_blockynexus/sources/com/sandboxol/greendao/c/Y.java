package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: GameDiscoverComplexDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class Y extends B {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Y f18462b;

    Y(String str) {
        super(str);
    }

    public static synchronized Y newInstance() {
        if (f18462b == null) {
            f18462b = new Y("bm-game-discover-complex-db");
        }
        return f18462b;
    }

    public void a(int i, long j, com.sandboxol.greendao.a.c<List<Game>> cVar) {
        post(new X(this, j, i, cVar));
    }
}
