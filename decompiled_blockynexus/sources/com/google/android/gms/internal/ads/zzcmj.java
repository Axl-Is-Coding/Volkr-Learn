package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmj implements zzeoy<zzcmk> {
    private final zzeph<zzcmz> zzetn;
    private final zzeph<zzcms> zzevx;

    private zzcmj(zzeph<zzcms> zzephVar, zzeph<zzcmz> zzephVar2) {
        this.zzevx = zzephVar;
        this.zzetn = zzephVar2;
    }

    public static zzcmj zzai(zzeph<zzcms> zzephVar, zzeph<zzcmz> zzephVar2) {
        return new zzcmj(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcmk(this.zzevx.get(), this.zzetn.get());
    }
}
