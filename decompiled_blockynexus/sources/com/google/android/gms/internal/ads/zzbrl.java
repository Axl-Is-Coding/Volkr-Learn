package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbrl<T> {
    private final Executor executor;
    private final zzcpf zzfsi;
    private final zzcpp zzfsj;
    private final zzdok zzfsk;
    private final zzdsi zzfsl;
    private final zzblx zzfsm;
    private final zzcwq<T> zzfsn;
    private final zzbyg zzfso;
    private final zzdog zzfsp;
    private final zzcql zzfsq;
    private final zzbtm zzfsr;
    private final zzcqi zzfss;
    private final zzctd zzfst;

    zzbrl(zzcpf zzcpfVar, zzcpp zzcppVar, zzdok zzdokVar, zzdsi zzdsiVar, zzblx zzblxVar, zzcwq<T> zzcwqVar, zzbyg zzbygVar, zzdog zzdogVar, zzcql zzcqlVar, zzbtm zzbtmVar, Executor executor, zzcqi zzcqiVar, zzctd zzctdVar) {
        this.zzfsi = zzcpfVar;
        this.zzfsj = zzcppVar;
        this.zzfsk = zzdokVar;
        this.zzfsl = zzdsiVar;
        this.zzfsm = zzblxVar;
        this.zzfsn = zzcwqVar;
        this.zzfso = zzbygVar;
        this.zzfsp = zzdogVar;
        this.zzfsq = zzcqlVar;
        this.zzfsr = zzbtmVar;
        this.executor = executor;
        this.zzfss = zzcqiVar;
        this.zzfst = zzctdVar;
    }

    private final zzdzc<zzdog> zza(zzdzc<zzatc> zzdzcVar) {
        if (this.zzfsp != null) {
            return this.zzfsl.zzu(zzdsf.SERVER_TRANSACTION).zze(zzdyq.zzaf(this.zzfsp)).zzavs();
        }
        com.google.android.gms.ads.internal.zzp.zzkx().zzmv();
        if (this.zzfsk.zzhfa.zzcho != null) {
            return this.zzfsl.zzu(zzdsf.SERVER_TRANSACTION).zze(this.zzfsj.zzapy()).zzavs();
        }
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcyj)).booleanValue()) {
            return this.zzfsl.zza(zzdsf.SERVER_TRANSACTION, zzdzcVar).zza(this.zzfsi).zzavs();
        }
        zzdsa<I> zzdsaVarZza = this.zzfsl.zza(zzdsf.SERVER_TRANSACTION, zzdzcVar);
        zzcqi zzcqiVar = this.zzfss;
        zzcqiVar.getClass();
        return zzdsaVarZza.zza(zzbro.zza(zzcqiVar)).zzavs();
    }

    public final zzdzc<zzdog> zzajg() {
        return zza(this.zzfsr.zzajp());
    }

    public final zzdzc<T> zzajh() {
        return zzb(zzajg());
    }

    public final zzbyg zzaji() {
        return this.zzfso;
    }

    public final zzdzc<T> zzb(zzdzc<zzdog> zzdzcVar) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcva)).booleanValue()) {
            return this.zzfsl.zza(zzdsf.RENDERER, zzdzcVar).zza(this.zzfsm).zza(this.zzfsn).zzavs();
        }
        return this.zzfsl.zza(zzdsf.RENDERER, zzdzcVar).zza(this.zzfsm).zza(this.zzfsn).zza(((Integer) zzwm.zzpx().zzd(zzabb.zzcvb)).intValue(), TimeUnit.SECONDS).zzavs();
    }

    public final zzdzc<Void> zzc(zzatc zzatcVar) {
        zzdrr zzdrrVarZzavs = this.zzfsl.zza(zzdsf.NOTIFY_CACHE_HIT, this.zzfsq.zzm(zzatcVar)).zzavs();
        zzdyq.zza(zzdrrVarZzavs, new zzbrp(this), this.executor);
        return zzdrrVarZzavs;
    }

    public final zzva zze(Throwable th) {
        return zzdpe.zza(th, this.zzfst);
    }

    public final zzdzc<T> zzb(zzatc zzatcVar) {
        return zzb(zza(zzatcVar));
    }

    public final zzdzc<zzdog> zza(zzatc zzatcVar) {
        return zza(zzdyq.zzaf(zzatcVar));
    }

    public final zzdzc<zzatc> zza(final zzdqg zzdqgVar) {
        zzdrr zzdrrVarZzavs = this.zzfsl.zza(zzdsf.GET_CACHE_KEY, this.zzfsr.zzajp()).zza(new zzdya(this, zzdqgVar) { // from class: com.google.android.gms.internal.ads.zzbrn
            private final zzbrl zzfsu;
            private final zzdqg zzfsv;

            {
                this.zzfsu = this;
                this.zzfsv = zzdqgVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzfsu.zza(this.zzfsv, (zzatc) obj);
            }
        }).zzavs();
        zzdyq.zza(zzdrrVarZzavs, new zzbrq(this), this.executor);
        return zzdrrVarZzavs;
    }

    final /* synthetic */ zzdzc zza(zzdqg zzdqgVar, zzatc zzatcVar) throws Exception {
        zzatcVar.zzdub = zzdqgVar;
        return this.zzfsq.zzl(zzatcVar);
    }
}
