package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.e.e;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class Polyline implements IOverlay {
    private final e polylineDelegate;

    public Polyline(e eVar) {
        this.polylineDelegate = eVar;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Polyline) {
            return this.polylineDelegate.equalsRemote(((Polyline) obj).polylineDelegate);
        }
        return false;
    }

    public int getColor() {
        return this.polylineDelegate.b();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public String getId() {
        return this.polylineDelegate.getId();
    }

    public List<LatLng> getPoints() {
        return this.polylineDelegate.c();
    }

    public float getWidth() {
        return this.polylineDelegate.a();
    }

    public float getZIndex() {
        return this.polylineDelegate.getZIndex();
    }

    public final int hashCode() {
        return this.polylineDelegate.hashCodeRemote();
    }

    public boolean isDottedLine() {
        return this.polylineDelegate.d();
    }

    public boolean isGeodesic() {
        return this.polylineDelegate.e();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public boolean isVisible() {
        return this.polylineDelegate.isVisible();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public void remove() {
        this.polylineDelegate.remove();
    }

    public void setColor(int i) {
        this.polylineDelegate.a(i);
    }

    public void setDottedLine(boolean z) {
        this.polylineDelegate.a(z);
    }

    public void setGeodesic(boolean z) {
        if (this.polylineDelegate.e() != z) {
            List<LatLng> points = getPoints();
            this.polylineDelegate.b(z);
            setPoints(points);
        }
    }

    public void setPoints(List<LatLng> list) {
        this.polylineDelegate.a(list);
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public void setVisible(boolean z) {
        this.polylineDelegate.setVisible(z);
    }

    public void setWidth(float f2) {
        this.polylineDelegate.a(f2);
    }

    public void setZIndex(float f2) {
        this.polylineDelegate.setZIndex(f2);
    }
}
