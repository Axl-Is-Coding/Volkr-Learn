package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1966Tt implements C6Y {
    public static String[] A01;
    public final /* synthetic */ U1 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"pBrDaZa5X5LjOgDS06qrKfvSDyGe8efw", "mQEhYUIy596kL", "EIforD6eBYb22Ex4JOKq", "k4SBaaSc1moa84J0CFgFz3nqLP2HVqmu", "u8nSh4T3SaBZfkGp86pLE93qaiXMklcf", "jMwuEx2OfYupc0", "IfOhRtB8SPti74hSuqBgnsqawc0MdhYN", "25E6wEyieKrSwG"};
    }

    public C1966Tt(U1 u1) {
        this.A00 = u1;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 4) {
            U1 u1 = this.A00;
            String[] strArr = A01;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "5uTBAcIF1H8x94";
            strArr2[5] = "w8sP31VUPTTap4";
            return u1.A08(EnumC14006j.A05);
        }
        if (this.A00.A01 != null) {
            U1 u12 = this.A00;
            String[] strArr3 = A01;
            if (strArr3[3].charAt(9) != strArr3[6].charAt(9)) {
                String[] strArr4 = A01;
                strArr4[7] = "fRLqK3UXRIvALx";
                strArr4[5] = "beY33YfNkspfTw";
                return u12.A05(u12.A01.targetSdkVersion);
            }
            String[] strArr5 = A01;
            strArr5[4] = "qWUfrjWL8adA9tG6bFG21ciodwCrSrmB";
            strArr5[4] = "qWUfrjWL8adA9tG6bFG21ciodwCrSrmB";
            return u12.A05(u12.A01.targetSdkVersion);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
