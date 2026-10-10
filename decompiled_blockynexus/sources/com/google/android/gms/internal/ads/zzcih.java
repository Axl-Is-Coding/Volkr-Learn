package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcih implements zzeoy<zzcif> {
    private final zzeph<zzcfe> zzfem;
    private final zzeph<Context> zzfth;
    private final zzeph<zzcei> zzfym;
    private final zzeph<zzcdx> zzged;

    private zzcih(zzeph<Context> zzephVar, zzeph<zzcei> zzephVar2, zzeph<zzcfe> zzephVar3, zzeph<zzcdx> zzephVar4) {
        this.zzfth = zzephVar;
        this.zzfym = zzephVar2;
        this.zzfem = zzephVar3;
        this.zzged = zzephVar4;
    }

    public static zzcih zzc(zzeph<Context> zzephVar, zzeph<zzcei> zzephVar2, zzeph<zzcfe> zzephVar3, zzeph<zzcdx> zzephVar4) {
        return new zzcih(zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcif(this.zzfth.get(), this.zzfym.get(), this.zzfem.get(), this.zzged.get());
    }
}
