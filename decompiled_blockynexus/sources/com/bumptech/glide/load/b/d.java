package com.bumptech.glide.load.b;

import com.bumptech.glide.e.l;
import com.bumptech.glide.load.engine.C;

/* JADX INFO: compiled from: SimpleResource.java */
/* JADX INFO: loaded from: classes.dex */
public class d<T> implements C<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final T f4340a;

    public d(T t) {
        l.a(t);
        this.f4340a = t;
    }

    @Override // com.bumptech.glide.load.engine.C
    public Class<T> a() {
        return (Class<T>) this.f4340a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.C
    public final T get() {
        return this.f4340a;
    }

    @Override // com.bumptech.glide.load.engine.C
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.C
    public void recycle() {
    }
}
