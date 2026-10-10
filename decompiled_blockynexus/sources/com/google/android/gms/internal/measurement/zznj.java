package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznj implements zzec<zzni> {
    private static zznj zza = new zznj();
    private final zzec<zzni> zzb;

    private zznj(zzec<zzni> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzni) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzni) zza.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzni zza() {
        return this.zzb.zza();
    }

    public zznj() {
        this(zzef.zza(new zznl()));
    }
}
