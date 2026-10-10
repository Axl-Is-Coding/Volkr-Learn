package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzoo implements zzec<zzor> {
    private static zzoo zza = new zzoo();
    private final zzec<zzor> zzb;

    private zzoo(zzec<zzor> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzor) zza.zza()).zza();
    }

    public static double zzc() {
        return ((zzor) zza.zza()).zzb();
    }

    public static long zzd() {
        return ((zzor) zza.zza()).zzc();
    }

    public static long zze() {
        return ((zzor) zza.zza()).zzd();
    }

    public static String zzf() {
        return ((zzor) zza.zza()).zze();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzor zza() {
        return this.zzb.zza();
    }

    public zzoo() {
        this(zzef.zza(new zzoq()));
    }
}
