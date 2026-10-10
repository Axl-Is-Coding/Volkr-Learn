package com.ironsource.mediationsdk.a;

/* JADX INFO: compiled from: ConfigValidationResult.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f14765a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ironsource.mediationsdk.logger.b f14766b = null;

    public void a(com.ironsource.mediationsdk.logger.b bVar) {
        this.f14765a = false;
        this.f14766b = bVar;
    }

    public boolean b() {
        return this.f14765a;
    }

    public String toString() {
        if (b()) {
            return "valid:" + this.f14765a;
        }
        return "valid:" + this.f14765a + ", IronSourceError:" + this.f14766b;
    }

    public com.ironsource.mediationsdk.logger.b a() {
        return this.f14766b;
    }
}
