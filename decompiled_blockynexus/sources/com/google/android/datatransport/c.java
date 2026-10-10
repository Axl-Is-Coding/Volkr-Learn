package com.google.android.datatransport;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c<T> {
    public static <T> c<T> a(T t) {
        return new a(null, t, Priority.HIGHEST);
    }

    public abstract Integer a();

    public abstract T b();

    public abstract Priority c();
}
