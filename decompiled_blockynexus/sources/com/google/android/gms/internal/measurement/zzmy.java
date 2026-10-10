package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmy implements zzec<zznb> {
    private static zzmy zza = new zzmy();
    private final zzec<zznb> zzb;

    private zzmy(zzec<zznb> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zznb) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznb) zza.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznb zza() {
        return this.zzb.zza();
    }

    public zzmy() {
        this(zzef.zza(new zzna()));
    }
}
