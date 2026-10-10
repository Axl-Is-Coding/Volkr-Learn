package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcuk implements zzeoy<zzcug> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzbpm> zzgof;

    public zzcuk(zzeph<Context> zzephVar, zzeph<zzbpm> zzephVar2) {
        this.zzesu = zzephVar;
        this.zzgof = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcug(this.zzesu.get(), this.zzgof.get());
    }
}
