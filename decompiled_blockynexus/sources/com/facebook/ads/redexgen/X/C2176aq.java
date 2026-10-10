package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2176aq implements HC {
    public static String[] A0L;
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public Uri A06;
    public HC A07;
    public C1650Hf A08;
    public String A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final HC A0D;
    public final HC A0E;
    public final HC A0F;
    public final InterfaceC1646Hb A0G;

    @Nullable
    public final InterfaceC1648Hd A0H;
    public final boolean A0I;
    public final boolean A0J;
    public final boolean A0K;

    static {
        A05();
    }

    public static void A05() {
        A0L = new String[]{"xvXnimfZlroovEtMoHYEYdvHQmTptcRb", "VShQwZMBIZykoEi", "P7iiojcQSdjMkPZizdNAiKDH8422CMpJ", "OxKv", "P8zJvNho1beYtiBqU3s9pOljEd8sbOL5", "Bz35mpVTEU3xTv8hVu6cT493QseTsu6A", "YnRJs9xpv2Ig79N4M2dWIXRLqnd73xG0", "iIjgXD4YmMEy6XOGrZ4fgbIBHD"};
    }

    public C2176aq(InterfaceC1646Hb interfaceC1646Hb, HC hc, HC hc2, HA ha, int i, @Nullable InterfaceC1648Hd interfaceC1648Hd) {
        this.A0G = interfaceC1646Hb;
        this.A0D = hc2;
        this.A0I = (i & 1) != 0;
        this.A0K = (i & 2) != 0;
        this.A0J = (i & 4) != 0;
        this.A0F = hc;
        if (ha != null) {
            this.A0E = new C2171al(hc, ha);
        } else {
            this.A0E = null;
        }
        this.A0H = interfaceC1648Hd;
    }

    private int A00(HG hg) {
        if (this.A0K && this.A0C) {
            return 0;
        }
        if (this.A0J && hg.A02 == -1) {
            return 1;
        }
        return -1;
    }

    public static Uri A01(InterfaceC1646Hb interfaceC1646Hb, String str, Uri uri) {
        InterfaceC1656Hl contentMetadata = interfaceC1646Hb.A5u(str);
        Uri uriA01 = C1657Hm.A01(contentMetadata);
        return uriA01 == null ? uri : uriA01;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A02() throws IOException {
        HC hc = this.A07;
        if (hc == null) {
            return;
        }
        try {
            hc.close();
        } finally {
            this.A07 = null;
            this.A0A = false;
            C1650Hf c1650Hf = this.A08;
            if (c1650Hf != null) {
                this.A0G.ACa(c1650Hf);
                this.A08 = null;
            }
        }
    }

    private void A03() {
        if (this.A0H != null && this.A04 > 0) {
            this.A0G.A5g();
            throw null;
        }
    }

    private void A04() throws IOException {
        this.A01 = 0L;
        if (A0B()) {
            this.A0G.ADD(this.A09, this.A03);
        }
    }

    private void A06(IOException iOException) {
        if (A09() || (iOException instanceof HZ)) {
            this.A0C = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x01c5 A[PHI: r4
      0x01c5: PHI (r4v9 long) = (r4v8 long), (r4v10 long) binds: [B:76:0x01da, B:73:0x01c3] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07(boolean r22) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 547
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2176aq.A07(boolean):void");
    }

    private boolean A08() {
        return this.A07 == this.A0F;
    }

    private boolean A09() {
        return this.A07 == this.A0D;
    }

    private boolean A0A() {
        return !A09();
    }

    private boolean A0B() {
        return this.A07 == this.A0E;
    }

    public static boolean A0C(IOException iOException) {
        for (Throwable cause = iOException; cause != null; cause = cause.getCause()) {
            if ((cause instanceof HD) && ((HD) cause).A00 == 0) {
                return true;
            }
        }
        if (A0L[5].charAt(13) != 'v') {
            throw new RuntimeException();
        }
        String[] strArr = A0L;
        strArr[1] = "Fi50x9pU4R4a4ch";
        strArr[1] = "Fi50x9pU4R4a4ch";
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final Uri A7J() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final long ABi(HG hg) throws IOException {
        try {
            this.A09 = C1652Hh.A02(hg);
            this.A06 = hg.A04;
            this.A05 = A01(this.A0G, this.A09, this.A06);
            this.A00 = hg.A00;
            this.A03 = hg.A03;
            this.A0B = A00(hg) != -1;
            boolean z = this.A0B;
            if (hg.A02 != -1 || this.A0B) {
                this.A01 = hg.A02;
            } else {
                this.A01 = this.A0G.A5t(this.A09);
                if (this.A01 != -1) {
                    this.A01 -= hg.A03;
                    if (this.A01 <= 0) {
                        throw new HD(0);
                    }
                }
            }
            A07(false);
            return this.A01;
        } catch (IOException e2) {
            A06(e2);
            throw e2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final void close() throws IOException {
        this.A06 = null;
        this.A05 = null;
        A03();
        try {
            A02();
        } catch (IOException e2) {
            A06(e2);
            throw e2;
        }
    }

    @Override // com.facebook.ads.redexgen.X.HC
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (i2 == 0) {
            return 0;
        }
        if (this.A01 == 0) {
            return -1;
        }
        try {
            long j = this.A03;
            long j2 = this.A02;
            String[] strArr = A0L;
            if (strArr[4].charAt(0) != strArr[2].charAt(0)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[7] = "DFL6VfCjI9oAtZuqjooU4v3Ar2";
            strArr2[3] = "hOjd";
            if (j >= j2) {
                A07(true);
            }
            int i3 = this.A07.read(bArr, i, i2);
            if (i3 != -1) {
                if (A09()) {
                    this.A04 += (long) i3;
                }
                this.A03 += (long) i3;
                if (this.A01 != -1) {
                    this.A01 -= (long) i3;
                }
            } else if (this.A0A) {
                A04();
            } else if (this.A01 > 0 || this.A01 == -1) {
                A02();
                A07(false);
                return read(bArr, i, i2);
            }
            return i3;
        } catch (IOException e2) {
            if (this.A0A && A0C(e2)) {
                A04();
                return -1;
            }
            A06(e2);
            throw e2;
        }
    }
}
