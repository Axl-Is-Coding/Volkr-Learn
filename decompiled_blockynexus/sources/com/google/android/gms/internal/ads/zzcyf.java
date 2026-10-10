package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcyf implements com.google.android.gms.ads.internal.zzg {
    private final zzcaf zzfqd;
    private final zzbuu zzfxv;
    private final zzbuc zzfxw;
    private final zzbmu zzfxx;
    private final zzcae zzfxz;
    private AtomicBoolean zzgro = new AtomicBoolean(false);

    zzcyf(zzbuc zzbucVar, zzbuu zzbuuVar, zzcaf zzcafVar, zzcae zzcaeVar, zzbmu zzbmuVar) {
        this.zzfxw = zzbucVar;
        this.zzfxv = zzbuuVar;
        this.zzfqd = zzcafVar;
        this.zzfxz = zzcaeVar;
        this.zzfxx = zzbmuVar;
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final synchronized void zzh(View view) {
        if (this.zzgro.compareAndSet(false, true)) {
            this.zzfxx.onAdImpression();
            this.zzfxz.zzv(view);
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkc() {
        if (this.zzgro.get()) {
            this.zzfxw.onAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzkd() {
        if (this.zzgro.get()) {
            this.zzfxv.onAdImpression();
            this.zzfqd.zzakv();
        }
    }
}
