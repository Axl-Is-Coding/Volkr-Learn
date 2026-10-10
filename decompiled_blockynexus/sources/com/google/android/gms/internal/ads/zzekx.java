package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzekx extends zzeij<Long> implements zzekh, zzelv, RandomAccess {
    private static final zzekx zzilc;
    private int size;
    private long[] zzild;

    static {
        zzekx zzekxVar = new zzekx(new long[0], 0);
        zzilc = zzekxVar;
        zzekxVar.zzbec();
    }

    zzekx() {
        this(new long[10], 0);
    }

    public static zzekx zzbhn() {
        return zzilc;
    }

    private final void zzfr(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long jLongValue = ((Long) obj).longValue();
        zzbed();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
        long[] jArr = this.zzild;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzild, i, jArr2, i + 1, this.size - i);
            this.zzild = jArr2;
        }
        this.zzild[i] = jLongValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzbed();
        zzekb.checkNotNull(collection);
        if (!(collection instanceof zzekx)) {
            return super.addAll(collection);
        }
        zzekx zzekxVar = (zzekx) collection;
        int i = zzekxVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.zzild;
        if (i3 > jArr.length) {
            this.zzild = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(zzekxVar.zzild, 0, this.zzild, this.size, zzekxVar.size);
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
        if (!(obj instanceof zzekx)) {
            return super.equals(obj);
        }
        zzekx zzekxVar = (zzekx) obj;
        if (this.size != zzekxVar.size) {
            return false;
        }
        long[] jArr = zzekxVar.zzild;
        for (int i = 0; i < this.size; i++) {
            if (this.zzild[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        zzfr(i);
        return this.zzild[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzfr = 1;
        for (int i = 0; i < this.size; i++) {
            iZzfr = (iZzfr * 31) + zzekb.zzfr(this.zzild[i]);
        }
        return iZzfr;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.zzild[i] == jLongValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbed();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzild[i]))) {
                long[] jArr = this.zzild;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
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
        long[] jArr = this.zzild;
        System.arraycopy(jArr, i2, jArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzbed();
        zzfr(i);
        long[] jArr = this.zzild;
        long j = jArr[i];
        jArr[i] = jLongValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    public final void zzfs(long j) {
        zzbed();
        int i = this.size;
        long[] jArr = this.zzild;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzild = jArr2;
        }
        long[] jArr3 = this.zzild;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    /* JADX INFO: renamed from: zzhd, reason: merged with bridge method [inline-methods] */
    public final zzekh zzft(int i) {
        if (i >= this.size) {
            return new zzekx(Arrays.copyOf(this.zzild, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzekx(long[] jArr, int i) {
        this.zzild = jArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbed();
        zzfr(i);
        long[] jArr = this.zzild;
        long j = jArr[i];
        if (i < this.size - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
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
    public final /* synthetic */ boolean add(Object obj) {
        zzfs(((Long) obj).longValue());
        return true;
    }
}
