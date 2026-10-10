package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbrh implements com.google.android.gms.ads.internal.overlay.zzp {
    private final zzbvh zzfsg;
    private AtomicBoolean zzfsh = new AtomicBoolean(false);

    public zzbrh(zzbvh zzbvhVar) {
        this.zzfsg = zzbvhVar;
    }

    public final boolean isClosed() {
        return this.zzfsh.get();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzum() {
        this.zzfsh.set(true);
        this.zzfsg.onAdClosed();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzun() {
        this.zzfsg.onAdOpened();
    }
}
