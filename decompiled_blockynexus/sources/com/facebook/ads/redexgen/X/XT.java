package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XT implements I7 {
    public static byte[] A04;

    @Nullable
    public XZ A00;

    @Nullable
    public I7 A01;
    public final InterfaceC14759r A02;
    public final C2186b0 A03;

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 59);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{95, 103, 126, 102, 123, 98, 126, 119, 50, 96, 119, 124, 118, 119, 96, 119, 96, 50, 127, 119, 118, 123, 115, 50, 113, 126, 125, 113, 121, 97, 50, 119, 124, 115, 112, 126, 119, 118, 60};
    }

    public XT(InterfaceC14759r interfaceC14759r, InterfaceC1665Hu interfaceC1665Hu) {
        this.A02 = interfaceC14759r;
        this.A03 = new C2186b0(interfaceC1665Hu);
    }

    private void A01() {
        this.A03.A03(this.A01.A6v());
        AF playbackParameters = this.A01.A6s();
        if (!playbackParameters.equals(this.A03.A6s())) {
            this.A03.ADM(playbackParameters);
            this.A02.AAm(playbackParameters);
        }
    }

    private boolean A03() {
        XZ xz = this.A00;
        return (xz == null || xz.A7n() || (!this.A00.A7w() && this.A00.A7R())) ? false : true;
    }

    public final long A04() {
        if (A03()) {
            A01();
            return this.A01.A6v();
        }
        return this.A03.A6v();
    }

    public final void A05() {
        this.A03.A01();
    }

    public final void A06() {
        this.A03.A02();
    }

    public final void A07(long j) {
        this.A03.A03(j);
    }

    public final void A08(XZ xz) {
        if (xz == this.A00) {
            this.A01 = null;
            this.A00 = null;
        }
    }

    public final void A09(XZ xz) throws C14789u {
        I7 i7;
        I7 i7A6c = xz.A6c();
        if (i7A6c != null && i7A6c != (i7 = this.A01)) {
            if (i7 == null) {
                this.A01 = i7A6c;
                this.A00 = xz;
                this.A01.ADM(this.A03.A6s());
                A01();
                return;
            }
            throw C14789u.A02(new IllegalStateException(A00(0, 39, 41)));
        }
    }

    @Override // com.facebook.ads.redexgen.X.I7
    public final AF A6s() {
        I7 i7 = this.A01;
        if (i7 != null) {
            return i7.A6s();
        }
        return this.A03.A6s();
    }

    @Override // com.facebook.ads.redexgen.X.I7
    public final long A6v() {
        if (A03()) {
            return this.A01.A6v();
        }
        return this.A03.A6v();
    }

    @Override // com.facebook.ads.redexgen.X.I7
    public final AF ADM(AF af) {
        I7 i7 = this.A01;
        if (i7 != null) {
            af = i7.ADM(af);
        }
        this.A03.ADM(af);
        this.A02.AAm(af);
        return af;
    }
}
