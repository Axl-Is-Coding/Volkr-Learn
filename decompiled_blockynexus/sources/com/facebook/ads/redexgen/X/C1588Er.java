package com.facebook.ads.redexgen.X;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Er, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1588Er extends R2 {
    public static byte[] A02;
    public static String[] A03;
    public static final String A04;
    public final Uri A00;
    public final Map<String, String> A01;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 99);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {ci.l, 41, 49, 52, 45, 44, -24, 60, 55, -24, 55, 56, 45, 54, -24, 52, 49, 54, 51, -24, 61, 58, 52, 2, -24, -14, -17, -12, -15};
        if (A03[0].length() == 23) {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[3] = "z2LBMWL3UZ6mgEOfq1wT6wdWGhdUBaxY";
        strArr[2] = "LNV6u0tAGiEAXpu6l5ZCQkq7c5KJBKxy";
        A02 = bArr;
    }

    public static void A02() {
        A03 = new String[]{"EO73VH", "Qgz5bq7vpM6wgaeZrwJ0N", "K0RixItTLV229tIQ9volfY9Fr2yfBG4Z", "0XJd0xzB9RaoqzSBbOWrwbmO5Qd7B1Hm", "", "cDFQfUnzrKwrnb1BC8KnyL9IHyRAK9fC", "Q7Q0M0vYffDRrtcuJmKxnq", "hygqtGcON2Cep"};
    }

    static {
        A02();
        A01();
        A04 = C1588Er.class.getSimpleName();
    }

    public C1588Er(C2026Wb c2026Wb, J5 j5, String str, Uri uri, Map<String, String> map, C12500l c12500l, boolean z) {
        super(c2026Wb, j5, str, c12500l, z);
        this.A00 = uri;
        this.A01 = map;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12430e
    @Nullable
    public final EnumC12420d A0A() {
        try {
            C1730Ko.A09(new C1730Ko(), ((AbstractC12430e) this).A00, Uri.parse(this.A00.getQueryParameter(A00(25, 4, 35))), this.A02);
            return null;
        } catch (Exception unused) {
            String str = A00(0, 25, 101) + this.A00.toString();
            return EnumC12420d.A02;
        }
    }

    @Override // com.facebook.ads.redexgen.X.R2
    public final void A0E() {
        EnumC12420d enumC12420dA0A = null;
        if (((R2) this).A01) {
            enumC12420dA0A = A0A();
        }
        A0F(this.A01, enumC12420dA0A);
    }
}
