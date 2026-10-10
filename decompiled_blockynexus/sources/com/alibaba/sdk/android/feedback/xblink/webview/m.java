package com.alibaba.sdk.android.feedback.xblink.webview;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
class m extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Handler f3922a;

    public m(Handler handler) {
        super(handler.getLooper());
        this.f3922a = handler;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            if (com.alibaba.sdk.android.feedback.xblink.i.g.a()) {
                com.alibaba.sdk.android.feedback.xblink.i.g.a("WebCoreProxyHandler", "handle message: " + message.what);
            }
            this.f3922a.handleMessage(message);
        } catch (Throwable th) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b("WebCoreProxyHandler", "handleMessage exception: " + th);
        }
    }
}
