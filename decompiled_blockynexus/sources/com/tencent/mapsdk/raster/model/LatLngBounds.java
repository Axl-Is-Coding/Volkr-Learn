package com.tencent.mapsdk.raster.model;

import com.tencent.mapsdk.rastercore.f.b;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class LatLngBounds {
    private int mVersionCode;
    private LatLng northeast;
    private LatLng southwest;

    public static final class Builder {
        private double mSouth = Double.POSITIVE_INFINITY;
        private double mNorth = Double.NEGATIVE_INFINITY;
        private double mWest = Double.NaN;
        private double mEast = Double.NaN;

        private boolean containsLongitude(double d2) {
            double d3 = this.mWest;
            double d4 = this.mEast;
            return d3 <= d4 ? d3 <= d2 && d2 <= d4 : d3 <= d2 || d2 <= d4;
        }

        public final LatLngBounds build() {
            return new LatLngBounds(new LatLng(this.mSouth, this.mWest), new LatLng(this.mNorth, this.mEast));
        }

        public final Builder include(LatLng latLng) {
            this.mSouth = Math.min(this.mSouth, latLng.getLatitude());
            this.mNorth = Math.max(this.mNorth, latLng.getLatitude());
            double longitude = latLng.getLongitude();
            if (!Double.isNaN(this.mWest)) {
                if (!containsLongitude(longitude)) {
                    if (LatLngBounds.longitudeDistanceHeadingWest(this.mWest, longitude) < LatLngBounds.longitudeDistanceHeadingEast(this.mEast, longitude)) {
                        this.mWest = longitude;
                    }
                }
                return this;
            }
            this.mWest = longitude;
            this.mEast = longitude;
            return this;
        }

        public final Builder include(Iterable<LatLng> iterable) {
            if (iterable != null) {
                Iterator<LatLng> it = iterable.iterator();
                while (it.hasNext()) {
                    include(it.next());
                }
            }
            return this;
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        Builder builderInclude = new Builder().include(latLng).include(latLng2);
        this.southwest = new LatLng(builderInclude.mSouth, builderInclude.mWest);
        this.northeast = new LatLng(builderInclude.mNorth, builderInclude.mEast);
        this.mVersionCode = i;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    public static Builder builder() {
        return new Builder();
    }

    private boolean containsLatitude(double d2) {
        return this.southwest.getLatitude() <= d2 && d2 <= this.northeast.getLatitude();
    }

    private boolean containsLongitude(double d2) {
        return this.southwest.getLongitude() <= this.northeast.getLongitude() ? this.southwest.getLongitude() <= d2 && d2 <= this.northeast.getLongitude() : this.southwest.getLongitude() <= d2 || d2 <= this.northeast.getLongitude();
    }

    private boolean intersect(LatLngBounds latLngBounds) {
        LatLng latLng;
        if (latLngBounds != null && (latLng = latLngBounds.northeast) != null && latLngBounds.southwest != null && this.northeast != null && this.southwest != null) {
            double longitude = ((latLng.getLongitude() + latLngBounds.southwest.getLongitude()) - this.northeast.getLongitude()) - this.southwest.getLongitude();
            double longitude2 = ((this.northeast.getLongitude() - this.southwest.getLongitude()) + latLngBounds.northeast.getLongitude()) - latLngBounds.southwest.getLongitude();
            double latitude = ((latLngBounds.northeast.getLatitude() + latLngBounds.southwest.getLatitude()) - this.northeast.getLatitude()) - this.southwest.getLatitude();
            double latitude2 = ((this.northeast.getLatitude() - this.southwest.getLatitude()) + latLngBounds.northeast.getLatitude()) - latLngBounds.southwest.getLatitude();
            if (Math.abs(longitude) < longitude2 && Math.abs(latitude) < latitude2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double longitudeDistanceHeadingEast(double d2, double d3) {
        return ((d3 - d2) + 360.0d) % 360.0d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double longitudeDistanceHeadingWest(double d2, double d3) {
        return ((d2 - d3) + 360.0d) % 360.0d;
    }

    public boolean contains(LatLng latLng) {
        return containsLatitude(latLng.getLatitude()) && containsLongitude(latLng.getLongitude());
    }

    public boolean contains(LatLngBounds latLngBounds) {
        return latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getNortheast() {
        return this.northeast;
    }

    public LatLng getSouthwest() {
        return this.southwest;
    }

    int getVersionCode() {
        return this.mVersionCode;
    }

    public final int hashCode() {
        return b.a(new Object[]{this.southwest, this.northeast});
    }

    public LatLngBounds including(LatLng latLng) {
        double dMin = Math.min(this.southwest.getLatitude(), latLng.getLatitude());
        double dMax = Math.max(this.northeast.getLatitude(), latLng.getLatitude());
        double longitude = this.northeast.getLongitude();
        double longitude2 = this.southwest.getLongitude();
        double longitude3 = latLng.getLongitude();
        if (!containsLongitude(longitude3)) {
            if (longitudeDistanceHeadingWest(longitude2, longitude3) < longitudeDistanceHeadingEast(longitude, longitude3)) {
                longitude2 = longitude3;
            } else {
                longitude = longitude3;
            }
        }
        return new LatLngBounds(new LatLng(dMin, longitude2), new LatLng(dMax, longitude));
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        return intersect(latLngBounds) || latLngBounds.intersect(this);
    }

    public final String toString() {
        return b.a(b.a("southwest", this.southwest), b.a("northeast", this.northeast));
    }
}
