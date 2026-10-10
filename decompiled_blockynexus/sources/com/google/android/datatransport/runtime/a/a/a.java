package com.google.android.datatransport.runtime.a.a;

/* JADX INFO: compiled from: DoubleCheck.java */
/* JADX INFO: loaded from: classes.dex */
public final class a<T> implements e.a.a<T>, com.google.android.datatransport.runtime.a.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f12797a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile e.a.a<T> f12798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile Object f12799c = f12797a;

    private a(e.a.a<T> aVar) {
        this.f12798b = aVar;
    }

    public static Object a(Object obj, Object obj2) {
        if (!(obj != f12797a) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // e.a.a
    public T get() {
        T t = (T) this.f12799c;
        if (t == f12797a) {
            synchronized (this) {
                t = (T) this.f12799c;
                if (t == f12797a) {
                    t = this.f12798b.get();
                    a(this.f12799c, t);
                    this.f12799c = t;
                    this.f12798b = null;
                }
            }
        }
        return t;
    }

    public static <P extends e.a.a<T>, T> e.a.a<T> a(P p) {
        d.a(p);
        return p instanceof a ? p : new a(p);
    }
}
