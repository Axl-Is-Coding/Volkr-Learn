package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(19)
public final class N4 extends LinearLayout {
    public static byte[] A0A;
    public static String[] A0B;
    public static final int A0C;
    public static final int A0D;
    public static final Uri A0E;
    public static final View.OnTouchListener A0F;

    @Nullable
    public ImageView A00;
    public ImageView A01;

    @Nullable
    public ImageView A02;
    public ImageView A03;
    public N3 A04;
    public NA A05;
    public String A06;
    public boolean A07;
    public final WebView A08;
    public final ND A09;

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b2 = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 39);
            String[] strArr = A0B;
            if (strArr[3].charAt(13) == strArr[1].charAt(13)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[6] = "2vQcPj1ELj1bu";
            strArr2[0] = "7aOELiI6quiDs";
            bArrCopyOfRange[i4] = b2;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0A = new byte[]{80, 115, 113, 121, 27, 52, 55, 43, 61, 39, ci.l, 19, 22, 0, 19, 5, ci.l, 49, 36, 47, 97, 47, 32, 53, 40, 55, 36, 97, 35, 51, 46, 54, 50, 36, 51, 5, 6, 11, 17, ci.n, 94, 6, 8, 5, 10, ci.m, 18, 29, 23, 1, 28, 26, 23, 93, 26, 29, 7, 22, 29, 7, 93, 18, ci.n, 7, 26, 28, 29, 93, 37, 58, 54, 36, 27, 23, 21, 86, 25, 22, 28, 10, 23, 17, 28, 86, 27, ci.n, 10, 23, 21, 29, 80, 76, 76, 72, 2, 23, 23, 79, 79, 79, 22, 94, 89, 91, 93, 90, 87, 87, 83, 22, 91, 87, 85};
    }

    public static void A08() {
        A0B = new String[]{"knq4crm7fvqQP", "POuWJNR6FFtqsTvB6KeDXgsqVDDrfXB5", "10LYd3PkBnL3JTlwXO74lkb8laVhyfxM", "yGvyB2PsIdOlgSHN7xWAdIyeKrkcUuSJ", "30OsfDGqNeLBXhmKwxFpv8WuoKRgKdOB", "v4mwmIuaROl", "LuFvPWZsJ2RrZ", "py7QobRXpH9AZVstdVJJOkEIejHuBaN9"};
    }

    static {
        A08();
        A07();
        A0C = Color.rgb(224, 224, 224);
        A0E = Uri.parse(A05(90, 23, 31));
        A0F = new ViewOnTouchListenerC1791My();
        A0D = Color.argb(34, 0, 0, 0);
    }

    public N4(C2026Wb c2026Wb, WebView webView) {
        super(c2026Wb);
        this.A09 = new XN(this);
        this.A08 = webView;
        this.A07 = C1694Iz.A06(c2026Wb);
        A09(c2026Wb);
    }

    private void A09(C2026Wb c2026Wb) {
        int i = (int) (50.0f * getResources().getDisplayMetrics().density);
        LX.A0P(this, -1);
        setGravity(16);
        this.A01 = new ImageView(c2026Wb);
        this.A01.setContentDescription(A05(4, 5, 127));
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(i, i);
        this.A01.setScaleType(ImageView.ScaleType.CENTER);
        this.A01.setImageBitmap(C1748Lg.A01(EnumC1747Lf.BROWSER_CLOSE));
        this.A01.setOnTouchListener(A0F);
        this.A01.setOnClickListener(new ViewOnClickListenerC1792Mz(this));
        addView(this.A01, layoutParams);
        if (this.A07) {
            this.A00 = new ImageView(c2026Wb);
            this.A00.setEnabled(false);
            this.A00.setAlpha(0.3f);
            this.A00.setContentDescription(A05(0, 4, 53));
            ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, i);
            this.A00.setScaleType(ImageView.ScaleType.CENTER);
            this.A00.setImageBitmap(C1748Lg.A01(EnumC1747Lf.BACK_ARROW));
            this.A00.setOnTouchListener(A0F);
            this.A00.setOnClickListener(new N0(this));
            addView(this.A00, layoutParams2);
        }
        this.A05 = new NA(c2026Wb);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, -2);
        layoutParams3.weight = this.A07 ? 0.5f : 1.0f;
        this.A05.setGravity(17);
        addView(this.A05, layoutParams3);
        if (this.A07) {
            this.A02 = new ImageView(c2026Wb);
            this.A02.setEnabled(false);
            this.A02.setAlpha(0.3f);
            this.A02.setContentDescription(A05(9, 7, 70));
            ViewGroup.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(i, i);
            this.A02.setScaleType(ImageView.ScaleType.CENTER);
            this.A02.setImageBitmap(C1748Lg.A02(EnumC1747Lf.BACK_ARROW));
            this.A02.setOnTouchListener(A0F);
            this.A02.setOnClickListener(new N1(this));
            addView(this.A02, layoutParams4);
        }
        this.A03 = new ImageView(c2026Wb);
        ViewGroup.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(i, i);
        this.A03.setContentDescription(A05(16, 19, 102));
        this.A03.setScaleType(ImageView.ScaleType.CENTER);
        this.A03.setOnTouchListener(A0F);
        this.A03.setOnClickListener(new N2(this, c2026Wb));
        addView(this.A03, layoutParams5);
        setupDefaultNativeBrowser(c2026Wb);
    }

    public ND getBrowserNavigationListener() {
        return this.A09;
    }

    public void setListener(N3 n3) {
        this.A04 = n3;
    }

    public void setTitle(String str) {
        this.A05.setTitle(str);
    }

    public void setUrl(String str) {
        this.A06 = str;
        if (TextUtils.isEmpty(str) || A05(35, 11, 67).equals(str)) {
            this.A05.setSubtitle(null);
            this.A03.setEnabled(false);
            this.A03.setColorFilter(new PorterDuffColorFilter(A0C, PorterDuff.Mode.SRC_IN));
        } else {
            this.A05.setSubtitle(str);
            this.A03.setEnabled(true);
            this.A03.setColorFilter((ColorFilter) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setupDefaultNativeBrowser(com.facebook.ads.redexgen.X.C2026Wb r7) {
        /*
            r6 = this;
            android.content.pm.PackageManager r5 = r7.getPackageManager()
            android.content.Intent r4 = new android.content.Intent
            android.net.Uri r3 = com.facebook.ads.redexgen.X.N4.A0E
            r2 = 46
            r1 = 26
            r0 = 84
            java.lang.String r0 = A05(r2, r1, r0)
            r4.<init>(r0, r3)
            r0 = 65536(0x10000, float:9.1835E-41)
            java.util.List r2 = r5.queryIntentActivities(r4, r0)
            int r0 = r2.size()
            if (r0 != 0) goto L2f
            android.widget.ImageView r1 = r6.A03
            r0 = 8
            r1.setVisibility(r0)
            r1 = 0
        L29:
            android.widget.ImageView r0 = r6.A03
            r0.setImageBitmap(r1)
            return
        L2f:
            int r1 = r2.size()
            r0 = 1
            if (r1 != r0) goto L71
            r0 = 0
            java.lang.Object r0 = r2.get(r0)
            android.content.pm.ResolveInfo r0 = (android.content.pm.ResolveInfo) r0
            android.content.pm.ActivityInfo r0 = r0.activityInfo
            java.lang.String r3 = r0.packageName
            r2 = 72
            r1 = 18
            r0 = 95
            java.lang.String r0 = A05(r2, r1, r0)
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L71
            com.facebook.ads.redexgen.X.Lf r3 = com.facebook.ads.redexgen.X.EnumC1747Lf.BROWSER_LAUNCH_CHROME
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.N4.A0B
            r0 = 5
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 31
            if (r1 == r0) goto L78
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.N4.A0B
            java.lang.String r1 = "ER9o4D5KfsgKq"
            r0 = 6
            r2[r0] = r1
            java.lang.String r1 = "PVCMoHz4n3Ffn"
            r0 = 0
            r2[r0] = r1
            android.graphics.Bitmap r1 = com.facebook.ads.redexgen.X.C1748Lg.A01(r3)
            goto L29
        L71:
            com.facebook.ads.redexgen.X.Lf r0 = com.facebook.ads.redexgen.X.EnumC1747Lf.BROWSER_LAUNCH_NATIVE
            android.graphics.Bitmap r1 = com.facebook.ads.redexgen.X.C1748Lg.A01(r0)
            goto L29
        L78:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.N4.setupDefaultNativeBrowser(com.facebook.ads.redexgen.X.Wb):void");
    }
}
