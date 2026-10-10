package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzua;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcln implements zzbui, zzbuz, zzbvs, zzbws, zzbyo, zzux {
    private final zzts zzggj;
    private boolean zzggk = false;

    public zzcln(zzts zztsVar, zzdmd zzdmdVar) {
        this.zzggj = zztsVar;
        zztsVar.zza(zztu.zza.zzb.AD_REQUEST);
        if (zzdmdVar != null) {
            zztsVar.zza(zztu.zza.zzb.REQUEST_IS_PREFETCH);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzux
    public final synchronized void onAdClicked() {
        if (this.zzggk) {
            this.zzggj.zza(zztu.zza.zzb.AD_SUBSEQUENT_CLICK);
        } else {
            this.zzggj.zza(zztu.zza.zzb.AD_FIRST_CLICK);
            this.zzggk = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final synchronized void onAdImpression() {
        this.zzggj.zza(zztu.zza.zzb.AD_IMPRESSION);
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void onAdLoaded() {
        this.zzggj.zza(zztu.zza.zzb.AD_LOADED);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzake() {
        this.zzggj.zza(zztu.zza.zzb.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzb(final zzdog zzdogVar) {
        this.zzggj.zza(new zztr(zzdogVar) { // from class: com.google.android.gms.internal.ads.zzclq
            private final zzdog zzfvd;

            {
                this.zzfvd = zzdogVar;
            }

            @Override // com.google.android.gms.internal.ads.zztr
            public final void zza(zzua.zzi.zza zzaVar) {
                zzaVar.zza(zzaVar.zznz().zzbgg().zza(zzaVar.zznz().zznd().zzbgg().zzbx(this.zzfvd.zzhew.zzeou.zzdtb)));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzbg(boolean z) {
        this.zzggj.zza(z ? zztu.zza.zzb.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED : zztu.zza.zzb.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzbh(boolean z) {
        this.zzggj.zza(z ? zztu.zza.zzb.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED : zztu.zza.zzb.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzc(final zzua.zzb zzbVar) {
        this.zzggj.zza(new zztr(zzbVar) { // from class: com.google.android.gms.internal.ads.zzclp
            private final zzua.zzb zzfvp;

            {
                this.zzfvp = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zztr
            public final void zza(zzua.zzi.zza zzaVar) {
                zzaVar.zza(this.zzfvp);
            }
        });
        this.zzggj.zza(zztu.zza.zzb.REQUEST_LOADED_FROM_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzd(zzatc zzatcVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zzd(final zzua.zzb zzbVar) {
        this.zzggj.zza(new zztr(zzbVar) { // from class: com.google.android.gms.internal.ads.zzcls
            private final zzua.zzb zzfvp;

            {
                this.zzfvp = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zztr
            public final void zza(zzua.zzi.zza zzaVar) {
                zzaVar.zza(this.zzfvp);
            }
        });
        this.zzggj.zza(zztu.zza.zzb.REQUEST_SAVED_TO_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbyo
    public final void zze(final zzua.zzb zzbVar) {
        this.zzggj.zza(new zztr(zzbVar) { // from class: com.google.android.gms.internal.ads.zzclr
            private final zzua.zzb zzfvp;

            {
                this.zzfvp = zzbVar;
            }

            @Override // com.google.android.gms.internal.ads.zztr
            public final void zza(zzua.zzi.zza zzaVar) {
                zzaVar.zza(this.zzfvp);
            }
        });
        this.zzggj.zza(zztu.zza.zzb.REQUEST_PREFETCH_INTERCEPTED);
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void zzk(zzva zzvaVar) {
        switch (zzvaVar.errorCode) {
            case 1:
                this.zzggj.zza(zztu.zza.zzb.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                break;
            case 2:
                this.zzggj.zza(zztu.zza.zzb.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                break;
            case 3:
                this.zzggj.zza(zztu.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL);
                break;
            case 4:
                this.zzggj.zza(zztu.zza.zzb.AD_FAILED_TO_LOAD_TIMEOUT);
                break;
            case 5:
                this.zzggj.zza(zztu.zza.zzb.AD_FAILED_TO_LOAD_CANCELLED);
                break;
            case 6:
                this.zzggj.zza(zztu.zza.zzb.AD_FAILED_TO_LOAD_NO_ERROR);
                break;
            case 7:
                this.zzggj.zza(zztu.zza.zzb.AD_FAILED_TO_LOAD_NOT_FOUND);
                break;
            default:
                this.zzggj.zza(zztu.zza.zzb.AD_FAILED_TO_LOAD);
                break;
        }
    }
}
