package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzciy implements Callable<zzcil> {
    private final zzbgr zzbpt;
    private final zzbbx zzdqm;
    private final zzeg zzeom;
    private final Executor zzfoc;
    private final com.google.android.gms.ads.internal.zzb zzgdm;
    private final Context zzvr;

    public zzciy(Context context, Executor executor, zzeg zzegVar, zzbbx zzbbxVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbgr zzbgrVar) {
        this.zzvr = context;
        this.zzfoc = executor;
        this.zzeom = zzegVar;
        this.zzdqm = zzbbxVar;
        this.zzgdm = zzbVar;
        this.zzbpt = zzbgrVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzcil call() throws Exception {
        zzcil zzcilVar = new zzcil(this);
        zzcilVar.zzans();
        return zzcilVar;
    }
}
