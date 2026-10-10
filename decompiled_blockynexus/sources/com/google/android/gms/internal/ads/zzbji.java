package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbji implements zzeoy<String> {
    private final zzbja zzesn;

    public zzbji(zzbja zzbjaVar) {
        this.zzesn = zzbjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        String strZzaee = this.zzesn.zzaee();
        zzepe.zza(strZzaee, "Cannot return null from a non-@Nullable @Provides method");
        return strZzaee;
    }
}
