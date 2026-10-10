package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAdViewHolder;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdView;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbiy;
import com.google.android.gms.internal.ads.zzux;
import com.google.android.gms.internal.ads.zzwm;
import com.google.android.gms.internal.ads.zzyo;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractAdViewAdapter implements com.google.android.gms.ads.mediation.MediationBannerAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, zza, MediationRewardedVideoAdAdapter, zzbiy {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdView zzmi;
    private InterstitialAd zzmj;
    private AdLoader zzmk;
    private Context zzml;
    private InterstitialAd zzmm;
    private MediationRewardedVideoAdListener zzmn;

    @VisibleForTesting
    private final RewardedVideoAdListener zzmo = new com.google.ads.mediation.f(this);

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static class a extends NativeContentAdMapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NativeContentAd f12542a;

        public a(NativeContentAd nativeContentAd) {
            this.f12542a = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeContentAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f12542a);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbnu.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.f12542a);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static class b extends NativeAppInstallAdMapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final NativeAppInstallAd f12543a;

        public b(NativeAppInstallAd nativeAppInstallAd) {
            this.f12543a = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public final void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.f12543a);
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbnu.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.f12543a);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @VisibleForTesting
    static final class c extends AdListener implements AppEventListener, zzux {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        private final AbstractAdViewAdapter f12544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @VisibleForTesting
        private final com.google.android.gms.ads.mediation.MediationBannerListener f12545b;

        public c(AbstractAdViewAdapter abstractAdViewAdapter, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener) {
            this.f12544a = abstractAdViewAdapter;
            this.f12545b = mediationBannerListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzux
        public final void onAdClicked() {
            this.f12545b.onAdClicked(this.f12544a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.f12545b.onAdClosed(this.f12544a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.f12545b.onAdFailedToLoad(this.f12544a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.f12545b.onAdLeftApplication(this.f12544a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            this.f12545b.onAdLoaded(this.f12544a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.f12545b.onAdOpened(this.f12544a);
        }

        @Override // com.google.android.gms.ads.doubleclick.AppEventListener
        public final void onAppEvent(String str, String str2) {
            this.f12545b.zza(this.f12544a, str, str2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static class d extends UnifiedNativeAdMapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final UnifiedNativeAd f12546a;

        public d(UnifiedNativeAd unifiedNativeAd) {
            this.f12546a = unifiedNativeAd;
            setHeadline(unifiedNativeAd.getHeadline());
            setImages(unifiedNativeAd.getImages());
            setBody(unifiedNativeAd.getBody());
            setIcon(unifiedNativeAd.getIcon());
            setCallToAction(unifiedNativeAd.getCallToAction());
            setAdvertiser(unifiedNativeAd.getAdvertiser());
            setStarRating(unifiedNativeAd.getStarRating());
            setStore(unifiedNativeAd.getStore());
            setPrice(unifiedNativeAd.getPrice());
            zzn(unifiedNativeAd.zzjx());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(unifiedNativeAd.getVideoController());
        }

        @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
        public final void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            if (view instanceof UnifiedNativeAdView) {
                ((UnifiedNativeAdView) view).setNativeAd(this.f12546a);
                return;
            }
            NativeAdViewHolder nativeAdViewHolder = NativeAdViewHolder.zzbnu.get(view);
            if (nativeAdViewHolder != null) {
                nativeAdViewHolder.setNativeAd(this.f12546a);
            }
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @VisibleForTesting
    static final class e extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener, UnifiedNativeAd.OnUnifiedNativeAdLoadedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        private final AbstractAdViewAdapter f12547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @VisibleForTesting
        private final MediationNativeListener f12548b;

        public e(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.f12547a = abstractAdViewAdapter;
            this.f12548b = mediationNativeListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzux
        public final void onAdClicked() {
            this.f12548b.onAdClicked(this.f12547a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.f12548b.onAdClosed(this.f12547a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.f12548b.onAdFailedToLoad(this.f12547a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdImpression() {
            this.f12548b.onAdImpression(this.f12547a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.f12548b.onAdLeftApplication(this.f12547a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.f12548b.onAdOpened(this.f12547a);
        }

        @Override // com.google.android.gms.ads.formats.NativeAppInstallAd.OnAppInstallAdLoadedListener
        public final void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.f12548b.onAdLoaded(this.f12547a, new b(nativeAppInstallAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeContentAd.OnContentAdLoadedListener
        public final void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.f12548b.onAdLoaded(this.f12547a, new a(nativeContentAd));
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomClickListener
        public final void onCustomClick(NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
            this.f12548b.zza(this.f12547a, nativeCustomTemplateAd, str);
        }

        @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener
        public final void onCustomTemplateAdLoaded(NativeCustomTemplateAd nativeCustomTemplateAd) {
            this.f12548b.zza(this.f12547a, nativeCustomTemplateAd);
        }

        @Override // com.google.android.gms.ads.formats.UnifiedNativeAd.OnUnifiedNativeAdLoadedListener
        public final void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
            this.f12548b.onAdLoaded(this.f12547a, new d(unifiedNativeAd));
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @VisibleForTesting
    static final class f extends AdListener implements zzux {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        private final AbstractAdViewAdapter f12549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @VisibleForTesting
        private final MediationInterstitialListener f12550b;

        public f(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f12549a = abstractAdViewAdapter;
            this.f12550b = mediationInterstitialListener;
        }

        @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.internal.ads.zzux
        public final void onAdClicked() {
            this.f12550b.onAdClicked(this.f12549a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdClosed() {
            this.f12550b.onAdClosed(this.f12549a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdFailedToLoad(int i) {
            this.f12550b.onAdFailedToLoad(this.f12549a, i);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLeftApplication() {
            this.f12550b.onAdLeftApplication(this.f12549a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdLoaded() {
            this.f12550b.onAdLoaded(this.f12549a);
        }

        @Override // com.google.android.gms.ads.AdListener
        public final void onAdOpened() {
            this.f12550b.onAdOpened(this.f12549a);
        }
    }

    private final AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            Iterator<String> it = keywords.iterator();
            while (it.hasNext()) {
                builder.addKeyword(it.next());
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            zzwm.zzpt();
            builder.addTestDevice(zzbbg.zzbn(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.zzmi;
    }

    @Override // com.google.android.gms.internal.ads.zzbiy
    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzdv(1).zzadg();
    }

    @Override // com.google.android.gms.ads.mediation.zza
    public zzyo getVideoController() {
        VideoController videoController;
        AdView adView = this.zzmi;
        if (adView == null || (videoController = adView.getVideoController()) == null) {
            return null;
        }
        return videoController.zzdv();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzml = context.getApplicationContext();
        this.zzmn = mediationRewardedVideoAdListener;
        this.zzmn.onInitializationSucceeded(this);
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public boolean isInitialized() {
        return this.zzmn != null;
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        Context context = this.zzml;
        if (context == null || this.zzmn == null) {
            zzbbq.zzfc("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzmm = new InterstitialAd(context);
        this.zzmm.zzd(true);
        this.zzmm.setAdUnitId(getAdUnitId(bundle));
        this.zzmm.setRewardedVideoAdListener(this.zzmo);
        this.zzmm.setAdMetadataListener(new com.google.ads.mediation.e(this));
        this.zzmm.loadAd(zza(this.zzml, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        AdView adView = this.zzmi;
        if (adView != null) {
            adView.destroy();
            this.zzmi = null;
        }
        if (this.zzmj != null) {
            this.zzmj = null;
        }
        if (this.zzmk != null) {
            this.zzmk = null;
        }
        if (this.zzmm != null) {
            this.zzmm = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener
    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.zzmj;
        if (interstitialAd != null) {
            interstitialAd.setImmersiveMode(z);
        }
        InterstitialAd interstitialAd2 = this.zzmm;
        if (interstitialAd2 != null) {
            interstitialAd2.setImmersiveMode(z);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
        AdView adView = this.zzmi;
        if (adView != null) {
            adView.pause();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
        AdView adView = this.zzmi;
        if (adView != null) {
            adView.resume();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, com.google.android.gms.ads.mediation.MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzmi = new AdView(context);
        this.zzmi.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzmi.setAdUnitId(getAdUnitId(bundle));
        this.zzmi.setAdListener(new c(this, mediationBannerListener));
        this.zzmi.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzmj = new InterstitialAd(context);
        this.zzmj.setAdUnitId(getAdUnitId(bundle));
        this.zzmj.setAdListener(new f(this, mediationInterstitialListener));
        this.zzmj.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        e eVar = new e(this, mediationNativeListener);
        AdLoader.Builder builderWithAdListener = new AdLoader.Builder(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(eVar);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            builderWithAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isUnifiedNativeAdRequested()) {
            builderWithAdListener.forUnifiedNativeAd(eVar);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            builderWithAdListener.forAppInstallAd(eVar);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            builderWithAdListener.forContentAd(eVar);
        }
        if (nativeMediationAdRequest.zzuj()) {
            for (String str : nativeMediationAdRequest.zzuk().keySet()) {
                builderWithAdListener.forCustomTemplateAd(str, eVar, nativeMediationAdRequest.zzuk().get(str).booleanValue() ? eVar : null);
            }
        }
        this.zzmk = builderWithAdListener.build();
        this.zzmk.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        this.zzmj.show();
    }

    @Override // com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter
    public void showVideo() {
        this.zzmm.show();
    }

    protected abstract Bundle zza(Bundle bundle, Bundle bundle2);

    static /* synthetic */ InterstitialAd zza(AbstractAdViewAdapter abstractAdViewAdapter, InterstitialAd interstitialAd) {
        abstractAdViewAdapter.zzmm = null;
        return null;
    }
}
