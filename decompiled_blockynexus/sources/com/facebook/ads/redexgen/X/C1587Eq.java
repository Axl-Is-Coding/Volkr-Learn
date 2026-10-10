package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.util.Log;
import java.util.Arrays;
import java.util.Map;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1587Eq extends XK {
    public static byte[] A02;
    public final /* synthetic */ RA A00;
    public final /* synthetic */ RF A01;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 123);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{21, 34, 34, Utf8.REPLACEMENT_BYTE, 34, 112, 53, 40, 53, 51, 37, 36, 57, 62, 55, 112, 49, 51, 36, 57, Utf8.REPLACEMENT_BYTE, 62, 17, 21, 22, 19};
    }

    public C1587Eq(RA ra, RF rf) {
        this.A00 = ra;
        this.A01 = rf;
    }

    @Override // com.facebook.ads.redexgen.X.NJ
    public final void A9A() {
        this.A00.A09 = true;
        if (!this.A00.A0A) {
            return;
        }
        this.A00.A06();
    }

    @Override // com.facebook.ads.redexgen.X.XK, com.facebook.ads.redexgen.X.NJ
    public final void A9R(String str, Map<String, String> map) {
        this.A00.A02.A0A().A3Z();
        Uri uri = Uri.parse(str);
        if (A00(22, 4, 12).equals(uri.getScheme()) && C12440f.A04(uri.getAuthority()) && this.A00.A00 != null) {
            this.A00.A00.A9J(this.A00);
        }
        AbstractC12430e abstractC12430eA00 = C12440f.A00(this.A00.A02, this.A00.A03, this.A01.A5q(), uri, map);
        if (abstractC12430eA00 == null) {
            return;
        }
        try {
            this.A00.A02.A0A().A3W();
            abstractC12430eA00.A0D();
        } catch (Exception e2) {
            Log.e(RA.A0D, A00(0, 22, 43), e2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.XK, com.facebook.ads.redexgen.X.NJ
    public final void AA1() {
        this.A00.A02.A0A().A3a(this.A00.A01 != null);
        if (this.A00.A01 == null) {
            return;
        }
        this.A00.A01.A03();
    }

    @Override // com.facebook.ads.redexgen.X.XK, com.facebook.ads.redexgen.X.NJ
    public final void AAf() {
        this.A00.A02.A0A().A3c();
        this.A00.A01.A08();
    }
}
