package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbud implements zzeoy<zzawl> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzdnv> zzfou;
    private final zzbua zzfuo;
    private final zzeph<zzbbx> zzfup;
    private final zzeph<zzawn> zzfuq;

    private zzbud(zzbua zzbuaVar, zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<zzdnv> zzephVar3, zzeph<zzawn> zzephVar4) {
        this.zzfuo = zzbuaVar;
        this.zzesu = zzephVar;
        this.zzfup = zzephVar2;
        this.zzfou = zzephVar3;
        this.zzfuq = zzephVar4;
    }

    public static zzbud zza(zzbua zzbuaVar, zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<zzdnv> zzephVar3, zzeph<zzawn> zzephVar4) {
        return new zzbud(zzbuaVar, zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        Context context = this.zzesu.get();
        zzbbx zzbbxVar = this.zzfup.get();
        zzdnv zzdnvVar = this.zzfou.get();
        zzawn zzawnVar = this.zzfuq.get();
        zzawg zzawgVar = zzdnvVar.zzhdv;
        if (zzawgVar != null) {
            return new zzavy(context, zzbbxVar, zzawgVar, zzdnvVar.zzhdr.zzdpn, zzawnVar);
        }
        return null;
    }
}
