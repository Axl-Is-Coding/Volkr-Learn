package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfr implements zzeoy<zzdfp> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Bundle> zzgxf;

    private zzdfr(zzeph<zzdzb> zzephVar, zzeph<Bundle> zzephVar2) {
        this.zzesr = zzephVar;
        this.zzgxf = zzephVar2;
    }

    public static zzdfr zzbd(zzeph<zzdzb> zzephVar, zzeph<Bundle> zzephVar2) {
        return new zzdfr(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdfp(this.zzesr.get(), this.zzgxf.get());
    }
}
