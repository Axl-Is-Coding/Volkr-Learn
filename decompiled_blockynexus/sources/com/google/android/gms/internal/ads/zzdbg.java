package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbg implements zzeoy<String> {
    private final zzdbd zzgur;

    public zzdbg(zzdbd zzdbdVar) {
        this.zzgur = zzdbdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        String strZzarh = this.zzgur.zzarh();
        zzepe.zza(strZzarh, "Cannot return null from a non-@Nullable @Provides method");
        return strZzarh;
    }
}
