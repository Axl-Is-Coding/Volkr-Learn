package com.tencent.mapsdk.raster.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public final class LatLng implements Cloneable {
    private static DecimalFormat df = new DecimalFormat("0.000000", new DecimalFormatSymbols(Locale.US));
    private final double latitude;
    private final double longitude;

    public LatLng(double d2, double d3) {
        this.longitude = parseDouble((-180.0d > d3 || d3 >= 180.0d) ? ((((d3 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d : d3);
        this.latitude = parseDouble(Math.max(-85.0d, Math.min(85.0d, d2)));
    }

    private static double parseDouble(double d2) {
        return Double.parseDouble(df.format(d2));
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final LatLng m104clone() {
        return new LatLng(this.latitude, this.longitude);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(latLng.latitude) && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(latLng.longitude);
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.latitude);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        return "lat/lng: (" + this.latitude + "," + this.longitude + ")";
    }
}
