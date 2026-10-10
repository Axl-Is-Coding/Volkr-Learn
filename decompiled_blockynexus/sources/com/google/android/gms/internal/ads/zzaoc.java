package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.alibaba.android.arouter.utils.Consts;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaoc implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzanh zzdlq;
    private NativeAdMapper zzdlr;
    private UnifiedNativeAdMapper zzdls;
    private NativeCustomTemplateAd zzdlt;

    public zzaoc(zzanh zzanhVar) {
        this.zzdlq = zzanhVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdClicked.");
        try {
            this.zzdlq.onAdClicked();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdClosed.");
        try {
            this.zzdlq.onAdClosed();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error. ");
        sb.append(i);
        zzbbq.zzef(sb.toString());
        try {
            this.zzdlq.onAdFailedToLoad(i);
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzdlr;
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzdls;
        if (this.zzdlt == null) {
            if (nativeAdMapper == null && unifiedNativeAdMapper == null) {
                zzbbq.zze("#007 Could not call remote method.", null);
                return;
            }
            if (unifiedNativeAdMapper != null && !unifiedNativeAdMapper.getOverrideImpressionRecording()) {
                zzbbq.zzef("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            } else if (nativeAdMapper != null && !nativeAdMapper.getOverrideImpressionRecording()) {
                zzbbq.zzef("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        zzbbq.zzef("Adapter called onAdImpression.");
        try {
            this.zzdlq.onAdImpression();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdLeftApplication.");
        try {
            this.zzdlq.onAdLeftApplication();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdLoaded.");
        try {
            this.zzdlq.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdOpened.");
        try {
            this.zzdlq.onAdOpened();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onVideoEnd.");
        try {
            this.zzdlq.onVideoEnd();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void zza(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAppEvent.");
        try {
            this.zzdlq.onAppEvent(str, str2);
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final NativeAdMapper zzug() {
        return this.zzdlr;
    }

    public final UnifiedNativeAdMapper zzuh() {
        return this.zzdls;
    }

    public final NativeCustomTemplateAd zzui() {
        return this.zzdlt;
    }

    private static void zza(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper, NativeAdMapper nativeAdMapper) {
        if (mediationNativeAdapter instanceof AdMobAdapter) {
            return;
        }
        VideoController videoController = new VideoController();
        videoController.zza(new zzanv());
        if (unifiedNativeAdMapper != null && unifiedNativeAdMapper.hasVideoContent()) {
            unifiedNativeAdMapper.zza(videoController);
        }
        if (nativeAdMapper == null || !nativeAdMapper.hasVideoContent()) {
            return;
        }
        nativeAdMapper.zza(videoController);
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdClicked.");
        try {
            this.zzdlq.onAdClicked();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdClosed.");
        try {
            this.zzdlq.onAdClosed();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 97 + String.valueOf(domain).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(code);
        sb.append(". ErrorMessage: ");
        sb.append(message);
        sb.append(". ErrorDomain: ");
        sb.append(domain);
        zzbbq.zzef(sb.toString());
        try {
            this.zzdlq.zzc(adError.zzdo());
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdLeftApplication.");
        try {
            this.zzdlq.onAdLeftApplication();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdLoaded.");
        try {
            this.zzdlq.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdOpened.");
        try {
            this.zzdlq.onAdOpened();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        NativeAdMapper nativeAdMapper = this.zzdlr;
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzdls;
        if (this.zzdlt == null) {
            if (nativeAdMapper == null && unifiedNativeAdMapper == null) {
                zzbbq.zze("#007 Could not call remote method.", null);
                return;
            }
            if (unifiedNativeAdMapper != null && !unifiedNativeAdMapper.getOverrideClickHandling()) {
                zzbbq.zzef("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            } else if (nativeAdMapper != null && !nativeAdMapper.getOverrideClickHandling()) {
                zzbbq.zzef("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        zzbbq.zzef("Adapter called onAdClicked.");
        try {
            this.zzdlq.onAdClicked();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdClosed.");
        try {
            this.zzdlq.onAdClosed();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdLeftApplication.");
        try {
            this.zzdlq.onAdLeftApplication();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdLoaded.");
        this.zzdlr = nativeAdMapper;
        this.zzdls = null;
        zza(mediationNativeAdapter, this.zzdls, this.zzdlr);
        try {
            this.zzdlq.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdOpened.");
        try {
            this.zzdlq.onAdOpened();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(Consts.DOT);
        zzbbq.zzef(sb.toString());
        try {
            this.zzdlq.onAdFailedToLoad(i);
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        String strValueOf = String.valueOf(nativeCustomTemplateAd.getCustomTemplateId());
        zzbbq.zzef(strValueOf.length() != 0 ? "Adapter called onAdLoaded with template id ".concat(strValueOf) : new String("Adapter called onAdLoaded with template id "));
        this.zzdlt = nativeCustomTemplateAd;
        try {
            this.zzdlq.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 97 + String.valueOf(domain).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(code);
        sb.append(". ErrorMessage: ");
        sb.append(message);
        sb.append(". ErrorDomain: ");
        sb.append(domain);
        zzbbq.zzef(sb.toString());
        try {
            this.zzdlq.zzc(adError.zzdo());
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbq.zzef("Adapter called onAdLoaded.");
        this.zzdls = unifiedNativeAdMapper;
        this.zzdlr = null;
        zza(mediationNativeAdapter, this.zzdls, this.zzdlr);
        try {
            this.zzdlq.onAdLoaded();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void zza(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (nativeCustomTemplateAd instanceof zzafb) {
            try {
                this.zzdlq.zza(((zzafb) nativeCustomTemplateAd).zzst(), str);
                return;
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
                return;
            }
        }
        zzbbq.zzfe("Unexpected native custom template ad type.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(55);
        sb.append("Adapter called onAdFailedToLoad with error ");
        sb.append(i);
        sb.append(Consts.DOT);
        zzbbq.zzef(sb.toString());
        try {
            this.zzdlq.onAdFailedToLoad(i);
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 97 + String.valueOf(domain).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(code);
        sb.append(". ErrorMessage: ");
        sb.append(message);
        sb.append(". ErrorDomain: ");
        sb.append(domain);
        zzbbq.zzef(sb.toString());
        try {
            this.zzdlq.zzc(adError.zzdo());
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }
}
