package com.bumptech.glide.load.a;

import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ModelLoaderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final y f4299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f4300b;

    /* JADX INFO: compiled from: ModelLoaderRegistry.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, C0059a<?>> f4301a = new HashMap();

        /* JADX INFO: renamed from: com.bumptech.glide.load.a.w$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ModelLoaderRegistry.java */
        private static class C0059a<Model> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final List<u<Model, ?>> f4302a;

            public C0059a(List<u<Model, ?>> list) {
                this.f4302a = list;
            }
        }

        a() {
        }

        public void a() {
            this.f4301a.clear();
        }

        public <Model> void a(Class<Model> cls, List<u<Model, ?>> list) {
            if (this.f4301a.put(cls, new C0059a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }

        public <Model> List<u<Model, ?>> a(Class<Model> cls) {
            C0059a<?> c0059a = this.f4301a.get(cls);
            if (c0059a == null) {
                return null;
            }
            return (List<u<Model, ?>>) c0059a.f4302a;
        }
    }

    public w(androidx.core.f.e<List<Throwable>> eVar) {
        this(new y(eVar));
    }

    private synchronized <A> List<u<A, ?>> b(Class<A> cls) {
        List<u<A, ?>> listA;
        listA = this.f4300b.a(cls);
        if (listA == null) {
            listA = Collections.unmodifiableList(this.f4299a.a(cls));
            this.f4300b.a(cls, listA);
        }
        return listA;
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, v<? extends Model, ? extends Data> vVar) {
        this.f4299a.a(cls, cls2, vVar);
        this.f4300b.a();
    }

    private w(y yVar) {
        this.f4300b = new a();
        this.f4299a = yVar;
    }

    public <A> List<u<A, ?>> a(A a2) {
        List<u<A, ?>> listB = b((Class) b(a2));
        if (!listB.isEmpty()) {
            int size = listB.size();
            List<u<A, ?>> listEmptyList = Collections.emptyList();
            boolean z = true;
            for (int i = 0; i < size; i++) {
                u<A, ?> uVar = listB.get(i);
                if (uVar.handles(a2)) {
                    if (z) {
                        listEmptyList = new ArrayList<>(size - i);
                        z = false;
                    }
                    listEmptyList.add(uVar);
                }
            }
            if (listEmptyList.isEmpty()) {
                throw new Registry.NoModelLoaderAvailableException(a2, listB);
            }
            return listEmptyList;
        }
        throw new Registry.NoModelLoaderAvailableException(a2);
    }

    private static <A> Class<A> b(A a2) {
        return (Class<A>) a2.getClass();
    }

    public synchronized List<Class<?>> a(Class<?> cls) {
        return this.f4299a.b(cls);
    }
}
