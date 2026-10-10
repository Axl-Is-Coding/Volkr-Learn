package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhm implements zzeoy<zzdhl> {
    private final zzeph<Executor> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zzaxx> zzetv;
    private final zzeph<ScheduledExecutorService> zzfnm;

    public zzdhm(zzeph<zzaxx> zzephVar, zzeph<Context> zzephVar2, zzeph<ScheduledExecutorService> zzephVar3, zzeph<Executor> zzephVar4) {
        this.zzetv = zzephVar;
        this.zzesu = zzephVar2;
        this.zzfnm = zzephVar3;
        this.zzesr = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdhl(this.zzetv.get(), this.zzesu.get(), this.zzfnm.get(), this.zzesr.get());
    }
}
