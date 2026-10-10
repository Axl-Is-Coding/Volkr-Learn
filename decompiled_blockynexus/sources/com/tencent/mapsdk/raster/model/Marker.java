package com.tencent.mapsdk.raster.model;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mapsdk.rastercore.e.a.c;

/* JADX INFO: loaded from: classes5.dex */
public final class Marker implements IOverlay {
    private c markerDelegate;

    public Marker(c cVar) {
        this.markerDelegate = cVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Marker)) {
            return false;
        }
        return this.markerDelegate.equals(((Marker) obj).markerDelegate);
    }

    public final float getAlpha() {
        return this.markerDelegate.o();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final String getId() {
        return this.markerDelegate.m();
    }

    public final View getMarkerView() {
        return this.markerDelegate.a();
    }

    public final LatLng getPosition() {
        return this.markerDelegate.l();
    }

    public final float getRotation() {
        return this.markerDelegate.j();
    }

    public final String getSnippet() {
        return this.markerDelegate.i();
    }

    public final Object getTag() {
        return this.markerDelegate.p();
    }

    public final String getTitle() {
        return this.markerDelegate.h();
    }

    public final int hashCode() {
        return this.markerDelegate.hashCode();
    }

    public final void hideInfoWindow() {
        this.markerDelegate.g();
    }

    public final boolean isDraggable() {
        return this.markerDelegate.d();
    }

    public final boolean isInfoWindowShown() {
        return this.markerDelegate.e();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final boolean isVisible() {
        return this.markerDelegate.k();
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final void remove() {
        this.markerDelegate.b();
    }

    public final void set2Top() {
        this.markerDelegate.n();
    }

    public final void setAlpha(float f2) {
        this.markerDelegate.b(f2);
    }

    public final void setAnchor(float f2, float f3) {
        this.markerDelegate.a(f2, f3);
    }

    public final void setDraggable(boolean z) {
        this.markerDelegate.b(z);
    }

    public final void setIcon(BitmapDescriptor bitmapDescriptor) {
        this.markerDelegate.a(bitmapDescriptor);
    }

    public final void setInfoWindowHideAnimation(Animation animation) {
        this.markerDelegate.b(animation);
    }

    public final void setInfoWindowShowAnimation(Animation animation) {
        this.markerDelegate.a(animation);
    }

    public final void setMarkerView(View view) {
        this.markerDelegate.a(view);
    }

    public final void setPosition(LatLng latLng) {
        this.markerDelegate.a(latLng);
    }

    public final void setRotation(float f2) {
        this.markerDelegate.a(f2);
    }

    public final void setSnippet(String str) {
        this.markerDelegate.a(str);
    }

    public final void setTag(Object obj) {
        this.markerDelegate.a(obj);
    }

    public final void setTitle(String str) {
        this.markerDelegate.b(str);
    }

    @Override // com.tencent.mapsdk.raster.model.IOverlay
    public final void setVisible(boolean z) {
        this.markerDelegate.a(z);
    }

    public final void showInfoWindow() {
        this.markerDelegate.f();
    }
}
