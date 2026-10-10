package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Va, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1999Va implements C6Y {
    public static String[] A01;
    public final /* synthetic */ C2003Ve A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"zJajY9dZZxYFsLRzsvnBiwQWt0HnizLC", "gzFaheVOcPUMbI38nwUIVYmc91b5uR", "ce0KJPPQByTAaQ9ATxZk2kwW24DeaJ9j", "R6Wiv8wmYaZdmPdgU3hXsutSf", "job2ys34errF3to", "kwK9VFGEGX8wPEd", "j3AidPNHk3dBWfN6HPyZ7", "rfM1O6R1RyyEf1DP"};
    }

    public C1999Va(C2003Ve c2003Ve) {
        this.A00 = c2003Ve;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (this.A00.A01 != null && Build.VERSION.SDK_INT >= 22) {
            C2003Ve c2003Ve = this.A00;
            if (A01[1].length() != 30) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[6] = "SsABSdrOWb5CHUfmSefeH";
            strArr[6] = "SsABSdrOWb5CHUfmSefeH";
            return c2003Ve.A05(c2003Ve.A01.baseRevisionCode);
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
