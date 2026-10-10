package com.google.protobuf;

import com.google.protobuf.r;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: renamed from: com.google.protobuf.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DoubleArrayList.java */
/* JADX INFO: loaded from: classes2.dex */
final class C2303i extends AbstractC2297c<Double> implements r.b, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C2303i f14355b = new C2303i();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double[] f14356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14357d;

    static {
        f14355b.b();
    }

    C2303i() {
        this(new double[10], 0);
    }

    public static C2303i c() {
        return f14355b;
    }

    private void d(int i) {
        if (i < 0 || i >= this.f14357d) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    private String e(int i) {
        return "Index:" + i + ", Size:" + this.f14357d;
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        a();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof C2303i)) {
            return super.addAll(collection);
        }
        C2303i c2303i = (C2303i) collection;
        int i = c2303i.f14357d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f14357d;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.f14356c;
        if (i3 > dArr.length) {
            this.f14356c = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(c2303i.f14356c, 0, this.f14356c, this.f14357d, c2303i.f14357d);
        this.f14357d = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Double set(int i, Double d2) {
        return Double.valueOf(a(i, d2.doubleValue()));
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2303i)) {
            return super.equals(obj);
        }
        C2303i c2303i = (C2303i) obj;
        if (this.f14357d != c2303i.f14357d) {
            return false;
        }
        double[] dArr = c2303i.f14356c;
        for (int i = 0; i < this.f14357d; i++) {
            if (this.f14356c[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iA = 1;
        for (int i = 0; i < this.f14357d; i++) {
            iA = (iA * 31) + r.a(Double.doubleToLongBits(this.f14356c[i]));
        }
        return iA;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f14357d;
    }

    private C2303i(double[] dArr, int i) {
        this.f14356c = dArr;
        this.f14357d = i;
    }

    private void b(int i, double d2) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f14357d)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        double[] dArr = this.f14356c;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f14356c, i, dArr2, i + 1, this.f14357d - i);
            this.f14356c = dArr2;
        }
        this.f14356c[i] = d2;
        this.f14357d++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.r.h
    /* JADX INFO: renamed from: a */
    public r.h<Double> a2(int i) {
        if (i >= this.f14357d) {
            return new C2303i(Arrays.copyOf(this.f14356c, i), this.f14357d);
        }
        throw new IllegalArgumentException();
    }

    public double c(int i) {
        d(i);
        return this.f14356c[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public Double get(int i) {
        return Double.valueOf(c(i));
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f14357d; i++) {
            if (obj.equals(Double.valueOf(this.f14356c[i]))) {
                double[] dArr = this.f14356c;
                System.arraycopy(dArr, i + 1, dArr, i, this.f14357d - i);
                this.f14357d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public double a(int i, double d2) {
        a();
        d(i);
        double[] dArr = this.f14356c;
        double d3 = dArr[i];
        dArr[i] = d2;
        return d3;
    }

    @Override // java.util.AbstractList, java.util.List
    public Double remove(int i) {
        a();
        d(i);
        double[] dArr = this.f14356c;
        double d2 = dArr[i];
        System.arraycopy(dArr, i + 1, dArr, i, this.f14357d - i);
        this.f14357d--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i, Double d2) {
        b(i, d2.doubleValue());
    }
}
