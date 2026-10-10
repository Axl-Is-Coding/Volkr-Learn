package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdsn implements zzeoy<zzdsi> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<zzdsh> zzewr;
    private final zzeph<ScheduledExecutorService> zzfpy;

    private zzdsn(zzeph<zzdzb> zzephVar, zzeph<ScheduledExecutorService> zzephVar2, zzeph<zzdsh> zzephVar3) {
        this.zzesr = zzephVar;
        this.zzfpy = zzephVar2;
        this.zzewr = zzephVar3;
    }

    public static zzdsn zzx(zzeph<zzdzb> zzephVar, zzeph<ScheduledExecutorService> zzephVar2, zzeph<zzdsh> zzephVar3) {
        return new zzdsn(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdsi(this.zzesr.get(), this.zzfpy.get(), this.zzewr.get());
    }
}
