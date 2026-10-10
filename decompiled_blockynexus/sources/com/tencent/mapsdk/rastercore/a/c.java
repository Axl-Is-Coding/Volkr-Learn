package com.tencent.mapsdk.rastercore.a;

import android.graphics.PointF;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private PointF f19429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f19430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private double f19431f;

    public c(f fVar, double d2, PointF pointF, long j, CancelableCallback cancelableCallback) {
        super(fVar, j, cancelableCallback);
        this.f19430e = d2;
        this.f19429d = pointF;
    }

    @Override // com.tencent.mapsdk.rastercore.a.a
    protected final void a(float f2) {
        com.tencent.mapsdk.rastercore.d.b bVar = this.f19415b;
        double d2 = this.f19431f;
        double d3 = f2;
        Double.isNaN(d3);
        bVar.a(d2 * d3, this.f19429d, false, (CancelableCallback) null);
    }

    @Override // com.tencent.mapsdk.rastercore.a.a
    protected final void c() {
        double dC = this.f19415b.c();
        this.f19431f = this.f19430e - dC;
        StringBuilder sb = new StringBuilder("newZoom:");
        sb.append(this.f19430e);
        sb.append(",oldZoom=");
        sb.append(dC);
    }

    @Override // com.tencent.mapsdk.rastercore.a.a
    protected final void d() {
        this.f19415b.a(this.f19430e, this.f19429d, false, 0L, null);
    }
}
