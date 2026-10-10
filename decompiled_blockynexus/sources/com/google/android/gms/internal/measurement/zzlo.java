package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlo implements zzec<zzlr> {
    private static zzlo zza = new zzlo();
    private final zzec<zzlr> zzb;

    private zzlo(zzec<zzlr> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzlr) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzlr) zza.zza()).zzb();
    }

    public static boolean zzd() {
        return ((zzlr) zza.zza()).zzc();
    }

    public static boolean zze() {
        return ((zzlr) zza.zza()).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzlr zza() {
        return this.zzb.zza();
    }

    public zzlo() {
        this(zzef.zza(new zzlq()));
    }
}
