package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1548Cz {
    public final int A00;
    public final int A01;
    public final long A02;
    public final C1545Cw A03;
    public final int[] A04;
    public final int[] A05;
    public final long[] A06;
    public final long[] A07;

    public C1548Cz(C1545Cw c1545Cw, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        C1662Hr.A03(iArr.length == jArr2.length);
        C1662Hr.A03(jArr.length == jArr2.length);
        C1662Hr.A03(iArr2.length == jArr2.length);
        this.A03 = c1545Cw;
        this.A06 = jArr;
        this.A05 = iArr;
        this.A00 = i;
        this.A07 = jArr2;
        this.A04 = iArr2;
        this.A02 = j;
        this.A01 = jArr.length;
    }

    public final int A00(long j) {
        for (int iA0B = IW.A0B(this.A07, j, true, false); iA0B >= 0; iA0B--) {
            if ((this.A04[iA0B] & 1) != 0) {
                return iA0B;
            }
        }
        return -1;
    }

    public final int A01(long j) {
        for (int iA0A = IW.A0A(this.A07, j, true, false); iA0A < this.A07.length; iA0A++) {
            if ((this.A04[iA0A] & 1) != 0) {
                return iA0A;
            }
        }
        return -1;
    }
}
