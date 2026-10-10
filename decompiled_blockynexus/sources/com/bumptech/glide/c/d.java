package com.bumptech.glide.c;

import com.bumptech.glide.e.k;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ModelToResourceClassCache.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference<k> f4126a = new AtomicReference<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a.a.b<k, List<Class<?>>> f4127b = new a.a.b<>();

    public List<Class<?>> a(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        List<Class<?>> list;
        k andSet = this.f4126a.getAndSet(null);
        if (andSet == null) {
            andSet = new k(cls, cls2, cls3);
        } else {
            andSet.a(cls, cls2, cls3);
        }
        synchronized (this.f4127b) {
            list = this.f4127b.get(andSet);
        }
        this.f4126a.set(andSet);
        return list;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, List<Class<?>> list) {
        synchronized (this.f4127b) {
            this.f4127b.put(new k(cls, cls2, cls3), list);
        }
    }
}
