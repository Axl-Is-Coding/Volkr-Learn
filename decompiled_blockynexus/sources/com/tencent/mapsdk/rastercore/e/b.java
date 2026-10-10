package com.tencent.mapsdk.rastercore.e;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.d.f;

/* JADX INFO: loaded from: classes5.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private BitmapDescriptor f19586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LatLng f19587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f19588c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f19589d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LatLngBounds f19590e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f19591f;
    private float g;
    private boolean h;
    private float i;
    private float j;
    private float k;
    private String l = getId();
    private Bitmap m;
    private f n;
    private com.tencent.mapsdk.rastercore.d.a o;

    public b(f fVar, GroundOverlayOptions groundOverlayOptions) {
        this.h = true;
        this.i = WheelView.DividerConfig.FILL;
        this.j = 0.5f;
        this.k = 0.5f;
        this.n = fVar;
        this.o = fVar.e();
        this.j = groundOverlayOptions.getAnchorU();
        this.k = groundOverlayOptions.getAnchorV();
        this.f19591f = groundOverlayOptions.getBearing();
        this.f19588c = groundOverlayOptions.getWidth();
        this.f19589d = groundOverlayOptions.getHeight();
        this.f19586a = groundOverlayOptions.getImage();
        this.f19587b = groundOverlayOptions.getLocation();
        this.f19590e = groundOverlayOptions.getBounds();
        this.i = groundOverlayOptions.getTransparency();
        this.h = groundOverlayOptions.isVisible();
        this.g = groundOverlayOptions.getZIndex();
    }

    private void g() {
        double d2 = this.f19588c;
        double dCos = Math.cos(this.f19587b.getLatitude() * 0.01745329251994329d) * 6371000.79d * 0.01745329251994329d;
        Double.isNaN(d2);
        double d3 = d2 / dCos;
        double d4 = this.f19589d;
        Double.isNaN(d4);
        double d5 = d4 / 111194.94043265979d;
        double latitude = this.f19587b.getLatitude();
        double d6 = 1.0f - this.k;
        Double.isNaN(d6);
        double d7 = latitude - (d6 * d5);
        double longitude = this.f19587b.getLongitude();
        double d8 = this.j;
        Double.isNaN(d8);
        LatLng latLng = new LatLng(d7, longitude - (d8 * d3));
        double latitude2 = this.f19587b.getLatitude();
        double d9 = this.k;
        Double.isNaN(d9);
        double d10 = latitude2 + (d9 * d5);
        double longitude2 = this.f19587b.getLongitude();
        double d11 = 1.0f - this.j;
        Double.isNaN(d11);
        this.f19590e = new LatLngBounds(latLng, new LatLng(d10, longitude2 + (d11 * d3)));
    }

    private void h() {
        LatLng southwest = this.f19590e.getSouthwest();
        LatLng northeast = this.f19590e.getNortheast();
        double latitude = southwest.getLatitude();
        double d2 = 1.0f - this.k;
        double latitude2 = northeast.getLatitude() - southwest.getLatitude();
        Double.isNaN(d2);
        double d3 = latitude + (d2 * latitude2);
        double longitude = southwest.getLongitude();
        double d4 = this.j;
        double longitude2 = northeast.getLongitude() - southwest.getLongitude();
        Double.isNaN(d4);
        this.f19587b = new LatLng(d3, longitude + (d4 * longitude2));
        this.f19588c = (float) (Math.cos(this.f19587b.getLatitude() * 0.01745329251994329d) * 6371000.79d * (northeast.getLongitude() - southwest.getLongitude()) * 0.01745329251994329d);
        this.f19589d = (float) ((northeast.getLatitude() - southwest.getLatitude()) * 6371000.79d * 0.01745329251994329d);
    }

    public LatLng a() {
        return this.f19587b;
    }

    public void a(float f2) {
        if (this.f19588c != f2) {
            this.f19588c = f2;
            this.f19589d = f2;
            g();
        } else {
            this.f19588c = f2;
            this.f19589d = f2;
        }
        this.n.a(false, false);
    }

    public void a(float f2, float f3) {
        if (this.f19588c == f2 || this.f19589d == f3) {
            this.f19588c = f2;
            this.f19589d = f3;
        } else {
            this.f19588c = f2;
            this.f19589d = f3;
            g();
        }
        this.n.a(false, false);
    }

    public void a(BitmapDescriptor bitmapDescriptor) {
        this.f19586a = bitmapDescriptor;
        BitmapDescriptor bitmapDescriptor2 = this.f19586a;
        this.n.a(false, false);
    }

    public void a(LatLng latLng) {
        LatLng latLng2 = this.f19587b;
        if (latLng2 == null || latLng2.equals(latLng)) {
            this.f19587b = latLng;
        } else {
            this.f19587b = latLng;
            g();
        }
        this.n.a(false, false);
    }

    public void a(LatLngBounds latLngBounds) {
        LatLngBounds latLngBounds2 = this.f19590e;
        if (latLngBounds2 == null || latLngBounds2.equals(latLngBounds)) {
            this.f19590e = latLngBounds;
        } else {
            this.f19590e = latLngBounds;
            h();
        }
        this.n.a(false, false);
    }

    public float b() {
        return this.f19588c;
    }

    public void b(float f2) {
        this.f19591f = f2;
        this.n.a(false, false);
    }

    public void b(float f2, float f3) {
        this.j = f2;
        this.k = f3;
        this.n.a(false, false);
    }

    public float c() {
        return this.f19589d;
    }

    public void c(float f2) {
        this.i = f2;
        this.n.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean checkInBounds() {
        if (this.f19590e == null) {
            return false;
        }
        LatLngBounds latLngBoundsC = this.n.b().c();
        return latLngBoundsC == null || latLngBoundsC.contains(this.f19590e) || this.f19590e.intersects(latLngBoundsC);
    }

    public LatLngBounds d() {
        return this.f19590e;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void destroy() {
        Bitmap bitmap;
        try {
            remove();
            if (this.f19586a != null && (bitmap = this.f19586a.getBitmap()) != null) {
                bitmap.recycle();
                this.f19586a = null;
            }
            this.f19587b = null;
            this.f19590e = null;
        } catch (Exception e2) {
            new StringBuilder("GroundOverlayDelegateImp destroy").append(e2.getMessage());
        }
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void draw(Canvas canvas) {
        if (this.h) {
            if ((this.f19587b == null && this.f19590e == null) || this.f19586a == null) {
                return;
            }
            if (this.f19587b == null) {
                h();
            } else if (this.f19590e == null) {
                g();
            }
            if (this.f19588c == WheelView.DividerConfig.FILL && this.f19589d == WheelView.DividerConfig.FILL) {
                return;
            }
            this.m = this.f19586a.getBitmap();
            Bitmap bitmap = this.m;
            if (bitmap == null || bitmap.isRecycled()) {
                return;
            }
            LatLng southwest = this.f19590e.getSouthwest();
            LatLng northeast = this.f19590e.getNortheast();
            PointF pointFA = this.n.b().a(southwest);
            PointF pointFA2 = this.n.b().a(northeast);
            Paint paint = new Paint();
            float f2 = pointFA2.x;
            float f3 = pointFA.x;
            float f4 = ((f2 - f3) * this.j) + f3;
            float f5 = pointFA.y;
            float f6 = pointFA2.y;
            float f7 = ((f5 - f6) * this.k) + f6;
            RectF rectF = new RectF(f3 - f4, f6 - f7, f2 - f4, f5 - f7);
            paint.setAlpha((int) (255.0f - (this.i * 255.0f)));
            paint.setFilterBitmap(true);
            canvas.save();
            canvas.translate(f4, f7);
            canvas.rotate(this.f19591f);
            canvas.drawBitmap(this.m, (Rect) null, rectF, paint);
            canvas.restore();
        }
    }

    public float e() {
        return this.f19591f;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean equalsRemote(c cVar) {
        return equals(cVar) || cVar.getId().equals(getId());
    }

    public float f() {
        return this.i;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public String getId() {
        if (this.l == null) {
            this.l = com.tencent.mapsdk.rastercore.d.a.a("GroundOverlay");
        }
        return this.l;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public float getZIndex() {
        return this.g;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean isVisible() {
        return this.h;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void remove() {
        this.o.b(getId());
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void setVisible(boolean z) {
        this.h = z;
        this.n.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void setZIndex(float f2) {
        this.g = f2;
        this.o.c();
        this.n.a(false, false);
    }
}
