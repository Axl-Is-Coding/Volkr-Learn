package com.bytedance.sdk.adnet.d;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: WeakHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<a> f5563a;

    /* JADX INFO: compiled from: WeakHandler.java */
    public interface a {
        void a(Message message);
    }

    public h(Looper looper, a aVar) {
        super(looper);
        this.f5563a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f5563a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }
}
