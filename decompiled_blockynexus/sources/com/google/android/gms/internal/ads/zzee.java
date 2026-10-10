package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzee implements Runnable {
    private final /* synthetic */ int zzxu;
    private final /* synthetic */ int zzxv;
    private final /* synthetic */ int zzxw;

    zzee(zzdy zzdyVar, int i, int i2, int i3) {
        this.zzxu = i;
        this.zzxv = i2;
        this.zzxw = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzdy.zzxe.zza(MotionEvent.obtain(0L, this.zzxu, 0, this.zzxv, this.zzxw, 0));
        } catch (Exception e2) {
            zzdy.zzxg.zza(2022, -1L, e2);
        }
    }
}
