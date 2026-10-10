package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbug extends zzbyr<zzbui> implements zzbui {
    public zzbug(Set<zzcab<zzbui>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbui
    public final void zzk(final zzva zzvaVar) {
        zza(new zzbyt(zzvaVar) { // from class: com.google.android.gms.internal.ads.zzbuj
            private final zzva zzfus;

            {
                this.zzfus = zzvaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbui) obj).zzk(this.zzfus);
            }
        });
    }
}
