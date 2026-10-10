package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class zzag extends Handler {
    private final /* synthetic */ zzaf zzcx;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzag(zzaf zzafVar, Looper looper) {
        super(looper);
        this.zzcx = zzafVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.zzcx.zze(message);
    }
}
