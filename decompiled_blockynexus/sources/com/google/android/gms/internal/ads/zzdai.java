package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbys;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdai implements zzdae<zzbqo> {
    private final zzbix zzgpt;
    private final Context zzgsl;
    private final zzdom zzgsm;
    private final zzdac zzgtw;
    private zzbqv zzgtx;

    public zzdai(zzbix zzbixVar, Context context, zzdac zzdacVar, zzdom zzdomVar) {
        this.zzgpt = zzbixVar;
        this.zzgsl = context;
        this.zzgtw = zzdacVar;
        this.zzgsm = zzdomVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdae
    public final boolean isLoading() {
        zzbqv zzbqvVar = this.zzgtx;
        return zzbqvVar != null && zzbqvVar.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzdae
    public final boolean zza(zzvg zzvgVar, String str, zzdad zzdadVar, zzdag<? super zzbqo> zzdagVar) throws RemoteException {
        com.google.android.gms.ads.internal.zzp.zzkr();
        if (zzayu.zzbe(this.zzgsl) && zzvgVar.zzcho == null) {
            zzbbq.zzfc("Failed to load the ad because app ID is missing.");
            this.zzgpt.zzadi().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdah
                private final zzdai zzgtv;

                {
                    this.zzgtv = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgtv.zzare();
                }
            });
            return false;
        }
        if (str == null) {
            zzbbq.zzfc("Ad unit ID should not be null for NativeAdLoader.");
            this.zzgpt.zzadi().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdak
                private final zzdai zzgtv;

                {
                    this.zzgtv = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgtv.zzard();
                }
            });
            return false;
        }
        zzdox.zze(this.zzgsl, zzvgVar.zzche);
        zzdok zzdokVarZzatn = this.zzgsm.zzh(zzvgVar).zzec(zzdadVar instanceof zzdaf ? ((zzdaf) zzdadVar).zzgtu : 1).zzatn();
        zzcda zzcdaVarZzaex = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcyi)).booleanValue() ? this.zzgpt.zzadu().zza(new zzbtp.zza().zzce(this.zzgsl).zza(zzdokVarZzatn).zzajv()).zza(new zzbys.zza().zzakr()).zza(this.zzgtw.zzaqw()).zzaex() : this.zzgpt.zzadu().zza(new zzbtp.zza().zzce(this.zzgsl).zza(zzdokVarZzatn).zzajv()).zza(new zzbys.zza().zza(this.zzgtw.zzaqz(), this.zzgpt.zzadi()).zza(this.zzgtw.zzara(), this.zzgpt.zzadi()).zza(this.zzgtw.zzarb(), this.zzgpt.zzadi()).zza(this.zzgtw.zzarc(), this.zzgpt.zzadi()).zza(this.zzgtw.zzaqy(), this.zzgpt.zzadi()).zza(zzdokVarZzatn.zzhfg, this.zzgpt.zzadi()).zzakr()).zza(this.zzgtw.zzaqw()).zzaex();
        this.zzgpt.zzaea().zzed(1);
        this.zzgtx = new zzbqv(this.zzgpt.zzadk(), this.zzgpt.zzadj(), zzcdaVarZzaex.zzaev().zzajh());
        this.zzgtx.zza(new zzdaj(this, zzdagVar, zzcdaVarZzaex));
        return true;
    }

    final /* synthetic */ void zzard() {
        this.zzgtw.zzara().zzk(zzdpe.zza(zzdpg.INVALID_AD_UNIT_ID, null, null));
    }

    final /* synthetic */ void zzare() {
        this.zzgtw.zzara().zzk(zzdpe.zza(zzdpg.APP_ID_MISSING, null, null));
    }
}
