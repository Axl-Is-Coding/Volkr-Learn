package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznw implements zzec<zznz> {
    private static zznw zza = new zznw();
    private final zzec<zznz> zzb;

    private zznw(zzec<zznz> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zznz) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznz) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zznz) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zznz) zza.zza()).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznz zza() {
        return this.zzb.zza();
    }

    public zznw() {
        this(zzef.zza(new zzny()));
    }
}
