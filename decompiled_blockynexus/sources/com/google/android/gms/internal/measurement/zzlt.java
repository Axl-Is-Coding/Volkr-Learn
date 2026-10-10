package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlt implements zzec<zzls> {
    private static zzlt zza = new zzlt();
    private final zzec<zzls> zzb;

    private zzlt(zzec<zzls> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzls) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzls zza() {
        return this.zzb.zza();
    }

    public zzlt() {
        this(zzef.zza(new zzlv()));
    }
}
