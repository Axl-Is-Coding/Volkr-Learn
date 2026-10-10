package com.facebook.ads.redexgen.X;

import android.content.Context;
import androidx.annotation.Nullable;
import com.facebook.ads.AdError;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.internal.api.Repairable;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5H implements RewardedVideoAdApi, Repairable {
    public static byte[] A04;
    public static String[] A05;
    public final RewardedVideoAd A00;
    public final C12861v A01;
    public final C1577Ee A02;
    public final C2026Wb A03;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{117, 115, 118, 119, 116, -91, 123, -93, -92, -94, -46, -91, -92, -91, -47, -127, -80, -122, -81, 126, -128, -80, -124, 73, 74, 72, 72, 69, 118, 77, 78, 82, 119, 125, 110, 123, 119, 106, 117, 41, 110, 123, 123, 120, 123, 55, 19, -51, -32, -14, -36, -19, -33, -32, -33, -101, -15, -28, -33, -32, -22, -101, -36, -33, -101, -33, -32, -18, -17, -19, -22, -12, -32, -33, -81, -62, -44, -66, -49, -63, -62, -63, 125, -45, -58, -63, -62, -52, 125, -66, -63, 125, -55, -52, -66, -63, 125, -49, -62, -50, -46, -62, -48, -47, -62, -63, -63, -44, -26, -48, -31, -45, -44, -45, -113, -27, -40, -45, -44, -34, -113, -48, -45, -113, -30, -41, -34, -26, -113, -46, -48, -37, -37, -44, -45, -86, -85, -71, -70, -72, -75, -65, -84, -81, -95, -92, -127, -92, -43, -54, -47, -39};
    }

    public static void A02() {
        A05 = new String[]{"q8F3UYcndC8Ej6EzPObAfC2CDIoe743", "WHSSbjkejcnDJnmz9i28DmVQ7s5doV", "7Ae3C11G9ZnRQnjC1YEsbkjNlyvjMOhJ", "xIErM25UzhDXOZX5lXVK71ghnZu2uIsx", "TpWxEHvEZyAqJcOvGEooXr2tQ3t7MLKT", "CpjtrdZmrEbCE1OZgZlStH8uGVShpb", "AnU5GMoet7ZaRK4jG6aRRqRoHnPXG1EV", "P"};
    }

    public C5H(Context context, String str, RewardedVideoAd rewardedVideoAd) {
        this.A00 = rewardedVideoAd;
        this.A03 = AnonymousClass50.A05(context);
        this.A03.A0A().A2j(AdPlacementType.REWARDED_VIDEO.toString());
        this.A01 = new C12861v(this.A03, str, this.A00);
        this.A03.A0C(this);
        this.A02 = new C1577Ee(this.A01);
    }

    public final void A03(RewardData rewardData) {
        this.A02.A08(rewardData);
    }

    public final void A04(RewardedVideoAdListener rewardedVideoAdListener) {
        this.A01.A04 = rewardedVideoAdListener;
        this.A03.A0A().A2c(rewardedVideoAdListener != null);
    }

    public final void A05(@Nullable String str, @Nullable AdExperienceType adExperienceType, boolean z) {
        if (str == null) {
            this.A03.A0A().A2g();
        } else {
            C2026Wb c2026Wb = this.A03;
            if (A05[1].length() != 30) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[1] = "VbNMcinO8suVZXvBDeNnaTURWjAwCx";
            strArr[1] = "VbNMcinO8suVZXvBDeNnaTURWjAwCx";
            c2026Wb.A0A().A2f();
        }
        this.A02.A09(this.A00, str, adExperienceType, z);
        this.A03.A0A().A2e();
    }

    @Override // com.facebook.ads.FullScreenAd
    public final RewardedVideoAd.RewardedVideoAdLoadConfigBuilder buildLoadAdConfig() {
        return new C5I(this);
    }

    @Override // com.facebook.ads.FullScreenAd
    public final RewardedVideoAd.RewardedVideoAdShowConfigBuilder buildShowAdConfig() {
        return new C5J();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    public final void destroy() {
        C1710Jr.A05(A00(135, 7, 66), A00(47, 27, 119), A00(7, 8, 108));
        if (C1693Iy.A1G(this.A03)) {
            return;
        }
        this.A02.A05();
        this.A03.A0A().A2k();
    }

    public final void finalize() {
        this.A02.A04();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A01.A0C;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final int getVideoDuration() {
        return this.A01.A00;
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean zA0A = this.A02.A0A();
        this.A03.A0A().A4X(zA0A);
        return zA0A;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final boolean isAdLoaded() {
        return this.A02.A0B();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    public final void loadAd() {
        C1710Jr.A05(A00(142, 6, 60), A00(74, 32, 89), A00(23, 8, 17));
        A05(null, null, true);
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final void loadAd(RewardedVideoAd.RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        ((C5I) rewardedVideoLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.api.Repairable
    public final void repair(Throwable th) {
        if (this.A01.A04 != null) {
            this.A01.A04.onError(this.A00, new AdError(2001, A00(31, 16, 5) + LG.A03(this.A01.A0B, th)));
        }
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.Ad
    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A01.A06 = extraHints.getHints();
        this.A01.A07 = extraHints.getMediationData();
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi, com.facebook.ads.FullScreenAd
    public final boolean show() {
        C1710Jr.A05(A00(148, 4, 94), A00(106, 29, 107), A00(15, 8, 74));
        this.A03.A0A().A2p();
        boolean zA0C = this.A02.A0C(this.A00, new C5J().withAppOrientation(-1).build());
        this.A03.A0A().A2o(zA0C);
        return zA0C;
    }

    @Override // com.facebook.ads.internal.api.RewardedVideoAdApi
    public final boolean show(RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        C1710Jr.A05(A00(148, 4, 94), A00(106, 29, 107), A00(0, 7, 62));
        this.A03.A0A().A2p();
        boolean zA0C = this.A02.A0C(this.A00, rewardedVideoShowAdConfig);
        this.A03.A0A().A2o(zA0C);
        return zA0C;
    }
}
