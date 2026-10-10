package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzza {
    private final zzvl zzacs;
    private AppEventListener zzboa;
    private boolean zzbpb;
    private zzxc zzbut;
    private String zzbuu;
    private final zzanc zzbuw;
    private zzux zzcgv;
    private AdListener zzcha;
    private AdMetadataListener zzchq;
    private OnCustomRenderedAdLoadedListener zzcjv;
    private OnPaidEventListener zzcjy;
    private RewardedVideoAdListener zzckd;
    private boolean zzcke;
    private final Context zzvr;

    public zzza(Context context) {
        this(context, zzvl.zzchs, null);
    }

    private final void zzcr(String str) {
        if (this.zzbut != null) {
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
        sb.append("The ad unit ID must be set on InterstitialAd before ");
        sb.append(str);
        sb.append(" is called.");
        throw new IllegalStateException(sb.toString());
    }

    public final AdListener getAdListener() {
        return this.zzcha;
    }

    public final Bundle getAdMetadata() {
        try {
            if (this.zzbut != null) {
                return this.zzbut.getAdMetadata();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zzbuu;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzboa;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbut != null) {
                return this.zzbut.zzkh();
            }
            return null;
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcjv;
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzynVarZzki = null;
        try {
            if (this.zzbut != null) {
                zzynVarZzki = this.zzbut.zzki();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        return ResponseInfo.zza(zzynVarZzki);
    }

    public final boolean isLoaded() {
        try {
            if (this.zzbut == null) {
                return false;
            }
            return this.zzbut.isReady();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbut == null) {
                return false;
            }
            return this.zzbut.isLoading();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzcha = adListener;
            if (this.zzbut != null) {
                this.zzbut.zza(adListener != null ? new zzvc(adListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.zzchq = adMetadataListener;
            if (this.zzbut != null) {
                this.zzbut.zza(adMetadataListener != null ? new zzvh(adMetadataListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzbuu != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        }
        this.zzbuu = str;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzboa = appEventListener;
            if (this.zzbut != null) {
                this.zzbut.zza(appEventListener != null ? new zzvt(appEventListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbpb = z;
            if (this.zzbut != null) {
                this.zzbut.setImmersiveMode(z);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzcjv = onCustomRenderedAdLoadedListener;
            if (this.zzbut != null) {
                this.zzbut.zza(onCustomRenderedAdLoadedListener != null ? new zzabz(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzcjy = onPaidEventListener;
            if (this.zzbut != null) {
                this.zzbut.zza(new zzaab(onPaidEventListener));
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzckd = rewardedVideoAdListener;
            if (this.zzbut != null) {
                this.zzbut.zza(rewardedVideoAdListener != null ? new zzaun(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void show() {
        try {
            zzcr("show");
            this.zzbut.showInterstitial();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(zzyw zzywVar) {
        try {
            if (this.zzbut == null) {
                if (this.zzbuu == null) {
                    zzcr("loadAd");
                }
                zzvn zzvnVarZzpl = this.zzcke ? zzvn.zzpl() : new zzvn();
                zzvx zzvxVarZzpu = zzwm.zzpu();
                Context context = this.zzvr;
                this.zzbut = new zzwh(zzvxVarZzpu, context, zzvnVarZzpl, this.zzbuu, this.zzbuw).zzd(context, false);
                if (this.zzcha != null) {
                    this.zzbut.zza(new zzvc(this.zzcha));
                }
                if (this.zzcgv != null) {
                    this.zzbut.zza(new zzuz(this.zzcgv));
                }
                if (this.zzchq != null) {
                    this.zzbut.zza(new zzvh(this.zzchq));
                }
                if (this.zzboa != null) {
                    this.zzbut.zza(new zzvt(this.zzboa));
                }
                if (this.zzcjv != null) {
                    this.zzbut.zza(new zzabz(this.zzcjv));
                }
                if (this.zzckd != null) {
                    this.zzbut.zza(new zzaun(this.zzckd));
                }
                this.zzbut.zza(new zzaab(this.zzcjy));
                this.zzbut.setImmersiveMode(this.zzbpb);
            }
            if (this.zzbut.zza(zzvl.zza(this.zzvr, zzywVar))) {
                this.zzbuw.zzf(zzywVar.zzqq());
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zzd(boolean z) {
        this.zzcke = true;
    }

    public zzza(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzvl.zzchs, publisherInterstitialAd);
    }

    @VisibleForTesting
    private zzza(Context context, zzvl zzvlVar, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbuw = new zzanc();
        this.zzvr = context;
        this.zzacs = zzvlVar;
    }

    public final void zza(zzux zzuxVar) {
        try {
            this.zzcgv = zzuxVar;
            if (this.zzbut != null) {
                this.zzbut.zza(zzuxVar != null ? new zzuz(zzuxVar) : null);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }
}
