package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpf implements zzec<zzpe> {
    private static zzpf zza = new zzpf();
    private final zzec<zzpe> zzb;

    private zzpf(zzec<zzpe> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzpe) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpe zza() {
        return this.zzb.zza();
    }

    public zzpf() {
        this(zzef.zza(new zzph()));
    }
}
