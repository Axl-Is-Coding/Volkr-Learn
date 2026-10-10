package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.drm.DrmInitData;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class CT implements XZ, AS {
    public int A00;
    public int A01;
    public long A02;
    public AT A03;
    public FT A04;
    public boolean A05 = true;
    public boolean A06;
    public Format[] A07;
    public final int A08;

    public CT(int i) {
        this.A08 = i;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.Bu != com.facebook.ads.internal.exoplayer2.drm.DrmSessionManager<?> */
    public static boolean A0z(@Nullable InterfaceC1521Bu<?> interfaceC1521Bu, @Nullable DrmInitData drmInitData) {
        if (drmInitData == null) {
            return true;
        }
        if (interfaceC1521Bu == null) {
            return false;
        }
        return interfaceC1521Bu.A3x(drmInitData);
    }

    public final int A10() {
        return this.A00;
    }

    public final int A11(long j) {
        return this.A04.ADY(j - this.A02);
    }

    public final int A12(A7 a7, C2067Xq c2067Xq, boolean z) {
        int iACJ = this.A04.ACJ(a7, c2067Xq, z);
        if (iACJ == -4) {
            if (c2067Xq.A04()) {
                this.A05 = true;
                return this.A06 ? -4 : -3;
            }
            c2067Xq.A00 += this.A02;
        } else if (iACJ == -5) {
            Format format = a7.A00;
            if (format.A0G != Long.MAX_VALUE) {
                a7.A00 = format.A0I(format.A0G + this.A02);
            }
        }
        return iACJ;
    }

    public final AT A13() {
        return this.A03;
    }

    public void A14() {
    }

    public void A15() throws C14789u {
    }

    public void A16() throws C14789u {
    }

    public void A17(long j, boolean z) throws C14789u {
    }

    public void A18(boolean z) throws C14789u {
    }

    public void A19(Format[] formatArr, long j) throws C14789u {
    }

    public final boolean A1A() {
        return this.A05 ? this.A06 : this.A04.A7w();
    }

    public final Format[] A1B() {
        return this.A07;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void A4k() {
        C1662Hr.A04(this.A01 == 1);
        this.A01 = 0;
        this.A04 = null;
        this.A07 = null;
        this.A06 = false;
        A14();
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void A51(AT at, Format[] formatArr, FT ft, long j, boolean z, long j2) throws C14789u {
        C1662Hr.A04(this.A01 == 0);
        this.A03 = at;
        this.A01 = 1;
        A18(z);
        ACl(formatArr, ft, j2);
        A17(j, z);
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final AS A5j() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public I7 A6c() {
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final int A77() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final FT A7C() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.XZ, com.facebook.ads.redexgen.X.AS
    public final int A7H() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.AP
    public void A7O(int i, Object obj) throws C14789u {
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final boolean A7R() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final boolean A7k() {
        return this.A06;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void A8o() throws IOException {
        this.A04.A8l();
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void ACl(Format[] formatArr, FT ft, long j) throws C14789u {
        C1662Hr.A04(!this.A06);
        this.A04 = ft;
        this.A05 = false;
        this.A07 = formatArr;
        this.A02 = j;
        A19(formatArr, j);
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void ACu(long j) throws C14789u {
        this.A06 = false;
        this.A05 = false;
        A17(j, false);
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void ADE() {
        this.A06 = true;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void ADG(int i) {
        this.A00 = i;
    }

    public int ADn() throws C14789u {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void start() throws C14789u {
        C1662Hr.A04(this.A01 == 1);
        this.A01 = 2;
        A15();
    }

    @Override // com.facebook.ads.redexgen.X.XZ
    public final void stop() throws C14789u {
        C1662Hr.A04(this.A01 == 2);
        this.A01 = 1;
        A16();
    }
}
