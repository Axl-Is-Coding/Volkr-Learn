package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzctu implements zzeoy<zzctq> {
    private final zzeph<Context> zzesu;
    private final zzeph<Executor> zzfqk;
    private final zzeph<zzcjt> zzgbz;
    private final zzeph<zzbnq> zzgof;

    public zzctu(zzeph<zzbnq> zzephVar, zzeph<Context> zzephVar2, zzeph<Executor> zzephVar3, zzeph<zzcjt> zzephVar4) {
        this.zzgof = zzephVar;
        this.zzesu = zzephVar2;
        this.zzfqk = zzephVar3;
        this.zzgbz = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzctq(this.zzgof.get(), this.zzesu.get(), this.zzfqk.get(), this.zzgbz.get());
    }
}
