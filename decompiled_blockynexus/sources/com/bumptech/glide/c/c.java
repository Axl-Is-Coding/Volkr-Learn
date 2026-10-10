package com.bumptech.glide.c;

import com.bumptech.glide.e.k;
import com.bumptech.glide.load.b.d.g;
import com.bumptech.glide.load.engine.j;
import com.bumptech.glide.load.engine.z;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: LoadPathCache.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final z<?, ?, ?> f4123a = new z<>(Object.class, Object.class, Object.class, Collections.singletonList(new j(Object.class, Object.class, Object.class, Collections.emptyList(), new g(), null)), null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a.a.b<k, z<?, ?, ?>> f4124b = new a.a.b<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicReference<k> f4125c = new AtomicReference<>();

    private k b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        k andSet = this.f4125c.getAndSet(null);
        if (andSet == null) {
            andSet = new k();
        }
        andSet.a(cls, cls2, cls3);
        return andSet;
    }

    public boolean a(z<?, ?, ?> zVar) {
        return f4123a.equals(zVar);
    }

    public <Data, TResource, Transcode> z<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        z<Data, TResource, Transcode> zVar;
        k kVarB = b(cls, cls2, cls3);
        synchronized (this.f4124b) {
            zVar = (z) this.f4124b.get(kVarB);
        }
        this.f4125c.set(kVarB);
        return zVar;
    }

    public void a(Class<?> cls, Class<?> cls2, Class<?> cls3, z<?, ?, ?> zVar) {
        synchronized (this.f4124b) {
            a.a.b<k, z<?, ?, ?>> bVar = this.f4124b;
            k kVar = new k(cls, cls2, cls3);
            if (zVar == null) {
                zVar = f4123a;
            }
            bVar.put(kVar, zVar);
        }
    }
}
