package com.ironsource.adapters.admob;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.ironsource.mediationsdk.AbstractC2311b;
import com.ironsource.mediationsdk.C2315d;
import com.ironsource.mediationsdk.InterfaceC2344s;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.L;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.e.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.b;
import com.ironsource.mediationsdk.sdk.InterfaceC2349d;
import com.ironsource.mediationsdk.sdk.X;
import com.ironsource.mediationsdk.sdk.r;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class AdMobAdapter extends AbstractC2311b implements InterfaceC2344s {
    public static int BN_FAILED_TO_RELOAD_ERROR_CODE = 103;
    private static final String CORE_SDK_VERSION = "19.4.0";
    private static final String GitHash = "f3b7a7f75";
    public static int IS_NOT_READY_ERROR_CODE = 104;
    public static int RV_NOT_READY_ERROR_CODE = 101;
    private static final String VERSION = "4.3.14";
    private final String ADMOB_TFCD_KEY;
    private final String ADMOB_TFUA_KEY;
    private final String AD_UNIT_ID;
    private final String APP_ID;
    private final String IRONSOURCE_REQUEST_AGENT;
    private ConcurrentHashMap<String, AdView> mAdIdToBannerAd;
    private ConcurrentHashMap<String, InterstitialAd> mAdIdToInterstitialAd;
    private ConcurrentHashMap<String, RewardedAd> mAdIdToRewardedVideoAd;
    private ConcurrentHashMap<String, InterfaceC2349d> mAdUnitIdToBannerListener;
    private ConcurrentHashMap<String, r> mAdUnitIdToInterstitialListener;
    private ConcurrentHashMap<String, X> mAdUnitIdToRewardedVideoListener;
    private ConcurrentHashMap<String, Boolean> mInterstitialAdsAvailability;
    private ConcurrentHashMap<String, Boolean> mRewardedVideoAdsAvailability;
    private static AtomicBoolean mDidInitSdk = new AtomicBoolean(false);
    private static Boolean mConsent = null;
    private static Boolean mCCPAValue = null;
    private static boolean mDidInitSdkFinished = false;
    private static HashSet<InterfaceC2344s> initCallbackListeners = new HashSet<>();

    private AdMobAdapter(String str) {
        super(str);
        this.IRONSOURCE_REQUEST_AGENT = "ironSource";
        this.AD_UNIT_ID = "adUnitId";
        this.APP_ID = "appId";
        this.ADMOB_TFCD_KEY = "admob_tfcd";
        this.ADMOB_TFUA_KEY = "admob_tfua";
        IronLog.INTERNAL.verbose("");
        this.mAllBannerSmashes = new CopyOnWriteArrayList<>();
        this.mAdIdToInterstitialAd = new ConcurrentHashMap<>();
        this.mInterstitialAdsAvailability = new ConcurrentHashMap<>();
        this.mAdIdToBannerAd = new ConcurrentHashMap<>();
        this.mAdUnitIdToRewardedVideoListener = new ConcurrentHashMap<>();
        this.mAdIdToRewardedVideoAd = new ConcurrentHashMap<>();
        this.mRewardedVideoAdsAvailability = new ConcurrentHashMap<>();
        this.mAdUnitIdToInterstitialListener = new ConcurrentHashMap<>();
        this.mAdUnitIdToBannerListener = new ConcurrentHashMap<>();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdRequest createAdRequest() {
        AdRequest.Builder builder = new AdRequest.Builder();
        builder.setRequestAgent("ironSource");
        if (mConsent != null || mCCPAValue != null) {
            Bundle bundle = new Bundle();
            Boolean bool = mConsent;
            if (bool != null && !bool.booleanValue()) {
                IronLog.ADAPTER_API.verbose("mConsent = " + mConsent);
                bundle.putString("npa", "1");
            }
            if (mCCPAValue != null) {
                IronLog.ADAPTER_API.verbose("mCCPAValue = " + mCCPAValue);
                bundle.putInt("rdp", mCCPAValue.booleanValue() ? 1 : 0);
            }
            builder.addNetworkExtrasBundle(com.google.ads.mediation.admob.AdMobAdapter.class, bundle);
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdListener createBannerAdListener(final AdView adView, final String str) {
        return new AdListener() { // from class: com.ironsource.adapters.admob.AdMobAdapter.15
            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                super.onAdClosed();
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(str)) {
                    ((InterfaceC2349d) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).p();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                String str2;
                b bVarC;
                super.onAdFailedToLoad(loadAdError);
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (loadAdError != null) {
                    str2 = loadAdError.getMessage() + "( " + loadAdError.getCode() + " ) ";
                    if (loadAdError.getCause() != null) {
                        str2 = str2 + " Caused by - " + loadAdError.getCause();
                    }
                    bVarC = loadAdError.getCode() == 3 ? new b(606, str2) : g.c(str2);
                } else {
                    str2 = "Banner failed to load (loadAdError is null)";
                    bVarC = g.c("Banner failed to load (loadAdError is null)");
                }
                IronLog.ADAPTER_CALLBACK.error(str2 + str2);
                if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(str)) {
                    ((InterfaceC2349d) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).d(bVarC);
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(str)) {
                    ((InterfaceC2349d) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).o();
                    ((InterfaceC2349d) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).j();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                super.onAdLoaded();
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(str)) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    ((InterfaceC2349d) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).a(adView, layoutParams);
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                super.onAdOpened();
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(str)) {
                    ((InterfaceC2349d) AdMobAdapter.this.mAdUnitIdToBannerListener.get(str)).q();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdListener createInterstitialAdListener(JSONObject jSONObject, final String str) {
        return new AdListener() { // from class: com.ironsource.adapters.admob.AdMobAdapter.10
            @Override // com.google.android.gms.ads.AdListener
            public void onAdClosed() {
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(str)) {
                    ((r) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(str)).c();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                int code;
                String str2;
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (loadAdError != null) {
                    code = loadAdError.getCode();
                    str2 = loadAdError.getMessage() + "( " + code + " ) ";
                    if (loadAdError.getCause() != null) {
                        str2 = str2 + " Caused by - " + loadAdError.getCause();
                    }
                } else {
                    code = 510;
                    str2 = "Interstitial failed to load (LoadAdError is null) Error code - 510";
                }
                IronLog.ADAPTER_CALLBACK.error("adapterError = " + str2);
                if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(str)) {
                    AdMobAdapter.this.mInterstitialAdsAvailability.put(str, false);
                    ((r) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(str)).a(new b(code, str2));
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLeftApplication() {
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(str)) {
                    ((r) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(str)).d();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdLoaded() {
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                AdMobAdapter.this.mInterstitialAdsAvailability.put(str, true);
                if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(str)) {
                    ((r) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(str)).a();
                }
            }

            @Override // com.google.android.gms.ads.AdListener
            public void onAdOpened() {
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(str)) {
                    ((r) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(str)).e();
                    ((r) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(str)).f();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RewardedAdCallback createRewardedAdCallback(final String str) {
        return new RewardedAdCallback() { // from class: com.ironsource.adapters.admob.AdMobAdapter.5
            @Override // com.google.android.gms.ads.rewarded.RewardedAdCallback
            public void onRewardedAdClosed() {
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    ((X) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).onRewardedVideoAdClosed();
                }
            }

            @Override // com.google.android.gms.ads.rewarded.RewardedAdCallback
            public void onRewardedAdFailedToShow(AdError adError) {
                int code;
                String str2;
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (adError != null) {
                    code = adError.getCode();
                    str2 = adError.getMessage() + "( " + code + " )";
                    if (adError.getCause() != null) {
                        str2 = str2 + " Caused by - " + adError.getCause();
                    }
                } else {
                    code = 510;
                    str2 = "Rewarded video failed to show (AdError is null) Error code - 510";
                }
                IronLog.ADAPTER_CALLBACK.error("adapterError = " + str2);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    ((X) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).c(new b(code, AdMobAdapter.this.getProviderName() + "onRewardedAdFailedToShow " + str + " " + str2));
                    ((X) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).a(false);
                }
            }

            @Override // com.google.android.gms.ads.rewarded.RewardedAdCallback
            public void onRewardedAdOpened() {
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    ((X) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).onRewardedVideoAdOpened();
                }
            }

            @Override // com.google.android.gms.ads.rewarded.RewardedAdCallback
            public void onUserEarnedReward(RewardItem rewardItem) {
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    ((X) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).l();
                }
            }
        };
    }

    private RewardedAdLoadCallback createRewardedAdLoadCallback(final String str) {
        return new RewardedAdLoadCallback() { // from class: com.ironsource.adapters.admob.AdMobAdapter.6
            @Override // com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
            public void onRewardedAdFailedToLoad(LoadAdError loadAdError) {
                int code;
                String str2;
                IronLog.ADAPTER_CALLBACK.error("adUnitId = " + str);
                if (loadAdError != null) {
                    code = loadAdError.getCode();
                    str2 = loadAdError.getMessage() + "( " + code + " )";
                    if (loadAdError.getCause() != null) {
                        str2 = str2 + "Caused by " + loadAdError.getCause();
                    }
                } else {
                    code = 510;
                    str2 = "Rewarded video failed to load (AdError is null) 510";
                }
                IronLog.ADAPTER_CALLBACK.error("adapterError = " + str2);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    AdMobAdapter.this.mRewardedVideoAdsAvailability.put(str, false);
                    ((X) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).a(false);
                    ((X) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).e(new b(code, str2));
                }
            }

            @Override // com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
            public void onRewardedAdLoaded() {
                AdMobAdapter.this.mRewardedVideoAdsAvailability.put(str, true);
                IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + str);
                if (AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.containsKey(str)) {
                    ((X) AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.get(str)).a(true);
                }
            }
        };
    }

    private int getAdMobCoppaValue(String str) {
        return a.a(str) ? 1 : 0;
    }

    private int getAdMobEuValue(String str) {
        return a.a(str) ? 1 : 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.android.gms.ads.AdSize getAdSize(com.ironsource.mediationsdk.C2374v r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = r7.a()
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -387072689: goto L38;
                case 72205083: goto L2e;
                case 79011241: goto L24;
                case 1951953708: goto L1a;
                case 1999208305: goto L10;
                default: goto Lf;
            }
        Lf:
            goto L42
        L10:
            java.lang.String r1 = "CUSTOM"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L42
            r0 = 4
            goto L43
        L1a:
            java.lang.String r1 = "BANNER"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L42
            r0 = 0
            goto L43
        L24:
            java.lang.String r1 = "SMART"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L42
            r0 = 3
            goto L43
        L2e:
            java.lang.String r1 = "LARGE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L42
            r0 = 1
            goto L43
        L38:
            java.lang.String r1 = "RECTANGLE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L42
            r0 = 2
            goto L43
        L42:
            r0 = -1
        L43:
            if (r0 == 0) goto L6b
            if (r0 == r5) goto L68
            if (r0 == r4) goto L65
            if (r0 == r3) goto L5d
            if (r0 == r2) goto L4f
            r7 = 0
            return r7
        L4f:
            com.google.android.gms.ads.AdSize r8 = new com.google.android.gms.ads.AdSize
            int r0 = r7.c()
            int r7 = r7.b()
            r8.<init>(r0, r7)
            return r8
        L5d:
            if (r8 == 0) goto L62
            com.google.android.gms.ads.AdSize r7 = com.google.android.gms.ads.AdSize.LEADERBOARD
            goto L64
        L62:
            com.google.android.gms.ads.AdSize r7 = com.google.android.gms.ads.AdSize.BANNER
        L64:
            return r7
        L65:
            com.google.android.gms.ads.AdSize r7 = com.google.android.gms.ads.AdSize.MEDIUM_RECTANGLE
            return r7
        L68:
            com.google.android.gms.ads.AdSize r7 = com.google.android.gms.ads.AdSize.LARGE_BANNER
            return r7
        L6b:
            com.google.android.gms.ads.AdSize r7 = com.google.android.gms.ads.AdSize.BANNER
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.admob.AdMobAdapter.getAdSize(com.ironsource.mediationsdk.v, boolean):com.google.android.gms.ads.AdSize");
    }

    public static L getIntegrationData(Activity activity) {
        L l = new L("AdMob", "4.3.14");
        l.f14676c = new String[]{AdActivity.CLASS_NAME};
        return l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public InterstitialAd getInterstitialAd(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("adUnitId");
        if (TextUtils.isEmpty(strOptString) || !this.mAdIdToInterstitialAd.containsKey(strOptString)) {
            return null;
        }
        return this.mAdIdToInterstitialAd.get(strOptString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSDK(String str) {
        initCallbackListeners.add(this);
        if (mDidInitSdk.compareAndSet(false, true)) {
            IronLog.ADAPTER_API.verbose("");
            MobileAds.initialize(c.c().a(), new OnInitializationCompleteListener() { // from class: com.ironsource.adapters.admob.AdMobAdapter.1
                @Override // com.google.android.gms.ads.initialization.OnInitializationCompleteListener
                public void onInitializationComplete(InitializationStatus initializationStatus) {
                    IronLog.ADAPTER_API.verbose("initializationStatus = READY");
                    boolean unused = AdMobAdapter.mDidInitSdkFinished = true;
                    Iterator it = AdMobAdapter.initCallbackListeners.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC2344s) it.next()).onNetworkInitCallbackSuccess();
                    }
                    AdMobAdapter.initCallbackListeners.clear();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadRewardedVideoAdFromAdmob(String str) {
        RewardedAd rewardedAd = new RewardedAd(c.c().a(), str);
        this.mAdIdToRewardedVideoAd.put(str, rewardedAd);
        this.mRewardedVideoAdsAvailability.put(str, false);
        AdRequest adRequestCreateAdRequest = createAdRequest();
        IronLog.ADAPTER_API.verbose("RVAdUnitId = " + str);
        rewardedAd.loadAd(adRequestCreateAdRequest, createRewardedAdLoadCallback(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void setAdMobMetaDataValue(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            com.google.android.gms.ads.RequestConfiguration r0 = com.google.android.gms.ads.MobileAds.getRequestConfiguration()
            int r1 = r5.hashCode()
            r2 = 1374613845(0x51eef155, float:1.2828139E11)
            r3 = 1
            if (r1 == r2) goto L1e
            r2 = 1374614400(0x51eef380, float:1.2828593E11)
            if (r1 == r2) goto L14
            goto L28
        L14:
            java.lang.String r1 = "admob_tfua"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L28
            r5 = 1
            goto L29
        L1e:
            java.lang.String r1 = "admob_tfcd"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L28
            r5 = 0
            goto L29
        L28:
            r5 = -1
        L29:
            if (r5 == 0) goto L54
            if (r5 == r3) goto L2e
            goto L79
        L2e:
            int r5 = r4.getAdMobEuValue(r6)
            com.ironsource.mediationsdk.logger.IronLog r6 = com.ironsource.mediationsdk.logger.IronLog.ADAPTER_API
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "euValue = "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r6.verbose(r1)
            com.google.android.gms.ads.RequestConfiguration$Builder r6 = r0.toBuilder()
            com.google.android.gms.ads.RequestConfiguration$Builder r5 = r6.setTagForUnderAgeOfConsent(r5)
            r5.build()
            goto L79
        L54:
            int r5 = r4.getAdMobCoppaValue(r6)
            com.ironsource.mediationsdk.logger.IronLog r6 = com.ironsource.mediationsdk.logger.IronLog.ADAPTER_API
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "coppaValue = "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            r6.verbose(r1)
            com.google.android.gms.ads.RequestConfiguration$Builder r6 = r0.toBuilder()
            com.google.android.gms.ads.RequestConfiguration$Builder r5 = r6.setTagForChildDirectedTreatment(r5)
            r5.build()
        L79:
            com.google.android.gms.ads.MobileAds.setRequestConfiguration(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.admob.AdMobAdapter.setAdMobMetaDataValue(java.lang.String, java.lang.String):void");
    }

    private void setCCPAValue(boolean z) {
        IronLog.ADAPTER_API.verbose("value = " + z);
        mCCPAValue = Boolean.valueOf(z);
    }

    public static AdMobAdapter startAdapter(String str) {
        return new AdMobAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void destroyBanner(final JSONObject jSONObject) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.14
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strOptString = jSONObject.optString("adUnitId");
                    IronLog.ADAPTER_API.verbose("adUnitId = " + strOptString);
                    if (AdMobAdapter.this.mAdIdToBannerAd.containsKey(strOptString)) {
                        ((AdView) AdMobAdapter.this.mAdIdToBannerAd.get(strOptString)).destroy();
                        AdMobAdapter.this.mAdIdToBannerAd.remove(strOptString);
                    }
                } catch (Exception e2) {
                    IronLog.ADAPTER_API.error("e = " + e2);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void fetchRewardedVideoForAutomaticLoad(final JSONObject jSONObject, X x) {
        IronLog.ADAPTER_API.verbose("");
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                AdMobAdapter.this.loadRewardedVideoAdFromAdmob(jSONObject.optString("adUnitId"));
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getCoreSDKVersion() {
        return "19.4.0";
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getVersion() {
        return "4.3.14";
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initBanners(String str, String str2, final JSONObject jSONObject, final InterfaceC2349d interfaceC2349d) {
        final String strOptString = jSONObject.optString("adUnitId");
        if (TextUtils.isEmpty(strOptString)) {
            interfaceC2349d.h(g.a("AdMobAdapter loadBanner adUnitId is empty", "Banner"));
            return;
        }
        IronLog.ADAPTER_API.verbose("adUnitId = " + strOptString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.11
            @Override // java.lang.Runnable
            public void run() {
                AdMobAdapter.this.mAdUnitIdToBannerListener.put(strOptString, interfaceC2349d);
                AdMobAdapter.this.initSDK(jSONObject.optString("appId"));
                if (AdMobAdapter.mDidInitSdkFinished) {
                    interfaceC2349d.onBannerInitSuccess();
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void initInterstitial(String str, String str2, final JSONObject jSONObject, final r rVar) {
        final String strOptString = jSONObject.optString("adUnitId");
        if (TextUtils.isEmpty(strOptString)) {
            rVar.g(g.a("Missing params: 'adUnitId' ", "Interstitial"));
            return;
        }
        IronLog.ADAPTER_API.verbose("adUnitId = " + strOptString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.7
            @Override // java.lang.Runnable
            public void run() {
                AdMobAdapter.this.mAdUnitIdToInterstitialListener.put(strOptString, rVar);
                AdMobAdapter.this.initSDK(jSONObject.optString("appId"));
                InterstitialAd interstitialAd = new InterstitialAd(c.c().a());
                interstitialAd.setAdUnitId(strOptString);
                AdMobAdapter.this.mAdIdToInterstitialAd.put(strOptString, interstitialAd);
                interstitialAd.setAdListener(AdMobAdapter.this.createInterstitialAdListener(jSONObject, strOptString));
                if (AdMobAdapter.mDidInitSdkFinished) {
                    rVar.onInterstitialInitSuccess();
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void initRewardedVideo(String str, String str2, final JSONObject jSONObject, final X x) {
        final String strOptString = jSONObject.optString("adUnitId");
        IronLog.ADAPTER_API.verbose("adUnitId = " + strOptString);
        if (TextUtils.isEmpty(strOptString)) {
            x.f(g.a("Missing params: 'adUnitId' ", "Rewarded Video"));
        } else {
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.2
                @Override // java.lang.Runnable
                public void run() {
                    AdMobAdapter.this.mAdUnitIdToRewardedVideoListener.put(strOptString, x);
                    AdMobAdapter.this.initSDK(jSONObject.optString("appId"));
                    if (AdMobAdapter.mDidInitSdkFinished) {
                        AdMobAdapter.this.loadRewardedVideoAdFromAdmob(strOptString);
                    }
                }
            });
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public final boolean isInterstitialReady(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("adUnitId");
        if (this.mInterstitialAdsAvailability.get(strOptString) != null) {
            return this.mInterstitialAdsAvailability.get(strOptString).booleanValue();
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("adUnitId");
        return this.mRewardedVideoAdsAvailability.containsKey(strOptString) && this.mRewardedVideoAdsAvailability.get(strOptString).booleanValue();
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadBanner(final IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, final InterfaceC2349d interfaceC2349d) {
        if (ironSourceBannerLayout == null) {
            IronLog.ADAPTER_API.error("banner == null");
            return;
        }
        final String strOptString = jSONObject.optString("adUnitId");
        final AdSize adSize = getAdSize(ironSourceBannerLayout.getSize(), C2315d.a(ironSourceBannerLayout.getActivity()));
        if (adSize == null) {
            interfaceC2349d.d(g.h("AdMob"));
            return;
        }
        IronLog.ADAPTER_API.verbose("adUnitId = " + strOptString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.12
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AdView adView = new AdView(ironSourceBannerLayout.getActivity());
                    adView.setAdSize(adSize);
                    adView.setAdUnitId(strOptString);
                    adView.setAdListener(AdMobAdapter.this.createBannerAdListener(adView, strOptString));
                    AdMobAdapter.this.mAdIdToBannerAd.put(strOptString, adView);
                    AdRequest adRequestCreateAdRequest = AdMobAdapter.this.createAdRequest();
                    IronLog.ADAPTER_API.verbose("loadAd");
                    adView.loadAd(adRequestCreateAdRequest);
                } catch (Exception e2) {
                    interfaceC2349d.d(g.c("AdMobAdapter loadBanner exception " + e2.getMessage()));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void loadInterstitial(final JSONObject jSONObject, final r rVar) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.8
            @Override // java.lang.Runnable
            public void run() {
                String strOptString = jSONObject.optString("adUnitId");
                IronLog.ADAPTER_API.verbose("adUnitId = " + strOptString);
                AdMobAdapter.this.mInterstitialAdsAvailability.put(strOptString, false);
                InterstitialAd interstitialAd = AdMobAdapter.this.getInterstitialAd(jSONObject);
                if (interstitialAd == null) {
                    r rVar2 = rVar;
                    if (rVar2 != null) {
                        rVar2.a(g.c("invalid adUnitId"));
                        return;
                    }
                    return;
                }
                if (interstitialAd.isLoaded()) {
                    if (AdMobAdapter.this.mAdUnitIdToInterstitialListener.containsKey(strOptString)) {
                        AdMobAdapter.this.mInterstitialAdsAvailability.put(strOptString, true);
                        ((r) AdMobAdapter.this.mAdUnitIdToInterstitialListener.get(strOptString)).a();
                        return;
                    }
                    return;
                }
                if (interstitialAd.isLoading()) {
                    return;
                }
                IronLog.ADAPTER_API.verbose("loadAd");
                interstitialAd.loadAd(AdMobAdapter.this.createAdRequest());
            }
        });
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2344s
    public void onNetworkInitCallbackFailed(String str) {
    }

    public void onNetworkInitCallbackLoadSuccess(String str) {
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2344s
    public void onNetworkInitCallbackSuccess() {
        Iterator<r> it = this.mAdUnitIdToInterstitialListener.values().iterator();
        while (it.hasNext()) {
            it.next().onInterstitialInitSuccess();
        }
        Iterator<InterfaceC2349d> it2 = this.mAdUnitIdToBannerListener.values().iterator();
        while (it2.hasNext()) {
            it2.next().onBannerInitSuccess();
        }
        for (String str : this.mAdUnitIdToRewardedVideoListener.keySet()) {
            this.mAdUnitIdToRewardedVideoListener.get(str);
            loadRewardedVideoAdFromAdmob(str);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, final JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        final String strOptString = jSONObject.optString("adUnitId");
        IronLog.ADAPTER_API.verbose("adUnitId = " + strOptString);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.13
            @Override // java.lang.Runnable
            public void run() {
                if (AdMobAdapter.this.mAdIdToBannerAd.get(jSONObject.optString("adUnitId")) != null) {
                    AdRequest adRequestCreateAdRequest = AdMobAdapter.this.createAdRequest();
                    AdView adView = (AdView) AdMobAdapter.this.mAdIdToBannerAd.get(jSONObject.optString("adUnitId"));
                    if (adView != null) {
                        adView.loadAd(adRequestCreateAdRequest);
                        return;
                    }
                    if (AdMobAdapter.this.mAdUnitIdToBannerListener.containsKey(strOptString)) {
                        ((InterfaceC2349d) AdMobAdapter.this.mAdUnitIdToBannerListener.get(strOptString)).d(new b(AdMobAdapter.BN_FAILED_TO_RELOAD_ERROR_CODE, AdMobAdapter.this.getProviderName() + "reloadBanner missing banner " + strOptString));
                    }
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void setAge(int i) {
        int i2 = i < 13 ? 1 : 0;
        RequestConfiguration requestConfigurationBuild = MobileAds.getRequestConfiguration().toBuilder().setTagForChildDirectedTreatment(i2).build();
        IronLog.ADAPTER_API.verbose("coppaValue = " + i2);
        MobileAds.setRequestConfiguration(requestConfigurationBuild);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setConsent(boolean z) {
        IronLog.ADAPTER_API.verbose("consent = " + z);
        mConsent = Boolean.valueOf(z);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setMetaData(String str, String str2) {
        IronLog.ADAPTER_API.verbose("key = " + str + ", value = " + str2);
        if (a.a(str, str2)) {
            setCCPAValue(a.a(str2));
        } else {
            setAdMobMetaDataValue(str.toLowerCase(Locale.ENGLISH), str2.toLowerCase(Locale.ENGLISH));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void showInterstitial(final JSONObject jSONObject, final r rVar) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.9
            @Override // java.lang.Runnable
            public void run() {
                InterstitialAd interstitialAd = AdMobAdapter.this.getInterstitialAd(jSONObject);
                String strOptString = jSONObject.optString("adUnitId");
                IronLog.ADAPTER_API.verbose("adUnitId = " + strOptString);
                if (interstitialAd != null && interstitialAd.isLoaded()) {
                    IronLog.ADAPTER_API.verbose("show");
                    interstitialAd.show();
                    AdMobAdapter.this.mInterstitialAdsAvailability.put(jSONObject.optString("adUnitId"), false);
                    return;
                }
                r rVar2 = rVar;
                if (rVar2 != null) {
                    rVar2.b(new b(AdMobAdapter.IS_NOT_READY_ERROR_CODE, AdMobAdapter.this.getProviderName() + "showInterstitial is not ready " + strOptString));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void showRewardedVideo(final JSONObject jSONObject, final X x) {
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.AdMobAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                String strOptString = jSONObject.optString("adUnitId");
                RewardedAd rewardedAd = (RewardedAd) AdMobAdapter.this.mAdIdToRewardedVideoAd.get(strOptString);
                IronLog.ADAPTER_API.verbose("adUnitId = " + strOptString);
                if (rewardedAd != null && rewardedAd.isLoaded()) {
                    AdMobAdapter.this.mRewardedVideoAdsAvailability.put(strOptString, false);
                    AdMobAdapter.this.mAdIdToRewardedVideoAd.remove(rewardedAd);
                    rewardedAd.show(c.c().b(), AdMobAdapter.this.createRewardedAdCallback(jSONObject.optString("adUnitId")));
                    x.a(false);
                    return;
                }
                x.c(new b(AdMobAdapter.RV_NOT_READY_ERROR_CODE, AdMobAdapter.this.getProviderName() + "showRewardedVideo rv not ready " + strOptString));
                x.a(false);
            }
        });
    }
}
