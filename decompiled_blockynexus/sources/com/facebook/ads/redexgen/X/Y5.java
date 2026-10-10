package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.umeng.analytics.pro.ci;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"ViewConstructor"})
@TargetApi(16)
public final class Y5 extends RelativeLayout implements M0 {
    public static byte[] A0Q;
    public static String[] A0R;
    public static final int A0S;
    public static final int A0T;
    public static final int A0U;
    public static final int A0V;
    public static final int A0W;
    public static final int A0X;
    public static final int A0Y;
    public static final int A0Z;
    public static final int A0a;
    public static final RelativeLayout.LayoutParams A0b;

    @Nullable
    public View A00;

    @Nullable
    public RelativeLayout A01;

    @Nullable
    public RelativeLayout A02;
    public Toast A03;

    @Nullable
    public C13604u A04;

    @Nullable
    public ViewOnClickListenerC2033Wi A05;
    public OV A06;
    public boolean A07;
    public boolean A08;
    public final AnonymousClass15 A09;
    public final C1R A0A;
    public final InterfaceC13584s A0B;
    public final C2026Wb A0C;
    public final J5 A0D;
    public final JC A0E;
    public final C1738Kw A0F;
    public final LL A0G;
    public final InterfaceC1767Lz A0H;
    public final MU A0I;
    public final C1819Oa A0J;
    public final C1820Ob A0K;
    public final AtomicBoolean A0L;
    public final AtomicBoolean A0M;
    public final boolean A0N;
    public final boolean A0O;

    @VisibleForTesting
    public final AbstractC1762Lu A0P;

    public static String A0C(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Q, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 40);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0M() {
        A0Q = new byte[]{-110, -97, -94, -70, -84, -86, -70, -92, 4, ci.k, 10, 4, 12, 0, ci.n, 19, 10, 8, 10, ci.m, -77, -65, -67, 126, -74, -79, -77, -75, -78, -65, -65, -69, 126, -79, -76, -61, 126, -71, -66, -60, -75, -62, -61, -60, -71, -60, -71, -79, -68, 126, -77, -68, -71, -77, -69, -75, -76, -11, -6, 0, -15, -2, -1, 0, -11, 0, -11, -19, -8, -55, -68, -49, -60, -47, -64, -70, -66, -57, -60, -66, -58, -43, -47, -58, -56, -54, -46, -54, -45, -39, -65, -78, -60, -82, -65, -79, -78, -79, -84, -61, -74, -79, -78, -68, -80, -98, -101, -81, -94, -98, -80, -104, -100, -91, -94, -100, -92};
    }

    public static void A0N() {
        A0R = new String[]{"57rzzR6raHrat8cHk0n2c9utIvWN6OL8", "vZo4DQACnHxpUIABCEPhLIrXR", "3pKkUgRnbq5D8", "3oPHUcYdGBLGT6sjvwgTS6nCZs8dHXKK", "yMOWmEDq6oq3Yf8aoY", "BRjJ0geTmUVj6Aeo1VqVThKYcHpwhF7A", "bCnfD5Zsza6fNT9UI62TNCVdI9Gt63Qd", "0XbQU4AacrxlEwxF12eBigHvJ8"};
    }

    static {
        A0N();
        A0M();
        A0Z = (int) (LX.A01 * 64.0f);
        A0U = (int) (LX.A01 * 16.0f);
        A0a = (int) (LX.A01 * 12.0f);
        A0S = (int) (LX.A01 * 10.0f);
        A0b = new RelativeLayout.LayoutParams(-1, -1);
        A0V = (int) (LX.A01 * 48.0f);
        A0W = (int) (LX.A01 * 16.0f);
        A0Y = (int) (LX.A01 * 14.0f);
        A0X = C2F.A01(-1, 77);
        A0T = (int) (LX.A01 * 8.0f);
    }

    public Y5(C2026Wb c2026Wb, J5 j5, InterfaceC1767Lz interfaceC1767Lz, AnonymousClass15 anonymousClass15, @Nullable String str, MU mu) {
        super(c2026Wb);
        this.A0B = new ZS(this);
        this.A0M = new AtomicBoolean(false);
        this.A0L = new AtomicBoolean(false);
        this.A0C = c2026Wb;
        this.A0H = interfaceC1767Lz;
        this.A0D = j5;
        this.A09 = anonymousClass15;
        this.A0A = anonymousClass15.A0M().A0E().A06();
        this.A0E = new JC(this.A09.A0Q(), this.A0D);
        this.A0I = mu;
        this.A0K = new C1820Ob(c2026Wb, this.A0I, str, this.A0H);
        this.A0M.set(!this.A0A.A0I());
        this.A0F = new C1738Kw(this.A0A.A08(), new ZF(this, null));
        this.A0O = C1693Iy.A1i(this.A0C);
        this.A0N = C1693Iy.A0g(this.A0C);
        this.A0P = A05();
        this.A0J = new C1819Oa(this.A0C, this.A0D, this.A09);
        if (this.A0O) {
            C1801Ni.A00(c2026Wb, this, anonymousClass15.A0M().A0E().A07());
        } else {
            LX.A0P(this, -14473425);
        }
        this.A0G = new LL(this);
        this.A0G.A05(LK.A03);
    }

