package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbta implements zzeoy<zzbsx> {
    private final zzeph<zzcnu> zzetp;
    private final zzeph<zzayr> zzevu;
    private final zzeph<zzbbx> zzfov;
    private final zzeph<zzdok> zzfqr;
    private final zzeph<Context> zzfth;

    private zzbta(zzeph<Context> zzephVar, zzeph<zzdok> zzephVar2, zzeph<zzbbx> zzephVar3, zzeph<zzayr> zzephVar4, zzeph<zzcnu> zzephVar5) {
        this.zzfth = zzephVar;
        this.zzfqr = zzephVar2;
        this.zzfov = zzephVar3;
        this.zzevu = zzephVar4;
        this.zzetp = zzephVar5;
    }

    public static zzbta zzb(zzeph<Context> zzephVar, zzeph<zzdok> zzephVar2, zzeph<zzbbx> zzephVar3, zzeph<zzayr> zzephVar4, zzeph<zzcnu> zzephVar5) {
        return new zzbta(zzephVar, zzephVar2, zzephVar3, zzephVar4, zzephVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return new zzbsx(this.zzfth.get(), this.zzfqr.get(), this.zzfov.get(), this.zzevu.get(), this.zzetp.get());
    }
}
