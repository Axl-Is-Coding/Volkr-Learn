package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4p, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13554p implements AdViewApi {
    public static byte[] A0D;
    public static String[] A0E;
    public long A00;

    @Nullable
    public View A01;

    @Nullable
    public AdListener A02;

    @Nullable
    public C1581Ek A03;
    public NO A04;

    @Nullable
    public String A05;

    @Nullable
    public String A06;
    public final DisplayMetrics A07;
    public final AdView A08;
    public final AdViewParentApi A09;
    public final C1534Cl A0A;
    public final EnumC1701Ji A0B;
    public final String A0C;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 64);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {-78, -70, -74, -76, -73, -71, -26, -77, 122, 119, 124, 123, 117, -89, 117, 121, -12, 36, 33, 36, -16, -12, -12, -15, -17, ci.l, 27, 27, 18, 31, -51, ci.l, 17, -51, 17, 18, 32, 33, 31, 28, 38, 18, 17, -14, 17, 30, 30, 21, 34, -48, 17, 20, -48, 28, 31, 17, 20, -48, 34, 21, 33, 37, 21, 35, 36, 21, 20, -118, -88, -75, -75, -74, -69, 103, -83, -80, -75, -85, 103, -88, 103, -69, -84, -76, -73, -77, -88, -69, -84, 103, -69, -81, -88, -69, 103, -77, -74, -88, -85, 103, -87, -80, -85, 103, 110, 108, -70, 110, -77, -74, -91, -69, -52, -73, -20, -19, -5, -4, -6, -9, 1, -40, -37, -51, -48, -83, -48};
        if (A0E[2].charAt(11) != 'D') {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[7] = "i0zr3oWhaZ1ZQYjulO9yltnfKtDweGPM";
        strArr[6] = "f16HnFk6V4WfoRTY4RGQrwGHYb77b2mz";
        A0D = bArr;
    }

    public static void A03() {
        A0E = new String[]{"of0bzA7MwNGTia9F31tAkieNA09H6OOQ", "TyTQj7xFBxvma6AaZ1TUwVS6lItsexiQ", "kN9yyhhGlFuDqh5wulKzoOOSsFZblOVu", "DXKKP4SSVuW5x9unPZpKCS00jdGSX4q", "ceBkREnsnDPWKQGMERGG6oDocc2kf8dJ", "ULZujO58Hn4sCnlurEwExiI5FfKtYml", "oBzM86F4GMvLYp6iWCqbmyfPVfF4ncm8", "8s2Qgj6JQYkd4IbFNTxV1lfTN5yJUxqm"};
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public C13554p(Context context, String str, AdSize adSize, AdViewParentApi adViewParentApi, AdView adView) {
        this.A00 = -1L;
        if (adSize != null && adSize != AdSize.INTERSTITIAL) {
            this.A07 = adView.getContext().getResources().getDisplayMetrics();
            this.A0B = EnumC1701Ji.A02(adSize);
            this.A0C = str;
            this.A09 = adViewParentApi;
            this.A08 = adView;
            this.A0A = AnonymousClass50.A06(context);
            this.A0A.A0A().A2j(AdPlacementType.BANNER.toString());
            C12741j c12741j = new C12741j(str, C1704Jl.A02(this.A0B), AdPlacementType.BANNER, EnumC1701Ji.A02(adSize), 1);
            c12741j.A05(this.A05);
            c12741j.A06(this.A06);
            this.A03 = new C1581Ek(this.A0A, c12741j);
            this.A03.A0R(new C1939Ss(this));
            return;
        }
        throw new IllegalArgumentException(A01(108, 6, 18));
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    public C13554p(Context context, String str, String str2, AdViewParentApi adViewParentApi, AdView adView) throws C1698Je {
        this(context, str, A00(str2), adViewParentApi, adView);
        this.A0A.A0A().A3d();
    }

    public static AdSize A00(String str) throws C1698Je {
        EnumC1702Jj enumC1702JjA00 = C1707Jo.A00(str);
        if (enumC1702JjA00 != null) {
            C1707Jo.A04(enumC1702JjA00);
            return C1704Jl.A00(enumC1702JjA00);
        }
        throw new C1698Je(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A01(67, 41, 7), str));
    }

    private void A04(@Nullable String str) {
        this.A00 = System.currentTimeMillis();
        if (str == null) {
            this.A0A.A0A().A2g();
        } else {
            this.A0A.A0A().A2f();
        }
        C1581Ek c1581Ek = this.A03;
        String[] strArr = A0E;
        if (strArr[3].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0E;
        strArr2[3] = "8EJDtH9EjlwutgZO3WtzB3nx702AY4O";
        strArr2[5] = "dTiKD7UwUCw1SvcKYJrEphBgoR9CLtC";
        if (c1581Ek != null) {
            c1581Ek.A0T(str);
        }
        this.A0A.A0A().A2e();
    }

    public final long A05() {
        return this.A00;
    }

    public final DisplayMetrics A06() {
        return this.A07;
    }

    @Nullable
    public final AdListener A07() {
        return this.A02;
    }

    public final AdView A08() {
        return this.A08;
    }

    @Nullable
    public final C1581Ek A09() {
        return this.A03;
    }

    public final C1534Cl A0A() {
        return this.A0A;
    }

    public final EnumC1701Ji A0B() {
        return this.A0B;
    }

    public final void A0C(RelativeLayout relativeLayout, View view) {
        OS osA01;
        this.A0A.A0A().A3q(this.A06 != null);
        String str = this.A06;
        if (str != null && (osA01 = OR.A01(this.A0A, str)) != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            relativeLayout.addView(osA01, new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height));
        }
    }

    public final void A0D(@Nullable AdListener adListener) {
        this.A0A.A0A().A2c(adListener != null);
        this.A02 = adListener;
    }

    public final void A0E(NO no) {
        this.A04 = no;
    }

    @Override // com.facebook.ads.internal.api.AdViewApi
    public final AdView.AdViewLoadConfigBuilder buildLoadAdConfig() {
        return new JG(this);
    }

    @Override // com.facebook.ads.Ad
    public final void destroy() {
        C1710Jr.A05(A01(114, 7, 72), A01(24, 19, 109), A01(8, 8, 5));
        this.A0A.A0A().A2k();
        C1581Ek c1581Ek = this.A03;
        if (c1581Ek != null) {
            c1581Ek.A0W(true);
            this.A03 = null;
        }
        if (Build.VERSION.SDK_INT >= 18 && this.A04 != null && C1693Iy.A0r(this.A08.getContext())) {
            NO no = this.A04;
            String[] strArr = A0E;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[7] = "fmi4ltQko56R0Ot1hIU3uMuoiOam3SD1";
            strArr2[6] = "7H1g3sSDF1cZj7eOXlokIXc1uirRZwhG";
            no.A08();
            View view = this.A01;
            if (view != null) {
                view.getOverlay().remove(this.A04);
            }
        }
        this.A08.removeAllViews();
        this.A01 = null;
        this.A02 = null;
    }

    @Override // com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A0C;
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        C1581Ek c1581Ek = this.A03;
        boolean z = c1581Ek == null || c1581Ek.A0X();
        this.A0A.A0A().A4X(z);
        return z;
    }

    @Override // com.facebook.ads.Ad
    public final void loadAd() {
        C1710Jr.A05(A01(121, 6, 44), A01(43, 24, 112), A01(0, 8, 65));
        A04(null);
    }

    @Override // com.facebook.ads.internal.api.AdViewApi
    public final void loadAd(AdView.AdViewLoadConfig adViewLoadConfig) {
        C1710Jr.A05(A01(121, 6, 44), A01(43, 24, 112), A01(16, 8, 127));
        A04(((JG) adViewLoadConfig).A00());
    }

    @Override // com.facebook.ads.internal.api.AdViewApi, com.facebook.ads.internal.api.AdViewParentApi
    public final void onConfigurationChanged(Configuration configuration) {
        this.A09.onConfigurationChanged(configuration);
        View view = this.A01;
        if (view != null) {
            C1704Jl.A04(this.A07, view, this.A0B);
        }
    }

    @Override // com.facebook.ads.internal.api.AdViewApi, com.facebook.ads.Ad
    @Deprecated
    public final void setExtraHints(ExtraHints extraHints) {
        this.A05 = extraHints.getHints();
        this.A06 = extraHints.getMediationData();
    }
}
