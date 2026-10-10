package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpl implements zzec<zzpk> {
    private static zzpl zza = new zzpl();
    private final zzec<zzpk> zzb;

    private zzpl(zzec<zzpk> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzpk) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzpk zza() {
        return this.zzb.zza();
    }

    public zzpl() {
        this(zzef.zza(new zzpn()));
    }
}
