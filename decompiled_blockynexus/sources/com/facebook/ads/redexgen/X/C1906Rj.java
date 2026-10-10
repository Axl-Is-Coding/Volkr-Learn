package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1906Rj implements AnonymousClass11 {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ Eg A00;
    public final /* synthetic */ Runnable A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 97);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{80, 5, 82, 81, 84, 4, 5, 3, 112, 71, 85, 67, 80, 70, 71, 70, 2, 116, 75, 70, 71, 77, 2, 75, 79, 82, 80, 71, 81, 81, 75, 77, 76, 2, 68, 75, 80, 71, 70, 70, 71, 123, 76, 94, 72, 91, 77, 76, 77, 127, 64, 77, 76, 70, 104, 77, 101, 70, 78, 78, 64, 71, 78, 96, 68, 89, 91, 76, 90, 90, 64, 70, 71};
    }

    public static void A02() {
        A03 = new String[]{"gOGPE1XGqnroAJihU7XGAfTAdWa21jWC", "Kcs30m2Uc1eFMAQARd2pOhOOSRswugkg", "xkwB", "vFLx4ryI8nKhSFQKGVnAMH5qObxMihWN", "NnwKyO2XMzRH0BXfVduboZ9DAJ5a5svW", "U3uRLxNZuwH", "U9y6Wp3Jad2LD1", "sOAhAPVwmiqriGnbgM61Uai8lTIQh97W"};
    }

    public C1906Rj(Eg eg, Runnable runnable) {
        this.A00 = eg;
        this.A01 = runnable;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void AB5(RJ rj) {
        this.A00.A07.A05();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void AB6(RJ rj) {
        this.A00.A07.A06();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void AB7(RJ rj) {
        this.A00.A07.A0B();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void AB8(RJ rj) {
        this.A00.A0G().removeCallbacks(this.A01);
        Eg eg = this.A00;
        eg.A02 = rj;
        super/*com.facebook.ads.redexgen.X.Rb*/.A0J();
        this.A00.A07.A0E(rj);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void AB9(RJ rj) {
        C1710Jr.A05(A00(39, 34, 72), A00(8, 31, 67), A00(0, 8, 7));
        this.A00.A07.A0C();
        this.A00.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void ABA(RJ rj) {
        this.A00.A07.A07();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void ABB(RJ rj, AdError adError) {
        this.A00.A0G().removeCallbacks(this.A01);
        this.A00.A0C.A0A().A4Y(adError.getErrorCode(), adError.getErrorMessage());
        if (AdError.AD_PRESENTATION_ERROR.equals(adError) && C1693Iy.A17(this.A00.A0C)) {
            this.A00.A07.A0F(C1697Jd.A01(AdErrorType.AD_PRESENTATION_ERROR));
        } else {
            Eg eg = this.A00;
            if (A03[2].length() != 4) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[2] = "s57s";
            strArr[2] = "s57s";
            eg.A07.A0F(C1697Jd.A01(AdErrorType.INTERNAL_ERROR));
        }
        this.A00.A0P(rj);
        this.A00.A0O();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void onRewardedVideoActivityDestroyed() {
        this.A00.A07.A08();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass11
    public final void onRewardedVideoClosed() {
        this.A00.A07.A09();
    }
}
