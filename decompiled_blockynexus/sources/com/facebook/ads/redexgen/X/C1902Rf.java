package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Rf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1902Rf implements AnonymousClass10 {
    public static byte[] A07;
    public static String[] A08;
    public final /* synthetic */ long A03;
    public final /* synthetic */ C1579Ei A04;
    public final /* synthetic */ C14478o A05;
    public final /* synthetic */ Runnable A06;
    public boolean A02 = false;
    public boolean A01 = false;
    public boolean A00 = false;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A07 = new byte[]{57, 46, 46, 51, 46, 67, 93, 73};
    }

    public static void A02() {
        A08 = new String[]{"NdU3dTBV9vpPy6YybD2Qky8Xp9oiymUK", "iGXlqhzjj4re98AW13mRmUxQt0ip7heY", "i4JUsV98mtHDxTx4GI", "uX4rqc35PVKyGMlab4Ievks4AeXTKuCR", "rLO13ppjW7wMy", "YX8F9O1K3gbo5OniWABn3Un2bmHHQded", "vQnjhTu4uDmsPPd6tCmWM2PRV3nZ7tVA", "6doRqStA7fW6oocsKlayDSgQ6jqa5ScM"};
    }

    public C1902Rf(C1579Ei c1579Ei, Runnable runnable, long j, C14478o c14478o) {
        this.A04 = c1579Ei;
        this.A06 = runnable;
        this.A03 = j;
        this.A05 = c14478o;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass10
    public final void AAY(RD rd) {
        if (!this.A00) {
            this.A00 = true;
            this.A04.A06(this.A05.A05(EnumC14518s.A03), null);
        }
        if (this.A04.A07 != null) {
            this.A04.A07.A0B();
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass10
    public final void AAZ(RD rd) {
        if (rd != this.A04.A01) {
            return;
        }
        this.A04.A0G().removeCallbacks(this.A06);
        C1579Ei c1579Ei = this.A04;
        c1579Ei.A02 = rd;
        c1579Ei.A07.A0E(rd);
        if (!this.A02) {
            this.A02 = true;
            this.A04.A06(this.A05.A05(EnumC14518s.A05), this.A04.A01(this.A03));
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass10
    public final void AAa(RD rd) {
        if (!this.A01) {
            this.A01 = true;
            C1579Ei c1579Ei = this.A04;
            C14478o c14478o = this.A05;
            EnumC14518s enumC14518s = EnumC14518s.A04;
            String[] strArr = A08;
            if (strArr[3].charAt(16) != strArr[0].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A08;
            strArr2[3] = "w5hMaJohNUScvyTMb6YchiksjKW7iU2S";
            strArr2[0] = "lwejxTPFHVjkcDrib15s3w6szJ9sWeR6";
            c1579Ei.A06(c14478o.A05(enumC14518s), null);
        }
        this.A04.A0M();
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass10
    public final void AAc(RD rd, C1697Jd c1697Jd) {
        if (rd != this.A04.A01) {
            return;
        }
        this.A04.A0G().removeCallbacks(this.A06);
        this.A04.A0P(rd);
        if (!this.A02) {
            this.A02 = true;
            Map mapA01 = this.A04.A01(this.A03);
            mapA01.put(A00(0, 5, 58), String.valueOf(c1697Jd.A04().getErrorCode()));
            mapA01.put(A00(5, 3, 72), String.valueOf(c1697Jd.A05()));
            this.A04.A06(this.A05.A05(EnumC14518s.A05), mapA01);
        }
        this.A04.A0O();
    }
}
