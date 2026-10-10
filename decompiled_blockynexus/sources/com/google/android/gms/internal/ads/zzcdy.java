package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdy implements zzeoy<zzcdv> {
    private final zzeph<zzcei> zzfym;

    private zzcdy(zzeph<zzcei> zzephVar) {
        this.zzfym = zzephVar;
    }

    public static zzcdy zzy(zzeph<zzcei> zzephVar) {
        return new zzcdy(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcdv(this.zzfym.get());
    }
}
