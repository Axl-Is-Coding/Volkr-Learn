package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjc implements zzeoy<WeakReference<Context>> {
    private final zzbja zzesn;

    public zzbjc(zzbja zzbjaVar) {
        this.zzesn = zzbjaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        WeakReference<Context> weakReferenceZzaec = this.zzesn.zzaec();
        zzepe.zza(weakReferenceZzaec, "Cannot return null from a non-@Nullable @Provides method");
        return weakReferenceZzaec;
    }
}
