package com.google.android.gms.internal.ads;

import android.content.Context;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcvc implements zzccm {
    private final zzbbx zzbot;
    private final zzdnv zzgah;
    private final zzdzc<zzcbg> zzgod;
    private final zzbgj zzgoe;
    private final Context zzvr;

    private zzcvc(Context context, zzbbx zzbbxVar, zzdzc<zzcbg> zzdzcVar, zzdnv zzdnvVar, zzbgj zzbgjVar) {
        this.zzvr = context;
        this.zzbot = zzbbxVar;
        this.zzgod = zzdzcVar;
        this.zzgah = zzdnvVar;
        this.zzgoe = zzbgjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void zza(boolean z, Context context) {
        zzcbg zzcbgVar = (zzcbg) zzdyq.zzb(this.zzgod);
        this.zzgoe.zzba(true);
        com.google.android.gms.ads.internal.zzp.zzkr();
        com.google.android.gms.ads.internal.zzi zziVar = new com.google.android.gms.ads.internal.zzi(false, zzayu.zzbc(this.zzvr), false, WheelView.DividerConfig.FILL, -1, z, this.zzgah.zzfph, false);
        com.google.android.gms.ads.internal.zzp.zzkq();
        zzccc zzcccVarZzafr = zzcbgVar.zzafr();
        zzbgj zzbgjVar = this.zzgoe;
        zzdnv zzdnvVar = this.zzgah;
        int i = zzdnvVar.zzhea;
        zzbbx zzbbxVar = this.zzbot;
        String str = zzdnvVar.zzdss;
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        com.google.android.gms.ads.internal.overlay.zzl.zza(context, new AdOverlayInfoParcel((zzux) null, zzcccVarZzafr, (com.google.android.gms.ads.internal.overlay.zzv) null, zzbgjVar, i, zzbbxVar, str, zziVar, zzdnyVar.zzdpn, zzdnyVar.zzdpp), true);
    }
}
