package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcsx implements zzeoy<zzcsy> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzcsp> zzggy;
    private final zzeph<zzbbu> zzgno;

    public zzcsx(zzeph<Context> zzephVar, zzeph<zzcsp> zzephVar2, zzeph<zzbbu> zzephVar3) {
        this.zzesu = zzephVar;
        this.zzggy = zzephVar2;
        this.zzgno = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcsy(this.zzesu.get(), this.zzggy.get(), this.zzgno.get());
    }
}
