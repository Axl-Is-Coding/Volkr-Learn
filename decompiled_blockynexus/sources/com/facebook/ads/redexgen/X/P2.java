package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class P2 extends KT {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ C7v A00;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A02;
            if (strArr[3].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[7] = "csAIefbP6dEHufce3C5MSz";
            strArr2[7] = "csAIefbP6dEHufce3C5MSz";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 117);
            i4++;
        }
    }

    public static void A01() {
        A01 = new byte[]{67, 86, 81, 82, 92, ci.k, 91, 82, 99, 82, 95, ci.k, 96, 97, 78, 95, 97, 82, 81, ci.k, 93, 89, 78, 102, 86, 91, 84};
    }

    public static void A03() {
        A02 = new String[]{"aQtlI1Us5cYHMsIV", "ql6TdDFLVKaOF", "ILd0cBh", "B0sTrIURZDTgtQOqZ9wP44Me", "PUGSIMdaF2lm0BEktB", "ig45kctSq2tkP", "eb7l2wEenDPHh06UHeaR81tCSX", "F61vU5UciYvMkd8uRJU0Fm"};
    }

    public P2(C7v c7v) {
        this.A00 = c7v;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        if (!this.A00.A07) {
            this.A00.A0H(A00(0, 27, 120));
        }
    }
}
