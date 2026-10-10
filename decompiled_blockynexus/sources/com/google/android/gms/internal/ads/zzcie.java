package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcie implements zzeoy<zzcib> {
    private final zzeph<String> zzfun;
    private final zzeph<zzcei> zzfym;
    private final zzeph<zzcdx> zzged;

    private zzcie(zzeph<String> zzephVar, zzeph<zzcdx> zzephVar2, zzeph<zzcei> zzephVar3) {
        this.zzfun = zzephVar;
        this.zzged = zzephVar2;
        this.zzfym = zzephVar3;
    }

    public static zzcie zzl(zzeph<String> zzephVar, zzeph<zzcdx> zzephVar2, zzeph<zzcei> zzephVar3) {
        return new zzcie(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcib(this.zzfun.get(), this.zzged.get(), this.zzfym.get());
    }
}
