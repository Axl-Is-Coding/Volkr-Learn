package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class XW implements InterfaceC1769Mb {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ MZ A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 111);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-29, -17, -19, -82, -26, -31, -29, -27, -30, -17, -17, -21, -82, -31, -28, -13, -82, -31, -28, -14, -27, -16, -17, -14, -12, -23, -18, -25, -82, -58, -55, -50, -55, -45, -56, -33, -63, -60, -33, -46, -59, -48, -49, -46, -44, -55, -50, -57, -33, -58, -52, -49, -41};
        String[] strArr = A02;
        if (strArr[4].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[7] = "41BFLxMtpa8zSeOoPh8lyezFWRN0z1Os";
        strArr2[7] = "41BFLxMtpa8zSeOoPh8lyezFWRN0z1Os";
    }

    public static void A02() {
        A02 = new String[]{"nV", "0i4Wqrqqd8V", "SjjlSsHq4luZ", "UY2G1G5tdkkQRCLDawUW8PMELrtkam", "x8YzSsjyce", "sMLSYBAewXVAxhh2DbXf8YHA5QSbjC", "Z41BjwW", "WlPnbv1jMaDivlCQdRIz8mOz1GWjjHLQ"};
    }

    public XW(MZ mz) {
        this.A00 = mz;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1769Mb
    public final void A42() {
        if (this.A00.A06 != null) {
            this.A00.A06.A3s(A00(0, 53, 17));
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1769Mb
    public final void A43() {
        this.A00.A0L();
        if (this.A00.A07 != null) {
            this.A00.A07.AB4(true);
        }
        this.A00.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1769Mb
    public final void A7K() {
        if (this.A00.A03 == null) {
            A43();
            return;
        }
        MZ.A01(this.A00);
        if (this.A00.A03.A02() == null) {
            MZ mz = this.A00;
            if (A02[6].length() != 7) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[7] = "M7aB9yPR9altU9X1FYnvgfaKEANBwcUB";
            strArr[7] = "M7aB9yPR9altU9X1FYnvgfaKEANBwcUB";
            mz.A0B();
        } else {
            MZ mz2 = this.A00;
            mz2.A0D(mz2.A03.A02());
        }
        if (Build.VERSION.SDK_INT >= 16 && C1693Iy.A1O(this.A00.A04)) {
            this.A00.performAccessibilityAction(128, null);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1769Mb
    public final void A82() {
        if (!TextUtils.isEmpty(AnonymousClass22.A0C(this.A00.A04.A00()))) {
            C1730Ko.A09(new C1730Ko(), this.A00.A04, Uri.parse(AnonymousClass22.A0C(this.A00.A04.A00())), this.A00.A08);
        }
        this.A00.A02.A05();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1769Mb
    public final void A83() {
        this.A00.A0L();
        if (this.A00.A07 != null) {
            this.A00.A07.AB4(true);
        }
        if (!TextUtils.isEmpty(AnonymousClass22.A06(this.A00.A04.A00()))) {
            C1730Ko.A09(new C1730Ko(), this.A00.A04, Uri.parse(AnonymousClass22.A06(this.A00.A04.A00())), this.A00.A08);
        }
        this.A00.A02.A07();
        this.A00.A0A();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1769Mb
    public final void AAV(AnonymousClass23 anonymousClass23) {
        MZ.A00(this.A00);
        this.A00.A01 = anonymousClass23;
        this.A00.A0D(this.A00.A01 == AnonymousClass23.A03 ? AnonymousClass22.A03(this.A00.A04.A00()) : AnonymousClass22.A04(this.A00.A04.A00()));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1769Mb
    public final void AAd(AnonymousClass25 anonymousClass25) {
        MZ.A00(this.A00);
        this.A00.A02.A08(anonymousClass25.A01());
        if (!anonymousClass25.A05().isEmpty()) {
            this.A00.A0D(anonymousClass25);
        } else {
            this.A00.A0C(anonymousClass25);
        }
    }
}
