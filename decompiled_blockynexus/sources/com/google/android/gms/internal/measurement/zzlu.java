package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlu implements zzec<zzlx> {
    private static zzlu zza = new zzlu();
    private final zzec<zzlx> zzb;

    private zzlu(zzec<zzlx> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzlx) zza.zza()).zza();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzlx zza() {
        return this.zzb.zza();
    }

    public zzlu() {
        this(zzef.zza(new zzlw()));
    }
}
