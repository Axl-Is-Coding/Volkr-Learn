package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcgp implements zzeoy<zzcgn> {
    private final zzeph<Executor> zzesr;
    private final zzeph<zzbag> zzezq;
    private final zzeph<Clock> zzfok;

    public zzcgp(zzeph<zzbag> zzephVar, zzeph<Clock> zzephVar2, zzeph<Executor> zzephVar3) {
        this.zzezq = zzephVar;
        this.zzfok = zzephVar2;
        this.zzesr = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcgn(this.zzezq.get(), this.zzfok.get(), this.zzesr.get());
    }
}
