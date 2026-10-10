package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XR extends MZ {
    public static byte[] A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public final HorizontalScrollView A00;
    public final ImageView A01;
    public final LinearLayout A02;
    public final LinearLayout A03;
    public final C2026Wb A04;

    public static String A0A(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A05 = new byte[]{-57, -26, -24, -16, -92, -51, -48, -44, -58, -127, -94, -59, -127, -77, -58, -47, -48, -45, -43, -54, -49, -56};
    }

    static {
        A0B();
        A08 = (int) (LX.A01 * 4.0f);
        A07 = (int) (LX.A01 * 10.0f);
        A06 = (int) (LX.A01 * 44.0f);
    }

    public XR(C2026Wb c2026Wb, J5 j5, String str) {
        super(c2026Wb, j5, str);
        this.A04 = c2026Wb;
        this.A01 = new ImageView(getContext());
        ImageView imageView = this.A01;
        int i = A07;
        imageView.setPadding(i, i, i, i);
        this.A01.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.A01.setColorFilter(-10459280);
        int i2 = A06;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i2, i2);
        layoutParams.gravity = 16;
        this.A02 = new LinearLayout(getContext());
        this.A02.setOrientation(0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.gravity = 17;
        this.A00 = new HorizontalScrollView(getContext());
        this.A00.setHorizontalScrollBarEnabled(false);
        this.A00.setLayoutParams(layoutParams2);
        this.A00.addView(this.A02, layoutParams2);
        this.A03 = new LinearLayout(getContext());
        this.A03.setOrientation(0);
        LX.A0P(this.A03, -218103809);
        this.A03.setMotionEventSplittingEnabled(false);
        this.A03.addView(this.A01, layoutParams);
        this.A03.addView(this.A00, layoutParams2);
        addView(this.A03, new FrameLayout.LayoutParams(-1, -1));
        this.A03.setClickable(true);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0K() {
        this.A01.setImageBitmap(C1748Lg.A01(EnumC1747Lf.CROSS));
        this.A01.setOnClickListener(new ViewOnClickListenerC1776Mi(this));
        this.A01.setContentDescription(A0A(4, 18, 89));
        C1771Md c1771Md = new C1771Md(this.A04);
        c1771Md.setData(AnonymousClass22.A0B(this.A04.A00()), EnumC1747Lf.HIDE_AD);
        c1771Md.setOnClickListener(new ViewOnClickListenerC1777Mj(this, c1771Md));
        C1771Md c1771Md2 = new C1771Md(this.A04);
        c1771Md2.setData(AnonymousClass22.A0F(this.A04.A00()), EnumC1747Lf.REPORT_AD);
        c1771Md2.setOnClickListener(new ViewOnClickListenerC1778Mk(this, c1771Md2));
        C1771Md c1771Md3 = new C1771Md(this.A04);
        c1771Md3.setData(AnonymousClass22.A0G(this.A04.A00()), EnumC1747Lf.AD_CHOICES_ICON);
        c1771Md3.setOnClickListener(new Ml(this, c1771Md3));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A08;
        layoutParams.setMargins(0, i, i, i);
        LX.A0X(this.A03);
        this.A02.removeAllViews();
        this.A02.addView(c1771Md, layoutParams);
        this.A02.addView(c1771Md2, layoutParams);
        this.A02.addView(c1771Md3, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0L() {
        LX.A0L(this);
        LX.A0M(this);
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0M(AnonymousClass25 anonymousClass25, AnonymousClass23 anonymousClass23) {
        this.A01.setOnClickListener(null);
        TextView textView = new TextView(getContext());
        LX.A0b(textView, true, 14);
        textView.setText(AnonymousClass22.A07(this.A04.A00()));
        textView.setGravity(17);
        LX.A0X(this.A03);
        this.A03.removeAllViews();
        this.A03.addView(textView, new LinearLayout.LayoutParams(-1, -1));
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final void A0N(AnonymousClass25 anonymousClass25, AnonymousClass23 anonymousClass23) {
        LX.A0X(this.A03);
        this.A01.setImageBitmap(C1748Lg.A01(EnumC1747Lf.BACK_ARROW));
        this.A01.setOnClickListener(new ViewOnClickListenerC1779Mm(this));
        this.A01.setContentDescription(A0A(0, 4, 125));
        this.A02.removeAllViews();
        this.A00.fullScroll(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i = A08;
        layoutParams.setMargins(0, i, i, i);
        for (AnonymousClass25 anonymousClass252 : anonymousClass25.A05()) {
            C1771Md c1771Md = new C1771Md(this.A04);
            c1771Md.setData(anonymousClass252.A04(), null);
            c1771Md.setOnClickListener(new ViewOnClickListenerC1780Mn(this, c1771Md, anonymousClass252));
            this.A02.addView(c1771Md, layoutParams);
        }
    }

    @Override // com.facebook.ads.redexgen.X.MZ
    public final boolean A0O() {
        return true;
    }
}
