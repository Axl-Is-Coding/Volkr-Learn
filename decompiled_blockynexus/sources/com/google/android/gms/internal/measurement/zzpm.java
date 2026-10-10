package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpm implements zzec<zzpp> {
    private static zzpm zza = new zzpm();
    private final zzec<zzpp> zzb;

    private zzpm(zzec<zzpp> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzpp) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpp zza() {
        return this.zzb.zza();
    }

    public zzpm() {
        this(zzef.zza(new zzpo()));
    }
}
