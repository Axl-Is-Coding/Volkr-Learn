package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdzp<V> extends zzdyy<zzdzc<V>> {
    private final zzdyb<V> zzhtx;
    private final /* synthetic */ zzdzq zzhty;

    zzdzp(zzdzq zzdzqVar, zzdyb<V> zzdybVar) {
        this.zzhty = zzdzqVar;
        zzdwd.checkNotNull(zzdybVar);
        this.zzhtx = zzdybVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final boolean isDone() {
        return this.zzhty.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final /* synthetic */ Object zzayd() throws Exception {
        zzdzc<V> zzdzcVarZzarv = this.zzhtx.zzarv();
        zzdwd.zza(zzdzcVarZzarv, "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.zzhtx);
        return zzdzcVarZzarv;
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final String zzaye() {
        return this.zzhtx.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final /* synthetic */ void zzb(Object obj, Throwable th) {
        zzdzc<? extends V> zzdzcVar = (zzdzc) obj;
        if (th == null) {
            this.zzhty.setFuture(zzdzcVar);
        } else {
            this.zzhty.setException(th);
        }
    }
}
