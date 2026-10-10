package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.f.b;

/* JADX INFO: loaded from: classes5.dex */
public class Projection {
    private f mapContext;
    private c projection;

    public Projection(f fVar) {
        this.mapContext = fVar;
        this.projection = fVar.b();
    }

    public double distanceBetween(GeoPoint geoPoint, GeoPoint geoPoint2) {
        return distanceBetween(b.a(geoPoint), b.a(geoPoint2));
    }

    public double distanceBetween(LatLng latLng, LatLng latLng2) {
        return com.tencent.mapsdk.rastercore.c.a(latLng, latLng2);
    }

    public GeoPoint fromPixels(int i, int i2) {
        return b.a(this.projection.a(i, i2));
    }

    public LatLng fromScreenLocation(Point point) {
        return this.projection.a(point.x, point.y);
    }

    public int getLatitudeSpan() {
        LatLngBounds latLngBounds = getVisibleRegion().getLatLngBounds();
        return (int) ((latLngBounds.getNortheast().getLatitude() * 1000000.0d) - (latLngBounds.getSouthwest().getLatitude() * 1000000.0d));
    }

    public int getLongitudeSpan() {
        LatLngBounds latLngBounds = getVisibleRegion().getLatLngBounds();
        return (int) ((latLngBounds.getNortheast().getLongitude() * 1000000.0d) - (latLngBounds.getSouthwest().getLongitude() * 1000000.0d));
    }

    public float getScalePerPixel() {
        return this.projection.f();
    }

    public VisibleRegion getVisibleRegion() {
        int width = this.mapContext.c().getWidth();
        int height = this.mapContext.c().getHeight();
        LatLng latLngFromScreenLocation = fromScreenLocation(new Point(0, 0));
        LatLng latLngFromScreenLocation2 = fromScreenLocation(new Point(width, 0));
        LatLng latLngFromScreenLocation3 = fromScreenLocation(new Point(0, height));
        LatLng latLngFromScreenLocation4 = fromScreenLocation(new Point(width, height));
        return new VisibleRegion(latLngFromScreenLocation3, latLngFromScreenLocation4, latLngFromScreenLocation, latLngFromScreenLocation2, LatLngBounds.builder().include(latLngFromScreenLocation3).include(latLngFromScreenLocation4).include(latLngFromScreenLocation).include(latLngFromScreenLocation2).build());
    }

    public float metersToEquatorPixels(float f2) {
        return this.projection.a(f2);
    }

    public float metersToPixels(double d2, double d3) {
        return this.projection.a(d2, d3);
    }

    public Point toPixels(GeoPoint geoPoint, Point point) {
        if (point == null) {
            point = new Point();
        }
        PointF pointFA = this.projection.a(b.a(geoPoint));
        point.x = (int) pointFA.x;
        point.y = (int) pointFA.y;
        return point;
    }

    public Point toScreenLocation(LatLng latLng) {
        PointF pointFA = this.projection.a(latLng);
        return new Point((int) pointFA.x, (int) pointFA.y);
    }
}
