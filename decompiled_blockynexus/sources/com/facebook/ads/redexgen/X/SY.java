package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class SY implements InterfaceC13163b {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ EI A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-39, -9, 2, 2, -5, -6, -74, -9, 10, 10, -9, -7, -2, -74, 5, 4, -74, -9, -74, -7, -2, -1, 2, -6, -74, ci.k, -2, -1, -7, -2, -74, -1, 9, -74, 4, 5, 10, -74, -6, -5, 10, -9, -7, -2, -5, -6, -48, -74, -75, -77, -66, -66, -73, -74, 114, -74, -73, -58, -77, -75, -70, 114, -63, -64, 114, -77, -64, 114, -77, -66, -60, -73, -77, -74, -53, 114, -74, -73, -58, -77, -75, -70, -73, -74, 114, -75, -70, -69, -66, -74, 114};
    }

    public static void A02() {
        A02 = new String[]{"m0v39bkLL0n2S0xNgN89hz2dGOcTpwho", "Je1TSnUfgjz87J45b10M9zAxXIUpZahJ", "5NPz60Ycb2xlrnlJbjQuqitLPDDjbzHA", "GN4TkK3T6zCNiBjoupvxTPY", "uEyRXI1LEgEguUOEBvXDLSZ", "uM6injuc1j2LJ4wHPsuMaMxVec9yzmkB", "WB5Y9xOLXhFok7BjZ8qu5ygjzkxXvdjS", "QTx8NC78KyDJtqbkFzNokRxLjqTFyIiz"};
    }

    public SY(EI ei) {
        this.A00 = ei;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final void A3U(View view, int i, ViewGroup.LayoutParams layoutParams) {
        C4W c4wA0G = EI.A0G(view);
        if (c4wA0G != null) {
            if (c4wA0G.A0f() || c4wA0G.A0i()) {
                c4wA0G.A0Q();
            } else {
                throw new IllegalArgumentException(A00(0, 48, 113) + c4wA0G + this.A00.A1J());
            }
        }
        this.A00.attachViewToParent(view, i, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final void A4j(int i) {
        C4W c4wA0G;
        View viewA5k = A5k(i);
        if (viewA5k != null && (c4wA0G = EI.A0G(viewA5k)) != null) {
            if (!c4wA0G.A0f() || c4wA0G.A0i()) {
                c4wA0G.A0U(256);
            } else {
                throw new IllegalArgumentException(A00(48, 43, 45) + c4wA0G + this.A00.A1J());
            }
        }
        this.A00.detachViewFromParent(i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final View A5k(int i) {
        return this.A00.getChildAt(i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final int A5l() {
        return this.A00.getChildCount();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final C4W A5o(View view) {
        return EI.A0G(view);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final int A7d(View view) {
        return this.A00.indexOfChild(view);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final void A9n(View view) {
        C4W c4wA0G = EI.A0G(view);
        if (c4wA0G != null) {
            c4wA0G.A08(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final void AAE(View view) {
        C4W c4wA0G = EI.A0G(view);
        if (c4wA0G != null) {
            c4wA0G.A09(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final void ACe() {
        int i = A5l();
        for (int i2 = 0; i2 < i; i2++) {
            View viewA5k = A5k(i2);
            this.A00.A1j(viewA5k);
            viewA5k.clearAnimation();
        }
        this.A00.removeAllViews();
        String[] strArr = A02;
        if (strArr[3].length() != strArr[4].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[2] = "YVtNrV2twtC96zFGqk3M5li58NeZhLji";
        strArr2[2] = "YVtNrV2twtC96zFGqk3M5li58NeZhLji";
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final void ACi(int i) {
        View childAt = this.A00.getChildAt(i);
        if (childAt != null) {
            this.A00.A1j(childAt);
            childAt.clearAnimation();
        }
        EI ei = this.A00;
        if (A02[2].charAt(25) == 'R') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[2] = "BurwQQkBxJzMJJK1acCycPqXpvrCcXzS";
        strArr[2] = "BurwQQkBxJzMJJK1acCycPqXpvrCcXzS";
        ei.removeViewAt(i);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13163b
    public final void addView(View view, int i) {
        this.A00.addView(view, i);
        this.A00.A1i(view);
    }
}
