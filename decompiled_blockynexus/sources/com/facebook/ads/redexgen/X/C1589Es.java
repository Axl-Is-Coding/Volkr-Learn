package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Es, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1589Es extends R2 {
    public static byte[] A02;
    public static String[] A03;
    public Map<String, String> A00;
    public final Uri A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {104, 109, 106, 111};
        if (A03[5].charAt(30) != 'u') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[5] = "82m81CO1d0OwjHPL38rD7xdABiLQ6kup";
        strArr[5] = "82m81CO1d0OwjHPL38rD7xdABiLQ6kup";
        A02 = bArr;
    }

    public static void A02() {
        A03 = new String[]{"OXbCEMjwdPN5xvU2NT0kKgep5UeL1Sqr", "SX0ygsPxRN6KiRybC8JMsMv996SDI", "L77PzfY5dGd9ppcaJeqEYdg5mL", "qaE4mxmFDXDzve4pMTR5s0xQhV", "rrEUCxltihDw1phZ7LTyezPpJ6vgfWBl", "FdpTQfSalwXKw6iuOYHl49ZbqEAaQDuv", "IFg4N7XoM6S2Rxr", "IzcF2xeWDVSzXIhxKqlgaOjlVHZ1W1Z3"};
    }

    public C1589Es(C2026Wb c2026Wb, J5 j5, String str, Uri uri, Map<String, String> map) {
        super(c2026Wb, j5, str, null, true);
        this.A01 = uri;
        this.A00 = map;
    }

    @Override // com.facebook.ads.redexgen.X.R2
    public final void A0E() {
        A0F(this.A00, null);
    }

    public final Uri A0G() {
        return Uri.parse(this.A01.getQueryParameter(A00(0, 4, 20)));
    }
}
