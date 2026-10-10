package com.tencent.mapsdk.rastercore.a;

import com.tencent.mapsdk.rastercore.b.f;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private f f19426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private f f19427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f19428f;
    private double g;

    public b(com.tencent.mapsdk.rastercore.d.f fVar, f fVar2, long j, CancelableCallback cancelableCallback) {
        super(fVar, j, cancelableCallback);
        this.f19427e = fVar2;
    }

    @Override // com.tencent.mapsdk.rastercore.a.a
    protected final void a(float f2) {
        double d2 = this.f19428f;
        double d3 = f2;
        Double.isNaN(d3);
        double d4 = this.g;
        Double.isNaN(d3);
        f fVar = this.f19426d;
        fVar.b(fVar.b() + (d2 * d3));
        f fVar2 = this.f19426d;
        fVar2.a(fVar2.a() + (d4 * d3));
        this.f19415b.b(this.f19426d);
    }

    @Override // com.tencent.mapsdk.rastercore.a.a
    protected final void c() {
        this.f19426d = this.f19415b.b();
        this.f19428f = this.f19427e.b() - this.f19426d.b();
        this.g = this.f19427e.a() - this.f19426d.a();
    }

    @Override // com.tencent.mapsdk.rastercore.a.a
    protected final void d() {
        this.f19415b.b(this.f19427e);
    }
}
