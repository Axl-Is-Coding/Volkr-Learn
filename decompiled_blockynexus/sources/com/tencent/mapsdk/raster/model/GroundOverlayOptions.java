package com.tencent.mapsdk.raster.model;

import android.os.IBinder;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes5.dex */
public final class GroundOverlayOptions {
    private float anchorU;
    private float anchorV;
    private float bearing;
    private BitmapDescriptor bitmapDescriptor;
    private float height;
    private boolean isVisible;
    private LatLng latLng;
    private LatLngBounds latlngBounds;
    private float transparency;
    private float width;
    private float zIndex;

    public GroundOverlayOptions() {
        this.transparency = WheelView.DividerConfig.FILL;
        this.isVisible = true;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
    }

    protected GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f2, float f3, LatLngBounds latLngBounds, float f4, float f5, boolean z, float f6, float f7, float f8) {
        this.transparency = WheelView.DividerConfig.FILL;
        this.isVisible = true;
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(null);
        this.latLng = latLng;
        this.width = f2;
        this.height = f3;
        this.latlngBounds = latLngBounds;
        this.bearing = f4;
        this.zIndex = f5;
        this.isVisible = z;
        this.transparency = f6;
        this.anchorU = f7;
        this.anchorV = f8;
    }

    public final GroundOverlayOptions anchor(float f2, float f3) {
        this.anchorU = f2;
        this.anchorV = f3;
        return this;
    }

    public final GroundOverlayOptions bearing(float f2) {
        this.bearing = f2;
        return this;
    }

    public final float getAnchorU() {
        return this.anchorU;
    }

    public final float getAnchorV() {
        return this.anchorV;
    }

    public final float getBearing() {
        return this.bearing;
    }

    public final LatLngBounds getBounds() {
        return this.latlngBounds;
    }

    public final float getHeight() {
        return this.height;
    }

    public final BitmapDescriptor getImage() {
        return this.bitmapDescriptor;
    }

    public final LatLng getLocation() {
        return this.latLng;
    }

    public final float getTransparency() {
        return this.transparency;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final GroundOverlayOptions position(LatLng latLng, float f2) {
        return putGroundOverlayOptions(latLng, f2, f2);
    }

    public final GroundOverlayOptions position(LatLng latLng, float f2, float f3) {
        return putGroundOverlayOptions(latLng, f2, f3);
    }

    public final GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        this.latlngBounds = latLngBounds;
        return this;
    }

    protected final GroundOverlayOptions putGroundOverlayOptions(LatLng latLng, float f2, float f3) {
        this.latLng = latLng;
        this.width = f2;
        this.height = f3;
        return this;
    }

    public final GroundOverlayOptions transparency(float f2) {
        this.transparency = f2;
        return this;
    }

    public final GroundOverlayOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final GroundOverlayOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }
}
