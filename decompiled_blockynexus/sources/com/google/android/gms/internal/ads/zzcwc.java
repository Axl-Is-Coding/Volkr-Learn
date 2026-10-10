package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbtp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwc extends zzcwe<zzbqu> {
    private final zzccw zzeve;
    private final zzbys zzfbr;
    private final zzbix zzgpt;
    private final zzbtp.zza zzgpu;

    public zzcwc(zzbix zzbixVar, zzccw zzccwVar, zzbtp.zza zzaVar, zzbys zzbysVar) {
        this.zzgpt = zzbixVar;
        this.zzeve = zzccwVar;
        this.zzgpu = zzaVar;
        this.zzfbr = zzbysVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwe
    protected final zzdzc<zzbqu> zza(zzdok zzdokVar, Bundle bundle) {
        return this.zzgpt.zzadu().zza(this.zzgpu.zza(zzdokVar).zzf(bundle).zzajv()).zza(this.zzfbr).zza(this.zzeve).zzaex().zzaev().zzajh();
    }
}
