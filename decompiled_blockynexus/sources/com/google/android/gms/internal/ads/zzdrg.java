package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdrg implements zzeoy<zzdzb> {
    public static zzdrg zzave() {
        return zzdrf.zzhjr;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        zzdzb zzdzbVar;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvh)).booleanValue()) {
            zzdzbVar = zzbbz.zzeer;
        } else {
            zzdzbVar = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcvg)).booleanValue() ? zzbbz.zzeep : zzbbz.zzeet;
        }
        zzepe.zza(zzdzbVar, "Cannot return null from a non-@Nullable @Provides method");
        return zzdzbVar;
    }
}
