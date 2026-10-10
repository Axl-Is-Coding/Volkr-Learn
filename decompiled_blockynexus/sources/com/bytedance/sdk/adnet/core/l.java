package com.bytedance.sdk.adnet.core;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: RequestQueue.java */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f5532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Request<?>> f5533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue<Request<?>> f5534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<Request<?>> f5535d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.a f5536e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.bytedance.sdk.adnet.face.b f5537f;
    private final com.bytedance.sdk.adnet.face.c g;
    private final h[] h;
    private d i;
    private final List<b> j;
    private final List<a> k;

    /* JADX INFO: compiled from: RequestQueue.java */
    public interface a {
        void a(Request<?> request, int i);
    }

    /* JADX INFO: compiled from: RequestQueue.java */
    @Deprecated
    public interface b<T> {
        void a(Request<T> request);
    }

    public l(com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.b bVar, int i, com.bytedance.sdk.adnet.face.c cVar) {
        this.f5532a = new AtomicInteger();
        this.f5533b = new HashSet();
        this.f5534c = new PriorityBlockingQueue<>();
        this.f5535d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f5536e = aVar;
        this.f5537f = bVar;
        this.h = new h[i];
        this.g = cVar;
    }

    public void a() {
        b();
        this.i = new d(this.f5534c, this.f5535d, this.f5536e, this.g);
        this.i.start();
        for (int i = 0; i < this.h.length; i++) {
            h hVar = new h(this.f5535d, this.f5537f, this.f5536e, this.g);
            this.h[i] = hVar;
            hVar.start();
        }
    }

    public void b() {
        d dVar = this.i;
        if (dVar != null) {
            dVar.a();
        }
        for (h hVar : this.h) {
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    public int c() {
        return this.f5532a.incrementAndGet();
    }

    <T> void c(Request<T> request) {
        synchronized (this.f5533b) {
            this.f5533b.remove(request);
        }
        synchronized (this.j) {
            Iterator<b> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().a(request);
            }
        }
        a(request, 5);
    }

    public <T> void b(Request<T> request) {
        if (request == null || TextUtils.isEmpty(request.getUrl())) {
            return;
        }
        String url = request.getUrl();
        if (com.bytedance.sdk.adnet.a.d() != null) {
            String strA = com.bytedance.sdk.adnet.a.d().a(url);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            request.setUrl(strA);
        }
    }

    public <T> Request<T> a(Request<T> request) {
        b(request);
        request.setStartTime();
        request.setRequestQueue(this);
        synchronized (this.f5533b) {
            this.f5533b.add(request);
        }
        request.setSequence(c());
        request.addMarker("add-to-queue");
        a(request, 0);
        if (!request.shouldCache()) {
            this.f5535d.add(request);
            return request;
        }
        this.f5534c.add(request);
        return request;
    }

    public l(com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.b bVar, int i) {
        this(aVar, bVar, i, new g(new Handler(Looper.getMainLooper())));
    }

    public l(com.bytedance.sdk.adnet.face.a aVar, com.bytedance.sdk.adnet.face.b bVar) {
        this(aVar, bVar, 4);
    }

    void a(Request<?> request, int i) {
        synchronized (this.k) {
            Iterator<a> it = this.k.iterator();
            while (it.hasNext()) {
                it.next().a(request, i);
            }
        }
    }
}
