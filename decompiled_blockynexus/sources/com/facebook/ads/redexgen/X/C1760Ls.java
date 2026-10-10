package com.facebook.ads.redexgen.X;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ls, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1760Ls extends LinearLayout {
    public static byte[] A03;
    public static final int A04;
    public static final int A05;
    public static final int A06;
    public static final int A07;
    public static final int A08;
    public final ImageView A00;
    public final ImageView A01;
    public final C2026Wb A02;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 91);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{118, 83};
    }

    static {
        A02();
        A07 = (int) (LX.A01 * 50.0f);
        A04 = (int) (LX.A01 * 10.0f);
        A05 = (int) (LX.A01 * 20.0f);
        A08 = (int) (LX.A01 * 4.0f);
        A06 = (int) (LX.A01 * 12.0f);
    }

    public C1760Ls(C2026Wb c2026Wb, int i) {
        super(c2026Wb);
        this.A02 = c2026Wb;
        setOrientation(0);
        this.A00 = new ImageView(c2026Wb);
        this.A01 = new ImageView(c2026Wb);
        A03(i);
    }

    private void A03(int i) {
        EnumC1747Lf enumC1747Lf;
        A04(this.A00, EnumC1747Lf.AD_CHOICES_ICON);
        if (i == 2) {
            int i2 = A04;
            setPadding(i2, i2 / 3, i2, i2 / 3);
            TextView textView = new TextView(this.A02);
            textView.setText(A01(0, 2, 108));
            textView.setTextColor(-1);
            int i3 = A04;
            textView.setPadding(0, i3 / 2, i3 / 2, i3 / 2);
            LX.A0b(textView, true, 13);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
            addView(textView, layoutParams);
            int i4 = A06;
            LinearLayout.LayoutParams adChoicesIconParams = new LinearLayout.LayoutParams(i4, i4);
            adChoicesIconParams.gravity = 16;
            addView(this.A00, adChoicesIconParams);
            return;
        }
        int i5 = A04;
        setPadding(i5, i5, i5, i5);
        if (i == 1) {
            enumC1747Lf = EnumC1747Lf.AN_INFO_ICON;
        } else {
            enumC1747Lf = EnumC1747Lf.DEFAULT_INFO_ICON;
        }
        A04(this.A01, enumC1747Lf);
        int i6 = A05;
        LinearLayout.LayoutParams infoButtonParams = new LinearLayout.LayoutParams(i6, i6);
        infoButtonParams.gravity = 17;
        addView(this.A01, infoButtonParams);
        int i7 = A05;
        LinearLayout.LayoutParams infoButtonParams2 = new LinearLayout.LayoutParams(i7, i7);
        infoButtonParams2.setMargins(A08, 0, 0, 0);
        infoButtonParams2.gravity = 17;
        addView(this.A00, infoButtonParams2);
    }

    public static void A04(ImageView imageView, EnumC1747Lf enumC1747Lf) {
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageBitmap(C1748Lg.A01(enumC1747Lf));
        imageView.setColorFilter(-1);
    }

    public void setAdDetails(C1P c1p, String str, JC jc, InterfaceC1767Lz interfaceC1767Lz) {
        setOnClickListener(new ViewOnClickListenerC1759Lr(this, jc, interfaceC1767Lz, str, c1p));
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(A07);
        gradientDrawable.setColor(i);
        LX.A0W(this, gradientDrawable);
    }

    public void setIconColors(int i) {
        this.A00.setColorFilter(i);
        this.A01.setColorFilter(i);
    }
}
