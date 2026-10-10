package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcba implements zzeoy<zzcau> {
    private final zzeph<Set<zzcab<VideoController.VideoLifecycleCallbacks>>> zzfqq;

    private zzcba(zzeph<Set<zzcab<VideoController.VideoLifecycleCallbacks>>> zzephVar) {
        this.zzfqq = zzephVar;
    }

    public static zzcba zzv(zzeph<Set<zzcab<VideoController.VideoLifecycleCallbacks>>> zzephVar) {
        return new zzcba(zzephVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcau(this.zzfqq.get());
    }
}
