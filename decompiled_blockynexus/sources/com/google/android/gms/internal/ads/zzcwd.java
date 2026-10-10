package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbtp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwd extends zzcwe<zzboq> {
    private final zzccw zzeve;
    private final zzbys zzfbr;
    private final zzcyn zzfig;
    private final ViewGroup zzfpw;
    private final zzbwk zzfrk;
    private final zzbix zzgpt;
    private final zzbtp.zza zzgpu;

    public zzcwd(zzbix zzbixVar, zzbtp.zza zzaVar, zzcyn zzcynVar, zzbys zzbysVar, zzccw zzccwVar, zzbwk zzbwkVar, ViewGroup viewGroup) {
        this.zzgpt = zzbixVar;
        this.zzgpu = zzaVar;
        this.zzfig = zzcynVar;
        this.zzfbr = zzbysVar;
        this.zzeve = zzccwVar;
        this.zzfrk = zzbwkVar;
        this.zzfpw = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzcwe
    protected final zzdzc<zzboq> zza(zzdok zzdokVar, Bundle bundle) {
        return this.zzgpt.zzadp().zzd(this.zzgpu.zza(zzdokVar).zzf(bundle).zzajv()).zzd(this.zzfbr).zza(this.zzfig).zzb(this.zzeve).zza(new zzbqh(this.zzfrk)).zzc(new zzbol(this.zzfpw)).zzafw().zzaev().zzajh();
    }
}
