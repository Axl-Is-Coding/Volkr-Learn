package io.reactivex.internal.queue;

import io.reactivex.c.a.j;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: SpscLinkedArrayQueue.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a<T> implements j<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f22640a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f22641b = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f22643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f22644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f22645f;
    AtomicReferenceArray<Object> g;
    final int h;
    AtomicReferenceArray<Object> i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicLong f22642c = new AtomicLong();
    final AtomicLong j = new AtomicLong();

    public a(int i) {
        int iA = io.reactivex.internal.util.j.a(Math.max(8, i));
        int i2 = iA - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(iA + 1);
        this.g = atomicReferenceArray;
        this.f22645f = i2;
        a(iA);
        this.i = atomicReferenceArray;
        this.h = i2;
        this.f22644e = i2 - 1;
        b(0L);
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i) {
        a(atomicReferenceArray, i, t);
        b(j + 1);
        return true;
    }

    private static int b(int i) {
        return i;
    }

    private AtomicReferenceArray<Object> b(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        b(i);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) a(atomicReferenceArray, i);
        a(atomicReferenceArray, i, (Object) null);
        return atomicReferenceArray2;
    }

    private long c() {
        return this.j.get();
    }

    private long d() {
        return this.f22642c.get();
    }

    private long e() {
        return this.j.get();
    }

    private long f() {
        return this.f22642c.get();
    }

    @Override // io.reactivex.c.a.k
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.c.a.k
    public boolean isEmpty() {
        return f() == e();
    }

    @Override // io.reactivex.c.a.k
    public boolean offer(T t) {
        if (t == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<Object> atomicReferenceArray = this.g;
        long jD = d();
        int i = this.f22645f;
        int iA = a(jD, i);
        if (jD < this.f22644e) {
            return a(atomicReferenceArray, t, jD, iA);
        }
        long j = ((long) this.f22643d) + jD;
        if (a(atomicReferenceArray, a(j, i)) == null) {
            this.f22644e = j - 1;
            return a(atomicReferenceArray, t, jD, iA);
        }
        if (a(atomicReferenceArray, a(1 + jD, i)) == null) {
            return a(atomicReferenceArray, t, jD, iA);
        }
        a(atomicReferenceArray, jD, iA, t, i);
        return true;
    }

    @Override // io.reactivex.c.a.j, io.reactivex.c.a.k
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.i;
        long jC = c();
        int i = this.h;
        int iA = a(jC, i);
        T t = (T) a(atomicReferenceArray, iA);
        boolean z = t == f22641b;
        if (t == null || z) {
            if (z) {
                return b(b(atomicReferenceArray, i + 1), jC, i);
            }
            return null;
        }
        a(atomicReferenceArray, iA, (Object) null);
        a(jC + 1);
        return t;
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.g = atomicReferenceArray2;
        this.f22644e = (j2 + j) - 1;
        a(atomicReferenceArray2, i, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, i, f22641b);
        b(j + 1);
    }

    private T b(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.i = atomicReferenceArray;
        int iA = a(j, i);
        T t = (T) a(atomicReferenceArray, iA);
        if (t != null) {
            a(atomicReferenceArray, iA, (Object) null);
            a(j + 1);
        }
        return t;
    }

    public int b() {
        long jE = e();
        while (true) {
            long jF = f();
            long jE2 = e();
            if (jE == jE2) {
                return (int) (jF - jE2);
            }
            jE = jE2;
        }
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        int length = atomicReferenceArray.length() - 1;
        b(length);
        a(atomicReferenceArray, length, atomicReferenceArray2);
    }

    private void b(long j) {
        this.f22642c.lazySet(j);
    }

    public T a() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.i;
        long jC = c();
        int i = this.h;
        T t = (T) a(atomicReferenceArray, a(jC, i));
        return t == f22641b ? a(b(atomicReferenceArray, i + 1), jC, i) : t;
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i) {
        this.i = atomicReferenceArray;
        return (T) a(atomicReferenceArray, a(j, i));
    }

    private void a(int i) {
        this.f22643d = Math.min(i / 4, f22640a);
    }

    private void a(long j) {
        this.j.lazySet(j);
    }

    private static int a(long j, int i) {
        int i2 = ((int) j) & i;
        b(i2);
        return i2;
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    private static <E> Object a(AtomicReferenceArray<Object> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public boolean a(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.g;
        long jF = f();
        int i = this.f22645f;
        long j = 2 + jF;
        if (a(atomicReferenceArray, a(j, i)) == null) {
            int iA = a(jF, i);
            a(atomicReferenceArray, iA + 1, t2);
            a(atomicReferenceArray, iA, t);
            b(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.g = atomicReferenceArray2;
        int iA2 = a(jF, i);
        a(atomicReferenceArray2, iA2 + 1, t2);
        a(atomicReferenceArray2, iA2, t);
        a(atomicReferenceArray, atomicReferenceArray2);
        a(atomicReferenceArray, iA2, f22641b);
        b(j);
        return true;
    }
}
