package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznv implements zzec<zznu> {
    private static zznv zza = new zznv();
    private final zzec<zznu> zzb;

    private zznv(zzec<zznu> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zznu) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznu) zza.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznu zza() {
        return this.zzb.zza();
    }

    public zznv() {
        this(zzef.zza(new zznx()));
    }
}
