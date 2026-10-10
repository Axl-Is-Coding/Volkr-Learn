package com.tencent.mapsdk.rastercore.c;

/* JADX INFO: loaded from: classes5.dex */
public final class d extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f19473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float f19474e;

    public final void a(float f2) {
        this.f19473d = f2;
    }

    @Override // com.tencent.mapsdk.rastercore.c.a
    public final void a(com.tencent.mapsdk.rastercore.d.f fVar) {
        com.tencent.mapsdk.rastercore.d.b bVarC = fVar.c();
        if (this.f19466a) {
            bVarC.a((int) (-this.f19473d), (int) (-this.f19474e), this.f19467b, this.f19468c);
        } else {
            bVarC.scrollBy((int) (-this.f19473d), (int) (-this.f19474e));
        }
    }

    public final void b(float f2) {
        this.f19474e = f2;
    }
}
