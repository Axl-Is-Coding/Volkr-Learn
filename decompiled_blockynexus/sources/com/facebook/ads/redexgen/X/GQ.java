package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GQ {
    public static String[] A09;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public boolean A06;
    public final IG A07 = new IG();
    public final int[] A08 = new int[256];

    static {
        A00();
    }

    public static void A00() {
        A09 = new String[]{"dgnk6daQ0T87wOoHtyty7iRYaKvd8BzP", "TK3sWG", "r0T7HSyuXxeUz69yLbXIR4BhIiF2UDCf", "E94UIter8sht222SneNEBcgvWBNv8GHv", "qg4jsBrtjCwX7ZbqQAPOhxC1noKxQthL", "J", "sUrKaEkRL4ABh9brwle2ScDHOfoRuahW", "YVc6k2"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(IG ig, int i) {
        int iA0H;
        if (i < 4) {
            return;
        }
        ig.A0a(3);
        int i2 = i - 4;
        if ((ig.A0F() & 128) != 0) {
            if (i2 < 7 || (iA0H = ig.A0H()) < 4) {
                return;
            }
            this.A01 = ig.A0J();
            this.A00 = ig.A0J();
            this.A07.A0X(iA0H - 4);
            i2 -= 7;
        }
        int iA07 = this.A07.A07();
        int iA08 = this.A07.A08();
        if (iA07 < iA08 && i2 > 0) {
            int bytesToRead = Math.min(i2, iA08 - iA07);
            ig.A0d(this.A07.A00, iA07, bytesToRead);
            this.A07.A0Z(iA07 + bytesToRead);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(IG ig, int i) {
        if (i < 19) {
            return;
        }
        this.A05 = ig.A0J();
        this.A04 = ig.A0J();
        ig.A0a(11);
        this.A02 = ig.A0J();
        this.A03 = ig.A0J();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A06(IG ig, int i) {
        if (i % 5 != 2) {
            return;
        }
        ig.A0a(2);
        Arrays.fill(this.A08, 0);
        int i2 = i / 5;
        for (int r = 0; r < i2; r++) {
            int iA0F = ig.A0F();
            int iA0F2 = ig.A0F();
            int iA0F3 = ig.A0F();
            int iA0F4 = ig.A0F();
            int entryCount = ig.A0F();
            int i3 = (int) (((double) iA0F2) + (((double) (iA0F3 - 128)) * 1.402d));
            int cb = iA0F4 - 128;
            double d2 = ((double) iA0F2) - (((double) cb) * 0.34414d);
            int i4 = iA0F3 - 128;
            int i5 = (int) (d2 - (((double) i4) * 0.71414d));
            int i6 = iA0F4 - 128;
            int i7 = (int) (((double) iA0F2) + (((double) i6) * 1.772d));
            int[] iArr = this.A08;
            int i8 = IW.A06(i3, 0, 255);
            int i9 = (entryCount << 24) | (i8 << 16);
            int i10 = IW.A06(i5, 0, 255);
            int i11 = i9 | (i10 << 8);
            int i12 = IW.A06(i7, 0, 255);
            iArr[iA0F] = i11 | i12;
        }
        this.A06 = true;
    }

    /* JADX WARN: Incorrect condition in loop: B:20:0x003b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.facebook.ads.redexgen.X.G5 A07() {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.GQ.A07():com.facebook.ads.redexgen.X.G5");
    }

    public final void A08() {
        this.A05 = 0;
        this.A04 = 0;
        this.A02 = 0;
        this.A03 = 0;
        this.A01 = 0;
        this.A00 = 0;
        this.A07.A0X(0);
        this.A06 = false;
    }
}
