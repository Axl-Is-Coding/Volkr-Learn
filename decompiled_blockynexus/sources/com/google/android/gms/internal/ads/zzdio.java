package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdio implements zzdgx<zzdip> {
    List<String> zzdrc;
    private zzdzb zzgcz;
    zzaan zzgzk;

    public zzdio(zzaan zzaanVar, zzdzb zzdzbVar, List<String> list) {
        this.zzgzk = zzaanVar;
        this.zzgcz = zzdzbVar;
        this.zzdrc = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdip> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdir
            private final zzdio zzgzl;

            {
                this.zzgzl = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdio zzdioVar = this.zzgzl;
                return new zzdip(zzdioVar.zzgzk.zzf(zzdioVar.zzdrc));
            }
        });
    }
}
