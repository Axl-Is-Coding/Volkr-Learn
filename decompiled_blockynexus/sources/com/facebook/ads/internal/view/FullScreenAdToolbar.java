package com.facebook.ads.internal.view;

import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.redexgen.X.AbstractC1762Lu;
import com.facebook.ads.redexgen.X.C1760Ls;
import com.facebook.ads.redexgen.X.C1G;
import com.facebook.ads.redexgen.X.C1P;
import com.facebook.ads.redexgen.X.C1W;
import com.facebook.ads.redexgen.X.C2026Wb;
import com.facebook.ads.redexgen.X.InterfaceC1761Lt;
import com.facebook.ads.redexgen.X.InterfaceC1767Lz;
import com.facebook.ads.redexgen.X.JC;
import com.facebook.ads.redexgen.X.LX;
import com.facebook.ads.redexgen.X.M3;
import com.facebook.ads.redexgen.X.MM;
import com.facebook.ads.redexgen.X.OM;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FullScreenAdToolbar extends AbstractC1762Lu {
    public static byte[] A07;
    public static String[] A08;
    public static final int A09;
    public static final int A0A;
    public static final int A0B;
    public static final int A0C;
    public static final int A0D;

    @Nullable
    public InterfaceC1761Lt A00;
    public final RelativeLayout A01;
    public final JC A02;
    public final C1760Ls A03;
    public final InterfaceC1767Lz A04;
    public final MM A05;
    public final OM A06;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A07 = new byte[]{-26, ci.m, 18, 22, 8, -61, -28, 7, 56, 75, 86, 85, 88, 90, 6, 39, 74};
    }

    public static void A04() {
        A08 = new String[]{"elaUgpg", "xyZ5KhWZZkOCw26QnbyRE89VYXYHkT38", "j2Hg99bd5kkvFLrtwtqoGvtE7T", "FtK0h2Y990QReQxCoMrwn7Y", "09p430KvfvIa5D7TMMbG57be7BWhVuc0", "4K9Dg6G4rdQDm1ubILJxRl9GbBVTjarc", "MQsbPX4", "ODYsITK"};
    }

    static {
        A04();
        A03();
        A09 = (int) (LX.A01 * 10.0f);
        A0D = (int) (LX.A01 * 16.0f);
        int i = A0D;
        int i2 = A09;
        A0B = i - i2;
        A0C = (i * 2) - i2;
        A0A = (int) (LX.A01 * 4.0f);
    }

    public FullScreenAdToolbar(C2026Wb c2026Wb, InterfaceC1767Lz interfaceC1767Lz, JC jc, @ToolbarActionView$ToolbarActionMode int i, int i2) {
        super(c2026Wb);
        this.A04 = interfaceC1767Lz;
        this.A02 = jc;
        setGravity(16);
        this.A05 = new MM(c2026Wb, i);
        this.A05.setContentDescription(A02(0, 8, 50));
        this.A05.setActionClickListener(new M3(this));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        int i3 = A0B;
        layoutParams.setMargins(i3, i3, A0C, i3);
        addView(this.A05, layoutParams);
        this.A01 = new RelativeLayout(c2026Wb);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2);
        layoutParams2.weight = 1.0f;
        this.A06 = new OM(c2026Wb);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.A06.setLayoutParams(layoutParams3);
        this.A01.addView(this.A06);
        addView(this.A01, layoutParams2);
        this.A03 = new C1760Ls(c2026Wb, i2);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -1);
        int i4 = A0D;
        layoutParams4.setMargins(0, i4 / 2, i4 / 2, i4 / 2);
        addView(this.A03, layoutParams4);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public final void A05(C1G c1g, boolean z) {
        int iA04 = c1g.A04(z);
        this.A06.A01(c1g.A0A(z), iA04);
        this.A03.setIconColors(iA04);
        this.A03.setContentDescription(A02(8, 9, 117));
        this.A05.setColors(iA04);
        if (z) {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{-1778384896, 0});
            gradientDrawable.setCornerRadius(WheelView.DividerConfig.FILL);
            LX.A0W(this, gradientDrawable);
            LX.A0T(this.A03, 0, -16777216, A0A);
            return;
        }
        LX.A0P(this, 0);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public final boolean A07() {
        return this.A05.A02();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public int getToolbarHeight() {
        return AbstractC1762Lu.A00;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setAdReportingVisible(boolean z) {
        this.A03.setVisibility(z ? 0 : 8);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setPageDetails(C1P c1p, String str, int i, C1W c1w) {
        this.A05.setInitialUnskippableSeconds(i);
        this.A06.setPageDetails(c1p);
        this.A03.setAdDetails(c1p, str, this.A02, this.A04);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setPageDetailsVisible(boolean z) {
        this.A01.removeAllViews();
        if (z) {
            RelativeLayout relativeLayout = this.A01;
            OM om = this.A06;
            if (A08[4].charAt(4) != '3') {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[2] = "uYrc95dj4mq6YR3RipRhNZPjST";
            strArr[3] = "ufyXPPKrvmASdIniU0CJIS9";
            relativeLayout.addView(om);
        }
        MM mm = this.A05;
        String[] strArr2 = A08;
        if (strArr2[2].length() == strArr2[3].length()) {
            mm.setToolbarMessageEnabled(!z);
            return;
        }
        String[] strArr3 = A08;
        strArr3[1] = "RoBBOPMqmB8G6B1FErbRchWOJuWn3pgq";
        strArr3[1] = "RoBBOPMqmB8G6B1FErbRchWOJuWn3pgq";
        mm.setToolbarMessageEnabled(!z);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setProgress(float f2) {
        this.A05.setProgress(f2);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setToolbarActionMessage(String str) {
        this.A05.setToolbarMessage(str);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setToolbarActionMode(@ToolbarActionView$ToolbarActionMode int i) {
        this.A05.setToolbarActionMode(i);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1762Lu
    public void setToolbarListener(InterfaceC1761Lt interfaceC1761Lt) {
        this.A00 = interfaceC1761Lt;
    }
}
