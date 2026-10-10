package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzdvo extends Handler {
    private static zzdvn zzhox;

    public zzdvo() {
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        zzb(message);
    }

    protected void zzb(Message message) {
        super.dispatchMessage(message);
    }

    public zzdvo(Looper looper) {
        super(looper);
    }
}
