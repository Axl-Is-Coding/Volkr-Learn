package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbtp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwf extends zzcwe<zzcbe> {
    private final zzbys zzfbr;
    private final zzcyn zzfig;
    private final zzbix zzgpt;
    private final zzbtp.zza zzgpu;

    public zzcwf(zzbix zzbixVar, zzbtp.zza zzaVar, zzcyn zzcynVar, zzbys zzbysVar) {
        this.zzgpt = zzbixVar;
        this.zzgpu = zzaVar;
        this.zzfig = zzcynVar;
        this.zzfbr = zzbysVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcwe
    protected final zzdzc<zzcbe> zza(zzdok zzdokVar, Bundle bundle) {
        return this.zzgpt.zzadt().zze(this.zzgpu.zza(zzdokVar).zzf(bundle).zzajv()).zze(this.zzfbr).zzb(this.zzfig).zzagh().zzaev().zzajh();
    }
}
