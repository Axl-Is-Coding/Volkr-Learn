package com.facebook.ads.redexgen.X;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import java.util.Arrays;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1880Qj extends AbstractC1803Nk {

    @Nullable
    public static C1880Qj A0P;
    public static byte[] A0Q;
    public static String[] A0R;
    public static final int A0S;
    public static final int A0T;
    public static final int A0U;
    public static final int A0V;
    public static final int A0W;
    public float A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public View A06;
    public LinearLayout A07;
    public LinearLayout A08;
    public TextView A09;
    public AnonymousClass15 A0A;
    public N4 A0B;
    public N5 A0C;

    @Nullable
    public XM A0D;
    public C1807No A0E;
    public C1816Nx A0F;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0J;
    public boolean A0K;
    public final View A0L;
    public final AbstractC12430e A0M;
    public final JC A0N;
    public final C1638Gs A0O;

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Q, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0L() {
        A0Q = new byte[]{36};
    }

    public static void A0M() {
        A0R = new String[]{"E7d9V", "HfiTPdnQE6JsOHdYoOA4lRNnbQ3", "7AVXCU5oRbsgBqmorHmAVCwb6r5tuTQ8", "hoWzaZbN7yXesQFa", "a3ZYa3", "EXUfJIeYYGyfdCGOPOS2l0on83CPH94Z", "MYJwByDzw5bCUSkxw6qgTJ7WJbI", "X3l5ZIwYV4"};
    }

    static {
        A0M();
        A0L();
        A0U = (int) (LX.A01 * 26.0f);
        A0S = (int) (LX.A01 * 4.0f);
        A0W = (int) (LX.A01 * 8.0f);
        A0T = C2F.A01(-1, 77);
        A0V = (int) (LX.A01 * 12.0f);
        A0P = null;
    }

    public C1880Qj(C1807No c1807No) {
        super(c1807No, true);
        this.A01 = 0;
        this.A0G = false;
        this.A0I = false;
        this.A0K = false;
        this.A0J = false;
        this.A0E = c1807No;
        this.A0A = this.A0E.A04();
        this.A0N = new JC(c1807No.A04().A0Q(), c1807No.A06());
        this.A0O = this.A0E.A0A();
        C1638Gs c1638Gs = this.A0O;
        if (c1638Gs != null) {
            LX.A0N(c1638Gs);
        }
        this.A0L = this.A0E.A03();
        this.A0M = C12440f.A01(c1807No.A05(), c1807No.A06(), c1807No.A04().A0Q(), Uri.parse(c1807No.A04().A0M().A0G().A04()), new HashMap(), false, true);
        C1801Ni.A00(c1807No.A05(), this, c1807No.A04().A0M().A0E().A07());
        setupLayoutConfiguration(false);
        A0G();
        A0C();
        postDelayed(new SN(this), 1000L);
        A0K();
    }

    private void A0B() {
        LX.A0M(this.A08);
        this.A08 = new LinearLayout(this.A0E.A05());
        LX.A0V(this.A08, getAdContextWrapper());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A0G ? this.A02 / 4 : this.A02 / 5);
        layoutParams.addRule(12);
        this.A08.setLayoutParams(layoutParams);
        addView(this.A08, 2);
    }

    private void A0C() {
        LX.A0M(this.A07);
        this.A07 = new LinearLayout(this.A0E.A05());
        this.A07.setOrientation(1);
        LX.A0N(this.A07);
        A0H();
        this.A07.setBackgroundColor(-1);
        addView(this.A07);
    }

    private void A0D() {
        View view = this.A0L;
        if (view != null) {
            LX.A0M(view);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AbstractC1803Nk.A0A, AbstractC1803Nk.A0A);
            layoutParams.addRule(10);
            layoutParams.addRule(11);
            layoutParams.setMargins(AbstractC1803Nk.A09, this.A05, AbstractC1803Nk.A09, AbstractC1803Nk.A09);
            addView(this.A0L, layoutParams);
        }
    }

    private void A0E() {
        C1638Gs c1638Gs = this.A0O;
        if (c1638Gs != null) {
            LX.A0M(c1638Gs);
            C1638Gs c1638Gs2 = this.A0O;
            int i = A0V;
            c1638Gs2.setPadding(i, i, i, i);
            this.A0O.A0A(-1, A0T);
            this.A0O.setTranslationY(WheelView.DividerConfig.FILL);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, A0U);
            if (this.A0H) {
                layoutParams.addRule(8, this.A06.getId());
            } else {
                String[] strArr = A0R;
                if (strArr[3].length() == strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0R;
                strArr2[3] = "zjul6o0OG2Ezis8Q";
                strArr2[0] = "LmcEL";
                layoutParams.addRule(12);
            }
            addView(this.A0O, layoutParams);
        }
    }

    private void A0F() {
        AbstractC1762Lu abstractC1762LuA08 = this.A0E.A08();
        if (abstractC1762LuA08 == null) {
            return;
        }
        abstractC1762LuA08.setPageDetailsVisible((this.A0H || abstractC1762LuA08.A07()) ? false : true);
    }

    private void A0G() {
        this.A06 = this.A0E.A02();
        LX.A0M(this.A06);
        LX.A0N(this.A06);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        addView(this.A06, 1, layoutParams);
        this.A09 = new TextView(this.A0E.A05());
        LX.A0N(this.A09);
        this.A09.setGravity(17);
        this.A09.setTextColor(getColors().A05(true));
        this.A09.setEllipsize(TextUtils.TruncateAt.END);
        this.A09.setMaxLines(2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(12);
        int i = A0W;
        layoutParams2.setMargins(i, i / 2, i, this.A0O == null ? i : A0U);
        addView(this.A09, layoutParams2);
        LX.A0N(this.A09);
        C1807No c1807No = this.A0E;
        this.A0F = new C1816Nx(c1807No, c1807No.A04().A0M().A0G().A03(), getColors(), new SG(this));
        LX.A0J(1001, this.A0F);
        addView(this.A0F);
        A0J();
        A0B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (this.A03 * 4) / 5);
        if (A0d()) {
            layoutParams.setMargins(0, 0, 0, 0);
            layoutParams.addRule(12);
            LinearLayout linearLayout = this.A07;
            String[] strArr = A0R;
            if (strArr[7].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0R;
            strArr2[7] = "mOqhFUC5R4";
            strArr2[4] = "x2rQdK";
            linearLayout.setLayoutParams(layoutParams);
        } else {
            layoutParams.setMargins(0, this.A03 + 1, 0, 0);
        }
        this.A07.setTranslationY(WheelView.DividerConfig.FILL);
        this.A07.setLayoutParams(layoutParams);
    }

    private void A0J() {
        int i;
        if (!this.A0G) {
            int i2 = this.A02;
            String[] strArr = A0R;
            if (strArr[6].length() == strArr[1].length()) {
                String[] strArr2 = A0R;
                strArr2[2] = "bVoeq9MG5etfSqxTxXE6PlzRTEtccpLF";
                strArr2[2] = "bVoeq9MG5etfSqxTxXE6PlzRTEtccpLF";
                i = i2 / 5;
            }
            throw new RuntimeException();
        }
        i = this.A02 / 4;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, i);
        layoutParams.addRule(14);
        String[] strArr3 = A0R;
        if (strArr3[6].length() == strArr3[1].length()) {
            String[] strArr4 = A0R;
            strArr4[6] = "SHdOplU7mObztTib9yLp7cTgFqT";
            strArr4[1] = "8sjFKcaHqREVec5LNIXiQvlIl9H";
            layoutParams.addRule(2, this.A09.getId());
            layoutParams.setMargins(0, 0, 0, 0);
            this.A0F.setLayoutParams(layoutParams);
            return;
        }
        throw new RuntimeException();
    }

    private void A0K() {
        A0E();
        A0D();
        A0F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0Q(String str) {
        XM xm;
        LX.A0M(this.A0D);
        C1882Ql c1882Ql = new C1882Ql(this);
        if (this.A0E.A05().A09() == null) {
            this.A0E.A05().A0A().A7U();
        }
        if (C1694Iz.A02(this.A0E.A05()) || this.A0E.A05().A09() == null) {
            xm = new XM(this.A0E.A05(), c1882Ql);
        } else {
            xm = new XM(this.A0E.A05(), this.A0E.A05().A09(), c1882Ql);
        }
        this.A0D = xm;
        setUpBrowserControls(this.A0D);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        layoutParams.weight = 0.9f;
        this.A07.addView(this.A0D, layoutParams);
        this.A0D.loadUrl(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0R(boolean z) {
        ObjectAnimator objectAnimatorOfFloat;
        int i;
        int i2;
        long j;
        int i3;
        this.A0H = z;
        postDelayed(new C1881Qk(this, z), 250L);
        ObjectAnimator ctaTransAnim = null;
        String strA0A = A0A(0, 1, 39);
        if (z) {
            C1816Nx c1816Nx = this.A0F;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(c1816Nx, strA0A, c1816Nx.getY(), this.A03 / 5);
        } else {
            objectAnimatorOfFloat = null;
        }
        LinearLayout linearLayout = this.A07;
        float[] fArr = new float[2];
        fArr[0] = linearLayout.getY();
        int i4 = this.A03;
        if (z) {
            i4 /= 5;
        }
        fArr[1] = i4;
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(linearLayout, strA0A, fArr);
        objectAnimatorOfFloat2.setDuration(500L);
        int i5 = (this.A03 / 2) - (this.A01 / 2);
        View view = this.A06;
        float[] fArr2 = new float[2];
        fArr2[0] = view.getY();
        fArr2[1] = (z || this.A0G) ? WheelView.DividerConfig.FILL : i5;
        ObjectAnimator browserTransAnim = ObjectAnimator.ofFloat(view, strA0A, fArr2);
        browserTransAnim.setDuration(500L);
        C1638Gs c1638Gs = this.A0O;
        int height = c1638Gs == null ? 0 : c1638Gs.getHeight();
        if (z) {
            int i6 = this.A02;
            String[] strArr = A0R;
            if (strArr[6].length() == strArr[1].length()) {
                String[] strArr2 = A0R;
                strArr2[7] = "g83HcTndNM";
                strArr2[4] = "KO02it";
                i = (i6 / 5) - height;
            }
            throw new RuntimeException();
        }
        i = (this.A03 - A0U) - A0W;
        C1638Gs c1638Gs2 = this.A0O;
        if (c1638Gs2 != null) {
            float[] fArr3 = new float[2];
            fArr3[0] = c1638Gs2.getY();
            String[] strArr3 = A0R;
            if (strArr3[6].length() == strArr3[1].length()) {
                String[] strArr4 = A0R;
                strArr4[2] = "uMAfPHErUq8gYLqYGWwvrPw2H7I5hxcd";
                strArr4[2] = "uMAfPHErUq8gYLqYGWwvrPw2H7I5hxcd";
                fArr3[1] = i;
                ctaTransAnim = ObjectAnimator.ofFloat(c1638Gs2, strA0A, fArr3);
            }
            throw new RuntimeException();
        }
        int[] iArr = new int[2];
        iArr[0] = this.A06.getHeight();
        if (z) {
            i2 = this.A03 / 5;
        } else {
            i2 = this.A01;
        }
        iArr[1] = i2;
        ValueAnimator duration = ValueAnimator.ofInt(iArr).setDuration(500L);
        duration.addUpdateListener(new C1812Nt(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.playTogether(objectAnimatorOfFloat2, browserTransAnim, duration);
        if (objectAnimatorOfFloat != null) {
            j = 500;
            objectAnimatorOfFloat.setDuration(500L);
            i3 = 1;
            animatorSet.playTogether(objectAnimatorOfFloat);
        } else {
            j = 500;
            i3 = 1;
        }
        if (ctaTransAnim != null) {
            ctaTransAnim.setDuration(j);
            Animator[] animatorArr = new Animator[i3];
            animatorArr[0] = ctaTransAnim;
            animatorSet.playTogether(animatorArr);
        }
        animatorSet.addListener(new C1813Nu(this, z));
        animatorSet.start();
    }

    private void A0S(boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        setupLayoutConfiguration(z);
        LX.A0M(this.A06);
        this.A06 = this.A0E.A02();
        LX.A0N(this.A06);
        if (this.A0H) {
            layoutParams = new RelativeLayout.LayoutParams(-1, this.A03 / 5);
            layoutParams.addRule(14);
            layoutParams.addRule(10);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            A0C();
        }
        this.A06.setTranslationY(WheelView.DividerConfig.FILL);
        String[] strArr = A0R;
        if (strArr[3].length() == strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0R;
        strArr2[7] = "FZuJEB1DgE";
        strArr2[4] = "ioAK5D";
        addView(this.A06, 1, layoutParams);
        A0B();
        A0J();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0V() {
        super.A0V();
        A0P = null;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0W() {
        AbstractC1762Lu abstractC1762LuA08 = this.A0E.A08();
        if (abstractC1762LuA08 != null) {
            abstractC1762LuA08.setPageDetailsVisible((A0d() || abstractC1762LuA08.A07()) ? false : true);
        }
        this.A0J = false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0X() {
        if (this.A0E.A08() != null) {
            AbstractC1762Lu abstractC1762LuA08 = this.A0E.A08();
            String[] strArr = A0R;
            if (strArr[6].length() != strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0R;
            strArr2[3] = "MMiJw7TNUivh7iTB";
            strArr2[0] = "GEB80";
            abstractC1762LuA08.setPageDetailsVisible(false);
        }
        this.A0J = true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0Y() {
        this.A0K = false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0Z() {
        this.A0K = true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final void A0a(AnonymousClass18 anonymousClass18, String str, double d2, @Nullable Bundle bundle) {
        super.A0a(anonymousClass18, str, d2, bundle);
        String strA05 = anonymousClass18.A0F().A05();
        if (strA05 == null || strA05.trim().length() == 0) {
            LX.A0Q(this.A08, 8);
        } else {
            this.A09.setText(strA05);
        }
        if (d2 > 0.0d) {
            this.A01 = (int) (((double) this.A04) / d2);
        }
        this.A01 = this.A0G ? this.A02 : this.A01;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final boolean A0b() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    public final boolean A0c(boolean z) {
        if (!A0d()) {
            return false;
        }
        A0R(false);
        return true;
    }

    public final boolean A0d() {
        return this.A0H;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk
    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        if (A0d()) {
            return 3;
        }
        if (this.A0K) {
            return 2;
        }
        if (this.A0J) {
            return 4;
        }
        return super.getCloseButtonStyle();
    }

    private String getUrl() {
        return this.A0E.A04().A0M().A0G().A04();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1803Nk, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        A0S(A0d());
        A0K();
        setupLayoutConfiguration(A0d());
        A0H();
    }

    private void setUpBrowserControls(XM xm) {
        LX.A0M(this.A0B);
        this.A0B = new N4(this.A0E.A05(), xm);
        xm.setBrowserNavigationListener(this.A0B.getBrowserNavigationListener());
        LX.A0N(this.A0B);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.weight = 0.1f;
        this.A0B.setListener(new C1883Qm(this));
        this.A0B.setOnTouchListener(new ViewOnTouchListenerC1811Ns(this));
        this.A07.addView(this.A0B, layoutParams);
        LX.A0M(this.A0C);
        this.A0C = new N5(this.A0E.A05(), null, R.attr.progressBarStyleHorizontal);
        this.A07.addView(this.A0C, new LinearLayout.LayoutParams(-1, A0S));
    }

    private void setupLayoutConfiguration(boolean z) {
        this.A0G = getResources().getConfiguration().orientation == 2;
        this.A05 = this.A0E.A08() == null ? 0 : this.A0E.A08().getToolbarHeight();
        this.A0H = z;
        this.A02 = Resources.getSystem().getDisplayMetrics().heightPixels;
        this.A04 = Resources.getSystem().getDisplayMetrics().widthPixels;
        this.A03 = this.A02 + (this.A0G ? 0 : this.A05);
        this.A01 = this.A02;
    }
}
