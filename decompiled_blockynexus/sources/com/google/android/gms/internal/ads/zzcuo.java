package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcuo implements zzeoy<zzcuj> {
    private final zzeph<Context> zzesu;
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzcce> zzgof;
    private final zzeph<zzdnt> zzgox;

    public zzcuo(zzeph<Context> zzephVar, zzeph<Executor> zzephVar2, zzeph<zzcce> zzephVar3, zzeph<zzdnt> zzephVar4) {
        this.zzesu = zzephVar;
        this.zzfqk = zzephVar2;
        this.zzgof = zzephVar3;
        this.zzgox = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcuj(this.zzesu.get(), this.zzfqk.get(), this.zzgof.get(), this.zzgox.get());
    }
}
