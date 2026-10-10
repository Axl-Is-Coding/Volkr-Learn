package com.tencent.mapsdk.raster.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes5.dex */
public class GeoPoint implements Parcelable {
    public static final Parcelable.Creator<GeoPoint> CREATOR = new Parcelable.Creator<GeoPoint>() { // from class: com.tencent.mapsdk.raster.model.GeoPoint.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GeoPoint createFromParcel(Parcel parcel) {
            return new GeoPoint(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final GeoPoint[] newArray(int i) {
            return new GeoPoint[i];
        }
    };
    private int e6Lat;
    private int e6Lon;

    public GeoPoint(int i, int i2) {
        this.e6Lat = 0;
        this.e6Lon = 0;
        this.e6Lat = i;
        this.e6Lon = i2;
    }

    private GeoPoint(Parcel parcel) {
        this.e6Lat = 0;
        this.e6Lon = 0;
        this.e6Lat = parcel.readInt();
        this.e6Lon = parcel.readInt();
    }

    public GeoPoint Copy() {
        return new GeoPoint(this.e6Lat, this.e6Lon);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != GeoPoint.class) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        return this.e6Lat == geoPoint.e6Lat && this.e6Lon == geoPoint.e6Lon;
    }

    public int getLatitudeE6() {
        return this.e6Lat;
    }

    public int getLongitudeE6() {
        return this.e6Lon;
    }

    public final int hashCode() {
        return (this.e6Lon * 7) + (this.e6Lat * 11);
    }

    public void setLatitudeE6(int i) {
        this.e6Lat = i;
    }

    public void setLongitudeE6(int i) {
        this.e6Lon = i;
    }

    public final String toString() {
        return this.e6Lat + "," + this.e6Lon;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.e6Lat);
        parcel.writeInt(this.e6Lon);
    }
}
