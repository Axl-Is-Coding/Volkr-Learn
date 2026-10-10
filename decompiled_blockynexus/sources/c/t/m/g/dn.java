package c.t.m.g;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.tencent.map.geolocation.TencentGeofence;
import java.util.Locale;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TencentGeofence f3118a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f3120c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f3121d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PendingIntent f3122e;
    public Object h;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3123f = 0;
    public double g = Double.MAX_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Location f3119b = new Location("");

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: TL */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f3124a = new a("NETWORK_NONE", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f3125b = new a("NETWORK_MOBILE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f3126c = new a("NETWORK_WIFI", 2);

        static {
            a[] aVarArr = {f3124a, f3125b, f3126c};
        }

        private a(String str, int i) {
        }
    }

    public dn(TencentGeofence tencentGeofence, long j, String str, PendingIntent pendingIntent) {
        this.f3118a = tencentGeofence;
        this.f3120c = j;
        this.f3121d = str;
        this.f3122e = pendingIntent;
        this.f3119b.setLatitude(tencentGeofence.getLatitude());
        this.f3119b.setLongitude(tencentGeofence.getLongitude());
        this.f3119b.setTime(0L);
        this.f3119b.setSpeed(-0.001f);
    }

    @SuppressLint({"MissingPermission"})
    @Deprecated
    public static a a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return Build.VERSION.SDK_INT >= 16 ? connectivityManager.isActiveNetworkMetered() ? a.f3125b : a.f3126c : 1 == activeNetworkInfo.getType() ? a.f3126c : a.f3125b;
            }
            return a.f3124a;
        } catch (Throwable unused) {
            return a.f3124a;
        }
    }

    public final String toString() {
        int i = this.f3123f;
        return String.format(Locale.US, "%s dist=%5gm speed=%.2fm/s state=%s", this.f3118a.toString(), Double.valueOf(this.g), Float.valueOf(a()), i != 1 ? i != 2 ? "?" : "OUT" : "IN");
    }

    public final float a() {
        float speed = this.f3119b.getSpeed();
        if (speed <= -0.001f) {
            return -0.001f;
        }
        if (speed > 25.0f) {
            return 25.0f;
        }
        if (speed < 1.0f) {
            return 1.0f;
        }
        return speed;
    }
}
