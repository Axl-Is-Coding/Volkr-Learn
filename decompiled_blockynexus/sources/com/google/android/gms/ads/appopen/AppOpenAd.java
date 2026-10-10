package com.google.android.gms.ads.appopen;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzsm;
import com.google.android.gms.internal.ads.zzsr;
import com.google.android.gms.internal.ads.zzxc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AppOpenAd {
    public static final int APP_OPEN_AD_ORIENTATION_LANDSCAPE = 2;
    public static final int APP_OPEN_AD_ORIENTATION_PORTRAIT = 1;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static abstract class AppOpenAdLoadCallback {
        @Deprecated
        public void onAppOpenAdFailedToLoad(int i) {
        }

        public void onAppOpenAdFailedToLoad(LoadAdError loadAdError) {
        }

        public void onAppOpenAdLoaded(AppOpenAd appOpenAd) {
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public @interface AppOpenAdOrientation {
    }

    public static void load(Context context, String str, AdRequest adRequest, @AppOpenAdOrientation int i, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "adUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        new zzsr(context, str, adRequest.zzdr(), i, appOpenAdLoadCallback).zzmu();
    }

    public abstract ResponseInfo getResponseInfo();

    public abstract void show(Activity activity, FullScreenContentCallback fullScreenContentCallback);

    protected abstract void zza(zzsm zzsmVar);

    protected abstract zzxc zzdw();

    public static void load(Context context, String str, PublisherAdRequest publisherAdRequest, @AppOpenAdOrientation int i, AppOpenAdLoadCallback appOpenAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "adUnitId cannot be null.");
        Preconditions.checkNotNull(publisherAdRequest, "PublisherAdRequest cannot be null.");
        new zzsr(context, str, publisherAdRequest.zzdr(), i, appOpenAdLoadCallback).zzmu();
    }
}
