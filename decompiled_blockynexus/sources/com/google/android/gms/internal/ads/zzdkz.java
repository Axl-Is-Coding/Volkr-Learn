package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbtn;
import com.google.android.gms.internal.ads.zzua;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdkz<R extends zzbtn<AdT>, AdT extends zzbqo> implements zzdlv<R, AdT> {
    private final Executor executor;
    private final zzdlv<R, AdT> zzhaj;
    private final zzdlv<R, zzdli<AdT>> zzhbl;
    private final zzdqs<AdT> zzhbm;
    private R zzhbn;

    public zzdkz(zzdlv<R, AdT> zzdlvVar, zzdlv<R, zzdli<AdT>> zzdlvVar2, zzdqs<AdT> zzdqsVar, Executor executor) {
        this.zzhaj = zzdlvVar;
        this.zzhbl = zzdlvVar2;
        this.zzhbm = zzdqsVar;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.ads.zzdlv
    /* JADX INFO: renamed from: zzasw, reason: merged with bridge method [inline-methods] */
    public final synchronized R zzasv() {
        return this.zzhbn;
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final synchronized zzdzc<AdT> zza(final zzdlw zzdlwVar, final zzdlx<R> zzdlxVar) {
        final zzdlc zzdlcVar;
        zzdok zzdokVarZzafs = zzdlxVar.zzc(zzdlwVar.zzhcf).zzaey().zzafs();
        zzdlcVar = new zzdlc(zzdlxVar, zzdlwVar, zzdokVarZzafs.zzhfa, zzdokVarZzafs.zzhfb, this.executor, zzdokVarZzafs.zzhfe, null);
        return zzdyl.zzg(this.zzhbl.zza(zzdlwVar, zzdlxVar)).zzb(new zzdya(this, zzdlwVar, zzdlcVar, zzdlxVar) { // from class: com.google.android.gms.internal.ads.zzdky
            private final zzdkz zzhbh;
            private final zzdlw zzhbi;
            private final zzdlc zzhbj;
            private final zzdlx zzhbk;

            {
                this.zzhbh = this;
                this.zzhbi = zzdlwVar;
                this.zzhbj = zzdlcVar;
                this.zzhbk = zzdlxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzhbh.zza(this.zzhbi, this.zzhbj, this.zzhbk, (zzdli) obj);
            }
        }, this.executor);
    }

    private final zzdzc<AdT> zza(zzdqk<AdT> zzdqkVar, zzdlw zzdlwVar, zzdlx<R> zzdlxVar) {
        final zzbtq<R> zzbtqVarZzc = zzdlxVar.zzc(zzdlwVar.zzhcf);
        if (zzdqkVar.zzhir != null) {
            R rZzaey = zzbtqVarZzc.zzaey();
            if (rZzaey.zzaft() != null) {
                zzdqkVar.zzhir.zzaiy().zzb(rZzaey.zzaft());
            }
            return zzdyq.zzaf(zzdqkVar.zzhir);
        }
        zzbtqVarZzc.zza(zzdqkVar.zzevd);
        zzdzc<AdT> zzdzcVarZza = this.zzhaj.zza(zzdlwVar, new zzdlx(zzbtqVarZzc) { // from class: com.google.android.gms.internal.ads.zzdlb
            private final zzbtq zzhbp;

            {
                this.zzhbp = zzbtqVarZzc;
            }

            @Override // com.google.android.gms.internal.ads.zzdlx
            public final zzbtq zzc(zzdlu zzdluVar) {
                return this.zzhbp;
            }
        });
        this.zzhbn = this.zzhaj.zzasv();
        return zzdzcVarZza;
    }

    final /* synthetic */ zzdzc zza(zzdlx zzdlxVar, zzdqw zzdqwVar) throws Exception {
        zzdqy zzdqyVar;
        if (zzdqwVar != null && zzdqwVar.zzhbz != null && (zzdqyVar = zzdqwVar.zzhjh) != null) {
            zzdqwVar.zzhbz.zzhiq.zzaji().zze((zzua.zzb) zzua.zzb.zzni().zza(zzua.zzb.zza.zzng().zzb(zzua.zzb.zzc.IN_MEMORY).zza(zzua.zzb.zzd.zznk())).zzbgt());
            return zza(zzdqwVar.zzhbz, ((zzdlc) zzdqyVar).zzhbr, zzdlxVar);
        }
        throw new zzcof(zzdpg.INTERNAL_ERROR, "Empty prefetch");
    }

    final /* synthetic */ zzdzc zza(zzdlw zzdlwVar, zzdlc zzdlcVar, final zzdlx zzdlxVar, zzdli zzdliVar) throws Exception {
        if (zzdliVar != null) {
            zzdlc zzdlcVar2 = new zzdlc(zzdlcVar.zzhbq, zzdlcVar.zzhbr, zzdlcVar.zzdqr, zzdlcVar.zzbuu, zzdlcVar.executor, zzdlcVar.zzgvr, zzdliVar.zzhbs);
            if (zzdliVar.zzhbz != null) {
                this.zzhbn = null;
                this.zzhbm.zzb(zzdlcVar2);
                return zza(zzdliVar.zzhbz, zzdlwVar, zzdlxVar);
            }
            zzdzc<zzdqw<AdT>> zzdzcVarZzc = this.zzhbm.zzc(zzdlcVar2);
            if (zzdzcVarZzc != null) {
                this.zzhbn = (R) zzdlxVar.zzc(zzdlwVar.zzhcf).zzaey();
                return zzdyq.zzb(zzdzcVarZzc, new zzdya(this, zzdlxVar) { // from class: com.google.android.gms.internal.ads.zzdla
                    private final zzdkz zzhbh;
                    private final zzdlx zzhbo;

                    {
                        this.zzhbh = this;
                        this.zzhbo = zzdlxVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzdya
                    public final zzdzc zzf(Object obj) {
                        return this.zzhbh.zza(this.zzhbo, (zzdqw) obj);
                    }
                }, this.executor);
            }
            this.zzhbm.zzb(zzdlcVar2);
            zzdlwVar = new zzdlw(zzdlwVar.zzhcf, zzdliVar.zzgkg);
        }
        zzdzc<AdT> zzdzcVarZza = this.zzhaj.zza(zzdlwVar, zzdlxVar);
        this.zzhbn = this.zzhaj.zzasv();
        return zzdzcVarZza;
    }
}
