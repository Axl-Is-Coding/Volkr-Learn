package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdes implements zzeoy<zzdeq> {
    private final zzeph<zzdzb> zzesr;

    private zzdes(zzeph<zzdzb> zzephVar) {
        this.zzesr = zzephVar;
    }

    public static zzdes zzao(zzeph<zzdzb> zzephVar) {
        return new zzdes(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdeq(this.zzesr.get());
    }
}
