package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcpk implements zzdyr<zzdog> {
    private final /* synthetic */ zzcpf zzgjx;

    zzcpk(zzcpf zzcpfVar) {
        this.zzgjx = zzcpfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final /* synthetic */ void onSuccess(zzdog zzdogVar) {
        zzdog zzdogVar2 = zzdogVar;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwk)).booleanValue()) {
            this.zzgjx.zzgjt.zzdz(zzdogVar2.zzhew.zzeou.responseCode);
            this.zzgjx.zzgjt.zzeo(zzdogVar2.zzhew.zzeou.zzglu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyr
    public final void zzb(Throwable th) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwk)).booleanValue()) {
            Matcher matcher = zzcpf.zzgju.matcher(th.getMessage());
            if (matcher.matches()) {
                this.zzgjx.zzgjt.zzdz(Integer.parseInt(matcher.group(1)));
            }
        }
    }
}
