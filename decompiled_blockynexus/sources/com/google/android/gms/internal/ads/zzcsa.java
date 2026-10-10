package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcsa implements zzbui, zzbvs {
    private static final Object zzgmb = new Object();
    private static int zzgmc = 0;
    private final zzcsf zzgmd;

    public zzcsa(zzcsf zzcsfVar) {
        this.zzgmd = zzcsfVar;
    }

    private static boolean zzaqb() {
        boolean z;
        synchronized (zzgmb) {
            z = zzgmc < ((Integer) zzwm.zzpx().zzd(zzabb.zzcwl)).intValue();
        }
        return z;
    }

    private final void zzbk(boolean z) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwk)).booleanValue() && zzaqb()) {
            this.zzgmd.zzbk(z);
            synchronized (zzgmb) {
                zzgmc++;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void onAdLoaded() {
        zzbk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void zzk(zzva zzvaVar) {
        zzbk(false);
    }
}
