package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzed;
import com.google.android.gms.internal.ads.zzeg;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
final class zzo implements Callable<zzeg> {
    private final /* synthetic */ zzj zzbpm;

    zzo(zzj zzjVar) {
        this.zzbpm = zzjVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzeg call() throws Exception {
        return new zzeg(zzed.zzb(this.zzbpm.zzbpe.zzbre, this.zzbpm.zzvr, false));
    }
}
