package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbvh extends zzbyr<zzbuh> {
    public zzbvh(Set<zzcab<zzbuh>> set) {
        super(set);
    }

    public final void onAdClosed() {
        zza(zzbvg.zzfur);
    }

    public final void onAdLeftApplication() {
        zza(zzbvj.zzfur);
    }

    public final void onAdOpened() {
        zza(zzbvi.zzfur);
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbvn.zzfur);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbvl.zzfur);
    }

    public final void zzb(final zzatw zzatwVar, final String str, final String str2) {
        zza(new zzbyt(zzatwVar, str, str2) { // from class: com.google.android.gms.internal.ads.zzbvk
            private final String zzdgm;
            private final String zzdjk;
            private final zzatw zzfuw;

            {
                this.zzfuw = zzatwVar;
                this.zzdgm = str;
                this.zzdjk = str2;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbuh) obj).zzb(this.zzfuw, this.zzdgm, this.zzdjk);
            }
        });
    }
}
