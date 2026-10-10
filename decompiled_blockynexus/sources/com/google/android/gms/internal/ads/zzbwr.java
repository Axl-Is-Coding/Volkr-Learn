package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbwr extends zzbyr<zzbws> implements zzbws {
    public zzbwr(Set<zzcab<zzbws>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzb(final zzdog zzdogVar) {
        zza(new zzbyt(zzdogVar) { // from class: com.google.android.gms.internal.ads.zzbwt
            private final zzdog zzfvd;

            {
                this.zzfvd = zzdogVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbws) obj).zzb(this.zzfvd);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbws
    public final void zzd(final zzatc zzatcVar) {
        zza(new zzbyt(zzatcVar) { // from class: com.google.android.gms.internal.ads.zzbwq
            private final zzatc zzfvc;

            {
                this.zzfvc = zzatcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbws) obj).zzd(this.zzfvc);
            }
        });
    }
}
