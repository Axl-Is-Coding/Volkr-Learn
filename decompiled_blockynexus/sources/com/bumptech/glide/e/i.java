package com.bumptech.glide.e;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: LruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class i<T, Y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<T, Y> f4168a = new LinkedHashMap(100, 0.75f, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f4169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f4170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f4171d;

    public i(long j) {
        this.f4169b = j;
        this.f4170c = j;
    }

    public synchronized Y a(T t) {
        return this.f4168a.get(t);
    }

    protected void a(T t, Y y) {
    }

    protected int b(Y y) {
        return 1;
    }

    public synchronized long b() {
        return this.f4170c;
    }

    public synchronized Y c(T t) {
        Y yRemove;
        yRemove = this.f4168a.remove(t);
        if (yRemove != null) {
            this.f4171d -= (long) b(yRemove);
        }
        return yRemove;
    }

    public void a() {
        a(0L);
    }

    public synchronized Y b(T t, Y y) {
        long jB = b(y);
        if (jB >= this.f4170c) {
            a(t, y);
            return null;
        }
        if (y != null) {
            this.f4171d += jB;
        }
        Y yPut = this.f4168a.put(t, y);
        if (yPut != null) {
            this.f4171d -= (long) b(yPut);
            if (!yPut.equals(y)) {
                a(t, yPut);
            }
        }
        c();
        return yPut;
    }

    protected synchronized void a(long j) {
        while (this.f4171d > j) {
            Iterator<Map.Entry<T, Y>> it = this.f4168a.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.f4171d -= (long) b(value);
            T key = next.getKey();
            it.remove();
            a(key, value);
        }
    }

    private void c() {
        a(this.f4170c);
    }
}
