package com.tencent.mapsdk.rastercore.c;

import android.graphics.Point;
import android.graphics.PointF;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f19475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Point f19476e;

    public final void a(float f2) {
        this.f19475d = f2;
    }

    public final void a(Point point) {
        this.f19476e = point;
    }

    @Override // com.tencent.mapsdk.rastercore.c.a
    public final void a(com.tencent.mapsdk.rastercore.d.f fVar) {
        if (this.f19476e == null) {
            fVar.c().a(this.f19475d, this.f19466a, this.f19468c);
        } else {
            fVar.c().a(this.f19475d, new PointF(r0.x, r0.y), this.f19466a, this.f19468c);
        }
    }
}
