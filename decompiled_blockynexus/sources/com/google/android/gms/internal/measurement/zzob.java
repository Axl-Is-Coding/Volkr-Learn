package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzob implements zzec<zzoa> {
    private static zzob zza = new zzob();
    private final zzec<zzoa> zzb;

    private zzob(zzec<zzoa> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzoa) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzoa) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzoa) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zzoa) zza.zza()).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzoa zza() {
        return this.zzb.zza();
    }

    public zzob() {
        this(zzef.zza(new zzod()));
    }
}
