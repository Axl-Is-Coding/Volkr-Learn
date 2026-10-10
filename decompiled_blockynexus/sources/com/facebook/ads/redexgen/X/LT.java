package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.media.AudioManager;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LT {
    public static byte[] A00;
    public static String[] A01;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-8, -44, -40, -20, -37, -32, -26, -35, -15, -16, -21, -20, -24, -35, -11, -1, 4, 2, -1, 4, -5};
    }

    public static void A03() {
        A01 = new String[]{"", "SXw", "dejWMVKCcsRHbrwAIECa6aRABNrvRLL1", "Mpo", "dfeQdAe6W2quBxkeKKSlZfT5B8UcRWSp", "PPqjaOYWzYRlppBEr7ot7ueRFIAfsGXr", "QjvNArJcMH0SA20xehHAs5TxpNTDNPBN", "WLwkcjK3klW5xWY"};
    }

    public static float A00(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(A01(2, 5, 39));
        if (audioManager != null) {
            int streamVolume = audioManager.getStreamVolume(3);
            int volume = audioManager.getStreamMaxVolume(3);
            if (volume > 0) {
                float f2 = streamVolume * 1.0f;
                float f3 = volume;
                if (A01[6].charAt(22) != 84) {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[2] = "0x0JMOwm3zHAjWtXS56jSdeaa6cHcp3J";
                strArr[2] = "0x0JMOwm3zHAjWtXS56jSdeaa6cHcp3J";
                return f2 / f3;
            }
            return WheelView.DividerConfig.FILL;
        }
        return WheelView.DividerConfig.FILL;
    }

    public static void A04(Map<String, String> map, boolean z, boolean z2) {
        String strA01 = A01(1, 1, 83);
        String strA012 = A01(0, 1, 120);
        map.put(A01(7, 8, 44), z ? strA01 : strA012);
        if (!z2) {
            strA01 = strA012;
        }
        map.put(A01(15, 6, 70), strA01);
    }
}
