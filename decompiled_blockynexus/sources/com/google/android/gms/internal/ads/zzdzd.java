package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdzd implements Executor {
    boolean zzhtl = true;
    private final /* synthetic */ Executor zzhtm;
    private final /* synthetic */ zzdxq zzhtn;

    zzdzd(Executor executor, zzdxq zzdxqVar) {
        this.zzhtm = executor;
        this.zzhtn = zzdxqVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        try {
            this.zzhtm.execute(new zzdzg(this, runnable));
        } catch (RejectedExecutionException e2) {
            if (this.zzhtl) {
                this.zzhtn.setException(e2);
            }
        }
    }
}
