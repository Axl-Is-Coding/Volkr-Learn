package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbtp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwh extends zzcwe<zzcjg> {
    private final zzbys zzfbr;
    private final zzbix zzgpt;
    private final zzbtp.zza zzgpu;

    public zzcwh(zzbix zzbixVar, zzbtp.zza zzaVar, zzbys zzbysVar) {
        this.zzgpt = zzbixVar;
        this.zzgpu = zzaVar;
        this.zzfbr = zzbysVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwe
    protected final zzdzc<zzcjg> zza(zzdok zzdokVar, Bundle bundle) {
        return this.zzgpt.zzadv().zzf(this.zzgpu.zza(zzdokVar).zzf(bundle).zzajv()).zzf(this.zzfbr).zzagl().zzaev().zzajh();
    }
}
