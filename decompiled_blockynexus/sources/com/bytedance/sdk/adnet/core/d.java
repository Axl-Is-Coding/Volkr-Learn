package com.bytedance.sdk.adnet.core;

import android.os.Process;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.err.VAdError;
import com.bytedance.sdk.adnet.face.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: CacheDispatcher.java */
/* JADX INFO: loaded from: classes.dex */
class d extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f5485a = o.f5544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BlockingQueue<Request<?>> f5486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BlockingQueue<Request<?>> f5487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.a f5488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.c f5489e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f5490f = false;
    private final a g = new a(this);

    /* JADX INFO: compiled from: CacheDispatcher.java */
    private static class a implements Request.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, List<Request<?>>> f5493a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f5494b;

        a(d dVar) {
            this.f5494b = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean b(Request<?> request) {
            String cacheKey = request.getCacheKey();
            if (!this.f5493a.containsKey(cacheKey)) {
                this.f5493a.put(cacheKey, null);
                request.a(this);
                if (o.f5544a) {
                    o.b("new request, sending to network %s", cacheKey);
                }
                return false;
            }
            List<Request<?>> arrayList = this.f5493a.get(cacheKey);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            request.addMarker("waiting-for-response");
            arrayList.add(request);
            this.f5493a.put(cacheKey, arrayList);
            if (o.f5544a) {
                o.b("Request for cacheKey=%s is in flight, putting on hold.", cacheKey);
            }
            return true;
        }

        @Override // com.bytedance.sdk.adnet.core.Request.a
        public void a(Request<?> request, m<?> mVar) {
            List<Request<?>> listRemove;
            a.C0073a c0073a = mVar.f5539b;
            if (c0073a == null || c0073a.a()) {
                a(request);
                return;
            }
            String cacheKey = request.getCacheKey();
            synchronized (this) {
                listRemove = this.f5493a.remove(cacheKey);
            }
            if (listRemove != null) {
                if (o.f5544a) {
                    o.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(listRemove.size()), cacheKey);
                }
                Iterator<Request<?>> it = listRemove.iterator();
                while (it.hasNext()) {
                    this.f5494b.f5489e.a(it.next(), mVar);
                }
            }
        }

        @Override // com.bytedance.sdk.adnet.core.Request.a
        public synchronized void a(Request<?> request) {
            String cacheKey = request.getCacheKey();
            List<Request<?>> listRemove = this.f5493a.remove(cacheKey);
            if (listRemove != null && !listRemove.isEmpty()) {
                if (o.f5544a) {
                    o.a("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(listRemove.size()), cacheKey);
                }
                Request<?> requestRemove = listRemove.remove(0);
                this.f5493a.put(cacheKey, listRemove);
                requestRemove.a(this);
                try {
                    this.f5494b.f5487c.put(requestRemove);
                } catch (InterruptedException e2) {
                    o.c("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.f5494b.a();
                }
            }
        }
    }

    public d(BlockingQueue<Request<?>> blockingQueue, BlockingQueue<Request<?>> blockingQueue2, com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.c cVar) {
        this.f5486b = blockingQueue;
        this.f5487c = blockingQueue2;
        this.f5488d = aVar;
        this.f5489e = cVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (f5485a) {
            o.a("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f5488d.a();
        while (true) {
            try {
                b();
            } catch (InterruptedException unused) {
                if (this.f5490f) {
                    Thread.currentThread().interrupt();
                    return;
                }
                o.c("Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    private void b() throws InterruptedException {
        a(this.f5486b.take());
    }

    public void a() {
        this.f5490f = true;
        interrupt();
    }

    void a(final Request<?> request) throws InterruptedException {
        request.addMarker("cache-queue-take");
        request.a(1);
        try {
            try {
            } catch (Throwable th) {
                o.a(th, "CacheDispatcher Unhandled Throwable %s", th.toString());
                this.f5489e.a(request, new VAdError(th));
            }
            if (request.isCanceled()) {
                request.a("cache-discard-canceled");
                return;
            }
            a.C0073a c0073aA = this.f5488d.a(request.getCacheKey());
            if (c0073aA == null) {
                request.addMarker("cache-miss");
                if (!this.g.b(request)) {
                    this.f5487c.put(request);
                }
                return;
            }
            if (c0073aA.a()) {
                request.addMarker("cache-hit-expired");
                request.setCacheEntry(c0073aA);
                if (!this.g.b(request)) {
                    this.f5487c.put(request);
                }
                return;
            }
            request.addMarker("cache-hit");
            m<?> mVarA = request.a(new i(c0073aA.f5567b, c0073aA.h));
            request.addMarker("cache-hit-parsed");
            if (!c0073aA.b()) {
                this.f5489e.a(request, mVarA);
            } else {
                request.addMarker("cache-hit-refresh-needed");
                request.setCacheEntry(c0073aA);
                mVarA.f5541d = true;
                if (!this.g.b(request)) {
                    this.f5489e.a(request, mVarA, new Runnable() { // from class: com.bytedance.sdk.adnet.core.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                d.this.f5487c.put(request);
                            } catch (InterruptedException unused) {
                                Thread.currentThread().interrupt();
                            }
                        }
                    });
                } else {
                    this.f5489e.a(request, mVarA);
                }
            }
        } finally {
            request.a(2);
        }
    }
}
