package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.app.KeyguardManager;
import android.util.Log;
import android.view.Window;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1757Lp {
    public static byte[] A00;
    public static String[] A01;
    public static final String A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 115);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{75, 44, 126, 67, 88, 94, 75, 79, 82, 84, 85, 27, 82, 85, 27, 76, 82, 85, 95, 84, 76, 27, 82, 85, 93, 84, 27, 88, 83, 94, 88, 80, 28, 18, ci.l, ci.n, 2, 22, 5, 19, 119, 123, 110, 115, 104, 114, 106, 120, 10, 27, 25, 22, 26, 22, 7, 18, 22, ci.k, 90, 89};
    }

    public static void A03() {
        A01 = new String[]{"75", "", "84T1cPcVhFaG3gZ5iFCuz5VGfvW435Ys", "hmgtvPST3LKdfFpjmmFZYvFoyIGtsiKE", "1o0hQSlG2MREJWQYXtVsar2Zo68mKpVL", "LjPyS32kIH6YipP2gsYrsbvo7R8K", "pRhgJcRZc8j2ATnbWVmWTgInp0JNCNsL", "EpPf5pm3Rz1UtI6LaI9QQC8GFK2ymH0S"};
    }

    static {
        A03();
        A02();
        A02 = C1757Lp.class.getSimpleName();
    }

    public static Map<String, String> A01(C2026Wb c2026Wb) {
        Window window;
        HashMap map = new HashMap();
        if (c2026Wb == null) {
            return map;
        }
        try {
            map.put(A00(40, 3, 111), String.valueOf(A05(c2026Wb)));
            Activity activityA09 = c2026Wb.A09();
            if (activityA09 != null && (window = activityA09.getWindow()) != null) {
                int i = window.getAttributes().flags;
                map.put(A00(58, 2, 94), Integer.toString(window.getAttributes().type));
                int i2 = 4194304 & i;
                String strA00 = A00(1, 1, 110);
                String strA002 = A00(0, 1, 8);
                map.put(A00(48, 5, 14), i2 > 0 ? strA00 : strA002);
                if (A01[1].length() == 23) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[7] = "fwmMHJhcrVWyeAGw8Re8ymmckApbJBDL";
                strArr[7] = "fwmMHJhcrVWyeAGw8Re8ymmckApbJBDL";
                if ((524288 & i) <= 0) {
                    strA00 = strA002;
                }
                String flagShowWhenLockedEnabled = A00(53, 5, 18);
                map.put(flagShowWhenLockedEnabled, strA00);
            }
        } catch (Exception e2) {
            String str = A02;
            String flagShowWhenLockedEnabled2 = A00(2, 30, 72);
            Log.e(str, flagShowWhenLockedEnabled2, e2);
            C8X c8xA04 = c2026Wb.A04();
            int i3 = C8Y.A26;
            C8Z c8z = new C8Z(e2);
            String flagShowWhenLockedEnabled3 = A00(43, 5, 114);
            c8xA04.A8H(flagShowWhenLockedEnabled3, i3, c8z);
        }
        return map;
    }

    public static boolean A04(C2026Wb c2026Wb) {
        return !LY.A05(A01(c2026Wb));
    }

    public static boolean A05(C2026Wb c2026Wb) {
        KeyguardManager keyguardManager = (KeyguardManager) c2026Wb.getSystemService(A00(32, 8, 4));
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }
}
