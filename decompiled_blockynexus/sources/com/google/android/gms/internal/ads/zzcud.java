package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcud implements zzeoy<zzcub> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbx> zzfov;
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzbpm> zzgof;

    public zzcud(zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<zzbpm> zzephVar3, zzeph<Executor> zzephVar4) {
        this.zzesu = zzephVar;
        this.zzfov = zzephVar2;
        this.zzgof = zzephVar3;
        this.zzfqk = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcub(this.zzesu.get(), this.zzfov.get(), this.zzgof.get(), this.zzfqk.get());
    }
}
