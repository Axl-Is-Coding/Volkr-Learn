package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzejk extends zzeij<Double> implements zzekk<Double>, zzelv, RandomAccess {
    private static final zzejk zzifw;
    private int size;
    private double[] zzifx;

    static {
        zzejk zzejkVar = new zzejk(new double[0], 0);
        zzifw = zzejkVar;
        zzejkVar.zzbec();
    }

    zzejk() {
        this(new double[10], 0);
    }

    private final void zzfr(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
    }

    private final String zzfs(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double dDoubleValue = ((Double) obj).doubleValue();
        zzbed();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
        double[] dArr = this.zzifx;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzifx, i, dArr2, i + 1, this.size - i);
            this.zzifx = dArr2;
        }
        this.zzifx[i] = dDoubleValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzbed();
        zzekb.checkNotNull(collection);
        if (!(collection instanceof zzejk)) {
            return super.addAll(collection);
        }
        zzejk zzejkVar = (zzejk) collection;
        int i = zzejkVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.zzifx;
        if (i3 > dArr.length) {
            this.zzifx = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(zzejkVar.zzifx, 0, this.zzifx, this.size, zzejkVar.size);
        this.size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzejk)) {
            return super.equals(obj);
        }
        zzejk zzejkVar = (zzejk) obj;
        if (this.size != zzejkVar.size) {
            return false;
        }
        double[] dArr = zzejkVar.zzifx;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzifx[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzfr(i);
        return Double.valueOf(this.zzifx[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzfr = 1;
        for (int i = 0; i < this.size; i++) {
            iZzfr = (iZzfr * 31) + zzekb.zzfr(Double.doubleToLongBits(this.zzifx[i]));
        }
        return iZzfr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.zzifx[i] == dDoubleValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbed();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zzifx[i]))) {
                double[] dArr = this.zzifx;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
                this.size--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzbed();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.zzifx;
        System.arraycopy(dArr, i2, dArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        zzbed();
        zzfr(i);
        double[] dArr = this.zzifx;
        double d2 = dArr[i];
        dArr[i] = dDoubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zze(double d2) {
        zzbed();
        int i = this.size;
        double[] dArr = this.zzifx;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zzifx = dArr2;
        }
        double[] dArr3 = this.zzifx;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d2;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final /* synthetic */ zzekk<Double> zzft(int i) {
        if (i >= this.size) {
            return new zzejk(Arrays.copyOf(this.zzifx, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzejk(double[] dArr, int i) {
        this.zzifx = dArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbed();
        zzfr(i);
        double[] dArr = this.zzifx;
        double d2 = dArr[i];
        if (i < this.size - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zze(((Double) obj).doubleValue());
        return true;
    }
}
