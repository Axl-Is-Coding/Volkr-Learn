package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.sdk.InterfaceC2346a;
import com.ironsource.mediationsdk.sdk.InterfaceC2349d;
import com.ironsource.mediationsdk.sdk.InterfaceC2350e;
import com.ironsource.mediationsdk.sdk.InterfaceC2358m;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.mediationsdk.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2311b implements com.ironsource.mediationsdk.logger.e, com.ironsource.mediationsdk.sdk.S, InterfaceC2346a, InterfaceC2350e, InterfaceC2358m {
    private static Boolean mAdapterDebug;
    protected InterfaceC2349d mActiveBannerSmash;
    protected com.ironsource.mediationsdk.sdk.r mActiveInterstitialSmash;
    protected com.ironsource.mediationsdk.sdk.X mActiveRewardedVideoSmash;
    private String mPluginFrameworkVersion;
    private String mPluginType;
    private String mProviderName;
    protected LoadWhileShowSupportState mLWSSupportState = LoadWhileShowSupportState.NONE;
    private com.ironsource.mediationsdk.logger.c mLoggerManager = com.ironsource.mediationsdk.logger.c.c();
    protected CopyOnWriteArrayList<com.ironsource.mediationsdk.sdk.X> mAllRewardedVideoSmashes = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<com.ironsource.mediationsdk.sdk.r> mAllInterstitialSmashes = new CopyOnWriteArrayList<>();
    protected CopyOnWriteArrayList<InterfaceC2349d> mAllBannerSmashes = new CopyOnWriteArrayList<>();
    protected ConcurrentHashMap<String, com.ironsource.mediationsdk.sdk.X> mRewardedVideoPlacementToListenerMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, com.ironsource.mediationsdk.sdk.r> mInterstitialPlacementToListenerMap = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, InterfaceC2349d> mBannerPlacementToListenerMap = new ConcurrentHashMap<>();

    public AbstractC2311b(String str) {
        this.mProviderName = str;
    }

    protected void addBannerListener(InterfaceC2349d interfaceC2349d) {
    }

    public void addInterstitialListener(com.ironsource.mediationsdk.sdk.r rVar) {
        this.mAllInterstitialSmashes.add(rVar);
    }

    public void addRewardedVideoListener(com.ironsource.mediationsdk.sdk.X x) {
        this.mAllRewardedVideoSmashes.add(x);
    }

    public void destroyBanner(JSONObject jSONObject) {
    }

    public void earlyInit(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject) {
        return null;
    }

    public abstract String getCoreSDKVersion();

    protected String getDynamicUserId() {
        return U.e().d();
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject) {
        return null;
    }

    public LoadWhileShowSupportState getLoadWhileShowSupportState() {
        return this.mLWSSupportState;
    }

    public JSONObject getPlayerBiddingData() {
        return null;
    }

    public String getPluginFrameworkVersion() {
        return this.mPluginFrameworkVersion;
    }

    public String getPluginType() {
        return this.mPluginType;
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject) {
        return null;
    }

    public abstract String getVersion();

    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
    }

    public void initBanners(String str, String str2, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, com.ironsource.mediationsdk.sdk.r rVar) {
    }

    public void initRewardedVideoForBidding(String str, String str2, JSONObject jSONObject, com.ironsource.mediationsdk.sdk.X x) {
    }

    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, com.ironsource.mediationsdk.sdk.X x) {
    }

    protected boolean isAdaptersDebugEnabled() {
        Boolean bool = mAdapterDebug;
        return bool != null && bool.booleanValue();
    }

    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
    }

    public void loadBannerForBidding(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, InterfaceC2349d interfaceC2349d, String str) {
    }

    public void loadInterstitialForBidding(JSONObject jSONObject, com.ironsource.mediationsdk.sdk.r rVar, String str) {
    }

    public void loadRewardedVideoForBidding(JSONObject jSONObject, com.ironsource.mediationsdk.sdk.X x, String str) {
    }

    public void loadRewardedVideoForDemandOnly(JSONObject jSONObject, com.ironsource.mediationsdk.sdk.X x) {
    }

    public void loadRewardedVideoForDemandOnlyForBidding(JSONObject jSONObject, com.ironsource.mediationsdk.sdk.X x, String str) {
    }

    protected void postOnUIThread(Runnable runnable) {
        com.ironsource.mediationsdk.utils.c.c().a(runnable);
    }

    public void reloadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, InterfaceC2349d interfaceC2349d) {
    }

    protected void removeBannerListener(InterfaceC2349d interfaceC2349d) {
    }

    public void removeInterstitialListener(com.ironsource.mediationsdk.sdk.r rVar) {
        this.mAllInterstitialSmashes.remove(rVar);
    }

    public void removeRewardedVideoListener(com.ironsource.mediationsdk.sdk.X x) {
        this.mAllRewardedVideoSmashes.remove(x);
    }

    protected void runOnUIThread(Runnable runnable) {
        com.ironsource.mediationsdk.utils.c.c().b(runnable);
    }

    protected void setAdapterDebug(Boolean bool) {
        mAdapterDebug = bool;
    }

    public void setAge(int i) {
    }

    protected void setConsent(boolean z) {
    }

    public void setGender(String str) {
    }

    public void setLogListener(com.ironsource.mediationsdk.logger.d dVar) {
    }

    public void setMediationSegment(String str) {
    }

    protected void setMediationState(AbstractSmash.MEDIATION_STATE mediation_state, String str) {
    }

    protected void setMetaData(String str, String str2) {
    }

    protected void setMetaData(String str, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            setMetaData(str, it.next());
        }
    }

    void setPluginData(String str, String str2) {
        this.mPluginType = str;
        this.mPluginFrameworkVersion = str2;
    }

    public boolean shouldBindBannerViewOnReload() {
        return false;
    }

    public void updateRewardedVideoListener(com.ironsource.mediationsdk.sdk.X x) {
        this.mAllRewardedVideoSmashes.clear();
        this.mAllRewardedVideoSmashes.add(x);
    }
}
