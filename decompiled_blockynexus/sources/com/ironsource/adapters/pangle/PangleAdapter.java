package com.ironsource.adapters.pangle;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.ironsource.mediationsdk.AbstractC2311b;
import com.ironsource.mediationsdk.C2315d;
import com.ironsource.mediationsdk.L;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.b;
import com.ironsource.mediationsdk.sdk.X;
import com.ironsource.mediationsdk.sdk.r;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.g;
import io.rong.imlib.common.RongLibConst;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PangleAdapter extends AbstractC2311b {
    private static final String APP_ID = "appID";
    private static final String GitHash = "8bcfde620";
    private static final String META_DATA_COPPA_ADULT_VALUE = "0";
    private static final String META_DATA_COPPA_CHILD_VALUE = "1";
    private static final String META_DATA_COPPA_KEY = "Pangle_COPPA";
    private static final String PLACEMENT_ID = "slotID";
    private static final String VERSION = "4.1.4";
    private static AtomicBoolean mDidCallInitSDK = new AtomicBoolean(false);
    private static TTAdConfig.Builder mTTAConfigBuilder = new TTAdConfig.Builder();
    private static TTAdNative mTTAdNative;
    private ConcurrentHashMap<String, Boolean> mInterstitialAdsAvailability;
    private ConcurrentHashMap<String, TTFullScreenVideoAd> mPlacementIdToInterstitialAd;
    private ConcurrentHashMap<String, r> mPlacementIdToInterstitialSmashListener;
    private ConcurrentHashMap<String, TTRewardVideoAd> mPlacementIdToRewardedVideoAd;
    private ConcurrentHashMap<String, X> mPlacementIdToRewardedVideoSmashListener;
    private ConcurrentHashMap<String, Boolean> mRewardedVideoAdsAvailability;

    private class InterstitialAdInteractionListener implements TTFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        private String mPlacementId;

        InterstitialAdInteractionListener(String str) {
            this.mPlacementId = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdClose() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            r rVar = (r) PangleAdapter.this.mPlacementIdToInterstitialSmashListener.get(this.mPlacementId);
            if (rVar == null) {
                IronLog.INTERNAL.verbose("listener is nil");
            } else {
                rVar.c();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdShow() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            r rVar = (r) PangleAdapter.this.mPlacementIdToInterstitialSmashListener.get(this.mPlacementId);
            if (rVar == null) {
                IronLog.INTERNAL.verbose("listener is nil");
            } else {
                rVar.e();
                rVar.f();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onAdVideoBarClick() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            r rVar = (r) PangleAdapter.this.mPlacementIdToInterstitialSmashListener.get(this.mPlacementId);
            if (rVar == null) {
                IronLog.INTERNAL.verbose("listener is nil");
            } else {
                rVar.d();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onSkippedVideo() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
        }

        @Override // com.bytedance.sdk.openadsdk.TTFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public void onVideoComplete() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
        }
    }

    private class InterstitialAdLoadListener implements TTAdNative.FullScreenVideoAdListener {
        private String mPlacementId;

        InterstitialAdLoadListener(String str) {
            this.mPlacementId = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            String str2 = "load failed for placementId = " + this.mPlacementId + ", error code = " + i + ", message = " + str;
            IronLog.ADAPTER_CALLBACK.verbose(str2);
            r rVar = (r) PangleAdapter.this.mPlacementIdToInterstitialSmashListener.get(this.mPlacementId);
            if (rVar == null) {
                IronLog.INTERNAL.verbose("listener is nil");
            } else {
                PangleAdapter.this.mInterstitialAdsAvailability.put(this.mPlacementId, false);
                rVar.a(new b(i, str2));
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoAdLoad(TTFullScreenVideoAd tTFullScreenVideoAd) {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            r rVar = (r) PangleAdapter.this.mPlacementIdToInterstitialSmashListener.get(this.mPlacementId);
            if (rVar == null) {
                IronLog.INTERNAL.verbose("listener is nil");
            } else {
                if (tTFullScreenVideoAd == null) {
                    rVar.a(g.b("Interstitial", PangleAdapter.this.getProviderName(), "load failed - ad is null"));
                    return;
                }
                PangleAdapter.this.mPlacementIdToInterstitialAd.put(this.mPlacementId, tTFullScreenVideoAd);
                PangleAdapter.this.mInterstitialAdsAvailability.put(this.mPlacementId, true);
                rVar.a();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.FullScreenVideoAdListener
        public void onFullScreenVideoCached() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
        }
    }

    private interface ResultListener {
        void onFail(b bVar);

        void onSuccess();
    }

    private class RewardedVideoAdInteractionListener implements TTRewardVideoAd.RewardAdInteractionListener {
        private String mPlacementId;

        RewardedVideoAdInteractionListener(String str) {
            this.mPlacementId = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdClose() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            X x = (X) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (x == null) {
                IronLog.INTERNAL.verbose("listener is nil");
            } else {
                x.onRewardedVideoAdClosed();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdShow() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            X x = (X) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (x == null) {
                IronLog.INTERNAL.verbose("listener is nil");
            } else {
                x.onRewardedVideoAdOpened();
                x.g();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onAdVideoBarClick() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            X x = (X) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (x == null) {
                IronLog.INTERNAL.verbose("listener is nil");
            } else {
                x.k();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onRewardVerify(boolean z, int i, String str) {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            IronLog.ADAPTER_CALLBACK.verbose("rewardVerify = " + z);
            IronLog.ADAPTER_CALLBACK.verbose("rewardAmount = " + i);
            IronLog.ADAPTER_CALLBACK.verbose("rewardName = " + str);
            if (z) {
                X x = (X) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
                if (x == null) {
                    IronLog.INTERNAL.verbose("listener is nil");
                } else {
                    x.l();
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onSkippedVideo() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoComplete() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            X x = (X) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (x == null) {
                IronLog.INTERNAL.verbose("listener is nil");
            } else {
                x.b();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
        public void onVideoError() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            X x = (X) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (x == null) {
                IronLog.INTERNAL.verbose("listener is nil");
                return;
            }
            x.c(g.b("Rewarded Video", PangleAdapter.this.getProviderName() + " video error"));
            x.a(false);
        }
    }

    private class RewardedVideoAdLoadListener implements TTAdNative.RewardVideoAdListener {
        private String mPlacementId;

        RewardedVideoAdLoadListener(String str) {
            this.mPlacementId = str;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener, com.bytedance.sdk.openadsdk.a.b
        public void onError(int i, String str) {
            String str2 = "load failed for placementId = " + this.mPlacementId + ", error code = " + i + ", message = " + str;
            IronLog.ADAPTER_CALLBACK.verbose(str2);
            X x = (X) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (x == null) {
                IronLog.INTERNAL.verbose("listener is nil");
                return;
            }
            PangleAdapter.this.mRewardedVideoAdsAvailability.put(this.mPlacementId, false);
            x.e(new b(i, str2));
            x.a(false);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
            X x = (X) PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.get(this.mPlacementId);
            if (x == null) {
                IronLog.INTERNAL.verbose("listener is nil");
                return;
            }
            if (tTRewardVideoAd == null) {
                IronLog.ADAPTER_CALLBACK.verbose("load failed - ad is null");
                x.e(g.b("Rewarded Video", PangleAdapter.this.getProviderName(), "load failed - ad is null"));
                x.a(false);
            } else {
                PangleAdapter.this.mPlacementIdToRewardedVideoAd.put(this.mPlacementId, tTRewardVideoAd);
                PangleAdapter.this.mRewardedVideoAdsAvailability.put(this.mPlacementId, true);
                x.a(true);
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
            IronLog.ADAPTER_CALLBACK.verbose("placement = " + this.mPlacementId);
        }
    }

    private PangleAdapter(String str) {
        super(str);
        IronLog.INTERNAL.verbose("");
        this.mPlacementIdToRewardedVideoSmashListener = new ConcurrentHashMap<>();
        this.mPlacementIdToRewardedVideoAd = new ConcurrentHashMap<>();
        this.mRewardedVideoAdsAvailability = new ConcurrentHashMap<>();
        this.mPlacementIdToInterstitialSmashListener = new ConcurrentHashMap<>();
        this.mPlacementIdToInterstitialAd = new ConcurrentHashMap<>();
        this.mInterstitialAdsAvailability = new ConcurrentHashMap<>();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AdSlot createAdSlot(String str, boolean z, String str2) {
        IronLog.ADAPTER_API.verbose("placementId = " + str);
        AdSlot.Builder builder = new AdSlot.Builder();
        builder.setCodeId(str);
        if (z) {
            builder.withBid(str2);
        }
        Activity activityB = c.c().b();
        builder.setImageAcceptedSize(C2315d.a(activityB, activityB.getResources().getConfiguration().screenWidthDp), C2315d.a(activityB, activityB.getResources().getConfiguration().screenHeightDp));
        return builder.build();
    }

    public static String getAdapterSDKVersion() {
        return TTAdSdk.getAdManager() != null ? TTAdSdk.getAdManager().getSDKVersion() : "Pangle sdk was not initiated yet";
    }

    private Map<String, Object> getBiddingData() {
        String biddingToken = TTAdSdk.getAdManager().getBiddingToken();
        if (TextUtils.isEmpty(biddingToken)) {
            biddingToken = "";
        }
        IronLog.ADAPTER_API.verbose("token = " + biddingToken);
        HashMap map = new HashMap();
        map.put(RongLibConst.KEY_TOKEN, biddingToken);
        return map;
    }

    public static int getCOPPAMetaDataValue(String str) {
        return str.equals("0") ? 0 : 1;
    }

    public static L getIntegrationData(Activity activity) {
        return new L("Pangle", "4.1.4");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSDK(String str) {
        if (mDidCallInitSDK.compareAndSet(false, true)) {
            IronLog.ADAPTER_API.verbose("appId = " + str);
            if (mTTAConfigBuilder == null) {
                mTTAConfigBuilder = new TTAdConfig.Builder();
            }
            mTTAConfigBuilder.appId(str);
            mTTAConfigBuilder.appName("IronSource mediation - Pangle adapter version 4.1.4");
            if (isAdaptersDebugEnabled()) {
                IronLog.INTERNAL.verbose("adapter debug value = true");
                mTTAConfigBuilder.debug(true);
            }
            TTAdSdk.init(c.c().a(), mTTAConfigBuilder.build());
        }
        mTTAdNative = TTAdSdk.getAdManager().createAdNative(c.c().a());
    }

    public static boolean isValidCOPPAMetaData(String str, String str2) {
        IronLog.INTERNAL.verbose("key = " + str + ", value = " + str2);
        return str.equalsIgnoreCase(META_DATA_COPPA_KEY) && (str2.equals("0") || str2.equals("1"));
    }

    private void loadInterstitialInternal(final String str, final boolean z, r rVar, final String str2) {
        if (TextUtils.isEmpty(str)) {
            IronLog.INTERNAL.error("error - missing param = slotID");
            rVar.a(g.c(getProviderName() + " - placement id is empty"));
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + str);
        this.mInterstitialAdsAvailability.put(str, false);
        postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter.10
            @Override // java.lang.Runnable
            public void run() {
                PangleAdapter.mTTAdNative.loadFullScreenVideoAd(PangleAdapter.this.createAdSlot(str, z, str2), PangleAdapter.this.new InterstitialAdLoadListener(str));
            }
        });
    }

    private void loadRewardedVideo(final JSONObject jSONObject, final boolean z, X x, final String str, final ResultListener resultListener) {
        validateParams(jSONObject, "Rewarded Video", new ResultListener() { // from class: com.ironsource.adapters.pangle.PangleAdapter.6
            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onFail(b bVar) {
                resultListener.onFail(bVar);
            }

            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onSuccess() {
                final String strOptString = jSONObject.optString(PangleAdapter.PLACEMENT_ID);
                IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
                PangleAdapter.this.mRewardedVideoAdsAvailability.put(strOptString, false);
                PangleAdapter.this.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        TTAdNative tTAdNative = PangleAdapter.mTTAdNative;
                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                        tTAdNative.loadRewardVideoAd(PangleAdapter.this.createAdSlot(strOptString, z, str), PangleAdapter.this.new RewardedVideoAdLoadListener(strOptString));
                        resultListener.onSuccess();
                    }
                });
            }
        });
    }

    private void setCOPPAValue(String str) {
        String str2 = str.equals("0") ? "Adult" : "Child";
        IronLog.INTERNAL.verbose("value = " + str2);
        mTTAConfigBuilder.coppa(getCOPPAMetaDataValue(str));
    }

    public static PangleAdapter startAdapter(String str) {
        return new PangleAdapter(str);
    }

    private void validateParams(JSONObject jSONObject, String str, ResultListener resultListener) {
        if (TextUtils.isEmpty(jSONObject.optString(APP_ID))) {
            IronLog.INTERNAL.error("error - missing param = appID");
            resultListener.onFail(g.a("missing param = appID", str));
        } else if (!TextUtils.isEmpty(jSONObject.optString(PLACEMENT_ID))) {
            resultListener.onSuccess();
        } else {
            IronLog.INTERNAL.error("error - missing param = slotID");
            resultListener.onFail(g.a("missing param = slotID", str));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, final X x) {
        loadRewardedVideo(jSONObject, false, x, null, new ResultListener() { // from class: com.ironsource.adapters.pangle.PangleAdapter.4
            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onFail(b bVar) {
                x.a(false);
            }

            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onSuccess() {
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getCoreSDKVersion() {
        return TTAdSdk.getAdManager().getSDKVersion();
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
        return "4.1.4";
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void initInterstitial(String str, String str2, JSONObject jSONObject, final r rVar) {
        IronLog.INTERNAL.verbose("");
        initInterstitial(jSONObject, rVar, new ResultListener() { // from class: com.ironsource.adapters.pangle.PangleAdapter.8
            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onFail(b bVar) {
                rVar.g(bVar);
            }

            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onSuccess() {
                rVar.onInterstitialInitSuccess();
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, r rVar) {
        IronLog.INTERNAL.verbose("");
        initInterstitial(str, str2, jSONObject, rVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void initRewardedVideo(String str, String str2, final JSONObject jSONObject, final X x) {
        IronLog.INTERNAL.verbose("");
        initRewardedVideo(jSONObject, x, new ResultListener() { // from class: com.ironsource.adapters.pangle.PangleAdapter.2
            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onFail(b bVar) {
                x.a(false);
            }

            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onSuccess() {
                PangleAdapter.this.fetchRewardedVideoForAutomaticLoad(jSONObject, x);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initRewardedVideoForBidding(String str, String str2, JSONObject jSONObject, final X x) {
        IronLog.INTERNAL.verbose("");
        initRewardedVideo(jSONObject, x, new ResultListener() { // from class: com.ironsource.adapters.pangle.PangleAdapter.1
            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onFail(b bVar) {
                x.f(bVar);
            }

            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onSuccess() {
                x.m();
            }
        });
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public boolean isInterstitialReady(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(PLACEMENT_ID);
        return this.mInterstitialAdsAvailability.containsKey(strOptString) && this.mInterstitialAdsAvailability.get(strOptString).booleanValue();
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        String strOptString = jSONObject.optString(PLACEMENT_ID);
        return this.mRewardedVideoAdsAvailability.containsKey(strOptString) && this.mRewardedVideoAdsAvailability.get(strOptString).booleanValue();
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void loadInterstitial(JSONObject jSONObject, r rVar) {
        loadInterstitialInternal(jSONObject.optString(PLACEMENT_ID), false, rVar, null);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadInterstitialForBidding(JSONObject jSONObject, r rVar, String str) {
        loadInterstitialInternal(jSONObject.optString(PLACEMENT_ID), true, rVar, str);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadRewardedVideoForBidding(JSONObject jSONObject, final X x, String str) {
        loadRewardedVideo(jSONObject, true, x, str, new ResultListener() { // from class: com.ironsource.adapters.pangle.PangleAdapter.5
            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onFail(b bVar) {
                x.e(bVar);
            }

            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onSuccess() {
            }
        });
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setConsent(boolean z) {
        IronLog.ADAPTER_API.verbose("consent = " + z);
        mTTAConfigBuilder.setGDPR(z ? 1 : 0);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setMetaData(String str, String str2) {
        IronLog.ADAPTER_API.verbose("key = " + str + ", value = " + str2);
        if (isValidCOPPAMetaData(str, str2)) {
            setCOPPAValue(str2);
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void showInterstitial(JSONObject jSONObject, r rVar) {
        final String strOptString = jSONObject.optString(PLACEMENT_ID);
        IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
        if (isInterstitialReady(jSONObject)) {
            final TTFullScreenVideoAd tTFullScreenVideoAd = this.mPlacementIdToInterstitialAd.get(strOptString);
            this.mInterstitialAdsAvailability.put(strOptString, false);
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter.11
                @Override // java.lang.Runnable
                public void run() {
                    tTFullScreenVideoAd.setFullScreenVideoAdInteractionListener(PangleAdapter.this.new InterstitialAdInteractionListener(strOptString));
                    tTFullScreenVideoAd.showFullScreenVideoAd(c.c().b());
                }
            });
        } else {
            IronLog.INTERNAL.error("show failed - no ad found for placement");
            rVar.b(g.b("Interstitial", getProviderName() + " - show failed no ad found"));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void showRewardedVideo(JSONObject jSONObject, X x) {
        final String strOptString = jSONObject.optString(PLACEMENT_ID);
        IronLog.ADAPTER_API.verbose("placementId = " + strOptString);
        if (isRewardedVideoAvailable(jSONObject)) {
            final TTRewardVideoAd tTRewardVideoAd = this.mPlacementIdToRewardedVideoAd.get(strOptString);
            this.mRewardedVideoAdsAvailability.put(strOptString, false);
            postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter.7
                @Override // java.lang.Runnable
                public void run() {
                    tTRewardVideoAd.setRewardAdInteractionListener(PangleAdapter.this.new RewardedVideoAdInteractionListener(strOptString));
                    tTRewardVideoAd.showRewardVideoAd(c.c().b());
                }
            });
        } else {
            IronLog.INTERNAL.error("show failed - no ad for placement");
            x.c(g.b("Rewarded Video", getProviderName() + " - show failed no ad found"));
        }
        x.a(false);
    }

    private void initInterstitial(final JSONObject jSONObject, final r rVar, final ResultListener resultListener) {
        validateParams(jSONObject, "Interstitial", new ResultListener() { // from class: com.ironsource.adapters.pangle.PangleAdapter.9
            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onFail(b bVar) {
                resultListener.onFail(bVar);
            }

            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onSuccess() {
                final String strOptString = jSONObject.optString(PangleAdapter.APP_ID);
                String strOptString2 = jSONObject.optString(PangleAdapter.PLACEMENT_ID);
                IronLog.ADAPTER_API.verbose("placementId = " + strOptString2);
                PangleAdapter.this.mPlacementIdToInterstitialSmashListener.put(strOptString2, rVar);
                PangleAdapter.this.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter.9.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PangleAdapter.this.initSDK(strOptString);
                        resultListener.onSuccess();
                    }
                });
            }
        });
    }

    private void initRewardedVideo(final JSONObject jSONObject, final X x, final ResultListener resultListener) {
        validateParams(jSONObject, "Rewarded Video", new ResultListener() { // from class: com.ironsource.adapters.pangle.PangleAdapter.3
            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onFail(b bVar) {
                resultListener.onFail(bVar);
            }

            @Override // com.ironsource.adapters.pangle.PangleAdapter.ResultListener
            public void onSuccess() {
                final String strOptString = jSONObject.optString(PangleAdapter.APP_ID);
                String strOptString2 = jSONObject.optString(PangleAdapter.PLACEMENT_ID);
                IronLog.ADAPTER_API.verbose("placementId = " + strOptString2);
                PangleAdapter.this.mPlacementIdToRewardedVideoSmashListener.put(strOptString2, x);
                PangleAdapter.this.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        PangleAdapter.this.initSDK(strOptString);
                        resultListener.onSuccess();
                    }
                });
            }
        });
    }
}
