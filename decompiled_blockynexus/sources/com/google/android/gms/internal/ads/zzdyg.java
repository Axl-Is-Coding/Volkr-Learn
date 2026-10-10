package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzdyg<T> extends zzdyy<T> {
    private final Executor zzhsx;
    boolean zzhsy = true;
    private final /* synthetic */ zzdye zzhsz;

    zzdyg(zzdye zzdyeVar, Executor executor) {
        this.zzhsz = zzdyeVar;
        zzdwd.checkNotNull(executor);
        this.zzhsx = executor;
    }

    final void execute() {
        try {
            this.zzhsx.execute(this);
        } catch (RejectedExecutionException e2) {
            if (this.zzhsy) {
                this.zzhsz.setException(e2);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdyy
    final boolean isDone() {
        return this.zzhsz.isDone();
    }

    abstract void setValue(T t);

    @Override // com.google.android.gms.internal.ads.zzdyy
    final void zzb(T t, Throwable th) {
        zzdye.zza(this.zzhsz, (zzdyg) null);
        if (th == null) {
            setValue(t);
            return;
        }
        if (th instanceof ExecutionException) {
            this.zzhsz.setException(th.getCause());
        } else if (th instanceof CancellationException) {
            this.zzhsz.cancel(false);
        } else {
            this.zzhsz.setException(th);
        }
    }
}
