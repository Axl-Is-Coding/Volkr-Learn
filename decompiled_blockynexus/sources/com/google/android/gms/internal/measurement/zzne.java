package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzne implements zzec<zznh> {
    private static zzne zza = new zzne();
    private final zzec<zznh> zzb;

    private zzne(zzec<zznh> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zznh) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zznh) zza.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zznh zza() {
        return this.zzb.zza();
    }

    public zzne() {
        this(zzef.zza(new zzng()));
    }
}
