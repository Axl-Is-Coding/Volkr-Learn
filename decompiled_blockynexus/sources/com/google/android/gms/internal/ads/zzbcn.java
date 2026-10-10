package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class zzbcn<T> {
    private final zzbcg<T> zzefc = new zzbcg<>();
    private final AtomicInteger zzefd = new AtomicInteger(0);

    public zzbcn() {
        zzdyq.zza(this.zzefc, new zzbcm(this), zzbbz.zzeeu);
    }

    @Deprecated
    public final int getStatus() {
        return this.zzefd.get();
    }

    @Deprecated
    public final void reject() {
        this.zzefc.setException(new Exception());
    }

    @Deprecated
    public final void zza(zzbck<T> zzbckVar, zzbci zzbciVar) {
        zzdyq.zza(this.zzefc, new zzbcp(this, zzbckVar, zzbciVar), zzbbz.zzeeu);
    }

    @Deprecated
    public final void zzm(T t) {
        this.zzefc.set(t);
    }
}
