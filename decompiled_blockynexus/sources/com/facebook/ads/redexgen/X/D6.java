package com.facebook.ads.redexgen.X;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class D6 {
    public static String[] A0D;
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public CC A06;
    public CM A07;
    public D3 A08;
    public D5 A09;
    public boolean A0A;
    public boolean A0B;
    public final D1 A0C = new D1();

    static {
        A02();
    }

    public static void A02() {
        A0D = new String[]{"vdpx440NSg8M4CnGdydtu5qQkftaFl81", "8FBVTf92WyxNz1PbVx8WfEYVHOwD1jYA", "DKJKTeADHw9YeVFClTVADEpoqL7THNTT", "QMHe7Xu97ps4f3hWTDxnFcitcXlvMrzA", "cT681YGQWd9DutiYQJBSPFEBPfK5r2m4", "EyU4ukvYlXQau4YgIYVQwMEfY7bgqA6h", "DftqlnKuE3jyyUo0DxEITdlkAR2KkpEx", "3J2n16rNLfrexVGozCu5PKnUXiDeYKol"};
    }

    public abstract long A08(IG ig);

    public abstract boolean A0B(IG ig, long j, D5 d5) throws InterruptedException, IOException;

    private int A00(CB cb) throws InterruptedException, IOException {
        boolean zA0B = true;
        while (zA0B) {
            if (!this.A0C.A06(cb)) {
                this.A01 = 3;
                return -1;
            }
            this.A03 = cb.A6t() - this.A04;
            zA0B = A0B(this.A0C.A03(), this.A04, this.A09);
            if (zA0B) {
                this.A04 = cb.A6t();
            }
        }
        this.A00 = this.A09.A00.A0C;
        if (!this.A0A) {
            this.A07.A5I(this.A09.A00);
            this.A0A = true;
        }
        if (this.A09.A01 != null) {
            D5 d5 = this.A09;
            String[] strArr = A0D;
            if (strArr[3].charAt(31) == strArr[7].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[2] = "bh7MBcJSzFDWGWL7bYV4RFdmzZ5DJPtg";
            strArr2[4] = "jbTTtcEVTbmVVWffnqyGAcPkGPEAibSD";
            this.A08 = d5.A01;
        } else if (cb.A6a() == -1) {
            this.A08 = new C2084Yh();
        } else {
            D2 d2A02 = this.A0C.A02();
            this.A08 = new C2078Yb(this.A04, cb.A6a(), this, d2A02.A01 + d2A02.A00, d2A02.A05);
        }
        this.A09 = null;
        this.A01 = 2;
        this.A0C.A05();
        return 0;
    }

    private int A01(CB cb, CH ch) throws InterruptedException, IOException {
        long jACH = this.A08.ACH(cb);
        if (jACH >= 0) {
            ch.A00 = jACH;
            return 1;
        }
        if (jACH < -1) {
            A09(-(2 + jACH));
        }
        boolean z = this.A0B;
        if (A0D[1].charAt(31) == 'Q') {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[6] = "YKdoYyhEaGRVIGwSTWAYioMwjJxRxWbM";
        strArr[6] = "YKdoYyhEaGRVIGwSTWAYioMwjJxRxWbM";
        if (!z) {
            this.A06.AD3(this.A08.A4R());
            this.A0B = true;
        }
        if (this.A03 <= 0 && !this.A0C.A06(cb)) {
            this.A01 = 3;
            return -1;
        }
        this.A03 = 0L;
        IG igA03 = this.A0C.A03();
        long jA08 = A08(igA03);
        if (jA08 >= 0) {
            long j = this.A02;
            long granulesInPacket = j + jA08;
            if (granulesInPacket >= this.A05) {
                long jA04 = A04(j);
                this.A07.ACx(igA03, igA03.A08());
                this.A07.ACy(jA04, 1, igA03.A08(), 0, null);
                this.A05 = -1L;
            }
        }
        long timeUs = this.A02;
        this.A02 = timeUs + jA08;
        return 0;
    }

    public final int A03(CB cb, CH ch) throws InterruptedException, IOException {
        int i = this.A01;
        if (i == 0) {
            return A00(cb);
        }
        if (i == 1) {
            cb.ADZ((int) this.A04);
            this.A01 = 2;
            return 0;
        }
        if (i == 2) {
            int iA01 = A01(cb, ch);
            if (A0D[6].charAt(6) == 'm') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[1] = "ecnT7ItXVuTi5H8Gayt4a9jA0qUq5vI3";
            strArr[1] = "ecnT7ItXVuTi5H8Gayt4a9jA0qUq5vI3";
            return iA01;
        }
        throw new IllegalStateException();
    }

    public final long A04(long j) {
        return (1000000 * j) / ((long) this.A00);
    }

    public final long A05(long j) {
        return (((long) this.A00) * j) / 1000000;
    }

    public final void A06(long j, long j2) {
        this.A0C.A04();
        if (j == 0) {
            A0A(!this.A0B);
        } else {
            if (this.A01 == 0) {
                return;
            }
            this.A05 = this.A08.ADg(j2);
            this.A01 = 2;
        }
    }

    public final void A07(CC cc, CM cm) {
        this.A06 = cc;
        this.A07 = cm;
        A0A(true);
    }

    public void A09(long j) {
        this.A02 = j;
    }

    public void A0A(boolean z) {
        if (z) {
            this.A09 = new D5();
            this.A04 = 0L;
            this.A01 = 0;
        } else {
            this.A01 = 1;
        }
        this.A05 = -1L;
        this.A02 = 0L;
    }
}
