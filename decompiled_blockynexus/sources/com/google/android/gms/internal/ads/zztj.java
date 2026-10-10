package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zztj extends zzbcg<InputStream> {
    private final /* synthetic */ zztk zzbvl;

    zztj(zztk zztkVar) {
        this.zzbvl = zztkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbcg, java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        this.zzbvl.disconnect();
        return super.cancel(z);
    }
}
