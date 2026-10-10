package c.t.m.g;

import android.location.Location;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class el extends Cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Location f3187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f3191e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f3192f;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: TL */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f3193a = 2;

        static {
            int[] iArr = {1, 2, 3, 4};
        }
    }

    public el(Location location, long j, int i, int i2, int i3, int i4) {
        this.f3187a = location;
        this.f3188b = j;
        this.f3189c = i;
        this.f3190d = i2;
        this.f3191e = i3;
        this.f3192f = i4;
    }

    public final String toString() {
        return "TxGpsInfo [location=" + this.f3187a + ", gpsTime=" + this.f3188b + ", visbleSatelliteNum=" + this.f3189c + ", usedSatelliteNum=" + this.f3190d + ", gpsStatus=" + this.f3191e + "]";
    }
}
