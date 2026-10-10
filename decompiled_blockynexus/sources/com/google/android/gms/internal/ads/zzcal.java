package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcal extends zzbyr<zzaia> implements zzaia {
    public zzcal(Set<zzcab<zzaia>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final void zza(final zzauv zzauvVar) {
        zza(new zzbyt(zzauvVar) { // from class: com.google.android.gms.internal.ads.zzcan
            private final zzauv zzfwo;

            {
                this.zzfwo = zzauvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzaia) obj).zza(this.zzfwo);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final synchronized void zzta() {
        zza(zzcao.zzfur);
    }

    @Override // com.google.android.gms.internal.ads.zzaia
    public final void zztb() {
        zza(zzcaq.zzfur);
    }
}
