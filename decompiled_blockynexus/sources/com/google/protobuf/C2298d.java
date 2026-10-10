package com.google.protobuf;

import com.google.protobuf.r;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.protobuf.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BooleanArrayList.java */
/* JADX INFO: loaded from: classes2.dex */
final class C2298d extends AbstractC2297c<Boolean> implements r.a, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C2298d f14343b = new C2298d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean[] f14344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14345d;

    static {
        f14343b.b();
    }

    C2298d() {
        this(new boolean[10], 0);
    }

    public static C2298d c() {
        return f14343b;
    }

    private void d(int i) {
        if (i < 0 || i >= this.f14345d) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    private String e(int i) {
        return "Index:" + i + ", Size:" + this.f14345d;
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        a();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof C2298d)) {
            return super.addAll(collection);
        }
        C2298d c2298d = (C2298d) collection;
        int i = c2298d.f14345d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f14345d;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.f14344c;
        if (i3 > zArr.length) {
            this.f14344c = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(c2298d.f14344c, 0, this.f14344c, this.f14345d, c2298d.f14345d);
        this.f14345d = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i, Boolean bool) {
        return Boolean.valueOf(a(i, bool.booleanValue()));
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2298d)) {
            return super.equals(obj);
        }
        C2298d c2298d = (C2298d) obj;
        if (this.f14345d != c2298d.f14345d) {
            return false;
        }
        boolean[] zArr = c2298d.f14344c;
        for (int i = 0; i < this.f14345d; i++) {
            if (this.f14344c[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.f14345d; i++) {
            iA = (iA * 31) + r.a(this.f14344c[i]);
        }
        return iA;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f14345d;
    }

    private C2298d(boolean[] zArr, int i) {
        this.f14344c = zArr;
        this.f14345d = i;
    }

    private void b(int i, boolean z) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f14345d)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        boolean[] zArr = this.f14344c;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f14344c, i, zArr2, i + 1, this.f14345d - i);
            this.f14344c = zArr2;
        }
        this.f14344c[i] = z;
        this.f14345d++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.r.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public r.h<Boolean> a2(int i) {
        if (i >= this.f14345d) {
            return new C2298d(Arrays.copyOf(this.f14344c, i), this.f14345d);
        }
        throw new IllegalArgumentException();
    }

    public boolean c(int i) {
        d(i);
        return this.f14344c[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean get(int i) {
        return Boolean.valueOf(c(i));
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f14345d; i++) {
            if (obj.equals(Boolean.valueOf(this.f14344c[i]))) {
                boolean[] zArr = this.f14344c;
                System.arraycopy(zArr, i + 1, zArr, i, this.f14345d - i);
                this.f14345d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public boolean a(int i, boolean z) {
        a();
        d(i);
        boolean[] zArr = this.f14344c;
        boolean z2 = zArr[i];
        zArr[i] = z;
        return z2;
    }

    @Override // java.util.AbstractList, java.util.List
    public Boolean remove(int i) {
        a();
        d(i);
        boolean[] zArr = this.f14344c;
        boolean z = zArr[i];
        System.arraycopy(zArr, i + 1, zArr, i, this.f14345d - i);
        this.f14345d--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i, Boolean bool) {
        b(i, bool.booleanValue());
    }
}
