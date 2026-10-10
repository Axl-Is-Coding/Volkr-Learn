package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddd implements zzeoy<zzdcz> {
    private final zzeph<Executor> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<ScheduledExecutorService> zzfnm;

    private zzddd(zzeph<Context> zzephVar, zzeph<ScheduledExecutorService> zzephVar2, zzeph<Executor> zzephVar3) {
        this.zzesu = zzephVar;
        this.zzfnm = zzephVar2;
        this.zzesr = zzephVar3;
    }

    public static zzddd zzt(zzeph<Context> zzephVar, zzeph<ScheduledExecutorService> zzephVar2, zzeph<Executor> zzephVar3) {
        return new zzddd(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdcz(this.zzesu.get(), this.zzfnm.get(), this.zzesr.get());
    }
}
