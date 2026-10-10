package com.google.ads.mediation.facebook;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Keep;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class FacebookAdapter extends FacebookMediationAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    public static final String KEY_ID = "id";
    public static final String KEY_SOCIAL_CONTEXT_ASSET = "social_context";
    private static final int MAX_STAR_RATING = 5;
    private AdView mAdView;
    private MediationBannerListener mBannerListener;
    private InterstitialAd mInterstitialAd;
    private MediationInterstitialListener mInterstitialListener;
    private boolean mIsImpressionRecorded;
    private MediaView mMediaView;
    private NativeAd mNativeAd;
    private MediationNativeListener mNativeListener;
    private RelativeLayout mWrappedAdView;

    private class b implements AdListener {
        /* synthetic */ b(FacebookAdapter facebookAdapter, com.google.ads.mediation.facebook.a aVar) {
            this();
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            FacebookAdapter.this.mBannerListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mBannerListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mBannerListener.onAdLeftApplication(FacebookAdapter.this);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            FacebookAdapter.this.mBannerListener.onAdLoaded(FacebookAdapter.this);
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookMediationAdapter.TAG, errorMessage);
            }
            MediationBannerListener mediationBannerListener = FacebookAdapter.this.mBannerListener;
            FacebookAdapter facebookAdapter = FacebookAdapter.this;
            mediationBannerListener.onAdFailedToLoad(facebookAdapter, facebookAdapter.convertErrorCode(adError));
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
        }

        private b() {
        }
    }

    private class c extends NativeAd.Image {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Drawable f12573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Uri f12574b;

        public c(Uri uri) {
            this.f12574b = uri;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public Drawable getDrawable() {
            return this.f12573a;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public double getScale() {
            return 1.0d;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public Uri getUri() {
            return this.f12574b;
        }
    }

    private class d implements InterstitialAdListener {
        /* synthetic */ d(FacebookAdapter facebookAdapter, com.google.ads.mediation.facebook.a aVar) {
            this();
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mInterstitialListener.onAdLeftApplication(FacebookAdapter.this);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdLoaded(FacebookAdapter.this);
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookMediationAdapter.TAG, errorMessage);
            }
            MediationInterstitialListener mediationInterstitialListener = FacebookAdapter.this.mInterstitialListener;
            FacebookAdapter facebookAdapter = FacebookAdapter.this;
            mediationInterstitialListener.onAdFailedToLoad(facebookAdapter, facebookAdapter.convertErrorCode(adError));
        }

        @Override // com.facebook.ads.InterstitialAdListener
        public void onInterstitialDismissed(Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdClosed(FacebookAdapter.this);
        }

        @Override // com.facebook.ads.InterstitialAdListener
        public void onInterstitialDisplayed(Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdOpened(FacebookAdapter.this);
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
        }

        private d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface e {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    class f implements AdListener, NativeAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.facebook.ads.NativeAd f12577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private NativeMediationAdRequest f12578b;

        /* synthetic */ f(FacebookAdapter facebookAdapter, com.facebook.ads.NativeAd nativeAd, NativeMediationAdRequest nativeMediationAdRequest, com.google.ads.mediation.facebook.a aVar) {
            this(nativeAd, nativeMediationAdRequest);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            FacebookAdapter.this.mNativeListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdOpened(FacebookAdapter.this);
            FacebookAdapter.this.mNativeListener.onAdLeftApplication(FacebookAdapter.this);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            if (ad != this.f12577a) {
                Log.w(FacebookMediationAdapter.TAG, "Ad loaded is not a native ad.");
                FacebookAdapter.this.mNativeListener.onAdFailedToLoad(FacebookAdapter.this, 0);
                return;
            }
            NativeAdOptions nativeAdOptions = this.f12578b.getNativeAdOptions();
            if (this.f12578b.isUnifiedNativeAdRequested()) {
                g gVar = FacebookAdapter.this.new g(this.f12577a, nativeAdOptions);
                gVar.a(new com.google.ads.mediation.facebook.e(this, gVar));
            } else if (this.f12578b.isAppInstallAdRequested() || this.f12578b.isContentAdRequested()) {
                a aVar = FacebookAdapter.this.new a(this.f12577a, nativeAdOptions);
                aVar.a(new com.google.ads.mediation.facebook.f(this, aVar));
            }
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookMediationAdapter.TAG, errorMessage);
            }
            MediationNativeListener mediationNativeListener = FacebookAdapter.this.mNativeListener;
            FacebookAdapter facebookAdapter = FacebookAdapter.this;
            mediationNativeListener.onAdFailedToLoad(facebookAdapter, facebookAdapter.convertErrorCode(adError));
        }

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
            if (FacebookAdapter.this.mIsImpressionRecorded) {
                Log.d(FacebookMediationAdapter.TAG, "Received onLoggingImpression callback for a native whose impression is already recorded. Ignoring the duplicate callback.");
            } else {
                FacebookAdapter.this.mNativeListener.onAdImpression(FacebookAdapter.this);
                FacebookAdapter.this.mIsImpressionRecorded = true;
            }
        }

        @Override // com.facebook.ads.NativeAdListener
        public void onMediaDownloaded(Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }

        private f(com.facebook.ads.NativeAd nativeAd, NativeMediationAdRequest nativeMediationAdRequest) {
            this.f12577a = nativeAd;
            this.f12578b = nativeMediationAdRequest;
        }
    }

    private void buildAdRequest(MediationAdRequest mediationAdRequest) {
        if (mediationAdRequest != null) {
            AdSettings.setIsChildDirected(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int convertErrorCode(AdError adError) {
        if (adError == null) {
            return 0;
        }
        int errorCode = adError.getErrorCode();
        if (errorCode == 2000) {
            return 2;
        }
        switch (errorCode) {
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndLoadBannerAd(Context context, String str, AdSize adSize, MediationAdRequest mediationAdRequest) {
        this.mAdView = new AdView(context, str, getAdSize(context, adSize));
        this.mAdView.setAdListener(new b(this, null));
        buildAdRequest(mediationAdRequest);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(adSize.getWidthInPixels(context), adSize.getHeightInPixels(context));
        this.mWrappedAdView = new RelativeLayout(context);
        this.mAdView.setLayoutParams(layoutParams);
        this.mWrappedAdView.addView(this.mAdView);
        AdSettings.setMediationService("ADMOB_" + MobileAds.getVersionString());
        this.mAdView.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndLoadInterstitial(Context context, String str, MediationAdRequest mediationAdRequest) {
        this.mInterstitialAd = new InterstitialAd(context, str);
        this.mInterstitialAd.setAdListener(new d(this, null));
        buildAdRequest(mediationAdRequest);
        AdSettings.setMediationService("ADMOB_" + MobileAds.getVersionString());
        this.mInterstitialAd.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createAndLoadNativeAd(Context context, String str, NativeMediationAdRequest nativeMediationAdRequest) {
        this.mMediaView = new MediaView(context);
        this.mNativeAd = new com.facebook.ads.NativeAd(context, str);
        com.facebook.ads.NativeAd nativeAd = this.mNativeAd;
        nativeAd.setAdListener(new f(this, nativeAd, nativeMediationAdRequest, null));
        buildAdRequest(nativeMediationAdRequest);
        AdSettings.setMediationService("ADMOB_" + MobileAds.getVersionString());
        this.mNativeAd.loadAd();
    }

    private com.facebook.ads.AdSize getAdSize(Context context, AdSize adSize) {
        if (adSize.getWidth() == com.facebook.ads.AdSize.BANNER_320_50.getWidth() && adSize.getHeight() == com.facebook.ads.AdSize.BANNER_320_50.getHeight()) {
            return com.facebook.ads.AdSize.BANNER_320_50;
        }
        int iPixelToDip = pixelToDip(adSize.getHeightInPixels(context));
        if (iPixelToDip == com.facebook.ads.AdSize.BANNER_HEIGHT_50.getHeight()) {
            return com.facebook.ads.AdSize.BANNER_HEIGHT_50;
        }
        if (iPixelToDip == com.facebook.ads.AdSize.BANNER_HEIGHT_90.getHeight()) {
            return com.facebook.ads.AdSize.BANNER_HEIGHT_90;
        }
        if (iPixelToDip == com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250.getHeight()) {
            return com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250;
        }
        return null;
    }

    private int pixelToDip(int i) {
        return Math.round(i / Resources.getSystem().getDisplayMetrics().density);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public View getBannerView() {
        return this.mWrappedAdView;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onDestroy() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.destroy();
        }
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        com.facebook.ads.NativeAd nativeAd = this.mNativeAd;
        if (nativeAd != null) {
            nativeAd.unregisterView();
            this.mNativeAd.destroy();
        }
        MediaView mediaView = this.mMediaView;
        if (mediaView != null) {
            mediaView.destroy();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onPause() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public void onResume() {
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mBannerListener = mediationBannerListener;
        if (!FacebookMediationAdapter.isValidRequestParameters(context, bundle)) {
            this.mBannerListener.onAdFailedToLoad(this, 1);
            return;
        }
        if (adSize == null) {
            Log.w(FacebookMediationAdapter.TAG, "Fail to request banner ad, adSize is null");
            this.mBannerListener.onAdFailedToLoad(this, 1);
            return;
        }
        if (getAdSize(context, adSize) != null) {
            String string = bundle.getString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER);
            h.a().a(context, string, new com.google.ads.mediation.facebook.a(this, context, string, adSize, mediationAdRequest));
            return;
        }
        Log.w(FacebookMediationAdapter.TAG, "The input ad size " + adSize.toString() + " is not supported at this moment.");
        this.mBannerListener.onAdFailedToLoad(this, 3);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mInterstitialListener = mediationInterstitialListener;
        if (!FacebookMediationAdapter.isValidRequestParameters(context, bundle)) {
            this.mInterstitialListener.onAdFailedToLoad(this, 1);
        } else {
            String string = bundle.getString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER);
            h.a().a(context, string, new com.google.ads.mediation.facebook.b(this, context, string, mediationAdRequest));
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.mNativeListener = mediationNativeListener;
        if (!FacebookMediationAdapter.isValidRequestParameters(context, bundle)) {
            this.mNativeListener.onAdFailedToLoad(this, 1);
            return;
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested() && nativeMediationAdRequest.isContentAdRequested()) {
            String string = bundle.getString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER);
            h.a().a(context, string, new com.google.ads.mediation.facebook.c(this, context, string, nativeMediationAdRequest));
        } else {
            Log.w(FacebookMediationAdapter.TAG, "Failed to request native ad. Both app install and content ad should be requested");
            this.mNativeListener.onAdFailedToLoad(this, 1);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        if (this.mInterstitialAd.isAdLoaded()) {
            this.mInterstitialAd.show();
        }
    }

    class a extends NativeAppInstallAdMapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.facebook.ads.NativeAd f12569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private NativeAdOptions f12570b;

        public a(com.facebook.ads.NativeAd nativeAd, NativeAdOptions nativeAdOptions) {
            this.f12569a = nativeAd;
            this.f12570b = nativeAdOptions;
        }

        public void a(e eVar) {
            if (!a(this.f12569a)) {
                Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the app install format.");
                eVar.a();
                return;
            }
            setHeadline(this.f12569a.getAdHeadline());
            ArrayList arrayList = new ArrayList();
            arrayList.add(FacebookAdapter.this.new c(Uri.parse(this.f12569a.getAdCoverImage().toString())));
            setImages(arrayList);
            setBody(this.f12569a.getAdBodyText());
            setIcon(FacebookAdapter.this.new c(Uri.parse(this.f12569a.getAdIcon().toString())));
            setCallToAction(this.f12569a.getAdCallToAction());
            FacebookAdapter.this.mMediaView.setListener(new com.google.ads.mediation.facebook.d(this));
            setMediaView(FacebookAdapter.this.mMediaView);
            setHasVideoContent(true);
            Double dA = a(this.f12569a.getAdStarRating());
            if (dA != null) {
                setStarRating(dA.doubleValue());
            }
            Bundle bundle = new Bundle();
            bundle.putCharSequence("id", this.f12569a.getId());
            bundle.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.f12569a.getAdSocialContext());
            setExtras(bundle);
            eVar.b();
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            ViewGroup viewGroup = (ViewGroup) view;
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            ImageView imageView = null;
            if (childAt instanceof FrameLayout) {
                NativeAdLayout nativeAdLayout = new NativeAdLayout(view.getContext());
                ((FrameLayout) childAt).addView(nativeAdLayout);
                AdOptionsView adOptionsView = new AdOptionsView(view.getContext(), this.f12569a, nativeAdLayout);
                ((ViewGroup) childAt).addView(adOptionsView);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) adOptionsView.getLayoutParams();
                NativeAdOptions nativeAdOptions = this.f12570b;
                if (nativeAdOptions != null) {
                    int adChoicesPlacement = nativeAdOptions.getAdChoicesPlacement();
                    if (adChoicesPlacement == 0) {
                        layoutParams.gravity = 51;
                    } else if (adChoicesPlacement == 2) {
                        layoutParams.gravity = 85;
                    } else if (adChoicesPlacement != 3) {
                        layoutParams.gravity = 53;
                    } else {
                        layoutParams.gravity = 83;
                    }
                } else {
                    layoutParams.gravity = 53;
                }
                viewGroup.requestLayout();
            } else {
                setAdChoicesContent(new AdOptionsView(view.getContext(), this.f12569a, null));
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, View> entry : map.entrySet()) {
                arrayList.add(entry.getValue());
                if (entry.getKey().equals(NativeAppInstallAd.ASSET_ICON) || entry.getKey().equals(UnifiedNativeAdAssetNames.ASSET_ICON)) {
                    imageView = (ImageView) entry.getValue();
                }
            }
            this.f12569a.registerViewForInteraction(view, FacebookAdapter.this.mMediaView, imageView, arrayList);
        }

        @Override // com.google.android.gms.ads.mediation.NativeAdMapper
        public void untrackView(View view) {
            super.untrackView(view);
            View childAt = ((ViewGroup) view).getChildAt(r2.getChildCount() - 1);
            if (childAt instanceof FrameLayout) {
                ((FrameLayout) childAt).removeAllViews();
            }
            this.f12569a.unregisterView();
        }

        private boolean a(com.facebook.ads.NativeAd nativeAd) {
            return (nativeAd.getAdHeadline() == null || nativeAd.getAdCoverImage() == null || nativeAd.getAdBodyText() == null || nativeAd.getAdIcon() == null || nativeAd.getAdCallToAction() == null || FacebookAdapter.this.mMediaView == null) ? false : true;
        }

        private Double a(NativeAdBase.Rating rating) {
            if (rating == null) {
                return null;
            }
            return Double.valueOf((rating.getValue() * 5.0d) / rating.getScale());
        }
    }

    class g extends UnifiedNativeAdMapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.facebook.ads.NativeAd f12580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private NativeAdOptions f12581b;

        public g(com.facebook.ads.NativeAd nativeAd, NativeAdOptions nativeAdOptions) {
            this.f12580a = nativeAd;
            this.f12581b = nativeAdOptions;
        }

        public void a(e eVar) {
            if (!a(this.f12580a)) {
                Log.w(FacebookMediationAdapter.TAG, "Ad from Facebook doesn't have all assets required for the Unified Ad format.");
                eVar.a();
                return;
            }
            setHeadline(this.f12580a.getAdHeadline());
            ArrayList arrayList = new ArrayList();
            arrayList.add(FacebookAdapter.this.new c(Uri.parse(this.f12580a.getAdCoverImage().toString())));
            setImages(arrayList);
            setBody(this.f12580a.getAdBodyText());
            setIcon(FacebookAdapter.this.new c(Uri.parse(this.f12580a.getAdIcon().toString())));
            setCallToAction(this.f12580a.getAdCallToAction());
            setAdvertiser(this.f12580a.getAdvertiserName());
            FacebookAdapter.this.mMediaView.setListener(new com.google.ads.mediation.facebook.g(this));
            setMediaView(FacebookAdapter.this.mMediaView);
            setHasVideoContent(true);
            Double dA = a(this.f12580a.getAdStarRating());
            if (dA != null) {
                setStarRating(dA);
            }
            Bundle bundle = new Bundle();
            bundle.putCharSequence("id", this.f12580a.getId());
            bundle.putCharSequence(FacebookAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.f12580a.getAdSocialContext());
            setExtras(bundle);
            eVar.b();
        }

        @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
        public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
            ViewGroup viewGroup = (ViewGroup) view;
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            NativeAdLayout nativeAdLayout = new NativeAdLayout(view.getContext());
            if (childAt instanceof FrameLayout) {
                AdOptionsView adOptionsView = new AdOptionsView(view.getContext(), this.f12580a, nativeAdLayout);
                ((ViewGroup) childAt).addView(adOptionsView);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) adOptionsView.getLayoutParams();
                NativeAdOptions nativeAdOptions = this.f12581b;
                if (nativeAdOptions != null) {
                    int adChoicesPlacement = nativeAdOptions.getAdChoicesPlacement();
                    if (adChoicesPlacement == 0) {
                        layoutParams.gravity = 51;
                    } else if (adChoicesPlacement == 2) {
                        layoutParams.gravity = 85;
                    } else if (adChoicesPlacement != 3) {
                        layoutParams.gravity = 53;
                    } else {
                        layoutParams.gravity = 83;
                    }
                } else {
                    layoutParams.gravity = 53;
                }
                viewGroup.requestLayout();
            } else {
                setAdChoicesContent(new AdOptionsView(view.getContext(), this.f12580a, nativeAdLayout));
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            ImageView imageView = null;
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, View> entry : map.entrySet()) {
                arrayList.add(entry.getValue());
                if (entry.getKey().equals(NativeAppInstallAd.ASSET_ICON) || entry.getKey().equals(UnifiedNativeAdAssetNames.ASSET_ICON)) {
                    imageView = (ImageView) entry.getValue();
                }
            }
            this.f12580a.registerViewForInteraction(view, FacebookAdapter.this.mMediaView, imageView, arrayList);
        }

        @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
        public void untrackView(View view) {
            super.untrackView(view);
            View childAt = ((ViewGroup) view).getChildAt(r2.getChildCount() - 1);
            if (childAt instanceof FrameLayout) {
                ((FrameLayout) childAt).removeAllViews();
            }
            this.f12580a.unregisterView();
        }

        private boolean a(com.facebook.ads.NativeAd nativeAd) {
            return (nativeAd.getAdHeadline() == null || nativeAd.getAdCoverImage() == null || nativeAd.getAdBodyText() == null || nativeAd.getAdIcon() == null || nativeAd.getAdCallToAction() == null || FacebookAdapter.this.mMediaView == null) ? false : true;
        }

        private Double a(NativeAdBase.Rating rating) {
            if (rating == null) {
                return null;
            }
            return Double.valueOf((rating.getValue() * 5.0d) / rating.getScale());
        }
    }
}
