package com.tencent.mapsdk.rastercore.e;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PointF;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.d.f;

/* JADX INFO: loaded from: classes5.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f19547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f19548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f19549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f19550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f19551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f19552f;
    private boolean g;
    private boolean h;
    private DashPathEffect i;
    private DashPathEffect j;
    private String k = getId();
    private f l;
    private com.tencent.mapsdk.rastercore.d.a m;

    public a(f fVar, CircleOptions circleOptions) {
        this.f19547a = null;
        this.f19548b = 0.0d;
        this.f19549c = 10.0f;
        this.f19550d = -16777216;
        this.f19551e = 0;
        this.f19552f = WheelView.DividerConfig.FILL;
        this.g = true;
        this.h = false;
        this.i = null;
        this.l = fVar;
        this.m = fVar.e();
        this.f19551e = circleOptions.getFillColor();
        this.f19547a = circleOptions.getCenter();
        this.g = circleOptions.isVisible();
        this.f19549c = circleOptions.getStrokeWidth();
        this.f19552f = circleOptions.getZIndex();
        this.f19550d = circleOptions.getStrokeColor();
        this.f19548b = circleOptions.getRadius();
        this.h = circleOptions.getStrokeDash();
        this.i = circleOptions.getStrokeDashPathEffect();
        float f2 = this.f19549c;
        this.j = new DashPathEffect(new float[]{f2, f2}, WheelView.DividerConfig.FILL);
    }

    public LatLng a() {
        return this.f19547a;
    }

    public void a(double d2) {
        this.f19548b = d2;
        this.l.a(false, false);
    }

    public void a(float f2) {
        this.f19549c = f2;
        float f3 = this.f19549c;
        this.j = new DashPathEffect(new float[]{f3, f3}, WheelView.DividerConfig.FILL);
        this.l.a(false, false);
    }

    public void a(int i) {
        this.f19550d = i;
        this.l.a(false, false);
    }

    public void a(DashPathEffect dashPathEffect) {
        this.i = dashPathEffect;
    }

    public void a(LatLng latLng) {
        this.f19547a = latLng;
        this.l.a(false, false);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public double b() {
        return this.f19548b;
    }

    public void b(int i) {
        this.f19551e = i;
        this.l.a(false, false);
    }

    public boolean b(LatLng latLng) {
        return this.f19548b >= com.tencent.mapsdk.rastercore.c.a(this.f19547a, latLng);
    }

    public float c() {
        return this.f19549c;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean checkInBounds() {
        return true;
    }

    public int d() {
        return this.f19550d;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void destroy() {
        this.f19547a = null;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void draw(Canvas canvas) {
        if (a() == null || this.f19548b <= 0.0d || !isVisible()) {
            return;
        }
        float fA = this.l.b().a(this.f19547a.getLatitude(), (float) b());
        PointF pointFA = this.l.b().a(this.f19547a);
        Paint paint = new Paint();
        paint.setColor(e());
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(pointFA.x, pointFA.y, fA, paint);
        if (com.tencent.mapsdk.rastercore.f.b.a(c(), WheelView.DividerConfig.FILL)) {
            return;
        }
        if (this.h) {
            DashPathEffect dashPathEffect = this.i;
            if (dashPathEffect == null) {
                dashPathEffect = this.j;
            }
            paint.setPathEffect(dashPathEffect);
        }
        paint.setColor(d());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(c());
        canvas.drawCircle(pointFA.x, pointFA.y, fA, paint);
    }

    public int e() {
        return this.f19551e;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean equalsRemote(c cVar) {
        return equals(cVar) || cVar.getId().equals(getId());
    }

    public boolean f() {
        return this.h;
    }

    public DashPathEffect g() {
        return this.i;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public String getId() {
        if (this.k == null) {
            this.k = com.tencent.mapsdk.rastercore.d.a.a("Circle");
        }
        return this.k;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public float getZIndex() {
        return this.f19552f;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public int hashCodeRemote() {
        return 0;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean isVisible() {
        return this.g;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void remove() {
        this.m.b(getId());
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void setVisible(boolean z) {
        this.g = z;
        this.l.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void setZIndex(float f2) {
        this.f19552f = f2;
        this.m.c();
        this.l.a(false, false);
    }
}
