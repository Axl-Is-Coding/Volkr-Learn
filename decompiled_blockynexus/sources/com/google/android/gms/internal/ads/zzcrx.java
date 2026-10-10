package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcrx implements zzeoy<zzcrw> {
    private final zzeph<zzcru> zzeyu;
    private final zzeph<zzdzb> zzgly;

    private zzcrx(zzeph<zzcru> zzephVar, zzeph<zzdzb> zzephVar2) {
        this.zzeyu = zzephVar;
        this.zzgly = zzephVar2;
    }

    public static zzcrx zzav(zzeph<zzcru> zzephVar, zzeph<zzdzb> zzephVar2) {
        return new zzcrx(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcrw(this.zzeyu.get(), this.zzgly.get());
    }
}
