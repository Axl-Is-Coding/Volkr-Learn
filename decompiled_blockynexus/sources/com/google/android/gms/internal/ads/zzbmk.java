package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbmk implements zzdyr<String> {
    private final /* synthetic */ zzbmh zzfnh;

    zzbmk(zzbmh zzbmhVar) {
        this.zzfnh = zzbmhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(String str) {
        String str2 = str;
        zzdor zzdorVar = this.zzfnh.zzfmz;
        List<String> listZza = this.zzfnh.zzfmy.zza(this.zzfnh.zzfmw, this.zzfnh.zzfmx, false, "", str2, this.zzfnh.zzfmx.zzdkj);
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzdorVar.zza(listZza, zzayu.zzbf(this.zzfnh.zzvr) ? zzcsq.zzgne : zzcsq.zzgnd);
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        zzdor zzdorVar = this.zzfnh.zzfmz;
        List<String> listZza = this.zzfnh.zzfmy.zza(this.zzfnh.zzfmw, this.zzfnh.zzfmx, false, "", "failure_click_attok", this.zzfnh.zzfmx.zzdkj);
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzdorVar.zza(listZza, zzayu.zzbf(this.zzfnh.zzvr) ? zzcsq.zzgne : zzcsq.zzgnd);
    }
}
