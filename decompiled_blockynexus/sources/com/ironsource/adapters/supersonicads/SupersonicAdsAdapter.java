package com.ironsource.adapters.supersonicads;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.FrameLayout;
import b.f.d.g.b;
import b.f.d.g.d;
import b.f.d.g.e;
import b.f.d.g.f;
import b.f.d.h;
import b.f.d.i;
import com.facebook.internal.ServerProtocol;
import com.ironsource.mediationsdk.AbstractC2311b;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.L;
import com.ironsource.mediationsdk.U;
import com.ironsource.mediationsdk.e.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterfaceC2349d;
import com.ironsource.mediationsdk.sdk.InterfaceC2357l;
import com.ironsource.mediationsdk.sdk.O;
import com.ironsource.mediationsdk.sdk.X;
import com.ironsource.mediationsdk.sdk.r;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.g;
import com.ironsource.mediationsdk.utils.j;
import com.ironsource.mediationsdk.utils.m;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import com.ironsource.sdk.data.SSAEnums$ProductType;
import com.sandboxol.center.config.VipSubscribeStatus;
import com.umeng.analytics.pro.au;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
class SupersonicAdsAdapter extends AbstractC2311b implements b, d, e, f, O, c.a {
    private static final String VERSION = "7.0.2";
    private final String AD_VISIBLE_EVENT_NAME;
    private final String APPLICATION_PRIVATE_KEY;
    private final String APPLICATION_USER_AGE_GROUP;
    private final String APPLICATION_USER_GENDER;
    private final String CAMPAIGN_ID;
    private final String CLIENT_SIDE_CALLBACKS;
    private final String CUSTOM_PARAM_PREFIX;
    private final String CUSTOM_SEGMENT;
    private final String DYNAMIC_CONTROLLER_CONFIG;
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE;
    private final String DYNAMIC_CONTROLLER_URL;
    private final String ITEM_COUNT;
    private final String ITEM_NAME;
    private final String ITEM_SIGNATURE;
    private final String LANGUAGE;
    private final String MAX_VIDEO_LENGTH;
    private final String OW_PLACEMENT_ID;
    private final String SDK_PLUGIN_TYPE;
    private final String SESSION_ID;
    private final String SUPERSONIC_ADS;
    private final String TIMESTAMP;
    private AtomicBoolean isRVInitiated;
    private boolean mConsent;
    private boolean mDidSetConsent;
    private boolean mIsAlreadyShowing;
    private boolean mIsRVAvailable;
    private ISNAdView mIsnAdView;
    private String mMediationSegment;
    private InterfaceC2357l mOfferwallListener;
    private i mSSAPublisher;
    private String mUserAgeGroup;
    private String mUserGender;
    private static AtomicBoolean mDidSetInitParams = new AtomicBoolean(false);
    private static AtomicBoolean mDidInitSdk = new AtomicBoolean(false);

    private SupersonicAdsAdapter(String str) {
        super(str);
        this.TIMESTAMP = "timestamp";
        this.ITEM_SIGNATURE = "itemSignature";
        this.SDK_PLUGIN_TYPE = "SDKPluginType";
        this.OW_PLACEMENT_ID = "placementId";
        this.SESSION_ID = "sessionid";
        this.mIsRVAvailable = false;
        this.SUPERSONIC_ADS = "SupersonicAds";
        this.DYNAMIC_CONTROLLER_URL = "controllerUrl";
        this.DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
        this.DYNAMIC_CONTROLLER_CONFIG = "controllerConfig";
        this.APPLICATION_USER_GENDER = "applicationUserGender";
        this.APPLICATION_USER_AGE_GROUP = "applicationUserAgeGroup";
        this.LANGUAGE = au.M;
        this.MAX_VIDEO_LENGTH = "maxVideoLength";
        this.CAMPAIGN_ID = "campaignId";
        this.CUSTOM_PARAM_PREFIX = "custom_";
        this.CUSTOM_SEGMENT = "custom_Segment";
        this.ITEM_NAME = "itemName";
        this.ITEM_COUNT = "itemCount";
        this.APPLICATION_PRIVATE_KEY = "privateKey";
        this.CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
        this.AD_VISIBLE_EVENT_NAME = "impressions";
        IronLog.INTERNAL.verbose("");
        this.isRVInitiated = new AtomicBoolean(false);
        c.c().a(this);
        this.mIsAlreadyShowing = false;
    }

