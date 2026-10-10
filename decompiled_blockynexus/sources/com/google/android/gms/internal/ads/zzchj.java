package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzchj {
    private final Executor zzfoc;
    private final zzdok zzfsk;
    private final zzcjt zzgbx;

    public zzchj(zzdok zzdokVar, Executor executor, zzcjt zzcjtVar) {
        this.zzfsk = zzdokVar;
        this.zzfoc = executor;
        this.zzgbx = zzcjtVar;
    }

    private final void zzk(zzbgj zzbgjVar) {
        zzbgjVar.zza("/video", zzagx.zzdfd);
        zzbgjVar.zza("/videoMeta", zzagx.zzdfe);
        zzbgjVar.zza("/precache", new zzbfq());
        zzbgjVar.zza("/delayPageLoaded", zzagx.zzdfh);
        zzbgjVar.zza("/instrument", zzagx.zzdff);
        zzbgjVar.zza("/log", zzagx.zzdey);
        zzbgjVar.zza("/videoClicked", zzagx.zzdez);
        zzbgjVar.zzabw().zzay(true);
        zzbgjVar.zza("/click", zzagx.zzdeu);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcrx)).booleanValue()) {
            zzbgjVar.zza("/getNativeAdViewSignals", zzagx.zzdfk);
        }
        if (this.zzfsk.zzdsi != null) {
            zzbgjVar.zzabw().zzaz(true);
            zzbgjVar.zza("/open", new zzahu(null, null));
        } else {
            zzbgjVar.zzabw().zzaz(false);
        }
        if (com.google.android.gms.ads.internal.zzp.zzlp().zzac(zzbgjVar.getContext())) {
            zzbgjVar.zza("/logScionEvent", new zzahs(zzbgjVar.getContext()));
        }
    }

    final /* synthetic */ zzdzc zza(String str, String str2, Object obj) throws Exception {
        final zzbgj zzbgjVarZzc = this.zzgbx.zzc(zzvn.zzpk());
        final zzbch zzbchVarZzl = zzbch.zzl(zzbgjVarZzc);
        zzk(zzbgjVarZzc);
        if (this.zzfsk.zzdsi != null) {
            zzbgjVarZzc.zza(zzbhy.zzada());
        } else {
            zzbgjVarZzc.zza(zzbhy.zzacz());
        }
        zzbgjVarZzc.zzabw().zza(new zzbhu(this, zzbgjVarZzc, zzbchVarZzl) { // from class: com.google.android.gms.internal.ads.zzchq
            private final zzbgj zzgci;
            private final zzchj zzgdw;
            private final zzbch zzgdx;

            {
                this.zzgdw = this;
                this.zzgci = zzbgjVarZzc;
                this.zzgdx = zzbchVarZzl;
            }

            @Override // com.google.android.gms.internal.ads.zzbhu
            public final void zzai(boolean z) {
                this.zzgdw.zza(this.zzgci, this.zzgdx, z);
            }
        });
        zzbgjVarZzc.zzb(str, str2, null);
        return zzbchVarZzl;
    }

    final /* synthetic */ void zzb(zzbgj zzbgjVar, zzbch zzbchVar, boolean z) {
        if (this.zzfsk.zzhez != null && zzbgjVar.zzzs() != null) {
            zzbgjVar.zzzs().zzb(this.zzfsk.zzhez);
        }
        zzbchVar.zzyw();
    }

    public final zzdzc<zzbgj> zzn(final JSONObject jSONObject) {
        return zzdyq.zzb(zzdyq.zzb(zzdyq.zzaf(null), new zzdya(this) { // from class: com.google.android.gms.internal.ads.zzcho
            private final zzchj zzgdw;

            {
                this.zzgdw = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgdw.zzr(obj);
            }
        }, this.zzfoc), new zzdya(this, jSONObject) { // from class: com.google.android.gms.internal.ads.zzchm
            private final JSONObject zzfnx;
            private final zzchj zzgdw;

            {
                this.zzgdw = this;
                this.zzfnx = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgdw.zza(this.zzfnx, (zzbgj) obj);
            }
        }, this.zzfoc);
    }

    public final zzdzc<zzbgj> zzo(final String str, final String str2) {
        return zzdyq.zzb(zzdyq.zzaf(null), new zzdya(this, str, str2) { // from class: com.google.android.gms.internal.ads.zzchl
            private final String zzdgm;
            private final String zzdjk;
            private final zzchj zzgdw;

            {
                this.zzgdw = this;
                this.zzdgm = str;
                this.zzdjk = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgdw.zza(this.zzdgm, this.zzdjk, obj);
            }
        }, this.zzfoc);
    }

    final /* synthetic */ zzdzc zzr(Object obj) throws Exception {
        zzbgj zzbgjVarZzc = this.zzgbx.zzc(zzvn.zzpk());
        final zzbch zzbchVarZzl = zzbch.zzl(zzbgjVarZzc);
        zzk(zzbgjVarZzc);
        zzbgjVarZzc.zzabw().zza(new zzbhx(zzbchVarZzl) { // from class: com.google.android.gms.internal.ads.zzchn
            private final zzbch zzenq;

            {
                this.zzenq = zzbchVarZzl;
            }

            @Override // com.google.android.gms.internal.ads.zzbhx
            public final void zztj() {
                this.zzenq.zzyw();
            }
        });
        zzbgjVarZzc.loadUrl((String) zzwm.zzpx().zzd(zzabb.zzcrw));
        return zzbchVarZzl;
    }

    final /* synthetic */ void zza(zzbgj zzbgjVar, zzbch zzbchVar, boolean z) {
        if (z) {
            if (this.zzfsk.zzhez != null && zzbgjVar.zzzs() != null) {
                zzbgjVar.zzzs().zzb(this.zzfsk.zzhez);
            }
            zzbchVar.zzyw();
            return;
        }
        zzbchVar.setException(new zzcwn(zzdpg.INTERNAL_ERROR, "Instream video Web View failed to load."));
    }

    final /* synthetic */ zzdzc zza(JSONObject jSONObject, final zzbgj zzbgjVar) throws Exception {
        final zzbch zzbchVarZzl = zzbch.zzl(zzbgjVar);
        if (this.zzfsk.zzdsi != null) {
            zzbgjVar.zza(zzbhy.zzada());
        } else {
            zzbgjVar.zza(zzbhy.zzacz());
        }
        zzbgjVar.zzabw().zza(new zzbhu(this, zzbgjVar, zzbchVarZzl) { // from class: com.google.android.gms.internal.ads.zzchp
            private final zzbgj zzgci;
            private final zzchj zzgdw;
            private final zzbch zzgdx;

            {
                this.zzgdw = this;
                this.zzgci = zzbgjVar;
                this.zzgdx = zzbchVarZzl;
            }

            @Override // com.google.android.gms.internal.ads.zzbhu
            public final void zzai(boolean z) {
                this.zzgdw.zzb(this.zzgci, this.zzgdx, z);
            }
        });
        zzbgjVar.zzb("google.afma.nativeAds.renderVideo", jSONObject);
        return zzbchVarZzl;
    }
}
