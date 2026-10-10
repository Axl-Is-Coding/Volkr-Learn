package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import io.rong.common.dlog.DLog;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2078Yb implements D3 {
    public static byte[] A0C;
    public static String[] A0D;
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public final long A08;
    public final long A09;
    public final D2 A0A = new D2();
    public final D6 A0B;

    static {
        A0B();
        A0A();
    }

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 110);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0A() {
        A0C = new byte[]{38, 7, 72, 7, ci.m, ci.m, 72, 24, 9, ci.m, ci.k, 72, 11, 9, 6, 72, 10, ci.k, 72, ci.l, 7, 29, 6, 12, 70};
    }

    public static void A0B() {
        A0D = new String[]{"IwWJ1rAHfmexjsebXRXcDPjaU73iSJJD", "Pfa9O7smeRLr", "YVPVKTJSUnoy1mID8h1JiHhyOv", "4YIcZCc9D0v6GYbVW55qq4", "MQGq3Ss0TGTuZcZl9hZWKHAs", "ClxO0wOPMkXGPeTsbkyLqOefUDvePx9Y", "eY8aqVMBTreysgzhCT0m33TuEQRECFok", "4vNP3Dy1WFFR"};
    }

    public C2078Yb(long j, long j2, D6 d6, int i, long j3) {
        C1662Hr.A03(j >= 0 && j2 > j);
        this.A0B = d6;
        this.A09 = j;
        this.A08 = j2;
        if (i == j2 - j) {
            this.A07 = j3;
            this.A00 = 3;
        } else {
            this.A00 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A00(long j, long j2, long j3) {
        long j4 = this.A08;
        long j5 = this.A09;
        long j6 = j + ((((j4 - j5) * j2) / this.A07) - j3);
        if (j6 < j5) {
            j6 = this.A09;
        }
        long j7 = this.A08;
        if (j6 >= j7) {
            return j7 - 1;
        }
        return j6;
    }

    private final long A01(long j, CB cb) throws InterruptedException, IOException {
        if (this.A04 == this.A01) {
            return -(this.A05 + 2);
        }
        long jA6t = cb.A6t();
        if (A0E(cb, this.A01)) {
            this.A0A.A04(cb, false);
            cb.ACt();
            long j2 = j - this.A0A.A05;
            int i = this.A0A.A01 + this.A0A.A00;
            if (j2 >= 0) {
                String[] strArr = A0D;
                if (strArr[5].charAt(24) != strArr[0].charAt(24)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0D;
                strArr2[2] = "1HFKFqyQYawdfec4zhOWKwAEhw";
                strArr2[3] = "atngC4wrhlAL4xDnem6FNv";
                if (j2 <= 72000) {
                    cb.ADZ(i);
                    return -(this.A0A.A05 + 2);
                }
            }
            if (j2 < 0) {
                this.A01 = jA6t;
                this.A02 = this.A0A.A05;
            } else {
                long initialPosition = cb.A6t();
                this.A04 = initialPosition + ((long) i);
                this.A05 = this.A0A.A05;
                long initialPosition2 = this.A01;
                if ((initialPosition2 - this.A04) + ((long) i) < 100000) {
                    cb.ADZ(i);
                    long initialPosition3 = this.A05;
                    return -(initialPosition3 + 2);
                }
            }
            long initialPosition4 = this.A01;
            long j3 = this.A04;
            if (initialPosition4 - j3 < 100000) {
                this.A01 = j3;
                return j3;
            }
            long jA6t2 = cb.A6t() - (((long) i) * (j2 > 0 ? 1L : 2L));
            long j4 = this.A01;
            long j5 = this.A04;
            long j6 = (j4 - j5) * j2;
            String[] strArr3 = A0D;
            String str = strArr3[5];
            String str2 = strArr3[0];
            int pageSize = str.charAt(24);
            if (pageSize != str2.charAt(24)) {
                long initialPosition5 = this.A02;
                return Math.min(Math.max(jA6t2 + (j6 / (initialPosition5 - this.A05)), j5), this.A01 - 1);
            }
            String[] strArr4 = A0D;
            strArr4[1] = "HnyCEdH4by64";
            strArr4[7] = "f67XG71IQfud";
            return Math.min(Math.max(jA6t2 + (j6 / (this.A02 - this.A05)), j5), this.A01 - 1);
        }
        long j7 = this.A04;
        if (j7 != jA6t) {
            return j7;
        }
        throw new IOException(A09(0, 25, 6));
    }

    private final long A02(CB cb) throws InterruptedException, IOException {
        A0D(cb);
        this.A0A.A03();
        while ((this.A0A.A04 & 4) != 4 && cb.A6t() < this.A08) {
            this.A0A.A04(cb, false);
            cb.ADZ(this.A0A.A01 + this.A0A.A00);
        }
        return this.A0A.A05;
    }

    private final long A03(CB cb, long j, long j2) throws InterruptedException, IOException {
        this.A0A.A04(cb, false);
        while (this.A0A.A05 < j) {
            cb.ADZ(this.A0A.A01 + this.A0A.A00);
            j2 = this.A0A.A05;
            this.A0A.A04(cb, false);
        }
        cb.ACt();
        return j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.D3
    /* JADX INFO: renamed from: A07, reason: merged with bridge method [inline-methods] */
    public final C2077Ya A4R() {
        D0 d0 = null;
        if (this.A07 != 0) {
            return new C2077Ya(this);
        }
        return null;
    }

    private final void A0C() {
        this.A04 = this.A09;
        this.A01 = this.A08;
        this.A05 = 0L;
        this.A02 = this.A07;
    }

    private final void A0D(CB cb) throws InterruptedException, IOException {
        if (A0E(cb, this.A08)) {
        } else {
            throw new EOFException();
        }
    }

    private final boolean A0E(CB cb, long j) throws InterruptedException, IOException {
        long jMin = Math.min(3 + j, this.A08);
        byte[] bArr = new byte[DLog.CRS];
        int length = bArr.length;
        while (true) {
            if (cb.A6t() + ((long) length) > jMin && (length = (int) (jMin - cb.A6t())) < 4) {
                return false;
            }
            cb.ABt(bArr, 0, length, false);
            for (int i = 0; i < length - 3; i++) {
                if (bArr[i] == 79 && bArr[i + 1] == 103 && bArr[i + 2] == 103 && bArr[i + 3] == 83) {
                    cb.ADZ(i);
                    return true;
                }
            }
            cb.ADZ(length - 3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.D3
    public final long ACH(CB cb) throws InterruptedException, IOException {
        long jA03;
        int i = this.A00;
        if (i == 0) {
            this.A03 = cb.A6t();
            this.A00 = 1;
            long j = this.A08 - 65307;
            if (j > this.A03) {
                return j;
            }
        } else if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return -1L;
                }
                throw new IllegalStateException();
            }
            long j2 = this.A06;
            if (j2 == 0) {
                jA03 = 0;
            } else {
                long jA01 = A01(j2, cb);
                if (jA01 >= 0) {
                    return jA01;
                }
                jA03 = A03(cb, this.A06, -(jA01 + 2));
            }
            this.A00 = 3;
            return -(2 + jA03);
        }
        this.A07 = A02(cb);
        this.A00 = 3;
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.D3
    public final long ADg(long j) {
        int i = this.A00;
        C1662Hr.A03(i == 3 || i == 2);
        long jA05 = 0;
        if (j != 0) {
            jA05 = this.A0B.A05(j);
        }
        this.A06 = jA05;
        this.A00 = 2;
        A0C();
        long j2 = this.A06;
        String[] strArr = A0D;
        if (strArr[5].charAt(24) != strArr[0].charAt(24)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0D;
        strArr2[6] = "l4iEtEKEuRK6wb9mepvhy";
        strArr2[6] = "l4iEtEKEuRK6wb9mepvhy";
        return j2;
    }
}
