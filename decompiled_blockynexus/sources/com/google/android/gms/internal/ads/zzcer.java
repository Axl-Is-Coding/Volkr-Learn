package com.google.android.gms.internal.ads;

import a.a.i;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcer {
    zzaff zzgai;
    zzafe zzgaj;
    zzaft zzgak;
    zzafs zzgal;
    zzajk zzgam;
    final i<String, zzafl> zzgan = new i<>();
    final i<String, zzafk> zzgao = new i<>();

    public final zzcer zza(zzafs zzafsVar) {
        this.zzgal = zzafsVar;
        return this;
    }

    public final zzcep zzamw() {
        return new zzcep(this);
    }

    public final zzcer zzb(zzaff zzaffVar) {
        this.zzgai = zzaffVar;
        return this;
    }

    public final zzcer zzb(zzafe zzafeVar) {
        this.zzgaj = zzafeVar;
        return this;
    }

    public final zzcer zzb(zzaft zzaftVar) {
        this.zzgak = zzaftVar;
        return this;
    }

    public final zzcer zzb(zzajk zzajkVar) {
        this.zzgam = zzajkVar;
        return this;
    }

    public final zzcer zzb(String str, zzafl zzaflVar, zzafk zzafkVar) {
        this.zzgan.put(str, zzaflVar);
        this.zzgao.put(str, zzafkVar);
        return this;
    }
}
