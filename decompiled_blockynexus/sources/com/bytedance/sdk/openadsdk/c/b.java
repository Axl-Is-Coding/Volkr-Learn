package com.bytedance.sdk.openadsdk.c;

import android.os.Handler;
import android.os.Message;
import com.bytedance.sdk.openadsdk.c.g;
import com.bytedance.sdk.openadsdk.c.i;
import com.bytedance.sdk.openadsdk.f.b.c;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AdEventDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class b<T extends i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g<T> f5743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f5744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AtomicBoolean f5745c;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AdEventDispatcher.java */
    public static class a extends b<com.bytedance.sdk.openadsdk.c.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile a f5746a;

        a() {
        }

        public static a e() {
            if (f5746a == null) {
                synchronized (a.class) {
                    if (f5746a == null) {
                        f5746a = new a();
                    }
                }
            }
            return f5746a;
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void a(com.bytedance.sdk.openadsdk.c.a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public synchronized void a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.c.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdEventDispatcher.java */
    public static class C0074b extends b<c.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static volatile C0074b f5747a;

        C0074b() {
        }

        public static C0074b e() {
            if (f5747a == null) {
                synchronized (C0074b.class) {
                    if (f5747a == null) {
                        f5747a = new C0074b();
                    }
                }
            }
            return f5747a;
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void a(c.a aVar) {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public void b() {
        }

        @Override // com.bytedance.sdk.openadsdk.c.b
        public synchronized void a() {
        }
    }

    public b(e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, g.b bVar, g.a aVar) {
        this.f5743a = new g<>(eVar, pVar, bVar, aVar);
        this.f5745c = new AtomicBoolean(false);
    }

    public static a c() {
        return a.e();
    }

    public static C0074b d() {
        return C0074b.e();
    }

    public synchronized void a() {
        if ((this.f5745c == null || !this.f5745c.get()) && this.f5743a.getLooper() == null) {
            if (this.f5745c != null && !this.f5745c.get()) {
                this.f5743a.start();
                this.f5744b = new Handler(this.f5743a.getLooper(), this.f5743a);
                Message messageObtainMessage = this.f5744b.obtainMessage();
                messageObtainMessage.what = 5;
                this.f5744b.sendMessage(messageObtainMessage);
                this.f5745c.set(true);
            }
        }
    }

    public void b() {
        this.f5745c.set(false);
        this.f5743a.quit();
        this.f5744b.removeCallbacksAndMessages(null);
    }

    public b(e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, g.b bVar, g.a aVar, g<T> gVar) {
        this.f5743a = gVar;
        this.f5745c = new AtomicBoolean(false);
    }

    b() {
    }

    public void a(T t) {
        if (this.f5745c.get()) {
            Message messageObtainMessage = this.f5744b.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.obj = t;
            this.f5744b.sendMessage(messageObtainMessage);
        }
    }
}
