package com.tencent.mapsdk.rastercore.c;

import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LatLngBounds f19471f;
    private int g;

    public final void a(int i) {
        this.f19469d = i;
    }

    public final void a(LatLngBounds latLngBounds) {
        this.f19471f = latLngBounds;
    }

    @Override // com.tencent.mapsdk.rastercore.c.a
    public final void a(com.tencent.mapsdk.rastercore.d.f fVar) {
        double d2;
        com.tencent.mapsdk.rastercore.d.b bVarC = fVar.c();
        int height = this.f19470e;
        if (height == 0) {
            height = bVarC.getHeight();
        }
        this.f19470e = height - (this.g * 2);
        int width = this.f19469d;
        if (width == 0) {
            width = bVarC.getWidth();
        }
        this.f19469d = width - (this.g * 2);
        if (this.f19470e == 0 || this.f19469d == 0) {
            return;
        }
        LatLng northeast = this.f19471f.getNortheast();
        LatLng southwest = this.f19471f.getSouthwest();
        com.tencent.mapsdk.rastercore.b.f fVarA = com.tencent.mapsdk.rastercore.c.a(northeast);
        com.tencent.mapsdk.rastercore.b.f fVarA2 = com.tencent.mapsdk.rastercore.c.a(southwest);
        double dA = fVarA.a() - fVarA2.a();
        double dB = fVarA.b() - fVarA2.b();
        int i = this.f19470e;
        int i2 = this.f19469d;
        if ((i * 1.0f) / i2 < ((float) (dA / dB))) {
            double d3 = i;
            Double.isNaN(d3);
            d2 = (d3 * 156543.0339d) / dA;
        } else {
            double d4 = i2;
            Double.isNaN(d4);
            d2 = (d4 * 156543.0339d) / dB;
        }
        com.tencent.mapsdk.rastercore.b.d dVarA = fVar.b().a(new com.tencent.mapsdk.rastercore.b.d(0, (float) d2));
        com.tencent.mapsdk.rastercore.b.f fVar2 = new com.tencent.mapsdk.rastercore.b.f(fVarA2.b() + (dB / 2.0d), fVarA2.a() + (dA / 2.0d));
        if (this.f19466a) {
            bVarC.a(fVar2, this.f19467b, this.f19468c);
        } else {
            bVarC.b(fVar2);
        }
        bVarC.b(dVarA.c(), this.f19466a, this.f19468c);
    }

    public final void b(int i) {
        this.f19470e = i;
    }

    public final void c(int i) {
        this.g = i;
    }
}
