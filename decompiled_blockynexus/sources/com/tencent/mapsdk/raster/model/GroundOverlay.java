package com.tencent.mapsdk.raster.model;

import android.os.RemoteException;
import com.tencent.mapsdk.rastercore.e.b;

/* JADX INFO: loaded from: classes5.dex */
public final class GroundOverlay implements IOverlay {
    private b iGroundOverlayDelegate;

    public GroundOverlay(b bVar) {
        this.iGroundOverlayDelegate = bVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GroundOverlay)) {
            return false;
        }
        try {
            throw new RemoteException();
        } catch (RemoteException unused) {
            return false;
        }
    }

    public final float getBearing() {
        return this.iGroundOverlayDelegate.e();
    }

    protected final LatLngBounds getBounds() {
        return this.iGroundOverlayDelegate.d();
    }

    protected final float getHeight() {
        return this.iGroundOverlayDelegate.c();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final String getId() {
        return this.iGroundOverlayDelegate.getId();
    }

    protected final LatLng getPosition() {
        return this.iGroundOverlayDelegate.a();
    }

    protected final float getTransparency() {
        return this.iGroundOverlayDelegate.f();
    }

    protected final float getWidth() {
        return this.iGroundOverlayDelegate.b();
    }

    public final float getZIndex() {
        return this.iGroundOverlayDelegate.getZIndex();
    }

    public final int hashCode() {
        return this.iGroundOverlayDelegate.hashCode();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final boolean isVisible() {
        return this.iGroundOverlayDelegate.isVisible();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final void remove() {
        this.iGroundOverlayDelegate.remove();
    }

    public final void setAnchor(float f2, float f3) {
        this.iGroundOverlayDelegate.b(f2, f3);
    }

    public final void setBearing(float f2) {
        this.iGroundOverlayDelegate.b(f2);
    }

    protected final void setDimensions(float f2) {
        this.iGroundOverlayDelegate.a(f2);
    }

    protected final void setDimensions(float f2, float f3) {
        this.iGroundOverlayDelegate.a(f2, f3);
    }

    protected final void setImage(BitmapDescriptor bitmapDescriptor) {
        this.iGroundOverlayDelegate.a(bitmapDescriptor);
    }

    protected final void setPosition(LatLng latLng) {
        this.iGroundOverlayDelegate.a(latLng);
    }

    protected final void setPositionFromBounds(LatLngBounds latLngBounds) {
        this.iGroundOverlayDelegate.a(latLngBounds);
    }

    protected final void setTransparency(float f2) {
        this.iGroundOverlayDelegate.c(f2);
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final void setVisible(boolean z) {
        this.iGroundOverlayDelegate.setVisible(z);
    }

    public final void setZIndex(float f2) {
        this.iGroundOverlayDelegate.setZIndex(f2);
    }
}
