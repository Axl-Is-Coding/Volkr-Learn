package com.bumptech.glide.c;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: EncoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<C0052a<?>> f4119a = new ArrayList();

    /* JADX INFO: renamed from: com.bumptech.glide.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EncoderRegistry.java */
    private static final class C0052a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f4120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final com.bumptech.glide.load.a<T> f4121b;

        C0052a(Class<T> cls, com.bumptech.glide.load.a<T> aVar) {
            this.f4120a = cls;
            this.f4121b = aVar;
        }

        boolean a(Class<?> cls) {
            return this.f4120a.isAssignableFrom(cls);
        }
    }

    public synchronized <T> com.bumptech.glide.load.a<T> a(Class<T> cls) {
        for (C0052a<?> c0052a : this.f4119a) {
            if (c0052a.a(cls)) {
                return (com.bumptech.glide.load.a<T>) c0052a.f4121b;
            }
        }
        return null;
    }

    public synchronized <T> void a(Class<T> cls, com.bumptech.glide.load.a<T> aVar) {
        this.f4119a.add(new C0052a<>(cls, aVar));
    }
}
