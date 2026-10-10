package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzein extends zzeij<Boolean> implements zzekk<Boolean>, zzelv, RandomAccess {
    private static final zzein zzieo;
    private int size;
    private boolean[] zziep;

    static {
        zzein zzeinVar = new zzein(new boolean[0], 0);
        zzieo = zzeinVar;
        zzeinVar.zzbec();
    }

    zzein() {
        this(new boolean[10], 0);
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
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzbed();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfs(i));
        }
        boolean[] zArr = this.zziep;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zziep, i, zArr2, i + 1, this.size - i);
            this.zziep = zArr2;
        }
        this.zziep[i] = zBooleanValue;
        this.size++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbed();
        zzekb.checkNotNull(collection);
        if (!(collection instanceof zzein)) {
            return super.addAll(collection);
        }
        zzein zzeinVar = (zzein) collection;
        int i = zzeinVar.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.zziep;
        if (i3 > zArr.length) {
            this.zziep = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(zzeinVar.zziep, 0, this.zziep, this.size, zzeinVar.size);
        this.size = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void addBoolean(boolean z) {
        zzbed();
        int i = this.size;
        boolean[] zArr = this.zziep;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zziep = zArr2;
        }
        boolean[] zArr3 = this.zziep;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
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
        if (!(obj instanceof zzein)) {
            return super.equals(obj);
        }
        zzein zzeinVar = (zzein) obj;
        if (this.size != zzeinVar.size) {
            return false;
        }
        boolean[] zArr = zzeinVar.zziep;
        for (int i = 0; i < this.size; i++) {
            if (this.zziep[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzfr(i);
        return Boolean.valueOf(this.zziep[i]);
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzbu = 1;
        for (int i = 0; i < this.size; i++) {
            iZzbu = (iZzbu * 31) + zzekb.zzbu(this.zziep[i]);
        }
        return iZzbu;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.zziep[i] == zBooleanValue) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzbed();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zziep[i]))) {
                boolean[] zArr = this.zziep;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
        boolean[] zArr = this.zziep;
        System.arraycopy(zArr, i2, zArr, i, this.size - i2);
        this.size -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        zzbed();
        zzfr(i);
        boolean[] zArr = this.zziep;
        boolean z = zArr[i];
        zArr[i] = zBooleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final /* synthetic */ zzekk<Boolean> zzft(int i) {
        if (i >= this.size) {
            return new zzein(Arrays.copyOf(this.zziep, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    private zzein(boolean[] zArr, int i) {
        this.zziep = zArr;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbed();
        zzfr(i);
        boolean[] zArr = this.zziep;
        boolean z = zArr[i];
        if (i < this.size - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.size--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        addBoolean(((Boolean) obj).booleanValue());
        return true;
    }
}
