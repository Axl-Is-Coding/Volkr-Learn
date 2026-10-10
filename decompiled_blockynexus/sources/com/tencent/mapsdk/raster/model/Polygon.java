package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.e.d;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class Polygon implements IOverlay {
    private d polygonDelegate;

    public Polygon(d dVar) {
        this.polygonDelegate = dVar;
    }

    public final boolean contains(LatLng latLng) {
        return this.polygonDelegate.a(latLng);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Polygon) {
            return this.polygonDelegate.equalsRemote(((Polygon) obj).polygonDelegate);
        }
        return false;
    }

    public final int getFillColor() {
        return this.polygonDelegate.b();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final String getId() {
        return this.polygonDelegate.getId();
    }

    public final List<LatLng> getPoints() {
        return this.polygonDelegate.c();
    }

    public final int getStrokeColor() {
        return this.polygonDelegate.d();
    }

    public final float getStrokeWidth() {
        return this.polygonDelegate.a();
    }

    public final float getZIndex() {
        return this.polygonDelegate.getZIndex();
    }

    public final int hashCode() {
        return this.polygonDelegate.hashCodeRemote();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final boolean isVisible() {
        return this.polygonDelegate.isVisible();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final void remove() {
        this.polygonDelegate.remove();
    }

    public final void setFillColor(int i) {
        this.polygonDelegate.a(i);
    }

    public final void setPoints(List<LatLng> list) {
        this.polygonDelegate.a(list);
    }

    public final void setStrokeColor(int i) {
        this.polygonDelegate.b(i);
    }

    public final void setStrokeWidth(float f2) {
        this.polygonDelegate.a(f2);
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final void setVisible(boolean z) {
        this.polygonDelegate.setVisible(z);
    }

    public final void setZIndex(float f2) {
        this.polygonDelegate.setZIndex(f2);
    }
}
