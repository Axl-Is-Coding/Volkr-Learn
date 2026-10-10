package com.facebook.ads.redexgen.X;

import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class W7 implements C6Y {
    public static String[] A01;
    public final /* synthetic */ W8 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"Vh7d3JLClPU6O6M8cwd6Jw", "qoTOEE24iOX0Q2iJnmkuihyFZ58dtUeG", "nAWEC03NDSwq9NkCe2EWt", "lKLCTUg5DoQjO8iCafmP2M1qyzkHzRyN", "zIUGSnqgNQBLElYl1akNx9HRDEYjixyz", "g15BZq0dmNsNcXFZVGLSC", "388jVMFAtK4Tm3JKA9SjxAcbz1TvPoye", "A1Sv5qAzVDWgkr4HaP1"};
    }

    public W7(W8 w8) {
        this.A00 = w8;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 28) {
            return this.A00.A08(EnumC14006j.A05);
        }
        W8 w8 = this.A00;
        String[] strArr = A01;
        if (strArr[4].charAt(18) != strArr[1].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A01;
        strArr2[6] = "bZz0x6nk4wqsfLm60KBH7nDut9sP39y5";
        strArr2[3] = "KyjNNUgB1DvvpLcjDLXdCxQbayCmxayp";
        if (w8.A00 != null) {
            W8 w82 = this.A00;
            return w82.A05(w82.A00.getSimCarrierId());
        }
        return this.A00.A08(EnumC14006j.A07);
    }
}
