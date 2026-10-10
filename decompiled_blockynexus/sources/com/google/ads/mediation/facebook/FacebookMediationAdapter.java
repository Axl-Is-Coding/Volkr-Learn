package com.google.ads.mediation.facebook;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.RewardedVideoAdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.ads.rewarded.RewardItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class FacebookMediationAdapter extends Adapter implements MediationRewardedAd {
    static final String PLACEMENT_PARAMETER = "pubid";
    static final String TAG = FacebookAdapter.class.getSimpleName();
    private MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mAdLoadCallback;
    private MediationRewardedAdCallback mRewardedAdCallback;
    private RewardedVideoAd mRewardedVideoAd;

    private class a implements RewardItem {
        private a() {
        }

        @Override // com.google.android.gms.ads.rewarded.RewardItem
        public int getAmount() {
            return 1;
        }

        @Override // com.google.android.gms.ads.rewarded.RewardItem
        public String getType() {
            return "";
        }

        /* synthetic */ a(FacebookMediationAdapter facebookMediationAdapter, i iVar) {
            this();
        }
    }

    private class b implements RewardedVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> f12584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private RewardedVideoAd f12585b;

        /* synthetic */ b(FacebookMediationAdapter facebookMediationAdapter, RewardedVideoAd rewardedVideoAd, MediationAdLoadCallback mediationAdLoadCallback, i iVar) {
            this(rewardedVideoAd, mediationAdLoadCallback);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            if (FacebookMediationAdapter.this.mRewardedAdCallback != null) {
                FacebookMediationAdapter.this.mRewardedAdCallback.reportAdClicked();
            }
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.f12584a;
            if (mediationAdLoadCallback != null) {
                FacebookMediationAdapter facebookMediationAdapter = FacebookMediationAdapter.this;
                facebookMediationAdapter.mRewardedAdCallback = mediationAdLoadCallback.onSuccess(facebookMediationAdapter);
            }
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookMediationAdapter.TAG, "Failed to load ad from Facebook: " + errorMessage);
            }
            MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.f12584a;
            if (mediationAdLoadCallback != null) {
                mediationAdLoadCallback.onFailure(errorMessage);
            }
            this.f12585b.destroy();
        }

        @Override // com.facebook.ads.RewardedVideoAdListener, com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
            if (FacebookMediationAdapter.this.mRewardedAdCallback != null) {
                FacebookMediationAdapter.this.mRewardedAdCallback.reportAdImpression();
            }
        }

        @Override // com.facebook.ads.RewardedVideoAdListener
        public void onRewardedVideoClosed() {
            if (FacebookMediationAdapter.this.mRewardedAdCallback != null) {
                FacebookMediationAdapter.this.mRewardedAdCallback.onAdClosed();
            }
            this.f12585b.destroy();
        }

        @Override // com.facebook.ads.RewardedVideoAdListener
        public void onRewardedVideoCompleted() {
            if (FacebookMediationAdapter.this.mRewardedAdCallback != null) {
                FacebookMediationAdapter.this.mRewardedAdCallback.onVideoComplete();
                FacebookMediationAdapter.this.mRewardedAdCallback.onUserEarnedReward(new a(FacebookMediationAdapter.this, null));
            }
        }

        private b(RewardedVideoAd rewardedVideoAd, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
            this.f12585b = rewardedVideoAd;
            this.f12584a = mediationAdLoadCallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndLoadRewardedVideo(Context context, String str) {
        AdSettings.setMediationService("ADMOB_" + MobileAds.getVersionString());
        this.mRewardedVideoAd = new RewardedVideoAd(context, str);
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        rewardedVideoAd.setAdListener(new b(this, rewardedVideoAd, this.mAdLoadCallback, null));
        this.mRewardedVideoAd.loadAd(true);
    }

    static boolean isValidRequestParameters(Context context, Bundle bundle) {
        if (context == null) {
            Log.w(TAG, "Failed to request ad, Context is null.");
            return false;
        }
        if (bundle == null) {
            Log.w(TAG, "Failed to request ad, serverParameters is null.");
            return false;
        }
        if (!TextUtils.isEmpty(bundle.getString("pubid"))) {
            return true;
        }
        Log.w(TAG, "Failed to request ad, placementId is null or empty.");
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getSDKVersionInfo() {
        String[] strArrSplit = "5.2.0".split("\\.");
        return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]));
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public VersionInfo getVersionInfo() {
        String[] strArrSplit = "5.2.0.1".split("\\.");
        return new VersionInfo(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), (Integer.parseInt(strArrSplit[2]) * 100) + Integer.parseInt(strArrSplit[3]));
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void initialize(Context context, InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        if (context == null) {
            initializationCompleteCallback.onInitializationFailed("Initialization Failed: Context is null.");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<MediationConfiguration> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next().getServerParameters().getString("pubid");
            if (!TextUtils.isEmpty(string)) {
                arrayList.add(string);
            }
        }
        if (arrayList.isEmpty()) {
            initializationCompleteCallback.onInitializationFailed("Initialization failed: No placement IDs found");
        } else {
            h.a().a(context, arrayList, new i(this, initializationCompleteCallback));
        }
    }

    @Override // com.google.android.gms.ads.mediation.Adapter
    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Context context = mediationRewardedAdConfiguration.getContext();
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        if (!isValidRequestParameters(context, serverParameters)) {
            mediationAdLoadCallback.onFailure("Invalid request");
            return;
        }
        this.mAdLoadCallback = mediationAdLoadCallback;
        String string = serverParameters.getString("pubid");
        h.a().a(context, string, new j(this, context, string));
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(Context context) {
        RewardedVideoAd rewardedVideoAd = this.mRewardedVideoAd;
        if (rewardedVideoAd == null || !rewardedVideoAd.isAdLoaded()) {
            MediationRewardedAdCallback mediationRewardedAdCallback = this.mRewardedAdCallback;
            if (mediationRewardedAdCallback != null) {
                mediationRewardedAdCallback.onAdFailedToShow("No ads to show.");
                return;
            }
            return;
        }
        this.mRewardedVideoAd.show();
        MediationRewardedAdCallback mediationRewardedAdCallback2 = this.mRewardedAdCallback;
        if (mediationRewardedAdCallback2 != null) {
            mediationRewardedAdCallback2.onAdOpened();
            this.mRewardedAdCallback.onVideoStart();
        }
    }
}
