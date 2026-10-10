package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhi extends Handler {
    private final /* synthetic */ zzhj zzaeo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzhi(zzhj zzhjVar, Looper looper) {
        super(looper);
        this.zzaeo = zzhjVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.zzaeo.zza(message);
    }
}
