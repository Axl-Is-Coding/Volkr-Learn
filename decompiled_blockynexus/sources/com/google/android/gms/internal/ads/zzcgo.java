package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcgo implements zzeoy<zzcab<VideoController.VideoLifecycleCallbacks>> {
    private final zzeph<zzcjc> zzfop;
    private final zzeph<Executor> zzfqk;
    private final zzcgf zzgcr;

    public zzcgo(zzcgf zzcgfVar, zzeph<zzcjc> zzephVar, zzeph<Executor> zzephVar2) {
        this.zzgcr = zzcgfVar;
        this.zzfop = zzephVar;
        this.zzfqk = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzcab zzcabVar = new zzcab(this.zzfop.get(), this.zzfqk.get());
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
