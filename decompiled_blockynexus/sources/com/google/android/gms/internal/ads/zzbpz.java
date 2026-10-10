package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpz implements zzeoy<Runnable> {
    private final zzbqa zzfrc;

    public zzbpz(zzbqa zzbqaVar) {
        this.zzfrc = zzbqaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Runnable runnableZzais = this.zzfrc.zzais();
        zzepe.zza(runnableZzais, "Cannot return null from a non-@Nullable @Provides method");
        return runnableZzais;
    }
}
