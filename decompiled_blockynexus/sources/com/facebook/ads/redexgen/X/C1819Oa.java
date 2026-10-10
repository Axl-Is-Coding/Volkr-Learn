package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1819Oa {
    public static String[] A06;
    public static final int A07;
    public static final int A08;
    public static final int A09;
    public final AnonymousClass16 A00;
    public final C1F A01;
    public final C1I A02;
    public final C1P A03;
    public final C2026Wb A04;
    public final JC A05;

    public static void A02() {
        A06 = new String[]{"67PC1vS7qkP", "IjFo3BG6VwtzNtFBLMxB3hm7uxcMitzp", "CicRHWg02u8tYTVNboa", "Lc1HqPOOGgkkm0o4iF185HVfJQb2Oy4J", "rfUiy7qGv2cTTJD", "veTQu7RBhk0w6DuY7Y8JViB1PkIKs", "nFnk8VxBkehLa6QhTm5QccOE2IAl", "l0nPd7gOfqjUiTZVoVDHfvPfOU4VPF8e"};
    }

    static {
        A02();
        A09 = (int) (LX.A01 * 4.0f);
        A07 = (int) (LX.A01 * 72.0f);
        A08 = (int) (LX.A01 * 8.0f);
    }

    public C1819Oa(C2026Wb c2026Wb, J5 j5, AnonymousClass15 anonymousClass15) {
        this.A04 = c2026Wb;
        this.A05 = new JC(anonymousClass15.A0Q(), j5);
        this.A00 = anonymousClass15.A0L();
        this.A01 = anonymousClass15.A0M().A0F();
        this.A03 = anonymousClass15.A0O();
        this.A02 = anonymousClass15.A0M().A0H();
    }

    private View A00() {
        EI ei = new EI(this.A04);
        ei.setLayoutManager(new ST(this.A04, 0, false));
        ei.setAdapter(new NS(this.A04, this.A02.A00(), A09));
        return ei;
    }

    private View A01(@Nullable ViewOnClickListenerC2033Wi viewOnClickListenerC2033Wi) {
        C1800Nh c1800Nh = new C1800Nh(this.A04, this.A00.A01(), true, false, false);
        c1800Nh.A02(this.A01.A06(), this.A01.A01(), null, false, true);
        c1800Nh.setAlignment(17);
        C1794Nb c1794Nb = new C1794Nb(this.A04);
        LX.A0P(c1794Nb, 0);
        c1794Nb.setRadius(50);
        new AsyncTaskC2037Wm(c1794Nb, this.A04).A05().A08(this.A03.A01());
        LinearLayout linearLayout = new LinearLayout(this.A04);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int i = A07;
        linearLayout.addView(c1794Nb, new LinearLayout.LayoutParams(i, i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i2 = A08;
        layoutParams.setMargins(0, i2, 0, i2);
        linearLayout.addView(c1800Nh, layoutParams);
        if (viewOnClickListenerC2033Wi != null) {
            LX.A0M(viewOnClickListenerC2033Wi);
            linearLayout.addView(viewOnClickListenerC2033Wi, layoutParams);
            if (TextUtils.isEmpty(viewOnClickListenerC2033Wi.getText())) {
                LX.A0K(viewOnClickListenerC2033Wi);
            }
        }
        return linearLayout;
    }

    public final Pair<OZ, View> A03(@Nullable ViewOnClickListenerC2033Wi viewOnClickListenerC2033Wi) {
        View viewA00;
        OZ ozA04 = A04();
        if (OY.A00[ozA04.ordinal()] != 1) {
            viewA00 = A01(viewOnClickListenerC2033Wi);
        } else {
            viewA00 = A00();
        }
        JE.A04(viewA00, this.A05, JB.A0S);
        return new Pair<>(ozA04, viewA00);
    }

    public final OZ A04() {
        if (!this.A02.A00().isEmpty()) {
            return OZ.A04;
        }
        OZ oz = OZ.A03;
        String[] strArr = A06;
        if (strArr[3].charAt(8) == strArr[7].charAt(8)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[4] = "qwlEjiYhEcV8j1J";
        strArr2[4] = "qwlEjiYhEcV8j1J";
        return oz;
    }
}
