package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcnb implements zzeoy<zzcmz> {
    private final zzeph<Executor> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbu> zzezd;
    private final zzeph<zzbbx> zzfmh;

    public zzcnb(zzeph<Executor> zzephVar, zzeph<zzbbu> zzephVar2, zzeph<Context> zzephVar3, zzeph<zzbbx> zzephVar4) {
        this.zzesr = zzephVar;
        this.zzezd = zzephVar2;
        this.zzesu = zzephVar3;
        this.zzfmh = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcmz(this.zzesr.get(), this.zzezd.get(), this.zzesu.get(), this.zzfmh.get());
    }
}
