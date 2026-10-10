package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzot implements zzec<zzos> {
    private static zzot zza = new zzot();
    private final zzec<zzos> zzb;

    private zzot(zzec<zzos> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzos) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzos zza() {
        return this.zzb.zza();
    }

    public zzot() {
        this(zzef.zza(new zzov()));
    }
}
