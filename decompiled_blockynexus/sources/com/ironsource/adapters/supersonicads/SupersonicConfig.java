package com.ironsource.adapters.supersonicads;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.c;
import com.ironsource.mediationsdk.model.p;
import com.ironsource.mediationsdk.model.q;
import com.umeng.analytics.pro.au;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class SupersonicConfig {
    private static SupersonicConfig mInstance;
    private Map<String, String> mOfferwallCustomParams;
    private Map<String, String> mRewardedVideoCustomParams;
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String MAX_VIDEO_LENGTH = "maxVideoLength";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    private final String CAMPAIGN_ID = "campaignId";
    private final String LANGUAGE = au.M;
    private final String APPLICATION_PRIVATE_KEY = "privateKey";
    private final String ITEM_NAME = "itemName";
    private final String ITEM_COUNT = "itemCount";
    p mProviderSettings = new p(q.b().b("Mediation"));

    private SupersonicConfig() {
    }

    private Map<String, String> convertCustomParams(Map<String, String> map) {
        HashMap map2 = new HashMap();
        if (map != null) {
            try {
                Set<String> setKeySet = map.keySet();
                if (setKeySet != null) {
                    for (String str : setKeySet) {
                        if (!TextUtils.isEmpty(str)) {
                            String str2 = map.get(str);
                            if (!TextUtils.isEmpty(str2)) {
                                map2.put("custom_" + str, str2);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                c.c().a(IronSourceLogger.IronSourceTag.NATIVE, ":convertCustomParams()", e2);
            }
        }
        return map2;
    }

    public static SupersonicConfig getConfigObj() {
        if (mInstance == null) {
            mInstance = new SupersonicConfig();
        }
        return mInstance;
    }

    public boolean getClientSideCallbacks() {
        p pVar = this.mProviderSettings;
        if (pVar == null || pVar.k() == null || !this.mProviderSettings.k().has("useClientSideCallbacks")) {
            return false;
        }
        return this.mProviderSettings.k().optBoolean("useClientSideCallbacks", false);
    }

    Map<String, String> getOfferwallCustomParams() {
        return this.mOfferwallCustomParams;
    }

    Map<String, String> getRewardedVideoCustomParams() {
        return this.mRewardedVideoCustomParams;
    }

    public void setCampaignId(String str) {
        this.mProviderSettings.c("campaignId", str);
    }

    public void setClientSideCallbacks(boolean z) {
        this.mProviderSettings.c("useClientSideCallbacks", String.valueOf(z));
    }

    public void setCustomControllerUrl(String str) {
        this.mProviderSettings.c("controllerUrl", str);
        this.mProviderSettings.b("controllerUrl", str);
        this.mProviderSettings.a("controllerUrl", str);
    }

    public void setDebugMode(int i) {
        this.mProviderSettings.c("debugMode", Integer.valueOf(i));
        this.mProviderSettings.b("debugMode", Integer.valueOf(i));
        this.mProviderSettings.a("debugMode", Integer.valueOf(i));
    }

    public void setLanguage(String str) {
        this.mProviderSettings.c(au.M, str);
        this.mProviderSettings.b(au.M, str);
    }

    public void setOfferwallCustomParams(Map<String, String> map) {
        this.mOfferwallCustomParams = convertCustomParams(map);
    }

    public void setRewardedVideoCustomParams(Map<String, String> map) {
        this.mRewardedVideoCustomParams = convertCustomParams(map);
    }
}
