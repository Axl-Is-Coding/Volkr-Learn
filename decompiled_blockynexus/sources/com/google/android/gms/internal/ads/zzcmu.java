package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmu {
    private final Executor executor;
    private final zzcmz zzghe;
    private final Map<String, String> zzghi;

    public zzcmu(zzcmz zzcmzVar, Executor executor) {
        this.zzghe = zzcmzVar;
        this.zzghi = zzcmzVar.zzapg();
        this.executor = executor;
    }

    public final zzcmt zzapf() {
        zzcmt zzcmtVar = new zzcmt(this);
        zzcmt.zzb(zzcmtVar);
        return zzcmtVar;
    }
}
