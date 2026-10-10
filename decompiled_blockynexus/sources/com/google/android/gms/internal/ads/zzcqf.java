package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcqf implements zzeoy<zzcqg> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzawo> zzfmk;

    private zzcqf(zzeph<Context> zzephVar, zzeph<zzawo> zzephVar2) {
        this.zzesu = zzephVar;
        this.zzfmk = zzephVar2;
    }

    public static zzcqf zzar(zzeph<Context> zzephVar, zzeph<zzawo> zzephVar2) {
        return new zzcqf(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzcqg(this.zzesu.get(), this.zzfmk.get());
    }
}
