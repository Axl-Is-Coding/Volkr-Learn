package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzt implements zzak {
    private final Executor zzag;

    public zzt(Handler handler) {
        this.zzag = new zzs(this, handler);
    }

    @Override // com.google.android.gms.internal.ads.zzak
    public final void zza(zzaa<?> zzaaVar, zzaj<?> zzajVar, Runnable runnable) {
        zzaaVar.zzk();
        zzaaVar.zzc("post-response");
        this.zzag.execute(new zzv(zzaaVar, zzajVar, runnable));
    }

    @Override // com.google.android.gms.internal.ads.zzak
    public final void zzb(zzaa<?> zzaaVar, zzaj<?> zzajVar) {
        zza(zzaaVar, zzajVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzak
    public final void zza(zzaa<?> zzaaVar, zzao zzaoVar) {
        zzaaVar.zzc("post-error");
        this.zzag.execute(new zzv(zzaaVar, zzaj.zzd(zzaoVar), null));
    }
}
