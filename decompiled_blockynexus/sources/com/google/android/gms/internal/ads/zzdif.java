package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdif implements zzdgx<zzdic> {
    private zzdzb zzgcz;
    zztg zzgze;
    Context zzvr;

    public zzdif(zztg zztgVar, zzdzb zzdzbVar, Context context) {
        this.zzgze = zztgVar;
        this.zzgcz = zzdzbVar;
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdic> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdie
            private final zzdif zzgzd;

            {
                this.zzgzd = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdif zzdifVar = this.zzgzd;
                return new zzdic(zzdifVar.zzgze.zzf(zzdifVar.zzvr));
            }
        });
    }
}
