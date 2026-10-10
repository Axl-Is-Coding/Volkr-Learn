package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Z3 implements DO {
    public static byte[] A03;
    public static String[] A04;
    public CM A00;
    public IS A01;
    public boolean A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 96);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{11, 26, 26, 22, 19, ci.k, 11, 30, 19, 25, 24, -39, 34, -41, 29, ci.k, 30, ci.m, -35, -33};
    }

    public static void A02() {
        A04 = new String[]{"9dIhF2X5qYPGZcPrMQjFeU2FMq4Icb5t", "C7lZKzl2OzNugbLE4QJixcZrlcSgCGI7", "v7kvgcbsYqtq4Ou8B7XlURjv8wkzUozH", "8BzUB2zJ4MAZsKVthH28T9QXZJlG29jD", "wOgdV6BnuyxARX3Rbc0CvFDDXWIKfgjM", "mpBmZ", "f47n1mRwiFyOsV4myeWB5UC2YKJiwKop", "3tKYH9iJUyIyPmbH9Trftcv4NWgUsp5b"};
    }

    @Override // com.facebook.ads.redexgen.X.DO
    public final void A48(IG ig) {
        if (!this.A02) {
            if (this.A01.A06() == -9223372036854775807L) {
                return;
            }
            this.A00.A5I(Format.A02(null, A00(0, 20, 74), this.A01.A06()));
            this.A02 = true;
        }
        int iA05 = ig.A05();
        this.A00.ACx(ig, iA05);
        CM cm = this.A00;
        if (A04[0].charAt(13) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[0] = "M4wOXnroCREOIcf8T96EgrMDUu9ExHmM";
        strArr[0] = "M4wOXnroCREOIcf8T96EgrMDUu9ExHmM";
        cm.ACy(this.A01.A05(), 1, iA05, 0, null);
    }

    @Override // com.facebook.ads.redexgen.X.DO
    public final void A7g(IS is, CC cc, DU du) {
        this.A01 = is;
        du.A06();
        this.A00 = cc.ADr(du.A04(), 4);
        this.A00.A5I(Format.A0B(du.A05(), A00(0, 20, 74), null, -1, null));
    }
}
