package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface TTRewardVideoAd {

    public interface RewardAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onRewardVerify(boolean z, int i, String str);

        void onSkippedVideo();

        void onVideoComplete();

        void onVideoError();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    int getRewardVideoAdType();

    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    void setShowDownLoadBar(boolean z);

    void showRewardVideoAd(Activity activity);

    void showRewardVideoAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str);
}
