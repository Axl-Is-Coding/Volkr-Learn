package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjj implements zzeoy<String> {
    private final zzbja zzesn;

    public zzbjj(zzbja zzbjaVar) {
        this.zzesn = zzbjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        String strZzpy = zzwm.zzpy();
        zzepe.zza(strZzpy, "Cannot return null from a non-@Nullable @Provides method");
        return strZzpy;
    }
}
