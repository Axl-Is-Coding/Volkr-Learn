package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2023Vy implements C6Y {
    public static String[] A01;
    public final /* synthetic */ W8 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"xn6Y4xiAj5nTE1ZX0fcI9", "IuzZJNTC9Fpz", "Zp9uFgGuFlryeSNHyo4T0p", "eRJH2gjtevDtLFu1wMxFEv", "pTKacr9NdWTXHSX", "3c0ViuxMUKEAC", "2WDSEnCYP4spNEJs", "S3q5Kz3J"};
    }

    public C2023Vy(W8 w8) {
        this.A00 = w8;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 26) {
            W8 w8 = this.A00;
            String[] strArr = A01;
            if (strArr[2].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[2] = "x95Rh7kgyGSfBF3YHwpGzi";
            strArr2[3] = "73CHLU13D6YvD39ECjSAyL";
            return w8.A08(EnumC14006j.A05);
        }
        if (this.A00.A00 != null) {
            W8 w82 = this.A00;
            return w82.A0G(w82.A00.isDataEnabled());
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
