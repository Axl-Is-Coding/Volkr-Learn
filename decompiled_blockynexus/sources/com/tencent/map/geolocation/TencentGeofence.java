package com.tencent.map.geolocation;

import android.os.SystemClock;
import android.text.TextUtils;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Locale;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes5.dex */
public class TencentGeofence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f19386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f19387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f19388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f19389d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f19390e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f19391f;
    private final long g;

    /* JADX INFO: compiled from: TL */
    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private double f19392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private double f19393b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f19394c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f19395d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f19396e;

        public TencentGeofence build() {
            return new TencentGeofence(this.f19392a, this.f19393b, this.f19394c, this.f19395d, this.f19396e, (byte) 0);
        }

        public Builder setCircularRegion(double d2, double d3, float f2) {
            if (f2 <= WheelView.DividerConfig.FILL) {
                throw new IllegalArgumentException("invalid radius: ".concat(String.valueOf(f2)));
            }
            if (d2 > 90.0d || d2 < -90.0d) {
                throw new IllegalArgumentException("invalid latitude: ".concat(String.valueOf(d2)));
            }
            if (d3 > 180.0d || d3 < -180.0d) {
                throw new IllegalArgumentException("invalid longitude: ".concat(String.valueOf(d3)));
            }
            this.f19392a = d2;
            this.f19393b = d3;
            this.f19394c = f2;
            return this;
        }

        public Builder setExpirationDuration(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("invalid duration: ".concat(String.valueOf(j)));
            }
            this.f19395d = j;
            return this;
        }

        public Builder setTag(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new NullPointerException();
            }
            this.f19396e = str;
            return this;
        }
    }

    /* synthetic */ TencentGeofence(double d2, double d3, float f2, long j, String str, byte b2) {
        this(d2, d3, f2, j, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TencentGeofence.class != obj.getClass()) {
            return false;
        }
        TencentGeofence tencentGeofence = (TencentGeofence) obj;
        if (Double.doubleToLongBits(this.f19387b) != Double.doubleToLongBits(tencentGeofence.f19387b) || Double.doubleToLongBits(this.f19388c) != Double.doubleToLongBits(tencentGeofence.f19388c)) {
            return false;
        }
        String str = this.f19391f;
        if (str == null) {
            if (tencentGeofence.f19391f != null) {
                return false;
            }
        } else if (!str.equals(tencentGeofence.f19391f)) {
            return false;
        }
        return true;
    }

    public long getDuration() {
        return this.g;
    }

    public long getExpireAt() {
        return this.f19390e;
    }

    public double getLatitude() {
        return this.f19387b;
    }

    public double getLongitude() {
        return this.f19388c;
    }

    public float getRadius() {
        return this.f19389d;
    }

    public String getTag() {
        return this.f19391f;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f19387b);
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f19388c);
        int i = (((((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31) * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)))) * 31;
        String str = this.f19391f;
        return i + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        Locale locale = Locale.US;
        double dElapsedRealtime = this.f19390e - SystemClock.elapsedRealtime();
        Double.isNaN(dElapsedRealtime);
        return String.format(locale, "TencentGeofence[tag=%s, type=%s, loc=(%.6f, %.6f), radius=%.2fm life=%.2fs]", this.f19391f, "CIRCLE", Double.valueOf(this.f19387b), Double.valueOf(this.f19388c), Float.valueOf(this.f19389d), Double.valueOf(dElapsedRealtime / 1000.0d));
    }

    private TencentGeofence(double d2, double d3, float f2, long j, String str) {
        this.f19386a = 0;
        this.f19387b = d2;
        this.f19388c = d3;
        this.f19389d = f2;
        this.g = j;
        this.f19390e = SystemClock.elapsedRealtime() + j;
        this.f19391f = str;
    }
}
