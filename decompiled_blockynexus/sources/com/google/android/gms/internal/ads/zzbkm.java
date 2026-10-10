package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbkm {
    private zzbky zzesw;
    private zzbja zzesx;
    private zzdsp zzfjy;
    private zzblh zzfjz;
    private zzdpf zzfka;

    private zzbkm() {
    }

    public final zzbkm zza(zzbky zzbkyVar) {
        zzepe.checkNotNull(zzbkyVar);
        this.zzesw = zzbkyVar;
        return this;
    }

    public final zzbix zzagf() {
        zzepe.zza(this.zzesx, (Class<zzbja>) zzbja.class);
        zzepe.zza(this.zzesw, (Class<zzbky>) zzbky.class);
        if (this.zzfjy == null) {
            this.zzfjy = new zzdsp();
        }
        if (this.zzfjz == null) {
            this.zzfjz = new zzblh();
        }
        if (this.zzfka == null) {
            this.zzfka = new zzdpf();
        }
        return new zzbjv(this.zzesx, this.zzesw, this.zzfjy, this.zzfjz, this.zzfka);
    }

    public final zzbkm zzc(zzbja zzbjaVar) {
        zzepe.checkNotNull(zzbjaVar);
        this.zzesx = zzbjaVar;
        return this;
    }
}
