package com.google.protobuf;

import com.google.protobuf.r;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: IntArrayList.java */
/* JADX INFO: loaded from: classes2.dex */
final class q extends AbstractC2297c<Integer> implements r.f, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final q f14372b = new q();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int[] f14373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14374d;

    static {
        f14372b.b();
    }

    q() {
        this(new int[10], 0);
    }

    public static q c() {
        return f14372b;
    }

    private String d(int i) {
        return "Index:" + i + ", Size:" + this.f14374d;
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        a();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof q)) {
            return super.addAll(collection);
        }
        q qVar = (q) collection;
        int i = qVar.f14374d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f14374d;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.f14373c;
        if (i3 > iArr.length) {
            this.f14373c = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(qVar.f14373c, 0, this.f14373c, this.f14374d, qVar.f14374d);
        this.f14374d = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer set(int i, Integer num) {
        return Integer.valueOf(setInt(i, num.intValue()));
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return super.equals(obj);
        }
        q qVar = (q) obj;
        if (this.f14374d != qVar.f14374d) {
            return false;
        }
        int[] iArr = qVar.f14373c;
        for (int i = 0; i < this.f14374d; i++) {
            if (this.f14373c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.r.f
    public int getInt(int i) {
        c(i);
        return this.f14373c[i];
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f14374d; i2++) {
            i = (i * 31) + this.f14373c[i2];
        }
        return i;
    }

    @Override // com.google.protobuf.r.f
    public int setInt(int i, int i2) {
        a();
        c(i);
        int[] iArr = this.f14373c;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f14374d;
    }

    private q(int[] iArr, int i) {
        this.f14373c = iArr;
        this.f14374d = i;
    }

    private void c(int i) {
        if (i < 0 || i >= this.f14374d) {
            throw new IndexOutOfBoundsException(d(i));
        }
    }

    @Override // com.google.protobuf.r.h
    /* JADX INFO: renamed from: a */
    public r.h<Integer> a2(int i) {
        if (i >= this.f14374d) {
            return new q(Arrays.copyOf(this.f14373c, i), this.f14374d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.r.f
    public void b(int i) {
        a(this.f14374d, i);
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int i) {
        return Integer.valueOf(getInt(i));
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f14374d; i++) {
            if (obj.equals(Integer.valueOf(this.f14373c[i]))) {
                int[] iArr = this.f14373c;
                System.arraycopy(iArr, i + 1, iArr, i, this.f14374d - i);
                this.f14374d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i, Integer num) {
        a(i, num.intValue());
    }

    private void a(int i, int i2) {
        int i3;
        a();
        if (i >= 0 && i <= (i3 = this.f14374d)) {
            int[] iArr = this.f14373c;
            if (i3 < iArr.length) {
                System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
            } else {
                int[] iArr2 = new int[((i3 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                System.arraycopy(this.f14373c, i, iArr2, i + 1, this.f14374d - i);
                this.f14373c = iArr2;
            }
            this.f14373c[i] = i2;
            this.f14374d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(d(i));
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer remove(int i) {
        a();
        c(i);
        int[] iArr = this.f14373c;
        int i2 = iArr[i];
        System.arraycopy(iArr, i + 1, iArr, i, this.f14374d - i);
        this.f14374d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }
}
