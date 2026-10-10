package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2080Yd extends D6 {
    public static byte[] A02;
    public static String[] A03;
    public C2079Yc A00;
    public I3 A01;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 56);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{6, 18, 3, ci.l, 8, 72, 1, 11, 6, 4};
    }

    public static void A04() {
        A03 = new String[]{"RjYCDLb2NANzCnedRKoQM0GQ", "QX5lqyT5r1TYXy6sq6A", "sDmzmZu2Epi", "QleORMZQxcHxPLUcnR0aaEPVJ", "tBrVRsKa63H7cOEQm0uGMqa5cwtrVWSW", "PEwzIbtLaNn1pzRcppb", "zVqUyH", "ZIYCsXe3luBjtUiXTHmKPLmA"};
    }

    private int A00(IG ig) {
        int i = (ig.A00[2] & 255) >> 4;
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
            case 7:
                ig.A0a(4);
                ig.A0P();
                int iA0F = i == 6 ? ig.A0F() : ig.A0J();
                ig.A0Z(0);
                return iA0F + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    public static boolean A05(IG ig) {
        return ig.A05() >= 5 && ig.A0F() == 127 && ig.A0N() == 1179402563;
    }

    public static boolean A06(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.facebook.ads.redexgen.X.D6
    public final long A08(IG ig) {
        if (!A06(ig.A00)) {
            return -1L;
        }
        int iA00 = A00(ig);
        String[] strArr = A03;
        if (strArr[2].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[2] = "M0DKrSciZtY";
        strArr2[0] = "bwyyvFLni8GVBC8P6VU38e20";
        return iA00;
    }

    @Override // com.facebook.ads.redexgen.X.D6
    public final void A0A(boolean z) {
        super.A0A(z);
        if (z) {
            this.A01 = null;
            this.A00 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.D6
    public final boolean A0B(IG ig, long j, D5 d5) throws InterruptedException, IOException {
        byte[] bArr = ig.A00;
        if (this.A01 == null) {
            this.A01 = new I3(bArr, 17);
            byte[] data = Arrays.copyOfRange(bArr, 9, ig.A08());
            data[4] = -128;
            List listSingletonList = Collections.singletonList(data);
            d5.A00 = Format.A07(null, A02(0, 10, 95), null, -1, this.A01.A00(), this.A01.A01, this.A01.A06, listSingletonList, null, 0, null);
            return true;
        }
        if ((bArr[0] & 127) == 3) {
            this.A00 = new C2079Yc(this);
            this.A00.A02(ig);
            return true;
        }
        if (!A06(bArr)) {
            return true;
        }
        C2079Yc c2079Yc = this.A00;
        if (c2079Yc != null) {
            c2079Yc.A01(j);
            d5.A01 = this.A00;
        }
        return false;
    }
}
