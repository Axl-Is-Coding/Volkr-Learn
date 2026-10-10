package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkn implements zzbpx {
    private zzeph<zzdnv> zzfbt;
    private zzeph<Set<zzcab<zzbuy>>> zzfbw;
    private zzeph<zzbvb> zzfbx;
    private zzeph<zzbwv> zzfby;
    private zzeph<zzdog> zzfca;
    private zzeph<Set<zzcab<zzbvs>>> zzfde;
    private zzeph<zzbvr> zzfdf;
    private zzeph<String> zzfdz;
    private zzeph<zzbty> zzfea;
    private zzeph<zzbqn> zzfeb;
    private final /* synthetic */ zzbkl zzfjg;
    private final zzbqa zzfkb;
    private zzeph<zzafy> zzfkc;
    private zzeph<Runnable> zzfkd;
    private zzeph<zzbpw> zzfke;

    private zzbkn(zzbkl zzbklVar, zzbre zzbreVar, zzbqa zzbqaVar) {
        this.zzfjg = zzbklVar;
        this.zzfkb = zzbqaVar;
        this.zzfca = zzbri.zzf(zzbreVar);
        this.zzfbt = zzbrd.zza(zzbreVar);
        this.zzfbw = zzepd.zzar(0, 2).zzav(this.zzfjg.zzfai).zzav(this.zzfjg.zzfaj).zzbkk();
        this.zzfbx = zzeov.zzas(zzbve.zzj(this.zzfbw));
        this.zzfde = zzepd.zzar(4, 3).zzau(this.zzfjg.zzfax).zzau(this.zzfjg.zzfay).zzau(this.zzfjg.zzfaz).zzav(this.zzfjg.zzfba).zzav(this.zzfjg.zzfbb).zzav(this.zzfjg.zzfbc).zzau(this.zzfjg.zzfbd).zzbkk();
        this.zzfdf = zzeov.zzas(zzbvt.zzl(this.zzfde));
        this.zzfdz = zzbrg.zzd(zzbreVar);
        this.zzfea = zzbub.zzi(this.zzfbt, this.zzfdz, this.zzfjg.zzewv);
        this.zzfby = zzeov.zzas(zzbxs.zzakc());
        this.zzfeb = zzbsi.zza(this.zzfca, this.zzfbt, this.zzfbx, this.zzfdf, this.zzfjg.zzfbl, this.zzfea, this.zzfby);
        this.zzfkc = new zzbqc(zzbqaVar);
        this.zzfkd = new zzbpz(zzbqaVar);
        this.zzfke = zzeov.zzas(new zzbqb(this.zzfeb, this.zzfkc, this.zzfkd, this.zzfjg.zzfbq.zzesy));
    }

    @Override // com.google.android.gms.internal.ads.zzbpx
    public final zzboq zzagg() {
        zzbpw zzbpwVar = this.zzfke.get();
        zzepe.zza(zzbpwVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzbpwVar;
    }
}
