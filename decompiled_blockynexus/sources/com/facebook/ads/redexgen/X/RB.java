package com.facebook.ads.redexgen.X;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;
import java.util.UUID;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RB implements InterfaceC12510m, C1X {
    public static byte[] A0B;
    public static String[] A0C;
    public long A00;
    public RewardData A01;
    public InterfaceC12610w A02;
    public C12620x A03;
    public RR A04;
    public C2026Wb A05;
    public String A06;

    @Nullable
    public String A07;
    public String A08;
    public boolean A09;
    public final String A0A = UUID.randomUUID().toString();

    static {
        A06();
        A05();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        byte[] bArr = {78, 108, 99, 42, 121, 45, 126, 121, 108, 127, 121, 45, 76, 120, 105, 100, 104, 99, 110, 104, 67, 104, 121, 122, 98, 127, 102, 76, 110, 121, 100, 123, 100, 121, 116, 35, 45, 64, 108, 102, 104, 45, 126, 120, 127, 104, 45, 121, 101, 108, 121, 45, 100, 121, 42, 126, 45, 100, 99, 45, 116, 98, 120, 127, 45, 76, 99, 105, 127, 98, 100, 105, 64, 108, 99, 100, 107, 104, 126, 121, 35, 117, 96, 97, 45, 107, 100, 97, 104, 35, 73, 77, 78, 122, 107, 102, 106, 97, 108, 106, 65, 106, 123, 120, 96, 125, 100, 68, 37, 42, 27, 37, 39, 48, 45, 50, 45, 48, 61, 93, 82, 87, 91, 80, 74, 106, 81, 85, 91, 80, 17, 25, 24, 21, 29, 8, 21, 19, 18, 56, 29, 8, 29, 52, 40, 37, 39, 33, 41, 33, 42, 48, ci.k, 32, 4, 6, 17, ci.n, 17, 18, 29, 26, 17, ci.n, 59, 6, 29, 17, 26, 0, 21, 0, 29, 27, 26, Utf8.REPLACEMENT_BYTE, 17, ci.k, 117, 98, 118, 114, 98, 116, 115, 83, 110, 106, 98, 29, 6, 1, 25, 29, ci.k, 33, 12, 38, 57, 53, 39, 4, 41, 32, 53, 80, 78, 73, 67, 72, 80};
        if (A0C[1].charAt(29) == 'g') {
            throw new RuntimeException();
        }
        String[] strArr = A0C;
        strArr[4] = "6qgGoSyjmuhDFT94hunOHzgd3UUS7LMQ";
        strArr[0] = "q1PjRK7gg6WFD8n4pAFO870HLaNMi7ir";
        A0B = bArr;
    }

    public static void A06() {
        A0C = new String[]{"PgLDGrk3t3a26fQCrT3IpIrRB5PMNBKm", "uls9HIPpriPjzjIXJVTR7HWmS4IMGzWu", "f2YRmtND2fanruA3kJYGXgN9aGwgjawI", "EZdssni07U2TMPMup9RmA63S0tAhTBNo", "xilKUxawUAlWzUTJOedtCKHAHwNBDRxA", "SxIuirRfQS0L7ik0LzQXw", "dF8CYh", "NQmOIXzIEfwTEqDrM9Z7TuMEUTKSiMNX"};
    }

    private int A00() {
        int rotation = ((WindowManager) this.A05.getSystemService(A03(205, 6, 47))).getDefaultDisplay().getRotation();
        NR adOrientation = A02();
        if (adOrientation == NR.A06) {
            return -1;
        }
        if (adOrientation == NR.A04) {
            if (rotation != 2 && rotation != 3) {
                return 0;
            }
            if (A0C[1].charAt(29) == 'g') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[3] = "WCZdwi0h9oyTFk4ywD5LtkOxTOpQ29Yc";
            strArr[7] = "4yy96Y2PoNFTEE84mLwUlYETryPZgGhE";
            return 8;
        }
        if (rotation != 2) {
            return 1;
        }
        return 9;
    }

    private final KC A01() {
        return this.A04.A0A();
    }

    private NR A02() {
        return this.A04.A0B();
    }

    private void A04() {
        this.A09 = true;
    }

    private void A07(Intent intent) {
        RR rr = this.A04;
        RewardData rewardData = this.A01;
        rr.A0E(intent, rewardData, C1820Ob.A03(rewardData, this.A0A, this.A06));
    }

    private final void A08(C2026Wb c2026Wb, InterfaceC12610w interfaceC12610w, Map<String, Object> map, EnumSet<CacheFlag> enumSet, @Nullable String str) {
        this.A04 = new RR(c2026Wb, map, this, str);
        this.A04.A0F(c2026Wb, enumSet);
    }

    private void A09(KC kc) {
        if (kc.equals(KC.A06)) {
            this.A05.A0A().ADQ(EnumC12410c.A03);
            return;
        }
        if (kc.equals(KC.A07)) {
            this.A05.A0A().ADQ(EnumC12410c.A06);
            return;
        }
        if (kc.equals(KC.A09)) {
            this.A05.A0A().ADQ(EnumC12410c.A08);
            return;
        }
        if (kc.equals(KC.A08)) {
            this.A05.A0A().ADQ(EnumC12410c.A07);
            return;
        }
        if (!kc.equals(KC.A03)) {
            return;
        }
        if (this.A04.A0G()) {
            C0R c0rA0A = this.A05.A0A();
            String[] strArr = A0C;
            if (strArr[5].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[2] = "SZ1DhKHJxqFOmux8c4F7iNiG5ZFRRvjL";
            strArr2[2] = "SZ1DhKHJxqFOmux8c4F7iNiG5ZFRRvjL";
            c0rA0A.ADQ(EnumC12410c.A05);
            return;
        }
        this.A05.A0A().ADQ(EnumC12410c.A04);
    }

    public final void A0A(C2026Wb c2026Wb, InterfaceC12610w interfaceC12610w, Map<String, Object> map, EnumSet<CacheFlag> enumSet, @Nullable String str, @Nullable String str2, @Nullable RewardData rewardData) {
        String strA03;
        this.A05 = c2026Wb;
        this.A02 = interfaceC12610w;
        this.A08 = (String) map.get(A03(143, 11, 76));
        String str3 = this.A08;
        if (str3 != null) {
            strA03 = str3.split(A03(107, 1, 19))[0];
        } else {
            if (A0C[2].charAt(13) != 'u') {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[1] = "jgXU3SqF8Uv0ED4x1YEVN8i2uqYthAt6";
            strArr[1] = "jgXU3SqF8Uv0ED4x1YEVN8i2uqYthAt6";
            strA03 = A03(0, 0, 5);
        }
        this.A06 = strA03;
        this.A00 = ((Long) map.get(A03(178, 11, 15))).longValue();
        this.A07 = str2;
        this.A01 = rewardData;
        A08(c2026Wb, interfaceC12610w, map, enumSet, str);
    }

    public final boolean A0B() {
        if (!this.A09) {
            InterfaceC12610w interfaceC12610w = this.A02;
            if (interfaceC12610w != null) {
                interfaceC12610w.AA7(this, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR);
            }
            return false;
        }
        AdActivityIntent adActivityIntentA04 = C1725Kh.A04(this.A05);
        adActivityIntentA04.putExtra(A03(154, 24, 124), A00());
        adActivityIntentA04.putExtra(A03(189, 8, 96), this.A0A);
        adActivityIntentA04.putExtra(A03(143, 11, 76), this.A08);
        adActivityIntentA04.putExtra(A03(178, 11, 15), this.A00);
        KC kcA01 = A01();
        A09(kcA01);
        adActivityIntentA04.putExtra(A03(197, 8, 88), kcA01);
        String str = this.A07;
        if (str != null) {
            adActivityIntentA04.putExtra(A03(130, 13, 116), str);
        }
        A07(adActivityIntentA04);
        adActivityIntentA04.addFlags(268435456);
        adActivityIntentA04.putExtra(A03(119, 11, 54), this.A04.A0C());
        try {
            C1728Kk.A04(this.A05);
            C1725Kh.A0A(this.A05, adActivityIntentA04);
            return true;
        } catch (ActivityNotFoundException e2) {
            this.A05.A04().A8H(A03(108, 11, 76), C8Y.A05, new C8Z(e2));
            Log.e(A03(90, 17, 7), A03(0, 90, 5), e2);
            return false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12510m
    @Nullable
    public final String A5q() {
        return this.A04.A0C();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12510m
    public final AdPlacementType A6p() {
        return AdPlacementType.INTERSTITIAL;
    }

    @Override // com.facebook.ads.redexgen.X.C1X
    public final void A92(AdError adError) {
        InterfaceC12610w interfaceC12610w = this.A02;
        if (interfaceC12610w != null) {
            interfaceC12610w.AA7(this, adError);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1X
    public final void A93() {
        A04();
        this.A02.AA6(this);
    }

    @Override // com.facebook.ads.redexgen.X.C1X
    public final void ACT() {
        this.A03 = new C12620x(this.A05, this.A0A, this, this.A02);
        this.A03.A03();
    }

    @Override // com.facebook.ads.redexgen.X.C1X
    public final void ADu() {
        C12620x c12620x = this.A03;
        if (c12620x != null) {
            c12620x.A04();
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC12510m
    public final void onDestroy() {
        RR rr = this.A04;
        if (rr != null) {
            rr.A0D();
        }
    }
}
