package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzon implements zzec<zzom> {
    private static zzon zza = new zzon();
    private final zzec<zzom> zzb;

    private zzon(zzec<zzom> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzom) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzom zza() {
        return this.zzb.zza();
    }

    public zzon() {
        this(zzef.zza(new zzop()));
    }
}
