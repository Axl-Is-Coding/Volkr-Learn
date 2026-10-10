package com.sandboxol.ads.iron;

import android.app.Activity;
import com.ironsource.mediationsdk.IronSource;
import com.sandboxol.common.interfaces.AdsAdapter;
import com.sandboxol.common.interfaces.InterstitialAdapter;
import com.sandboxol.common.interfaces.RewardVideoAdapter;

/* JADX INFO: compiled from: AdsIronUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends AdsAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f16034a;

    public static c a() {
        if (f16034a == null) {
            f16034a = new c();
        }
        return f16034a;
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public void initIronSource(Activity activity, boolean z, String str) {
        super.initIronSource(activity, z, str);
        IronSource.a(activity, str, IronSource.AD_UNIT.REWARDED_VIDEO);
        IronSource.a(activity, str, IronSource.AD_UNIT.INTERSTITIAL);
        IronSource.a(activity, true);
        if (z) {
            com.ironsource.mediationsdk.d.b.a(activity);
        }
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public boolean isIronInterstitialLoad() {
        return IronSource.a();
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public boolean isIronRewardVideoLoad() {
        return IronSource.b();
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public void loadIronInterstitialAd() {
        IronSource.c();
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public void onPause(Activity activity) {
        super.onPause(activity);
        IronSource.a(activity);
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public void onResume(Activity activity) {
        super.onResume(activity);
        IronSource.b(activity);
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public void setIronInterstitialListener(InterstitialAdapter interstitialAdapter) {
        super.setIronInterstitialListener(interstitialAdapter);
        IronSource.a(new b(this, interstitialAdapter));
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public void setIronRewardVideoListener(RewardVideoAdapter rewardVideoAdapter) {
        super.setIronRewardVideoListener(rewardVideoAdapter);
        IronSource.a(new a(this, rewardVideoAdapter));
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public void showIronInterstitialAd() {
        super.showIronInterstitialAd();
        if (IronSource.a()) {
            IronSource.d();
        }
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public void showIronRewardVideo() {
        super.showIronRewardVideo();
        if (IronSource.b()) {
            IronSource.e();
        }
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public void showIronInterstitialAd(String str) {
        super.showIronInterstitialAd(str);
        if (IronSource.a()) {
            IronSource.a(str);
        }
    }

    @Override // com.sandboxol.common.interfaces.AdsAdapter, com.sandboxol.common.interfaces.IAdsIronSourceListener
    public void showIronRewardVideo(String str) {
        super.showIronRewardVideo(str);
        if (IronSource.b()) {
            IronSource.b(str);
        }
    }
}
