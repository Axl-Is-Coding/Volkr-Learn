package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Cw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1545Cw {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final Format A07;

    @Nullable
    public final long[] A08;

    @Nullable
    public final long[] A09;

    @Nullable
    public final C1546Cx[] A0A;

    public C1545Cw(int i, int i2, long j, long j2, long j3, Format format, int i3, @Nullable C1546Cx[] c1546CxArr, int i4, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.A00 = i;
        this.A03 = i2;
        this.A06 = j;
        this.A05 = j2;
        this.A04 = j3;
        this.A07 = format;
        this.A02 = i3;
        this.A0A = c1546CxArr;
        this.A01 = i4;
        this.A08 = jArr;
        this.A09 = jArr2;
    }

    public final C1546Cx A00(int i) {
        C1546Cx[] c1546CxArr = this.A0A;
        if (c1546CxArr == null) {
            return null;
        }
        return c1546CxArr[i];
    }
}
