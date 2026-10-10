package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzddl implements zzeoy<zzddj> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzesu;

    public zzddl(zzeph<zzdzb> zzephVar, zzeph<Context> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzesu = zzephVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzddj(this.zzesr.get(), this.zzesu.get());
    }
}
