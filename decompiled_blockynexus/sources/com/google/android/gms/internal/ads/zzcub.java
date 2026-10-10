package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcub implements zzcti<zzboq, zzdpa, zzcuu> {
    private final zzbbx zzbot;
    private final Executor zzfoc;
    private final zzbpm zzgoj;
    private final Context zzvr;

    public zzcub(Context context, zzbbx zzbbxVar, zzbpm zzbpmVar, Executor executor) {
        this.zzvr = context;
        this.zzbot = zzbbxVar;
        this.zzgoj = zzbpmVar;
        this.zzfoc = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcti
    public final void zza(zzdog zzdogVar, zzdnv zzdnvVar, zzctc<zzdpa, zzcuu> zzctcVar) throws zzdos {
        zzvn zzvnVar = zzdogVar.zzhev.zzfsk.zzbpf;
        zzvn zzvnVar2 = zzvnVar.zzcia ? new zzvn(this.zzvr, com.google.android.gms.ads.zzb.zza(zzvnVar.width, zzvnVar.height)) : zzdoq.zzb(this.zzvr, zzdnvVar.zzhdt);
        if (this.zzbot.zzeem < 4100000) {
            zzctcVar.zzdlf.zza(this.zzvr, zzvnVar2, zzdogVar.zzhev.zzfsk.zzhfa, zzdnvVar.zzhdu.toString(), (zzanh) zzctcVar.zzgns);
        } else {
            zzctcVar.zzdlf.zza(this.zzvr, zzvnVar2, zzdogVar.zzhev.zzfsk.zzhfa, zzdnvVar.zzhdu.toString(), zzbao.zza(zzdnvVar.zzhdr), (zzanh) zzctcVar.zzgns);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzcti
    public final /* synthetic */ zzboq zzb(zzdog zzdogVar, zzdnv zzdnvVar, zzctc zzctcVar) throws zzcwn, zzdos {
        zzbpm zzbpmVar = this.zzgoj;
        zzbre zzbreVar = new zzbre(zzdogVar, zzdnvVar, zzctcVar.zzcib);
        View view = ((zzdpa) zzctcVar.zzdlf).getView();
        zzdpa zzdpaVar = (zzdpa) zzctcVar.zzdlf;
        zzdpaVar.getClass();
        zzbop zzbopVarZza = zzbpmVar.zza(zzbreVar, new zzbot(view, null, zzcue.zza(zzdpaVar), zzdnvVar.zzhdt.get(0)));
        zzbopVarZza.zzagb().zzv(((zzdpa) zzctcVar.zzdlf).getView());
        zzbopVarZza.zzaez().zza(new zzbmf((zzdpa) zzctcVar.zzdlf), this.zzfoc);
        ((zzcuu) zzctcVar.zzgns).zzb(zzbopVarZza.zzafe());
        return zzbopVarZza.zzaga();
    }
}
