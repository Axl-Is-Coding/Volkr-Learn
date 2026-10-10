package com.google.protobuf;

import com.google.protobuf.r;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: LongArrayList.java */
/* JADX INFO: loaded from: classes2.dex */
final class w extends AbstractC2297c<Long> implements r.g, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final w f14388b = new w();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f14389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14390d;

    static {
        f14388b.b();
    }

    w() {
        this(new long[10], 0);
    }

    public static w c() {
        return f14388b;
    }

    private void d(int i) {
        if (i < 0 || i >= this.f14390d) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    private String e(int i) {
        return "Index:" + i + ", Size:" + this.f14390d;
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        a();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof w)) {
            return super.addAll(collection);
        }
        w wVar = (w) collection;
        int i = wVar.f14390d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f14390d;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.f14389c;
        if (i3 > jArr.length) {
            this.f14389c = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(wVar.f14389c, 0, this.f14389c, this.f14390d, wVar.f14390d);
        this.f14390d = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Long set(int i, Long l) {
        return Long.valueOf(a(i, l.longValue()));
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return super.equals(obj);
        }
        w wVar = (w) obj;
        if (this.f14390d != wVar.f14390d) {
            return false;
        }
        long[] jArr = wVar.f14389c;
        for (int i = 0; i < this.f14390d; i++) {
            if (this.f14389c[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.f14390d; i++) {
            iA = (iA * 31) + r.a(this.f14389c[i]);
        }
        return iA;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f14390d;
    }

    private w(long[] jArr, int i) {
        this.f14389c = jArr;
        this.f14390d = i;
    }

    private void b(int i, long j) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f14390d)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        long[] jArr = this.f14389c;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f14389c, i, jArr2, i + 1, this.f14390d - i);
            this.f14389c = jArr2;
        }
        this.f14389c[i] = j;
        this.f14390d++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.r.h
    /* JADX INFO: renamed from: a */
    public r.h<Long> a2(int i) {
        if (i >= this.f14390d) {
            return new w(Arrays.copyOf(this.f14389c, i), this.f14390d);
        }
        throw new IllegalArgumentException();
    }

    public long c(int i) {
        d(i);
        return this.f14389c[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int i) {
        return Long.valueOf(c(i));
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f14390d; i++) {
            if (obj.equals(Long.valueOf(this.f14389c[i]))) {
                long[] jArr = this.f14389c;
                System.arraycopy(jArr, i + 1, jArr, i, this.f14390d - i);
                this.f14390d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public long a(int i, long j) {
        a();
        d(i);
        long[] jArr = this.f14389c;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Long remove(int i) {
        a();
        d(i);
        long[] jArr = this.f14389c;
        long j = jArr[i];
        System.arraycopy(jArr, i + 1, jArr, i, this.f14390d - i);
        this.f14390d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i, Long l) {
        b(i, l.longValue());
    }
}
