package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcze implements zzeoy<zzcza> {
    private final zzeph<Executor> zzesr;

    public zzcze(zzeph<Executor> zzephVar) {
        this.zzesr = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcza(this.zzesr.get());
    }
}
