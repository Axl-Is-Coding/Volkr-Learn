package com.bumptech.glide.c;

import com.bumptech.glide.load.n;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ResourceEncoderRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<a<?>> f4133a = new ArrayList();

    /* JADX INFO: compiled from: ResourceEncoderRegistry.java */
    private static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<T> f4134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final n<T> f4135b;

        a(Class<T> cls, n<T> nVar) {
            this.f4134a = cls;
            this.f4135b = nVar;
        }

        boolean a(Class<?> cls) {
            return this.f4134a.isAssignableFrom(cls);
        }
    }

    public synchronized <Z> void a(Class<Z> cls, n<Z> nVar) {
        this.f4133a.add(new a<>(cls, nVar));
    }

    public synchronized <Z> n<Z> a(Class<Z> cls) {
        int size = this.f4133a.size();
        for (int i = 0; i < size; i++) {
            a<?> aVar = this.f4133a.get(i);
            if (aVar.a(cls)) {
                return (n<Z>) aVar.f4135b;
            }
        }
        return null;
    }
}
