package com.facebook.ads.internal.dynamicloading;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import com.facebook.ads.internal.api.AdSettingsApi;
import com.facebook.ads.internal.api.AdSizeApi;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.api.AudienceNetworkAdsApi;
import com.facebook.ads.internal.api.BidderTokenProviderApi;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.api.InitApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import com.facebook.ads.internal.api.NativeAdViewApi;
import com.facebook.ads.internal.api.NativeAdViewAttributesApi;
import com.facebook.ads.internal.api.NativeAdViewTypeApi;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import com.facebook.ads.internal.api.NativeBannerAdApi;
import com.facebook.ads.internal.api.NativeBannerAdViewApi;
import com.facebook.ads.internal.api.NativeComponentTagApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoader;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.ads.internal.settings.AdSharedPreferences;
import com.facebook.ads.internal.settings.MultithreadedBundleWrapper;
import com.facebook.ads.redexgen.X.AnonymousClass50;
import com.facebook.ads.redexgen.X.AnonymousClass52;
import com.facebook.ads.redexgen.X.AnonymousClass55;
import com.facebook.ads.redexgen.X.AnonymousClass56;
import com.facebook.ads.redexgen.X.AnonymousClass57;
import com.facebook.ads.redexgen.X.C13524m;
import com.facebook.ads.redexgen.X.C13554p;
import com.facebook.ads.redexgen.X.C13604u;
import com.facebook.ads.redexgen.X.C13765k;
import com.facebook.ads.redexgen.X.C14538v;
import com.facebook.ads.redexgen.X.C1698Je;
import com.facebook.ads.redexgen.X.C1932Sl;
import com.facebook.ads.redexgen.X.C1946Sz;
import com.facebook.ads.redexgen.X.C2204bJ;
import com.facebook.ads.redexgen.X.C2213bT;
import com.facebook.ads.redexgen.X.C5A;
import com.facebook.ads.redexgen.X.C5H;
import com.facebook.ads.redexgen.X.EnumC1701Ji;
import com.facebook.ads.redexgen.X.JQ;
import com.facebook.ads.redexgen.X.JR;
import com.facebook.ads.redexgen.X.JS;
import com.facebook.ads.redexgen.X.T0;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import okio.Utf8;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class DynamicLoaderImpl implements DynamicLoader {
    public static AdSettingsApi A00;
    public static AudienceNetworkAdsApi A01;
    public static NativeAdViewApi A02;
    public static NativeBannerAdViewApi A03;
    public static C13765k A04;
    public static String[] A05;
    public static final InitApi A06;

    public static void A00() {
        A05 = new String[]{"", "hl0DpOFqxM1jfK98LJTADvCdgffrETQN", "QW5nZBv4w8ebawOaJAju5UC6DpXIEYNP", "lDXIr49IIqC5d9soZ9ZlhOdK7Sq4PNcS", "1TLrXBQAGAxZIydv1bacR9cCDSxOiDhT", "HKpyy44hPf1TiYKwXHdFJYATCyhvdc4i", "5Vop4gtsdytJgHep4xjnsMChzM034SFi", "0HGMkPnlBdCz3NKZQL2lJn"};
    }

    static {
        A00();
        A06 = new InitApi() { // from class: com.facebook.ads.redexgen.X.51
            @Override // com.facebook.ads.internal.api.InitApi
            public final void initialize(Context context, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener, int i) {
                C14538v.A0H(AnonymousClass50.A07(context), multithreadedBundleWrapper, initListener, i);
            }

            @Override // com.facebook.ads.internal.api.InitApi
            public final boolean isInitialized() {
                return C14538v.A0J();
            }

            @Override // com.facebook.ads.internal.api.InitApi
            public final void maybeAttachCrashListener(Context context) {
                C14538v.A08(AnonymousClass50.A07(context));
            }

            @Override // com.facebook.ads.internal.api.InitApi
            public final void onAdEventManagerCreated(Context context) {
                C14538v.A09(AnonymousClass50.A07(context));
            }

            @Override // com.facebook.ads.internal.api.InitApi
            public final void onAdLoadInvoked(Context context) {
                C14538v.A0A(AnonymousClass50.A07(context));
            }

            @Override // com.facebook.ads.internal.api.InitApi
            public final void onContentProviderCreated(Context context) {
                C14538v.A0B(AnonymousClass50.A07(context));
            }
        };
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdOptionsViewApi createAdOptionsView(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView.Orientation orientation, int i, AdOptionsView adOptionsView) {
        return new C1932Sl(context, nativeAdBase, nativeAdLayout, orientation, i, adOptionsView);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdOptionsViewApi createAdOptionsView(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView adOptionsView) {
        return new C1932Sl(context, nativeAdBase, nativeAdLayout, adOptionsView);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdSettingsApi createAdSettingsApi() {
        if (A00 == null) {
            A00 = new AdSettingsApi() { // from class: com.facebook.ads.redexgen.X.4o
                public static byte[] A00;
                public static String[] A01;
                public static final String A02;
                public static final Collection<String> A03;
                public static volatile boolean A04;

                public static String A00(int i, int i2, int i3) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
                    for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                        bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 48);
                    }
                    return new String(bArrCopyOfRange);
                }

                public static void A01() {
                    A00 = new byte[]{124, 119, 101, 8, ci.m, 9, 4, 31, 30, ci.k, 18, 24, 30, 4, 18, 31, 4, 19, 26, 8, 19, 4, ci.n, 30, 2, 107, 90, 76, 75, 31, 82, 80, 91, 90, 31, 91, 90, 73, 86, 92, 90, 31, 87, 94, 76, 87, 5, 31, 45, 18, 31, 20, 90, ci.l, 31, 9, ci.l, 19, 20, 29, 90, 3, 21, ci.m, 8, 90, 27, 10, 10, 90, ci.k, 19, ci.l, 18, 90, 60, 27, 25, 31, 24, 21, 21, 17, 93, 9, 90, 27, 30, 90, ci.m, 20, 19, ci.l, 9, 90, 3, 21, ci.m, 90, 23, ci.m, 9, ci.l, 90, 9, 10, 31, 25, 19, 28, 3, 90, ci.l, 18, 31, 90, 30, 31, 12, 19, 25, 31, 90, 18, 27, 9, 18, 31, 30, 90, 51, 62, 90, ci.l, 21, 90, 31, 20, 9, ci.m, 8, 31, 90, ci.l, 18, 31, 90, 30, 31, 22, 19, 12, 31, 8, 3, 90, 21, 28, 90, ci.l, 31, 9, ci.l, 90, 27, 30, 9, 86, 90, 27, 30, 30, 90, ci.l, 18, 31, 90, 28, 21, 22, 22, 21, ci.k, 19, 20, 29, 90, 25, 21, 30, 31, 90, 24, 31, 28, 21, 8, 31, 90, 22, 21, 27, 30, 19, 20, 29, 90, 27, 20, 90, 27, 30, 64, 90, 59, 30, 41, 31, ci.l, ci.l, 19, 20, 29, 9, 84, 27, 30, 30, 46, 31, 9, ci.l, 62, 31, 12, 19, 25, 31, 82, 88, 26, 27, 8, 23, 29, 27, 55, 26, 54, 31, ci.k, 22, 60, 52, 52, 60, 55, 62, 4, 40, Utf8.REPLACEMENT_BYTE, 48, 114, 101, 106, 102, 114, 127, 104, 40, 38, 96, 41, 61, 48, 39, 103, 105, 43, 47};
                }

                public static void A02() {
                    A01 = new String[]{"TFkOB7WAPr6F4oSDAD2lBM3orjMmpCql", "qm70b4Ur0FRBuwfAT3tN36vqG0Nf4UFd", "zPpQ1cnfbXvczPvVr", "8IvLkkrNdMNEKNCoxjkf6IUs19Br2Jri", "GW45NL8mXfcvSmeq7", "yk6fztNbTNbTdYOeWP4a4qU6KiJuVBGT", "Yi7aT5eKgI7tScmdPed7vydq7f2NoqCT", "ldtlhzHQs0POAzCz5K2SoOIZIeNjlq2l"};
                }

                static {
                    A02();
                    A01();
                    A02 = AdInternalSettings.class.getSimpleName();
                    A03 = new HashSet();
                    A03.add(A00(262, 3, 49));
                    A03.add(A00(252, 10, 107));
                    A03.add(A00(265, 7, 32));
                    A03.add(A00(272, 8, 111));
                    A04 = false;
                }

                public static void A03(String str) {
                    if (A04) {
                        return;
                    }
                    A04 = true;
                    Log.i(A02, A00(25, 23, 15) + str);
                    Log.i(A02, A00(48, 192, 74) + str + A00(0, 3, 110));
                }

                @Override // com.facebook.ads.internal.api.AdSettingsApi
                public final boolean isTestMode(Context context) {
                    if (AdInternalSettings.isDebugBuild() || AdInternalSettings.isExplicitTestMode() || A03.contains(Build.PRODUCT)) {
                        return true;
                    }
                    MultithreadedBundleWrapper multithreadedBundleWrapper = AdInternalSettings.sSettingsBundle;
                    String strA00 = A00(3, 22, 107);
                    String string = multithreadedBundleWrapper.getString(strA00, null);
                    if (string == null) {
                        SharedPreferences sharedPreferences = AdSharedPreferences.getSharedPreferences(context);
                        String strA002 = A00(240, 12, 78);
                        string = sharedPreferences.getString(strA002, null);
                        if (TextUtils.isEmpty(string)) {
                            UUID uuidRandomUUID = UUID.randomUUID();
                            if (A01[6].charAt(4) == 'r') {
                                throw new RuntimeException();
                            }
                            String[] strArr = A01;
                            strArr[4] = "ACuTT9OHS44wxpENU";
                            strArr[2] = "rDA9ItLQjR7JTNF9w";
                            string = uuidRandomUUID.toString();
                            sharedPreferences.edit().putString(strA002, string).apply();
                        }
                        AdInternalSettings.sSettingsBundle.putString(strA00, string);
                    }
                    if (AdInternalSettings.getTestDevicesList().contains(string)) {
                        return true;
                    }
                    A03(string);
                    return false;
                }

                @Override // com.facebook.ads.internal.api.AdSettingsApi
                public final void turnOnDebugger() {
                    C1710Jr.A02();
                }
            };
        }
        AdSettingsApi adSettingsApi = A00;
        String[] strArr = A05;
        if (strArr[5].charAt(22) == strArr[3].charAt(22)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[7] = "zPBUQH";
        strArr2[7] = "zPBUQH";
        return adSettingsApi;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdSizeApi createAdSizeApi(int i) {
        return EnumC1701Ji.A00(i);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdViewApi createAdViewApi(Context context, String str, AdSize adSize, AdViewParentApi adViewParentApi, AdView adView) {
        return (AdViewApi) C13524m.A00(new C13554p(context, str, adSize, adViewParentApi, adView), AdViewApi.class);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdViewApi createAdViewApi(Context context, String str, String str2, AdViewParentApi adViewParentApi, AdView adView) throws Exception {
        try {
            return (AdViewApi) C13524m.A00(new C13554p(context, str, str2, adViewParentApi, adView), AdViewApi.class);
        } catch (C1698Je e2) {
            throw new Exception(e2.A01());
        }
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AudienceNetworkActivityApi createAudienceNetworkActivity(final AudienceNetworkActivity audienceNetworkActivity, final AudienceNetworkActivityApi audienceNetworkActivityApi) {
        final C13604u c13604u = new C13604u(audienceNetworkActivity, audienceNetworkActivityApi);
        return new AudienceNetworkActivityApi(audienceNetworkActivity, audienceNetworkActivityApi, c13604u) { // from class: com.facebook.ads.redexgen.X.4v
            public static byte[] A04;
            public static String[] A05;
            public boolean A00;
            public final AudienceNetworkActivity A01;
            public final AudienceNetworkActivityApi A02;
            public final C13604u A03;

            static {
                A02();
                A01();
            }

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 71);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A04 = new byte[]{12, 8, 7, 59, 42, 47, 43, 52, 41, 43, 20, 43, 58, 61, 53, 56, 49, 19, 44, 35, 54, 46, 35, 33, 50, 35, 34, -34, 35, 54, 33, 35, 46, 50, 39, 45, 44, -20, -70, -57, -72, -70, -68, -51, -62, -49, -62, -51, -46};
            }

            public static void A02() {
                A05 = new String[]{"kVVxbIvKBpFLpNMn249evg7U1t5DMrkR", "HNBIISUKPJt5lzvo", "tha", "s0U2IqORDUirQkjYFZUhzDbmHPDS66DK", "4XQ6Ra6x1CsG5mP0jlsGo4Oc8x5GsOh7", "mYQ1yQiLRLlGaSwEYEmmcgt3b9ncmm6M", "URRMMekVjcz4ECsO2XmiMnA4WEVCe5QQ", "lW2qNIOuJVr9bvm7hZsN45J1F7Bnv3JY"};
            }

            {
                this.A01 = audienceNetworkActivity;
                this.A02 = audienceNetworkActivityApi;
                this.A03 = c13604u;
            }

            private void A03(Throwable th) {
                this.A00 = true;
                this.A03.A0K();
                finish(8);
                C2026Wb c2026WbA0J = this.A03.A0J();
                if (c2026WbA0J != null) {
                    c2026WbA0J.A04().A8H(A00(38, 11, 18), C8Y.A04, new C8Z(th));
                    return;
                }
                String strA00 = A00(0, 17, 127);
                if (A05[3].charAt(1) != '0') {
                    throw new RuntimeException();
                }
                String[] strArr = A05;
                strArr[6] = "roakWe6n8CepWvGQKms2st32sM0MtJhe";
                strArr[6] = "roakWe6n8CepWvGQKms2st32sM0MtJhe";
                Log.e(strA00, A00(17, 21, 119), th);
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            public final void finish(int i) {
                this.A03.finish(i);
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            public final void onActivityResult(int i, int i2, Intent intent) {
                try {
                } catch (Throwable th) {
                    A03(th);
                }
                if (this.A00) {
                    this.A02.onActivityResult(i, i2, intent);
                } else {
                    this.A03.onActivityResult(i, i2, intent);
                    this.A02.onActivityResult(i, i2, intent);
                }
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            @SuppressLint({"CatchGeneralException"})
            public final void onBackPressed() {
                try {
                    if (this.A00) {
                        return;
                    }
                    this.A03.onBackPressed();
                } catch (Throwable th) {
                    String[] strArr = A05;
                    if (strArr[4].charAt(24) == strArr[5].charAt(24)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A05;
                    strArr2[7] = "o2QAVIvbVP3X0FiUaWNt1f6t7dHcTRBl";
                    strArr2[0] = "vmYtMIbIQwew4451MpW2UPrO9wIbxS87";
                    A03(th);
                }
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            @SuppressLint({"CatchGeneralException"})
            public final void onConfigurationChanged(Configuration configuration) {
                try {
                } catch (Throwable th) {
                    A03(th);
                }
                if (this.A00) {
                    this.A02.onConfigurationChanged(configuration);
                } else {
                    this.A03.onConfigurationChanged(configuration);
                    this.A02.onConfigurationChanged(configuration);
                }
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            @SuppressLint({"CatchGeneralException"})
            public final void onCreate(Bundle bundle) {
                this.A02.onCreate(bundle);
                try {
                    this.A03.onCreate(bundle);
                } catch (Throwable th) {
                    A03(th);
                }
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            @SuppressLint({"CatchGeneralException"})
            public final void onDestroy() {
                try {
                } catch (Throwable th) {
                    A03(th);
                }
                if (this.A00) {
                    this.A02.onDestroy();
                } else {
                    this.A03.onDestroy();
                    this.A02.onDestroy();
                }
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            @SuppressLint({"CatchGeneralException"})
            public final void onPause() {
                try {
                } catch (Throwable th) {
                    A03(th);
                }
                if (this.A00) {
                    this.A02.onPause();
                } else {
                    this.A03.onPause();
                    this.A02.onPause();
                }
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            @SuppressLint({"CatchGeneralException"})
            public final void onResume() {
                this.A02.onResume();
                try {
                    if (this.A00) {
                        return;
                    }
                    this.A03.onResume();
                } catch (Throwable th) {
                    A03(th);
                }
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            @SuppressLint({"CatchGeneralException"})
            public final void onSaveInstanceState(Bundle bundle) {
                this.A02.onSaveInstanceState(bundle);
                try {
                    if (this.A00) {
                        return;
                    }
                    this.A03.onSaveInstanceState(bundle);
                } catch (Throwable th) {
                    String[] strArr = A05;
                    if (strArr[4].charAt(24) == strArr[5].charAt(24)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A05;
                    strArr2[6] = "46sQaeWUXFUhhsRkoBzMlxezgaVtku4l";
                    strArr2[6] = "46sQaeWUXFUhhsRkoBzMlxezgaVtku4l";
                    A03(th);
                }
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            @SuppressLint({"CatchGeneralException"})
            public final void onStart() {
                this.A02.onStart();
                try {
                    if (this.A00) {
                        return;
                    }
                    this.A03.onStart();
                } catch (Throwable th) {
                    A03(th);
                }
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            @SuppressLint({"CatchGeneralException"})
            public final void onStop() {
                this.A02.onStop();
                try {
                    if (this.A00) {
                        return;
                    }
                    this.A03.onStop();
                } catch (Throwable th) {
                    A03(th);
                }
            }

            @Override // com.facebook.ads.internal.api.AudienceNetworkActivityApi
            @SuppressLint({"CatchGeneralException"})
            public final boolean onTouchEvent(MotionEvent motionEvent) {
                try {
                } catch (Throwable th) {
                    A03(th);
                }
                if (this.A00) {
                    return this.A02.onTouchEvent(motionEvent);
                }
                this.A03.onTouchEvent(motionEvent);
                return this.A02.onTouchEvent(motionEvent);
            }
        };
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AudienceNetworkAdsApi createAudienceNetworkAdsApi() {
        if (A01 == null) {
            A01 = new AudienceNetworkAdsApi() { // from class: com.facebook.ads.redexgen.X.4x
                @Override // com.facebook.ads.internal.api.AudienceNetworkAdsApi
                public final int getAdFormatForPlacement(String str) throws Throwable {
                    if (KL.A02(this)) {
                        return 0;
                    }
                    try {
                        return AnonymousClass94.A00(str).intValue();
                    } catch (Throwable th) {
                        KL.A00(th, this);
                        return 0;
                    }
                }

                @Override // com.facebook.ads.internal.api.AudienceNetworkAdsApi
                public final void initialize(Context context, @Nullable MultithreadedBundleWrapper multithreadedBundleWrapper, @Nullable AudienceNetworkAds.InitListener initListener) throws Throwable {
                    if (KL.A02(this)) {
                        return;
                    }
                    if (initListener == null) {
                        try {
                            initListener = new AudienceNetworkAds.InitListener() { // from class: com.facebook.ads.redexgen.X.4w
                                @Override // com.facebook.ads.AudienceNetworkAds.InitListener
                                public final void onInitialized(AudienceNetworkAds.InitResult initResult) {
                                }
                            };
                        } catch (Throwable th) {
                            KL.A00(th, this);
                            return;
                        }
                    }
                    DynamicLoaderFactory.makeLoader(context).getInitApi().initialize(context, multithreadedBundleWrapper, initListener, 1);
                }

                @Override // com.facebook.ads.internal.api.AudienceNetworkAdsApi
                public final boolean isInitialized() throws Throwable {
                    if (KL.A02(this)) {
                        return false;
                    }
                    try {
                        DynamicLoader dynamicLoader = DynamicLoaderFactory.getDynamicLoader();
                        if (dynamicLoader == null) {
                            return false;
                        }
                        return dynamicLoader.getInitApi().isInitialized();
                    } catch (Throwable th) {
                        KL.A00(th, this);
                        return false;
                    }
                }

                @Override // com.facebook.ads.internal.api.AudienceNetworkAdsApi
                public final void onContentProviderCreated(Context context) throws Throwable {
                    if (KL.A02(this)) {
                        return;
                    }
                    try {
                        DynamicLoaderFactory.makeLoader(context).getInitApi().onContentProviderCreated(context);
                    } catch (Throwable th) {
                        KL.A00(th, this);
                    }
                }
            };
        }
        return A01;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public BidderTokenProviderApi createBidderTokenProviderApi() {
        return getBidderTokenProviderApi();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public DefaultMediaViewVideoRendererApi createDefaultMediaViewVideoRendererApi() {
        return new C2204bJ();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public InterstitialAdApi createInterstitialAd(Context context, String str, InterstitialAd interstitialAd) {
        return (InterstitialAdApi) C13524m.A00(new AnonymousClass52(context, str, interstitialAd), InterstitialAdApi.class);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public MediaViewApi createMediaViewApi() {
        return new C1946Sz();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public MediaViewVideoRendererApi createMediaViewVideoRendererApi() {
        return new AnonymousClass55();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AnonymousClass56 createNativeAdApi(NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        return new AnonymousClass56(nativeAd, nativeAdBaseApi);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AnonymousClass56 createNativeAdApi(NativeAdBase nativeAdBase, NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        return new AnonymousClass56(nativeAdBase, nativeAd, nativeAdBaseApi);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdBaseApi createNativeAdBaseApi(Context context, String str) {
        return new C2213bT(context, str, C2213bT.A0I(), false);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdBaseApi createNativeAdBaseApi(NativeAdBaseApi nativeAdBaseApi) {
        return new C2213bT((C2213bT) nativeAdBaseApi);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdBase createNativeAdBaseFromBidPayload(Context context, String str, String str2) throws Exception {
        try {
            return C2213bT.A0A(context, str, str2);
        } catch (C1698Je e2) {
            throw new Exception(e2.A01());
        }
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    @Nullable
    public NativeAdImageApi createNativeAdImageApi(JSONObject jSONObject) {
        return JQ.A00(jSONObject);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdLayoutApi createNativeAdLayoutApi() {
        return new T0();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    @Nullable
    public JR createNativeAdRatingApi(JSONObject jSONObject) {
        return JR.A00(jSONObject);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdScrollViewApi createNativeAdScrollViewApi(NativeAdScrollView nativeAdScrollView, Context context, NativeAdsManager nativeAdsManager, @Nullable NativeAdScrollView.AdViewProvider adViewProvider, int i, @Nullable NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i2) {
        return new AnonymousClass57(nativeAdScrollView, context, nativeAdsManager, adViewProvider, i, type, nativeAdViewAttributes, i2);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdViewApi createNativeAdViewApi() {
        if (A02 == null) {
            A02 = new NativeAdViewApi() { // from class: com.facebook.ads.redexgen.X.58
                public static String[] A00;

                static {
                    A02();
                }

                public static void A02() {
                    A00 = new String[]{"4lhDSJeQx8ImoxNIMYyIsOpW4XJuQDgf", "lqCKp7vrLkXGNxXrvc6I3m7c", "zCZ5ygsfQGVhB3Y237HbJ1q9o76yX", "bq9vw23WcXUY1kk1BWsR1Wz1yPOY5uBm", "", "Hv6Nwq3QZSzEF0Nb8JqXMZqCHWYzLqUn", "tYYpfGiIizklMQ8", "46C5bVFnHWUcfGRcMiONp8ja9wt0MV54"};
                }

                public static View A00(C2026Wb c2026Wb, NativeAd nativeAd, NativeAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    if (nativeAdViewAttributes == null) {
                        nativeAdViewAttributes = new NativeAdViewAttributes();
                    }
                    JS js = (JS) nativeAdViewAttributes.getInternalAttributes();
                    C2213bT c2213bTA0J = C2213bT.A0J(nativeAd.getInternalNativeAd());
                    c2213bTA0J.A1P(JT.A00(type.getEnumCode()));
                    c2213bTA0J.A1O(js);
                    C1538Cp c1538Cp = new C1538Cp();
                    NativeAdLayout nativeAdLayout = new NativeAdLayout(c2026Wb, c1538Cp);
                    c1538Cp.A05(nativeAdLayout, c2026Wb, nativeAd, js);
                    nativeAdLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (LX.A01 * type.getHeight())));
                    return nativeAdLayout;
                }

                public static View A01(C2026Wb c2026Wb, NativeAd nativeAd, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    if (nativeAdViewAttributes == null) {
                        nativeAdViewAttributes = new NativeAdViewAttributes();
                    }
                    C2213bT c2213bTA0J = C2213bT.A0J(nativeAd.getInternalNativeAd());
                    JS js = (JS) nativeAdViewAttributes.getInternalAttributes();
                    c2213bTA0J.A1P(JT.A0B);
                    c2213bTA0J.A1O(js);
                    C1538Cp c1538Cp = new C1538Cp();
                    NativeAdLayout nativeAdLayout = new NativeAdLayout(c2026Wb, c1538Cp);
                    c1538Cp.A05(nativeAdLayout, c2026Wb, nativeAd, js);
                    return nativeAdLayout;
                }

                @Override // com.facebook.ads.internal.api.NativeAdViewApi
                public final View render(Context context, NativeAd nativeAd) {
                    return render(context, nativeAd, (NativeAdViewAttributes) null);
                }

                @Override // com.facebook.ads.internal.api.NativeAdViewApi
                public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type) {
                    return render(context, nativeAd, type, null);
                }

                @Override // com.facebook.ads.internal.api.NativeAdViewApi
                @SuppressLint({"CatchGeneralException"})
                public final View render(Context context, NativeAd nativeAd, NativeAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    try {
                        return A00(AnonymousClass50.A02(context), nativeAd, type, nativeAdViewAttributes);
                    } catch (Throwable th) {
                        C2026Wb c2026WbA02 = AnonymousClass50.A02(context);
                        if (A00[1].length() == 17) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A00;
                        strArr[0] = "2CJ6YuIajjVObDWBrmgwGQhi0qiA6kO3";
                        strArr[3] = "BzZMljeHsN6l5z4UR6G3olqVRWzg5ScF";
                        return M9.A00(c2026WbA02, th);
                    }
                }

                @Override // com.facebook.ads.internal.api.NativeAdViewApi
                @SuppressLint({"CatchGeneralException"})
                public final View render(Context context, NativeAd nativeAd, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    try {
                        return A01(AnonymousClass50.A02(context), nativeAd, nativeAdViewAttributes);
                    } catch (Throwable th) {
                        return M9.A00(AnonymousClass50.A02(context), th);
                    }
                }
            };
        }
        return A02;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdViewAttributesApi createNativeAdViewAttributesApi() {
        return new JS();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdViewTypeApi createNativeAdViewTypeApi(final int i) {
        return new NativeAdViewTypeApi(i) { // from class: com.facebook.ads.redexgen.X.59
            public final JT A00;

            {
                this.A00 = JT.A00(i);
            }

            @Override // com.facebook.ads.internal.api.NativeAdViewTypeApi
            public final int getHeight() {
                return this.A00.A03();
            }

            @Override // com.facebook.ads.internal.api.NativeAdViewTypeApi
            public final int getValue() {
                return this.A00.A04();
            }

            @Override // com.facebook.ads.internal.api.NativeAdViewTypeApi
            public final int getWidth() {
                return this.A00.A05();
            }
        };
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdsManagerApi createNativeAdsManagerApi(Context context, String str, int i) {
        return (NativeAdsManagerApi) C13524m.A00(new C5A(context, str, i), NativeAdsManagerApi.class);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeBannerAdApi createNativeBannerAdApi(NativeBannerAd nativeBannerAd, NativeAdBaseApi nativeAdBaseApi) {
        return new NativeBannerAdApi(nativeAdBaseApi) { // from class: com.facebook.ads.redexgen.X.5E
            public static byte[] A01;
            public static String[] A02;
            public final C2213bT A00;

            static {
                A02();
                A01();
            }

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 40);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A01() {
                A01 = new byte[]{43, 47, 44, 24, 9, 4, 8, 3, ci.l, 8, 35, 8, 25, 26, 2, 31, 6};
                String[] strArr = A02;
                if (strArr[3].length() == strArr[4].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A02;
                strArr2[1] = "g9VMJ7KVDiHxjzY4mov6XPU8OVFxG";
                strArr2[1] = "g9VMJ7KVDiHxjzY4mov6XPU8OVFxG";
            }

            public static void A02() {
                A02 = new String[]{"GHtEJsCBxF6ZG8G1CCL5RBmKmDCxDlHG", "8TFtHG5", "ovYsObbmHQ4MgJZYSDt7UbSE4I8Jd3xL", "OStrwIklzSQSoVp6y3SnTe0L", "CizBuXx6tKQSK5P8xVf5ORSYZ1", "CxGaKpsxgS6bhWDX5B71lG4aeRzyf4w9", "ZUquOnXGk9BCY4cqa0yz5KxW6oH5Pvvn", "wvrH4lpYI8UyLhNBrrW8XGK9bs66R2Pk"};
            }

            {
                this.A00 = C2213bT.A0J(nativeAdBaseApi);
                this.A00.A1Q(EnumC1702Jj.A04);
            }

            private void A03(ImageView imageView, NativeAdBaseApi nativeAdBaseApi2) {
                C2213bT c2213bTA0J = C2213bT.A0J(nativeAdBaseApi2);
                T7 t7 = new T7(this, imageView, c2213bTA0J);
                JQ jqA0z = c2213bTA0J.getAdIcon();
                if (jqA0z != null) {
                    Bitmap bitmapA0I = c2213bTA0J.A0w().A0I(jqA0z.getUrl());
                    C2026Wb c2026WbA02 = AnonymousClass50.A02(imageView.getContext());
                    if (bitmapA0I != null) {
                        Drawable drawableA05 = C2213bT.A05(c2026WbA02, bitmapA0I, c2213bTA0J.A1V(), c2213bTA0J.A15());
                        C2213bT.A0a(drawableA05, imageView);
                        imageView.post(new T8(this, c2213bTA0J, drawableA05));
                        return;
                    } else {
                        T7 t72 = null;
                        new C5B(c2026WbA02, t7, c2213bTA0J.A1V(), t72).execute(new C5D(jqA0z.getUrl(), c2213bTA0J.A15(), t72));
                        return;
                    }
                }
                InterfaceC2214bU interfaceC2214bUA10 = c2213bTA0J.A10();
                AdErrorType adErrorType = AdErrorType.NATIVE_AD_IS_NOT_LOADED;
                c2213bTA0J.A0x().A0A().A2d(-1L, adErrorType.getErrorCode(), adErrorType.getDefaultErrorMessage());
                if (interfaceC2214bUA10 != null) {
                    interfaceC2214bUA10.A9p(C1697Jd.A01(adErrorType));
                }
                Log.e(A00(0, 17, 69), adErrorType.getDefaultErrorMessage());
            }

            @Override // com.facebook.ads.internal.api.NativeBannerAdApi
            public final void registerViewForInteraction(View view, ImageView imageView) {
                registerViewForInteraction(view, imageView, (List<View>) null);
            }

            @Override // com.facebook.ads.internal.api.NativeBannerAdApi
            public final void registerViewForInteraction(View view, ImageView imageView, @Nullable List<View> list) {
                if (imageView != null) {
                    A03(imageView, this.A00);
                }
                if (list != null) {
                    this.A00.A1F(view, imageView, list);
                } else {
                    this.A00.A1E(view, imageView);
                }
            }

            @Override // com.facebook.ads.internal.api.NativeBannerAdApi
            public final void registerViewForInteraction(View view, MediaView mediaView) {
                registerViewForInteraction(view, mediaView, (List<View>) null);
            }

            @Override // com.facebook.ads.internal.api.NativeBannerAdApi
            public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable List<View> list) {
                if (mediaView != null) {
                    C1946Sz c1946Sz = (C1946Sz) mediaView.getMediaViewApi();
                    C2213bT c2213bT = this.A00;
                    String[] strArr = A02;
                    if (strArr[3].length() == strArr[4].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[2] = "js1TYeoyNOBe6miaJaLofzAsC6CsUfwk";
                    strArr2[0] = "W1hafLFlhK2580scubVHArACmFSZlS1F";
                    c1946Sz.A0J(c2213bT, true);
                }
                if (list != null) {
                    this.A00.A1H(view, mediaView, list);
                } else {
                    this.A00.A1G(view, mediaView);
                }
            }
        };
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeBannerAdViewApi createNativeBannerAdViewApi() {
        if (A03 == null) {
            A03 = new NativeBannerAdViewApi() { // from class: com.facebook.ads.redexgen.X.5F
                public static View A00(C2026Wb c2026Wb, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    if (nativeAdViewAttributes == null) {
                        nativeAdViewAttributes = new NativeAdViewAttributes();
                    }
                    C2213bT.A0J(nativeBannerAd.getInternalNativeAd()).A1P(JT.A00(type.getEnumCode()));
                    C1551Dc c1551Dc = new C1551Dc();
                    NativeAdLayout nativeAdLayout = new NativeAdLayout(c2026Wb, c1551Dc);
                    c1551Dc.A05(c2026Wb, nativeBannerAd, (JS) nativeAdViewAttributes.getInternalAttributes(), nativeAdLayout);
                    nativeAdLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, (int) (LX.A01 * type.getHeight())));
                    return nativeAdLayout;
                }

                @Override // com.facebook.ads.internal.api.NativeBannerAdViewApi
                public final View render(Context context, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type) {
                    return render(context, nativeBannerAd, type, null);
                }

                @Override // com.facebook.ads.internal.api.NativeBannerAdViewApi
                @SuppressLint({"CatchGeneralException"})
                public final View render(Context context, NativeBannerAd nativeBannerAd, NativeBannerAdView.Type type, @Nullable NativeAdViewAttributes nativeAdViewAttributes) {
                    try {
                        return A00(AnonymousClass50.A02(context), nativeBannerAd, type, nativeAdViewAttributes);
                    } catch (Throwable th) {
                        return M9.A00(AnonymousClass50.A02(context), th);
                    }
                }
            };
        }
        return A03;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeComponentTagApi createNativeComponentTagApi() {
        return new NativeComponentTagApi() { // from class: com.facebook.ads.redexgen.X.5G
            @Override // com.facebook.ads.internal.api.NativeComponentTagApi
            public final void tagView(View view, NativeAdBase.NativeComponentTag nativeComponentTag) {
                if (view != null && nativeComponentTag != null) {
                    L5.A03(view, nativeComponentTag);
                }
            }
        };
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public RewardedVideoAdApi createRewardedVideoAd(Context context, String str, RewardedVideoAd rewardedVideoAd) {
        return (RewardedVideoAdApi) C13524m.A00(new C5H(context, str, rewardedVideoAd), RewardedVideoAdApi.class);
    }

    public static C13765k getBidderTokenProviderApi() {
        if (A04 == null) {
            A04 = new C13765k();
        }
        return A04;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public InitApi getInitApi() {
        return A06;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public void maybeInitInternally(Context context) {
        C14538v.A0C(AnonymousClass50.A07(context));
    }
}
