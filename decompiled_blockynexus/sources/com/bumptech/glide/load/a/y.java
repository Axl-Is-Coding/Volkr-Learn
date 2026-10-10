package com.bumptech.glide.load.a;

import com.bumptech.glide.Registry;
import com.bumptech.glide.load.a.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: MultiModelLoaderFactory.java */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f4311a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final u<Object, Object> f4312b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<b<?, ?>> f4313c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f4314d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Set<b<?, ?>> f4315e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final androidx.core.f.e<List<Throwable>> f4316f;

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class a implements u<Object, Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.a.u
        public u.a<Object> buildLoadData(Object obj, int i, int i2, com.bumptech.glide.load.l lVar) {
            return null;
        }

        @Override // com.bumptech.glide.load.a.u
        public boolean handles(Object obj) {
            return false;
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    private static class b<Model, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<Model> f4317a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class<Data> f4318b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final v<? extends Model, ? extends Data> f4319c;

        public b(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
            this.f4317a = cls;
            this.f4318b = cls2;
            this.f4319c = vVar;
        }

        public boolean a(Class<?> cls, Class<?> cls2) {
            return a(cls) && this.f4318b.isAssignableFrom(cls2);
        }

        public boolean a(Class<?> cls) {
            return this.f4317a.isAssignableFrom(cls);
        }
    }

    /* JADX INFO: compiled from: MultiModelLoaderFactory.java */
    static class c {
        c() {
        }

        public <Model, Data> x<Model, Data> a(List<u<Model, Data>> list, androidx.core.f.e<List<Throwable>> eVar) {
            return new x<>(list, eVar);
        }
    }

    public y(androidx.core.f.e<List<Throwable>> eVar) {
        this(eVar, f4311a);
    }

    synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        a(cls, cls2, vVar, true);
    }

    synchronized List<Class<?>> b(Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f4313c) {
            if (!arrayList.contains(bVar.f4318b) && bVar.a(cls)) {
                arrayList.add(bVar.f4318b);
            }
        }
        return arrayList;
    }

    y(androidx.core.f.e<List<Throwable>> eVar, c cVar) {
        this.f4313c = new ArrayList();
        this.f4315e = new HashSet();
        this.f4316f = eVar;
        this.f4314d = cVar;
    }

    private <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, vVar);
        List<b<?, ?>> list = this.f4313c;
        list.add(z ? list.size() : 0, bVar);
    }

    synchronized <Model> List<u<Model, ?>> a(Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f4313c) {
                if (!this.f4315e.contains(bVar) && bVar.a(cls)) {
                    this.f4315e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f4315e.remove(bVar);
                }
            }
        } finally {
        }
        return arrayList;
    }

    public synchronized <Model, Data> u<Model, Data> a(Class<Model> cls, Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f4313c) {
                if (this.f4315e.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.f4315e.add(bVar);
                    arrayList.add(a(bVar));
                    this.f4315e.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f4314d.a(arrayList, this.f4316f);
            }
            if (arrayList.size() == 1) {
                return (u) arrayList.get(0);
            }
            if (z) {
                return a();
            }
            throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
        } catch (Throwable th) {
            this.f4315e.clear();
            throw th;
        }
    }

    private <Model, Data> u<Model, Data> a(b<?, ?> bVar) {
        Object objBuild = bVar.f4319c.build(this);
        com.bumptech.glide.e.l.a(objBuild);
        return (u) objBuild;
    }

    private static <Model, Data> u<Model, Data> a() {
        return (u<Model, Data>) f4312b;
    }
}
