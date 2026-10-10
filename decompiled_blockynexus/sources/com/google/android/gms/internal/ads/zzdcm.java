package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdcm implements zzdgx<zzdcn> {
    private final zzbbx zzdqm;
    private final zzdok zzfsk;
    private final zzdzb zzgcz;

    public zzdcm(zzdzb zzdzbVar, zzdok zzdokVar, zzbbx zzbbxVar) {
        this.zzgcz = zzdzbVar;
        this.zzfsk = zzdokVar;
        this.zzdqm = zzbbxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdcn> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdcp
            private final zzdcm zzgvs;

            {
                this.zzgvs = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgvs.zzarm();
            }
        });
    }

    final /* synthetic */ zzdcn zzarm() throws Exception {
        return new zzdcn(this.zzfsk.zzhfe, this.zzdqm);
    }
}
