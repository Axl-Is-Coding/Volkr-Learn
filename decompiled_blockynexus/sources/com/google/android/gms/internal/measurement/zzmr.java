package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmr implements zzec<zzmq> {
    private static zzmr zza = new zzmr();
    private final zzec<zzmq> zzb;

    private zzmr(zzec<zzmq> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzmq) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmq zza() {
        return this.zzb.zza();
    }

    public zzmr() {
        this(zzef.zza(new zzmt()));
    }
}
