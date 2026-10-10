package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzekc extends zzeij<Integer> implements zzekf, zzelv, RandomAccess {
    private static final zzekc zzika;
    private int size;
    private int[] zzikb;

    static {
        zzekc zzekcVar = new zzekc(new int[0], 0);
        zzika = zzekcVar;
        zzekcVar.zzbec();
    }

    zzekc() {
        this(new int[10], 0);
    }

    public static zzekc zzbgw() {
        return zzika;
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
        int iIntValue = ((Integer) obj).intValue();
        zzbed();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
        int[] iArr = this.zzikb;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzikb, i, iArr2, i + 1, this.size - i);
            this.zzikb = iArr2;
        }
        this.zzikb[i] = iIntValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbed();
        zzekb.checkNotNull(collection);
        if (!(collection instanceof zzekc)) {
            return super.addAll(collection);
        }
        zzekc zzekcVar = (zzekc) collection;
        int i = zzekcVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.zzikb;
        if (i3 > iArr.length) {
            this.zzikb = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(zzekcVar.zzikb, 0, this.zzikb, this.size, zzekcVar.size);
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
        if (!(obj instanceof zzekc)) {
            return super.equals(obj);
        }
        zzekc zzekcVar = (zzekc) obj;
        if (this.size != zzekcVar.size) {
            return false;
        }
        int[] iArr = zzekcVar.zzikb;
        for (int i = 0; i < this.size; i++) {
            if (this.zzikb[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzfr(i);
        return this.zzikb[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzikb[i2];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.zzikb[i] == iIntValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbed();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzikb[i]))) {
                int[] iArr = this.zzikb;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
        int[] iArr = this.zzikb;
        System.arraycopy(iArr, i2, iArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zzbed();
        zzfr(i);
        int[] iArr = this.zzikb;
        int i2 = iArr[i];
        iArr[i] = iIntValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    /* JADX INFO: renamed from: zzhb, reason: merged with bridge method [inline-methods] */
    public final zzekf zzft(int i) {
        if (i >= this.size) {
            return new zzekc(Arrays.copyOf(this.zzikb, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzekf
    public final void zzhc(int i) {
        zzbed();
        int i2 = this.size;
        int[] iArr = this.zzikb;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzikb = iArr2;
        }
        int[] iArr3 = this.zzikb;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    private zzekc(int[] iArr, int i) {
        this.zzikb = iArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbed();
        zzfr(i);
        int[] iArr = this.zzikb;
        int i2 = iArr[i];
        if (i < this.size - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        zzhc(((Integer) obj).intValue());
        return true;
    }
}
