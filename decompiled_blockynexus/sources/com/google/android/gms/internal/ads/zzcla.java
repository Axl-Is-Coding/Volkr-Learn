package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcla implements zzeoy<zzckw> {
    private final zzeph<Executor> zzesr;

    public zzcla(zzeph<Executor> zzephVar) {
        this.zzesr = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzckw(this.zzesr.get());
    }
}
