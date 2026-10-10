package com.sandboxol.oversea.service;

import android.app.Activity;
import android.content.Context;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.sandboxol.adsoversea.AdsBuilder;
import com.sandboxol.adsoversea.AdsControl;
import com.sandboxol.adsoversea.config.AdsEventConstant;
import com.sandboxol.adsoversea.config.AdsSourcesType;
import com.sandboxol.adsoversea.config.SharedConstant;
import com.sandboxol.center.router.moduleApi.IAdsService;
import com.sandboxol.center.router.moduleInfo.ads.AdsInfo;
import com.sandboxol.center.router.module_application.BaseModuleApp;
import com.sandboxol.center.router.path.RouterServicePath;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.interfaces.RewardVideoAdapter;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.common.utils.SharedUtils;

/* JADX INFO: loaded from: classes4.dex */
@Route(path = RouterServicePath.EventAds.ADS_SERVICE)
public class AdsService implements IAdsService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static AdsInfo f18835a = new AdsInfo();

    private void a(String str, int i) {
        f18835a.setNowType(i);
        AdsControl.newInstant().showRewardVideo(str);
        ReportDataAdapter.onEvent(BaseApplication.getContext(), AdsEventConstant.CLICK_REWARD_AD, str);
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public void clickToShowVideo(Context context, int i) {
        String str;
        String str2;
        if (i == 1) {
            str = SharedConstant.SHOW_ADS_DATE;
            str2 = SharedConstant.SHOW_ADS_TIMES;
        } else if (i != 2) {
            if (i != 3 && (i == 4 || i != 5)) {
                return;
            }
            str = SharedConstant.SHOW_ADS_DATE;
            str2 = SharedConstant.SHOW_ADS_TIMES;
        } else {
            str = SharedConstant.DRESS_SHOW_ADS_DATE;
            str2 = SharedConstant.DRESS_SHOW_ADS_TIMES;
        }
        SharedUtils.putInt(context, str2, SharedUtils.getInt(context, str2) + 1);
        SharedUtils.putLong(context, str, System.currentTimeMillis());
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public AdsInfo getAdsInfo() {
        if (f18835a == null) {
            f18835a = new AdsInfo();
        }
        return f18835a;
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public void init(Activity activity) {
        AdsControl.newInstant().init(activity, new AdsBuilder().setAdsSource(AdsSourcesType.IRONSOURCE).isDebug(false).setAdsKey(BaseModuleApp.getBaseModuleApp().getMetaDataIronsourceKey()));
    }

    @Override // com.sandboxol.center.router.moduleApi.IBaseService, com.alibaba.android.arouter.facade.template.IProvider
    public /* synthetic */ void init(Context context) {
        com.sandboxol.center.router.moduleApi.a.a(this, context);
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public boolean isShowIronAds(Context context, int i, int i2) {
        String str;
        String str2;
        String str3;
        if (!isVideoLoaded()) {
            return false;
        }
        if (i2 == 1) {
            str = SharedConstant.SHOW_ADS_DATE;
            str2 = SharedConstant.SHOW_ADS_TIMES;
            str3 = "last.time.watch.ads";
        } else if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    return true;
                }
                if (i2 != 5) {
                    return false;
                }
            }
            str = SharedConstant.SHOW_ADS_DATE;
            str2 = SharedConstant.SHOW_ADS_TIMES;
            str3 = "last.time.watch.ads";
        } else {
            str = SharedConstant.DRESS_SHOW_ADS_DATE;
            str2 = SharedConstant.DRESS_SHOW_ADS_TIMES;
            str3 = SharedConstant.DRESS_LAST_TIME_WATCH_ADS;
        }
        if (DateUtils.date2TimeStamp(DateUtils.timeStamp2Date(System.currentTimeMillis(), "yyyy-MM-dd"), "yyyy-MM-dd") - DateUtils.date2TimeStamp(DateUtils.timeStamp2Date(SharedUtils.getLong(context, str), "yyyy-MM-dd"), "yyyy-MM-dd") >= 86400000) {
            SharedUtils.putInt(context, str2, 0);
        }
        return SharedUtils.getInt(context, str2) < i && System.currentTimeMillis() - SharedUtils.getLong(context, str3) > 0;
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public boolean isVideoLoaded() {
        return AdsControl.newInstant().isVideoLoad();
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public void onPause(Activity activity) {
        AdsControl.newInstant().onPause(activity);
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public void onResume(Activity activity) {
        AdsControl.newInstant().onResume(activity);
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public void setRewardedVideoListener(Activity activity, RewardVideoAdapter rewardVideoAdapter) {
        AdsControl.newInstant().setRewardedVideoListener(rewardVideoAdapter);
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public void showRewardVideo(int i) {
        showRewardVideo(i, "");
        ReportDataAdapter.onEvent(BaseApplication.getContext(), AdsEventConstant.CLICK_REWARD_AD, String.valueOf(i));
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public void showRewardVideoByPlacement(Activity activity, int i, String str, String str2) {
        f18835a.setGameIntType(i);
        f18835a.setGameParams(str);
        if (str2.equals("ResultPanelWatchAd")) {
            a(str2, 8);
        } else {
            a(str2, 7);
        }
        ReportDataAdapter.onEvent(activity, AdsEventConstant.REWARD_AD_SHOW, String.valueOf(f18835a.getNowType()));
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public void showRewardVideo(int i, String str) {
        f18835a.setNowType(i);
        f18835a.setGameId(str);
        if (isVideoLoaded()) {
            AdsControl.newInstant().showRewardVideo();
        }
        ReportDataAdapter.onEvent(BaseApplication.getContext(), AdsEventConstant.CLICK_REWARD_AD, String.valueOf(i));
    }

    @Override // com.sandboxol.center.router.moduleApi.IAdsService
    public void showRewardVideo(int i, long j) {
        f18835a.setNowType(i);
        f18835a.setNextQty(j);
        if (isVideoLoaded()) {
            AdsControl.newInstant().showRewardVideo();
        }
        ReportDataAdapter.onEvent(BaseApplication.getContext(), AdsEventConstant.CLICK_REWARD_AD, String.valueOf(i));
    }
}
