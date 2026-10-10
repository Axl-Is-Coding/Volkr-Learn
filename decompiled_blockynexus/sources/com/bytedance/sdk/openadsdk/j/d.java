package com.bytedance.sdk.openadsdk.j;

import java.util.List;

/* JADX INFO: compiled from: TrackAdUrlImplEmpty.java */
/* JADX INFO: loaded from: classes.dex */
class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f7013a;

    private d() {
    }

    public static d c() {
        if (f7013a == null) {
            synchronized (d.class) {
                if (f7013a == null) {
                    f7013a = new d();
                }
            }
        }
        return f7013a;
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void a(List<String> list) {
    }

    @Override // com.bytedance.sdk.openadsdk.j.a
    public void b() {
    }
}
