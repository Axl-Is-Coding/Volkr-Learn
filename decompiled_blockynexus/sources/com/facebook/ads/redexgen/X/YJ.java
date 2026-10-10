package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YJ extends CO {
    public static byte[] A05;
    public static String[] A06;
    public int A00;
    public int A01;
    public boolean A02;
    public final IG A03;
    public final IG A04;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{1, 62, 51, 50, 56, 119, 49, 56, 37, 58, 54, 35, 119, 57, 56, 35, 119, 36, 34, 39, 39, 56, 37, 35, 50, 51, 109, 119, 91, 68, 73, 72, 66, 2, 76, 91, 78};
    }

    public static void A02() {
        A06 = new String[]{"HrBrUDmtAiHhEIFi", "ovhYl7NWEd171z8PJdmzSHTS5BmNRwGh", "O04BUWOaHdfjopELTyPlWCM73tUUR1GH", "jF3DEBpuUmaMt5XqjGdbc3EKLhdJIOP", "6wGSczOuIh6bVbI0f7FgwzIt", "67fT6B3p0kUWiMxqOkjfZNmnVryLDGGV", "w97Hra0FQmNyyw573", "JpIXAL9FgQ2FQzjAVAZn2BwWekNoW7nE"};
    }

    public YJ(CM cm) {
        super(cm);
        this.A04 = new IG(IC.A03);
        this.A03 = new IG(4);
    }

    @Override // com.facebook.ads.redexgen.X.CO
    public final void A0C(IG ig, long j) throws AD {
        int iA0F = ig.A0F();
        long jA0A = j + (((long) ig.A0A()) * 1000);
        if (iA0F == 0 && !this.A02) {
            IG videoSequence = new IG(new byte[ig.A05()]);
            ig.A0d(videoSequence.A00, 0, ig.A05());
            IY iyA00 = IY.A00(videoSequence);
            this.A01 = iyA00.A02;
            super.A00.A5I(Format.A03(null, A00(28, 9, 114), null, -1, -1, iyA00.A03, iyA00.A01, -1.0f, iyA00.A04, -1, iyA00.A00, null));
            this.A02 = true;
            return;
        }
        if (iA0F != 1 || !this.A02) {
            return;
        }
        byte[] bArr = this.A03.A00;
        bArr[0] = 0;
        bArr[1] = 0;
        bArr[2] = 0;
        int i = 4 - this.A01;
        int i2 = 0;
        while (ig.A05() > 0) {
            ig.A0d(this.A03.A00, i, this.A01);
            this.A03.A0Z(0);
            int iA0I = this.A03.A0I();
            this.A04.A0Z(0);
            super.A00.ACx(this.A04, 4);
            super.A00.ACx(ig, iA0I);
            i2 = i2 + 4 + iA0I;
        }
        CM cm = super.A00;
        int i3 = this.A00 != 1 ? 0 : 1;
        if (A06[6].length() == 3) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[1] = "SxoTsTEtYbkIpzmogJvkXCUruqqJ7knT";
        strArr[7] = "DX7TKSEUbLiNIzjv4P1HkLtMAUktYoJf";
        cm.ACy(jA0A, i3, i2, 0, null);
    }

    @Override // com.facebook.ads.redexgen.X.CO
    public final boolean A0D(IG ig) throws YI {
        int iA0F = ig.A0F();
        int i = (iA0F >> 4) & 15;
        int i2 = iA0F & 15;
        if (i2 == 7) {
            this.A00 = i;
            return i != 5;
        }
        throw new YI(A00(0, 28, 8) + i2);
    }
}
