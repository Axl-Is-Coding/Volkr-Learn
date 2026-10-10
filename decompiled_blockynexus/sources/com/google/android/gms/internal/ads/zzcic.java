package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcic implements zzeoy<zzchx> {
    private final zzeph<zzcei> zzfym;
    private final zzeph<zzcdx> zzged;

    private zzcic(zzeph<zzcdx> zzephVar, zzeph<zzcei> zzephVar2) {
        this.zzged = zzephVar;
        this.zzfym = zzephVar2;
    }

    public static zzcic zzy(zzeph<zzcdx> zzephVar, zzeph<zzcei> zzephVar2) {
        return new zzcic(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzchx(this.zzged.get(), this.zzfym.get());
    }
}
