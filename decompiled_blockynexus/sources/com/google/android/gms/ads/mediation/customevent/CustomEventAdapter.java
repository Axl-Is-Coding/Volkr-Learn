package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbbq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdkWithMembers
@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {

    @VisibleForTesting
    private static final AdError zzesc = new AdError(0, "Could not instantiate custom event adapter", MobileAds.ERROR_DOMAIN);

    @VisibleForTesting
    private CustomEventBanner zzesd;

    @VisibleForTesting
    private CustomEventInterstitial zzese;

    @VisibleForTesting
    private CustomEventNative zzesf;
    private View zzne;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view) {
        this.zzne = view;
    }

    private static <T> T zzam(String str) {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            String message = th.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(message).length());
            sb.append("Could not instantiate custom event adapter: ");
            sb.append(str);
            sb.append(". ");
            sb.append(message);
            zzbbq.zzfe(sb.toString());
            return null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final View getBannerView() {
        return this.zzne;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        CustomEventBanner customEventBanner = this.zzesd;
        if (customEventBanner != null) {
            customEventBanner.onDestroy();
        }
        CustomEventInterstitial customEventInterstitial = this.zzese;
        if (customEventInterstitial != null) {
            customEventInterstitial.onDestroy();
        }
        CustomEventNative customEventNative = this.zzesf;
        if (customEventNative != null) {
            customEventNative.onDestroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        CustomEventBanner customEventBanner = this.zzesd;
        if (customEventBanner != null) {
            customEventBanner.onPause();
        }
        CustomEventInterstitial customEventInterstitial = this.zzese;
        if (customEventInterstitial != null) {
            customEventInterstitial.onPause();
        }
        CustomEventNative customEventNative = this.zzesf;
        if (customEventNative != null) {
            customEventNative.onPause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        CustomEventBanner customEventBanner = this.zzesd;
        if (customEventBanner != null) {
            customEventBanner.onResume();
        }
        CustomEventInterstitial customEventInterstitial = this.zzese;
        if (customEventInterstitial != null) {
            customEventInterstitial.onResume();
        }
        CustomEventNative customEventNative = this.zzesf;
        if (customEventNative != null) {
            customEventNative.onResume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public final void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzesd = (CustomEventBanner) zzam(bundle.getString("class_name"));
        if (this.zzesd == null) {
            mediationBannerListener.onAdFailedToLoad(this, zzesc);
        } else {
            this.zzesd.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzese = (CustomEventInterstitial) zzam(bundle.getString("class_name"));
        if (this.zzese == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, zzesc);
        } else {
            this.zzese.requestInterstitialAd(context, new zzc(this, mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.zzesf = (CustomEventNative) zzam(bundle.getString("class_name"));
        if (this.zzesf == null) {
            mediationNativeListener.onAdFailedToLoad(this, zzesc);
        } else {
            this.zzesf.requestNativeAd(context, new zzb(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        this.zzese.showInterstitial();
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @VisibleForTesting
    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzesa;
        private final MediationBannerListener zzesb;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzesa = customEventAdapter;
            this.zzesb = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzbbq.zzef("Custom event adapter called onAdClicked.");
            this.zzesb.onAdClicked(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzbbq.zzef("Custom event adapter called onAdClosed.");
            this.zzesb.onAdClosed(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzbbq.zzef("Custom event adapter called onAdFailedToLoad.");
            this.zzesb.onAdFailedToLoad(this.zzesa, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzbbq.zzef("Custom event adapter called onAdLeftApplication.");
            this.zzesb.onAdLeftApplication(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventBannerListener
        public final void onAdLoaded(View view) {
            zzbbq.zzef("Custom event adapter called onAdLoaded.");
            this.zzesa.zza(view);
            this.zzesb.onAdLoaded(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzbbq.zzef("Custom event adapter called onAdOpened.");
            this.zzesb.onAdOpened(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(AdError adError) {
            zzbbq.zzef("Custom event adapter called onAdFailedToLoad.");
            this.zzesb.onAdFailedToLoad(this.zzesa, adError);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @VisibleForTesting
    static class zzb implements CustomEventNativeListener {
        private final CustomEventAdapter zzesa;
        private final MediationNativeListener zzesg;

        public zzb(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzesa = customEventAdapter;
            this.zzesg = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzbbq.zzef("Custom event adapter called onAdClicked.");
            this.zzesg.onAdClicked(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzbbq.zzef("Custom event adapter called onAdClosed.");
            this.zzesg.onAdClosed(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzbbq.zzef("Custom event adapter called onAdFailedToLoad.");
            this.zzesg.onAdFailedToLoad(this.zzesa, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdImpression() {
            zzbbq.zzef("Custom event adapter called onAdImpression.");
            this.zzesg.onAdImpression(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzbbq.zzef("Custom event adapter called onAdLeftApplication.");
            this.zzesg.onAdLeftApplication(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdLoaded(NativeAdMapper nativeAdMapper) {
            zzbbq.zzef("Custom event adapter called onAdLoaded.");
            this.zzesg.onAdLoaded(this.zzesa, nativeAdMapper);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzbbq.zzef("Custom event adapter called onAdOpened.");
            this.zzesg.onAdOpened(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(AdError adError) {
            zzbbq.zzef("Custom event adapter called onAdFailedToLoad.");
            this.zzesg.onAdFailedToLoad(this.zzesa, adError);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventNativeListener
        public final void onAdLoaded(UnifiedNativeAdMapper unifiedNativeAdMapper) {
            zzbbq.zzef("Custom event adapter called onAdLoaded.");
            this.zzesg.onAdLoaded(this.zzesa, unifiedNativeAdMapper);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @VisibleForTesting
    class zzc implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzesa;
        private final MediationInterstitialListener zzesh;

        public zzc(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzesa = customEventAdapter;
            this.zzesh = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClicked() {
            zzbbq.zzef("Custom event adapter called onAdClicked.");
            this.zzesh.onAdClicked(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdClosed() {
            zzbbq.zzef("Custom event adapter called onAdClosed.");
            this.zzesh.onAdClosed(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(int i) {
            zzbbq.zzef("Custom event adapter called onFailedToReceiveAd.");
            this.zzesh.onAdFailedToLoad(this.zzesa, i);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdLeftApplication() {
            zzbbq.zzef("Custom event adapter called onAdLeftApplication.");
            this.zzesh.onAdLeftApplication(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventInterstitialListener
        public final void onAdLoaded() {
            zzbbq.zzef("Custom event adapter called onReceivedAd.");
            this.zzesh.onAdLoaded(CustomEventAdapter.this);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdOpened() {
            zzbbq.zzef("Custom event adapter called onAdOpened.");
            this.zzesh.onAdOpened(this.zzesa);
        }

        @Override // com.google.android.gms.ads.mediation.customevent.CustomEventListener
        public final void onAdFailedToLoad(AdError adError) {
            zzbbq.zzef("Custom event adapter called onFailedToReceiveAd.");
            this.zzesh.onAdFailedToLoad(this.zzesa, adError);
        }
    }
}
