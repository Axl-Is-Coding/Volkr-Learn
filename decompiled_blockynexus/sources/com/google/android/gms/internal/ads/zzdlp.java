package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbtn;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdlp<R extends zzbtn<? extends zzbqo>> {
    private final Executor executor;
    private final zzdlx<R> zzhbq;
    private final zzdpz zzhbu;
    private final zzdlu zzhcb;
    private zzdlt zzhcc;

    public zzdlp(zzdpz zzdpzVar, zzdlu zzdluVar, zzdlx<R> zzdlxVar, Executor executor) {
        this.zzhbu = zzdpzVar;
        this.zzhcb = zzdluVar;
        this.zzhbq = zzdlxVar;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public final zzdqj zzatb() {
        zzdok zzdokVarZzafs = this.zzhbq.zzc(this.zzhcb).zzaey().zzafs();
        return this.zzhbu.zza(zzdokVarZzafs.zzhfa, zzdokVarZzafs.zzhfb, zzdokVarZzafs.zzhfe);
    }

    public final zzdzc<zzdlt> zzata() {
        zzdzc zzdzcVarZza;
        zzdlt zzdltVar = this.zzhcc;
        if (zzdltVar != null) {
            return zzdyq.zzaf(zzdltVar);
        }
        if (zzada.zzdca.get().booleanValue()) {
            zzdzcVarZza = zzdyl.zzg(this.zzhbq.zzc(this.zzhcb).zza(new zzdlf(this.zzhbu.zzaty().zzhib)).zzaey().zzaev().zza(this.zzhbu.zzaty())).zza(new zzdlq(this), this.executor).zza(zzcqm.class, new zzdlr(this), this.executor);
        } else {
            this.zzhcc = new zzdlt(null, zzatb(), null);
            zzdzcVarZza = zzdyq.zzaf(this.zzhcc);
        }
        return zzdyq.zzb(zzdzcVarZza, zzdlo.zzdwz, this.executor);
    }
}
