package com.tencent.mapsdk.rastercore.e;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.rastercore.d.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class d implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f19593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19594c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19596e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f19597f;
    private float g;
    private f i;
    private com.tencent.mapsdk.rastercore.d.a j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<LatLng> f19592a = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LatLngBounds f19595d = null;
    private String h = getId();

    public d(f fVar, PolygonOptions polygonOptions) {
        this.f19596e = true;
        this.g = WheelView.DividerConfig.FILL;
        this.i = fVar;
        this.j = fVar.e();
        this.f19593b = polygonOptions.getFillColor();
        b(polygonOptions.getPoints());
        this.f19596e = polygonOptions.isVisible();
        this.f19597f = polygonOptions.getStrokeWidth();
        this.g = polygonOptions.getZIndex();
        this.f19594c = polygonOptions.getStrokeColor();
    }

    private void b(List<LatLng> list) {
        LatLngBounds.Builder builder = LatLngBounds.builder();
        this.f19592a.clear();
        if (list != null) {
            Object obj = null;
            for (LatLng latLng : list) {
                if (!latLng.equals(obj)) {
                    this.f19592a.add(latLng);
                    builder.include(latLng);
                    obj = latLng;
                }
            }
            int size = this.f19592a.size();
            if (size > 1) {
                int i = size - 1;
                if (this.f19592a.get(0).equals(this.f19592a.get(i))) {
                    this.f19592a.remove(i);
                }
            }
        }
        this.f19595d = builder.build();
    }

    public float a() {
        return this.f19597f;
    }

    public void a(float f2) {
        this.f19597f = f2;
        this.i.a(false, false);
    }

    public void a(int i) {
        this.f19593b = i;
        this.i.a(false, false);
    }

    public void a(List<LatLng> list) {
        b(list);
        this.i.a(false, false);
    }

    public boolean a(LatLng latLng) {
        return com.tencent.mapsdk.rastercore.f.b.a(latLng, c());
    }

    public int b() {
        return this.f19593b;
    }

    public void b(int i) {
        this.f19594c = i;
        this.i.a(false, false);
    }

    public List<LatLng> c() {
        return this.f19592a;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean checkInBounds() {
        if (this.f19595d == null) {
            return false;
        }
        LatLngBounds latLngBoundsC = this.i.b().c();
        return latLngBoundsC == null || this.f19595d.contains(latLngBoundsC) || this.f19595d.intersects(latLngBoundsC);
    }

    public int d() {
        return this.f19594c;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void destroy() {
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void draw(Canvas canvas) {
        List<LatLng> list = this.f19592a;
        if (list == null || list.size() == 0) {
            return;
        }
        Path path = new Path();
        LatLng latLng = this.f19592a.get(0);
        new PointF();
        PointF pointFA = this.i.b().a(latLng);
        path.moveTo(pointFA.x, pointFA.y);
        for (int i = 1; i < this.f19592a.size(); i++) {
            LatLng latLng2 = this.f19592a.get(i);
            new PointF();
            PointF pointFA2 = this.i.b().a(latLng2);
            path.lineTo(pointFA2.x, pointFA2.y);
        }
        Paint paint = new Paint();
        paint.setColor(b());
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        path.close();
        canvas.drawPath(path, paint);
        if (com.tencent.mapsdk.rastercore.f.b.a(a(), WheelView.DividerConfig.FILL)) {
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(d());
        paint.setStrokeWidth(a());
        canvas.drawPath(path, paint);
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean equalsRemote(c cVar) {
        return equals(cVar) || cVar.getId().equals(getId());
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public String getId() {
        if (this.h == null) {
            this.h = com.tencent.mapsdk.rastercore.d.a.a("Polygon");
        }
        return this.h;
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
        return this.f19596e;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void remove() {
        this.j.b(getId());
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void setVisible(boolean z) {
        this.f19596e = z;
        this.i.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void setZIndex(float f2) {
        this.g = f2;
        this.j.c();
        this.i.a(false, false);
    }
}
