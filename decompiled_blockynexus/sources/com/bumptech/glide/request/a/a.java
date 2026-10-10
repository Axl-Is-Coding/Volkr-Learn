package com.bumptech.glide.request.a;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.a.b;

/* JADX INFO: compiled from: NoTransition.java */
/* JADX INFO: loaded from: classes.dex */
public class a<R> implements b<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final a<?> f4787a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c<?> f4788b = new C0064a();

    /* JADX INFO: renamed from: com.bumptech.glide.request.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: NoTransition.java */
    public static class C0064a<R> implements c<R> {
        @Override // com.bumptech.glide.request.a.c
        public b<R> a(DataSource dataSource, boolean z) {
            return a.f4787a;
        }
    }

    public static <R> c<R> a() {
        return (c<R>) f4788b;
    }

    @Override // com.bumptech.glide.request.a.b
    public boolean a(Object obj, b.a aVar) {
        return false;
    }
}
