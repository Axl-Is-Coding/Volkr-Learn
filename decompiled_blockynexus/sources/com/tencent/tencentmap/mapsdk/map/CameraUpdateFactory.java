package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.c;
import com.tencent.mapsdk.rastercore.c.d;
import com.tencent.mapsdk.rastercore.c.f;
import com.tencent.mapsdk.rastercore.c.g;
import com.tencent.mapsdk.rastercore.c.h;

/* JADX INFO: loaded from: classes5.dex */
public final class CameraUpdateFactory {
    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        return new CameraUpdate(c.a(cameraPosition));
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        return new CameraUpdate(c.a(CameraPosition.builder().target(latLng).build()));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i) {
        return new CameraUpdate(c.a(latLngBounds, 0, 0, i));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i, int i2, int i3) {
        return new CameraUpdate(c.a(latLngBounds, i, i2, i3));
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f2) {
        return new CameraUpdate(c.a(CameraPosition.builder().target(latLng).zoom(f2).build()));
    }

    public static CameraUpdate scrollBy(float f2, float f3) {
        d dVar = new d();
        dVar.a(f2);
        dVar.b(f3);
        return new CameraUpdate(dVar);
    }

    public static CameraUpdate zoomBy(float f2) {
        return new CameraUpdate(c.a(f2, (Point) null));
    }

    public static CameraUpdate zoomBy(float f2, Point point) {
        return new CameraUpdate(c.a(f2, point));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(new f());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(new g());
    }

    public static CameraUpdate zoomTo(float f2) {
        h hVar = new h();
        hVar.a(f2);
        return new CameraUpdate(hVar);
    }
}
