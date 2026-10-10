package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpg implements zzec<zzpj> {
    private static zzpg zza = new zzpg();
    private final zzec<zzpj> zzb;

    private zzpg(zzec<zzpj> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzpj) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzpj) zza.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpj zza() {
        return this.zzb.zza();
    }

    public zzpg() {
        this(zzef.zza(new zzpi()));
    }
}
