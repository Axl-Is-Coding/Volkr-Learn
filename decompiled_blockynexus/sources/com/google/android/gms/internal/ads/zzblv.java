package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzblv implements zzeoy<zzawo> {
    private final zzblh zzfmq;

    public zzblv(zzblh zzblhVar) {
        this.zzfmq = zzblhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzawo zzawoVarZzlp = com.google.android.gms.ads.internal.zzp.zzlp();
        zzepe.zza(zzawoVarZzlp, "Cannot return null from a non-@Nullable @Provides method");
        return zzawoVarZzlp;
    }
}
