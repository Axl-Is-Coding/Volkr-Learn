package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznk implements zzec<zznn> {
    private static zznk zza = new zznk();
    private final zzec<zznn> zzb;

    private zznk(zzec<zznn> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zznn) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznn) zza.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznn zza() {
        return this.zzb.zza();
    }

    public zznk() {
        this(zzef.zza(new zznm()));
    }
}
