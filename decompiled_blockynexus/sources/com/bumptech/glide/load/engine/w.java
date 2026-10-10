package com.bumptech.glide.load.engine;

/* JADX INFO: compiled from: EngineResource.java */
/* JADX INFO: loaded from: classes.dex */
class w<Z> implements C<Z> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f4615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final C<Z> f4616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f4617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.h f4618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4619f;
    private boolean g;

    /* JADX INFO: compiled from: EngineResource.java */
    interface a {
        void a(com.bumptech.glide.load.h hVar, w<?> wVar);
    }

    w(C<Z> c2, boolean z, boolean z2, com.bumptech.glide.load.h hVar, a aVar) {
        com.bumptech.glide.e.l.a(c2);
        this.f4616c = c2;
        this.f4614a = z;
        this.f4615b = z2;
        this.f4618e = hVar;
        com.bumptech.glide.e.l.a(aVar);
        this.f4617d = aVar;
    }

    @Override // com.bumptech.glide.load.engine.C
    public Class<Z> a() {
        return this.f4616c.a();
    }

    synchronized void b() {
        if (this.g) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.f4619f++;
    }

    C<Z> c() {
        return this.f4616c;
    }

    boolean d() {
        return this.f4614a;
    }

    void e() {
        boolean z;
        synchronized (this) {
            if (this.f4619f <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i = this.f4619f - 1;
            this.f4619f = i;
            if (i != 0) {
                z = false;
            }
        }
        if (z) {
            this.f4617d.a(this.f4618e, this);
        }
    }

    @Override // com.bumptech.glide.load.engine.C
    public Z get() {
        return this.f4616c.get();
    }

    @Override // com.bumptech.glide.load.engine.C
    public int getSize() {
        return this.f4616c.getSize();
    }

    @Override // com.bumptech.glide.load.engine.C
    public synchronized void recycle() {
        if (this.f4619f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.g) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.g = true;
        if (this.f4615b) {
            this.f4616c.recycle();
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f4614a + ", listener=" + this.f4617d + ", key=" + this.f4618e + ", acquired=" + this.f4619f + ", isRecycled=" + this.g + ", resource=" + this.f4616c + '}';
    }
}
