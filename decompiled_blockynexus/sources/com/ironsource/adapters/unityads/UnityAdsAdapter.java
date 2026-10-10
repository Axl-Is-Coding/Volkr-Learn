package com.ironsource.adapters.unityads;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.AbstractC2311b;
import com.ironsource.mediationsdk.C2315d;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.L;
import com.ironsource.mediationsdk.e.a;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.b;
import com.ironsource.mediationsdk.logger.c;
import com.ironsource.mediationsdk.sdk.InterfaceC2349d;
import com.ironsource.mediationsdk.sdk.X;
import com.ironsource.mediationsdk.sdk.r;
import com.ironsource.mediationsdk.utils.g;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.ads.metadata.MetaData;
import com.unity3d.ads.metadata.PlayerMetaData;
import com.unity3d.services.banners.BannerErrorCode;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class UnityAdsAdapter extends AbstractC2311b implements IUnityAdsListener, IUnityAdsExtendedListener, BannerView.IListener {
    private static final String GitHash = "838888bbb";
    private static final String VERSION = "4.3.2";
    private final String CONSENT_CCPA;
    private final String CONSENT_GDPR;
    private final String GAME_ID;
    private final String PLACEMENT_ID;
    private Activity mActivity;
    private Boolean mCCPACollectingUserData;
    private Boolean mConsentCollectingUserData;
    private AtomicBoolean mDidInit;
    private CopyOnWriteArraySet<String> mIsZoneReceivedFirstStatus;
    private final Object mUnityAdsStorageLock;
    private ConcurrentHashMap<String, IronSourceBannerLayout> mZoneIdToBannerLayout;
    private ConcurrentHashMap<String, BannerView> mZoneIdToBnAd;
    private ConcurrentHashMap<String, InterfaceC2349d> mZoneIdToBnListener;
    private ConcurrentHashMap<String, r> mZoneIdToIsListener;
    private ConcurrentHashMap<String, X> mZoneIdToRvListener;

    /* JADX INFO: renamed from: com.ironsource.adapters.unityads.UnityAdsAdapter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$FinishState;
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$PlacementState = new int[UnityAds.PlacementState.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError;

        static {
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$PlacementState[UnityAds.PlacementState.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$PlacementState[UnityAds.PlacementState.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$PlacementState[UnityAds.PlacementState.NO_FILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$PlacementState[UnityAds.PlacementState.NOT_AVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError = new int[UnityAds.UnityAdsError.values().length];
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAds.UnityAdsError.NOT_INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAds.UnityAdsError.INITIALIZE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAds.UnityAdsError.INVALID_ARGUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAds.UnityAdsError.VIDEO_PLAYER_ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAds.UnityAdsError.INIT_SANITY_CHECK_FAIL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAds.UnityAdsError.AD_BLOCKER_DETECTED.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAds.UnityAdsError.FILE_IO_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAds.UnityAdsError.DEVICE_ID_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAds.UnityAdsError.SHOW_ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[UnityAds.UnityAdsError.INTERNAL_ERROR.ordinal()] = 10;
            } catch (NoSuchFieldError unused14) {
            }
            $SwitchMap$com$unity3d$ads$UnityAds$FinishState = new int[UnityAds.FinishState.values().length];
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$FinishState[UnityAds.FinishState.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$FinishState[UnityAds.FinishState.SKIPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$unity3d$ads$UnityAds$FinishState[UnityAds.FinishState.COMPLETED.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private UnityAdsAdapter(String str) {
        super(str);
        this.GAME_ID = "sourceId";
        this.PLACEMENT_ID = "zoneId";
        this.CONSENT_GDPR = "gdpr.consent";
        this.CONSENT_CCPA = "privacy.consent";
        this.mConsentCollectingUserData = null;
        this.mCCPACollectingUserData = null;
        this.mUnityAdsStorageLock = new Object();
        this.mZoneIdToIsListener = new ConcurrentHashMap<>();
        this.mZoneIdToRvListener = new ConcurrentHashMap<>();
        this.mZoneIdToBnListener = new ConcurrentHashMap<>();
        this.mZoneIdToBnAd = new ConcurrentHashMap<>();
        this.mZoneIdToBannerLayout = new ConcurrentHashMap<>();
        this.mIsZoneReceivedFirstStatus = new CopyOnWriteArraySet<>();
        this.mDidInit = new AtomicBoolean(false);
    }

    private FrameLayout.LayoutParams createLayoutParams(UnityBannerSize unityBannerSize) {
        return new FrameLayout.LayoutParams(C2315d.a(this.mActivity, unityBannerSize.getWidth()), -2, 17);
    }

    public static String getAdapterSDKVersion() {
        try {
            return UnityAds.getVersion();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.unity3d.services.banners.UnityBannerSize getBannerSize(com.ironsource.mediationsdk.C2374v r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r5 = r5.a()
            int r0 = r5.hashCode()
            r1 = 72205083(0x44dc31b, float:2.4187222E-36)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L2e
            r1 = 79011241(0x4b59da9, float:4.2697683E-36)
            if (r0 == r1) goto L24
            r1 = 1951953708(0x7458732c, float:6.859571E31)
            if (r0 == r1) goto L1a
            goto L38
        L1a:
            java.lang.String r0 = "BANNER"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L38
            r5 = 0
            goto L39
        L24:
            java.lang.String r0 = "SMART"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L38
            r5 = 2
            goto L39
        L2e:
            java.lang.String r0 = "LARGE"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L38
            r5 = 1
            goto L39
        L38:
            r5 = -1
        L39:
            r0 = 50
            r1 = 320(0x140, float:4.48E-43)
            if (r5 == 0) goto L57
            if (r5 == r3) goto L57
            if (r5 == r2) goto L45
            r5 = 0
            return r5
        L45:
            if (r6 == 0) goto L51
            com.unity3d.services.banners.UnityBannerSize r5 = new com.unity3d.services.banners.UnityBannerSize
            r6 = 728(0x2d8, float:1.02E-42)
            r0 = 90
            r5.<init>(r6, r0)
            goto L56
        L51:
            com.unity3d.services.banners.UnityBannerSize r5 = new com.unity3d.services.banners.UnityBannerSize
            r5.<init>(r1, r0)
        L56:
            return r5
        L57:
            com.unity3d.services.banners.UnityBannerSize r5 = new com.unity3d.services.banners.UnityBannerSize
            r5.<init>(r1, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.unityads.UnityAdsAdapter.getBannerSize(com.ironsource.mediationsdk.v, boolean):com.unity3d.services.banners.UnityBannerSize");
    }

    private BannerView getBannerView(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        if (this.mZoneIdToBnAd.get(str) != null) {
            return this.mZoneIdToBnAd.get(str);
        }
        return new BannerView(this.mActivity, str, getBannerSize(ironSourceBannerLayout.getSize(), C2315d.a(this.mActivity)));
    }

    public static L getIntegrationData(Activity activity) {
        L l = new L("UnityAds", VERSION);
        l.f14676c = new String[]{"com.unity3d.services.ads.adunit.AdUnitActivity", "com.unity3d.services.ads.adunit.AdUnitTransparentActivity", "com.unity3d.services.ads.adunit.AdUnitTransparentSoftwareActivity", "com.unity3d.services.ads.adunit.AdUnitSoftwareActivity"};
        return l;
    }

    private void initSDK(Activity activity, String str) {
        logApi("initSDK");
        boolean zIsAdaptersDebugEnabled = false;
        if (this.mDidInit.compareAndSet(false, true)) {
            logApi("initiating unityAds SDK in manual mode");
            this.mActivity = activity;
            synchronized (this.mUnityAdsStorageLock) {
                MediationMetaData mediationMetaData = new MediationMetaData(activity);
                mediationMetaData.setName("IronSource");
                mediationMetaData.setVersion(VERSION);
                mediationMetaData.commit();
            }
            UnityAds.addListener(this);
            UnityAds.initialize(activity, str, false, true);
            try {
                zIsAdaptersDebugEnabled = isAdaptersDebugEnabled();
            } catch (NoSuchMethodError unused) {
            }
            UnityAds.setDebugMode(zIsAdaptersDebugEnabled);
            Boolean bool = this.mConsentCollectingUserData;
            if (bool != null) {
                setConsent(bool.booleanValue());
            }
            Boolean bool2 = this.mCCPACollectingUserData;
            if (bool2 != null) {
                setCCPAValue(bool2.booleanValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Boolean isBannerSizeSupported(com.ironsource.mediationsdk.C2374v r6) {
        /*
            r5 = this;
            java.lang.String r6 = r6.a()
            int r0 = r6.hashCode()
            r1 = 72205083(0x44dc31b, float:2.4187222E-36)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2f
            r1 = 79011241(0x4b59da9, float:4.2697683E-36)
            if (r0 == r1) goto L25
            r1 = 1951953708(0x7458732c, float:6.859571E31)
            if (r0 == r1) goto L1b
            goto L39
        L1b:
            java.lang.String r0 = "BANNER"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L39
            r6 = 0
            goto L3a
        L25:
            java.lang.String r0 = "SMART"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L39
            r6 = 2
            goto L3a
        L2f:
            java.lang.String r0 = "LARGE"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L39
            r6 = 1
            goto L3a
        L39:
            r6 = -1
        L3a:
            if (r6 == 0) goto L45
            if (r6 == r4) goto L45
            if (r6 == r3) goto L45
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r2)
            return r6
        L45:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.unityads.UnityAdsAdapter.isBannerSizeSupported(com.ironsource.mediationsdk.v):java.lang.Boolean");
    }

    private Boolean isPlacementReady(String str) {
        logApi(" isPlacementReady - placementId <" + str + ">, state = " + UnityAds.getPlacementState(str));
        return Boolean.valueOf(UnityAds.getPlacementState(str) == UnityAds.PlacementState.READY);
    }

    private void loadRewardedVideo(String str) {
        logApi("loadRewardedVideo placementId: <" + str + ">");
        UnityAds.load(str);
    }

    private void logApi(String str) {
        c.c().b(IronSourceLogger.IronSourceTag.ADAPTER_API, getProviderName() + " " + str, 0);
    }

    private void logCallback(String str) {
        c.c().b(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, getProviderName() + " " + str, 0);
    }

    private void logError(IronSourceLogger.IronSourceTag ironSourceTag, String str) {
        c.c().b(ironSourceTag, getProviderName() + " " + str, 3);
    }

    private void setCCPAValue(boolean z) {
        logApi("setCCPAValue: value = " + z);
        if (!this.mDidInit.get()) {
            this.mCCPACollectingUserData = Boolean.valueOf(z);
            return;
        }
        synchronized (this.mUnityAdsStorageLock) {
            MetaData metaData = new MetaData(this.mActivity);
            metaData.set("privacy.consent", Boolean.valueOf(z));
            metaData.commit();
        }
    }

    public static UnityAdsAdapter startAdapter(String str) {
        return new UnityAdsAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void destroyBanner(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("zoneId");
        logApi("placementId = " + strOptString);
        if (this.mZoneIdToBnAd.get(strOptString) != null) {
            this.mZoneIdToBnAd.get(strOptString).destroy();
            this.mZoneIdToBnAd.remove(strOptString);
        }
    }

    public void fetchRewardedVideo(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("zoneId");
        logApi("fetchRewardedVideo with placementId: <" + strOptString + "> state: " + UnityAds.getPlacementState(strOptString));
        X x = this.mZoneIdToRvListener.get(strOptString);
        if (x == null) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "fetchRewardedVideo: null listener");
            return;
        }
        loadRewardedVideo(strOptString);
        if (UnityAds.getPlacementState(strOptString) == UnityAds.PlacementState.READY) {
            x.a(true);
        } else if (UnityAds.getPlacementState(strOptString) == UnityAds.PlacementState.NO_FILL || UnityAds.getPlacementState(strOptString) == UnityAds.PlacementState.DISABLED) {
            x.a(false);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getCoreSDKVersion() {
        return UnityAds.getVersion();
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getVersion() {
        return VERSION;
    }

    public void initBanners(Activity activity, String str, String str2, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        logApi("initBanners");
        String strOptString = jSONObject.optString("sourceId");
        String strOptString2 = jSONObject.optString("zoneId");
        if (interfaceC2349d == null) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "initRewardedVideo: null listener");
            return;
        }
        if (TextUtils.isEmpty(strOptString)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "Missing params - placementId");
            interfaceC2349d.h(g.a("Missing params gameId", "Banner"));
            return;
        }
        if (TextUtils.isEmpty(strOptString2)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "Missing params - placementId");
            interfaceC2349d.h(g.a("Missing params placementId", "Banner"));
            return;
        }
        logApi("initBanners gameId: <" + strOptString + "> placementId: <" + strOptString2 + ">");
        this.mZoneIdToBnListener.put(strOptString2, interfaceC2349d);
        initSDK(activity, strOptString);
        interfaceC2349d.onBannerInitSuccess();
    }

    public void initInterstitial(Activity activity, String str, String str2, JSONObject jSONObject, r rVar) {
        logApi("initInterstitial");
        String strOptString = jSONObject.optString("sourceId");
        String strOptString2 = jSONObject.optString("zoneId");
        if (rVar == null) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "initInterstitial: null listener");
            return;
        }
        if (TextUtils.isEmpty(strOptString)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "Missing params - gameId");
            rVar.g(g.a("Missing params gameId", "Interstitial"));
            return;
        }
        if (TextUtils.isEmpty(strOptString2)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "Missing params - placementId");
            rVar.g(g.a("Missing params placementId", "Interstitial"));
            return;
        }
        logApi("initInterstitial gameId: <" + strOptString + "> placementId: <" + strOptString2 + ">");
        this.mZoneIdToIsListener.put(strOptString2, rVar);
        initSDK(activity, jSONObject.optString("sourceId"));
        rVar.onInterstitialInitSuccess();
    }

    public void initRewardedVideo(Activity activity, String str, String str2, JSONObject jSONObject, X x) {
        logApi("initRewardedVideo");
        String strOptString = jSONObject.optString("sourceId");
        String strOptString2 = jSONObject.optString("zoneId");
        if (x == null) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "initRewardedVideo: null listener");
            return;
        }
        if (TextUtils.isEmpty(strOptString)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "Missing params - gameId");
            x.a(false);
            return;
        }
        if (TextUtils.isEmpty(strOptString2)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "Missing params - placementId");
            x.a(false);
            return;
        }
        logApi("initRewardedVideo gameId: <" + strOptString + "> placementId: <" + strOptString2 + ">");
        this.mZoneIdToRvListener.put(strOptString2, x);
        if (this.mIsZoneReceivedFirstStatus.contains(strOptString2)) {
            x.a(UnityAds.isReady(strOptString2));
        }
        initSDK(activity, strOptString);
        loadRewardedVideo(strOptString2);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public boolean isInterstitialReady(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("zoneId");
        logApi(" isInterstitialReady placementId <" + strOptString + ">  state: " + UnityAds.getPlacementState(strOptString));
        return isPlacementReady(strOptString).booleanValue();
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        return UnityAds.isReady(jSONObject.optString("zoneId"));
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        String strOptString = jSONObject.optString("zoneId");
        if (TextUtils.isEmpty(strOptString)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "Missing params - placementId");
            interfaceC2349d.d(new b(505, "placementId is empty"));
            return;
        }
        if (ironSourceBannerLayout == null) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "loadBanner - banner is null");
            interfaceC2349d.d(g.e("banner is null"));
            return;
        }
        if (ironSourceBannerLayout.isDestroyed()) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "loadBanner - banner is destroyed");
            interfaceC2349d.d(g.e("banner is destroyed"));
            return;
        }
        if (!isBannerSizeSupported(ironSourceBannerLayout.getSize()).booleanValue()) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "loadBanner - banner size not supported");
            interfaceC2349d.d(new b(616, "banner size = " + ironSourceBannerLayout.getSize().a()));
            return;
        }
        logApi("loadBanner - placementId = " + strOptString);
        try {
            this.mZoneIdToBannerLayout.put(strOptString, ironSourceBannerLayout);
            BannerView bannerView = getBannerView(ironSourceBannerLayout, strOptString);
            this.mZoneIdToBnAd.put(strOptString, bannerView);
            bannerView.setListener(this);
            bannerView.load();
        } catch (Exception e2) {
            b bVarC = g.c("UnityAds loadBanner exception - " + e2.getMessage());
            logError(IronSourceLogger.IronSourceTag.ADAPTER_API, "error = " + bVarC);
            interfaceC2349d.d(bVarC);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void loadInterstitial(JSONObject jSONObject, r rVar) {
        String strOptString = jSONObject.optString("zoneId");
        logApi("loadInterstitial placementId <" + strOptString + ">: " + UnityAds.getPlacementState(strOptString));
        if (rVar == null) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "loadInterstitial: null listener for placement Id <" + strOptString + ">");
            return;
        }
        UnityAds.load(strOptString);
        if (isPlacementReady(strOptString).booleanValue()) {
            rVar.a();
            return;
        }
        if (UnityAds.getPlacementState(strOptString) == UnityAds.PlacementState.NO_FILL || UnityAds.getPlacementState(strOptString) == UnityAds.PlacementState.DISABLED) {
            rVar.a(g.c("Ad unavailable: " + UnityAds.getPlacementState(strOptString)));
        }
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerClick(BannerView bannerView) {
        logCallback("onBannerClick - placementId = " + bannerView.getPlacementId());
        InterfaceC2349d interfaceC2349d = this.mZoneIdToBnListener.get(bannerView.getPlacementId());
        if (interfaceC2349d != null) {
            interfaceC2349d.o();
        }
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        logCallback("onBannerFailedToLoad - placementId = " + bannerView.getPlacementId());
        InterfaceC2349d interfaceC2349d = this.mZoneIdToBnListener.get(bannerView.getPlacementId());
        if (interfaceC2349d != null) {
            String str = getProviderName() + " banner, onAdLoadFailed placementID <" + bannerView.getPlacementId() + "> with error: " + bannerErrorInfo.errorMessage;
            interfaceC2349d.d(bannerErrorInfo.errorCode == BannerErrorCode.NO_FILL ? new b(606, str) : g.c(str));
        }
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerLeftApplication(BannerView bannerView) {
        logCallback("onBannerLeftApplication - placementId = " + bannerView.getPlacementId());
        InterfaceC2349d interfaceC2349d = this.mZoneIdToBnListener.get(bannerView.getPlacementId());
        if (interfaceC2349d != null) {
            interfaceC2349d.j();
        }
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerLoaded(BannerView bannerView) {
        logCallback("onBannerLoaded - placementId = " + bannerView.getPlacementId());
        InterfaceC2349d interfaceC2349d = this.mZoneIdToBnListener.get(bannerView.getPlacementId());
        if (interfaceC2349d != null) {
            interfaceC2349d.a(bannerView, createLayoutParams(bannerView.getSize()));
        }
    }

    public void onResume(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.unity3d.ads.mediation.IUnityAdsExtendedListener
    public void onUnityAdsClick(String str) {
        logApi("onUnityAdsClick placementId: <" + str + ">");
        if (TextUtils.isEmpty(str)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "Missing params - placementId");
            return;
        }
        X x = this.mZoneIdToRvListener.get(str);
        r rVar = this.mZoneIdToIsListener.get(str);
        if (x != null) {
            x.k();
        } else if (rVar != null) {
            rVar.d();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0029. Please report as an issue. */
    @Override // com.unity3d.ads.IUnityAdsListener
    public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String str) {
        logApi("onUnityAdsError(errorType: " + unityAdsError + ", errorMessage: " + str + ")");
        switch (AnonymousClass1.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsError[unityAdsError.ordinal()]) {
        }
    }

    @Override // com.unity3d.ads.IUnityAdsListener
    public void onUnityAdsFinish(String str, UnityAds.FinishState finishState) {
        logApi("onUnityAdsFinish placementId: <" + str + "> finishState: " + finishState + ")");
        if (TextUtils.isEmpty(str)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "Missing params - placementId");
            return;
        }
        X x = this.mZoneIdToRvListener.get(str);
        r rVar = this.mZoneIdToIsListener.get(str);
        int i = AnonymousClass1.$SwitchMap$com$unity3d$ads$UnityAds$FinishState[finishState.ordinal()];
        boolean z = true;
        if (i == 1) {
            if (x != null) {
                x.c(g.a("finishState as " + finishState.name(), "Rewarded Video"));
            } else if (rVar != null) {
                rVar.b(g.a("finishState as " + finishState.name(), "Interstitial"));
            }
            z = false;
        } else if (i == 2) {
            if (x != null) {
                x.onRewardedVideoAdClosed();
            } else if (rVar != null) {
                rVar.c();
            }
            z = false;
        } else if (i == 3) {
            if (x != null) {
                x.b();
                x.l();
                x.onRewardedVideoAdClosed();
            } else if (rVar != null) {
                rVar.c();
            }
            z = false;
        } else {
            z = false;
        }
        if (z) {
            logApi("unknown placementId");
        }
    }

    @Override // com.unity3d.ads.mediation.IUnityAdsExtendedListener
    public void onUnityAdsPlacementStateChanged(String str, UnityAds.PlacementState placementState, UnityAds.PlacementState placementState2) {
        logApi("onUnityAdsPlacementStateChanged placementId: <" + str + "> from " + placementState + " to " + placementState2 + " is Ready: " + UnityAds.isReady(str));
        if (placementState2.equals(placementState)) {
            logApi("onUnityAdsPlacementStateChanged: newState is equals to oldState");
            return;
        }
        if (placementState2.equals(UnityAds.PlacementState.WAITING)) {
            logApi("onUnityAdsPlacementStateChanged: newState is equals to WAITING");
            return;
        }
        if (placementState2.equals(UnityAds.PlacementState.NOT_AVAILABLE) && placementState.equals(UnityAds.PlacementState.READY)) {
            logApi("onUnityAdsPlacementStateChanged: newState is equals to NOT_AVAILABLE and oldState is equals to READY, show ads have been called");
            X x = this.mZoneIdToRvListener.get(str);
            if (x != null) {
                x.a(false);
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "Missing params - placementId");
            return;
        }
        this.mIsZoneReceivedFirstStatus.add(str);
        X x2 = this.mZoneIdToRvListener.get(str);
        r rVar = this.mZoneIdToIsListener.get(str);
        int i = AnonymousClass1.$SwitchMap$com$unity3d$ads$UnityAds$PlacementState[placementState2.ordinal()];
        if (i == 1) {
            if (x2 != null) {
                try {
                    x2.n();
                } catch (Throwable unused) {
                }
                x2.a(true);
                return;
            } else {
                if (rVar != null) {
                    rVar.a();
                    return;
                }
                return;
            }
        }
        if (i == 2 || i == 3 || i == 4) {
            if (x2 != null) {
                try {
                    x2.e(g.c(str + " placement state: " + placementState2.toString()));
                } catch (Throwable unused2) {
                }
                x2.a(false);
                return;
            }
            if (rVar != null) {
                rVar.a(g.c(str + " placement state: " + placementState2.toString()));
            }
        }
    }

    @Override // com.unity3d.ads.IUnityAdsListener
    public void onUnityAdsReady(String str) {
        logApi("onUnityAdsReady placementId <" + str + ">");
    }

    @Override // com.unity3d.ads.IUnityAdsListener
    public void onUnityAdsStart(String str) {
        logApi("onUnityAdsStart placementId <" + str + ">");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        X x = this.mZoneIdToRvListener.get(str);
        if (x != null) {
            x.onRewardedVideoAdOpened();
            x.g();
            return;
        }
        r rVar = this.mZoneIdToIsListener.get(str);
        if (rVar != null) {
            rVar.e();
            rVar.f();
        }
    }

    public void reloadBanner(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("zoneId");
        if (TextUtils.isEmpty(strOptString)) {
            logError(IronSourceLogger.IronSourceTag.INTERNAL, "reloadBanner - placementId is empty");
            InterfaceC2349d interfaceC2349d = this.mZoneIdToBnListener.get(strOptString);
            if (interfaceC2349d != null) {
                interfaceC2349d.d(new b(505, "placementId is empty"));
                return;
            }
            return;
        }
        logApi("reloadBanner - placementId =" + strOptString);
        loadBanner(this.mZoneIdToBannerLayout.get(strOptString), jSONObject, this.mZoneIdToBnListener.get(strOptString));
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setConsent(boolean z) {
        logApi("setConsent = " + z);
        if (!this.mDidInit.get()) {
            this.mConsentCollectingUserData = Boolean.valueOf(z);
            return;
        }
        synchronized (this.mUnityAdsStorageLock) {
            MetaData metaData = new MetaData(this.mActivity);
            metaData.set("gdpr.consent", Boolean.valueOf(z));
            metaData.commit();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setMetaData(String str, String str2) {
        logApi("setMetaData: key = " + str + ", value = " + str2);
        if (a.a(str, str2)) {
            setCCPAValue(a.getCCPABooleanValue(str2));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public boolean shouldBindBannerViewOnReload() {
        return true;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void showInterstitial(JSONObject jSONObject, r rVar) {
        String strOptString = jSONObject.optString("zoneId");
        logApi("showInterstitial placementId <" + strOptString + ">");
        if (UnityAds.isReady(strOptString)) {
            UnityAds.show(this.mActivity, strOptString);
        } else if (rVar != null) {
            rVar.b(g.d("Interstitial"));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void showRewardedVideo(JSONObject jSONObject, X x) {
        String strOptString = jSONObject.optString("zoneId");
        logApi("showRewardedVideo placementId: <" + strOptString + ">");
        if (isPlacementReady(strOptString).booleanValue()) {
            if (!TextUtils.isEmpty(getDynamicUserId())) {
                synchronized (this.mUnityAdsStorageLock) {
                    PlayerMetaData playerMetaData = new PlayerMetaData(this.mActivity);
                    playerMetaData.setServerId(getDynamicUserId());
                    playerMetaData.commit();
                }
            }
            UnityAds.show(this.mActivity, strOptString);
        } else if (x != null) {
            x.c(g.d("Rewarded Video"));
        }
        if (x != null) {
            x.a(false);
        }
    }
}
