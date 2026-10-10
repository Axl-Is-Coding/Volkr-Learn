package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.tencent.map.geolocation.TencentLocation;
import java.util.Calendar;

/* JADX INFO: compiled from: TwilightManager.java */
/* JADX INFO: loaded from: classes.dex */
class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static D f243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LocationManager f245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f246d = new a();

    /* JADX INFO: compiled from: TwilightManager.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f247a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f248b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f249c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        long f250d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        long f251e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f252f;

        a() {
        }
    }

    D(Context context, LocationManager locationManager) {
        this.f244b = context;
        this.f245c = locationManager;
    }

    static D a(Context context) {
        if (f243a == null) {
            Context applicationContext = context.getApplicationContext();
            f243a = new D(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f243a;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location locationA = androidx.core.content.c.a(this.f244b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? a(TencentLocation.NETWORK_PROVIDER) : null;
        Location locationA2 = androidx.core.content.c.a(this.f244b, "android.permission.ACCESS_FINE_LOCATION") == 0 ? a("gps") : null;
        return (locationA2 == null || locationA == null) ? locationA2 != null ? locationA2 : locationA : locationA2.getTime() > locationA.getTime() ? locationA2 : locationA;
    }

    private boolean c() {
        return this.f246d.f252f > System.currentTimeMillis();
    }

    boolean a() {
        a aVar = this.f246d;
        if (c()) {
            return aVar.f247a;
        }
        Location locationB = b();
        if (locationB != null) {
            a(locationB);
            return aVar.f247a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location a(String str) {
        try {
            if (this.f245c.isProviderEnabled(str)) {
                return this.f245c.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d("TwilightManager", "Failed to get last known location", e2);
            return null;
        }
    }

    private void a(Location location) {
        long j;
        a aVar = this.f246d;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C cA = C.a();
        cA.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = cA.f240b;
        cA.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = cA.f242d == 1;
        long j3 = cA.f241c;
        long j4 = cA.f240b;
        boolean z2 = z;
        cA.a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = cA.f241c;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + jCurrentTimeMillis;
        } else {
            j = (jCurrentTimeMillis > j4 ? 0 + j5 : jCurrentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
        }
        aVar.f247a = z2;
        aVar.f248b = j2;
        aVar.f249c = j3;
        aVar.f250d = j4;
        aVar.f251e = j5;
        aVar.f252f = j;
    }
}
