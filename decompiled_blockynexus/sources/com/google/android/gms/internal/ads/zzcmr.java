package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmr implements zzeoy<zzcms> {
    private final zzeph<zzcmz> zzetn;

    private zzcmr(zzeph<zzcmz> zzephVar) {
        this.zzetn = zzephVar;
    }

    public static zzcmr zzab(zzeph<zzcmz> zzephVar) {
        return new zzcmr(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcms(this.zzetn.get());
    }
}
