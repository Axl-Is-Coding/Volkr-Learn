package com.sandboxol.greendao.c;

import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: GameRecommendDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class ja extends B {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ja f18502b;

    private ja(String str) {
        super(str);
    }

    public static synchronized ja newInstance() {
        if (f18502b == null) {
            f18502b = new ja("bm-game-recommend-db");
        }
        return f18502b;
    }

    public void c(com.sandboxol.greendao.a.c<List<Game>> cVar) {
        post(new ia(this, cVar));
    }
}
