package com.android.volley;

import android.os.Process;
import com.android.volley.Request;
import com.android.volley.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: CacheDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f3984a = p.f4029b;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<Request<?>> f3985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BlockingQueue<Request<?>> f3986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.android.volley.a f3987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final n f3988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f3989f = false;
    private final a g = new a(this);

    /* JADX INFO: compiled from: CacheDispatcher.java */
    private static class a implements Request.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, List<Request<?>>> f3990a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final c f3991b;

        a(c cVar) {
            this.f3991b = cVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(Request<?> request) {
            String strD = request.d();
            if (!this.f3990a.containsKey(strD)) {
                this.f3990a.put(strD, null);
                request.a((Request.a) this);
                if (p.f4029b) {
                    p.a("new request, sending to network %s", strD);
                }
                return false;
            }
            List<Request<?>> arrayList = this.f3990a.get(strD);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            request.a("waiting-for-response");
            arrayList.add(request);
            this.f3990a.put(strD, arrayList);
            if (p.f4029b) {
                p.a("Request for cacheKey=%s is in flight, putting on hold.", strD);
            }
            return true;
        }

        @Override // com.android.volley.Request.a
        public void a(Request<?> request, m<?> mVar) {
            List<Request<?>> listRemove;
            a.C0049a c0049a = mVar.f4025b;
            if (c0049a == null || c0049a.a()) {
                a(request);
                return;
            }
            String strD = request.d();
            synchronized (this) {
                listRemove = this.f3990a.remove(strD);
            }
            if (listRemove != null) {
                if (p.f4029b) {
                    p.c("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(listRemove.size()), strD);
                }
                Iterator<Request<?>> it = listRemove.iterator();
                while (it.hasNext()) {
                    this.f3991b.f3988e.a(it.next(), mVar);
                }
            }
        }

        @Override // com.android.volley.Request.a
        public synchronized void a(Request<?> request) {
            String strD = request.d();
            List<Request<?>> listRemove = this.f3990a.remove(strD);
            if (listRemove != null && !listRemove.isEmpty()) {
                if (p.f4029b) {
                    p.c("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(listRemove.size()), strD);
                }
                Request<?> requestRemove = listRemove.remove(0);
                this.f3990a.put(strD, listRemove);
                requestRemove.a((Request.a) this);
                try {
                    this.f3991b.f3986c.put(requestRemove);
                } catch (InterruptedException e2) {
                    p.b("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.f3991b.a();
                }
            }
        }
    }

    public c(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, com.android.volley.a aVar, n nVar) {
        this.f3985b = blockingQueue;
        this.f3986c = blockingQueue2;
        this.f3987d = aVar;
        this.f3988e = nVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f3984a) {
            p.c("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f3987d.initialize();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f3989f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                p.b("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        a(this.f3985b.take());
    }

    public void a() {
        this.f3989f = true;
        interrupt();
    }

    void a(Request<?> request) throws InterruptedException {
        request.a("cache-queue-take");
        if (request.v()) {
            request.b("cache-discard-canceled");
            return;
        }
        a.C0049a c0049a = this.f3987d.get(request.d());
        if (c0049a == null) {
            request.a("cache-miss");
            if (this.g.b(request)) {
                return;
            }
            this.f3986c.put(request);
            return;
        }
        if (c0049a.a()) {
            request.a("cache-hit-expired");
            request.a(c0049a);
            if (this.g.b(request)) {
                return;
            }
            this.f3986c.put(request);
            return;
        }
        request.a("cache-hit");
        m<?> mVarA = request.a(new j(c0049a.f3976a, c0049a.g));
        request.a("cache-hit-parsed");
        if (!c0049a.b()) {
            this.f3988e.a(request, mVarA);
            return;
        }
        request.a("cache-hit-refresh-needed");
        request.a(c0049a);
        mVarA.f4027d = true;
        if (!this.g.b(request)) {
            this.f3988e.a(request, mVarA, new b(this, request));
        } else {
            this.f3988e.a(request, mVarA);
        }
    }
}
