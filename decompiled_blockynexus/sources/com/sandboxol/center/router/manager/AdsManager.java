package com.sandboxol.center.router.manager;

import android.app.Activity;
import android.content.Context;
import com.sandboxol.center.router.RouteServiceManager;
import com.sandboxol.center.router.moduleApi.IAdsService;
import com.sandboxol.center.router.moduleInfo.ads.AdsInfo;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.interfaces.RewardVideoAdapter;

/* JADX INFO: loaded from: classes3.dex */
public class AdsManager {
    public static final int MAIN_CAN_VIEW_ADS_COUNT = 2;
    private static IAdsService iAdsService = (IAdsService) RouteServiceManager.provide(RouterServicePath.EventAds.ADS_SERVICE);

    public static void clickToShowVideo(Context context, int i) {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            iAdsService2.clickToShowVideo(context, i);
        }
    }

    public static AdsInfo getAdsInfo() {
        IAdsService iAdsService2 = iAdsService;
        return iAdsService2 != null ? iAdsService2.getAdsInfo() : new AdsInfo();
    }

    public static void init(Activity activity) {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            iAdsService2.init(activity);
        }
    }

    public static boolean isShowIronAds(Context context, int i, int i2) {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            return iAdsService2.isShowIronAds(context, i, i2);
        }
        return false;
    }

    public static boolean isVideoLoaded() {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            return iAdsService2.isVideoLoaded();
        }
        return false;
    }

    public static void onPause(Activity activity) {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            iAdsService2.onPause(activity);
        }
    }

    public static void onResume(Activity activity) {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            iAdsService2.onResume(activity);
        }
    }

    public static void setRewardedVideoListener(Activity activity, RewardVideoAdapter rewardVideoAdapter) {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            iAdsService2.setRewardedVideoListener(activity, rewardVideoAdapter);
        }
    }

    public static void showRewardVideo(int i) {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            iAdsService2.showRewardVideo(i);
        }
    }

    public static void showRewardVideoByPlacement(Activity activity, int i, String str, String str2) {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            iAdsService2.showRewardVideoByPlacement(activity, i, str, str2);
        }
    }

    public static void showRewardVideo(int i, String str) {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            iAdsService2.showRewardVideo(i, str);
        }
    }

    public static void showRewardVideo(int i, long j) {
        IAdsService iAdsService2 = iAdsService;
        if (iAdsService2 != null) {
            iAdsService2.showRewardVideo(i, j);
        }
    }
}
