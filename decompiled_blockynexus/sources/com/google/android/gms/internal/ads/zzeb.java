package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeb implements Runnable {
    private final /* synthetic */ MotionEvent zzxs;

    zzeb(zzdy zzdyVar, MotionEvent motionEvent) {
        this.zzxs = motionEvent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzdy.zzxe.zza(this.zzxs);
        } catch (Exception e2) {
            zzdy.zzxg.zza(2022, -1L, e2);
        }
    }
}
