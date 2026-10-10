package com.bytedance.sdk.openadsdk.core;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.TTAdManagerFactory;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: InitHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f6243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicBoolean f6244b = new AtomicBoolean(false);

    public static void a(Context context) {
        if (f6244b.get()) {
            return;
        }
        synchronized (TTAdManagerFactory.class) {
            if (!f6244b.get()) {
                c(context);
                f6244b.set(true);
            }
        }
    }

    private static void c(final Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.d("InitHelper", "init start: " + f6243a);
        o.a(context.getApplicationContext());
        if (com.bytedance.sdk.openadsdk.core.g.g.a()) {
            com.bytedance.sdk.openadsdk.multipro.d.a(context);
            if (f6243a) {
                Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.l.1
                    @Override // java.lang.Runnable
                    public void run() {
                        l.d(context);
                    }
                });
            } else {
                d(context);
            }
            Log.d("InitHelper", "init over: " + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Context context) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        e(context);
        g(context);
        com.bytedance.sdk.openadsdk.utils.y.a();
        o.h().a();
        ac.a(context);
        f(context);
        o.c().a();
        o.e().a();
        o.d().a();
        o.j().a();
        o.g().a();
        com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a();
        com.bytedance.sdk.openadsdk.core.video.c.a.a().b();
        a();
        Log.d("InitHelper", "do async task: " + (System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private static void e(Context context) {
        com.bytedance.embedapplog.b bVar = new com.bytedance.embedapplog.b(String.valueOf(1181), "openadsdk");
        bVar.a(1);
        com.bytedance.embedapplog.a.a(com.bytedance.sdk.openadsdk.utils.o.c());
        com.bytedance.embedapplog.a.a(context, bVar);
    }

    private static void f(Context context) {
        d.a(context).a("uuid", UUID.randomUUID().toString());
    }

    private static void g(Context context) {
    }

    private static void a() {
        Context contextA;
        if (o.h().d() && (contextA = o.a()) != null) {
            try {
                com.bytedance.sdk.adnet.a.a(new com.bytedance.sdk.openadsdk.g.c(contextA));
                com.bytedance.sdk.adnet.a.a(true);
                com.bytedance.sdk.adnet.a.a(contextA, (Application) contextA, com.bytedance.sdk.openadsdk.multipro.b.b());
            } catch (Exception unused) {
            }
        }
    }
}
