package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpb implements zzeoy<zzcab<zzbvs>> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<zzdnv> zzfou;
    private final zzbot zzfqp;
    private final zzeph<zzdok> zzfqr;

    public zzbpb(zzbot zzbotVar, zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<zzdnv> zzephVar3, zzeph<zzdok> zzephVar4) {
        this.zzfqp = zzbotVar;
        this.zzesu = zzephVar;
        this.zzfmh = zzephVar2;
        this.zzfou = zzephVar3;
        this.zzfqr = zzephVar4;
    }

    public static zzcab<zzbvs> zza(zzbot zzbotVar, final Context context, final zzbbx zzbbxVar, final zzdnv zzdnvVar, final zzdok zzdokVar) {
        zzcab<zzbvs> zzcabVar = new zzcab<>(new zzbvs(context, zzbbxVar, zzdnvVar, zzdokVar) { // from class: com.google.android.gms.internal.ads.zzbow
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

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        return zza(this.zzfqp, this.zzesu.get(), this.zzfmh.get(), this.zzfou.get(), this.zzfqr.get());
    }
}
