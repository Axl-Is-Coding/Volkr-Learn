package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1900Rd implements InterfaceC12610w {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ C1580Ej A00;
    public final /* synthetic */ Runnable A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] ^ i3) ^ 34;
            String[] strArr = A03;
            if (strArr[5].charAt(5) == strArr[1].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "sVZQ6Ml9fBzEITS5ybXWTtwXQoWqWbAN";
            strArr2[1] = "MwEMOJFXQFuJpU8zWQ85tYeWswvxAO3B";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{105, 99, 61, 99, 108, 106, Utf8.REPLACEMENT_BYTE, 106, ci.m, 42, 47, 62, 58, 43, 60, 110, 39, 61, 110, 32, 59, 34, 34, 110, 33, 32, 110, 34, 33, 47, 42, 7, 32, 58, 43, 60, 61, 58, 39, 58, 39, 47, 34, ci.m, 42, 93, 122, 96, 113, 102, 103, 96, 125, 96, 125, 117, 120, 52, 125, 121, 100, 102, 113, 103, 103, 125, 123, 122, 52, 114, 125, 102, 113, 112, 106, 101, 111, 121, 100, 98, 111, 37, 98, 101, 127, 110, 101, 127, 37, 106, 104, 127, 98, 100, 101, 37, 93, 66, 78, 92, 47, 62, 39, 96, 97, 70, 97, 123, 106, 125, 124, 123, 102, 123, 102, 110, 99, 67, 96, 104, 104, 102, 97, 104, 70, 98, 127, 125, 106, 124, 124, 102, 96, 97};
    }

    public static void A02() {
        A03 = new String[]{"CodBKn6Rx4Nd2NCJ9VlYeJoUvBmT0K9p", "5Rf8WjvcJZOUdeEvkpnEyeT6h0OK8cqO", "9H9umRBAwWbsUQsHVAjP1GvoefoGWKiv", "nqryT6E7", "BkgpBj4q", "vUmBCwuwnOwC6wDkIlhiKnb32h6Srhe1", "47HB5bdSxtP74yDXUEGozfNjn4WOkRGN", "xids5JFtyjlo4uGEh5DI8Wwgi7h0jVQM"};
    }

    public C1900Rd(C1580Ej c1580Ej, Runnable runnable) {
        this.A00 = c1580Ej;
        this.A01 = runnable;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12610w
    public final void AA3(RB rb, String str, boolean z) {
        this.A00.A07.A0B();
        boolean z2 = !TextUtils.isEmpty(str);
        if (z && z2) {
            Intent intent = new Intent(A00(74, 26, 41));
            intent.setData(Uri.parse(str));
            C1725Kh.A0C(this.A00.A0C, intent);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12610w
    public final void AA4(RB rb) {
        this.A00.A07.A02();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12610w
    public final void AA5(RB rb) {
        this.A00.A07.A04();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12610w
    public final void AA6(RB rb) {
        if (rb != this.A00.A01) {
            return;
        }
        if (rb == null) {
            this.A00.A0C.A04().A8H(A00(100, 3, 108), C8Y.A0M, new C8Z(A00(8, 37, 108)));
            AA7(rb, AdError.internalError(AdError.INTERNAL_ERROR_2004));
            return;
        }
        this.A00.A0G().removeCallbacks(this.A01);
        C1580Ej c1580Ej = this.A00;
        c1580Ej.A02 = rb;
        super/*com.facebook.ads.redexgen.X.Rb*/.A0J();
        this.A00.A07.A0E(rb);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12610w
    public final void AA7(RB rb, AdError adError) {
        if (rb != this.A00.A01) {
            return;
        }
        this.A00.A0G().removeCallbacks(this.A01);
        this.A00.A0P(rb);
        if (!C1693Iy.A0k(this.A00.A0C)) {
            this.A00.A0O();
        }
        this.A00.A0C.A0A().A4Y(adError.getErrorCode(), adError.getErrorMessage());
        this.A00.A07.A0F(new C1697Jd(adError.getErrorCode(), adError.getErrorMessage()));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12610w
    public final void AA8(RB rb) {
        C1710Jr.A05(A00(103, 31, 45), A00(45, 29, 54), A00(0, 8, 121));
        this.A00.A07.A0C();
        this.A00.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12610w
    public final void AA9() {
        this.A00.A07.A07();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12610w
    public final void AAA() {
        this.A00.A07.A05();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12610w
    public final void AAB() {
        this.A00.A07.A06();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12610w
    public final void onInterstitialActivityDestroyed() {
        this.A00.A07.A00();
    }
}
