package com.tencent.mapsdk.rastercore.b;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f19445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f[] f19446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f19447c;

    public c(f fVar, f[] fVarArr, float f2) {
        this.f19445a = fVar;
        this.f19446b = fVarArr;
        this.f19447c = f2;
    }

    public final f a() {
        return this.f19445a;
    }

    public final void a(f fVar, f[] fVarArr, float f2) {
        this.f19445a = fVar;
        this.f19446b = fVarArr;
        this.f19447c = f2;
    }

    public final f[] b() {
        return this.f19446b;
    }

    public final float c() {
        return this.f19447c - 1.0f;
    }
}
