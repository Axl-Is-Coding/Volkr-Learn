package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbuk extends zzbyr<zzbul> implements zzbul {
    public zzbuk(zzbuo zzbuoVar, Set<zzcab<zzbul>> set, Executor executor) {
        super(set);
        zza(zzbuoVar, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzbul
    public final void zza(final zzccl zzcclVar) {
        zza(new zzbyt(zzcclVar) { // from class: com.google.android.gms.internal.ads.zzbum
            private final zzccl zzfut;

            {
                this.zzfut = zzcclVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbul) obj).zza(this.zzfut);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbul
    public final void zzajw() {
        zza(zzbup.zzfur);
    }

    @Override // com.google.android.gms.internal.ads.zzbul
    public final void zzl(final zzva zzvaVar) {
        zza(new zzbyt(zzvaVar) { // from class: com.google.android.gms.internal.ads.zzbun
            private final zzva zzfus;

            {
                this.zzfus = zzvaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbul) obj).zzl(this.zzfus);
            }
        });
    }
}
