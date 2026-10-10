package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjd implements zzeoy<Context> {
    private final zzbja zzesn;

    public zzbjd(zzbja zzbjaVar) {
        this.zzesn = zzbjaVar;
    }

    public static Context zza(zzbja zzbjaVar) {
        Context contextZzaeb = zzbjaVar.zzaeb();
        zzepe.zza(contextZzaeb, "Cannot return null from a non-@Nullable @Provides method");
        return contextZzaeb;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzesn);
    }
}
