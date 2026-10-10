package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.Format;
import com.just.agentweb.WebIndicator;
import com.umeng.analytics.pro.ci;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YD implements CA {
    public static byte[] A07;
    public static String[] A08;
    public static final CD A09;
    public static final int A0A;
    public static final byte[] A0B;
    public static final byte[] A0C;
    public static final int[] A0D;
    public static final int[] A0E;
    public int A00;
    public int A01;
    public long A02;
    public CM A03;
    public boolean A04;
    public boolean A05;
    public final byte[] A06 = new byte[1];

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 86);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A07 = new byte[]{68, 2, 22, 5, 9, 1, 68, ci.n, 29, 20, 1, 68, 110, 108, 12, 0, 31, 71, 71, 69, 37, 41, 54, 73, 51, 38, 110, 19, Utf8.REPLACEMENT_BYTE, 37, 60, 52, 112, 62, Utf8.REPLACEMENT_BYTE, 36, 112, 54, 57, 62, 52, 112, 17, 29, 2, 112, 56, 53, 49, 52, 53, 34, 126, 118, 83, 83, 90, 88, 94, 83, 31, 126, 114, 109, 31, 66, 101, 125, 106, 103, 98, 111, 43, 123, 106, 111, 111, 98, 101, 108, 43, 105, 98, 127, 120, 43, 109, 100, 121, 43, 109, 121, 106, 102, 110, 43, 99, 110, 106, 111, 110, 121, 43, 100, 104, 11, 30, 117, 97, 112, 125, 123, 59, 39, 115, 100, 100, 79, 91, 74, 71, 65, 1, 79, 67, 92, 3, 89, 76};
    }

    public static void A06() {
        A08 = new String[]{"kwIa2qvFZnh4ugx7FyhwbqYesuLHzW8H", "4Dgc9JYMaZvt2hrxHtp57hAkJrlRZ5uW", "jO6V5", "R3", "Im86Iu6D0MRlrMkG5DQfIyJ6juGc2Tk5", "YTnYWq927V90IgLbpCGbNLebKXRpsTKS", "IVlYalVTOJIVyjwO93zz99ctNlNH9y3g", "4VmeTfaP7iXdbh5q2O9S939ewelN7CTt"};
    }

    static {
        A06();
        A05();
        A09 = new YC();
        A0D = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        A0E = new int[]{18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        A0B = IW.A0j(A03(12, 6, 27));
        A0C = IW.A0j(A03(18, 9, 50));
        A0A = A0E[8];
    }

    private int A00(int i) throws AD {
        if (!A08(i)) {
            StringBuilder sb = new StringBuilder();
            sb.append(A03(53, 12, 105));
            sb.append(this.A05 ? A03(105, 2, 10) : A03(103, 2, 124));
            sb.append(A03(0, 12, 50));
            sb.append(i);
            throw new AD(sb.toString());
        }
        if (!this.A05) {
            return A0D[i];
        }
        int[] iArr = A0E;
        if (A08[1].charAt(23) == 'y') {
            throw new RuntimeException();
        }
        String[] strArr = A08;
        strArr[2] = "ixm0r";
        strArr[2] = "ixm0r";
        return iArr[i];
    }

    private int A01(CB cb) throws InterruptedException, IOException {
        cb.ACt();
        cb.ABs(this.A06, 0, 1);
        byte b2 = this.A06[0];
        if ((b2 & 131) <= 0) {
            return A00((b2 >> 3) & 15);
        }
        throw new AD(A03(65, 38, 93) + ((int) b2));
    }

    private int A02(CB cb) throws InterruptedException, IOException {
        if (this.A00 == 0) {
            try {
                this.A01 = A01(cb);
                this.A00 = this.A01;
            } catch (EOFException unused) {
                return -1;
            }
        }
        int iACw = this.A03.ACw(cb, this.A00, true);
        if (iACw == -1) {
            return -1;
        }
        this.A00 -= iACw;
        if (this.A00 > 0) {
            return 0;
        }
        CM cm = this.A03;
        long j = this.A02;
        String[] strArr = A08;
        if (strArr[4].charAt(15) == strArr[5].charAt(15)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[2] = "25B6f";
        strArr2[2] = "25B6f";
        cm.ACy(j, 1, this.A01, 0, null);
        this.A02 += 20000;
        return 0;
    }

    private void A04() {
        if (!this.A04) {
            this.A04 = true;
            this.A03.A5I(Format.A06(null, this.A05 ? A03(117, 12, 120) : A03(107, 10, 66), null, -1, A0A, 1, this.A05 ? 16000 : WebIndicator.MAX_UNIFORM_SPEED_DURATION, -1, null, null, 0, null));
        }
    }

    private boolean A07(int i) {
        return !this.A05 && (i < 12 || i > 14);
    }

    private boolean A08(int i) {
        return i >= 0 && i <= 15 && (A09(i) || A07(i));
    }

    private boolean A09(int i) {
        return this.A05 && (i < 10 || i > 13);
    }

    private boolean A0A(CB cb) throws InterruptedException, IOException {
        if (A0B(cb, A0B)) {
            this.A05 = false;
            cb.ADZ(A0B.length);
            return true;
        }
        if (!A0B(cb, A0C)) {
            return false;
        }
        this.A05 = true;
        cb.ADZ(A0C.length);
        return true;
    }

    private boolean A0B(CB cb, byte[] bArr) throws InterruptedException, IOException {
        cb.ACt();
        byte[] bArr2 = new byte[bArr.length];
        cb.ABs(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void A7e(CC cc) {
        cc.AD3(new YB(-9223372036854775807L));
        this.A03 = cc.ADr(0, 1);
        cc.A54();
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final int ACG(CB cb, CH ch) throws InterruptedException, IOException {
        if (cb.A6t() != 0 || A0A(cb)) {
            A04();
            return A02(cb);
        }
        throw new AD(A03(27, 26, 6));
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final void AD2(long j, long j2) {
        this.A02 = 0L;
        this.A01 = 0;
        this.A00 = 0;
    }

    @Override // com.facebook.ads.redexgen.X.CA
    public final boolean ADa(CB cb) throws InterruptedException, IOException {
        return A0A(cb);
    }
}
