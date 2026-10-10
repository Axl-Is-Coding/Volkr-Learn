package com.tencent.mapsdk.rastercore.d;

import android.graphics.PointF;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.tencent.mapsdk.rastercore.b.e f19513a = new com.tencent.mapsdk.rastercore.b.e(new com.tencent.mapsdk.rastercore.b.f(-2.003750834E7d, -2.003750834E7d), new com.tencent.mapsdk.rastercore.b.f(2.003750834E7d, 2.003750834E7d));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private f f19514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f19515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.b.d f19516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.b.d f19517e;
    private com.tencent.mapsdk.rastercore.b.e g;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19518f = false;
    private double h = 0.0d;
    private double i = 0.0d;

    public c(f fVar) {
        this.f19514b = fVar;
    }

    private double a(double d2) {
        return this.f19515c.d().d() * Math.cos(d2 * 0.017453292519943295d);
    }

    private double a(boolean z) {
        double latitude;
        double latitude2;
        LatLngBounds latLngBoundsC = c();
        if (z) {
            latitude = latLngBoundsC.getNortheast().getLongitude();
            latitude2 = latLngBoundsC.getSouthwest().getLongitude();
        } else {
            latitude = latLngBoundsC.getNortheast().getLatitude();
            latitude2 = latLngBoundsC.getSouthwest().getLatitude();
        }
        return Math.abs(latitude - latitude2);
    }

    private com.tencent.mapsdk.rastercore.b.f[] k() {
        return new com.tencent.mapsdk.rastercore.b.f[]{com.tencent.mapsdk.rastercore.c.a(new PointF(WheelView.DividerConfig.FILL, this.f19515c.getHeight()), this.f19515c.b(), this.f19515c.a(), this.f19515c.d()), com.tencent.mapsdk.rastercore.c.a(new PointF(this.f19515c.getWidth(), WheelView.DividerConfig.FILL), this.f19515c.b(), this.f19515c.a(), this.f19515c.d())};
    }

    public final float a(double d2, double d3) {
        return (float) (d3 / a(d2));
    }

    public final float a(float f2) {
        double d2 = f2;
        double dA = a(0.0d);
        Double.isNaN(d2);
        return (float) (d2 / dA);
    }

    public final PointF a(LatLng latLng) {
        com.tencent.mapsdk.rastercore.b.f fVarB = this.f19515c.b();
        PointF pointFA = this.f19515c.a();
        com.tencent.mapsdk.rastercore.b.d dVarD = this.f19515c.d();
        com.tencent.mapsdk.rastercore.b.f fVarA = com.tencent.mapsdk.rastercore.c.a(latLng);
        double dB = fVarA.b() - fVarB.b();
        double dA = fVarA.a() - fVarB.a();
        double d2 = dB / dVarD.d();
        double d3 = dA / dVarD.d();
        PointF pointF = new PointF();
        double d4 = pointFA.x;
        Double.isNaN(d4);
        pointF.x = (float) (d4 + d2);
        double d5 = pointFA.y;
        Double.isNaN(d5);
        pointF.y = (float) (d5 - d3);
        return pointF;
    }

    public final LatLng a(int i, int i2) {
        return com.tencent.mapsdk.rastercore.c.a(com.tencent.mapsdk.rastercore.c.a(new PointF(i, i2), this.f19515c.b(), this.f19515c.a(), this.f19515c.d()));
    }

    public final com.tencent.mapsdk.rastercore.b.d a(com.tencent.mapsdk.rastercore.b.d dVar) {
        com.tencent.mapsdk.rastercore.b.d dVar2;
        boolean z = this.f19514b.f().a() >= 3 && this.f19514b.f().b() > 1.0f;
        double dC = dVar.c();
        double dA = this.f19517e.a();
        double dLog = z ? Math.log(1.3d) / Math.log(2.0d) : 0.0d;
        Double.isNaN(dA);
        if (dC < dA + dLog) {
            dVar2 = new com.tencent.mapsdk.rastercore.b.d(this.f19517e.c());
            if (z) {
                dVar2.a(1.3d);
            }
        } else {
            dVar2 = dVar;
        }
        if (dVar.c() > this.f19516d.c() + (z ? Math.log(1.3d) / Math.log(2.0d) : 0.0d)) {
            dVar2 = new com.tencent.mapsdk.rastercore.b.d(this.f19516d.c());
            if (z) {
                dVar2.a(1.3d);
            }
        }
        return dVar2;
    }

    public final void a() {
        this.g = f19513a;
        this.f19516d = new com.tencent.mapsdk.rastercore.b.d(19.0d);
        this.f19517e = new com.tencent.mapsdk.rastercore.b.d(com.tencent.mapsdk.rastercore.b.d.f19448a);
        this.f19515c = this.f19514b.c();
    }

    protected final void a(int i) {
        this.h = 0.0d;
    }

    public final void a(com.tencent.mapsdk.rastercore.b.f fVar) {
        if (this.g == null) {
            return;
        }
        com.tencent.mapsdk.rastercore.b.f[] fVarArrK = k();
        com.tencent.mapsdk.rastercore.b.f fVarA = this.g.a();
        com.tencent.mapsdk.rastercore.b.f fVarB = this.g.b();
        double dA = fVarA.a() > fVarArrK[0].a() ? fVarA.a() - fVarArrK[0].a() : 0.0d;
        double dB = fVarA.b() > fVarArrK[0].b() ? fVarA.b() - fVarArrK[0].b() : 0.0d;
        if (fVarB.a() < fVarArrK[1].a()) {
            dA = fVarB.a() - fVarArrK[1].a();
        }
        if (fVarB.b() < fVarArrK[1].b()) {
            dB = fVarB.b() - fVarArrK[1].b();
        }
        fVar.a(fVar.a() + dA);
        fVar.b(fVar.b() + dB);
    }

    public final boolean a(LatLngBounds latLngBounds) {
        double d2;
        if (latLngBounds == null) {
            this.g = f19513a;
            this.f19517e.b(com.tencent.mapsdk.rastercore.b.d.f19448a);
            this.f19518f = false;
            return true;
        }
        int height = this.f19515c.getHeight();
        int width = this.f19515c.getWidth();
        if (height == 0 || width == 0) {
            return false;
        }
        LatLng northeast = latLngBounds.getNortheast();
        LatLng southwest = latLngBounds.getSouthwest();
        com.tencent.mapsdk.rastercore.b.f fVarA = com.tencent.mapsdk.rastercore.c.a(northeast);
        com.tencent.mapsdk.rastercore.b.f fVarA2 = com.tencent.mapsdk.rastercore.c.a(southwest);
        double dA = fVarA.a() - fVarA2.a();
        double dB = fVarA.b() - fVarA2.b();
        if ((height * 1.0f) / width > ((float) (dA / dB))) {
            double d3 = height;
            double dC = com.tencent.mapsdk.rastercore.b.d.c(19.0d);
            Double.isNaN(d3);
            d2 = (d3 * dC) / dA;
        } else {
            double d4 = width;
            double dC2 = com.tencent.mapsdk.rastercore.b.d.c(19.0d);
            Double.isNaN(d4);
            d2 = (d4 * dC2) / dB;
        }
        float f2 = (float) d2;
        if (f2 > 2.0f) {
            return false;
        }
        this.f19517e.a(19);
        this.f19517e.a(f2);
        this.f19515c.d().b(this.f19517e.c());
        this.g = new com.tencent.mapsdk.rastercore.b.e(fVarA2, fVarA);
        a(this.f19515c.b());
        this.f19518f = true;
        this.f19514b.a(false, false);
        return true;
    }

    protected final void b(double d2, double d3) {
        if (d2 <= 0.0d || d3 <= 0.0d) {
            return;
        }
        double dA = a(true);
        double dA2 = a(false);
        if (dA == 0.0d && dA2 == 0.0d) {
            this.h = d2;
            this.i = d3;
            return;
        }
        double dMax = Math.max(d2 / dA2, d3 / dA);
        com.tencent.mapsdk.rastercore.b.d dVarD = this.f19515c.d();
        dVarD.a(dVarD.b() * dMax);
        a(dVarD);
        this.f19514b.a(false, false);
    }

    protected final void b(int i) {
        this.i = 0.0d;
    }

    public final com.tencent.mapsdk.rastercore.b.f[] b() {
        com.tencent.mapsdk.rastercore.b.f[] fVarArr = new com.tencent.mapsdk.rastercore.b.f[8];
        float width = this.f19515c.getWidth();
        float height = this.f19515c.getHeight();
        float f2 = width / 2.0f;
        float f3 = height / 2.0f;
        PointF[] pointFArr = {new PointF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL), new PointF(f2, WheelView.DividerConfig.FILL), new PointF(width, WheelView.DividerConfig.FILL), new PointF(width, f3), new PointF(width, height), new PointF(f2, height), new PointF(WheelView.DividerConfig.FILL, height), new PointF(WheelView.DividerConfig.FILL, f3)};
        for (int i = 0; i < 8; i++) {
            fVarArr[i] = com.tencent.mapsdk.rastercore.c.a(pointFArr[i], this.f19515c.b(), this.f19515c.a(), this.f19515c.d());
        }
        return fVarArr;
    }

    public final LatLngBounds c() {
        com.tencent.mapsdk.rastercore.b.f[] fVarArrK = k();
        return new LatLngBounds(com.tencent.mapsdk.rastercore.c.a(fVarArrK[0]), com.tencent.mapsdk.rastercore.c.a(fVarArrK[1]));
    }

    public final void c(int i) {
        if (i <= this.f19517e.a()) {
            i = this.f19517e.a();
        }
        if (i >= 19) {
            i = 19;
        }
        this.f19516d.b(i);
        if (this.f19515c.d().c() >= this.f19516d.c()) {
            this.f19515c.b(this.f19516d.c(), true, null);
        }
    }

    public final CameraPosition d() {
        return CameraPosition.builder().target(com.tencent.mapsdk.rastercore.c.a(this.f19515c.b())).zoom(this.f19515c.d().a()).build();
    }

    public final void d(int i) {
        if (this.f19518f && i <= this.f19517e.c()) {
            i = this.f19517e.a();
        }
        int i2 = com.tencent.mapsdk.rastercore.b.d.f19448a;
        if (i <= i2) {
            i = i2;
        }
        if (i >= this.f19516d.c()) {
            i = this.f19516d.a();
        }
        this.f19517e.b(i);
        if (this.f19515c.d().c() <= this.f19517e.c()) {
            this.f19515c.b(this.f19517e.c(), true, null);
        }
    }

    public final double e() {
        double dAbs = 1.0d;
        if (this.f19515c.d().a() >= 7) {
            dAbs = 1.0d - Math.abs(this.f19515c.b().a() / 2.003750834E7d);
            if (dAbs < 0.1d) {
                dAbs = 0.1d;
            }
        }
        return this.f19515c.d().d() * dAbs;
    }

    public final float f() {
        int width = this.f19515c.getWidth();
        double dA = com.tencent.mapsdk.rastercore.c.a(a(0, 0), a(width, 0));
        double d2 = width;
        Double.isNaN(d2);
        return (float) (dA / d2);
    }

    protected final double g() {
        return this.h;
    }

    protected final double h() {
        return this.i;
    }

    public final com.tencent.mapsdk.rastercore.b.d i() {
        return this.f19516d;
    }

    public final com.tencent.mapsdk.rastercore.b.d j() {
        return this.f19517e;
    }
}
