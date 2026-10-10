package com.facebook.ads.redexgen.X;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2112Zm extends AbstractC1762Lu {
    public static byte[] A06;
    public static String[] A07;
    public static final int A08;
    public static final int A09;

    @Nullable
    public InterfaceC1761Lt A00;
    public final C2026Wb A01;
    public final JC A02;
    public final C1760Ls A03;
    public final C2109Zh A04;
    public final InterfaceC1767Lz A05;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A07[4].length() == 19) {
                throw new RuntimeException();
            }
            String[] strArr = A07;
            strArr[4] = "L2RboTZhxjQ9awTRnLbhSQGg6v";
            strArr[4] = "L2RboTZhxjQ9awTRnLbhSQGg6v";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 127);
            i4++;
        }
    }

    public static void A03() {
        A06 = new byte[]{-19, -2, ci.l, -6, -6, -6, -6, -6, -6, 25, 74, 61, -8, 81, 71, 77, -8, 75, 77, 74, 61, -8, 81, 71, 77, -8, 79, 57, 70, 76, -8, 76, 71, -8, 75, 67, 65, 72, -8, 76, 64, 61, -8, 57, 60, 23, -8, 49, 71, 77, -8, 79, 65, 68, 68, -8, 68, 71, 75, 61, -8, 81, 71, 77, 74, -8, 74, 61, 79, 57, 74, 60, 6, 36, 77, 80, 84, 70, 1, 34, 69, -22, -3, 11, ci.k, 5, -3, -72, -39, -4, -11, ci.k, 11, 18, -62, -29, 6, 66, 90, 88, 95, ci.m, 48, 83, ci.m, 80, 93, 83, ci.m, 59, 94, 98, 84, ci.m, 65, 84, 102, 80, 97, 83};
    }

    public static void A04() {
        A07 = new String[]{"DSMXyIjmw5HclhajbHNu0bHfM2UoxQfV", "VI8qELbWvj15goD4sBQF3Ikg1AZrbLrB", "e65oiusvVwGlpJBKbHqtCRVJnI6YlHd3", "IRi9ljHD5lnLVRZZd0Abks", "cwd6", "joZNq3IpHeg70E", "Xkn9HJi", "Qn9IhJ0zzYM2Lk7aXz3vW7M0LF"};
    }

    static {
        A04();
        A03();
        A09 = (int) (LX.A01 * 16.0f);
        A08 = Color.parseColor(A02(0, 9, 75));
    }

    public C2112Zm(C2026Wb c2026Wb, InterfaceC1767Lz interfaceC1767Lz, JC jc, int i, int i2) {
        super(c2026Wb);
        this.A01 = c2026Wb;
        this.A05 = interfaceC1767Lz;
        this.A02 = jc;
        setGravity(16);
        this.A04 = new C2109Zh(c2026Wb, i);
        this.A04.setBackgroundColor(A08);
        this.A04.setContentDescription(A02(73, 8, 98));
        this.A04.setActionClickListener(new ViewOnClickListenerC1764Lw(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        View view = new View(c2026Wb);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.A03 = new C1760Ls(c2026Wb, i2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        int i3 = A09;
        layoutParams3.setMargins(i3, 0, i3, 0);
        this.A03.setBackgroundColor(A08);
        if (C1693Iy.A1Q(c2026Wb)) {
            addView(this.A03, layoutParams3);
            addView(view, layoutParams2);
            addView(this.A04, layoutParams);
        } else {
            addView(this.A04, layoutParams);
            addView(view, layoutParams2);
            addView(this.A03, layoutParams3);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public final void A05(C1G c1g, boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public final void A06(MJ mj) {
        Activity activityA09 = this.A01.A09();
        if (activityA09 != null) {
            DialogC2117Zr dialogC2117Zr = new DialogC2117Zr(this.A01, activityA09);
            setUpSkipDialog(dialogC2117Zr, mj);
            dialogC2117Zr.show();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public final boolean A07() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public int getToolbarHeight() {
        return AbstractC1762Lu.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setAdReportingVisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setPageDetails(C1P c1p, String str, int i, C1W c1w) {
        this.A04.setInitialUnskippableSeconds(i);
        this.A03.setAdDetails(c1p, str, this.A02, this.A05);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setPageDetailsVisible(boolean z) {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setProgress(float f2) {
        this.A04.setProgress(f2);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setToolbarActionMessage(String str) {
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setToolbarActionMode(int i) {
        this.A04.setToolbarActionMode(i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setToolbarListener(InterfaceC1761Lt interfaceC1761Lt) {
        this.A00 = interfaceC1761Lt;
    }

    private void setUpSkipDialog(DialogC2117Zr dialogC2117Zr, MJ mj) {
        dialogC2117Zr.A08(A02(97, 23, 112));
        dialogC2117Zr.A05(A02(9, 64, 89));
        dialogC2117Zr.A06(A02(90, 7, 35));
        dialogC2117Zr.A07(A02(81, 9, 25));
        dialogC2117Zr.A03(new ViewOnClickListenerC1765Lx(this, mj, dialogC2117Zr));
        dialogC2117Zr.A04(new ViewOnClickListenerC1766Ly(this, mj, dialogC2117Zr));
    }
}
