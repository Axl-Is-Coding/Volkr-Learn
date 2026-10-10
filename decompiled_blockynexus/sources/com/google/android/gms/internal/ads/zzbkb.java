package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkb extends zzdhp {
    private zzeph<String> zzevp;
    private zzeph<zzcmg> zzewf;
    private zzeph<Map<zzdsf, zzcmg>> zzewh;
    private zzeph<Set<zzcab<zzdso>>> zzewj;
    private zzeph<Set<zzcab<zzdso>>> zzewq;
    private zzeph zzewr;
    private zzeph<zzdsi> zzews;
    private zzeph<ApplicationInfo> zzexd;
    private zzeph<zzdit> zzeyi;
    private final /* synthetic */ zzbjv zzfbq;
    private final zzdiy zzffu;
    private zzeph<zzdhl> zzffv;
    private zzeph<String> zzffw;
    private zzeph<zzdhv> zzffx;
    private zzeph<Integer> zzffy;
    private zzeph<zzdhz> zzffz;
    private zzeph<zzdif> zzfga;
    private zzeph<zzdik> zzfgb;
    private zzeph<Boolean> zzfgc;
    private zzeph<zzdix> zzfgd;
    private zzeph<zzdjl> zzfge;
    private zzeph<zzcmg> zzfgf;
    private zzeph<zzcmg> zzfgg;
    private zzeph<zzcmg> zzfgh;

    private zzbkb(zzbjv zzbjvVar, zzdiy zzdiyVar) {
        this.zzfbq = zzbjvVar;
        this.zzffu = zzdiyVar;
        this.zzffv = new zzdhm(zzblw.zzfmr, this.zzfbq.zzetf, this.zzfbq.zzeta, zzdri.zzavg());
        this.zzffw = new zzdjb(zzdiyVar);
        this.zzffx = new zzdhx(zzbjm.zzess, this.zzfbq.zzetf, this.zzffw, zzdri.zzavg());
        this.zzffy = new zzdjc(zzdiyVar);
        this.zzffz = new zzdid(zzblw.zzfmr, this.zzffy, this.zzfbq.zzetf, this.zzfbq.zzeua, this.zzfbq.zzeta, zzdri.zzavg());
        this.zzfga = new zzdih(zzblq.zzfmn, zzdri.zzavg(), this.zzfbq.zzetf);
        this.zzfgb = new zzdim(zzbls.zzfmo, zzdri.zzavg(), this.zzffw);
        this.zzfgc = new zzdjd(zzdiyVar);
        this.zzexd = new zzdja(zzdiyVar);
        this.zzeyi = new zzdiv(this.zzfbq.zzeuc, this.zzfbq.zzeta, this.zzfgc, this.zzexd);
        this.zzfgd = new zzdiz(zzblu.zzfmp, this.zzfbq.zzeta, this.zzfbq.zzetf);
        this.zzfge = new zzdjn(zzdri.zzavg());
        this.zzevp = new zzdjf(zzdiyVar);
        this.zzewf = zzeov.zzas(zzclv.zzaor());
        this.zzfgf = zzeov.zzas(zzclt.zzaoq());
        this.zzfgg = zzeov.zzas(zzclx.zzaot());
        this.zzfgh = zzeov.zzas(zzclz.zzaov());
        this.zzewh = ((zzepc) ((zzepc) ((zzepc) ((zzepc) zzepa.zzic(4).zza(zzdsf.GMS_SIGNALS, this.zzewf)).zza(zzdsf.BUILD_URL, this.zzfgf)).zza(zzdsf.HTTP, this.zzfgg)).zza(zzdsf.PRE_PROCESS, this.zzfgh)).zzbkj();
        this.zzewj = zzeov.zzas(new zzcmb(this.zzevp, this.zzfbq.zzetf, zzdri.zzavg(), this.zzewh));
        this.zzewq = zzepd.zzar(0, 1).zzav(this.zzewj).zzbkk();
        this.zzewr = zzdsq.zzar(this.zzewq);
        this.zzews = zzeov.zzas(zzdsn.zzx(zzdri.zzavg(), this.zzfbq.zzeta, this.zzewr));
    }

    private final zzdio zzafk() {
        zzaao zzaaoVar = new zzaao();
        zzepe.zza(zzaaoVar, "Cannot return null from a non-@Nullable @Provides method");
        zzdzb zzdzbVarZzavh = zzdri.zzavh();
        List<String> listZzasj = this.zzffu.zzasj();
        zzepe.zza(listZzasj, "Cannot return null from a non-@Nullable @Provides method");
        return new zzdio(zzaaoVar, zzdzbVarZzavh, listZzasj);
    }

    private final zzdhr zzafl() {
        zzaxx zzaxxVarZzahb = zzblt.zzahb();
        zzdzb zzdzbVarZzavh = zzdri.zzavh();
        String strZzasg = this.zzffu.zzasg();
        zzepe.zza(strZzasg, "Cannot return null from a non-@Nullable @Provides method");
        return new zzdhr(zzaxxVarZzahb, zzdzbVarZzavh, strZzasg, this.zzffu.zzash());
    }

    @Override // com.google.android.gms.internal.ads.zzdhp
    public final zzdgw<JSONObject> zzafm() {
        zzdzb zzdzbVarZzavh = zzdri.zzavh();
        zzdfi zzdfiVar = new zzdfi(new zzdik(zzblp.zzagx(), zzdri.zzavh(), zzdjb.zzc(this.zzffu)), 0L, (ScheduledExecutorService) this.zzfbq.zzeta.get());
        zzepe.zza(zzdfiVar, "Cannot return null from a non-@Nullable @Provides method");
        zzdfi zzdfiVar2 = zzdfiVar;
        zzdfi zzdfiVar3 = new zzdfi(new zzdit(zzblc.zzb(this.zzfbq.zzesw), (ScheduledExecutorService) this.zzfbq.zzeta.get(), this.zzffu.zzasi(), zzdja.zzb(this.zzffu)), ((Long) zzwm.zzpx().zzd(zzabb.zzcsm)).longValue(), (ScheduledExecutorService) this.zzfbq.zzeta.get());
        zzepe.zza(zzdfiVar3, "Cannot return null from a non-@Nullable @Provides method");
        zzdfi zzdfiVar4 = new zzdfi(new zzdix(zzblr.zzagz(), (ScheduledExecutorService) this.zzfbq.zzeta.get(), zzbjd.zza(this.zzfbq.zzesx)), ((Long) zzwm.zzpx().zzd(zzabb.zzcsu)).longValue(), (ScheduledExecutorService) this.zzfbq.zzeta.get());
        zzepe.zza(zzdfiVar4, "Cannot return null from a non-@Nullable @Provides method");
        zzdfi zzdfiVar5 = new zzdfi(new zzdhl(zzblt.zzahb(), zzbjd.zza(this.zzfbq.zzesx), (ScheduledExecutorService) this.zzfbq.zzeta.get(), zzdri.zzavh()), 0L, (ScheduledExecutorService) this.zzfbq.zzeta.get());
        zzepe.zza(zzdfiVar5, "Cannot return null from a non-@Nullable @Provides method");
        zzdfi zzdfiVar6 = new zzdfi(new zzdjl(zzdri.zzavh()), 0L, (ScheduledExecutorService) this.zzfbq.zzeta.get());
        zzepe.zza(zzdfiVar6, "Cannot return null from a non-@Nullable @Provides method");
        zzdgx<? extends zzdgu<JSONObject>> zzdgxVarZzasn = zzdje.zzasn();
        zzepe.zza(zzdgxVarZzasn, "Cannot return null from a non-@Nullable @Provides method");
        return zzdhb.zza(zzdzbVarZzavh, zzdws.zza(zzdfiVar2, zzdfiVar3, zzdfiVar4, zzdfiVar5, zzdfiVar6, zzdgxVarZzasn, new zzdhv(null, zzbjd.zza(this.zzfbq.zzesx), zzdjb.zzc(this.zzffu), zzdri.zzavh()), new zzdif(zzbln.zzagv(), zzdri.zzavh(), zzbjd.zza(this.zzfbq.zzesx)), zzafk(), zzafl(), new zzdhz(zzblt.zzahb(), this.zzffu.zzasm(), zzbjd.zza(this.zzfbq.zzesx), (zzayb) this.zzfbq.zzeua.get(), (ScheduledExecutorService) this.zzfbq.zzeta.get(), zzdri.zzavh()), (zzdgx) this.zzfbq.zzeub.get()));
    }

    @Override // com.google.android.gms.internal.ads.zzdhp
    public final zzdgw<JSONObject> zzafn() {
        return zzdjj.zza(zzblp.zzagx(), this.zzfbq.zzeub.get(), zzafl(), zzafk(), zzeov.zzat(this.zzffv), zzeov.zzat(this.zzffx), zzeov.zzat(this.zzffz), zzeov.zzat(this.zzfga), zzeov.zzat(this.zzfgb), zzeov.zzat(this.zzeyi), zzeov.zzat(this.zzfgd), zzeov.zzat(this.zzfge), zzdri.zzavh(), (ScheduledExecutorService) this.zzfbq.zzeta.get());
    }

    @Override // com.google.android.gms.internal.ads.zzdhp
    public final zzdsi zzafo() {
        return this.zzews.get();
    }
}
