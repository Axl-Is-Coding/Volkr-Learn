package com.google.android.gms.internal.firebase_messaging;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes2.dex */
public class zze extends Handler {
    private static volatile zzh zzc;

    public zze() {
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }

    public zze(Looper looper) {
        super(looper);
    }

    public zze(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }
}
