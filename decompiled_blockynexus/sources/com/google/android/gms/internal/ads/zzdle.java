package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqo;
import com.google.android.gms.internal.ads.zzbtn;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdle<R extends zzbtn<AdT>, AdT extends zzbqo> implements zzdlv<R, zzdli<AdT>> {
    private final Executor executor;
    private final zzdpz zzhbu;
    private zzdyr<Void> zzhbv = new zzdlj(this);

    public zzdle(zzdpz zzdpzVar, Executor executor) {
        this.zzhbu = zzdpzVar;
        this.executor = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final zzdzc<zzdli<AdT>> zza(final zzdlw zzdlwVar, final zzdlx<R> zzdlxVar) {
        return zzdyl.zzg(new zzdlp(this.zzhbu, zzdlwVar.zzhcf, zzdlxVar, this.executor).zzata()).zzb(new zzdya(this, zzdlwVar, zzdlxVar) { // from class: com.google.android.gms.internal.ads.zzdlh
            private final zzdlw zzhbi;
            private final zzdle zzhbx;
            private final zzdlx zzhby;

            {
                this.zzhbx = this;
                this.zzhbi = zzdlwVar;
                this.zzhby = zzdlxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzhbx.zza(this.zzhbi, this.zzhby, (zzdlt) obj);
            }
        }, this.executor).zza(Exception.class, new zzdlg(this), this.executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdlv
    public final /* bridge */ /* synthetic */ Object zzasv() {
        return null;
    }

    final /* synthetic */ zzdzc zza(zzdlw zzdlwVar, zzdlx zzdlxVar, zzdlt zzdltVar) throws Exception {
        zzdqj zzdqjVar = zzdltVar.zzhbs;
        zzatc zzatcVar = zzdltVar.zzgkg;
        zzdqk<?> zzdqkVarZza = zzdqjVar != null ? this.zzhbu.zza(zzdqjVar) : null;
        if (zzdqjVar == null) {
            return zzdyq.zzaf(null);
        }
        if (zzdqkVarZza != null && zzatcVar != null) {
            zzdyq.zza(((zzbtn) zzdlxVar.zzc(zzdlwVar.zzhcf).zzaey()).zzaev().zzc(zzatcVar), this.zzhbv, this.executor);
        }
        return zzdyq.zzaf(new zzdli(zzdqjVar, zzatcVar, zzdqkVarZza));
    }
}
