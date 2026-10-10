package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: OpenAppSuccEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k f5775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HandlerThread f5776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f5777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Executor f5778d = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f5779e = b.a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f5780f;

    /* JADX INFO: compiled from: OpenAppSuccEvent.java */
    private static class a implements Serializable, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f5782a = new AtomicInteger(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicBoolean f5783b = new AtomicBoolean(false);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.core.d.h f5784c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f5785d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Map<String, Object> f5786e;

        public a() {
        }

        public static a a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str, Map<String, Object> map) {
            return new a(hVar, str, map);
        }

        public void b() {
            this.f5782a.incrementAndGet();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5784c == null || TextUtils.isEmpty(this.f5785d)) {
                com.bytedance.sdk.openadsdk.utils.o.a("materialMeta or eventTag is null, pls check");
            } else {
                d.f(com.bytedance.sdk.openadsdk.core.o.a(), this.f5784c, this.f5785d, this.f5783b.get() ? "dpl_success" : "dpl_failed", this.f5786e);
            }
        }

        public a a(boolean z) {
            this.f5783b.set(z);
            return this;
        }

        public int a() {
            return this.f5782a.get();
        }

        public a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str, Map<String, Object> map) {
            this.f5784c = hVar;
            this.f5785d = str;
            this.f5786e = map;
        }
    }

    /* JADX INFO: compiled from: OpenAppSuccEvent.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5787a = 500;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5788b = 5000;

        public static b a() {
            return new b();
        }
    }

    private k() {
        if (this.f5776b == null) {
            this.f5776b = new HandlerThread("OpenAppSuccEvent_HandlerThread", 10);
            this.f5776b.start();
        }
        this.f5777c = new Handler(this.f5776b.getLooper(), new Handler.Callback() { // from class: com.bytedance.sdk.openadsdk.c.k.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                if (message.what != 100) {
                    return true;
                }
                a aVar = null;
                Object obj = message.obj;
                if (obj != null && (obj instanceof a)) {
                    aVar = (a) obj;
                }
                if (aVar == null) {
                    return true;
                }
                k.this.b(aVar);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar == null) {
            return;
        }
        Context contextA = com.bytedance.sdk.openadsdk.core.o.a();
        if (ab.c(contextA, contextA.getPackageName())) {
            a(aVar);
        } else {
            c(aVar.a(true));
        }
    }

    private void c(a aVar) {
        if (aVar == null) {
            return;
        }
        this.f5778d.execute(aVar);
    }

    public static k a() {
        if (f5775a == null) {
            synchronized (k.class) {
                if (f5775a == null) {
                    f5775a = new k();
                }
            }
        }
        return f5775a;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.h hVar, String str) {
        Message messageObtainMessage = this.f5777c.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = a.a(hVar, str, this.f5780f);
        messageObtainMessage.sendToTarget();
    }

    private void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.b();
        int iA = aVar.a();
        b bVar = this.f5779e;
        if (iA * bVar.f5787a > bVar.f5788b) {
            c(aVar.a(false));
            return;
        }
        Message messageObtainMessage = this.f5777c.obtainMessage();
        messageObtainMessage.what = 100;
        messageObtainMessage.obj = aVar;
        this.f5777c.sendMessageDelayed(messageObtainMessage, this.f5779e.f5787a);
    }
}
