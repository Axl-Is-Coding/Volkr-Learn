package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdyp<V> extends zzdym<V> implements zzdzc<V> {
    protected zzdyp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdzc
    public void addListener(Runnable runnable, Executor executor) {
        zzaxh().addListener(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdym
    /* JADX INFO: renamed from: zzayg, reason: merged with bridge method [inline-methods] */
    public abstract zzdzc<? extends V> zzaxh();
}
