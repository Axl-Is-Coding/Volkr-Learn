package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpm implements zzeoy<zzdpj> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzayi> zzevj;

    private zzdpm(zzeph<Context> zzephVar, zzeph<zzayi> zzephVar2) {
        this.zzesu = zzephVar;
        this.zzevj = zzephVar2;
    }

    public static zzdpm zzbi(zzeph<Context> zzephVar, zzeph<zzayi> zzephVar2) {
        return new zzdpm(zzephVar, zzephVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzdpj(this.zzesu.get(), this.zzevj.get());
    }
}
