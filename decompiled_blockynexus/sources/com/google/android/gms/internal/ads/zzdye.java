package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxu;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdye<V> extends zzdxu<Object, V> {
    private zzdyg<?> zzhsw;

    zzdye(zzdwk<? extends zzdzc<?>> zzdwkVar, boolean z, Executor executor, Callable<V> callable) {
        super(zzdwkVar, z, false);
        this.zzhsw = new zzdyh(this, callable, executor);
        zzaxy();
    }

    @Override // com.google.android.gms.internal.ads.zzdxq
    protected final void interruptTask() {
        zzdyg<?> zzdygVar = this.zzhsw;
        if (zzdygVar != null) {
            zzdygVar.interruptTask();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxu
    final void zza(zzdxu.zza zzaVar) {
        super.zza(zzaVar);
        if (zzaVar == zzdxu.zza.OUTPUT_FUTURE_DONE) {
            this.zzhsw = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxu
    final void zzaxz() {
        zzdyg<?> zzdygVar = this.zzhsw;
        if (zzdygVar != null) {
            zzdygVar.execute();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdxu
    final void zzb(int i, Object obj) {
    }

    static /* synthetic */ zzdyg zza(zzdye zzdyeVar, zzdyg zzdygVar) {
        zzdyeVar.zzhsw = null;
        return null;
    }
}
