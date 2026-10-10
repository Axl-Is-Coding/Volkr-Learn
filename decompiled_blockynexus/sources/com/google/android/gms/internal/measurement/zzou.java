package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzou implements zzec<zzox> {
    private static zzou zza = new zzou();
    private final zzec<zzox> zzb;

    private zzou(zzec<zzox> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzox) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzox zza() {
        return this.zzb.zza();
    }

    public zzou() {
        this(zzef.zza(new zzow()));
    }
}
