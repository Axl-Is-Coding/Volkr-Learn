package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.source.TrackGroupArray;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AE {
    public final int A00;
    public final long A01;
    public final long A02;
    public final AZ A03;
    public final F6 A04;
    public final TrackGroupArray A05;
    public final H2 A06;

    @Nullable
    public final Object A07;
    public final boolean A08;
    public volatile long A09;
    public volatile long A0A;

    public AE(AZ az, long j, TrackGroupArray trackGroupArray, H2 h2) {
        this(az, null, new F6(0), j, -9223372036854775807L, 1, false, trackGroupArray, h2);
    }

    public AE(AZ az, @Nullable Object obj, F6 f6, long j, long j2, int i, boolean z, TrackGroupArray trackGroupArray, H2 h2) {
        this.A03 = az;
        this.A07 = obj;
        this.A04 = f6;
        this.A02 = j;
        this.A01 = j2;
        this.A0A = j;
        this.A09 = j;
        this.A00 = i;
        this.A08 = z;
        this.A05 = trackGroupArray;
        this.A06 = h2;
    }

    public static void A00(AE ae, AE ae2) {
        ae2.A0A = ae.A0A;
        ae2.A09 = ae.A09;
    }

    public final AE A01(int i) {
        AE ae = new AE(this.A03, this.A07, this.A04.A01(i), this.A02, this.A01, this.A00, this.A08, this.A05, this.A06);
        A00(this, ae);
        return ae;
    }

    public final AE A02(int i) {
        AE ae = new AE(this.A03, this.A07, this.A04, this.A02, this.A01, i, this.A08, this.A05, this.A06);
        A00(this, ae);
        return ae;
    }

    public final AE A03(AZ az, Object obj) {
        AE ae = new AE(az, obj, this.A04, this.A02, this.A01, this.A00, this.A08, this.A05, this.A06);
        A00(this, ae);
        return ae;
    }

    public final AE A04(F6 f6, long j, long j2) {
        long j3 = j2;
        AZ az = this.A03;
        Object obj = this.A07;
        if (!f6.A02()) {
            j3 = -9223372036854775807L;
        }
        return new AE(az, obj, f6, j, j3, this.A00, this.A08, this.A05, this.A06);
    }

    public final AE A05(TrackGroupArray trackGroupArray, H2 h2) {
        AE ae = new AE(this.A03, this.A07, this.A04, this.A02, this.A01, this.A00, this.A08, trackGroupArray, h2);
        A00(this, ae);
        return ae;
    }

    public final AE A06(boolean z) {
        AE ae = new AE(this.A03, this.A07, this.A04, this.A02, this.A01, this.A00, z, this.A05, this.A06);
        A00(this, ae);
        return ae;
    }
}
