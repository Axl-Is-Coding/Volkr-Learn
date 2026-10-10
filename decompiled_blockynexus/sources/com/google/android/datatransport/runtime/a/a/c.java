package com.google.android.datatransport.runtime.a.a;

/* JADX INFO: compiled from: InstanceFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class c<T> implements b<T>, com.google.android.datatransport.runtime.a.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c<Object> f12800a = new c<>(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T f12801b;

    private c(T t) {
        this.f12801b = t;
    }

    public static <T> b<T> a(T t) {
        d.a(t, "instance cannot be null");
        return new c(t);
    }

    @Override // e.a.a
    public T get() {
        return this.f12801b;
    }
}
