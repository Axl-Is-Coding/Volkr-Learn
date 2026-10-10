package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmm implements zzec<zzmp> {
    private static zzmm zza = new zzmm();
    private final zzec<zzmp> zzb;

    private zzmm(zzec<zzmp> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzmp) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmp zza() {
        return this.zzb.zza();
    }

    public zzmm() {
        this(zzef.zza(new zzmo()));
    }
}
