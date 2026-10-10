package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdxq;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdzk extends zzdxq.zzh<Void> implements Runnable {
    private final Runnable zzhtt;

    public zzdzk(Runnable runnable) {
        zzdwd.checkNotNull(runnable);
        this.zzhtt = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzhtt.run();
        } catch (Throwable th) {
            setException(th);
            zzdwh.zzj(th);
            throw null;
        }
    }
}