    private AbstractC1762Lu A05() {
        FullScreenAdToolbar fullScreenAdToolbar = new FullScreenAdToolbar(this.A0C, this.A0H, this.A0E, 0, this.A09.A0E());
        fullScreenAdToolbar.A05(this.A09.A0L().A01(), true);
        fullScreenAdToolbar.setPageDetailsVisible(false);
        fullScreenAdToolbar.setPageDetails(this.A09.A0O(), this.A09.A0Q(), this.A0A.A08(), this.A09.A0P());
        fullScreenAdToolbar.setToolbarListener(new ZO(this));
        return fullScreenAdToolbar;
    }

    @Nullable
    private ViewOnClickListenerC2033Wi A08() {
        OV ov = this.A06;
        if (ov == null || ov.getViewabilityChecker() == null || this.A06.getTouchDataRecorder() == null) {
            return null;
        }
        C1G c1gA01 = this.A09.A0L().A01();
        ViewOnClickListenerC2033Wi viewOnClickListenerC2033Wi = new ViewOnClickListenerC2033Wi(this.A0C, A0C(20, 37, 40), c1gA01, this.A0D, this.A0H, this.A06.getViewabilityChecker(), this.A06.getTouchDataRecorder());
        LX.A0N(viewOnClickListenerC2033Wi);
        viewOnClickListenerC2033Wi.setText(this.A09.A0M().A0G().A03());
        viewOnClickListenerC2033Wi.setTextSize(14.0f);
        viewOnClickListenerC2033Wi.setIncludeFontPadding(false);
        int i = A0S;
        viewOnClickListenerC2033Wi.setPadding(i, i, i, i);
        if (!this.A0O) {
            LX.A0Q(viewOnClickListenerC2033Wi, 8);
        }
        viewOnClickListenerC2033Wi.setOnClickListener(new MA(this));
        return viewOnClickListenerC2033Wi;
    }

    private C1800Nh A0A() {
        C1800Nh c1800Nh = new C1800Nh(this.A0C, this.A09.A0L().A01(), true, 16, 14, 0);
        c1800Nh.A02(this.A09.A0M().A0F().A06(), this.A09.A0M().A0F().A05(), null, false, true);
        TextView descriptionTextView = c1800Nh.getDescriptionTextView();
        descriptionTextView.setAlpha(0.8f);
        descriptionTextView.setMaxLines(1);
        descriptionTextView.setEllipsize(TextUtils.TruncateAt.END);
        TextView titleTextView = c1800Nh.getTitleTextView();
        titleTextView.setMaxLines(1);
        titleTextView.setEllipsize(TextUtils.TruncateAt.END);
        return c1800Nh;
    }

