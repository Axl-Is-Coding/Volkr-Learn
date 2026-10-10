package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdeu implements zzdgx<zzdev> {
    private final zzdnt zzfmt;
    private final zzdzb zzgcz;

    public zzdeu(zzdzb zzdzbVar, zzdnt zzdntVar) {
        this.zzgcz = zzdzbVar;
        this.zzfmt = zzdntVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdev> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdex
            private final zzdeu zzgwx;

            {
                this.zzgwx = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgwx.zzarr();
            }
        });
    }

    final /* synthetic */ zzdev zzarr() throws Exception {
        return new zzdev(this.zzfmt);
    }
}
