package com.bytedance.sdk.openadsdk.f.b;

/* JADX INFO: compiled from: LogUploaderImplEmpty.java */
/* JADX INFO: loaded from: classes.dex */
class e implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f6756a;

    private e() {
    }

    public static e c() {
        if (f6756a == null) {
            synchronized (e.class) {
                if (f6756a == null) {
                    f6756a = new e();
                }
            }
        }
        return f6756a;
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a(com.bytedance.sdk.openadsdk.f.a.a aVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void a(com.bytedance.sdk.openadsdk.f.a.a aVar, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.f.b.a
    public void b() {
    }
}
