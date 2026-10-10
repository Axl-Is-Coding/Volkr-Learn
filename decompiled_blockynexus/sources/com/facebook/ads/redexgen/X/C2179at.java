package com.facebook.ads.redexgen.X;

import android.util.Base64;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.at, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2179at extends KT {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ K3 A00;
    public final /* synthetic */ K6 A01;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A03;
            if (strArr[2].charAt(31) == strArr[3].charAt(31)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[7] = "vKWhPjbFalI70MxhKihYQQhrE25QXeUX";
            strArr2[7] = "vKWhPjbFalI70MxhKihYQQhrE25QXeUX";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 89);
            i4++;
        }
    }

    public static void A01() {
        A02 = new byte[]{-51, -85, -67, -96, -97, -84, -84, -93, -80, -67, -87, -93, -73};
    }

    public static void A03() {
        A03 = new String[]{"HdBP5Xz", "1x1Spdd4leaR6rMyIqz7jDuVALPBafGP", "axXL5TnL0HBMXsVKsrA9GDOWQxSG9OY6", "1dEgnVHIT0m43fI6JYH9hpNhfyiBWS6N", "iEi5yE", "UjLwzpYsoJIrFySVWBkKISpV5tCrd9dB", "Qbq65yz", "qKKFep347IAmJ8sue1lLg6VgEBnKG6W3"};
    }

    public C2179at(K6 k6, K3 k3) {
        this.A01 = k6;
        this.A00 = k3;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        C14408h.A08(this.A01.A05);
        C5V.A08(this.A01.A05);
        boolean z = true;
        this.A01.A04 = this.A00.A09(AnonymousClass92.A00().A01(this.A01.A05, true).A6G());
        try {
            this.A01.A04.put(A00(1, 12, 5), new String(Base64.encode((this.A01.A05.getPackageName() + A00(0, 1, 84) + this.A01.A05.getPackageManager().getInstallerPackageName(this.A01.A05.getPackageName())).getBytes(), 2)));
        } catch (Exception unused) {
        }
        try {
            if (this.A00.A06() != EnumC1702Jj.A03 && this.A00.A06() != EnumC1702Jj.A05 && this.A00.A06() != EnumC1702Jj.A04 && this.A00.A06() != null) {
                z = false;
            }
            Q1.A02(z, this.A01.A05).ABx(this.A01.A07, new C1868Px().A06(this.A01.A04).A09(), this.A01.A04(LP.A00()));
        } catch (Exception e2) {
            AdErrorType adErrorType = AdErrorType.AD_REQUEST_FAILED;
            String message = e2.getMessage();
            C0R c0rA0A = this.A01.A05.A0A();
            K6 k6 = this.A01;
            String errorMessage = A03[4];
            if (errorMessage.length() == 14) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "AzlAWwW";
            strArr[6] = "AhjxiUn";
            c0rA0A.A2m(LP.A01(k6.A00), adErrorType.getErrorCode(), message, adErrorType.isPublicError());
            this.A01.A0G(C1697Jd.A02(adErrorType, message));
        }
    }
}
