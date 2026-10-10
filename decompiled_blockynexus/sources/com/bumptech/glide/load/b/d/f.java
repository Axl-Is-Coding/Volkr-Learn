package com.bumptech.glide.load.b.d;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: TranscoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a<?, ?>> f4347a = new ArrayList();

    /* JADX INFO: compiled from: TranscoderRegistry.java */
    private static final class a<Z, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<Z> f4348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class<R> f4349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final e<Z, R> f4350c;

        a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
            this.f4348a = cls;
            this.f4349b = cls2;
            this.f4350c = eVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return this.f4348a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f4349b);
        }
    }

    public synchronized <Z, R> void a(Class<Z> cls, Class<R> cls2, e<Z, R> eVar) {
        this.f4347a.add(new a<>(cls, cls2, eVar));
    }

    public synchronized <Z, R> List<Class<R>> b(Class<Z> cls, Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        Iterator<a<?, ?>> it = this.f4347a.iterator();
        while (it.hasNext()) {
            if (it.next().a(cls, cls2)) {
                arrayList.add(cls2);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> e<Z, R> a(Class<Z> cls, Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.a();
        }
        for (a<?, ?> aVar : this.f4347a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f4350c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }
}
