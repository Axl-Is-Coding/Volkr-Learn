package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbte implements zzeoy<zzdvu<zzdnv, zzazp>> {
    private final zzeph<Context> zzesu;
    private final zzeph<zzbbx> zzfmh;
    private final zzeph<zzdok> zzfqr;

    public zzbte(zzeph<Context> zzephVar, zzeph<zzbbx> zzephVar2, zzeph<zzdok> zzephVar3) {
        this.zzesu = zzephVar;
        this.zzfmh = zzephVar2;
        this.zzfqr = zzephVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        final Context context = this.zzesu.get();
        final zzbbx zzbbxVar = this.zzfmh.get();
        final zzdok zzdokVar = this.zzfqr.get();
        zzdvu zzdvuVar = new zzdvu(context, zzbbxVar, zzdokVar) { // from class: com.google.android.gms.internal.ads.zzbtb
            private final Context zzcyt;
            private final zzbbx zzfqm;
            private final zzdok zzfti;

            {
                this.zzcyt = context;
                this.zzfqm = zzbbxVar;
                this.zzfti = zzdokVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                Context context2 = this.zzcyt;
                zzbbx zzbbxVar2 = this.zzfqm;
                zzdok zzdokVar2 = this.zzfti;
                zzdnv zzdnvVar = (zzdnv) obj;
                zzazp zzazpVar = new zzazp(context2);
                zzazpVar.zzet(zzdnvVar.zzdss);
                zzazpVar.zzeu(zzdnvVar.zzhdw.toString());
                zzazpVar.zzae(zzbbxVar2.zzbre);
                zzazpVar.setAdUnitId(zzdokVar2.zzhfb);
                return zzazpVar;
            }
        };
        zzepe.zza(zzdvuVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdvuVar;
    }
}
