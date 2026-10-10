package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ko, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1730Ko {
    public static byte[] A00;
    public static String[] A01;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 60);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{-47, -17, -4, -75, 2, -82, 1, 2, -17, 0, 2, -82, -49, 3, -14, -9, -13, -4, -15, -13, -36, -13, 2, 5, -3, 0, -7, -49, -15, 2, -9, 4, -9, 2, 7, -68, -82, -37, -17, -7, -13, -82, 1, 3, 0, -13, -82, 2, -10, -17, 2, -82, -9, 2, -75, 1, -82, -9, -4, -82, 7, -3, 3, 0, -82, -49, -4, -14, 0, -3, -9, -14, -37, -17, -4, -9, -12, -13, 1, 2, -68, 6, -5, -6, -82, -12, -9, -6, -13, -68, -15, -19, -20, 32, ci.m, 20, ci.n, 25, ci.l, ci.n, -7, ci.n, 31, 34, 26, 29, 22, -26, -13, -28, -26, -24, -7, -18, -5, -18, -7, -2, 24, 37, 27, 41, 38, 32, 27, -27, 32, 37, 43, 28, 37, 43, -27, 24, 26, 43, 32, 38, 37, -27, ci.k, 0, -4, ci.l, -60, -47, -57, -43, -46, -52, -57, -111, -52, -47, -41, -56, -47, -41, -111, -58, -60, -41, -56, -54, -46, -43, -36, -111, -91, -75, -78, -70, -74, -92, -91, -81, -88, -32, -16, -19, -11, -15, -29, -16, -45, -48, -54, -23, -14, -17, -21, -12, -6, -38, -11, -15, -21, -12, -82, -70, -72, 121, -84, -71, -81, -67, -70, -76, -81, 121, -83, -67, -70, -62, -66, -80, -67, 121, -84, -69, -69, -73, -76, -82, -84, -65, -76, -70, -71, -86, -76, -81, -56, -44, -46, -109, -58, -45, -55, -41, -44, -50, -55, -109, -37, -54, -45, -55, -50, -45, -52, -47, -32, -45, -49, -30, -45, -51, -36, -45, -27, -51, -30, -49, -48, -25, -32, -19, -29, -21, -28, -15, -45, -24, -20, -28, -84, -72, -72, -76, -11, 1, 1, -3, -57, -68, -68, -3, -7, -18, 6, -69, -12, -4, -4, -12, -7, -14, -69, -16, -4, -6, -68, 0, 1, -4, -1, -14, -68, -18, -3, -3, 0, -68, -70, -58, -58, -62, -59, -68, -80, -63, -70, -76, -61, -26, -30, -41, -17, -92, -35, -27, -27, -35, -30, -37, -92, -39, -27, -29, -53, -66, -70, -52, -87, -50, -59, -70};
    }

    public static void A04() {
        A01 = new String[]{"HfGv3264Bq2TQ34NqRtE4P30TXR", "AZVpgJ8fi5FDz5AiC", "FCmmf0GU", "NGZF99o8OEHjBvmOxlLxN", "MEp80XUn5zKurDhCJ73", "hVp2plT6ulDLwck", "CErebgOhZelO8plRL7vU3", "v0a34uu5Y8rm3tpqkSr554RtUBdvL4ru"};
    }

    private Intent A00(Uri uri) {
        Intent intent = new Intent(A02(118, 26, 123), uri);
        intent.setComponent(null);
        if (Build.VERSION.SDK_INT >= 15) {
            intent.setSelector(null);
        }
        return intent;
    }

    private Intent A01(C2026Wb c2026Wb, Uri uri) {
        Intent intentA00 = A00(uri);
        intentA00.addCategory(A02(144, 33, 39));
        intentA00.addFlags(268435456);
        intentA00.putExtra(A02(198, 34, 15), c2026Wb.getPackageName());
        intentA00.putExtra(A02(251, 14, 50), false);
        return intentA00;
    }

    private void A05(C2026Wb c2026Wb, Uri uri) {
        C1725Kh.A0C(c2026Wb, A01(c2026Wb, uri));
    }

    private final void A06(C2026Wb c2026Wb, Uri uri) throws Kn {
        if (A0B(c2026Wb)) {
            Intent intentA01 = A01(c2026Wb, uri);
            intentA01.setPackage(A02(232, 19, 41));
            C1725Kh.A0C(c2026Wb, intentA01);
            return;
        }
        throw new Kn();
    }

    private void A07(C2026Wb c2026Wb, Uri uri, String str) {
        AdActivityIntent adActivityIntentA04 = C1725Kh.A04(c2026Wb);
        adActivityIntentA04.addFlags(268435456);
        adActivityIntentA04.putExtra(A02(340, 8, 25), KC.A02);
        adActivityIntentA04.putExtra(A02(177, 10, 66), uri.toString());
        adActivityIntentA04.putExtra(A02(187, 11, 74), str);
        adActivityIntentA04.putExtra(A02(265, 11, 67), System.currentTimeMillis());
        try {
            C1725Kh.A0A(c2026Wb, adActivityIntentA04);
        } catch (ActivityNotFoundException e2) {
            c2026Wb.A04().A8H(A02(107, 11, 73), C8Y.A05, new C8Z(e2));
            Log.e(A02(90, 17, 111), A02(0, 90, 82), e2);
        }
    }

    private final void A08(C2026Wb c2026Wb, Uri uri, String str) {
        boolean zA05 = C1694Iz.A05(c2026Wb);
        if (A0A(uri) && zA05) {
            A07(c2026Wb, uri, str);
        } else {
            c2026Wb.A0A().A7V(zA05);
            A05(c2026Wb, uri);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A09(com.facebook.ads.redexgen.X.C1730Ko r5, com.facebook.ads.redexgen.X.C2026Wb r6, android.net.Uri r7, java.lang.String r8) {
        /*
            boolean r0 = A0A(r7)
            if (r0 == 0) goto L31
            java.lang.String r3 = r7.getHost()
            r2 = 325(0x145, float:4.55E-43)
            r1 = 15
            r0 = 58
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L31
            r4 = 1
        L1b:
            java.lang.String r3 = r7.getScheme()
            r2 = 319(0x13f, float:4.47E-43)
            r1 = 6
            r0 = 19
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L33
            if (r4 == 0) goto L3b
            goto L33
        L31:
            r4 = 0
            goto L1b
        L33:
            r5.A06(r6, r7)     // Catch: com.facebook.ads.redexgen.X.Kn -> L37
            goto L3e
        L37:
            r5.A08(r6, r7, r8)
            goto L3e
        L3b:
            r5.A08(r6, r7, r8)
        L3e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1730Ko.A09(com.facebook.ads.redexgen.X.Ko, com.facebook.ads.redexgen.X.Wb, android.net.Uri, java.lang.String):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0A(android.net.Uri r5) {
        /*
            int r1 = android.os.Build.VERSION.SDK_INT
            r4 = 0
            r0 = 24
            if (r1 < r0) goto L3d
            android.security.NetworkSecurityPolicy r0 = android.security.NetworkSecurityPolicy.getInstance()
            boolean r3 = r0.isCleartextTrafficPermitted()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1730Ko.A01
            r0 = 1
            r1 = r2[r0]
            r0 = 4
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L66
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C1730Ko.A01
            java.lang.String r1 = "9DaYNTGnU6m41BFJKxw5hEDOoLHVmNBK"
            r0 = 7
            r2[r0] = r1
            java.lang.String r1 = "9DaYNTGnU6m41BFJKxw5hEDOoLHVmNBK"
            r0 = 7
            r2[r0] = r1
            if (r3 != 0) goto L3d
            android.security.NetworkSecurityPolicy r1 = android.security.NetworkSecurityPolicy.getInstance()
            java.lang.String r0 = r5.getHost()
            boolean r0 = r1.isCleartextTrafficPermitted(r0)
            if (r0 == 0) goto L64
        L3d:
            r0 = 1
        L3e:
            java.lang.String r3 = r5.getScheme()
            if (r0 == 0) goto L53
            r2 = 276(0x114, float:3.87E-43)
            r1 = 4
            r0 = 8
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 != 0) goto L62
        L53:
            r2 = 314(0x13a, float:4.4E-43)
            r1 = 5
            r0 = 22
            java.lang.String r0 = A02(r2, r1, r0)
            boolean r0 = r0.equalsIgnoreCase(r3)
            if (r0 == 0) goto L63
        L62:
            r4 = 1
        L63:
            return r4
        L64:
            r0 = 0
            goto L3e
        L66:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C1730Ko.A0A(android.net.Uri):boolean");
    }

    private boolean A0B(C2026Wb c2026Wb) {
        for (ResolveInfo appInfo : c2026Wb.getPackageManager().queryIntentActivities(new Intent(A02(118, 26, 123), Uri.parse(A02(280, 34, 81))), 0)) {
            if (appInfo.activityInfo.applicationInfo.packageName.equals(A02(232, 19, 41))) {
                return true;
            }
        }
        return false;
    }
}
