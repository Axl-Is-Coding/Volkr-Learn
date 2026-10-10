package com.bumptech.glide.load.a;

import java.util.Queue;

/* JADX INFO: compiled from: ModelCache.java */
/* JADX INFO: loaded from: classes.dex */
public class t<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.e.i<a<A>, B> f4291a;

    public t(long j) {
        this.f4291a = new s(this, j);
    }

    public B a(A a2, int i, int i2) {
        a<A> aVarA = a.a(a2, i, i2);
        B bA = this.f4291a.a(aVarA);
        aVarA.a();
        return bA;
    }

    public void a(A a2, int i, int i2, B b2) {
        this.f4291a.b(a.a(a2, i, i2), b2);
    }

    /* JADX INFO: compiled from: ModelCache.java */
    static final class a<A> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Queue<a<?>> f4292a = com.bumptech.glide.e.n.a(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4293b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4294c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private A f4295d;

        private a() {
        }

        static <A> a<A> a(A a2, int i, int i2) {
            a<A> aVar;
            synchronized (f4292a) {
                aVar = (a) f4292a.poll();
            }
            if (aVar == null) {
                aVar = new a<>();
            }
            aVar.b(a2, i, i2);
            return aVar;
        }

        private void b(A a2, int i, int i2) {
            this.f4295d = a2;
            this.f4294c = i;
            this.f4293b = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4294c == aVar.f4294c && this.f4293b == aVar.f4293b && this.f4295d.equals(aVar.f4295d);
        }

        public int hashCode() {
            return (((this.f4293b * 31) + this.f4294c) * 31) + this.f4295d.hashCode();
        }

        public void a() {
            synchronized (f4292a) {
                f4292a.offer(this);
            }
        }
    }
}
