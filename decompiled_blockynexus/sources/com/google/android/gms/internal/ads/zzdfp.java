package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdfp implements zzdgx<zzdfm> {
    private final Bundle zzfuh;
    private final zzdzb zzgcz;

    public zzdfp(zzdzb zzdzbVar, Bundle bundle) {
        this.zzgcz = zzdzbVar;
        this.zzfuh = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdfm> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdfo
            private final zzdfp zzgxe;

            {
                this.zzgxe = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgxe.zzaru();
            }
        });
    }

    final /* synthetic */ zzdfm zzaru() throws Exception {
        return new zzdfm(this.zzfuh);
    }
}
