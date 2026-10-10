package com.bytedance.sdk.openadsdk.core.video.a;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: DownloadingSourceManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, b> f6400a = new ConcurrentHashMap<>();

    public static void a(String str, b bVar) {
        f6400a.put(str, bVar);
    }

    public static void b(String str) {
        f6400a.remove(str);
    }

    public static b a(String str) {
        return f6400a.get(str);
    }
}
