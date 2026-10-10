package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.MediaViewVideoRenderer;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.proguard.annotations.DoNotStrip;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2204bJ extends C13654z implements DefaultMediaViewVideoRendererApi {
    public static byte[] A0F;
    public static String[] A0G;
    public static final String A0H;
    public MediaViewVideoRenderer A00;
    public C2026Wb A01;

    @Nullable
    public JK A02;

    @Nullable
    public C14679j A04;
    public C7Q A05;
    public C7I A06;

    @DoNotStrip
    public AbstractC1848Pd A07;
    public C1849Pe A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final InterfaceC1831Om A0C = new C2198bD(this);
    public final AtomicBoolean A0D = new AtomicBoolean(false);
    public final AtomicBoolean A0E = new AtomicBoolean(false);
    public JV A03 = JV.A03;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0F, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0E() {
        A0F = new byte[]{7, 32, 56, 47, 34, 39, 42, 110, 60, 43, 32, 42, 43, 60, 43, 60, 110, 45, 38, 39, 34, 42, 110, 45, 33, 32, 40, 39, 41, 96, ci.l, 38, 39, 42, 34, 21, 42, 38, 52, 21, 42, 39, 38, 44, 99, 42, 48, 99, 45, 54, 47, 47, 120, 99, 54, 45, 34, 33, 47, 38, 99, 55, 44, 99, 37, 42, 45, 39, 99, 42, 55, 109, ci.n, 43, 36, 39, 41, 32, 101, 49, 42, 101, 35, 44, 43, 33, 101, 8, 32, 33, 44, 36, 19, 44, 32, 50, 19, 44, 33, 32, 42, 101, 38, 45, 44, 41, 33, 107};
    }

    public static void A0F() {
        A0G = new String[]{"mcYgxpLQMmIwsDd5yEmcOVEUvqtoI", "GHoJM0N9xHnxy27wJlEicj6316JJBG", "sAgmez8xlBVRjdgohc9cPNZKpCHjl", "UXd4O0RMEZeMz8rPKuZc9Jx8", "lkMSGOb1N9f2znZPpxO7v43dGPgWn", "ZJq7h5cFUWj9FCmvTSQNl6xA6rnC8", "yifDfgH7QVrqMR4w0vNHSMY9h4Ewh", "QZpfE8IVFABXRQwraZ"};
    }

    static {
        A0F();
        A0E();
        A0H = C2204bJ.class.getSimpleName();
    }

    private JM A01(MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        return new C2199bE(this, mediaViewVideoRendererApi);
    }

    private JM A02(MediaViewVideoRendererApi mediaViewVideoRendererApi) {
        return new C2200bF(this, mediaViewVideoRendererApi);
    }

    private AbstractC1848Pd A04() {
        return new C2202bH(this);
    }

    private C1849Pe A05() {
        return new C1849Pe(this.A00, 50, true, new WeakReference(this.A07), this.A01);
    }

    private void A09() {
        C14679j c14679j = this.A04;
        if (c14679j != null) {
            C1832On c1832On = (C1832On) c14679j.getVideoView();
            if (A0G[3].length() != 24) {
                throw new RuntimeException();
            }
            String[] strArr = A0G;
            strArr[2] = "uL1T6UePNJ7Kw1irCYcqiA1GlgiEZ";
            strArr[0] = "2BZHbySyGqLzqR4K5b7TQMpiAd64K";
            c1832On.setViewImplInflationListener(this.A0C);
        }
    }

    private void A0A() {
        C14679j c14679j = this.A04;
        if (c14679j != null) {
            c14679j.getVideoView().setOnTouchListener(new JJ(this));
        }
    }

    private void A0B() {
        C14679j c14679j = this.A04;
        if (c14679j != null) {
            C1832On c1832On = (C1832On) c14679j.getVideoView();
            String[] strArr = A0G;
            if (strArr[4].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[7] = "MUEPyY1MJMWvhU3XHu";
            strArr2[7] = "MUEPyY1MJMWvhU3XHu";
            c1832On.setViewImplInflationListener(null);
        }
    }

    private void A0C() {
        if (this.A00.getVisibility() == 0 && this.A09) {
            MediaViewVideoRenderer mediaViewVideoRenderer = this.A00;
            String[] strArr = A0G;
            if (strArr[4].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0G;
            strArr2[4] = "vtumVYeB8x7vkBeCNzRl37Vgwgf5m";
            strArr2[1] = "l5c2Nb35iHyego1JNAmcVzJY15xyfp";
            if (mediaViewVideoRenderer.hasWindowFocus()) {
                this.A08.A0W();
                return;
            }
        }
        C14679j c14679j = this.A04;
        if (c14679j != null && c14679j.getState() == EnumC1846Pb.A05) {
            this.A0B = true;
        }
        this.A08.A0X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D() {
        this.A03 = JV.A03;
        A0B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void A0J(com.facebook.ads.redexgen.X.C2213bT r6, @androidx.annotation.Nullable com.facebook.ads.redexgen.X.JK r7) {
        /*
            r5 = this;
            r0 = 0
            r5.A0A = r0
            r5.A0B = r0
            r5.A02 = r7
            r5.A09()
            com.facebook.ads.redexgen.X.7Q r3 = r5.A05
            if (r6 == 0) goto L41
            com.facebook.ads.redexgen.X.JQ r4 = r6.getAdCoverImage()
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2204bJ.A0G
            r0 = 2
            r1 = r2[r0]
            r0 = 0
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L2a
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L2a:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C2204bJ.A0G
            java.lang.String r1 = "zpp3cHPhluFOPvL30kkcY8af"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "zpp3cHPhluFOPvL30kkcY8af"
            r0 = 3
            r2[r0] = r1
            if (r4 == 0) goto L41
            com.facebook.ads.redexgen.X.JQ r0 = r6.getAdCoverImage()
            java.lang.String r1 = r0.getUrl()
            goto L42
        L41:
            r1 = 0
        L42:
            com.facebook.ads.redexgen.X.bG r0 = new com.facebook.ads.redexgen.X.bG
            r0.<init>(r5)
            r3.setImage(r1, r0)
            com.facebook.ads.redexgen.X.JV r0 = r6.A13()
            r5.A03 = r0
            com.facebook.ads.redexgen.X.7I r1 = r5.A06
            java.lang.String r0 = r6.A17()
            r1.setPlayAccessibilityLabel(r0)
            com.facebook.ads.redexgen.X.7I r1 = r5.A06
            java.lang.String r0 = r6.A16()
            r1.setPauseAccessibilityLabel(r0)
            com.facebook.ads.redexgen.X.Pe r0 = r5.A08
            r0.A0W()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2204bJ.A0J(com.facebook.ads.redexgen.X.bT, com.facebook.ads.redexgen.X.JK):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0K(EnumC1834Op enumC1834Op) {
        C14679j c14679j = this.A04;
        if (c14679j != null) {
            c14679j.A0Y(enumC1834Op, 24);
        } else {
            if (!AdInternalSettings.isDebugBuild()) {
                return;
            }
            Log.e(A0H, A06(30, 42, 60));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0L() {
        C14679j c14679j = this.A04;
        if (c14679j == null || c14679j.getState() == EnumC1846Pb.A06) {
            return false;
        }
        return this.A03 == JV.A05 || this.A03 == JV.A03;
    }

    @Override // com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi
    public final void initialize(Context context, MediaViewVideoRenderer mediaViewVideoRenderer, MediaViewVideoRendererApi mediaViewVideoRendererApi, int i) {
        JM jmA02;
        ((C13654z) mediaViewVideoRendererApi.getAdComponentViewApi()).A01(this);
        if (i == 0) {
            jmA02 = A02(mediaViewVideoRendererApi);
        } else if (i == 1) {
            jmA02 = A01(mediaViewVideoRendererApi);
        } else {
            throw new IllegalArgumentException(A06(0, 30, 49));
        }
        ((AnonymousClass55) mediaViewVideoRendererApi).A07(jmA02);
        this.A01 = AnonymousClass50.A02(context);
        this.A00 = mediaViewVideoRenderer;
        this.A05 = new C7Q(this.A01);
        this.A07 = A04();
        this.A08 = A05();
        float f2 = LX.A01;
        int i2 = (int) (2.0f * f2);
        int i3 = (int) (25.0f * f2);
        this.A06 = new C7I(this.A01);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        this.A06.setPadding(i2, i3, i3, i2);
        this.A06.setLayoutParams(layoutParams);
        int i4 = 0;
        while (true) {
            int childCount = this.A00.getChildCount();
            if (A0G[3].length() == 24) {
                String[] strArr = A0G;
                strArr[2] = "oEzbzrDqpY4LpZuK9aeaZZijHYv0V";
                strArr[0] = "65U2aK7TrzSKlLOXQMMYyslcv3rZK";
                if (i4 >= childCount) {
                    break;
                }
                View childAt = this.A00.getChildAt(0);
                if (childAt instanceof C14679j) {
                    this.A04 = (C14679j) childAt;
                    break;
                }
                i4++;
            } else {
                throw new RuntimeException();
            }
        }
        C14679j c14679j = this.A04;
        if (c14679j == null) {
            if (AdInternalSettings.isDebugBuild()) {
                Log.e(A0H, A06(72, 36, 58));
            }
        } else {
            c14679j.A0Z(this.A05);
            this.A04.A0Z(this.A06);
        }
        this.A08.A0Y(0);
        this.A08.A0Z(250);
        jmA02.ADH();
        String[] strArr2 = A0G;
        if (strArr2[4].length() != strArr2[1].length()) {
            String[] strArr3 = A0G;
            strArr3[4] = "NjD77g9sbns6FUonJskLzorZMVzfs";
            strArr3[1] = "sF6jyMJNRDvSJleY8k7g51skJQqlgl";
        } else {
            String[] strArr4 = A0G;
            strArr4[2] = "irNdkufru0tgAA9z3l7YlJhRv0dZK";
            strArr4[0] = "zN5wNlZvELtjdUjcESL7VUEU7ru13";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C13654z, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.A09 = true;
        A0C();
    }

    @Override // com.facebook.ads.redexgen.X.C13654z, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.A09 = false;
        A0C();
    }

    @Override // com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi
    public final void onPrepared() {
        this.A00.setOnTouchListener(new JI(this));
        A0A();
    }

    @Override // com.facebook.ads.redexgen.X.C13654z, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        A0C();
    }

    @Override // com.facebook.ads.redexgen.X.C13654z, com.facebook.ads.internal.api.AdComponentView
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        A0C();
    }
}
