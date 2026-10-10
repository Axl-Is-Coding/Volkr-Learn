package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import com.facebook.ads.internal.exoplayer2.source.TrackGroup;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC2143aJ implements InterfaceC1643Gy {
    public static String[] A06;
    public int A00;
    public final long[] A01;
    public final Format[] A02;
    public final int A03;
    public final TrackGroup A04;
    public final int[] A05;

    static {
        A01();
    }

    public static void A01() {
        A06 = new String[]{"pUEZtwC879kNTB0j2TOCFjJulbgJhqUC", "LPVOHHlL8UGYMHe0OEH9XWTZwVKfE88", "jCWSEziDhw1FUDawrAH0", "ULlgao2XS9ulxIggOdCWnHLutHCveOYX", "OfpsRfCrHKp957e6", "lRTa0LPDu3nTDFLS", "m8d4mf9eDgFJFgmjbUCxubxaGITUd7Ju", "HrUOWAYLXAxBFn4TYCBDJo12hDa"};
    }

    public AbstractC2143aJ(TrackGroup trackGroup, int... iArr) {
        C1662Hr.A04(iArr.length > 0);
        this.A04 = (TrackGroup) C1662Hr.A01(trackGroup);
        this.A03 = iArr.length;
        this.A02 = new Format[this.A03];
        for (int i = 0; i < iArr.length; i++) {
            this.A02[i] = trackGroup.A02(iArr[i]);
        }
        Arrays.sort(this.A02, new C1633Gm());
        this.A05 = new int[this.A03];
        int i2 = 0;
        while (true) {
            int i3 = this.A03;
            if (i2 < i3) {
                this.A05[i2] = trackGroup.A01(this.A02[i2]);
                i2++;
            } else {
                this.A01 = new long[i3];
                return;
            }
        }
    }

    public final boolean A02(int i, long j) {
        return this.A01[i] > j;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1643Gy
    public void A50() {
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1643Gy
    public final Format A6Q(int i) {
        return this.A02[i];
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1643Gy
    public final int A6V(int i) {
        return this.A05[i];
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1643Gy
    public final Format A70() {
        return this.A02[A71()];
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1643Gy
    public final TrackGroup A7F() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1643Gy
    public void AAn(float f2) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (A06[5].length() != 16) {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[4] = "LRd3kE9IkICWfxuz";
        strArr[7] = "u7g1WhIErEGO9Vcw68pTGYuY7C3";
        AbstractC2143aJ abstractC2143aJ = (AbstractC2143aJ) obj;
        return this.A04 == abstractC2143aJ.A04 && Arrays.equals(this.A05, abstractC2143aJ.A05);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            int iIdentityHashCode = System.identityHashCode(this.A04);
            if (A06[6].charAt(23) != 'a') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[6] = "LdgR80foYK7ntQpYvL7rAZHaf8ikiVBs";
            strArr[6] = "LdgR80foYK7ntQpYvL7rAZHaf8ikiVBs";
            this.A00 = (iIdentityHashCode * 31) + Arrays.hashCode(this.A05);
        }
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1643Gy
    public final int length() {
        return this.A05.length;
    }
}
