package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpa implements zzec<zzpd> {
    private static zzpa zza = new zzpa();
    private final zzec<zzpd> zzb;

    private zzpa(zzec<zzpd> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzpd) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzpd) zza.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpd zza() {
        return this.zzb.zza();
    }

    public zzpa() {
        this(zzef.zza(new zzpc()));
    }
}
