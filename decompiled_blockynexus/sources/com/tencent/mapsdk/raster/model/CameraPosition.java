package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mapsdk.rastercore.f.b;

/* JADX INFO: loaded from: classes5.dex */
public final class CameraPosition implements Parcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new Parcelable.Creator<CameraPosition>() { // from class: com.tencent.mapsdk.raster.model.CameraPosition.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraPosition createFromParcel(Parcel parcel) {
            return new CameraPosition(new LatLng(parcel.readFloat(), parcel.readFloat()), parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final CameraPosition[] newArray(int i) {
            return new CameraPosition[i];
        }
    };
    private static final int EMPTY_ZOOMLEVEL = -1;
    private final LatLng target;
    private float zoom;

    public static final class Builder {
        private LatLng target;
        private float zoom = -1.0f;

        public Builder() {
        }

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.getTarget()).zoom(cameraPosition.getZoom());
        }

        public final CameraPosition build() {
            return new CameraPosition(this.target, this.zoom);
        }

        public final Builder target(LatLng latLng) {
            this.target = latLng;
            return this;
        }

        public final Builder zoom(float f2) {
            this.zoom = f2;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f2) {
        this.zoom = -1.0f;
        this.target = latLng;
        this.zoom = f2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f2) {
        return new CameraPosition(latLng, f2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return getTarget().equals(cameraPosition.getTarget()) && Float.floatToIntBits(getZoom()) == Float.floatToIntBits(cameraPosition.getZoom());
    }

    public final LatLng getTarget() {
        return this.target;
    }

    public final float getZoom() {
        return this.zoom;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return b.a(b.a("target", getTarget()), b.a("zoom", Float.valueOf(getZoom())));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat((float) getTarget().getLatitude());
        parcel.writeFloat((float) getTarget().getLongitude());
        parcel.writeFloat(getZoom());
    }
}
