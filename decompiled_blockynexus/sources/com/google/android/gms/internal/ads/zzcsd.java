package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcsd implements zzdso {
    private final zzcsc zzgml;

    zzcsd(zzcsc zzcscVar) {
        this.zzgml = zzcscVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zza(zzdsf zzdsfVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zza(zzdsf zzdsfVar, String str, Throwable th) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwk)).booleanValue() && zzdsf.RENDERER == zzdsfVar && this.zzgml.zzaqe() != 0) {
            this.zzgml.zzep(com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - this.zzgml.zzaqe());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zzb(zzdsf zzdsfVar, String str) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwk)).booleanValue() && zzdsf.RENDERER == zzdsfVar) {
            this.zzgml.zzff(com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdso
    public final void zzc(zzdsf zzdsfVar, String str) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwk)).booleanValue() && zzdsf.RENDERER == zzdsfVar && this.zzgml.zzaqe() != 0) {
            this.zzgml.zzep(com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - this.zzgml.zzaqe());
        }
    }
}
