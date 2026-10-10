package com.facebook.ads.redexgen.X;

import com.sandboxol.center.config.VipSubscribeStatus;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2152aS implements H4 {
    public static byte[] A08;
    public static String[] A09;
    public int A00;
    public int A01;
    public int A02;
    public H3[] A03;
    public final int A04;
    public final boolean A05;
    public final byte[] A06;
    public final H3[] A07;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 123);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A08 = new byte[]{-69, -81, -2, 23, ci.l, 33, 25, ci.l, 12, 29, ci.l, ci.k, -55, 10, 21, 21, 24, 12, 10, 29, 18, 24, 23, -29, -55};
    }

    public static void A02() {
        A09 = new String[]{"4ve0RWyhYyl9xCQBcFEHHb6J5", "0", "sHlJnKRUCXWWG8DJxhYmJcdBG87KccAz", "Y1hOWn5yAZG8wtugOKE5SlkzB9Lmm", "ccLKzhNJONN8hN3GMkJFYY9R9j4tosDy", "kB2MLz2Qt2VhBov62BdjLbPbFvH", "HEcEuygojM8kHr", "TVH0enYaQUtbllarZb7wcHSuDyXsicXL"};
    }

    public C2152aS(boolean z, int i) {
        this(z, i, 0);
    }

    public C2152aS(boolean z, int i, int i2) {
        C1662Hr.A03(i > 0);
        C1662Hr.A03(i2 >= 0);
        this.A05 = z;
        this.A04 = i;
        this.A01 = i2;
        this.A03 = new H3[i2 + 100];
        if (i2 > 0) {
            this.A06 = new byte[i2 * i];
            for (int i3 = 0; i3 < i2; i3++) {
                this.A03[i3] = new H3(this.A06, i3 * i);
            }
        } else {
            this.A06 = null;
        }
        this.A07 = new H3[1];
    }

    public final synchronized int A03() {
        int i;
        i = this.A00 * this.A04;
        String[] strArr = A09;
        if (strArr[3].length() == strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[0] = "5S97W7P0mYMCYwMDzMcet6TY3";
        strArr2[1] = VipSubscribeStatus.SUBSCRIPTION_RESTARTED;
        return i;
    }

    public final synchronized void A04() {
        if (this.A05) {
            A05(0);
        }
    }

    public final synchronized void A05(int i) {
        boolean z = i < this.A02;
        this.A02 = i;
        if (z) {
            ADs();
        }
    }

    @Override // com.facebook.ads.redexgen.X.H4
    public final synchronized H3 A3N() {
        H3 h3;
        this.A00++;
        if (this.A01 > 0) {
            H3[] h3Arr = this.A03;
            int i = this.A01 - 1;
            this.A01 = i;
            h3 = h3Arr[i];
            this.A03[this.A01] = null;
        } else {
            h3 = new H3(new byte[this.A04], 0);
        }
        return h3;
    }

    @Override // com.facebook.ads.redexgen.X.H4
    public final int A6W() {
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.H4
    public final synchronized void ACX(H3 h3) {
        this.A07[0] = h3;
        ACY(this.A07);
        String[] strArr = A09;
        if (strArr[0].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A09;
        strArr2[2] = "vTQnHDwqIVvtvGKS6QPwZVkZoK1Lgm5f";
        strArr2[2] = "vTQnHDwqIVvtvGKS6QPwZVkZoK1Lgm5f";
    }

    @Override // com.facebook.ads.redexgen.X.H4
    public final synchronized void ACY(H3[] h3Arr) {
        if (this.A01 + h3Arr.length >= this.A03.length) {
            this.A03 = (H3[]) Arrays.copyOf(this.A03, Math.max(this.A03.length * 2, this.A01 + h3Arr.length));
        }
        for (H3 h3 : h3Arr) {
            if (h3.A01 == this.A06 || h3.A01.length == this.A04) {
                H3[] h3Arr2 = this.A03;
                int i = this.A01;
                this.A01 = i + 1;
                h3Arr2[i] = h3;
            } else {
                throw new IllegalArgumentException(A00(2, 23, 46) + System.identityHashCode(h3.A01) + A00(0, 2, 20) + System.identityHashCode(this.A06) + A00(0, 2, 20) + h3.A01.length + A00(0, 2, 20) + this.A04);
            }
        }
        this.A00 -= h3Arr.length;
        notifyAll();
    }

    @Override // com.facebook.ads.redexgen.X.H4
    public final synchronized void ADs() {
        int lowIndex = Math.max(0, IW.A04(this.A02, this.A04) - this.A00);
        if (lowIndex >= this.A01) {
            return;
        }
        if (this.A06 != null) {
            int i = 0;
            int i2 = this.A01 - 1;
            while (i <= i2) {
                H3 h3 = this.A03[i];
                if (h3.A01 == this.A06) {
                    i++;
                } else {
                    H3 h32 = this.A03[i2];
                    if (h32.A01 != this.A06) {
                        i2--;
                    } else {
                        int highIndex = i + 1;
                        this.A03[i] = h32;
                        this.A03[i2] = h3;
                        i2--;
                        i = highIndex;
                    }
                }
            }
            lowIndex = Math.max(lowIndex, i);
            if (lowIndex >= this.A01) {
                return;
            }
        }
        Arrays.fill(this.A03, lowIndex, this.A01, (Object) null);
        this.A01 = lowIndex;
    }
}
