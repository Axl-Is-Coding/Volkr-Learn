package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzelx<E> extends zzeij<E> implements RandomAccess {
    private static final zzelx<Object> zzimh;
    private int size;
    private E[] zzhrb;

    static {
        zzelx<Object> zzelxVar = new zzelx<>(new Object[0], 0);
        zzimh = zzelxVar;
        zzelxVar.zzbec();
    }

    zzelx() {
        this(new Object[10], 0);
    }

    public static <E> zzelx<E> zzbib() {
        return (zzelx<E>) zzimh;
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

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e2) {
        zzbed();
        int i = this.size;
        E[] eArr = this.zzhrb;
        if (i == eArr.length) {
            this.zzhrb = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzhrb;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e2;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        zzfr(i);
        return this.zzhrb[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        zzbed();
        zzfr(i);
        E[] eArr = this.zzhrb;
        E e2 = eArr[i];
        if (i < this.size - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (r2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return e2;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final E set(int i, E e2) {
        zzbed();
        zzfr(i);
        E[] eArr = this.zzhrb;
        E e3 = eArr[i];
        eArr[i] = e2;
        ((AbstractList) this).modCount++;
        return e3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final /* synthetic */ zzekk zzft(int i) {
        if (i >= this.size) {
            return new zzelx(Arrays.copyOf(this.zzhrb, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzelx(E[] eArr, int i) {
        this.zzhrb = eArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final void add(int i, E e2) {
        int i2;
        zzbed();
        if (i >= 0 && i <= (i2 = this.size)) {
            E[] eArr = this.zzhrb;
            if (i2 < eArr.length) {
                System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
            } else {
                E[] eArr2 = (E[]) new Object[((i2 * 3) / 2) + 1];
                System.arraycopy(eArr, 0, eArr2, 0, i);
                System.arraycopy(this.zzhrb, i, eArr2, i + 1, this.size - i);
                this.zzhrb = eArr2;
            }
            this.zzhrb[i] = e2;
            this.size++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzfs(i));
    }
}
