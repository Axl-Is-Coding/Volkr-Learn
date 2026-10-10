package com.tencent.mapsdk.rastercore.e.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class d implements com.tencent.mapsdk.rastercore.e.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f19573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<LatLng> f19574b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.d.f f19576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.d.a f19577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f19578f;
    private boolean h;
    private boolean i;
    private int j;
    private float k;
    private float l;
    private BitmapDescriptor m;
    private float n;
    private int o;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<LatLng> f19575c = new ArrayList();
    private LatLngBounds g = null;
    private String p = getId();

    public d(com.tencent.mapsdk.rastercore.d.f fVar, PolylineOptions polylineOptions) {
        this.f19573a = 90.0f;
        this.f19574b = new ArrayList();
        this.f19578f = false;
        this.h = false;
        this.i = true;
        this.j = -16777216;
        this.k = 10.0f;
        this.l = WheelView.DividerConfig.FILL;
        this.n = WheelView.DividerConfig.FILL;
        this.o = -983041;
        this.f19576d = fVar;
        this.f19577e = fVar.e();
        this.j = polylineOptions.getColor();
        this.f19578f = polylineOptions.isDottedLine();
        this.h = polylineOptions.isGeodesic();
        if (this.h || this.f19578f) {
            this.f19574b = polylineOptions.getPoints();
        }
        b(polylineOptions.getPoints());
        this.i = polylineOptions.isVisible();
        this.k = polylineOptions.getWidth();
        this.l = polylineOptions.getZIndex();
        this.m = polylineOptions.getArrowTexture();
        this.n = polylineOptions.getEdgeWidth();
        this.o = polylineOptions.getEdgeColor();
        this.f19573a = polylineOptions.getArrowGap();
    }

    private void a(Canvas canvas, List<PointF> list) {
        BitmapDescriptor bitmapDescriptor;
        int i;
        int i2;
        double d2;
        double d3;
        double dSqrt;
        int i3;
        int i4;
        double d4;
        List<PointF> list2 = list;
        if (list2 == null || list.size() == 0 || (bitmapDescriptor = this.m) == null || bitmapDescriptor.getBitmap() == null || this.m.getBitmap().isRecycled()) {
            return;
        }
        int width = this.m.getWidth();
        int height = this.m.getHeight();
        float f2 = this.k;
        float f3 = height;
        double d5 = f2 / f3;
        double d6 = (width * f2) / (f3 * this.f19573a);
        double d7 = width;
        Double.isNaN(d7);
        Double.isNaN(d5);
        double d8 = -((d7 * d5) / 2.0d);
        int i5 = 0;
        while (i5 < list.size() - 1) {
            PointF pointF = list2.get(i5);
            int i6 = i5 + 1;
            PointF pointF2 = list2.get(i6);
            if (pointF == null || pointF2 == null) {
                i = width;
                i2 = height;
                d2 = d6;
                d3 = d5;
                dSqrt = 0.0d;
            } else {
                i = width;
                d3 = d5;
                i2 = height;
                d2 = d6;
                dSqrt = Math.sqrt(Math.pow(pointF.x - pointF2.x, 2.0d) + Math.pow(pointF.y - pointF2.y, 2.0d));
            }
            double d9 = dSqrt + d8;
            float f4 = this.f19573a;
            if (d9 < f4) {
                i3 = i2;
                i4 = i;
                d4 = d3;
            } else {
                double d10 = f4;
                Double.isNaN(d10);
                double d11 = dSqrt / d10;
                double d12 = f4;
                Double.isNaN(d12);
                double d13 = d8;
                double d14 = f4;
                Double.isNaN(d14);
                double d15 = (d12 - d8) / d14;
                double d16 = pointF2.x - pointF.x;
                Double.isNaN(d16);
                double dAcos = (Math.acos(d16 / dSqrt) * 180.0d) / 3.141592653589793d;
                if (pointF2.x <= pointF.x && pointF2.y >= pointF.y) {
                    dAcos = (180.0d - dAcos) + 180.0d;
                } else if (pointF2.x >= pointF.x && pointF2.y >= pointF.y) {
                    dAcos = 360.0d - dAcos;
                }
                while (d15 <= d11) {
                    if (i5 == list.size() - 2) {
                        Double.isNaN(d2);
                        if (d15 + d2 > d11) {
                            return;
                        }
                    }
                    canvas.save();
                    float f5 = pointF.x;
                    double d17 = f5;
                    int i7 = i5;
                    float f6 = pointF2.x - f5;
                    int i8 = i2;
                    double d18 = f6;
                    Double.isNaN(d18);
                    Double.isNaN(d17);
                    float f7 = (float) (d17 + ((d18 * d15) / d11));
                    float f8 = pointF.y;
                    double d19 = f8;
                    PointF pointF3 = pointF;
                    PointF pointF4 = pointF2;
                    double d20 = pointF2.y - f8;
                    Double.isNaN(d20);
                    Double.isNaN(d19);
                    canvas.translate(f7, (float) (d19 + ((d20 * d15) / d11)));
                    double d21 = d3;
                    float f9 = (float) d21;
                    canvas.scale(f9, f9);
                    canvas.rotate((float) (-dAcos));
                    int i9 = i;
                    double d22 = dAcos;
                    canvas.drawBitmap(this.m.getBitmap(), (-i9) / 2, (-i8) / 2, (Paint) null);
                    canvas.restore();
                    double d23 = 1.0d + d15;
                    if (d23 > d11) {
                        double d24 = this.f19573a;
                        Double.isNaN(d24);
                        d13 = (d11 - d15) * d24;
                    }
                    d15 = d23;
                    i = i9;
                    dAcos = d22;
                    i5 = i7;
                    pointF = pointF3;
                    pointF2 = pointF4;
                    i2 = i8;
                    d3 = d21;
                }
                i3 = i2;
                i4 = i;
                d4 = d3;
                d9 = d13;
            }
            list2 = list;
            height = i3;
            width = i4;
            i5 = i6;
            d6 = d2;
            d5 = d4;
            d8 = d9;
        }
    }

    private static void a(List<LatLng> list, List<LatLng> list2, double d2) {
        if (list.size() != 3) {
            return;
        }
        int i = 0;
        while (i <= 10) {
            float f2 = i;
            float f3 = f2 / 10.0f;
            double d3 = f3;
            Double.isNaN(d3);
            double d4 = 1.0d - d3;
            double d5 = d4 * d4;
            double longitude = list.get(0).getLongitude() * d5;
            double d6 = 2.0f * f3;
            Double.isNaN(d6);
            double d7 = d6 * d4;
            double longitude2 = longitude + (list.get(1).getLongitude() * d7 * d2);
            double d8 = f3 * f3;
            double longitude3 = list.get(2).getLongitude();
            Double.isNaN(d8);
            double d9 = longitude2 + (longitude3 * d8);
            double latitude = (list.get(0).getLatitude() * d5) + (list.get(1).getLatitude() * d7 * d2);
            double latitude2 = list.get(2).getLatitude();
            Double.isNaN(d8);
            Double.isNaN(d8);
            double d10 = d5 + (d7 * d2) + d8;
            list2.add(new LatLng((latitude + (latitude2 * d8)) / d10, d9 / d10));
            i = (int) (f2 + 1.0f);
        }
    }

    private void b(List<LatLng> list) {
        LatLngBounds.Builder builder;
        d dVar = this;
        if (list == null || list.size() == 0) {
            return;
        }
        LatLngBounds.Builder builder2 = LatLngBounds.builder();
        dVar.f19575c.clear();
        if (list != null) {
            LatLng latLng = null;
            for (LatLng latLng2 : list) {
                if (latLng2 == null || latLng2.equals(latLng)) {
                    builder = builder2;
                    dVar = this;
                } else if (dVar.h) {
                    if (latLng == null) {
                        builder = builder2;
                    } else if (Math.abs(latLng2.getLongitude() - latLng.getLongitude()) < 0.01d) {
                        dVar.f19575c.add(latLng);
                        builder2.include(latLng);
                        dVar.f19575c.add(latLng2);
                        builder2.include(latLng2);
                        builder = builder2;
                    } else {
                        List<LatLng> list2 = dVar.f19575c;
                        double dAbs = (Math.abs(latLng.getLongitude() - latLng2.getLongitude()) * 3.141592653589793d) / 180.0d;
                        LatLng latLng3 = new LatLng((latLng2.getLatitude() + latLng.getLatitude()) / 2.0d, (latLng2.getLongitude() + latLng.getLongitude()) / 2.0d);
                        builder2.include(latLng).include(latLng3).include(latLng2);
                        int i = latLng3.getLatitude() > 0.0d ? 1 : -1;
                        double d2 = dAbs * 0.5d;
                        double dCos = Math.cos(d2);
                        builder = builder2;
                        double dHypot = Math.hypot(latLng.getLongitude() - latLng2.getLongitude(), latLng.getLatitude() - latLng2.getLatitude()) * 0.5d * Math.tan(d2);
                        double longitude = latLng2.getLongitude() - latLng.getLongitude();
                        double latitude = latLng2.getLatitude() - latLng.getLatitude();
                        double d3 = i;
                        Double.isNaN(d3);
                        double dSqrt = (int) (((d3 * dHypot) / Math.sqrt(((latitude * latitude) / (longitude * longitude)) + 1.0d)) + latLng3.getLatitude());
                        double latitude2 = latLng3.getLatitude();
                        Double.isNaN(dSqrt);
                        LatLng latLng4 = new LatLng(dSqrt, (int) ((((latitude2 - dSqrt) * latitude) / longitude) + latLng3.getLongitude()));
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(latLng);
                        arrayList.add(latLng4);
                        arrayList.add(latLng2);
                        a(arrayList, list2, dCos);
                    }
                    dVar = this;
                    latLng = latLng2;
                } else {
                    dVar.f19575c.add(latLng2);
                    builder2.include(latLng2);
                    builder = builder2;
                    dVar = this;
                    latLng = latLng2;
                }
                builder2 = builder;
            }
        }
        this.g = builder2.build();
    }

    @Override // com.tencent.mapsdk.rastercore.e.e
    public final float a() {
        return this.k;
    }

    @Override // com.tencent.mapsdk.rastercore.e.e
    public final void a(float f2) {
        this.k = f2;
        this.f19576d.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.e
    public final void a(int i) {
        this.j = i;
        this.f19576d.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.e
    public final void a(List<LatLng> list) {
        if (this.h || this.f19578f) {
            this.f19574b = list;
        }
        b(list);
        this.f19576d.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.e
    public final void a(boolean z) {
        this.f19578f = z;
        this.f19576d.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.e
    public final int b() {
        return this.j;
    }

    @Override // com.tencent.mapsdk.rastercore.e.e
    public final void b(boolean z) {
        this.h = z;
        this.f19576d.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.e
    public final List<LatLng> c() {
        return (this.h || this.f19578f) ? this.f19574b : this.f19575c;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final boolean checkInBounds() {
        if (this.g == null) {
            return false;
        }
        LatLngBounds latLngBoundsC = this.f19576d.b().c();
        return latLngBoundsC == null || latLngBoundsC.contains(this.g) || this.g.intersects(latLngBoundsC);
    }

    @Override // com.tencent.mapsdk.rastercore.e.e
    public final boolean d() {
        return this.f19578f;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final void destroy() {
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final void draw(Canvas canvas) {
        ArrayList arrayList = new ArrayList();
        List<LatLng> list = this.f19575c;
        if (list == null || list.size() == 0 || this.k <= WheelView.DividerConfig.FILL) {
            return;
        }
        Path path = new Path();
        PointF pointFA = this.f19576d.b().a(this.f19575c.get(0));
        arrayList.add(pointFA);
        path.moveTo(pointFA.x, pointFA.y);
        for (int i = 1; i < this.f19575c.size(); i++) {
            PointF pointFA2 = this.f19576d.b().a(this.f19575c.get(i));
            arrayList.add(pointFA2);
            path.lineTo(pointFA2.x, pointFA2.y);
        }
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        if (this.f19578f) {
            int i2 = (int) this.k;
            float f2 = i2 * 3;
            float f3 = i2;
            paint.setPathEffect(new DashPathEffect(new float[]{f2, f3, f2, f3}, 1.0f));
        } else {
            paint.setStrokeJoin(Paint.Join.ROUND);
            paint.setStrokeCap(Paint.Cap.ROUND);
        }
        paint.setAntiAlias(true);
        if (this.n > WheelView.DividerConfig.FILL) {
            paint.setColor(this.o);
            paint.setStrokeWidth(this.k + (this.n * 2.0f));
            canvas.drawPath(path, paint);
        }
        paint.setColor(this.j);
        paint.setStrokeWidth(this.k);
        canvas.drawPath(path, paint);
        if (this.m != null) {
            a(canvas, arrayList);
        }
        arrayList.clear();
    }

    @Override // com.tencent.mapsdk.rastercore.e.e
    public final boolean e() {
        return this.h;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final boolean equalsRemote(com.tencent.mapsdk.rastercore.e.c cVar) {
        return equals(cVar) || cVar.getId().equals(getId());
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final String getId() {
        if (this.p == null) {
            this.p = com.tencent.mapsdk.rastercore.d.a.a("Polyline");
        }
        return this.p;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final float getZIndex() {
        return this.l;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final boolean isVisible() {
        return this.i;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final void remove() {
        this.f19577e.b(getId());
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final void setVisible(boolean z) {
        this.i = z;
        this.f19577e.c();
        this.f19576d.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public final void setZIndex(float f2) {
        this.l = f2;
        this.f19577e.c();
        this.f19576d.a(false, false);
    }
}
