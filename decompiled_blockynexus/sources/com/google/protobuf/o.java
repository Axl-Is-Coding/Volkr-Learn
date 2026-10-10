package com.google.protobuf;

import com.google.protobuf.r;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: FloatArrayList.java */
/* JADX INFO: loaded from: classes2.dex */
final class o extends AbstractC2297c<Float> implements r.e, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final o f14368b = new o();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float[] f14369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f14370d;

    static {
        f14368b.b();
    }

    o() {
        this(new float[10], 0);
    }

    public static o c() {
        return f14368b;
    }

    private void d(int i) {
        if (i < 0 || i >= this.f14370d) {
            throw new IndexOutOfBoundsException(e(i));
        }
    }

    private String e(int i) {
        return "Index:" + i + ", Size:" + this.f14370d;
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        a();
        if (collection == null) {
            throw new NullPointerException();
        }
        if (!(collection instanceof o)) {
            return super.addAll(collection);
        }
        o oVar = (o) collection;
        int i = oVar.f14370d;
        if (i == 0) {
            return false;
        }
        int i2 = this.f14370d;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.f14369c;
        if (i3 > fArr.length) {
            this.f14369c = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(oVar.f14369c, 0, this.f14369c, this.f14370d, oVar.f14370d);
        this.f14370d = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Float set(int i, Float f2) {
        return Float.valueOf(a(i, f2.floatValue()));
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return super.equals(obj);
        }
        o oVar = (o) obj;
        if (this.f14370d != oVar.f14370d) {
            return false;
        }
        float[] fArr = oVar.f14369c;
        for (int i = 0; i < this.f14370d; i++) {
            if (this.f14369c[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iFloatToIntBits = 1;
        for (int i = 0; i < this.f14370d; i++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f14369c[i]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f14370d;
    }

    private o(float[] fArr, int i) {
        this.f14369c = fArr;
        this.f14370d = i;
    }

    private void b(int i, float f2) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.f14370d)) {
            throw new IndexOutOfBoundsException(e(i));
        }
        float[] fArr = this.f14369c;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f14369c, i, fArr2, i + 1, this.f14370d - i);
            this.f14369c = fArr2;
        }
        this.f14369c[i] = f2;
        this.f14370d++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.protobuf.r.h
    /* JADX INFO: renamed from: a */
    public r.h<Float> a2(int i) {
        if (i >= this.f14370d) {
            return new o(Arrays.copyOf(this.f14369c, i), this.f14370d);
        }
        throw new IllegalArgumentException();
    }

    public float c(int i) {
        d(i);
        return this.f14369c[i];
    }

    @Override // java.util.AbstractList, java.util.List
    public Float get(int i) {
        return Float.valueOf(c(i));
    }

    @Override // com.google.protobuf.AbstractC2297c, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f14370d; i++) {
            if (obj.equals(Float.valueOf(this.f14369c[i]))) {
                float[] fArr = this.f14369c;
                System.arraycopy(fArr, i + 1, fArr, i, this.f14370d - i);
                this.f14370d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    public float a(int i, float f2) {
        a();
        d(i);
        float[] fArr = this.f14369c;
        float f3 = fArr[i];
        fArr[i] = f2;
        return f3;
    }

    @Override // java.util.AbstractList, java.util.List
    public Float remove(int i) {
        a();
        d(i);
        float[] fArr = this.f14369c;
        float f2 = fArr[i];
        System.arraycopy(fArr, i + 1, fArr, i, this.f14370d - i);
        this.f14370d--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void add(int i, Float f2) {
        b(i, f2.floatValue());
    }
}