    private void A0F() {
        int i = A0V;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(15);
        layoutParams.addRule(9);
        C1794Nb c1794Nb = new C1794Nb(this.A0C);
        LX.A0P(c1794Nb, 0);
        LX.A0N(c1794Nb);
        AsyncTaskC2037Wm asyncTaskC2037Wm = new AsyncTaskC2037Wm(c1794Nb, this.A0C);
        int i2 = A0V;
        asyncTaskC2037Wm.A06(i2, i2).A08(this.A09.A0O().A01());
        TextView textView = new TextView(this.A0C);
        LX.A0N(textView);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setTextColor(this.A09.A0L().A01().A06(true));
        textView.setText(this.A09.A0M().A0F().A06());
        textView.setTextSize(16.0f);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        C1796Nd c1796Nd = new C1796Nd(this.A0C, A0Y, 5, A0X, -1);
        c1796Nd.setGravity(16);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -1);
        TextView textView2 = new TextView(this.A0C);
        textView2.setTextColor(this.A09.A0L().A01().A06(true));
        textView2.setGravity(16);
        textView2.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -1);
        layoutParams3.leftMargin = A0T;
        LinearLayout linearLayout = new LinearLayout(this.A0C);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, A0W);
        layoutParams4.topMargin = A0T / 2;
        layoutParams4.addRule(3, textView.getId());
        linearLayout.addView(c1796Nd, layoutParams2);
        linearLayout.addView(textView2, layoutParams3);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = A0T;
        layoutParams5.addRule(1, c1794Nb.getId());
        layoutParams5.addRule(15);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.addView(linearLayout, layoutParams4);
        relativeLayout.addView(textView);
        RelativeLayout relativeLayout2 = this.A02;
        if (relativeLayout2 != null) {
            relativeLayout2.removeAllViews();
            RelativeLayout relativeLayout3 = this.A02;
            if (A0R[4].length() != 18) {
                throw new RuntimeException();
            }
            String[] strArr = A0R;
            strArr[4] = "bsFsSO04IJ4eZVQxRT";
            strArr[4] = "bsFsSO04IJ4eZVQxRT";
            relativeLayout3.addView(relativeLayout, layoutParams5);
            this.A02.addView(c1794Nb, layoutParams);
        }
        if (TextUtils.isEmpty(this.A09.A0M().A0F().A03())) {
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        c1796Nd.setRating(Float.parseFloat(this.A09.A0M().A0F().A03()));
        if (this.A09.A0M().A0F().A02() == null) {
            return;
        }
        textView2.setText(A0C(0, 1, 66) + NumberFormat.getNumberInstance().format(Integer.parseInt(this.A09.A0M().A0F().A02())) + A0C(1, 1, 78));
    }

    private void A0G() {
        if (this.A0A.A0I()) {
            A0I();
        } else {
            A0J();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            this.A0G.A05(LK.A04);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H() {
        this.A08 = true;
        if (this.A09.A0M().A0L()) {
            this.A0K.A06();
            this.A0H.A3t(this.A0I.A5M(), new C7l(0, 0));
            if (this.A07) {
                boolean z = this.A0O;
                if (A0R[4].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A0R;
                strArr[1] = "I0JtICznoezMzS0InHXj65Cim";
                strArr[2] = "YxqOCBuXvZfwM";
                if (!z) {
                    NX.A03(this.A0C, this.A06.getViewabilityChecker(), this.A06.getTouchDataRecorder(), this.A0D, this.A09.A0M().A0G(), this.A09.A0Q());
                }
            }
        }
    }

    private void A0I() {
        OE oeA0B = new OC(this.A0C, this.A09.A0M().A0F(), this.A09.A0O()).A08(this.A09.A0L().A01()).A0A(this.A0A.A0G()).A09(this.A0A.A0E()).A07(2000).A0B();
        JE.A04(oeA0B, this.A0E, JB.A0U);
        addView(oeA0B, A0b);
        oeA0B.A04(new ZP(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0J() {
        LX.A0X(this);
        this.A06.A0C();
        this.A05 = A08();
        this.A01 = new RelativeLayout(getContext());
        LX.A0N(this.A01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int i = A0U;
        int i2 = A0a;
        layoutParams.setMargins(i, i2, i, i2);
        layoutParams.addRule(12);
        this.A02 = new RelativeLayout(getContext());
        LX.A0N(this.A02);
        if (this.A0N) {
            A0F();
        } else {
            RelativeLayout relativeLayout = this.A02;
            C1800Nh c1800NhA0A = A0A();
            RelativeLayout.LayoutParams toolbarParams = new RelativeLayout.LayoutParams(-2, -2);
            relativeLayout.addView(c1800NhA0A, toolbarParams);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, A0U, 0);
        this.A01.addView(this.A02, layoutParams2);
        ViewOnClickListenerC2033Wi viewOnClickListenerC2033Wi = this.A05;
        if (viewOnClickListenerC2033Wi != null) {
            layoutParams2.addRule(0, viewOnClickListenerC2033Wi.getId());
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(6, this.A02.getId());
            layoutParams3.addRule(8, this.A02.getId());
            this.A01.addView(this.A05, layoutParams3);
        }
        LX.A0N(this.A0P);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(10);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        int i3 = A0U;
        layoutParams5.setMargins(i3, 0, i3, 0);
        layoutParams5.addRule(3, this.A0P.getId());
        layoutParams5.addRule(2, this.A01.getId());
        addView(this.A0P, layoutParams4);
        addView(this.A06, layoutParams5);
        addView(this.A01, layoutParams);
        this.A0F.A08();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0K() {
        new JC(this.A09.A0Q(), this.A0D).A03(JB.A0n, null);
        this.A0L.set(true);
        LX.A0X(this);
        LX.A0K(this.A06);
        LX.A0d(this.A06, this.A00);
        LX.A0O(this.A0P);
        Pair<OZ, View> pairA03 = this.A0J.A03(this.A05);
        this.A00 = (View) pairA03.second;
        int i = MB.A00[((OZ) pairA03.first).ordinal()];
        if (i != 1) {
            if (i != 2) {
                return;
            }
            RelativeLayout relativeLayout = this.A01;
            if (relativeLayout != null) {
                LX.A0d(relativeLayout);
            }
            addView(this.A00, new RelativeLayout.LayoutParams(-1, -1));
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, this.A0P.getToolbarHeight(), 0, 0);
        RelativeLayout relativeLayout2 = this.A01;
        if (relativeLayout2 != null) {
            layoutParams.addRule(2, relativeLayout2.getId());
        }
        addView(this.A00, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L() {
        Toast toast = this.A03;
        if (toast != null && toast.getView().getWindowVisibility() == 0) {
            return;
        }
        this.A03 = Toast.makeText(getContext(), this.A0A.A0D(), 1);
        A0O((int) this.A0F.A04());
        this.A03.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0O(int i) {
        LX.A0c(this.A03, this.A0A.A0D().replace(A0C(2, 6, 31), String.valueOf(i)), 49, 0, A0Z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0V(boolean z) {
        HashMap map = new HashMap();
        map.put(A0C(8, 12, 121), z ? A0C(104, 13, 17) : A0C(69, 12, 51));
        NX nx = new NX(this.A0C, this.A0I.A5p(), this.A06.getViewabilityChecker(), this.A06.getTouchDataRecorder(), this.A0D, this.A0H);
        if (this.A0O) {
            nx.A08(this.A09.A0Q(), this.A09.A0M().A0G().A04(), map);
            return;
        }
        boolean z2 = !this.A0F.A05();
        nx.A0A(!z2);
        nx.A08(this.A09.A0Q(), this.A09.A0M().A0G().A04(), map);
        if (z2) {
            new Handler(Looper.getMainLooper()).post(new ZN(this));
        }
        this.A07 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0W() {
        if (!this.A09.A0T().equals(A0C(90, 14, 37))) {
            if (this.A09.A0T().equals(A0C(57, 12, 100))) {
                AnonymousClass15 anonymousClass15 = this.A09;
                if (A0R[4].length() != 18) {
                    throw new RuntimeException();
                }
                String[] strArr = A0R;
                strArr[0] = "r5y7OBqhAYVA47bIfl4AlIWKO2XfiX80";
                strArr[0] = "r5y7OBqhAYVA47bIfl4AlIWKO2XfiX80";
                if (anonymousClass15.A0M().A0N()) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void A85(Intent intent, Bundle bundle, C13604u c13604u) {
        this.A04 = c13604u;
        this.A04.A0L(this.A0B);
        HashMap map = new HashMap();
        map.put(A0C(81, 9, 61), this.A0I.A6q());
        C1R c1rA06 = this.A09.A0M().A0E().A06();
        if (c1rA06 == null) {
            this.A0H.A3s(this.A0I.A6J());
            this.A0H.A3s(this.A0I.A6E());
        } else {
            this.A06 = new OV(this.A0C, this.A09, c1rA06, this.A0D, new C2086Yj(this, null), map);
            this.A0H.A3L(this, new RelativeLayout.LayoutParams(-1, -1));
            A0G();
        }
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AAh(boolean z) {
        this.A0F.A07();
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AB4(boolean z) {
        if (this.A0M.get() && !this.A0F.A06()) {
            C1738Kw c1738Kw = this.A0F;
            if (A0R[5].charAt(2) == 'm') {
                throw new RuntimeException();
            }
            String[] strArr = A0R;
            strArr[0] = "UQp6GtSKm4mkcrS1rXAjxFqYQJcA6U4M";
            strArr[0] = "UQp6GtSKm4mkcrS1rXAjxFqYQJcA6U4M";
            c1738Kw.A08();
        }
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void ACz(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void onDestroy() {
        this.A0G.A03();
        C13604u c13604u = this.A04;
        if (c13604u != null) {
            c13604u.A0M(this.A0B);
        }
        if (this.A06 != null) {
            AnonymousClass15 anonymousClass15 = this.A09;
            if (A0R[0].charAt(29) == 'D') {
                throw new RuntimeException();
            }
            String[] strArr = A0R;
            strArr[0] = "voPpcOtL9PQSCLq1wYvqOCQr8JaLbGKq";
            strArr[0] = "voPpcOtL9PQSCLq1wYvqOCQr8JaLbGKq";
            if (!TextUtils.isEmpty(anonymousClass15.A0Q())) {
                this.A0D.A8E(this.A09.A0Q(), new NQ().A04(this.A06.getViewabilityChecker()).A03(this.A06.getTouchDataRecorder()).A06());
            }
            this.A06.A0D();
        }
        this.A0F.A07();
        this.A0P.setToolbarListener(null);
        this.A03 = null;
        this.A04 = null;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            AB4(false);
        } else {
            AAh(false);
        }
    }

    public void setListener(InterfaceC1767Lz interfaceC1767Lz) {
    }
}
