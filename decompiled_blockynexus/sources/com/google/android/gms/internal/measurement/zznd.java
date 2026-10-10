package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznd implements zzec<zznc> {
    private static zznd zza = new zznd();
    private final zzec<zznc> zzb;

    private zznd(zzec<zznc> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zznc) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznc) zza.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznc zza() {
        return this.zzb.zza();
    }

    public zznd() {
        this(zzef.zza(new zznf()));
    }
}
