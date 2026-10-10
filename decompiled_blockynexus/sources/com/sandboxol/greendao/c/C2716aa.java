package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: renamed from: com.sandboxol.greendao.c.aa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: GameDiscoverNewDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2716aa extends B {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static C2716aa f18469b;

    C2716aa(String str) {
        super(str);
    }

    public static synchronized C2716aa newInstance() {
        if (f18469b == null) {
            f18469b = new C2716aa("bm-game-discover-new-db");
        }
        return f18469b;
    }

    public void a(int i, long j, com.sandboxol.greendao.a.c<List<Game>> cVar) {
        post(new Z(this, j, i, cVar));
    }
}
