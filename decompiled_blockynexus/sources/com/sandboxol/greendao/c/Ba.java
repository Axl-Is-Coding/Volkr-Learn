package com.sandboxol.greendao.c;

/* JADX INFO: compiled from: VideoNewDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ba extends F {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Ba f18414b;

    Ba(String str) {
        super(str);
    }

    public static synchronized Ba newInstance() {
        if (f18414b == null) {
            f18414b = new Ba("bm-video-new-cache-db");
        }
        return f18414b;
    }
}
