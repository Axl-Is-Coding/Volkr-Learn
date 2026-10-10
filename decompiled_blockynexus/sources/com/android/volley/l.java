package com.android.volley;

import android.os.Handler;
import android.os.Looper;
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
    private final AtomicInteger f4018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Request<?>> f4019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PriorityBlockingQueue<Request<?>> f4020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PriorityBlockingQueue<Request<?>> f4021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.android.volley.a f4022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final h f4023f;
    private final n g;
    private final i[] h;
    private c i;
    private final List<a> j;

    /* JADX INFO: compiled from: RequestQueue.java */
    public interface a<T> {
        void a(Request<T> request);
    }

    public l(com.android.volley.a aVar, h hVar, int i, n nVar) {
        this.f4018a = new AtomicInteger();
        this.f4019b = new HashSet();
        this.f4020c = new PriorityBlockingQueue<>();
        this.f4021d = new PriorityBlockingQueue<>();
        this.j = new ArrayList();
        this.f4022e = aVar;
        this.f4023f = hVar;
        this.h = new i[i];
        this.g = nVar;
    }

    public int a() {
        return this.f4018a.incrementAndGet();
    }

    public void b() {
        c();
        this.i = new c(this.f4020c, this.f4021d, this.f4022e, this.g);
        this.i.start();
        for (int i = 0; i < this.h.length; i++) {
            i iVar = new i(this.f4021d, this.f4023f, this.f4022e, this.g);
            this.h[i] = iVar;
            iVar.start();
        }
    }

    public void c() {
        c cVar = this.i;
        if (cVar != null) {
            cVar.a();
        }
        for (i iVar : this.h) {
            if (iVar != null) {
                iVar.a();
            }
        }
    }

    public <T> Request<T> a(Request<T> request) {
        request.a(this);
        synchronized (this.f4019b) {
            this.f4019b.add(request);
        }
        request.a(a());
        request.a("add-to-queue");
        if (request.y()) {
            this.f4020c.add(request);
            return request;
        }
        this.f4021d.add(request);
        return request;
    }

    <T> void b(Request<T> request) {
        synchronized (this.f4019b) {
            this.f4019b.remove(request);
        }
        synchronized (this.j) {
            Iterator<a> it = this.j.iterator();
            while (it.hasNext()) {
                it.next().a(request);
            }
        }
    }

    public l(com.android.volley.a aVar, h hVar, int i) {
        this(aVar, hVar, i, new f(new Handler(Looper.getMainLooper())));
    }

    public l(com.android.volley.a aVar, h hVar) {
        this(aVar, hVar, 4);
    }
}
