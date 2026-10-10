package com.bumptech.glide.e.a;

import android.util.Log;
import java.util.List;

/* JADX INFO: compiled from: FactoryPools.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final InterfaceC0054d<Object> f4154a = new com.bumptech.glide.e.a.a();

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface a<T> {
        T create();
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    public interface c {
        g b();
    }

    /* JADX INFO: renamed from: com.bumptech.glide.e.a.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FactoryPools.java */
    public interface InterfaceC0054d<T> {
        void a(T t);
    }

    public static <T extends c> androidx.core.f.e<T> a(int i, a<T> aVar) {
        return a(new androidx.core.f.g(i), aVar);
    }

    private static <T> InterfaceC0054d<T> b() {
        return (InterfaceC0054d<T>) f4154a;
    }

    public static <T> androidx.core.f.e<List<T>> a() {
        return a(20);
    }

    public static <T> androidx.core.f.e<List<T>> a(int i) {
        return a(new androidx.core.f.g(i), new com.bumptech.glide.e.a.b(), new com.bumptech.glide.e.a.c());
    }

    private static <T extends c> androidx.core.f.e<T> a(androidx.core.f.e<T> eVar, a<T> aVar) {
        return a(eVar, aVar, b());
    }

    private static <T> androidx.core.f.e<T> a(androidx.core.f.e<T> eVar, a<T> aVar, InterfaceC0054d<T> interfaceC0054d) {
        return new b(eVar, aVar, interfaceC0054d);
    }

    /* JADX INFO: compiled from: FactoryPools.java */
    private static final class b<T> implements androidx.core.f.e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a<T> f4155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0054d<T> f4156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final androidx.core.f.e<T> f4157c;

        b(androidx.core.f.e<T> eVar, a<T> aVar, InterfaceC0054d<T> interfaceC0054d) {
            this.f4157c = eVar;
            this.f4155a = aVar;
            this.f4156b = interfaceC0054d;
        }

        @Override // androidx.core.f.e
        public T a() {
            T tA = this.f4157c.a();
            if (tA == null) {
                tA = this.f4155a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + tA.getClass());
                }
            }
            if (tA instanceof c) {
                ((c) tA).b().a(false);
            }
            return tA;
        }

        @Override // androidx.core.f.e
        public boolean a(T t) {
            if (t instanceof c) {
                ((c) t).b().a(true);
            }
            this.f4156b.a(t);
            return this.f4157c.a(t);
        }
    }
}
