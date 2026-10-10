package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzadu;
import com.google.android.gms.internal.ads.zzagk;
import com.google.android.gms.internal.ads.zzagn;
import com.google.android.gms.internal.ads.zzago;
import com.google.android.gms.internal.ads.zzagq;
import com.google.android.gms.internal.ads.zzags;
import com.google.android.gms.internal.ads.zzanc;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzvc;
import com.google.android.gms.internal.ads.zzvl;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzwm;
import com.google.android.gms.internal.ads.zzwu;
import com.google.android.gms.internal.ads.zzwz;
import com.google.android.gms.internal.ads.zzyw;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public class AdLoader {
    private final zzvl zzacs;
    private final zzwu zzact;
    private final Context zzvr;

    AdLoader(Context context, zzwu zzwuVar) {
        this(context, zzwuVar, zzvl.zzchs);
    }

    private final void zza(zzyw zzywVar) {
        try {
            this.zzact.zzb(zzvl.zza(this.zzvr, zzywVar));
        } catch (RemoteException e2) {
            zzbbq.zzc("Failed to load ad.", e2);
        }
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        try {
            return this.zzact.zzkh();
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to get the mediation adapter class name.", e2);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzact.isLoading();
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to check if ad is loading.", e2);
            return false;
        }
    }

    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdr());
    }

    public void loadAds(AdRequest adRequest, int i) {
        try {
            this.zzact.zza(zzvl.zza(this.zzvr, adRequest.zzdr()), i);
        } catch (RemoteException e2) {
            zzbbq.zzc("Failed to load ads.", e2);
        }
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdr());
    }

    private AdLoader(Context context, zzwu zzwuVar, zzvl zzvlVar) {
        this.zzvr = context;
        this.zzact = zzwuVar;
        this.zzacs = zzvlVar;
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static class Builder {
        private final zzwz zzacr;
        private final Context zzvr;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(Context context, String str) {
            this(context, zzwm.zzpu().zzb(context, str, new zzanc()));
            Preconditions.checkNotNull(context, "context cannot be null");
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.zzvr, this.zzacr.zzqf());
            } catch (RemoteException e2) {
                zzbbq.zzc("Failed to build AdLoader.", e2);
                return null;
            }
        }

        @Deprecated
        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzacr.zza(new zzago(onAppInstallAdLoadedListener));
            } catch (RemoteException e2) {
                zzbbq.zzd("Failed to add app install ad listener", e2);
            }
            return this;
        }

        @Deprecated
        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzacr.zza(new zzagn(onContentAdLoadedListener));
            } catch (RemoteException e2) {
                zzbbq.zzd("Failed to add content ad listener", e2);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            zzagk zzagkVar = new zzagk(onCustomTemplateAdLoadedListener, onCustomClickListener);
            try {
                this.zzacr.zza(str, zzagkVar.zzsx(), zzagkVar.zzsy());
            } catch (RemoteException e2) {
                zzbbq.zzd("Failed to add custom template ad listener", e2);
            }
            return this;
        }

        public Builder forPublisherAdView(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener, AdSize... adSizeArr) {
            if (adSizeArr == null || adSizeArr.length <= 0) {
                throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
            }
            try {
                this.zzacr.zza(new zzagq(onPublisherAdViewLoadedListener), new zzvn(this.zzvr, adSizeArr));
            } catch (RemoteException e2) {
                zzbbq.zzd("Failed to add publisher banner ad listener", e2);
            }
            return this;
        }

        public Builder forUnifiedNativeAd(UnifiedNativeAd.OnUnifiedNativeAdLoadedListener onUnifiedNativeAdLoadedListener) {
            try {
                this.zzacr.zza(new zzags(onUnifiedNativeAdLoadedListener));
            } catch (RemoteException e2) {
                zzbbq.zzd("Failed to add google native ad listener", e2);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzacr.zzb(new zzvc(adListener));
            } catch (RemoteException e2) {
                zzbbq.zzd("Failed to set AdListener.", e2);
            }
            return this;
        }

        @KeepForSdk
        @Deprecated
        public Builder withCorrelator(Correlator correlator) {
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzacr.zza(new zzadu(nativeAdOptions));
            } catch (RemoteException e2) {
                zzbbq.zzd("Failed to specify native ad options", e2);
            }
            return this;
        }

        public Builder withPublisherAdViewOptions(PublisherAdViewOptions publisherAdViewOptions) {
            try {
                this.zzacr.zza(publisherAdViewOptions);
            } catch (RemoteException e2) {
                zzbbq.zzd("Failed to specify DFP banner ad options", e2);
            }
            return this;
        }

        private Builder(Context context, zzwz zzwzVar) {
            this.zzvr = context;
            this.zzacr = zzwzVar;
        }
    }
}
