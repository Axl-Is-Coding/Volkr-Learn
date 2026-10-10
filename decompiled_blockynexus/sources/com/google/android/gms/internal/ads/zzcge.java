package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcge implements zzeoy<zzcgb> {
    private final zzeph<zzcem> zzfeh;
    private final zzeph<zzcei> zzfym;

    public zzcge(zzeph<zzcei> zzephVar, zzeph<zzcem> zzephVar2) {
        this.zzfym = zzephVar;
        this.zzfeh = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcgb(this.zzfym.get(), this.zzfeh.get());
    }
}
