package c.t.m.g;

import android.content.Context;
import android.telephony.TelephonyManager;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Tb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Tb f3015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f3016b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f3017c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f3018d = 1;

    public static Tb a() {
        if (f3015a == null) {
            f3015a = new Tb();
        }
        return f3015a;
    }

    private static boolean b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            if (telephonyManager.getSimState() == 5) {
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:6|(2:65|7)|(5:9|63|10|(2:12|(12:14|61|20|(12:67|22|59|25|(1:27)(1:28)|(1:33)|(1:35)|(1:37)|(1:39)|(1:41)|(1:43)|(1:(2:46|(2:48|(1:72)(2:51|69))(2:52|70))(2:53|71))(2:54|55))(1:30)|31|(0)|(0)|(0)|(0)|(0)|(0)|(0)(0)))|15)(1:16)|17|61|20|(0)(0)|31|(0)|(0)|(0)|(0)|(0)|(0)|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r9) {
        /*
            java.lang.String r0 = "gps"
            if (r9 != 0) goto L6
            r9 = -1
            return r9
        L6:
            boolean r1 = b(r9)
            r2 = 1
            r3 = 0
            java.lang.String r4 = "wifi"
            java.lang.Object r4 = r9.getSystemService(r4)     // Catch: java.lang.Throwable -> L30
            android.net.wifi.WifiManager r4 = (android.net.wifi.WifiManager) r4     // Catch: java.lang.Throwable -> L30
            if (r4 == 0) goto L2b
            boolean r5 = r4.isWifiEnabled()     // Catch: java.lang.Throwable -> L30
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L31
            r7 = 18
            if (r6 < r7) goto L29
            boolean r4 = r4.isScanAlwaysAvailable()     // Catch: java.lang.Throwable -> L31
            if (r4 == 0) goto L29
            r4 = 1
            r6 = 1
            goto L33
        L29:
            r4 = 1
            goto L2d
        L2b:
            r4 = 0
            r5 = 0
        L2d:
            r6 = r4
            r4 = 0
            goto L33
        L30:
            r5 = 0
        L31:
            r4 = 0
            r6 = 0
        L33:
            java.lang.String r7 = "location"
            java.lang.Object r7 = r9.getSystemService(r7)     // Catch: java.lang.Exception -> L5a
            android.location.LocationManager r7 = (android.location.LocationManager) r7     // Catch: java.lang.Exception -> L5a
            if (r7 == 0) goto L5a
            android.content.ContentResolver r9 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L48
            java.lang.String r8 = "location_mode"
            int r9 = android.provider.Settings.Secure.getInt(r9, r8)     // Catch: java.lang.Throwable -> L48
            goto L49
        L48:
            r9 = 0
        L49:
            boolean r8 = r7.isProviderEnabled(r0)     // Catch: java.lang.Exception -> L5b
            java.util.List r7 = r7.getAllProviders()     // Catch: java.lang.Exception -> L5b
            if (r7 != 0) goto L55
            r0 = 0
            goto L5d
        L55:
            boolean r0 = r7.contains(r0)     // Catch: java.lang.Exception -> L5b
            goto L5d
        L5a:
            r9 = 0
        L5b:
            r0 = 0
            r8 = 0
        L5d:
            if (r1 != 0) goto L60
            r3 = 1
        L60:
            if (r5 != 0) goto L64
            int r3 = r3 + 2
        L64:
            if (r8 != 0) goto L68
            int r3 = r3 + 4
        L68:
            if (r6 != 0) goto L6c
            int r3 = r3 + 8
        L6c:
            if (r0 != 0) goto L70
            int r3 = r3 + 16
        L70:
            if (r4 != 0) goto L74
            int r3 = r3 + 32
        L74:
            if (r9 == 0) goto L88
            if (r9 == r2) goto L85
            r0 = 2
            if (r9 == r0) goto L82
            r0 = 3
            if (r9 == r0) goto L7f
            goto L8a
        L7f:
            int r3 = r3 + 512
            goto L8a
        L82:
            int r3 = r3 + 256
            goto L8a
        L85:
            int r3 = r3 + 128
            goto L8a
        L88:
            int r3 = r3 + 64
        L8a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.g.Tb.a(android.content.Context):int");
    }
}
