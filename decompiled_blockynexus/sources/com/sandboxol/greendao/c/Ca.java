package com.sandboxol.greendao.c;

/* JADX INFO: compiled from: VideoTopDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class Ca extends F {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Ca f18418b;

    Ca(String str) {
        super(str);
    }

    public static synchronized Ca newInstance() {
        if (f18418b == null) {
            f18418b = new Ca("bm-video-top-cache-db");
        }
        return f18418b;
    }
}
