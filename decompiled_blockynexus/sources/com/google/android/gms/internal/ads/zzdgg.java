package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdgg implements zzeoy<zzdge> {
    private final zzeph<zzdzb> zzesr;
    private final zzeph<Context> zzesu;
    private final zzeph<zzawo> zzfmk;

    private zzdgg(zzeph<zzawo> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<Context> zzephVar3) {
        this.zzfmk = zzephVar;
        this.zzesr = zzephVar2;
        this.zzesu = zzephVar3;
    }

    public static zzdgg zzv(zzeph<zzawo> zzephVar, zzeph<zzdzb> zzephVar2, zzeph<Context> zzephVar3) {
        return new zzdgg(zzephVar, zzephVar2, zzephVar3);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdge(this.zzfmk.get(), this.zzesr.get(), this.zzesu.get());
    }
}
