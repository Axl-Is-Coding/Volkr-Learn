package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcjt {
    private final zzbbx zzbpe;
    private final zzbgr zzbpt;
    private final zzts zzemr;
    private final zzeg zzeom;
    private final zzacb zzeon;
    private final com.google.android.gms.ads.internal.zzb zzeop;
    private final zzsu zzeor;
    private final zzbwk zzgfh;
    private final Context zzvr;

    public zzcjt(zzbgr zzbgrVar, Context context, zzeg zzegVar, zzacb zzacbVar, zzbbx zzbbxVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, zzbwk zzbwkVar, zzcaz zzcazVar) {
        this.zzbpt = zzbgrVar;
        this.zzvr = context;
        this.zzeom = zzegVar;
        this.zzeon = zzacbVar;
        this.zzbpe = zzbbxVar;
        this.zzeop = zzbVar;
        this.zzemr = zztsVar;
        this.zzgfh = zzbwkVar;
        this.zzeor = zzcazVar;
    }

    public final zzbgj zza(zzvn zzvnVar, zzdnv zzdnvVar, zzdnw zzdnwVar, boolean z) throws zzbgv {
        return zzbgr.zza(this.zzvr, zzbhy.zzb(zzvnVar), zzvnVar.zzacy, false, false, this.zzeom, this.zzeon, this.zzbpe, null, new zzcjw(this), this.zzeop, this.zzemr, this.zzeor, z, zzdnvVar, zzdnwVar);
    }

    public final zzbgj zzc(zzvn zzvnVar) throws zzbgv {
        return zza(zzvnVar, null, null, false);
    }
}
