package com.ironsource.adapters.facebook;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkAds;
import com.facebook.ads.BidderTokenProvider;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdExtendedListener;
import com.facebook.ads.RewardedVideoAdListener;
import com.facebook.ads.internal.settings.AdSdkVersion;
import com.ironsource.mediationsdk.AbstractC2311b;
import com.ironsource.mediationsdk.C2315d;
import com.ironsource.mediationsdk.C2374v;
import com.ironsource.mediationsdk.InterfaceC2344s;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.L;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.b;
import com.ironsource.mediationsdk.sdk.InterfaceC2349d;
import com.ironsource.mediationsdk.sdk.X;
import com.ironsource.mediationsdk.sdk.r;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.g;
import io.rong.imlib.common.RongLibConst;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FacebookAdapter extends AbstractC2311b implements InterfaceC2344s {
    public static int BN_FAILED_TO_RELOAD_ERROR_CODE = 103;
    private static final String GitHash = "de0e9d8d2";
    private static final String MEDIATION_SERVICE_NAME = "ironSource";
    private static final String VERSION = "4.3.21";
    private final String ALL_PLACEMENT_IDS;
    private final String FACEBOOK_BN_CACHE_FLAG;
    private final String FACEBOOK_IS_CACHE_FLAG;
    private final String FACEBOOK_RV_CACHE_FLAG;
    private final String PLACEMENT_ID;
    private ConcurrentHashMap<String, AdView> mBNPlacementToAdMap;
    private ConcurrentHashMap<String, InterfaceC2349d> mBNPlacementToListenerMap;
    private boolean mDidCallClosed;
    private ConcurrentHashMap<String, InterstitialAd> mISPlacementToAdMap;
    private ConcurrentHashMap<String, FacebookInterstitialAdListener> mISPlacementToFBListener;
    private ConcurrentHashMap<String, r> mISPlacementToListenerMap;
    private ConcurrentHashMap<String, Boolean> mInterstitialAdsAvailability;
    private CopyOnWriteArraySet<String> mProgrammaticPlacements;
    private ConcurrentHashMap<String, RewardedVideoAd> mRVPlacementToAdMap;
    private ConcurrentHashMap<String, FacebookRewardedVideoAdListener> mRVPlacementToFBListener;
    private ConcurrentHashMap<String, X> mRVPlacementToListenerMap;
    private ConcurrentHashMap<String, Boolean> mRvAdsAvailability;
    private static EnumSet<CacheFlag> mInterstitialFacebookFlags = EnumSet.allOf(CacheFlag.class);
    private static Boolean mDidInitSuccess = null;
    private static AtomicBoolean mDidCallInit = new AtomicBoolean(false);
    private static HashSet<InterfaceC2344s> initCallbackListeners = new HashSet<>();

    private class FBInitListener implements AudienceNetworkAds.InitListener {
        private FBInitListener() {
        }

        @Override // com.facebook.ads.AudienceNetworkAds.InitListener
        public void onInitialized(AudienceNetworkAds.InitResult initResult) {
            IronLog.ADAPTER_CALLBACK.verbose("init SDK is completed with status: " + initResult.isSuccess() + ", " + initResult.getMessage());
            if (initResult.isSuccess()) {
                Boolean unused = FacebookAdapter.mDidInitSuccess = true;
                Iterator it = FacebookAdapter.initCallbackListeners.iterator();
                while (it.hasNext()) {
                    ((InterfaceC2344s) it.next()).onNetworkInitCallbackSuccess();
                }
                FacebookAdapter.initCallbackListeners.clear();
                return;
            }
            Boolean unused2 = FacebookAdapter.mDidInitSuccess = false;
            Iterator it2 = FacebookAdapter.initCallbackListeners.iterator();
            while (it2.hasNext()) {
                ((InterfaceC2344s) it2.next()).onNetworkInitCallbackFailed(initResult.getMessage());
            }
            FacebookAdapter.initCallbackListeners.clear();
        }
    }

    private class FacebookInterstitialAdListener implements InterstitialAdExtendedListener {
        private r mListener;
        private String mPlacementId;

        FacebookInterstitialAdListener(r rVar, String str) {
            this.mPlacementId = str;
            this.mListener = rVar;
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            this.mListener.d();
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            this.mListener.a();
            FacebookAdapter.this.mInterstitialAdsAvailability.put(this.mPlacementId, true);
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, AdError adError) {
            IronLog.ADAPTER_CALLBACK.error("mPlacementId = " + this.mPlacementId);
            IronLog.ADAPTER_CALLBACK.error("error = " + adError.getErrorCode() + ", " + adError.getErrorMessage());
            this.mListener.a(new b(adError.getErrorCode(), adError.getErrorMessage() + ""));
            FacebookAdapter.this.mInterstitialAdsAvailability.put(this.mPlacementId, false);
        }

        @Override // com.facebook.ads.InterstitialAdExtendedListener
        public void onInterstitialActivityDestroyed() {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            if (FacebookAdapter.this.mDidCallClosed) {
                return;
            }
            this.mListener.c();
        }

        @Override // com.facebook.ads.InterstitialAdListener
        public void onInterstitialDismissed(Ad ad) {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            FacebookAdapter.this.mDidCallClosed = true;
            this.mListener.c();
        }

        @Override // com.facebook.ads.InterstitialAdListener
        public void onInterstitialDisplayed(Ad ad) {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            FacebookAdapter.this.mDidCallClosed = false;
            this.mListener.e();
            this.mListener.f();
        }

        @Override // com.facebook.ads.RewardedAdListener
        public void onRewardedAdCompleted() {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
        }

        @Override // com.facebook.ads.RewardedAdListener
        public void onRewardedAdServerFailed() {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
        }

        @Override // com.facebook.ads.RewardedAdListener
        public void onRewardedAdServerSucceeded() {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
        }
    }

    private class FacebookRewardedVideoAdListener implements RewardedVideoAdExtendedListener {
        private X mListener;
        private String mPlacementId;

        FacebookRewardedVideoAdListener(X x, String str) {
            this.mPlacementId = str;
            this.mListener = x;
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            this.mListener.k();
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            this.mListener.a(true);
            FacebookAdapter.this.mRvAdsAvailability.put(this.mPlacementId, true);
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, AdError adError) {
            IronLog.ADAPTER_CALLBACK.error("mPlacementId = " + this.mPlacementId);
            if (adError != null) {
                try {
                    b bVar = new b(adError.getErrorCode(), adError.getErrorMessage());
                    IronLog.ADAPTER_CALLBACK.error("error = " + bVar.a() + ", " + bVar.b());
                    this.mListener.e(bVar);
                } catch (Throwable unused) {
                }
            }
            this.mListener.a(false);
            FacebookAdapter.this.mRvAdsAvailability.put(this.mPlacementId, false);
        }

        @Override // com.facebook.ads.RewardedVideoAdListener, com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            FacebookAdapter.this.mDidCallClosed = false;
            this.mListener.onRewardedVideoAdOpened();
            this.mListener.g();
        }

        @Override // com.facebook.ads.RewardedVideoAdExtendedListener
        public void onRewardedVideoActivityDestroyed() {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            if (FacebookAdapter.this.mDidCallClosed) {
                return;
            }
            this.mListener.onRewardedVideoAdClosed();
        }

        @Override // com.facebook.ads.RewardedVideoAdListener
        public void onRewardedVideoClosed() {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            FacebookAdapter.this.mDidCallClosed = true;
            this.mListener.onRewardedVideoAdClosed();
        }

        @Override // com.facebook.ads.RewardedVideoAdListener
        public void onRewardedVideoCompleted() {
            IronLog.ADAPTER_CALLBACK.verbose("mPlacementId = " + this.mPlacementId);
            this.mListener.b();
            this.mListener.l();
        }
    }

    private FacebookAdapter(String str) {
        super(str);
        this.PLACEMENT_ID = "placementId";
        this.ALL_PLACEMENT_IDS = "placementIds";
        this.FACEBOOK_RV_CACHE_FLAG = "facebook_rv_cacheflag";
        this.FACEBOOK_IS_CACHE_FLAG = "facebook_is_cacheflag";
        this.FACEBOOK_BN_CACHE_FLAG = "facebook_bn_cacheflag";
        this.mRVPlacementToListenerMap = new ConcurrentHashMap<>();
        this.mISPlacementToListenerMap = new ConcurrentHashMap<>();
        this.mBNPlacementToListenerMap = new ConcurrentHashMap<>();
        this.mRVPlacementToAdMap = new ConcurrentHashMap<>();
        this.mISPlacementToAdMap = new ConcurrentHashMap<>();
        this.mBNPlacementToAdMap = new ConcurrentHashMap<>();
        this.mRVPlacementToFBListener = new ConcurrentHashMap<>();
        this.mISPlacementToFBListener = new ConcurrentHashMap<>();
        this.mRvAdsAvailability = new ConcurrentHashMap<>();
        this.mInterstitialAdsAvailability = new ConcurrentHashMap<>();
        this.mProgrammaticPlacements = new CopyOnWriteArraySet<>();
        AdSettings.setMediationService(getMediationServiceName());
        this.mDidCallClosed = false;
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public FrameLayout.LayoutParams calcLayoutParams(C2374v c2374v, Activity activity) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(C2315d.a(activity, c2374v.a().equals("RECTANGLE") ? 300 : (c2374v.a().equals("SMART") && C2315d.a(activity)) ? 728 : 320), -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.facebook.ads.AdSize calculateBannerSize(com.ironsource.mediationsdk.C2374v r7, boolean r8) {
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
            if (r0 == 0) goto L7f
            if (r0 == r5) goto L7c
            if (r0 == r4) goto L79
            if (r0 == r3) goto L71
            if (r0 == r2) goto L4e
            goto L6f
        L4e:
            int r8 = r7.b()
            r0 = 50
            if (r8 != r0) goto L59
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_50
            return r7
        L59:
            int r8 = r7.b()
            r0 = 90
            if (r8 != r0) goto L64
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_90
            return r7
        L64:
            int r7 = r7.b()
            r8 = 250(0xfa, float:3.5E-43)
            if (r7 != r8) goto L6f
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250
            return r7
        L6f:
            r7 = 0
            return r7
        L71:
            if (r8 == 0) goto L76
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_90
            goto L78
        L76:
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_50
        L78:
            return r7
        L79:
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250
            return r7
        L7c:
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_90
            return r7
        L7f:
            com.facebook.ads.AdSize r7 = com.facebook.ads.AdSize.BANNER_HEIGHT_50
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.facebook.FacebookAdapter.calculateBannerSize(com.ironsource.mediationsdk.v, boolean):com.facebook.ads.AdSize");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdListener createBannerAdListener(final FrameLayout.LayoutParams layoutParams) {
        return new AdListener() { // from class: com.ironsource.adapters.facebook.FacebookAdapter.8
            @Override // com.facebook.ads.AdListener
            public void onAdClicked(Ad ad) {
                IronLog.ADAPTER_CALLBACK.verbose("ad.getPlacementId() = " + ad.getPlacementId());
                if (FacebookAdapter.this.mBNPlacementToListenerMap.containsKey(ad.getPlacementId())) {
                    ((InterfaceC2349d) FacebookAdapter.this.mBNPlacementToListenerMap.get(ad.getPlacementId())).o();
                }
            }

            @Override // com.facebook.ads.AdListener
            public void onAdLoaded(Ad ad) {
                IronLog.ADAPTER_CALLBACK.verbose("ad.getPlacementId() = " + ad.getPlacementId());
                if (FacebookAdapter.this.mBNPlacementToListenerMap.containsKey(ad.getPlacementId()) && FacebookAdapter.this.mBNPlacementToAdMap.containsKey(ad.getPlacementId())) {
                    ((InterfaceC2349d) FacebookAdapter.this.mBNPlacementToListenerMap.get(ad.getPlacementId())).a((View) FacebookAdapter.this.mBNPlacementToAdMap.get(ad.getPlacementId()), layoutParams);
                }
            }

            @Override // com.facebook.ads.AdListener
            public void onError(Ad ad, AdError adError) {
                IronLog.ADAPTER_CALLBACK.error("error = " + adError.getErrorCode() + ", " + adError.getErrorMessage());
                if (FacebookAdapter.this.mBNPlacementToListenerMap.containsKey(ad.getPlacementId())) {
                    InterfaceC2349d interfaceC2349d = (InterfaceC2349d) FacebookAdapter.this.mBNPlacementToListenerMap.get(ad.getPlacementId());
                    int errorCode = adError.getErrorCode() == 1001 ? 606 : adError.getErrorCode();
                    if (adError.getErrorMessage() == null) {
                        interfaceC2349d.d(new b(errorCode, "Empty error string"));
                        return;
                    }
                    interfaceC2349d.d(new b(errorCode, adError.getErrorCode() + ":" + adError.getErrorMessage()));
                }
            }

            @Override // com.facebook.ads.AdListener
            public void onLoggingImpression(Ad ad) {
                IronLog.ADAPTER_CALLBACK.verbose("ad.getPlacementId() = " + ad.getPlacementId());
            }
        };
    }

    public static String getAdapterSDKVersion() {
        return AdSdkVersion.BUILD;
    }

    private Map<String, Object> getBiddingData() {
        if (!mDidInitSuccess.booleanValue()) {
            IronLog.INTERNAL.verbose("returning nil as token since init failed");
            return null;
        }
        String bidderToken = BidderTokenProvider.getBidderToken(c.c().a());
        if (TextUtils.isEmpty(bidderToken)) {
            bidderToken = "";
        }
        IronLog.ADAPTER_API.verbose("token = " + bidderToken);
        HashMap map = new HashMap();
        map.put(RongLibConst.KEY_TOKEN, bidderToken);
        return map;
    }

    private EnumSet<CacheFlag> getFacebookAllCacheFlags() {
        IronLog.ADAPTER_API.verbose("");
        return EnumSet.allOf(CacheFlag.class);
    }

    private CacheFlag getFacebookCacheFlag(String str) {
        IronLog.ADAPTER_API.verbose("value = " + str);
        return CacheFlag.valueOf(str.toUpperCase(Locale.ENGLISH));
    }

    public static L getIntegrationData(Activity activity) {
        L l = new L("Facebook", "4.3.21");
        l.f14676c = new String[]{"com.facebook.ads.AudienceNetworkActivity"};
        return l;
    }

    private String getMediationServiceName() {
        String str = String.format("%s_%s:%s", MEDIATION_SERVICE_NAME, "7.0.2", "4.3.21");
        IronLog.INTERNAL.verbose("mediationServiceName = " + str);
        return str;
    }

    private void initBannersInternal(JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placement = " + strOptString);
        if (TextUtils.isEmpty(strOptString)) {
            IronLog.INTERNAL.error("placement is empty");
            interfaceC2349d.h(g.a("Missing placementId", "Banner"));
            return;
        }
        this.mBNPlacementToListenerMap.put(strOptString, interfaceC2349d);
        initSdk(jSONObject);
        Boolean bool = mDidInitSuccess;
        if (bool != null) {
            if (bool.booleanValue()) {
                interfaceC2349d.onBannerInitSuccess();
            } else {
                interfaceC2349d.h(g.a("init failed", "Banner"));
            }
        }
    }

    private void initSdk(JSONObject jSONObject) {
        if (!mDidCallInit.compareAndSet(false, true)) {
            if (mDidInitSuccess == null) {
                initCallbackListeners.add(this);
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("");
        if (AudienceNetworkAds.isInitialized(c.c().a())) {
            IronLog.ADAPTER_API.verbose("SDK is already initialized");
            mDidInitSuccess = true;
            return;
        }
        String strOptString = jSONObject.optString("placementIds");
        initCallbackListeners.add(this);
        if (TextUtils.isEmpty(strOptString)) {
            IronLog.ADAPTER_API.verbose("Initialize Facebook without placement ids");
            AudienceNetworkAds.buildInitSettings(c.c().a()).withInitListener(new FBInitListener()).initialize();
            return;
        }
        List<String> listAsList = Arrays.asList(strOptString.split(","));
        IronLog.ADAPTER_API.verbose("Initialize Facebook with placement ids = " + listAsList.toString());
        AudienceNetworkAds.buildInitSettings(c.c().a()).withInitListener(new FBInitListener()).withPlacementIds(listAsList).initialize();
    }

    private void loadBannerInternal(final IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, final InterfaceC2349d interfaceC2349d, final String str) {
        final String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
        if (ironSourceBannerLayout == null) {
            IronLog.INTERNAL.error("banner is null");
            interfaceC2349d.d(g.c("banner layout is null"));
        } else {
            if (TextUtils.isEmpty(strOptString)) {
                IronLog.INTERNAL.error("placement is empty");
                interfaceC2349d.d(g.c("FacebookAdapter loadBanner placementId is empty"));
                return;
            }
            final AdSize adSizeCalculateBannerSize = calculateBannerSize(ironSourceBannerLayout.getSize(), C2315d.a(ironSourceBannerLayout.getActivity()));
            if (adSizeCalculateBannerSize != null) {
                postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.FacebookAdapter.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AdView adView = new AdView(ironSourceBannerLayout.getActivity(), strOptString, adSizeCalculateBannerSize);
                            AdListener adListenerCreateBannerAdListener = FacebookAdapter.this.createBannerAdListener(FacebookAdapter.this.calcLayoutParams(ironSourceBannerLayout.getSize(), ironSourceBannerLayout.getActivity()));
                            AdView.AdViewLoadConfigBuilder adViewLoadConfigBuilderBuildLoadAdConfig = adView.buildLoadAdConfig();
                            adViewLoadConfigBuilderBuildLoadAdConfig.withAdListener(adListenerCreateBannerAdListener);
                            if (str != null) {
                                adViewLoadConfigBuilderBuildLoadAdConfig.withBid(str);
                            }
                            FacebookAdapter.this.mBNPlacementToAdMap.put(strOptString, adView);
                            adView.loadAd(adViewLoadConfigBuilderBuildLoadAdConfig.build());
                        } catch (Exception e2) {
                            interfaceC2349d.d(g.c("FacebookAdapter loadBanner exception " + e2.getMessage()));
                        }
                    }
                });
            } else {
                IronLog.INTERNAL.error("adSize is null");
                interfaceC2349d.d(g.h("Facebook"));
            }
        }
    }

    private void loadRewardedVideo(String str) {
        loadRewardedVideo(str, null);
    }

    public static FacebookAdapter startAdapter(String str) {
        return new FacebookAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void destroyBanner(final JSONObject jSONObject) {
        IronLog.ADAPTER_API.verbose("placementId = " + jSONObject.optString("placementId"));
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.FacebookAdapter.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strOptString = jSONObject.optString("placementId");
                    if (FacebookAdapter.this.mBNPlacementToAdMap.containsKey(strOptString)) {
                        IronLog.ADAPTER_API.verbose("destroying old placement = " + strOptString);
                        ((AdView) FacebookAdapter.this.mBNPlacementToAdMap.get(strOptString)).destroy();
                        FacebookAdapter.this.mBNPlacementToAdMap.remove(strOptString);
                    }
                } catch (Exception e2) {
                    IronLog.INTERNAL.error("destroyBanner failed with an exception = " + e2);
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, X x) {
        String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placement = " + strOptString);
        loadRewardedVideo(strOptString);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getCoreSDKVersion() {
        return getAdapterSDKVersion();
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject) {
        return getBiddingData();
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getVersion() {
        return "4.3.21";
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        IronLog.ADAPTER_API.verbose("");
        initBannersInternal(jSONObject, interfaceC2349d);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initBanners(String str, String str2, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        IronLog.ADAPTER_API.verbose("");
        initBannersInternal(jSONObject, interfaceC2349d);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void initInterstitial(String str, String str2, JSONObject jSONObject, r rVar) {
        String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placement = " + strOptString);
        if (TextUtils.isEmpty(strOptString)) {
            IronLog.INTERNAL.error("placement is empty");
            rVar.g(g.a("Missing params: placementId", "Interstitial"));
            return;
        }
        FacebookInterstitialAdListener facebookInterstitialAdListener = new FacebookInterstitialAdListener(rVar, strOptString);
        this.mISPlacementToListenerMap.put(strOptString, rVar);
        this.mISPlacementToFBListener.put(strOptString, facebookInterstitialAdListener);
        initSdk(jSONObject);
        Boolean bool = mDidInitSuccess;
        if (bool != null) {
            if (bool.booleanValue()) {
                rVar.onInterstitialInitSuccess();
            } else {
                rVar.g(g.a("init failed", "Interstitial"));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, r rVar) {
        IronLog.ADAPTER_API.verbose("");
        initInterstitial(str, str2, jSONObject, rVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void initRewardedVideo(String str, String str2, JSONObject jSONObject, X x) {
        String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placement = " + strOptString);
        if (TextUtils.isEmpty(strOptString)) {
            IronLog.INTERNAL.error("placement is empty");
            x.a(false);
            return;
        }
        this.mRVPlacementToFBListener.put(strOptString, new FacebookRewardedVideoAdListener(x, strOptString));
        this.mRVPlacementToListenerMap.put(strOptString, x);
        initSdk(jSONObject);
        if (mDidInitSuccess != null) {
            IronLog.INTERNAL.verbose("mDidInitSuccess = " + mDidInitSuccess);
            if (mDidInitSuccess.booleanValue()) {
                loadRewardedVideo(strOptString);
            } else {
                x.a(false);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initRewardedVideoForBidding(String str, String str2, JSONObject jSONObject, X x) {
        String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placement = " + strOptString);
        if (TextUtils.isEmpty(strOptString)) {
            IronLog.INTERNAL.error("placement is empty");
            x.f(g.a("Missing placementId", "Rewarded Video"));
            return;
        }
        this.mRVPlacementToFBListener.put(strOptString, new FacebookRewardedVideoAdListener(x, strOptString));
        this.mRVPlacementToListenerMap.put(strOptString, x);
        this.mProgrammaticPlacements.add(strOptString);
        initSdk(jSONObject);
        if (mDidInitSuccess != null) {
            IronLog.INTERNAL.verbose("mDidInitSuccess = " + mDidInitSuccess);
            if (mDidInitSuccess.booleanValue()) {
                x.m();
            } else {
                x.f(g.a("FAN Sdk failed to initiate", "Rewarded Video"));
            }
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public boolean isInterstitialReady(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("placementId");
        return this.mInterstitialAdsAvailability.containsKey(strOptString) && this.mInterstitialAdsAvailability.get(strOptString).booleanValue();
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("placementId");
        return this.mRvAdsAvailability.containsKey(strOptString) && this.mRvAdsAvailability.get(strOptString).booleanValue();
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        loadBannerInternal(ironSourceBannerLayout, jSONObject, interfaceC2349d, null);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadBannerForBidding(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, InterfaceC2349d interfaceC2349d, String str) {
        loadBannerInternal(ironSourceBannerLayout, jSONObject, interfaceC2349d, str);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void loadInterstitial(JSONObject jSONObject, r rVar) {
        String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placement = " + strOptString);
        loadInterstitial(rVar, jSONObject, null);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadInterstitialForBidding(JSONObject jSONObject, r rVar, String str) {
        String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placement = " + strOptString);
        loadInterstitial(rVar, jSONObject, str);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadRewardedVideoForBidding(JSONObject jSONObject, X x, String str) {
        String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placement = " + strOptString);
        loadRewardedVideo(strOptString, str);
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2344s
    public void onNetworkInitCallbackFailed(String str) {
        Iterator<InterfaceC2349d> it = this.mBNPlacementToListenerMap.values().iterator();
        while (it.hasNext()) {
            it.next().h(new b(508, str));
        }
        Iterator<r> it2 = this.mISPlacementToListenerMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().g(g.a(str, "Interstitial"));
        }
        for (String str2 : this.mRVPlacementToListenerMap.keySet()) {
            if (this.mProgrammaticPlacements.contains(str2)) {
                this.mRVPlacementToListenerMap.get(str2).f(g.a(str, "Rewarded Video"));
            } else {
                this.mRVPlacementToListenerMap.get(str2).a(false);
            }
        }
    }

    public void onNetworkInitCallbackLoadSuccess(String str) {
    }

    @Override // com.ironsource.mediationsdk.InterfaceC2344s
    public void onNetworkInitCallbackSuccess() {
        Iterator<InterfaceC2349d> it = this.mBNPlacementToListenerMap.values().iterator();
        while (it.hasNext()) {
            it.next().onBannerInitSuccess();
        }
        Iterator<r> it2 = this.mISPlacementToListenerMap.values().iterator();
        while (it2.hasNext()) {
            it2.next().onInterstitialInitSuccess();
        }
        for (String str : this.mRVPlacementToListenerMap.keySet()) {
            if (this.mProgrammaticPlacements.contains(str)) {
                this.mRVPlacementToListenerMap.get(str).m();
            } else {
                loadRewardedVideo(str);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, final JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        IronLog.ADAPTER_API.verbose("placementId = " + jSONObject.optString("placementId"));
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.FacebookAdapter.6
            @Override // java.lang.Runnable
            public void run() {
                String strOptString = jSONObject.optString("placementId");
                if (FacebookAdapter.this.mBNPlacementToAdMap.containsKey(strOptString)) {
                    ((AdView) FacebookAdapter.this.mBNPlacementToAdMap.get(strOptString)).loadAd();
                    return;
                }
                if (FacebookAdapter.this.mBNPlacementToListenerMap.containsKey(strOptString)) {
                    ((InterfaceC2349d) FacebookAdapter.this.mBNPlacementToListenerMap.get(strOptString)).d(new b(FacebookAdapter.BN_FAILED_TO_RELOAD_ERROR_CODE, FacebookAdapter.this.getProviderName() + "reloadBanner missing banner " + strOptString));
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    @Override // com.ironsource.mediationsdk.AbstractC2311b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void setMetaData(java.lang.String r5, java.util.List<java.lang.String> r6) {
        /*
            r4 = this;
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.ADAPTER_API
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "key = "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = ", values = "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.verbose(r1)
            java.util.Locale r0 = java.util.Locale.ENGLISH
            java.lang.String r5 = r5.toLowerCase(r0)
            int r0 = r5.hashCode()
            r1 = -503171436(0xffffffffe2023694, float:-6.005024E20)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L4e
            r1 = 5585394(0x5539f2, float:7.826804E-39)
            if (r0 == r1) goto L44
            r1 = 71443084(0x442228c, float:2.2820454E-36)
            if (r0 == r1) goto L3a
            goto L58
        L3a:
            java.lang.String r0 = "facebook_rv_cacheflag"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L58
            r5 = 0
            goto L59
        L44:
            java.lang.String r0 = "facebook_is_cacheflag"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L58
            r5 = 2
            goto L59
        L4e:
            java.lang.String r0 = "facebook_bn_cacheflag"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L58
            r5 = 1
            goto L59
        L58:
            r5 = -1
        L59:
            if (r5 == 0) goto La6
            if (r5 == r3) goto La6
            if (r5 == r2) goto L60
            goto La6
        L60:
            java.util.EnumSet<com.facebook.ads.CacheFlag> r5 = com.ironsource.adapters.facebook.FacebookAdapter.mInterstitialFacebookFlags
            r5.clear()
            java.util.Iterator r5 = r6.iterator()     // Catch: java.lang.Exception -> L99
        L69:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Exception -> L99
            if (r6 == 0) goto La6
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Exception -> L99
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Exception -> L99
            com.facebook.ads.CacheFlag r6 = r4.getFacebookCacheFlag(r6)     // Catch: java.lang.Exception -> L99
            com.ironsource.mediationsdk.logger.IronLog r0 = com.ironsource.mediationsdk.logger.IronLog.ADAPTER_API     // Catch: java.lang.Exception -> L99
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L99
            r1.<init>()     // Catch: java.lang.Exception -> L99
            java.lang.String r2 = "flag = "
            r1.append(r2)     // Catch: java.lang.Exception -> L99
            java.lang.String r2 = r6.name()     // Catch: java.lang.Exception -> L99
            r1.append(r2)     // Catch: java.lang.Exception -> L99
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L99
            r0.verbose(r1)     // Catch: java.lang.Exception -> L99
            java.util.EnumSet<com.facebook.ads.CacheFlag> r0 = com.ironsource.adapters.facebook.FacebookAdapter.mInterstitialFacebookFlags     // Catch: java.lang.Exception -> L99
            r0.add(r6)     // Catch: java.lang.Exception -> L99
            goto L69
        L99:
            com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r6 = "flag is unknown or all, set all as default"
            r5.error(r6)
            java.util.EnumSet r5 = r4.getFacebookAllCacheFlags()
            com.ironsource.adapters.facebook.FacebookAdapter.mInterstitialFacebookFlags = r5
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.facebook.FacebookAdapter.setMetaData(java.lang.String, java.util.List):void");
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void showInterstitial(JSONObject jSONObject, final r rVar) {
        final String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
        this.mInterstitialAdsAvailability.put(strOptString, false);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.FacebookAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    InterstitialAd interstitialAd = (InterstitialAd) FacebookAdapter.this.mISPlacementToAdMap.get(strOptString);
                    if (interstitialAd != null && interstitialAd.isAdLoaded() && !interstitialAd.isAdInvalidated()) {
                        interstitialAd.show();
                        return;
                    }
                    if (interstitialAd != null) {
                        str = "interstitialAd.isAdInvalidated() = " + interstitialAd.isAdInvalidated();
                    } else {
                        str = "no ads to show";
                    }
                    b bVarB = g.b("Interstitial", str);
                    IronLog.INTERNAL.error("error = " + bVarB.b());
                    rVar.b(bVarB);
                } catch (Exception e2) {
                    IronLog.INTERNAL.error("ex.getMessage() = " + e2.getMessage());
                    rVar.b(g.b("Interstitial", e2.getMessage()));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void showRewardedVideo(JSONObject jSONObject, final X x) {
        final String strOptString = jSONObject.optString("placementId");
        IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
        this.mRvAdsAvailability.put(strOptString, false);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.FacebookAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                String str;
                try {
                    RewardedVideoAd rewardedVideoAd = (RewardedVideoAd) FacebookAdapter.this.mRVPlacementToAdMap.get(strOptString);
                    if (rewardedVideoAd == null || !rewardedVideoAd.isAdLoaded() || rewardedVideoAd.isAdInvalidated()) {
                        if (rewardedVideoAd != null) {
                            str = "videoAd.isAdInvalidated() = " + rewardedVideoAd.isAdInvalidated();
                        } else {
                            str = "no ads to show";
                        }
                        b bVarB = g.b("Rewarded Video", str);
                        IronLog.INTERNAL.error("error = " + bVarB.b());
                        x.c(bVarB);
                    } else {
                        rewardedVideoAd.show();
                    }
                } catch (Exception e2) {
                    IronLog.INTERNAL.error("ex.getMessage() = " + e2.getMessage());
                    x.c(g.b("Rewarded Video", e2.getMessage()));
                }
                x.a(false);
            }
        });
    }

    private void loadRewardedVideo(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            IronLog.INTERNAL.error("loadRewardedVideo: placementId is empty");
        } else {
            this.mRvAdsAvailability.put(str, false);
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.FacebookAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (FacebookAdapter.this.mRVPlacementToAdMap.containsKey(str)) {
                            IronLog.ADAPTER_API.verbose("destroying old placement = " + str);
                            ((RewardedVideoAd) FacebookAdapter.this.mRVPlacementToAdMap.get(str)).destroy();
                            FacebookAdapter.this.mRVPlacementToAdMap.remove(str);
                        }
                        RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(c.c().a(), str);
                        RewardedVideoAd.RewardedVideoAdLoadConfigBuilder rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig = rewardedVideoAd.buildLoadAdConfig();
                        rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.withAdListener((RewardedVideoAdListener) FacebookAdapter.this.mRVPlacementToFBListener.get(str));
                        if (str2 != null) {
                            rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.withBid(str2);
                        }
                        if (!TextUtils.isEmpty(FacebookAdapter.this.getDynamicUserId())) {
                            rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.withRewardData(new RewardData(FacebookAdapter.this.getDynamicUserId(), "1"));
                        }
                        rewardedVideoAd.loadAd(rewardedVideoAdLoadConfigBuilderBuildLoadAdConfig.build());
                        FacebookAdapter.this.mRVPlacementToAdMap.put(str, rewardedVideoAd);
                    } catch (Exception unused) {
                        if (FacebookAdapter.this.mRVPlacementToListenerMap.containsKey(str)) {
                            ((X) FacebookAdapter.this.mRVPlacementToListenerMap.get(str)).a(false);
                        }
                    }
                }
            });
        }
    }

    private void loadInterstitial(final r rVar, JSONObject jSONObject, final String str) {
        final String strOptString = jSONObject.optString("placementId");
        if (TextUtils.isEmpty(strOptString)) {
            IronLog.INTERNAL.error("placement is empty");
            rVar.a(g.c("Empty placementId"));
        } else {
            this.mInterstitialAdsAvailability.put(strOptString, false);
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.facebook.FacebookAdapter.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (FacebookAdapter.this.mISPlacementToAdMap.containsKey(strOptString)) {
                            IronLog.ADAPTER_API.verbose("destroying old placement = " + strOptString);
                            ((InterstitialAd) FacebookAdapter.this.mISPlacementToAdMap.get(strOptString)).destroy();
                            FacebookAdapter.this.mISPlacementToAdMap.remove(strOptString);
                        }
                        InterstitialAd interstitialAd = new InterstitialAd(c.c().a(), strOptString);
                        InterstitialAd.InterstitialAdLoadConfigBuilder interstitialAdLoadConfigBuilderBuildLoadAdConfig = interstitialAd.buildLoadAdConfig();
                        interstitialAdLoadConfigBuilderBuildLoadAdConfig.withCacheFlags(FacebookAdapter.mInterstitialFacebookFlags);
                        interstitialAdLoadConfigBuilderBuildLoadAdConfig.withAdListener((InterstitialAdListener) FacebookAdapter.this.mISPlacementToFBListener.get(strOptString));
                        if (str != null) {
                            interstitialAdLoadConfigBuilderBuildLoadAdConfig.withBid(str);
                        }
                        IronLog.ADAPTER_API.verbose("loading placement = " + strOptString + " with facebook flags = " + FacebookAdapter.mInterstitialFacebookFlags.toString());
                        interstitialAd.loadAd(interstitialAdLoadConfigBuilderBuildLoadAdConfig.build());
                        FacebookAdapter.this.mISPlacementToAdMap.put(strOptString, interstitialAd);
                    } catch (Exception e2) {
                        rVar.a(g.c(e2.getLocalizedMessage()));
                    }
                }
            });
        }
    }
}
