package com.bytedance.sdk.openadsdk.h;

import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.h.g;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.ServerProtocol;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ProxyServer.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile f f6904e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile ServerSocket f6905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile int f6906b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.h.b.c f6909f;
    private volatile com.bytedance.sdk.openadsdk.h.a.c g;
    private volatile com.bytedance.sdk.openadsdk.h.a.b h;
    private volatile c k;
    private volatile c l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicInteger f6907c = new AtomicInteger(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ExecutorService f6908d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.h.f.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("video-proxyserver-" + thread.getId());
            return thread;
        }
    });
    private final SparseArray<Set<g>> i = new SparseArray<>(2);
    private final g.c j = new g.c() { // from class: com.bytedance.sdk.openadsdk.h.f.2
        @Override // com.bytedance.sdk.openadsdk.h.g.c
        public void a(g gVar) {
            synchronized (f.this.i) {
                Set set = (Set) f.this.i.get(gVar.f());
                if (set != null) {
                    set.add(gVar);
                }
            }
        }

        @Override // com.bytedance.sdk.openadsdk.h.g.c
        public void b(g gVar) {
            if (e.f6890c) {
                Log.d("TAG_PROXY_ProxyServer", "afterExecute, ProxyTask: " + gVar);
            }
            int iF = gVar.f();
            synchronized (f.this.i) {
                Set set = (Set) f.this.i.get(iF);
                if (set != null) {
                    set.remove(gVar);
                }
            }
        }
    };
    private final Runnable m = new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.f.3
        /* JADX WARN: Removed duplicated region for block: B:33:0x00e7  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instruction units count: 286
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.f.AnonymousClass3.run():void");
        }
    };
    private final AtomicBoolean n = new AtomicBoolean();

    /* JADX INFO: compiled from: ProxyServer.java */
    private static final class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6913a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f6914b;

        a(String str, int i) {
            this.f6913a = str;
            this.f6914b = i;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Throwable {
            Throwable th;
            Socket socket;
            Throwable th2;
            try {
                try {
                    socket = new Socket(this.f6913a, this.f6914b);
                    try {
                        socket.setSoTimeout(2000);
                        OutputStream outputStream = socket.getOutputStream();
                        outputStream.write("Ping\n".getBytes(com.bytedance.sdk.openadsdk.h.g.d.f6950a));
                        outputStream.flush();
                        if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                            com.bytedance.sdk.openadsdk.h.g.d.a(socket);
                            return true;
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        th2.printStackTrace();
                        f.b("ping error", Log.getStackTraceString(th2));
                    }
                } catch (Throwable th4) {
                    th = th4;
                    com.bytedance.sdk.openadsdk.h.g.d.a((Socket) null);
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
                com.bytedance.sdk.openadsdk.h.g.d.a((Socket) null);
                throw th;
            }
            com.bytedance.sdk.openadsdk.h.g.d.a(socket);
            return false;
        }
    }

    private f() {
        this.i.put(0, new HashSet());
        this.i.put(1, new HashSet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f6907c.compareAndSet(1, 2) || this.f6907c.compareAndSet(0, 2)) {
            com.bytedance.sdk.openadsdk.h.g.d.a(this.f6905a);
            this.f6908d.shutdownNow();
            f();
        }
    }

    private void f() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.i) {
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                Set<g> set = this.i.get(this.i.keyAt(i));
                if (set != null) {
                    arrayList.addAll(set);
                    set.clear();
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((g) it.next()).a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        Future futureSubmit = this.f6908d.submit(new a("127.0.0.1", this.f6906b));
        h();
        try {
            if (((Boolean) futureSubmit.get()).booleanValue()) {
                if (!e.f6890c) {
                    return true;
                }
                Log.i("TAG_PROXY_ProxyServer", "Ping OK!");
                return true;
            }
            Log.e("TAG_PROXY_ProxyServer", "Ping error");
            b("ping error", "");
            e();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            b("ping error", Log.getStackTraceString(th));
            e();
            return false;
        }
    }

    private void h() {
        Socket socketAccept = null;
        try {
            try {
                socketAccept = this.f6905a.accept();
                socketAccept.setSoTimeout(2000);
                if ("Ping".equals(new BufferedReader(new InputStreamReader(socketAccept.getInputStream())).readLine())) {
                    OutputStream outputStream = socketAccept.getOutputStream();
                    outputStream.write("OK\n".getBytes(com.bytedance.sdk.openadsdk.h.g.d.f6950a));
                    outputStream.flush();
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                b("ping error", Log.getStackTraceString(e2));
            }
        } finally {
            com.bytedance.sdk.openadsdk.h.g.d.a(socketAccept);
        }
    }

    c b() {
        return this.k;
    }

    c c() {
        return this.l;
    }

    public void d() {
        if (this.n.compareAndSet(false, true)) {
            new Thread(this.m).start();
        }
    }

    boolean a(int i, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.i) {
            Set<g> set = this.i.get(i);
            if (set != null) {
                for (g gVar : set) {
                    if (gVar != null && str.equals(gVar.h)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static f a() {
        if (f6904e == null) {
            synchronized (f.class) {
                if (f6904e == null) {
                    f6904e = new f();
                }
            }
        }
        return f6904e;
    }

    void a(com.bytedance.sdk.openadsdk.h.b.c cVar) {
        this.f6909f = cVar;
    }

    void a(com.bytedance.sdk.openadsdk.h.a.c cVar) {
        this.g = cVar;
    }

    public String a(boolean z, boolean z2, String str, String... strArr) {
        if (strArr != null && strArr.length != 0) {
            if (TextUtils.isEmpty(str)) {
                b("key", "key is empty");
                return strArr[0];
            }
            if (this.f6909f == null) {
                b(UserDataStore.DATE_OF_BIRTH, "VideoProxyDB is null");
                return strArr[0];
            }
            if ((z ? this.h : this.g) == null) {
                b("cache", "Cache is null");
                return strArr[0];
            }
            int i = this.f6907c.get();
            if (i != 1) {
                b(ServerProtocol.DIALOG_PARAM_STATE, "ProxyServer is not running, " + i);
                return strArr[0];
            }
            List<String> listA = com.bytedance.sdk.openadsdk.h.g.d.a(strArr);
            if (listA == null) {
                b("url", "url not start with http/https");
                return strArr[0];
            }
            String strA = i.a(str, z2 ? str : com.bytedance.sdk.openadsdk.h.g.b.a(str), listA);
            if (strA == null) {
                b("url", "combine proxy url error");
                return strArr[0];
            }
            if (z) {
                return "http://127.0.0.1:" + this.f6906b + "?f=1&" + strA;
            }
            return "http://127.0.0.1:" + this.f6906b + "?" + strA;
        }
        b("url", "url is empty");
        return null;
    }
}
