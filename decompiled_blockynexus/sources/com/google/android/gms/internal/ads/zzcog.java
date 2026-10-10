package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcog implements zzeoy<zzcnu> {
    private final zzeph<zzcku> zzeso;
    private final zzeph<Executor> zzesr;
    private final zzeph<zzcne> zzeto;
    private final zzeph<ScheduledExecutorService> zzfnm;
    private final zzeph<zzbbx> zzfov;
    private final zzeph<Executor> zzfqk;
    private final zzeph<Context> zzgiz;
    private final zzeph<WeakReference<Context>> zzgja;

    public zzcog(zzeph<Executor> zzephVar, zzeph<Context> zzephVar2, zzeph<WeakReference<Context>> zzephVar3, zzeph<Executor> zzephVar4, zzeph<zzcku> zzephVar5, zzeph<ScheduledExecutorService> zzephVar6, zzeph<zzcne> zzephVar7, zzeph<zzbbx> zzephVar8) {
        this.zzfqk = zzephVar;
        this.zzgiz = zzephVar2;
        this.zzgja = zzephVar3;
        this.zzesr = zzephVar4;
        this.zzeso = zzephVar5;
        this.zzfnm = zzephVar6;
        this.zzeto = zzephVar7;
        this.zzfov = zzephVar8;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcnu(this.zzfqk.get(), this.zzgiz.get(), this.zzgja.get(), this.zzesr.get(), this.zzeso.get(), this.zzfnm.get(), this.zzeto.get(), this.zzfov.get());
    }
}
