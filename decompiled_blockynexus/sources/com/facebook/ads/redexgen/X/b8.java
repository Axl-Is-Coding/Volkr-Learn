package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class b8 implements J5 {

    @Nullable
    @SuppressLint({"StaticFieldLeak"})
    public static J5 A03;
    public static byte[] A04;
    public static final String A05;
    public static volatile boolean A06;
    public final C2027Wc A00;
    public final C9E A01;
    public final J4 A02;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 79);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{-90, -21, -4, -21, -12, -6, -76, -88, -37, -37, -52, -44, -41, -37, -48, -43, -50, -121, -37, -42, -121, -45, -42, -50, -121, -56, -43, -121, -48, -43, -35, -56, -45, -48, -53, -121};
    }

    static {
        A03();
        A05 = b8.class.getSimpleName();
        A06 = false;
    }

    public b8(C2027Wc c2027Wc) {
        J3 j3A00;
        this.A00 = c2027Wc;
        if (J0.A0U(c2027Wc)) {
            this.A01 = C9C.A00(c2027Wc);
            j3A00 = J9.A01(c2027Wc, this.A01);
        } else {
            CV cvA01 = C9C.A01(c2027Wc);
            j3A00 = J9.A00(c2027Wc, cvA01);
            this.A01 = cvA01;
        }
        this.A02 = new C2191b5(c2027Wc, j3A00);
        ExecutorC1744Lc.A08.execute(new C2192b6(this));
        A04(c2027Wc);
    }

    public static synchronized J5 A01(C2027Wc c2027Wc) {
        if (A03 == null) {
            A03 = new b8(c2027Wc);
        }
        return A03;
    }

    public static synchronized void A04(C2027Wc c2027Wc) {
        if (A06) {
            return;
        }
        DynamicLoaderFactory.makeLoader(c2027Wc).getInitApi().onAdEventManagerCreated(c2027Wc);
        A06 = true;
    }

    private void A05(J2 j2) {
        if (!j2.A0B()) {
            Log.e(A05, A02(7, 29, 24) + j2.A07() + A02(0, 7, 55));
            return;
        }
        this.A01.AEE(j2, new C2193b7(this, j2));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A89(String str, Map<String, String> map) {
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A04).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8C(String str, Map<String, String> map) {
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A06).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8D(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A07).A06(JE.A0A(str, JB.A0I)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8E(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A08).A06(JE.A0A(str, JB.A06)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8G(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A0B).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8K(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A0C).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8M(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A05).A02(J7.A0D).A06(JE.A0A(str, JB.A0T)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8N(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A05).A02(J7.A0E).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8O(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A05).A02(J7.A0H).A06(JE.A0A(str, JB.A0V)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8Q(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A0G).A06(JE.A0A(str, JB.A0W)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8S(String str, Map<String, String> map, String str2, J6 j6) {
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(j6).A02(J7.A00(str2)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8T(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A0I).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8Y(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A01(J6.A04).A02(J7.A0K).A06(JE.A0A(str, JB.A0Y)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8a(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A0F).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8b(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A05).A02(J7.A0L).A06(JE.A0A(str, JB.A0c)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8c(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A0P).A06(JE.A0A(str, JB.A0e)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8d(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A04).A02(J7.A0O).A06(JE.A0A(str, JB.A0f)).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8e(String str, Map<String, String> map) {
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A05).A02(J7.A0Q).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void A8g(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        A05(new J1().A04(str).A00(this.A00.A05().A01()).A03(this.A00.A05().A02()).A05(map).A01(J6.A05).A02(J7.A0R).A07(this.A00));
    }

    @Override // com.facebook.ads.redexgen.X.J5
    public final void ABy(String str) {
        new Q3(this.A00).execute(str);
    }
}
