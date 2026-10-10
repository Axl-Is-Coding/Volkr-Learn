package com.facebook.ads.redexgen.X;

import android.view.View;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C13323r {
    public static byte[] A05;
    public int A00;
    public int A01;
    public boolean A02;
    public boolean A03;
    public final /* synthetic */ ST A04;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{ci.k, 1, 76, 98, 78, 78, 83, 69, 72, 79, 64, 85, 68, 28, 111, 99, 46, ci.m, 34, 58, 44, 54, 55, 5, 49, 44, 46, 6, 45, 39, 126, 91, 87, 26, 33, 22, 27, 30, 19, 74, 116, 91, 86, 93, 90, 71, 124, 91, 83, 90, 78, 88, 101, 90, 70, 92, 65, 92, 90, 91, 8};
    }

    public C13323r(ST st) {
        this.A04 = st;
        A03();
    }

    public final void A02() {
        int iA0A;
        if (this.A02) {
            iA0A = this.A04.A04.A07();
        } else {
            iA0A = this.A04.A04.A0A();
        }
        this.A00 = iA0A;
    }

    public final void A03() {
        this.A01 = -1;
        this.A00 = Integer.MIN_VALUE;
        this.A02 = false;
        this.A03 = false;
    }

    public final void A04(View view) {
        if (this.A02) {
            this.A00 = this.A04.A04.A0C(view) + this.A04.A04.A05();
        } else {
            this.A00 = this.A04.A04.A0F(view);
        }
        this.A01 = this.A04.A0q(view);
    }

    public final void A05(View view) {
        int estimatedEnd = this.A04.A04.A05();
        if (estimatedEnd >= 0) {
            A04(view);
            return;
        }
        this.A01 = this.A04.A0q(view);
        if (this.A02) {
            int iA07 = this.A04.A04.A07() - estimatedEnd;
            int childEnd = this.A04.A04.A0C(view);
            int i = iA07 - childEnd;
            int childEnd2 = this.A04.A04.A07();
            this.A00 = childEnd2 - i;
            if (i > 0) {
                int childEnd3 = this.A04.A04.A0D(view);
                int previousEndMargin = this.A00;
                int previousEndMargin2 = previousEndMargin - childEnd3;
                int iA0A = this.A04.A04.A0A();
                int layoutStart = this.A04.A04.A0F(view);
                int startReference = Math.min(layoutStart - iA0A, 0) + iA0A;
                int previousEndMargin3 = previousEndMargin2 - startReference;
                if (previousEndMargin3 < 0) {
                    int startMargin = -previousEndMargin3;
                    this.A00 += Math.min(i, startMargin);
                    return;
                }
                return;
            }
            return;
        }
        int iA0F = this.A04.A04.A0F(view);
        int iA0A2 = iA0F - this.A04.A04.A0A();
        this.A00 = iA0F;
        if (iA0A2 <= 0) {
            return;
        }
        int iA0D = this.A04.A04.A0D(view) + iA0F;
        int iA072 = this.A04.A04.A07() - estimatedEnd;
        int previousLayoutEnd = this.A04.A04.A0C(view);
        int estimatedEnd2 = this.A04.A04.A07();
        int previousEndMargin4 = Math.min(0, iA072 - previousLayoutEnd);
        int estimatedEnd3 = (estimatedEnd2 - previousEndMargin4) - iA0D;
        if (estimatedEnd3 >= 0) {
            return;
        }
        int endMargin = -estimatedEnd3;
        this.A00 -= Math.min(iA0A2, endMargin);
    }

    public final boolean A06(View view, C4T c4t) {
        C4F c4f = (C4F) view.getLayoutParams();
        return !c4f.A02() && c4f.A00() >= 0 && c4f.A00() < c4t.A03();
    }

    public final String toString() {
        return A00(40, 21, 73) + this.A01 + A00(0, 14, 93) + this.A00 + A00(14, 17, 63) + this.A02 + A00(31, 9, 11) + this.A03 + '}';
    }
}
