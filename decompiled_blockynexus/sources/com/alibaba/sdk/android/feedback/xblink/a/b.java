package com.alibaba.sdk.android.feedback.xblink.a;

import android.os.Build;
import android.util.LruCache;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f3757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LruCache f3758b;

    public b() {
        int iMaxMemory = (int) (Runtime.getRuntime().maxMemory() / 10240);
        if (Build.VERSION.SDK_INT > 11) {
            this.f3758b = new c(this, iMaxMemory);
        }
    }

    public static synchronized b a() {
        if (f3757a == null) {
            f3757a = new b();
        }
        return f3757a;
    }

    public void b() {
        LruCache lruCache = this.f3758b;
        if (lruCache != null) {
            lruCache.evictAll();
        }
    }
}
