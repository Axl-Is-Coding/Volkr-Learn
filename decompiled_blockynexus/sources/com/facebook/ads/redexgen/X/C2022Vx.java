package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Build;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2022Vx implements C6Y {
    public static String[] A01;
    public final /* synthetic */ W8 A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"Zr9pMbCXDOnIQia1rxNbs", "xgHdKmUla89dgoNlEUmYBSdthljERTVN", "t0eJ9CzsilrQTJZ3mBY5uHdLOToWpPD0", "xn7Df6Bsn6N8b", "nuXOesuXOGqaff6jWjDzzwB48Mr7m9Ru", "HD4PNhpjIErL9f7FhF1L2XB0w8jmfy8z", "GFJMAbd7JtPv78Iw3eZ5GKABpr6j7C", "a6D5eDw1EZzTAa7WvhZLV0FGc6KUpGTS"};
    }

    public C2022Vx(W8 w8) {
        this.A00 = w8;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    @SuppressLint({"MissingPermission"})
    public final AbstractC14046n A58() {
        if (Build.VERSION.SDK_INT < 17) {
            return this.A00.A08(EnumC14006j.A05);
        }
        boolean zA0E = C14136w.A0E();
        if (A01[2].charAt(7) != 's') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "7cAAgCcjwnswSonydGODzEoLsKghCJb5";
        strArr[4] = "7cAAgCcjwnswSonydGODzEoLsKghCJb5";
        if (zA0E) {
            boolean zA0D = C14136w.A0D();
            if (A01[1].charAt(23) == 'I') {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "A1O8dvsw8NjieGbBncMIJ1M47KAaXmaM";
            strArr2[7] = "A1O8dvsw8NjieGbBncMIJ1M47KAaXmaM";
            if (zA0D) {
                return this.A00.A08(EnumC14006j.A07);
            }
        }
        if (this.A00.A00 != null) {
            W8 w8 = this.A00;
            return w8.A05(W8.A01(w8.A00.getAllCellInfo().get(0)));
        }
        W8 w82 = this.A00;
        EnumC14006j enumC14006j = EnumC14006j.A07;
        String[] strArr3 = A01;
        if (strArr3[3].length() == strArr3[6].length()) {
            return w82.A08(enumC14006j);
        }
        String[] strArr4 = A01;
        strArr4[3] = "coCM9MFponCPc";
        strArr4[6] = "NV1iD8UH9ErBba9OnjbAeyrfSpL8qw";
        return w82.A08(enumC14006j);
    }
}
