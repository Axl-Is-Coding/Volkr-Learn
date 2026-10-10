package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.trackselection.DefaultTrackSelector$Parameters;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1636Gp implements Comparable<C1636Gp> {
    public static String[] A07;
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final DefaultTrackSelector$Parameters A06;

    static {
        A00();
    }

    public static void A00() {
        A07 = new String[]{"UOhnAWHUvWrKh39blc2", "rJoZ4rjs3", "mwxErCj8CFXQtRdeT7I", "OMBsSVN1m", "xKR0iM7hb", "rY23JmNnbt4", "7JhRM9", "FTdecT"};
    }

    public C1636Gp(Format format, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, int i) {
        this.A06 = defaultTrackSelector$Parameters;
        this.A05 = AH.A0I(i, false) ? 1 : 0;
        this.A03 = AH.A0L(format, defaultTrackSelector$Parameters.A07) ? 1 : 0;
        this.A02 = (format.A0D & 1) != 0 ? 1 : 0;
        this.A01 = format.A05;
        this.A04 = format.A0C;
        this.A00 = format.A04;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final int compareTo(C1636Gp c1636Gp) {
        int i = this.A05;
        int i2 = c1636Gp.A05;
        if (i != i2) {
            return AH.A01(i, i2);
        }
        int i3 = this.A03;
        int i4 = c1636Gp.A03;
        if (i3 != i4) {
            return AH.A01(i3, i4);
        }
        int i5 = this.A02;
        int i6 = c1636Gp.A02;
        if (i5 != i6) {
            return AH.A01(i5, i6);
        }
        if (this.A06.A0D) {
            return AH.A01(c1636Gp.A00, this.A00);
        }
        int i7 = this.A05 != 1 ? -1 : 1;
        int i8 = this.A01;
        int i9 = c1636Gp.A01;
        String[] strArr = A07;
        if (strArr[6].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A07;
        strArr2[3] = "q1nzmC2W0";
        strArr2[3] = "q1nzmC2W0";
        if (i8 != i9) {
            return AH.A01(i8, i9) * i7;
        }
        int i10 = this.A04;
        int i11 = c1636Gp.A04;
        return i10 != i11 ? AH.A01(i10, i11) * i7 : AH.A01(this.A00, c1636Gp.A00) * i7;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1636Gp c1636Gp = (C1636Gp) obj;
        if (this.A05 == c1636Gp.A05 && this.A03 == c1636Gp.A03 && this.A02 == c1636Gp.A02 && this.A01 == c1636Gp.A01 && this.A04 == c1636Gp.A04) {
            int i = this.A00;
            if (A07[5].length() != 11) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[0] = "5gFFNpUtyAKNtlVcilC";
            strArr[2] = "oFDw9vE2Y7jHYxyqfLD";
            if (i == c1636Gp.A00) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((this.A05 * 31) + this.A03) * 31;
        int result = this.A02;
        int i2 = (((i + result) * 31) + this.A01) * 31;
        int result2 = this.A04;
        return ((i2 + result2) * 31) + this.A00;
    }
}
