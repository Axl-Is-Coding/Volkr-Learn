package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzms implements zzec<zzmv> {
    private static zzms zza = new zzms();
    private final zzec<zzmv> zzb;

    private zzms(zzec<zzmv> zzecVar) {
        this.zzb = zzef.zza((zzec) zzecVar);
    }

    public static boolean zzb() {
        return ((zzmv) zza.zza()).zza();
    }

    public static boolean zzc() {
        return ((zzmv) zza.zza()).zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final /* synthetic */ zzmv zza() {
        return this.zzb.zza();
    }

    public zzms() {
        this(zzef.zza(new zzmu()));
    }
}
