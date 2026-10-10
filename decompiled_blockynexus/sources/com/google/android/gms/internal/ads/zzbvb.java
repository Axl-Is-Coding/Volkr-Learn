package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbvb extends zzbyr<zzbuy> {
    public zzbvb(Set<zzcab<zzbuy>> set) {
        super(set);
    }

    public final void zza(zzcar zzcarVar, Executor executor) {
        zza(zzcab.zzb(new zzbvf(this, zzcarVar), executor));
    }

    public final void zzca(final Context context) {
        zza(new zzbyt(context) { // from class: com.google.android.gms.internal.ads.zzbva
            private final Context zzcyt;

            {
                this.zzcyt = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbuy) obj).zzca(this.zzcyt);
            }
        });
    }

    public final void zzcb(final Context context) {
        zza(new zzbyt(context) { // from class: com.google.android.gms.internal.ads.zzbvd
            private final Context zzcyt;

            {
                this.zzcyt = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbuy) obj).zzcb(this.zzcyt);
            }
        });
    }

    public final void zzcc(final Context context) {
        zza(new zzbyt(context) { // from class: com.google.android.gms.internal.ads.zzbvc
            private final Context zzcyt;

            {
                this.zzcyt = context;
            }

            @Override // com.google.android.gms.internal.ads.zzbyt
            public final void zzp(Object obj) {
                ((zzbuy) obj).zzcc(this.zzcyt);
            }
        });
    }
}
