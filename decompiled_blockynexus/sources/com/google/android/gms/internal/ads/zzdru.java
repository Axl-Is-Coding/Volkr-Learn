package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdru<E> {
    private static final zzdzc<?> zzhka = zzdyq.zzaf(null);
    private final ScheduledExecutorService zzfoz;
    private final zzdzb zzgcz;
    private final zzdsg<E> zzhkb;

    public zzdru(zzdzb zzdzbVar, ScheduledExecutorService scheduledExecutorService, zzdsg<E> zzdsgVar) {
        this.zzgcz = zzdzbVar;
        this.zzfoz = scheduledExecutorService;
        this.zzhkb = zzdsgVar;
    }

    public final <I> zzdsa<I> zza(E e2, zzdzc<I> zzdzcVar) {
        return new zzdsa<>(this, e2, zzdzcVar, Collections.singletonList(zzdzcVar), zzdzcVar);
    }

    public final zzdry zzu(E e2) {
        return new zzdry(this, e2);
    }

    protected abstract String zzv(E e2);

    public final zzdrw zza(E e2, zzdzc<?>... zzdzcVarArr) {
        return new zzdrw(this, e2, Arrays.asList(zzdzcVarArr));
    }
}