    private void addItemNameCountSignature(HashMap<String, String> map, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("itemName");
            int iOptInt = jSONObject.optInt("itemCount", -1);
            String strOptString2 = jSONObject.optString("privateKey");
            boolean z = true;
            if (TextUtils.isEmpty(strOptString)) {
                z = false;
            } else {
                map.put("itemName", strOptString);
            }
            if (TextUtils.isEmpty(strOptString2)) {
                z = false;
            }
            if (iOptInt == -1) {
                z = false;
            } else {
                map.put("itemCount", String.valueOf(iOptInt));
            }
            if (z) {
                int iA = j.a();
                map.put("timestamp", String.valueOf(iA));
                map.put("itemSignature", createItemSig(iA, strOptString, iOptInt, strOptString2));
            }
        } catch (Exception e2) {
            IronLog.ADAPTER_API.error(" addItemNameCountSignature" + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyConsent(boolean z) {
        if (this.mSSAPublisher == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gdprConsentStatus", String.valueOf(z));
            jSONObject.put("demandSourceName", getProviderName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.mSSAPublisher.updateConsentInfo(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x007e A[PHI: r7
      0x007e: PHI (r7v1 int) = (r7v0 int), (r7v3 int) binds: [B:22:0x0048, B:40:0x007b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.ironsource.sdk.ISNAdView.ISNAdView createBanner(android.app.Activity r9, com.ironsource.mediationsdk.C2374v r10, com.ironsource.mediationsdk.sdk.InterfaceC2349d r11) {
        /*
            r8 = this;
            java.lang.String r0 = r10.a()
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -387072689: goto L37;
                case 72205083: goto L2d;
                case 79011241: goto L23;
                case 1951953708: goto L19;
                case 1999208305: goto Lf;
                default: goto Le;
            }
        Le:
            goto L41
        Lf:
            java.lang.String r1 = "CUSTOM"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L41
            r1 = 3
            goto L42
        L19:
            java.lang.String r1 = "BANNER"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L41
            r1 = 0
            goto L42
        L23:
            java.lang.String r1 = "SMART"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L41
            r1 = 2
            goto L42
        L2d:
            java.lang.String r1 = "LARGE"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L41
            r1 = 1
            goto L42
        L37:
            java.lang.String r1 = "RECTANGLE"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L41
            r1 = 4
            goto L42
        L41:
            r1 = -1
        L42:
            r5 = 90
            r6 = 50
            r7 = 320(0x140, float:4.48E-43)
            if (r1 == 0) goto L7e
            if (r1 == r4) goto L80
            if (r1 == r3) goto L71
            java.lang.String r3 = "SupersonicAds"
            r4 = 0
            if (r1 == r2) goto L5d
            if (r11 == 0) goto L5c
            com.ironsource.mediationsdk.logger.b r9 = com.ironsource.mediationsdk.utils.g.h(r3)
            r11.d(r9)
        L5c:
            return r4
        L5d:
            int r10 = r10.b()
            if (r10 == r6) goto L6f
            if (r10 == r5) goto L6f
            if (r11 == 0) goto L6e
            com.ironsource.mediationsdk.logger.b r9 = com.ironsource.mediationsdk.utils.g.h(r3)
            r11.d(r9)
        L6e:
            return r4
        L6f:
            r5 = r10
            goto L80
        L71:
            boolean r10 = com.ironsource.mediationsdk.C2315d.a(r9)
            if (r10 == 0) goto L7b
            r11 = 728(0x2d8, float:1.02E-42)
            r7 = 728(0x2d8, float:1.02E-42)
        L7b:
            if (r10 == 0) goto L7e
            goto L80
        L7e:
            r5 = 50
        L80:
            int r10 = com.ironsource.mediationsdk.C2315d.a(r9, r7)
            int r11 = com.ironsource.mediationsdk.C2315d.a(r9, r5)
            b.f.d.a r1 = new b.f.d.a
            r1.<init>(r10, r11, r0)
            b.f.d.i r10 = r8.mSSAPublisher
            com.ironsource.sdk.ISNAdView.ISNAdView r9 = r10.a(r9, r1)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.createBanner(android.app.Activity, com.ironsource.mediationsdk.v, com.ironsource.mediationsdk.sdk.d):com.ironsource.sdk.ISNAdView.ISNAdView");
    }

    private String createItemSig(int i, String str, int i2, String str2) {
        return j.a(i + str + i2 + str2);
    }

    private String createMinimumOfferCommissionSig(double d2, String str) {
        return j.a(d2 + str);
    }

    private String createUserCreationDateSig(String str, String str2, String str3) {
        return j.a(str + str2 + str3);
    }

    public static String getAdapterSDKVersion() {
        return com.ironsource.sdk.utils.i.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> getBannerExtraParams(JSONObject jSONObject) {
        return getGenenralExtraParams();
    }

    private HashMap<String, String> getGenenralExtraParams() {
        HashMap<String, String> map = new HashMap<>();
        if (!TextUtils.isEmpty(this.mUserAgeGroup)) {
            map.put("applicationUserAgeGroup", this.mUserAgeGroup);
        }
        if (!TextUtils.isEmpty(this.mUserGender)) {
            map.put("applicationUserGender", this.mUserGender);
        }
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            map.put("SDKPluginType", pluginType);
        }
        return map;
    }

    private HashMap<String, String> getInitParams() {
        HashMap<String, String> map = new HashMap<>();
        if (!TextUtils.isEmpty(this.mUserAgeGroup)) {
            map.put("applicationUserAgeGroup", this.mUserAgeGroup);
        }
        if (!TextUtils.isEmpty(this.mUserGender)) {
            map.put("applicationUserGender", this.mUserGender);
        }
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            map.put("SDKPluginType", pluginType);
        }
        if (!TextUtils.isEmpty(this.mMediationSegment)) {
            map.put("custom_Segment", this.mMediationSegment);
        }
        if (!TextUtils.isEmpty(U.e().k())) {
            map.put("sessionid", U.e().k());
        }
        return map;
    }

    public static L getIntegrationData(Activity activity) {
        L l = new L("SupersonicAds", VERSION);
        l.f14676c = new String[]{"com.ironsource.sdk.controller.ControllerActivity", "com.ironsource.sdk.controller.InterstitialActivity", "com.ironsource.sdk.controller.OpenUrlActivity"};
        return l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> getInterstitialExtraParams() {
        return getGenenralExtraParams();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> getOfferwallExtraParams(JSONObject jSONObject) {
        HashMap<String, String> genenralExtraParams = getGenenralExtraParams();
        String strOptString = jSONObject.optString(au.M);
        if (!TextUtils.isEmpty(strOptString)) {
            genenralExtraParams.put(au.M, strOptString);
        }
        genenralExtraParams.put("useClientSideCallbacks", String.valueOf(SupersonicConfig.getConfigObj().getClientSideCallbacks()));
        Map<String, String> offerwallCustomParams = SupersonicConfig.getConfigObj().getOfferwallCustomParams();
        if (offerwallCustomParams != null && !offerwallCustomParams.isEmpty()) {
            genenralExtraParams.putAll(offerwallCustomParams);
        }
        addItemNameCountSignature(genenralExtraParams, jSONObject);
        return genenralExtraParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap<String, String> getRewardedVideoExtraParams(JSONObject jSONObject) {
        HashMap<String, String> genenralExtraParams = getGenenralExtraParams();
        String strOptString = jSONObject.optString(au.M);
        if (!TextUtils.isEmpty(strOptString)) {
            genenralExtraParams.put(au.M, strOptString);
        }
        String strOptString2 = jSONObject.optString("maxVideoLength");
        if (!TextUtils.isEmpty(strOptString2)) {
            genenralExtraParams.put("maxVideoLength", strOptString2);
        }
        String strOptString3 = jSONObject.optString("campaignId");
        if (!TextUtils.isEmpty(strOptString3)) {
            genenralExtraParams.put("campaignId", strOptString3);
        }
        if (!TextUtils.isEmpty(this.mMediationSegment)) {
            genenralExtraParams.put("custom_Segment", this.mMediationSegment);
        }
        addItemNameCountSignature(genenralExtraParams, jSONObject);
        Map<String, String> rewardedVideoCustomParams = SupersonicConfig.getConfigObj().getRewardedVideoCustomParams();
        if (rewardedVideoCustomParams != null && !rewardedVideoCustomParams.isEmpty()) {
            genenralExtraParams.putAll(rewardedVideoCustomParams);
        }
        return genenralExtraParams;
    }

    private boolean isValidMetaData(String str, String str2) {
        if (str.equals("do_not_sell")) {
            return a.a(str, str2);
        }
        return true;
    }

    private void setParamsBeforeInit(JSONObject jSONObject) {
        if (mDidSetInitParams.compareAndSet(false, true)) {
            com.ironsource.sdk.utils.i.g(jSONObject.optString("controllerUrl"));
            int iOptInt = jSONObject.optInt("debugMode", 0);
            if (isAdaptersDebugEnabled()) {
                iOptInt = 3;
            }
            com.ironsource.sdk.utils.i.a(iOptInt);
            com.ironsource.sdk.utils.i.f(jSONObject.optString("controllerConfig", ""));
            IronLog.ADAPTER_API.verbose(getProviderName() + "setting controller url to  " + jSONObject.optString("controllerUrl"));
            IronLog.ADAPTER_API.verbose(getProviderName() + "setting controller config to  " + jSONObject.optString("controllerConfig"));
            IronLog.ADAPTER_API.verbose(getProviderName() + "setting debug mode to " + iOptInt);
        }
    }

    public static SupersonicAdsAdapter startAdapter(String str) {
        return new SupersonicAdsAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void addBannerListener(InterfaceC2349d interfaceC2349d) {
        this.mAllBannerSmashes.add(interfaceC2349d);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void destroyBanner(JSONObject jSONObject) {
        this.mIsAlreadyShowing = false;
        if (this.mIsnAdView != null) {
            IronLog.ADAPTER_API.verbose(getProviderName() + " mIsnAdView.performCleanup");
            this.mIsnAdView.performCleanup();
            this.mIsnAdView = null;
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void earlyInit(String str, String str2, JSONObject jSONObject) {
        j.c(getProviderName() + ": earlyInit");
        if (mDidInitSdk.compareAndSet(false, true)) {
            if (isAdaptersDebugEnabled()) {
                com.ironsource.sdk.utils.i.a(3);
            } else {
                com.ironsource.sdk.utils.i.a(jSONObject.optInt("debugMode", 0));
            }
            com.ironsource.sdk.utils.i.g(jSONObject.optString("controllerUrl"));
            IronLog.ADAPTER_API.verbose(getProviderName() + " IronSourceNetwork setting controller url to  " + jSONObject.optString("controllerUrl"));
            com.ironsource.sdk.utils.i.f(jSONObject.optString("controllerConfig", ""));
            IronLog.ADAPTER_API.verbose(getProviderName() + " IronSourceNetwork setting controller config to  " + jSONObject.optString("controllerConfig"));
            HashMap<String, String> initParams = getInitParams();
            b.f.d.d.a(c.c().b(), str, str2, initParams);
            IronLog.ADAPTER_API.verbose("initSDK with appKey=" + str + " userId=" + str2 + " parameters " + initParams);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, X x) {
        IronLog.ADAPTER_API.verbose(getProviderName());
        for (X x2 : this.mAllRewardedVideoSmashes) {
            if (x2 != null) {
                x2.a(this.mIsRVAvailable);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getCoreSDKVersion() {
        return com.ironsource.sdk.utils.i.h();
    }

    public void getOfferwallCredits() {
        if (this.mSSAPublisher == null) {
            IronLog.INTERNAL.error("Please call init before calling getOfferwallCredits");
            return;
        }
        String strF = U.e().f();
        String strG = U.e().g();
        IronLog.ADAPTER_API.verbose(getProviderName() + " mSSAPublisher.getOfferWallCredits userId=" + strG);
        this.mSSAPublisher.getOfferWallCredits(strF, strG, this);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getVersion() {
        return VERSION;
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initBanners(final String str, String str2, final JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        IronLog.ADAPTER_API.verbose(getProviderName());
        setParamsBeforeInit(jSONObject);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strB = j.b();
                    HashMap bannerExtraParams = SupersonicAdsAdapter.this.getBannerExtraParams(jSONObject);
                    SupersonicAdsAdapter.this.mSSAPublisher = h.a(c.c().b());
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                    }
                    IronLog.ADAPTER_API.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initBanner userId=" + strB);
                    SupersonicAdsAdapter.this.mSSAPublisher.a(str, strB, SupersonicAdsAdapter.this.getProviderName(), (Map<String, String>) bannerExtraParams, (b) SupersonicAdsAdapter.this);
                    SupersonicAdsAdapter.mDidInitSdk.set(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    SupersonicAdsAdapter.this.onBannerInitFailed(e2.getMessage());
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void initInterstitial(final String str, String str2, JSONObject jSONObject, r rVar) {
        setParamsBeforeInit(jSONObject);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strB = j.b();
                    SupersonicAdsAdapter.this.mSSAPublisher = h.a(c.c().b());
                    HashMap interstitialExtraParams = SupersonicAdsAdapter.this.getInterstitialExtraParams();
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                    }
                    IronLog.ADAPTER_API.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initInterstitial userId=" + strB);
                    SupersonicAdsAdapter.this.mSSAPublisher.a(str, strB, SupersonicAdsAdapter.this.getProviderName(), (Map<String, String>) interstitialExtraParams, (d) SupersonicAdsAdapter.this);
                    SupersonicAdsAdapter.mDidInitSdk.set(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    SupersonicAdsAdapter.this.onInterstitialInitFailed(e2.getMessage());
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.O
    public void initOfferwall(final String str, final String str2, final JSONObject jSONObject) {
        IronLog.ADAPTER_API.verbose(getProviderName() + " userId=" + str2);
        setParamsBeforeInit(jSONObject);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HashMap offerwallExtraParams = SupersonicAdsAdapter.this.getOfferwallExtraParams(jSONObject);
                    SupersonicAdsAdapter.this.mSSAPublisher = h.a(c.c().b());
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                    }
                    IronLog.ADAPTER_API.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initOfferWall");
                    SupersonicAdsAdapter.this.mSSAPublisher.initOfferWall(str, str2, offerwallExtraParams, SupersonicAdsAdapter.this);
                    SupersonicAdsAdapter.mDidInitSdk.set(true);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    IronLog.ADAPTER_API.error(SupersonicAdsAdapter.this.getProviderName() + ":initOfferwall(userId:" + str2 + ")" + e2);
                    SupersonicAdsAdapter.this.mOfferwallListener.a(false, g.a("Adapter initialization failure - " + SupersonicAdsAdapter.this.getProviderName() + " - " + e2.getMessage(), "Offerwall"));
                }
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void initRewardedVideo(final String str, String str2, final JSONObject jSONObject, X x) {
        if (this.isRVInitiated.compareAndSet(false, true)) {
            setParamsBeforeInit(jSONObject);
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String strB = j.b();
                        SupersonicAdsAdapter.this.mSSAPublisher = h.a(c.c().b());
                        HashMap rewardedVideoExtraParams = SupersonicAdsAdapter.this.getRewardedVideoExtraParams(jSONObject);
                        if (SupersonicAdsAdapter.this.mDidSetConsent) {
                            SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                        }
                        IronLog.ADAPTER_API.verbose(SupersonicAdsAdapter.this.getProviderName() + " mSSAPublisher.initRewardedVideo userId=" + strB);
                        SupersonicAdsAdapter.this.mSSAPublisher.a(str, strB, SupersonicAdsAdapter.this.getProviderName(), (Map<String, String>) rewardedVideoExtraParams, (f) SupersonicAdsAdapter.this);
                        SupersonicAdsAdapter.mDidInitSdk.set(true);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        SupersonicAdsAdapter.this.onRVInitFail("initRewardedVideo");
                    }
                }
            });
            return;
        }
        IronLog.ADAPTER_API.verbose(getProviderName() + " adapter already initiated");
        fetchRewardedVideoForAutomaticLoad(jSONObject, x);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public boolean isInterstitialReady(JSONObject jSONObject) {
        i iVar = this.mSSAPublisher;
        return iVar != null && iVar.isInterstitialAdAvailable(getProviderName());
    }

    public boolean isOfferwallAvailable() {
        return true;
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        return this.mIsRVAvailable;
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadBanner(final IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        try {
            if (this.mSSAPublisher == null) {
                IronLog.INTERNAL.error("Please call initBanner before calling loadBanner");
                for (InterfaceC2349d interfaceC2349d2 : this.mAllBannerSmashes) {
                    if (interfaceC2349d2 != null) {
                        interfaceC2349d2.d(g.c("Load was called before Init"));
                    }
                }
            }
            this.mActiveBannerSmash = interfaceC2349d;
            if (this.mIsnAdView != null && !this.mIsAlreadyShowing) {
                this.mIsnAdView.performCleanup();
                this.mIsnAdView = null;
            }
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("demandSourceName", getProviderName());
            jSONObject2.put("productType", SSAEnums$ProductType.Banner);
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!SupersonicAdsAdapter.this.mIsAlreadyShowing) {
                            SupersonicAdsAdapter.this.mIsnAdView = SupersonicAdsAdapter.this.createBanner(ironSourceBannerLayout.getActivity(), ironSourceBannerLayout.getSize(), ((AbstractC2311b) SupersonicAdsAdapter.this).mActiveBannerSmash);
                        }
                        if (SupersonicAdsAdapter.this.mIsnAdView != null) {
                            IronLog.ADAPTER_API.verbose("mIsnAdView.loadAd");
                            SupersonicAdsAdapter.this.mIsnAdView.loadAd(jSONObject2);
                        }
                    } catch (Exception e2) {
                        com.ironsource.mediationsdk.logger.b bVarC = g.c("Banner Load Fail, " + SupersonicAdsAdapter.this.getProviderName() + " - " + e2.getMessage());
                        if (((AbstractC2311b) SupersonicAdsAdapter.this).mActiveBannerSmash != null) {
                            ((AbstractC2311b) SupersonicAdsAdapter.this).mActiveBannerSmash.d(bVarC);
                        }
                    }
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void loadInterstitial(JSONObject jSONObject, r rVar) {
        if (this.mSSAPublisher == null) {
            IronLog.INTERNAL.error("Please call initInterstitial before calling loadInterstitial");
            for (r rVar2 : this.mAllInterstitialSmashes) {
                if (rVar2 != null) {
                    rVar2.a(g.c("Load was called before Init"));
                }
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("demandSourceName", getProviderName());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        IronLog.ADAPTER_API.verbose(getProviderName() + " mSSAPublisher.loadInterstitial");
        this.mSSAPublisher.c(jSONObject2);
    }

    @Override // b.f.d.g.b
    public void onBannerClick() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        InterfaceC2349d interfaceC2349d = this.mActiveBannerSmash;
        if (interfaceC2349d != null) {
            interfaceC2349d.o();
        }
    }

    @Override // b.f.d.g.b
    public void onBannerInitFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        for (InterfaceC2349d interfaceC2349d : this.mAllBannerSmashes) {
            if (interfaceC2349d != null) {
                interfaceC2349d.h(g.a(str, "Banner"));
            }
        }
    }

    @Override // b.f.d.g.b
    public void onBannerInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        for (InterfaceC2349d interfaceC2349d : this.mAllBannerSmashes) {
            if (interfaceC2349d != null) {
                interfaceC2349d.onBannerInitSuccess();
            }
        }
    }

    @Override // b.f.d.g.b
    public void onBannerLoadFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        for (InterfaceC2349d interfaceC2349d : this.mAllBannerSmashes) {
            if (interfaceC2349d != null) {
                interfaceC2349d.d(g.a(str, "Banner"));
            }
        }
    }

    @Override // b.f.d.g.b
    public void onBannerLoadSuccess() {
        ISNAdView iSNAdView;
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        this.mIsAlreadyShowing = true;
        for (InterfaceC2349d interfaceC2349d : this.mAllBannerSmashes) {
            if (interfaceC2349d != null && (iSNAdView = this.mIsnAdView) != null && iSNAdView.getAdViewSize() != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mIsnAdView.getAdViewSize().b(), this.mIsnAdView.getAdViewSize().a());
                layoutParams.gravity = 17;
                interfaceC2349d.a(this.mIsnAdView, layoutParams);
            }
        }
    }

    @Override // b.f.d.g.e
    public void onGetOWCreditsFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.d(g.b(str));
        }
    }

    @Override // b.f.d.g.d
    public void onInterstitialAdRewarded(String str, int i) {
    }

    @Override // b.f.d.g.d
    public void onInterstitialClick() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        r rVar = this.mActiveInterstitialSmash;
        if (rVar != null) {
            rVar.d();
        }
    }

    @Override // b.f.d.g.d
    public void onInterstitialClose() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        r rVar = this.mActiveInterstitialSmash;
        if (rVar != null) {
            rVar.c();
        }
    }

    @Override // b.f.d.g.d
    public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
        r rVar;
        if (jSONObject != null) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName() + " " + str + " extData: " + jSONObject.toString());
            if (TextUtils.isEmpty(str) || !"impressions".equals(str) || (rVar = this.mActiveInterstitialSmash) == null) {
                return;
            }
            rVar.h();
        }
    }

    @Override // b.f.d.g.d
    public void onInterstitialInitFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        for (r rVar : this.mAllInterstitialSmashes) {
            if (rVar != null) {
                rVar.g(g.a(str, "Interstitial"));
            }
        }
    }

    @Override // b.f.d.g.d
    public void onInterstitialInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        for (r rVar : this.mAllInterstitialSmashes) {
            if (rVar != null) {
                rVar.onInterstitialInitSuccess();
            }
        }
    }

    @Override // b.f.d.g.d
    public void onInterstitialLoadFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        for (r rVar : this.mAllInterstitialSmashes) {
            if (rVar != null) {
                rVar.a(g.c(str));
            }
        }
    }

    @Override // b.f.d.g.d
    public void onInterstitialLoadSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        for (r rVar : this.mAllInterstitialSmashes) {
            if (rVar != null) {
                rVar.a();
            }
        }
    }

    @Override // b.f.d.g.d
    public void onInterstitialOpen() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        r rVar = this.mActiveInterstitialSmash;
        if (rVar != null) {
            rVar.e();
        }
    }

    @Override // b.f.d.g.d
    public void onInterstitialShowFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        r rVar = this.mActiveInterstitialSmash;
        if (rVar != null) {
            rVar.b(g.b("Interstitial", str));
        }
    }

    @Override // b.f.d.g.d
    public void onInterstitialShowSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        r rVar = this.mActiveInterstitialSmash;
        if (rVar != null) {
            rVar.f();
        }
    }

    @Override // b.f.d.g.e
    public void onOWAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        InterfaceC2357l interfaceC2357l = this.mOfferwallListener;
        if (interfaceC2357l != null) {
            interfaceC2357l.i();
        }
    }

    @Override // b.f.d.g.e
    public boolean onOWAdCredited(int i, int i2, boolean z) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        InterfaceC2357l interfaceC2357l = this.mOfferwallListener;
        return interfaceC2357l != null && interfaceC2357l.a(i, i2, z);
    }

    @Override // b.f.d.g.e
    public void onOWGeneric(String str, String str2) {
    }

    @Override // b.f.d.g.e
    public void onOWShowFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.e(g.b(str));
        }
    }

    @Override // b.f.d.g.e
    public void onOWShowSuccess(String str) {
        if (TextUtils.isEmpty(str)) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        } else {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName() + ":onOWShowSuccess(placementId:" + str + ")");
        }
        InterfaceC2357l interfaceC2357l = this.mOfferwallListener;
        if (interfaceC2357l != null) {
            interfaceC2357l.h();
        }
    }

    @Override // b.f.d.g.e
    public void onOfferwallEventNotificationReceived(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        }
    }

    @Override // b.f.d.g.e
    public void onOfferwallInitFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.a(false, g.b(str));
        }
    }

    @Override // b.f.d.g.e
    public void onOfferwallInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        InterfaceC2357l interfaceC2357l = this.mOfferwallListener;
        if (interfaceC2357l != null) {
            interfaceC2357l.b(true);
        }
    }

    @Override // com.ironsource.mediationsdk.utils.c.a
    public void onPause(Activity activity) {
        if (this.mSSAPublisher != null) {
            IronLog.ADAPTER_API.verbose(getProviderName() + " mSSAPublisher.onPause");
            this.mSSAPublisher.onPause(activity);
        }
    }

    @Override // b.f.d.g.f
    public void onRVAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        X x = this.mActiveRewardedVideoSmash;
        if (x != null) {
            x.k();
        }
    }

    @Override // b.f.d.g.f
    public void onRVAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        X x = this.mActiveRewardedVideoSmash;
        if (x != null) {
            x.onRewardedVideoAdClosed();
        }
    }

    @Override // b.f.d.g.f
    public void onRVAdCredited(int i) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        X x = this.mActiveRewardedVideoSmash;
        if (x != null) {
            x.l();
        }
    }

    @Override // b.f.d.g.f
    public void onRVAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        X x = this.mActiveRewardedVideoSmash;
        if (x != null) {
            x.onRewardedVideoAdOpened();
        }
    }

    @Override // b.f.d.g.f
    public void onRVEventNotificationReceived(String str, JSONObject jSONObject) {
        X x;
        if (jSONObject != null) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName() + " " + str + " extData: " + jSONObject.toString());
        }
        if (TextUtils.isEmpty(str) || !"impressions".equals(str) || (x = this.mActiveRewardedVideoSmash) == null) {
            return;
        }
        x.i();
    }

    @Override // b.f.d.g.f
    public void onRVInitFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        for (X x : this.mAllRewardedVideoSmashes) {
            if (x != null) {
                x.a(false);
            }
        }
    }

    @Override // b.f.d.g.f
    public void onRVInitSuccess(com.ironsource.sdk.data.a aVar) {
        int i;
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        try {
            i = Integer.parseInt(aVar.b());
        } catch (NumberFormatException e2) {
            IronLog.INTERNAL.error("parseInt()" + e2);
            i = 0;
        }
        boolean z = i > 0;
        this.mIsRVAvailable = z;
        for (X x : this.mAllRewardedVideoSmashes) {
            if (x != null) {
                x.a(z);
            }
        }
    }

    @Override // b.f.d.g.f
    public void onRVNoMoreOffers() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        this.mIsRVAvailable = false;
        for (X x : this.mAllRewardedVideoSmashes) {
            if (x != null) {
                x.a(false);
            }
        }
    }

    @Override // b.f.d.g.f
    public void onRVShowFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        X x = this.mActiveRewardedVideoSmash;
        if (x != null) {
            x.c(new com.ironsource.mediationsdk.logger.b(509, str));
        }
    }

    @Override // com.ironsource.mediationsdk.utils.c.a
    public void onResume(Activity activity) {
        if (this.mSSAPublisher != null) {
            IronLog.ADAPTER_API.verbose(getProviderName() + " mSSAPublisher.onResume");
            this.mSSAPublisher.onResume(activity);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
        try {
            if (this.mIsnAdView != null) {
                IronLog.ADAPTER_API.verbose("mIsnAdView.loadAd");
                this.mIsnAdView.loadAd(jSONObject);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            IronLog.INTERNAL.error(getProviderName() + " reloadBanner Failed to reload banner ad");
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void removeBannerListener(InterfaceC2349d interfaceC2349d) {
        this.mAllBannerSmashes.remove(interfaceC2349d);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void setAge(int i) {
        if (i >= 13 && i <= 17) {
            this.mUserAgeGroup = "1";
            return;
        }
        if (i >= 18 && i <= 20) {
            this.mUserAgeGroup = "2";
            return;
        }
        if (i >= 21 && i <= 24) {
            this.mUserAgeGroup = "3";
            return;
        }
        if (i >= 25 && i <= 34) {
            this.mUserAgeGroup = VipSubscribeStatus.SUBSCRIPTION_PURCHASED;
            return;
        }
        if (i >= 35 && i <= 44) {
            this.mUserAgeGroup = VipSubscribeStatus.SUBSCRIPTION_ON_HOLD;
            return;
        }
        if (i >= 45 && i <= 54) {
            this.mUserAgeGroup = VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD;
            return;
        }
        if (i >= 55 && i <= 64) {
            this.mUserAgeGroup = VipSubscribeStatus.SUBSCRIPTION_RESTARTED;
        } else if (i <= 65 || i > 120) {
            this.mUserAgeGroup = "0";
        } else {
            this.mUserAgeGroup = VipSubscribeStatus.SUBSCRIPTION_PRICE_CHANGE_CONFIRMED;
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(": setConsent (");
        sb.append(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        sb.append(")");
        ironLog.verbose(sb.toString());
        this.mDidSetConsent = true;
        this.mConsent = z;
        applyConsent(z);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void setGender(String str) {
        this.mUserGender = str;
    }

    @Override // com.ironsource.mediationsdk.sdk.O
    public void setInternalOfferwallListener(InterfaceC2357l interfaceC2357l) {
        this.mOfferwallListener = interfaceC2357l;
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void setMediationSegment(String str) {
        this.mMediationSegment = str;
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setMediationState(AbstractSmash.MEDIATION_STATE mediation_state, String str) {
        if (this.mSSAPublisher != null) {
            IronLog.ADAPTER_API.verbose(getProviderName() + ": setMediationState(" + str + " , " + getProviderName() + " , " + mediation_state.getValue() + ")");
            this.mSSAPublisher.a(str, getProviderName(), mediation_state.getValue());
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setMetaData(String str, String str2) {
        if (mDidInitSdk.get()) {
            return;
        }
        IronLog.ADAPTER_API.verbose("key=" + str + ", value=" + str2);
        if (!isValidMetaData(str, str2)) {
            IronLog.ADAPTER_API.verbose("not valid");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, str2);
            b.f.d.d.c(jSONObject);
        } catch (JSONException e2) {
            IronLog.ADAPTER_API.error("error - " + e2);
            e2.printStackTrace();
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void showInterstitial(JSONObject jSONObject, r rVar) {
        this.mActiveInterstitialSmash = rVar;
        if (this.mSSAPublisher == null) {
            IronLog.INTERNAL.error("Please call loadInterstitialForBidding before calling showInterstitial");
            r rVar2 = this.mActiveInterstitialSmash;
            if (rVar2 != null) {
                rVar2.b(g.d("Interstitial"));
                return;
            }
            return;
        }
        int iA = m.a().a(2);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("demandSourceName", getProviderName());
            jSONObject2.put("sessionDepth", iA);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        IronLog.ADAPTER_API.verbose(getProviderName() + " mSSAPublisher.showInterstitial");
        this.mSSAPublisher.b(jSONObject2);
    }

    public void showOfferwall(String str, JSONObject jSONObject) {
        HashMap<String, String> offerwallExtraParams = getOfferwallExtraParams(jSONObject);
        if (offerwallExtraParams != null) {
            offerwallExtraParams.put("placementId", str);
        }
        if (this.mSSAPublisher == null) {
            IronLog.INTERNAL.error("Please call init before calling showOfferwall");
            return;
        }
        IronLog.ADAPTER_API.verbose(getProviderName() + " mSSAPublisher.showOfferWall");
        this.mSSAPublisher.showOfferWall(offerwallExtraParams);
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void showRewardedVideo(JSONObject jSONObject, X x) {
        this.mActiveRewardedVideoSmash = x;
        if (this.mSSAPublisher == null) {
            this.mIsRVAvailable = false;
            X x2 = this.mActiveRewardedVideoSmash;
            if (x2 != null) {
                x2.c(g.d("Rewarded Video"));
            }
            for (X x3 : this.mAllRewardedVideoSmashes) {
                if (x3 != null) {
                    x3.a(false);
                }
            }
            return;
        }
        int iA = m.a().a(1);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("demandSourceName", getProviderName());
            jSONObject2.put("sessionDepth", iA);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        IronLog.ADAPTER_API.verbose(getProviderName() + " mSSAPublisher.showRewardedVideo");
        this.mSSAPublisher.d(jSONObject2);
    }
}
