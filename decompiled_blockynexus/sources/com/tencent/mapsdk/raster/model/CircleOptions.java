package com.tencent.mapsdk.raster.model;

import android.graphics.DashPathEffect;
import android.os.Bundle;
import android.os.Parcel;
import cn.qqtheme.framework.widget.WheelView;
import com.umeng.analytics.pro.b;

/* JADX INFO: loaded from: classes5.dex */
public final class CircleOptions {
    private String id;
    private int strokeColor = -16777216;
    private float strokeWidth = 10.0f;
    private boolean isVisible = true;
    private double radius = 0.0d;
    private float zIndex = WheelView.DividerConfig.FILL;
    private LatLng point = null;
    private int fillColor = 0;
    private boolean strokeDash = false;
    private DashPathEffect dashPathEffect = null;

    public final CircleOptions center(LatLng latLng) {
        this.point = latLng;
        return this;
    }

    public final int describeContents() {
        return 0;
    }

    public final CircleOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final LatLng getCenter() {
        return this.point;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final double getRadius() {
        return this.radius;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final boolean getStrokeDash() {
        return this.strokeDash;
    }

    public final DashPathEffect getStrokeDashPathEffect() {
        return this.dashPathEffect;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final CircleOptions radius(double d2) {
        this.radius = d2;
        return this;
    }

    public final CircleOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final CircleOptions strokeDash(boolean z) {
        this.strokeDash = z;
        return this;
    }

    public final CircleOptions strokeDashPathEffect(DashPathEffect dashPathEffect) {
        this.dashPathEffect = dashPathEffect;
        return this;
    }

    public final CircleOptions strokeWidth(float f2) {
        this.strokeWidth = f2;
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        LatLng latLng = this.point;
        if (latLng != null) {
            bundle.putDouble(b.B, latLng.getLatitude());
            bundle.putDouble(b.C, this.point.getLongitude());
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.radius);
        parcel.writeFloat(this.strokeWidth);
        parcel.writeInt(this.strokeColor);
        parcel.writeInt(this.fillColor);
        parcel.writeFloat(this.zIndex);
        parcel.writeByte(this.isVisible ? (byte) 1 : (byte) 0);
        parcel.writeString(this.id);
    }

    public final CircleOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }
}
