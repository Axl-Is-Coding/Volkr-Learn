package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzceg implements zzeoy<zzced> {
    private final zzeph<zzcdv> zzfzq;

    private zzceg(zzeph<zzcdv> zzephVar) {
        this.zzfzq = zzephVar;
    }

    public static zzceg zzz(zzeph<zzcdv> zzephVar) {
        return new zzceg(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzced(this.zzfzq.get());
    }
}
