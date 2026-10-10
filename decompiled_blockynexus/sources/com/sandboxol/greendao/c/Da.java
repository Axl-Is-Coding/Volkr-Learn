package com.sandboxol.greendao.c;

/* JADX INFO: compiled from: VideoTotalDbHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class Da extends F {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Da f18421b;

    Da(String str) {
        super(str);
    }

    public static synchronized Da newInstance() {
        if (f18421b == null) {
            f18421b = new Da("bm-video-total-cache-db");
        }
        return f18421b;
    }
}
