package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdq implements zzeoy<zzcem> {
    private final zzeph<zzcel> zzfez;
    private final zzcdl zzfyp;

    public zzcdq(zzcdl zzcdlVar, zzeph<zzcel> zzephVar) {
        this.zzfyp = zzcdlVar;
        this.zzfez = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcel zzcelVar = this.zzfez.get();
        zzepe.zza(zzcelVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcelVar;
    }
}
