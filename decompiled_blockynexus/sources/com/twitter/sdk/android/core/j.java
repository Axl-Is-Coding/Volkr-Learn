package com.twitter.sdk.android.core;

import com.twitter.sdk.android.core.l;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PersistedSessionManager.java */
/* JADX INFO: loaded from: classes5.dex */
public class j<T extends l> implements m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.twitter.sdk.android.core.internal.b.b f20211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.twitter.sdk.android.core.internal.b.e<T> f20212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentHashMap<Long, T> f20213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<Long, com.twitter.sdk.android.core.internal.b.d<T>> f20214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.twitter.sdk.android.core.internal.b.d<T> f20215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference<T> f20216f;
    private final String g;
    private volatile boolean h;

    public j(com.twitter.sdk.android.core.internal.b.b bVar, com.twitter.sdk.android.core.internal.b.e<T> eVar, String str, String str2) {
        this(bVar, eVar, new ConcurrentHashMap(1), new ConcurrentHashMap(1), new com.twitter.sdk.android.core.internal.b.d(bVar, eVar, str), str2);
    }

    private void d() {
        T tB = this.f20215e.b();
        if (tB != null) {
            a(tB.b(), tB, false);
        }
    }

    private synchronized void e() {
        if (this.h) {
            d();
            f();
            this.h = false;
        }
    }

    private void f() {
        T tA;
        for (Map.Entry<String, ?> entry : this.f20211a.get().getAll().entrySet()) {
            if (a(entry.getKey()) && (tA = this.f20212b.a((String) entry.getValue())) != null) {
                a(tA.b(), tA, false);
            }
        }
    }

    boolean a(String str) {
        return str.startsWith(this.g);
    }

    @Override // com.twitter.sdk.android.core.m
    public T b() {
        c();
        return this.f20216f.get();
    }

    void c() {
        if (this.h) {
            e();
        }
    }

    j(com.twitter.sdk.android.core.internal.b.b bVar, com.twitter.sdk.android.core.internal.b.e<T> eVar, ConcurrentHashMap<Long, T> concurrentHashMap, ConcurrentHashMap<Long, com.twitter.sdk.android.core.internal.b.d<T>> concurrentHashMap2, com.twitter.sdk.android.core.internal.b.d<T> dVar, String str) {
        this.h = true;
        this.f20211a = bVar;
        this.f20212b = eVar;
        this.f20213c = concurrentHashMap;
        this.f20214d = concurrentHashMap2;
        this.f20215e = dVar;
        this.f20216f = new AtomicReference<>();
        this.g = str;
    }

    @Override // com.twitter.sdk.android.core.m
    public void a(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Session must not be null!");
        }
        c();
        a(t.b(), t, true);
    }

    String b(long j) {
        return this.g + "_" + j;
    }

    @Override // com.twitter.sdk.android.core.m
    public Map<Long, T> a() {
        c();
        return Collections.unmodifiableMap(this.f20213c);
    }

    private void a(long j, T t, boolean z) {
        this.f20213c.put(Long.valueOf(j), t);
        com.twitter.sdk.android.core.internal.b.d<T> dVar = this.f20214d.get(Long.valueOf(j));
        if (dVar == null) {
            dVar = new com.twitter.sdk.android.core.internal.b.d<>(this.f20211a, this.f20212b, b(j));
            this.f20214d.putIfAbsent(Long.valueOf(j), dVar);
        }
        dVar.a(t);
        T t2 = this.f20216f.get();
        if (t2 == null || t2.b() == j || z) {
            synchronized (this) {
                this.f20216f.compareAndSet(t2, t);
                this.f20215e.a(t);
            }
        }
    }

    @Override // com.twitter.sdk.android.core.m
    public void a(long j) {
        c();
        if (this.f20216f.get() != null && this.f20216f.get().b() == j) {
            synchronized (this) {
                this.f20216f.set(null);
                this.f20215e.a();
            }
        }
        this.f20213c.remove(Long.valueOf(j));
        com.twitter.sdk.android.core.internal.b.d<T> dVarRemove = this.f20214d.remove(Long.valueOf(j));
        if (dVarRemove != null) {
            dVarRemove.a();
        }
    }
}
