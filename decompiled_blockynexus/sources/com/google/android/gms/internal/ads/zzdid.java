package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdid implements zzeoy<zzdhz> {
    private final zzeph<Executor> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zzaxx> zzetv;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<zzayb> zzgvj;
    private final zzeph<Integer> zzgzc;

    public zzdid(zzeph<zzaxx> zzephVar, zzeph<Integer> zzephVar2, zzeph<Context> zzephVar3, zzeph<zzayb> zzephVar4, zzeph<ScheduledExecutorService> zzephVar5, zzeph<Executor> zzephVar6) {
        this.zzetv = zzephVar;
        this.zzgzc = zzephVar2;
        this.zzesu = zzephVar3;
        this.zzgvj = zzephVar4;
        this.zzfnm = zzephVar5;
        this.zzesr = zzephVar6;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdhz(this.zzetv.get(), this.zzgzc.get().intValue(), this.zzesu.get(), this.zzgvj.get(), this.zzfnm.get(), this.zzesr.get());
    }
}
