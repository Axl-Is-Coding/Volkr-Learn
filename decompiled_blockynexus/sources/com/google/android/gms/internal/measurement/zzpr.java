package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpr implements zzec<zzpq> {
    private static zzpr zza = new zzpr();
    private final zzec<zzpq> zzb;

    private zzpr(zzec<zzpq> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzpq) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpq zza() {
        return this.zzb.zza();
    }

    public zzpr() {
        this(zzef.zza(new zzps()));
    }
}
