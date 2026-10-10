package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbpt implements zzeoy<Boolean> {
    private final zzeph<zzdok> zzfqr;

    public zzbpt(zzeph<zzdok> zzephVar) {
        this.zzfqr = zzephVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeph
    public final /* synthetic */ Object get() {
        boolean zBooleanValue;
        if (this.zzfqr.get().zzati() != null) {
            zBooleanValue = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcpc)).booleanValue();
        } else {
            zBooleanValue = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcvc)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }
}
