package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ss, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1939Ss extends AbstractC12520n {
    public static byte[] A03;
    public View A00;
    public final C13554p A01;
    public final C1534Cl A02;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 53);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{-23, 7, 20, 20, 21, 26, -58, 22, 24, 11, 25, 11, 20, 26, -58, 20, 27, 18, 18, -58, 7, 10, -4, ci.m, 11, 29};
    }

    public C1939Ss(C13554p c13554p) {
        this.A02 = c13554p.A0A();
        this.A01 = c13554p;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0B() {
        this.A02.A0A().A3e();
        KK.A00(new C1937Sq(this));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0C() {
        this.A02.A0A().A3h();
        KK.A00(new C1938Sr(this));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0D(View view) {
        if (view != null) {
            this.A02.A0A().A3g();
            this.A00 = view;
            this.A01.A08().removeAllViews();
            this.A01.A08().addView(this.A00);
            if (this.A00 instanceof C2044Wt) {
                C1704Jl.A04(this.A01.A06(), this.A00, this.A01.A0B());
            }
            C1581Ek c1581EkA09 = this.A01.A09();
            if (c1581EkA09 != null) {
                c1581EkA09.A0J();
            }
            KK.A00(new C1936Sp(this));
            C13554p c13554p = this.A01;
            c13554p.A0C(c13554p.A08(), this.A00);
            if (Build.VERSION.SDK_INT >= 18 && C1693Iy.A0r(this.A01.A08().getContext())) {
                final NO no = new NO();
                this.A01.A0E(no);
                no.A0D(this.A01.getPlacementId());
                no.A0C(this.A01.A08().getContext().getPackageName());
                if (this.A01.A09() != null && this.A01.A09().A0H() != null) {
                    no.A0A(this.A01.A09().A0H().A0C());
                }
                View view2 = this.A00;
                if (view2 instanceof C2044Wt) {
                    no.A0B(((C2044Wt) view2).getViewabilityChecker());
                }
                this.A00.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.facebook.ads.redexgen.X.4y
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view3) {
                        if (this.A00.A00 != null) {
                            no.setBounds(0, 0, this.A00.A00.getWidth(), this.A00.A00.getHeight());
                            no.A0E(!r1.A0F());
                        }
                        return true;
                    }
                });
                this.A00.getOverlay().add(no);
                return;
            }
            return;
        }
        throw new IllegalStateException(A02(0, 26, 113));
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0E(InterfaceC12510m interfaceC12510m) {
        this.A02.A0A().A3f(this.A01.A09() != null);
        if (this.A01.A09() != null) {
            this.A01.A09().A0K();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12520n
    public final void A0F(C1697Jd c1697Jd) {
        this.A02.A0A().A2d(LP.A01(this.A01.A05()), c1697Jd.A04().getErrorCode(), c1697Jd.A05());
        KK.A00(new C1935So(this, c1697Jd));
    }
}
