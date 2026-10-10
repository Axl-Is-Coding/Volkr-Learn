package com.sandboxol.halloween.c;

import com.sandboxol.halloween.entity.HalloweenInfoResponse;

/* JADX INFO: compiled from: HalloweenCacheManager.java */
/* JADX INFO: loaded from: classes4.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f18644a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HalloweenInfoResponse f18645b;

    /* JADX INFO: compiled from: HalloweenCacheManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f18646a = new b();
    }

    public static b b() {
        return a.f18646a;
    }

    public void a(HalloweenInfoResponse halloweenInfoResponse) {
        this.f18645b = halloweenInfoResponse;
    }

    public boolean c() {
        return this.f18644a;
    }

    private b() {
    }

    public HalloweenInfoResponse a() {
        return this.f18645b;
    }

    public void a(boolean z) {
        this.f18644a = z;
    }
}
