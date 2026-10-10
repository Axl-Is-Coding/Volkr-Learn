package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcbl implements zzeoy<zzcab<zzbvs>> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<zzdnv> zzfou;
    private final zzeph<zzdok> zzfqr;
    private final zzcbf zzfwx;

    private zzcbl(zzcbf zzcbfVar, zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<zzdnv> zzephVar3, zzeph<zzdok> zzephVar4) {
        this.zzfwx = zzcbfVar;
        this.zzesu = zzephVar;
        this.zzfmh = zzephVar2;
        this.zzfou = zzephVar3;
        this.zzfqr = zzephVar4;
    }

    public static zzcbl zza(zzcbf zzcbfVar, zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<zzdnv> zzephVar3, zzeph<zzdok> zzephVar4) {
        return new zzcbl(zzcbfVar, zzephVar, zzephVar2, zzephVar3, zzephVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        final Context context = this.zzesu.get();
        final zzbbx zzbbxVar = this.zzfmh.get();
        final zzdnv zzdnvVar = this.zzfou.get();
        final zzdok zzdokVar = this.zzfqr.get();
        zzcab zzcabVar = new zzcab(new zzbvs(context, zzbbxVar, zzdnvVar, zzdokVar) { // from class: com.google.android.gms.internal.ads.zzcbi
            private final Context zzcyt;
            private final zzbbx zzfqm;
            private final zzdnv zzfqn;
            private final zzdok zzfqo;

            {
                this.zzcyt = context;
                this.zzfqm = zzbbxVar;
                this.zzfqn = zzdnvVar;
                this.zzfqo = zzdokVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbvs
            public final void onAdLoaded() {
                com.google.android.gms.ads.internal.zzp.zzlb().zzb(this.zzcyt, this.zzfqm.zzbre, this.zzfqn.zzhdw.toString(), this.zzfqo.zzhfb);
            }
        }, zzbbz.zzeeu);
        zzepe.zza(zzcabVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzcabVar;
    }
}
