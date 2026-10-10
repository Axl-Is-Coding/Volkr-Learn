package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnm implements zzeoy<View> {
    private final zzbnj zzfpi;

    public zzbnm(zzbnj zzbnjVar) {
        this.zzfpi = zzbnjVar;
    }

    public static View zza(zzbnj zzbnjVar) {
        View viewZzahm = zzbnjVar.zzahm();
        zzepe.zza(viewZzahm, "Cannot return null from a non-@Nullable @Provides method");
        return viewZzahm;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfpi);
    }
}
