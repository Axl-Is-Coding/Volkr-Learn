package com.facebook.ads.redexgen.X;

import android.R;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(19)
public final class C2106Zd implements M0 {
    public static byte[] A0C;
    public static String[] A0D;
    public static final String A0E;
    public long A00;
    public String A02;
    public String A03;
    public final C13604u A07;
    public final J5 A08;
    public final N4 A09;
    public final N5 A0A;
    public final XM A0B;
    public final InterfaceC13584s A06 = new Zg(this);
    public boolean A05 = true;
    public long A01 = -1;
    public boolean A04 = true;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0D;
            if (strArr[1].charAt(18) == strArr[4].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[7] = "WrA4t0RN";
            strArr2[7] = "WrA4t0RN";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 62);
            i4++;
        }
    }

    public static void A04() {
        A0C = new byte[]{114, -120, -120, -107, -120, -84, -41, -43, -120, -85, -41, -42, -36, -51, -42, -36, -120, -76, -41, -55, -52, -51, -52, -120, -68, -47, -43, -51, -94, -120, -70, -48, -48, -35, -48, -4, 31, 17, 20, -48, -10, 25, 30, 25, 35, 24, -48, 4, 25, 29, 21, -22, -48, -98, -76, -76, -63, -76, -32, 3, -11, -8, -76, -25, 8, -11, 6, 8, -76, -24, -3, 1, -7, -50, -76, -101, -79, -79, -66, -79, -29, -10, 4, 1, 0, -1, 4, -10, -79, -42, -1, -11, -79, -27, -6, -2, -10, -53, -79, -57, -35, -35, -22, -35, ci.n, 32, 47, 44, 41, 41, -35, ci.m, 34, 30, 33, 54, -35, 17, 38, 42, 34, -9, -35, -112, -90, -90, -77, -90, -39, -21, -7, -7, -17, -11, -12, -90, -52, -17, -12, -17, -7, -18, -90, -38, -17, -13, -21, -64, -90, -116, 92, 114, 114, 127, 114, -102, -77, -64, -74, -66, -73, -60, 114, -90, -69, -65, -73, -116, 114, -90, -42, -45, -37, -41, -55, -42, -124, -41, -55, -41, -41, -51, -45, -46, -124, -56, -59, -40, -59, -124, -48, -45, -53, -53, -55, -56, -124, -92, -124, -58, -57, -44, -38, -39, -97, -57, -47, -58, -45, -48, 9, 25, 22, 30, 26, 12, 25, -4, -7, -13, 24, 33, 30, 26, 35, 41, 9, 36, 32, 26, 35, -54, -61, -48, -58, -50, -57, -44, -74, -53, -49, -57};
    }

    public static void A05() {
        A0D = new String[]{"VjNTozFJBHBTAbZvfj55MfAwGP9LBSf6", "Pq0aBOwFzXTv3d8c4kUbGJ29Dl7JaeBe", "6Jh9GB1FdSmhvo4jirjJmKwQUVM2B32M", "TGGBgusTs1FvyAgmLwAY3Gsc6eBuJSRW", "x90wDNv6CtBtNBa5WCDyDNAaFj8t5cCY", "GDNjvFSJPJLifqCEdIwxfegvvEeKItWd", "ZGbO0A4ZRQBBFZeQfXm02pkO19XETszh", "zRbEM6nv1u3uOOYe"};
    }

    static {
        A05();
        A04();
        A0E = C2106Zd.class.getSimpleName();
    }

    public C2106Zd(C13604u c13604u, C2026Wb c2026Wb, J5 j5, InterfaceC1767Lz interfaceC1767Lz) {
        XM xm;
        this.A07 = c13604u;
        this.A08 = j5;
        int i = (int) (LX.A01 * 2.0f);
        C2108Zf c2108Zf = new C2108Zf(this);
        if (c2026Wb.A09() == null) {
            c2026Wb.A0A().A7U();
        }
        if (C1694Iz.A02(c2026Wb) || c2026Wb.A09() == null) {
            xm = new XM(c2026Wb, c2108Zf);
        } else {
            xm = new XM(c2026Wb, c2026Wb.A09(), c2108Zf);
        }
        this.A0B = xm;
        this.A09 = new N4(c2026Wb, this.A0B);
        this.A09.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        this.A09.setListener(new C2107Ze(this, c13604u));
        interfaceC1767Lz.A3L(this.A09, layoutParams);
        this.A0B.setBrowserNavigationListener(this.A09.getBrowserNavigationListener());
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(3, this.A09.getId());
        layoutParams2.addRule(12);
        interfaceC1767Lz.A3L(this.A0B, layoutParams2);
        this.A0A = new N5(c2026Wb, null, R.attr.progressBarStyleHorizontal);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, i);
        layoutParams3.addRule(3, this.A09.getId());
        this.A0A.setProgress(0);
        interfaceC1767Lz.A3L(this.A0A, layoutParams3);
        c13604u.A0L(this.A06);
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void A85(Intent intent, Bundle bundle, C13604u c13604u) {
        if (this.A01 < 0) {
            this.A01 = System.currentTimeMillis();
        }
        String strA03 = A03(231, 11, 36);
        String strA032 = A03(220, 11, 119);
        String strA033 = A03(210, 10, 105);
        if (bundle == null) {
            this.A02 = intent.getStringExtra(strA033);
            this.A03 = intent.getStringExtra(strA032);
            String[] strArr = A0D;
            if (strArr[0].charAt(28) != strArr[2].charAt(28)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[5] = "h34ynCyxETZN0C4DuHOjqZ0ETc7IsjOt";
            strArr2[5] = "h34ynCyxETZN0C4DuHOjqZ0ETc7IsjOt";
            this.A00 = intent.getLongExtra(strA03, -1L);
        } else {
            this.A02 = bundle.getString(strA033);
            this.A03 = bundle.getString(strA032);
            this.A00 = bundle.getLong(strA03, -1L);
        }
        String strA034 = this.A02;
        if (strA034 == null) {
            strA034 = A03(199, 11, 39);
        }
        this.A09.setUrl(strA034);
        this.A0B.loadUrl(strA034);
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AAh(boolean z) {
        this.A0B.onPause();
        if (this.A04) {
            this.A04 = false;
            N8 n8A07 = new N7(this.A0B.getFirstUrl()).A01(this.A00).A03(this.A01).A04(this.A0B.getResponseEndMs()).A00(this.A0B.getDomContentLoadedMs()).A05(this.A0B.getScrollReadyMs()).A02(this.A0B.getLoadFinishMs()).A06(System.currentTimeMillis()).A07();
            this.A08.A8C(this.A03, n8A07.A02());
            if (BuildConfigApi.isDebug()) {
                String str = A03(169, 30, 38) + System.currentTimeMillis() + A03(149, 20, 20) + n8A07.A01 + A03(53, 22, 86) + n8A07.A03 + A03(75, 24, 83) + n8A07.A04 + A03(0, 30, 42) + n8A07.A00 + A03(99, 24, 127) + n8A07.A05 + A03(30, 23, 114) + n8A07.A02 + A03(123, 26, 72) + n8A07.A06;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AB4(boolean z) {
        this.A0B.onResume();
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void ACz(Bundle bundle) {
        bundle.putString(A03(210, 10, 105), this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void onDestroy() {
        this.A07.A0M(this.A06);
        NM.A04(this.A0B);
        this.A0B.destroy();
    }
}
