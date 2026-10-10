package com.sandboxol.center.router.moduleApi;

import android.app.Activity;
import android.content.Context;
import com.sandboxol.center.router.moduleInfo.ads.AdsInfo;
import com.sandboxol.common.interfaces.RewardVideoAdapter;

/* JADX INFO: loaded from: classes3.dex */
public interface IAdsService extends IBaseService {
    void clickToShowVideo(Context context, int i);

    AdsInfo getAdsInfo();

    void init(Activity activity);

    boolean isShowIronAds(Context context, int i, int i2);

    boolean isVideoLoaded();

    void onPause(Activity activity);

    void onResume(Activity activity);

    void setRewardedVideoListener(Activity activity, RewardVideoAdapter rewardVideoAdapter);

    void showRewardVideo(int i);

    void showRewardVideo(int i, long j);

    void showRewardVideo(int i, String str);

    void showRewardVideoByPlacement(Activity activity, int i, String str, String str2);
}
