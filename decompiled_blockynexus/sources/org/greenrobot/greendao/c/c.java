package org.greenrobot.greendao.c;

import java.util.Arrays;

/* JADX INFO: compiled from: LongHashMap.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a<T>[] f23578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f23580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23581d;

    /* JADX INFO: compiled from: LongHashMap.java */
    static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f23582a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        T f23583b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a<T> f23584c;

        a(long j, T t, a<T> aVar) {
            this.f23582a = j;
            this.f23583b = t;
            this.f23584c = aVar;
        }
    }

    public c() {
        this(16);
    }

    public T a(long j) {
        for (a<T> aVar = this.f23578a[((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f23579b]; aVar != null; aVar = aVar.f23584c) {
            if (aVar.f23582a == j) {
                return aVar.f23583b;
            }
        }
        return null;
    }

    public T b(long j) {
        int i = ((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f23579b;
        a<T> aVar = this.f23578a[i];
        a<T> aVar2 = null;
        while (aVar != null) {
            a<T> aVar3 = aVar.f23584c;
            if (aVar.f23582a == j) {
                if (aVar2 == null) {
                    this.f23578a[i] = aVar3;
                } else {
                    aVar2.f23584c = aVar3;
                }
                this.f23581d--;
                return aVar.f23583b;
            }
            aVar2 = aVar;
            aVar = aVar3;
        }
        return null;
    }

    public c(int i) {
        this.f23579b = i;
        this.f23580c = (i * 4) / 3;
        this.f23578a = new a[i];
    }

    public T a(long j, T t) {
        int i = ((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % this.f23579b;
        a<T> aVar = this.f23578a[i];
        for (a<T> aVar2 = aVar; aVar2 != null; aVar2 = aVar2.f23584c) {
            if (aVar2.f23582a == j) {
                T t2 = aVar2.f23583b;
                aVar2.f23583b = t;
                return t2;
            }
        }
        this.f23578a[i] = new a<>(j, t, aVar);
        this.f23581d++;
        if (this.f23581d <= this.f23580c) {
            return null;
        }
        b(this.f23579b * 2);
        return null;
    }

    public void b(int i) {
        a<T>[] aVarArr = new a[i];
        int length = this.f23578a.length;
        for (int i2 = 0; i2 < length; i2++) {
            a<T> aVar = this.f23578a[i2];
            while (aVar != null) {
                long j = aVar.f23582a;
                int i3 = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % i;
                a<T> aVar2 = aVar.f23584c;
                aVar.f23584c = aVarArr[i3];
                aVarArr[i3] = aVar;
                aVar = aVar2;
            }
        }
        this.f23578a = aVarArr;
        this.f23579b = i;
        this.f23580c = (i * 4) / 3;
    }

    public void a() {
        this.f23581d = 0;
        Arrays.fill(this.f23578a, (Object) null);
    }

    public void a(int i) {
        b((i * 5) / 3);
    }
}
