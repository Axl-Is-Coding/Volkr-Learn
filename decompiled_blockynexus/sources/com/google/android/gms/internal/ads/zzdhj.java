package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhj implements zzeoy<zzdhh> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzesu;

    private zzdhj(zzeph<zzdzb> zzephVar, zzeph<Context> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzesu = zzephVar2;
    }

    public static zzdhj zzbh(zzeph<zzdzb> zzephVar, zzeph<Context> zzephVar2) {
        return new zzdhj(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdhh(this.zzesr.get(), this.zzesu.get());
    }
}
