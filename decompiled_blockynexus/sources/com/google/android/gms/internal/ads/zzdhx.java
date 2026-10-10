package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdhx implements zzeoy<zzdhv> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zzatj> zzetv;
    private final zzeph<String> zzfuc;

    public zzdhx(zzeph<zzatj> zzephVar, zzeph<Context> zzephVar2, zzeph<String> zzephVar3, zzeph<zzdzb> zzephVar4) {
        this.zzetv = zzephVar;
        this.zzesu = zzephVar2;
        this.zzfuc = zzephVar3;
        this.zzesr = zzephVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdhv(this.zzetv.get(), this.zzesu.get(), this.zzfuc.get(), this.zzesr.get());
    }
}
