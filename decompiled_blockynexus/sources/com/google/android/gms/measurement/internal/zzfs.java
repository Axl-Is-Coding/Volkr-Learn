package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfs<V> extends FutureTask<V> implements Comparable<zzfs<V>> {
    final boolean zza;
    private final long zzb;
    private final String zzc;
    private final /* synthetic */ zzfr zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfs(zzfr zzfrVar, Callable<V> callable, boolean z, String str) {
        super(com.google.android.gms.internal.measurement.zzm.zza().zza(callable));
        this.zzd = zzfrVar;
        Preconditions.checkNotNull(str);
        this.zzb = zzfr.zzj.getAndIncrement();
        this.zzc = str;
        this.zza = z;
        if (this.zzb == Long.MAX_VALUE) {
            zzfrVar.zzq().zze().zza("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        zzfs zzfsVar = (zzfs) obj;
        boolean z = this.zza;
        if (z != zzfsVar.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzfsVar.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzq().zzf().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    protected final void setException(Throwable th) {
        this.zzd.zzq().zze().zza(this.zzc, th);
        if (th instanceof zzfq) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfs(zzfr zzfrVar, Runnable runnable, boolean z, String str) {
        super(com.google.android.gms.internal.measurement.zzm.zza().zza(runnable), null);
        this.zzd = zzfrVar;
        Preconditions.checkNotNull(str);
        this.zzb = zzfr.zzj.getAndIncrement();
        this.zzc = str;
        this.zza = z;
        if (this.zzb == Long.MAX_VALUE) {
            zzfrVar.zzq().zze().zza("Tasks index overflow");
        }
    }
}
