package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzayo extends zzdvo {
    public zzayo(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AdMobHandler.handleMessage");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdvo
    protected final void zzb(Message message) {
        try {
            super.zzb(message);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzp.zzkr();
            zzayu.zza(com.google.android.gms.ads.internal.zzp.zzkv().getApplicationContext(), th);
            throw th;
        }
    }
}
