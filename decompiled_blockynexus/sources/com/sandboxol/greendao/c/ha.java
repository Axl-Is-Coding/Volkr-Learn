package com.sandboxol.greendao.c;

/* JADX INFO: compiled from: GameMoreDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class ha extends B {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ha f18495b;

    private ha(String str) {
        super(str);
    }

    public static synchronized ha newInstance() {
        if (f18495b == null) {
            f18495b = new ha("bm-game-more-db");
        }
        return f18495b;
    }
}
