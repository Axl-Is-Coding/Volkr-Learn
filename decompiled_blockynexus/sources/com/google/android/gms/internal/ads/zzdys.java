package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdys<V> implements Runnable {
    private final Future<V> zzhte;
    private final zzdyr<? super V> zzhtf;

    zzdys(Future<V> future, zzdyr<? super V> zzdyrVar) {
        this.zzhte = future;
        this.zzhtf = zzdyrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable thZza;
        Future<V> future = this.zzhte;
        if ((future instanceof zzdzt) && (thZza = zzdzw.zza((zzdzt) future)) != null) {
            this.zzhtf.zzb(thZza);
            return;
        }
        try {
            this.zzhtf.onSuccess(zzdyq.zza(this.zzhte));
        } catch (Error e2) {
            e = e2;
            this.zzhtf.zzb(e);
        } catch (RuntimeException e3) {
            e = e3;
            this.zzhtf.zzb(e);
        } catch (ExecutionException e4) {
            this.zzhtf.zzb(e4.getCause());
        }
    }

    public final String toString() {
        return zzdvt.zzx(this).zzy(this.zzhtf).toString();
    }
}
