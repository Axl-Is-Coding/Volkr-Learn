package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC12530o {
    public static byte[] A04;
    public static String[] A05;
    public boolean A00;
    public final C2026Wb A01;
    public final AbstractC12540p A02;
    public final C1849Pe A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 37);
            String[] strArr = A05;
            if (strArr[7].charAt(19) == strArr[3].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[5] = "ralyQsFIfJjHchT6ijaCYOn7xcrh9SYP";
            strArr2[0] = "lf1tsTh5P7IODA8hmkOKCVUdKtrYifbk";
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-126, -90, -87, -85, -98, -84, -84, -94, -88, -89, 89, -91, -88, -96, -96, -98, -99};
    }

    public static void A02() {
        A05 = new String[]{"OqcLT37Xtir4oyEfNmT1h4Rk4YkQZZDY", "Uwe5RI", "pL0dXLjcEL0YvPTfwlaTsWSX1DbaAkE5", "xtw7OOYBvYdKgcW8WzcZrKA0PDZy4bwg", "f918FI", "0rYE8aKdqB5alUcDRGHr7byWf0zxjLED", "HJdrWZ0hD1uhwEG", "W2AWehjS6wPr2mpVEIqcODXDVwSDQEbA"};
    }

    public abstract void A07(Map<String, String> map);

    public AbstractC12530o(C2026Wb c2026Wb, AbstractC12540p abstractC12540p, C1849Pe c1849Pe) {
        this.A01 = c2026Wb;
        this.A02 = abstractC12540p;
        this.A03 = c1849Pe;
    }

    public final void A03() {
        if (this.A00) {
            return;
        }
        AbstractC12540p abstractC12540p = this.A02;
        if (abstractC12540p != null) {
            abstractC12540p.A01();
        }
        A07(new NQ().A04(this.A03).A06());
        this.A00 = true;
        C1733Kr.A02(this.A01, A00(0, 17, 20));
        AbstractC12540p abstractC12540p2 = this.A02;
    }
}
