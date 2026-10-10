package com.facebook.ads.redexgen.X;

import android.app.KeyguardManager;
import android.content.Context;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LY {
    public static byte[] A00;
    public static String[] A01;
    public static final String A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-67, -13, -19, 1, -17, -3, -23, -6, -20, -100, -104, -93, -94, -96, -93, -109, -91, -108, -110, -103, -107, -84, -101, -88, -84, -95};
    }

    public static void A02() {
        A01 = new String[]{"daXn", "1AEGGiZtK9izNwxj0gdNwiRX4yxGSLbl", "jWJWqJI6vm3EcSkucHo8Z2hc4QqQU5eN", "kJ80Vw1lOC47iRluFhEDeBzKcKjW1m8D", "UFa447OZZwRnjgAwYt6DClQrKKYck", "JtTOAq931RuxhQ9Tu1gEBrllAq", "KlezWCwDulS1StSn2NonTUsqgHFd0zlY", "hQC1wn7yR06U4qX9nCxzTugCr"};
    }

    static {
        A02();
        A01();
        A02 = LY.class.getSimpleName();
    }

    public static boolean A03(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(A00(1, 8, 122));
        return keyguardManager != null && keyguardManager.inKeyguardRestrictedInputMode();
    }

    public static boolean A04(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        String str = map.get(A00(16, 5, 32));
        String str2 = map.get(A00(21, 5, 39));
        String flagShowWhenLocked = A00(9, 3, 35);
        String str3 = map.get(flagShowWhenLocked);
        if (str != null) {
            String[] strArr = A01;
            String str4 = strArr[0];
            String flagShowWhenLocked2 = strArr[4];
            if (str4.length() == flagShowWhenLocked2.length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "KnKdjir99deazR25n";
            strArr2[7] = "KnKdjir99deazR25n";
            String strA00 = A00(0, 1, 126);
            if (str.equals(strA00) && str2 != null && str2.equals(strA00) && str3 != null) {
                String flagShowWhenLocked3 = A00(12, 4, 32);
                if (str3.equals(flagShowWhenLocked3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean A05(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return false;
        }
        String str = map.get(A00(16, 5, 32));
        String str2 = map.get(A00(21, 5, 39));
        String strA00 = A00(0, 1, 126);
        if ((str != null && str.equals(strA00)) || (str2 != null && str2.equals(strA00))) {
            return false;
        }
        String flagShowWhenLocked = A00(9, 3, 35);
        String str3 = map.get(flagShowWhenLocked);
        if (str3 == null) {
            return false;
        }
        String flagShowWhenLocked2 = A00(12, 4, 32);
        return str3.equals(flagShowWhenLocked2);
    }
}
