package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmg implements zzec<zzmj> {
    private static zzmg zza = new zzmg();
    private final zzec<zzmj> zzb;

    private zzmg(zzec<zzmj> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzmj) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmj) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzmj) zza.zza()).zzc();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmj zza() {
        return this.zzb.zza();
    }

    public zzmg() {
        this(zzef.zza(new zzmi()));
    }
}
