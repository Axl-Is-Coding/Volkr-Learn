package com.bumptech.glide.load.engine;

import com.bumptech.glide.e.a.d;

/* JADX INFO: compiled from: LockedResource.java */
/* JADX INFO: loaded from: classes.dex */
final class B<Z> implements C<Z>, d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final androidx.core.f.e<B<?>> f4409a = com.bumptech.glide.e.a.d.a(20, new A());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.e.a.g f4410b = com.bumptech.glide.e.a.g.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C<Z> f4411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f4413e;

    B() {
    }

    static <Z> B<Z> a(C<Z> c2) {
        B bA = f4409a.a();
        com.bumptech.glide.e.l.a(bA);
        B b2 = bA;
        b2.b(c2);
        return b2;
    }

    private void b(C<Z> c2) {
        this.f4413e = false;
        this.f4412d = true;
        this.f4411c = c2;
    }

    private void d() {
        this.f4411c = null;
        f4409a.a(this);
    }

    synchronized void c() {
        this.f4410b.b();
        if (!this.f4412d) {
            throw new IllegalStateException("Already unlocked");
        }
        this.f4412d = false;
        if (this.f4413e) {
            recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.C
    public Z get() {
        return this.f4411c.get();
    }

    @Override // com.bumptech.glide.load.engine.C
    public int getSize() {
        return this.f4411c.getSize();
    }

    @Override // com.bumptech.glide.load.engine.C
    public synchronized void recycle() {
        this.f4410b.b();
        this.f4413e = true;
        if (!this.f4412d) {
            this.f4411c.recycle();
            d();
        }
    }

    @Override // com.bumptech.glide.load.engine.C
    public Class<Z> a() {
        return this.f4411c.a();
    }

    @Override // com.bumptech.glide.e.a.d.c
    public com.bumptech.glide.e.a.g b() {
        return this.f4410b;
    }
}
