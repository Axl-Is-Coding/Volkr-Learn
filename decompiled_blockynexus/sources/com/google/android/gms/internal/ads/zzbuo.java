package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzbuo extends zzbyr<zzbuv> implements zzbul {
    @VisibleForTesting
    public zzbuo(Set<zzcab<zzbuv>> set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbul
    public final void zza(zzccl zzcclVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbul
    public final void zzajw() {
        zza(zzbuq.zzfur);
    }

    @Override // com.google.android.gms.internal.ads.zzbul
    public final void zzl(final zzva zzvaVar) {
        zza(new zzbyt(zzvaVar) { // from class: com.google.android.gms.internal.ads.zzbur
            private final zzva zzfus;

            {
                this.zzfus = zzvaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbuv) obj).zzj(this.zzfus);
            }
        });
    }
}
