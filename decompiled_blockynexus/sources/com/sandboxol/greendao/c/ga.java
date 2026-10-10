package com.sandboxol.greendao.c;

/* JADX INFO: compiled from: GameLatelyDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class ga extends B {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ga f18492b;

    private ga(String str) {
        super(str);
    }

    public static synchronized ga newInstance() {
        if (f18492b == null) {
            f18492b = new ga("bm-lately-new-all-db");
        }
        return f18492b;
    }
}
