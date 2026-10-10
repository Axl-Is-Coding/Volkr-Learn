package com.bytedance.sdk.openadsdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: WeakHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class ad extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference<a> f7102a;

    /* JADX INFO: compiled from: WeakHandler.java */
    public interface a {
        void a(Message message);
    }

    public ad(a aVar) {
        this.f7102a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f7102a.get();
        if (aVar == null || message == null) {
            return;
        }
        aVar.a(message);
    }

    public ad(Looper looper, a aVar) {
        super(looper);
        this.f7102a = new WeakReference<>(aVar);
    }
}
