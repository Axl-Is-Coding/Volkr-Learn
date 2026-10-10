package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Xe, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2055Xe implements M0 {
    public static byte[] A0B;
    public int A00;
    public C7m A01;
    public final C2026Wb A02;
    public final J5 A03;
    public final InterfaceC1767Lz A04;
    public final MP A05;
    public final LU A06;
    public final AbstractC1696Jb A0A = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.9c
        public static byte[] A01;
        public static String[] A02;

        static {
            A02();
            A01();
        }

        public static String A00(int i, int i2, int i3) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
            int i4 = 0;
            while (true) {
                int length = bArrCopyOfRange.length;
                if (A02[1].charAt(16) != 'Y') {
                    throw new RuntimeException();
                }
                String[] strArr = A02;
                strArr[7] = "MNhPeHQbaIIJpJ20hNozP";
                strArr[2] = "";
                if (i4 >= length) {
                    return new String(bArrCopyOfRange);
                }
                bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 60);
                i4++;
            }
        }

        public static void A01() {
            A01 = new byte[]{35, 22, 17, 18, 28, -10, 27, 33, 18, 31, 32, 33, 22, 33, ci.l, 25, -14, 35, 18, 27, 33};
        }

        public static void A02() {
            A02 = new String[]{"AyjpfVMH4abbuU", "C4f54F5689i8nguXYuZVyawidNrV99tP", "", "kvcj7JPhLleA0fC5", "qT9ER7mxQyIS", "DVCseFxiIzNfwa", "yADVvB6XdmuuqrvB", "b9AAn0hyeOBCYK5qzyR18"};
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C9A
        /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
        public final void A04(C1703Jk c1703Jk) {
            this.A00.A04.A3t(A00(0, 21, 113), c1703Jk);
        }
    };
    public final AbstractC1708Jp A09 = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.9b
        public static byte[] A01;

        static {
            A01();
        }

        public static String A00(int i, int i2, int i3) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
            for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 63);
            }
            return new String(bArrCopyOfRange);
        }

        public static void A01() {
            A01 = new byte[]{72, 87, 90, 91, 81, 119, 80, 74, 91, 76, 77, 74, 87, 74, 95, 82, 123, 72, 91, 80, 74};
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C9A
        /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
        public final void A04(C14257j c14257j) {
            this.A00.A04.A3t(A00(0, 21, 1), c14257j);
        }
    };
    public final AbstractC1714Jv A07 = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.9a
        public static byte[] A01;
        public static String[] A02;

        static {
            A02();
            A01();
        }

        public static String A00(int i, int i2, int i3) {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
            for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 86);
            }
            return new String(bArrCopyOfRange);
        }

        public static void A01() {
            byte[] bArr = {17, 4, -1, 0, 10, -28, 9, ci.m, 0, ci.k, ci.l, ci.m, 4, ci.m, -4, 7, -32, 17, 0, 9, ci.m};
            String[] strArr = A02;
            if (strArr[6].charAt(4) != strArr[3].charAt(4)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[2] = "e0kN46odqljBIthjpUkTXG9hdDsWHsKW";
            strArr2[2] = "e0kN46odqljBIthjpUkTXG9hdDsWHsKW";
            A01 = bArr;
        }

        public static void A02() {
            A02 = new String[]{"OtZHHid0c6Ryk9CDDBq47ngXcNldIUWH", "JwrlVwQ54E2WwwQvkywQUOYHwL6g1bho", "WFiM5IPZvaQ4xMZm5xgvQ3FNROoMY2Kr", "al6ZIECO6LO12zMiuvYELaWNpYKDhozx", "wYAPbQwhGVteNN6MGdL8gA6824n9AnKf", "jTihIhEYsz4XSFMEjn7OlZEBUOzI3KNS", "mXaQIkSzTCVxPQuz9HLogqhmhIjgMyMR", "pEgzTi4rZbqmTwficQat67UuNHBZNbaD"};
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C9A
        /* JADX INFO: renamed from: A03, reason: merged with bridge method [inline-methods] */
        public final void A04(C7l c7l) {
            this.A00.A04.A3t(A00(0, 21, 69), c7l);
        }
    };
    public final AbstractC1712Jt A08 = new AbstractC1712Jt() { // from class: com.facebook.ads.redexgen.X.9Z
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.facebook.ads.redexgen.X.C9A
        /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
        public final void A04(C1713Ju c1713Ju) {
            this.A00.A05.A9u();
        }
    };

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 38);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A0B = new byte[]{-49, -29, -30, -35, -34, -38, -49, -25, -17, -8, -11, -15, -6, 0, -32, -5, -9, -15, -6, -68, -70, -84, -107, -88, -69, -80, -67, -84, -118, -69, -88, -119, -68, -69, -69, -74, -75, -73, -86, -91, -90, -80, -118, -81, -75, -90, -77, -76, -75, -86, -75, -94, -83, -122, -73, -90, -81, -75, -99, -112, -117, -116, -106, 115, -106, -114, -114, -116, -103, -2, -15, -20, -19, -9, -43, -40, -52, 24, 11, 6, 7, 17, -11, 7, 7, ci.k, -10, 11, ci.m, 7, -66, -79, -84, -83, -73, -99, -102, -108};
    }

    public C2055Xe(C2026Wb c2026Wb, MP mp, J5 j5, InterfaceC1767Lz interfaceC1767Lz) {
        this.A02 = c2026Wb;
        this.A03 = j5;
        this.A05 = mp;
        this.A06 = new LU(c2026Wb);
        this.A06.A0Z(new C7Y(c2026Wb));
        this.A06.getEventBus().A04(this.A0A, this.A09, this.A07, this.A08);
        this.A04 = interfaceC1767Lz;
        this.A06.setIsFullScreen(true);
        this.A06.setVolume(1.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        interfaceC1767Lz.A3L(this.A06, layoutParams);
        M2 m2 = new M2(c2026Wb);
        m2.setOnClickListener(new MN(this));
        interfaceC1767Lz.A3L(m2, m2.getDefaultLayoutParams());
    }

    public final void A04(int i) {
        this.A06.setVideoProgressReportIntervalMs(i);
    }

    public final void A05(View view) {
        this.A06.setControlsAnchorView(view);
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void A85(Intent intent, Bundle bundle, C13604u c13604u) {
        String stringExtra = intent.getStringExtra(A02(19, 18, 33));
        if (stringExtra != null && !stringExtra.isEmpty()) {
            OL ol = new OL(this.A02, stringExtra);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int i = (int) (16.0f * LX.A01);
            layoutParams.setMargins(i, i, i, i);
            layoutParams.addRule(10);
            layoutParams.addRule(9);
            ol.setOnClickListener(new MO(this));
            this.A04.A3L(ol, layoutParams);
        }
        this.A00 = intent.getIntExtra(A02(77, 13, 124), 0);
        this.A01 = new C7m(this.A02, this.A03, this.A06, intent.getStringExtra(A02(8, 11, 102)), intent.getBundleExtra(A02(58, 11, 1)));
        this.A06.setVideoMPD(intent.getStringExtra(A02(69, 8, 98)));
        this.A06.setVideoURI(intent.getStringExtra(A02(90, 8, 34)));
        int i2 = this.A00;
        if (i2 > 0) {
            this.A06.A0V(i2);
        }
        if (intent.getBooleanExtra(A02(0, 8, 72), false)) {
            this.A06.A0Y(EnumC1834Op.A05, 17);
        }
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AAh(boolean z) {
        this.A04.A3t(A02(37, 21, 27), new C1711Js());
        this.A06.A0T();
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void AB4(boolean z) {
        this.A04.A3t(A02(37, 21, 27), new C1709Jq());
        if (!this.A06.A0g()) {
            this.A06.A0Y(EnumC1834Op.A05, 18);
        }
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void ACz(Bundle bundle) {
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void onDestroy() {
        this.A04.A3t(A02(37, 21, 27), new IM(this.A00, this.A06.getCurrentPositionInMillis()));
        this.A01.A0e(this.A06.getCurrentPositionInMillis());
        this.A06.A0W(1);
        this.A06.A0S();
    }
}
