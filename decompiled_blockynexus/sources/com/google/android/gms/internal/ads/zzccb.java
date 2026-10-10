package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzccb implements zzeoy<zzccc> {
    private final zzeph<zzbwa> zzfdj;
    private final zzeph<zzbzx> zzfhp;

    private zzccb(zzeph<zzbwa> zzephVar, zzeph<zzbzx> zzephVar2) {
        this.zzfdj = zzephVar;
        this.zzfhp = zzephVar2;
    }

    public static zzccb zzw(zzeph<zzbwa> zzephVar, zzeph<zzbzx> zzephVar2) {
        return new zzccb(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzccc(this.zzfdj.get(), this.zzfhp.get());
    }
}
