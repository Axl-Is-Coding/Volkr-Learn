package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdw implements zzeoy<zzbnd> {
    private final zzeph<Executor> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<Clock> zzfok;
    private final zzeph<zzqo> zzfys;

    public zzcdw(zzeph<zzqo> zzephVar, zzeph<Executor> zzephVar2, zzeph<Context> zzephVar3, zzeph<Clock> zzephVar4) {
        this.zzfys = zzephVar;
        this.zzesr = zzephVar2;
        this.zzesu = zzephVar3;
        this.zzfok = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzqo zzqoVar = this.zzfys.get();
        Executor executor = this.zzesr.get();
        Context context = this.zzesu.get();
        zzbnd zzbndVar = new zzbnd(executor, new zzbms(context, zzqoVar), this.zzfok.get());
        zzepe.zza(zzbndVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzbndVar;
    }
}
