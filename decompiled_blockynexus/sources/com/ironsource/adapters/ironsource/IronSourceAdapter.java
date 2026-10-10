package com.ironsource.adapters.ironsource;

import android.app.Activity;
import android.text.TextUtils;
import b.f.d.b;
import b.f.d.g.d;
import com.facebook.internal.ServerProtocol;
import com.ironsource.mediationsdk.AbstractC2311b;
import com.ironsource.mediationsdk.AuctionDataUtils;
import com.ironsource.mediationsdk.U;
import com.ironsource.mediationsdk.e.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.X;
import com.ironsource.mediationsdk.sdk.r;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.utils.g;
import com.ironsource.mediationsdk.utils.j;
import com.ironsource.mediationsdk.utils.m;
import com.ironsource.sdk.utils.i;
import com.sandboxol.center.config.VipSubscribeStatus;
import io.rong.imlib.common.RongLibConst;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class IronSourceAdapter extends AbstractC2311b implements c.a {
    private static final int IS_LOAD_EXCEPTION = 1000;
    private static final int IS_SHOW_EXCEPTION = 1001;
    private static final int RV_LOAD_EXCEPTION = 1002;
    private static final int RV_SHOW_EXCEPTION = 1003;
    private static final String VERSION = "7.0.2";
    private static AtomicBoolean mDidInitSdk = new AtomicBoolean(false);
    private static String mediationSegment;
    private static String userAgeGroup;
    private static String userGender;
    private final String ADM_KEY;
    private final String APPLICATION_USER_AGE_GROUP;
    private final String APPLICATION_USER_GENDER;
    private final String CUSTOM_SEGMENT;
    private final String DEMAND_SOURCE_NAME;
    private final String DYNAMIC_CONTROLLER_CONFIG;
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE;
    private final String DYNAMIC_CONTROLLER_URL;
    private final String SDK_PLUGIN_TYPE;
    private final String SESSION_ID;
    private ConcurrentHashMap<String, b> mDemandSourceToISAd;
    private ConcurrentHashMap<String, r> mDemandSourceToISSmash;
    private ConcurrentHashMap<String, b> mDemandSourceToRvAd;
    private ConcurrentHashMap<String, X> mDemandSourceToRvSmash;

    private class IronSourceInterstitialListener implements d {
        private String mDemandSourceName;
        private r mListener;

        IronSourceInterstitialListener(r rVar, String str) {
            this.mDemandSourceName = str;
            this.mListener = rVar;
        }

        @Override // b.f.d.g.d
        public void onInterstitialAdRewarded(String str, int i) {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener demandSourceId=" + str + " amount=" + i);
        }

        @Override // b.f.d.g.d
        public void onInterstitialClick() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.d();
        }

        @Override // b.f.d.g.d
        public void onInterstitialClose() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.c();
        }

        @Override // b.f.d.g.d
        public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener eventName=" + str);
            this.mListener.h();
        }

        @Override // b.f.d.g.d
        public void onInterstitialInitFailed(String str) {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener");
        }

        @Override // b.f.d.g.d
        public void onInterstitialInitSuccess() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener");
        }

        @Override // b.f.d.g.d
        public void onInterstitialLoadFailed(String str) {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener " + str);
            this.mListener.a(g.c(str));
        }

        @Override // b.f.d.g.d
        public void onInterstitialLoadSuccess() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.a();
        }

        @Override // b.f.d.g.d
        public void onInterstitialOpen() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.e();
        }

        @Override // b.f.d.g.d
        public void onInterstitialShowFailed(String str) {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener " + str);
            this.mListener.b(g.b("Interstitial", str));
        }

        @Override // b.f.d.g.d
        public void onInterstitialShowSuccess() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " interstitialListener");
            this.mListener.f();
        }
    }

    private IronSourceAdapter(String str) {
        super(str);
        this.DYNAMIC_CONTROLLER_URL = "controllerUrl";
        this.DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
        this.DYNAMIC_CONTROLLER_CONFIG = "controllerConfig";
        this.APPLICATION_USER_GENDER = "applicationUserGender";
        this.APPLICATION_USER_AGE_GROUP = "applicationUserAgeGroup";
        this.SESSION_ID = "sessionid";
        this.SDK_PLUGIN_TYPE = "SDKPluginType";
        this.CUSTOM_SEGMENT = "custom_Segment";
        this.ADM_KEY = "adm";
        this.DEMAND_SOURCE_NAME = "demandSourceName";
        IronLog.INTERNAL.verbose(str + ": new instance");
        this.mDemandSourceToISAd = new ConcurrentHashMap<>();
        this.mDemandSourceToRvAd = new ConcurrentHashMap<>();
        this.mDemandSourceToRvSmash = new ConcurrentHashMap<>();
        this.mDemandSourceToISSmash = new ConcurrentHashMap<>();
        userAgeGroup = null;
        userGender = null;
        mediationSegment = null;
        c.c().a(this);
    }

    private b getAdInstance(String str, boolean z, boolean z2, boolean z3) {
        b.f.d.c cVar;
        b bVarA = z3 ? this.mDemandSourceToRvAd.get(str) : this.mDemandSourceToISAd.get(str);
        if (bVarA == null) {
            IronLog.ADAPTER_API.verbose("creating ad instance for " + str + " isDemandOnlyForRv=" + z + " isBidder=" + z2 + " isRewarded=" + z3);
            if (z3) {
                cVar = new b.f.d.c(str, new IronSourceRewardedVideoListener(this.mDemandSourceToRvSmash.get(str), str, z));
                cVar.a(getInitParams());
                cVar.c();
            } else {
                cVar = new b.f.d.c(str, new IronSourceInterstitialListener(this.mDemandSourceToISSmash.get(str), str));
                cVar.a(getInitParams());
            }
            if (z2) {
                cVar.b();
            }
            bVarA = cVar.a();
            if (z3) {
                this.mDemandSourceToRvAd.put(str, bVarA);
            } else {
                this.mDemandSourceToISAd.put(str, bVarA);
            }
        }
        return bVarA;
    }

    private String getDemandSourceName(JSONObject jSONObject) {
        return !TextUtils.isEmpty(jSONObject.optString("demandSourceName")) ? jSONObject.optString("demandSourceName") : getProviderName();
    }

    private HashMap<String, String> getInitParams() {
        HashMap<String, String> map = new HashMap<>();
        if (!TextUtils.isEmpty(userAgeGroup)) {
            map.put("applicationUserAgeGroup", userAgeGroup);
        }
        if (!TextUtils.isEmpty(userGender)) {
            map.put("applicationUserGender", userGender);
        }
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            map.put("SDKPluginType", pluginType);
        }
        if (!TextUtils.isEmpty(mediationSegment)) {
            map.put("custom_Segment", mediationSegment);
        }
        if (!TextUtils.isEmpty(U.e().k())) {
            map.put("sessionid", U.e().k());
        }
        return map;
    }

    private void initInterstitialInternal(String str, JSONObject jSONObject, r rVar, String str2) {
        initSDK(str, jSONObject);
        this.mDemandSourceToISSmash.put(str2, rVar);
        rVar.onInterstitialInitSuccess();
    }

    private void initRewardedVideoInternal(String str, JSONObject jSONObject, X x, String str2) {
        initSDK(str, jSONObject);
        this.mDemandSourceToRvSmash.put(str2, x);
    }

    private void initSDK(String str, JSONObject jSONObject) {
        if (mDidInitSdk.compareAndSet(false, true)) {
            String strB = j.b();
            int iOptInt = jSONObject.optInt("debugMode", 0);
            if (isAdaptersDebugEnabled()) {
                iOptInt = 3;
            }
            IronLog.ADAPTER_API.verbose("etting debug mode to " + iOptInt);
            i.a(iOptInt);
            i.g(jSONObject.optString("controllerUrl"));
            IronLog.ADAPTER_API.verbose("IronSourceNetwork setting controller url to  " + jSONObject.optString("controllerUrl"));
            i.f(jSONObject.optString("controllerConfig"));
            IronLog.ADAPTER_API.verbose("IronSourceNetwork setting controller config to  " + jSONObject.optString("controllerConfig"));
            HashMap<String, String> initParams = getInitParams();
            IronLog.ADAPTER_API.verbose("with appKey=" + str + " userId=" + strB + " parameters " + initParams);
            b.f.d.d.a(c.c().b(), str, strB, initParams);
        }
    }

    private boolean isValidMetaData(String str, String str2) {
        if (str.equals("do_not_sell")) {
            return a.a(str, str2);
        }
        return true;
    }

    private void loadAdInternal(String str, String str2, boolean z, boolean z2, boolean z3) throws Exception {
        HashMap map = new HashMap();
        if (str2 != null) {
            map.put("adm", AuctionDataUtils.b().b(str2));
            map.putAll(AuctionDataUtils.b().c(str2));
        }
        b adInstance = getAdInstance(str, z, z2, z3);
        printInstanceExtraParams(map);
        IronLog.ADAPTER_API.verbose("demandSourceName=" + adInstance.d());
        b.f.d.d.a(adInstance, map);
    }

    private void printInstanceExtraParams(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        IronLog.ADAPTER_API.verbose("instance extra params:");
        for (String str : map.keySet()) {
            IronLog.ADAPTER_API.verbose(str + "=" + map.get(str));
        }
    }

    private void showAdInternal(b bVar, int i) throws Exception {
        int iA = m.a().a(i);
        HashMap map = new HashMap();
        map.put("sessionDepth", String.valueOf(iA));
        IronLog.ADAPTER_API.verbose("demandSourceName=" + bVar.d() + " showParams=" + map);
        b.f.d.d.b(bVar, map);
    }

    public static IronSourceAdapter startAdapter(String str) {
        return new IronSourceAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void earlyInit(String str, String str2, JSONObject jSONObject) {
        if (str == null) {
            IronLog.ADAPTER_API.error("Appkey is null for early init");
            return;
        }
        j.c(getDemandSourceName(jSONObject) + ": earlyInit");
        initSDK(str, jSONObject);
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void fetchRewardedVideoForAutomaticLoad(JSONObject jSONObject, X x) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName);
        try {
            loadAdInternal(demandSourceName, null, false, false, true);
        } catch (Exception e2) {
            IronLog.ADAPTER_API.error("exception " + e2.getMessage());
            X x2 = this.mDemandSourceToRvSmash.get(demandSourceName);
            if (x2 != null) {
                IronLog.ADAPTER_API.error("exception " + e2.getMessage());
                x2.e(new com.ironsource.mediationsdk.logger.b(1002, e2.getMessage()));
                x2.a(false);
            }
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getCoreSDKVersion() {
        return i.h();
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject) {
        IronLog.ADAPTER_API.verbose("");
        HashMap map = new HashMap();
        String strB = b.f.d.d.b(c.c().a());
        if (strB != null) {
            map.put(RongLibConst.KEY_TOKEN, strB);
        } else {
            IronLog.ADAPTER_API.error("IS bidding token is null");
            map.put(RongLibConst.KEY_TOKEN, "");
        }
        return map;
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public JSONObject getPlayerBiddingData() {
        JSONObject jSONObjectA;
        IronLog.ADAPTER_API.verbose("");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObjectA = b.f.d.d.a(c.c().a());
        } catch (Exception e2) {
            IronLog.ADAPTER_API.error("getRawToken exception: " + e2.getLocalizedMessage());
            jSONObjectA = null;
        }
        if (jSONObjectA != null) {
            return jSONObjectA;
        }
        IronLog.ADAPTER_API.error("Player's bidding token is null");
        return jSONObject;
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject) {
        IronLog.ADAPTER_API.verbose("getRewardedVideoBiddingData");
        HashMap map = new HashMap();
        String strB = b.f.d.d.b(c.c().a());
        if (strB != null) {
            map.put(RongLibConst.KEY_TOKEN, strB);
        } else {
            IronLog.ADAPTER_API.error("RV bidding token is null");
            map.put(RongLibConst.KEY_TOKEN, "");
        }
        return map;
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public String getVersion() {
        return VERSION;
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void initInterstitial(String str, String str2, JSONObject jSONObject, r rVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.INTERNAL.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initInterstitialInternal(str, jSONObject, rVar, demandSourceName);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, r rVar) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.INTERNAL.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initInterstitialInternal(str, jSONObject, rVar, demandSourceName);
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void initRewardedVideo(String str, String str2, JSONObject jSONObject, X x) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.INTERNAL.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, x, demandSourceName);
        fetchRewardedVideoForAutomaticLoad(jSONObject, x);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initRewardedVideoForBidding(String str, String str2, JSONObject jSONObject, X x) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.INTERNAL.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, x, demandSourceName);
        x.m();
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, X x) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.INTERNAL.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, x, demandSourceName);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public boolean isInterstitialReady(JSONObject jSONObject) {
        b bVar = this.mDemandSourceToISAd.get(getDemandSourceName(jSONObject));
        return bVar != null && b.f.d.d.a(bVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        b bVar = this.mDemandSourceToRvAd.get(getDemandSourceName(jSONObject));
        return bVar != null && b.f.d.d.a(bVar);
    }

    @Override // com.ironsource.mediationsdk.sdk.InterfaceC2358m
    public void loadInterstitial(JSONObject jSONObject, r rVar) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), null, false, false, false);
        } catch (Exception e2) {
            IronLog.ADAPTER_API.error("exception " + e2.getMessage());
            rVar.a(new com.ironsource.mediationsdk.logger.b(1000, e2.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadInterstitialForBidding(JSONObject jSONObject, r rVar, String str) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), str, false, true, false);
        } catch (Exception e2) {
            IronLog.ADAPTER_API.error("for bidding exception " + e2.getMessage());
            rVar.a(new com.ironsource.mediationsdk.logger.b(1000, e2.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadRewardedVideoForBidding(JSONObject jSONObject, X x, String str) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), str, false, true, true);
        } catch (Exception e2) {
            IronLog.ADAPTER_API.error("exception " + e2.getMessage());
            x.e(new com.ironsource.mediationsdk.logger.b(1002, e2.getMessage()));
            x.a(false);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadRewardedVideoForDemandOnly(JSONObject jSONObject, X x) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), null, true, false, true);
        } catch (Exception e2) {
            IronLog.ADAPTER_API.error("exception " + e2.getMessage());
            x.e(new com.ironsource.mediationsdk.logger.b(1002, e2.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void loadRewardedVideoForDemandOnlyForBidding(JSONObject jSONObject, X x, String str) {
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            loadAdInternal(getDemandSourceName(jSONObject), str, true, true, true);
        } catch (Exception e2) {
            IronLog.ADAPTER_API.error("exception " + e2.getMessage());
            x.e(new com.ironsource.mediationsdk.logger.b(1002, e2.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.utils.c.a
    public void onPause(Activity activity) {
        IronLog.ADAPTER_API.verbose("IronSourceNetwork.onPause");
        b.f.d.d.a(activity);
    }

    @Override // com.ironsource.mediationsdk.utils.c.a
    public void onResume(Activity activity) {
        IronLog.ADAPTER_API.verbose("IronSourceNetwork.onResume");
        b.f.d.d.b(activity);
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void setAge(int i) {
        IronLog.INTERNAL.verbose(": " + i);
        if (i >= 13 && i <= 17) {
            userAgeGroup = "1";
            return;
        }
        if (i >= 18 && i <= 20) {
            userAgeGroup = "2";
            return;
        }
        if (i >= 21 && i <= 24) {
            userAgeGroup = "3";
            return;
        }
        if (i >= 25 && i <= 34) {
            userAgeGroup = VipSubscribeStatus.SUBSCRIPTION_PURCHASED;
            return;
        }
        if (i >= 35 && i <= 44) {
            userAgeGroup = VipSubscribeStatus.SUBSCRIPTION_ON_HOLD;
            return;
        }
        if (i >= 45 && i <= 54) {
            userAgeGroup = VipSubscribeStatus.SUBSCRIPTION_IN_GRACE_PERIOD;
            return;
        }
        if (i >= 55 && i <= 64) {
            userAgeGroup = VipSubscribeStatus.SUBSCRIPTION_RESTARTED;
        } else if (i <= 65 || i > 120) {
            userAgeGroup = "0";
        } else {
            userAgeGroup = VipSubscribeStatus.SUBSCRIPTION_PRICE_CHANGE_CONFIRMED;
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        sb.append(")");
        ironLog.verbose(sb.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consent", z ? "1" : "0");
            b.f.d.d.c(jSONObject);
        } catch (JSONException e2) {
            IronLog.ADAPTER_API.error("exception " + e2.getMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void setGender(String str) {
        IronLog.INTERNAL.verbose(str);
        userGender = str;
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    public void setMediationSegment(String str) {
        mediationSegment = str;
    }

    @Override // com.ironsource.mediationsdk.AbstractC2311b
    protected void setMetaData(String str, String str2) {
        if (mDidInitSdk.get()) {
            return;
        }
        IronLog.ADAPTER_API.verbose("key=" + str + ", value=" + str2);
        if (!isValidMetaData(str, str2)) {
            IronLog.ADAPTER_API.verbose("MetaData not valid");
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
        IronLog.ADAPTER_API.verbose(getDemandSourceName(jSONObject));
        try {
            showAdInternal(this.mDemandSourceToISAd.get(getDemandSourceName(jSONObject)), 2);
        } catch (Exception e2) {
            IronLog.ADAPTER_API.error("exception " + e2.getMessage());
            rVar.b(new com.ironsource.mediationsdk.logger.b(1001, e2.getMessage()));
        }
    }

    @Override // com.ironsource.mediationsdk.sdk.S
    public void showRewardedVideo(JSONObject jSONObject, X x) {
        try {
            showAdInternal(this.mDemandSourceToRvAd.get(getDemandSourceName(jSONObject)), 1);
        } catch (Exception e2) {
            IronLog.ADAPTER_API.error("exception " + e2.getMessage());
            x.c(new com.ironsource.mediationsdk.logger.b(1003, e2.getMessage()));
        }
    }

    private class IronSourceRewardedVideoListener implements d {
        private String mDemandSourceName;
        boolean mIsRvDemandOnly;
        X mListener;

        IronSourceRewardedVideoListener(X x, String str) {
            this.mDemandSourceName = str;
            this.mListener = x;
            this.mIsRvDemandOnly = false;
        }

        @Override // b.f.d.g.d
        public void onInterstitialAdRewarded(String str, int i) {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener demandSourceId=" + str + " amount=" + i);
            this.mListener.l();
        }

        @Override // b.f.d.g.d
        public void onInterstitialClick() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener");
            this.mListener.k();
        }

        @Override // b.f.d.g.d
        public void onInterstitialClose() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener");
            this.mListener.onRewardedVideoAdClosed();
        }

        @Override // b.f.d.g.d
        public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener eventName=" + str);
            this.mListener.i();
        }

        @Override // b.f.d.g.d
        public void onInterstitialInitFailed(String str) {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener");
        }

        @Override // b.f.d.g.d
        public void onInterstitialInitSuccess() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener");
        }

        @Override // b.f.d.g.d
        public void onInterstitialLoadFailed(String str) {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener " + str);
            this.mListener.e(g.c(str));
            if (this.mIsRvDemandOnly) {
                return;
            }
            this.mListener.a(false);
        }

        @Override // b.f.d.g.d
        public void onInterstitialLoadSuccess() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener");
            if (this.mIsRvDemandOnly) {
                this.mListener.n();
            } else {
                this.mListener.a(true);
            }
        }

        @Override // b.f.d.g.d
        public void onInterstitialOpen() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener");
            this.mListener.onRewardedVideoAdOpened();
        }

        @Override // b.f.d.g.d
        public void onInterstitialShowFailed(String str) {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + "rewardedVideoListener " + str);
            this.mListener.c(g.b("Rewarded Video", str));
        }

        @Override // b.f.d.g.d
        public void onInterstitialShowSuccess() {
            IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener");
            if (this.mIsRvDemandOnly) {
                return;
            }
            this.mListener.a(false);
        }

        IronSourceRewardedVideoListener(X x, String str, boolean z) {
            this.mDemandSourceName = str;
            this.mListener = x;
            this.mIsRvDemandOnly = z;
        }
    }
}
