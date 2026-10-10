package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: renamed from: com.sandboxol.greendao.c.ca, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GameDiscoverOnlineDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2720ca extends B {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C2720ca f18478b;

    C2720ca(String str) {
        super(str);
    }

    public static synchronized C2720ca newInstance() {
        if (f18478b == null) {
            f18478b = new C2720ca("bm-game-discover-online-db");
        }
        return f18478b;
    }

    public void a(int i, long j, com.sandboxol.greendao.a.c<List<Game>> cVar) {
        post(new C2718ba(this, j, i, cVar));
    }
}
