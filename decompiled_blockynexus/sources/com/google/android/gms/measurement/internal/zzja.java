package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzja extends zzai {
    private final /* synthetic */ zzir zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzja(zzir zzirVar, zzgt zzgtVar) {
        super(zzgtVar);
        this.zza = zzirVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzai
    public final void zza() {
        this.zza.zzq().zzh().zza("Tasks have been queued for a long time");
    }
}
