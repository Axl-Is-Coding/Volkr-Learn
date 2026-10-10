package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5A implements NativeAdsManagerApi {
    public static byte[] A0A;
    public static final String A0B;
    public NativeAdsManager.Listener A01;
    public C1904Rh A02;
    public String A03;
    public final int A06;
    public final C2026Wb A07;
    public final String A08;
    public final List<NativeAd> A09;
    public int A00 = -1;
    public boolean A04 = false;
    public boolean A05 = false;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0A = new byte[]{27, 60, 52, 49, 56, 57, 125, 41, 50, 125, 52, 51, 52, 41, 52, 60, 49, 52, 39, 56, 125, 30, 50, 50, 54, 52, 56, ci.n, 60, 51, 60, 58, 56, 47, 115};
    }

    static {
        A01();
        A0B = NativeAdsManager.class.getSimpleName();
    }

    @SuppressLint({"CatchGeneralException"})
    public C5A(Context context, String str, int i) {
        this.A07 = AnonymousClass50.A02(context);
        this.A08 = str;
        this.A06 = Math.max(i, 0);
        this.A09 = new ArrayList(i);
        try {
            CookieManager.getInstance();
            if (Build.VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(context);
            }
        } catch (Exception e2) {
            Log.w(A0B, A00(0, 35, 89), e2);
        }
    }

    public final NativeAdsManager.Listener A02() {
        return this.A01;
    }

    public final C1904Rh A03() {
        return this.A02;
    }

    public final void A04() {
        this.A09.clear();
    }

    public final void A05(int i) {
        this.A00 = i;
    }

    public final void A06(NativeAd nativeAd) {
        this.A09.add(nativeAd);
    }

    public final void A07(boolean z) {
        this.A04 = z;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void disableAutoRefresh() {
        this.A05 = true;
        C1904Rh c1904Rh = this.A02;
        if (c1904Rh != null) {
            c1904Rh.A07();
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final int getUniqueNativeAdCount() {
        return this.A09.size();
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final boolean isLoaded() {
        return this.A04;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void loadAds() {
        loadAds(NativeAdBase.MediaCacheFlag.ALL);
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void loadAds(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        EnumC1702Jj enumC1702Jj = EnumC1702Jj.A05;
        int i = this.A06;
        C1904Rh c1904Rh = this.A02;
        this.A02 = new C1904Rh(this.A07, this.A08, enumC1702Jj, null, i);
        if (this.A05) {
            this.A02.A07();
        }
        this.A02.A0A(this.A03);
        this.A02.A09(new T6(this, this.A07, mediaCacheFlag));
        this.A02.A08();
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final NativeAd nextNativeAd() {
        if (this.A09.size() == 0) {
            return null;
        }
        int i = this.A00;
        this.A00 = i + 1;
        List<NativeAd> list = this.A09;
        NativeAd nativeAd = list.get(i % list.size());
        if (i >= this.A09.size()) {
            return new NativeAd(this.A07, nativeAd);
        }
        return nativeAd;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void setExtraHints(String str) {
        this.A03 = str;
    }

    @Override // com.facebook.ads.internal.api.NativeAdsManagerApi
    public final void setListener(NativeAdsManager.Listener listener) {
        this.A01 = listener;
    }
}
