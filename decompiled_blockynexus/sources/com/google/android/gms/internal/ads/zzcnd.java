package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcnd implements zzeoy<zzcne> {
    private final zzeph<String> zzght;
    private final zzeph<zzcmz> zzghu;

    public zzcnd(zzeph<String> zzephVar, zzeph<zzcmz> zzephVar2) {
        this.zzght = zzephVar;
        this.zzghu = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcne(this.zzght.get(), this.zzghu.get());
    }
}
