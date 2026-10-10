package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdwp<E> extends zzdwk<E> implements List<E>, RandomAccess {
    private static final zzdxj<Object> zzhqm = new zzdwr(zzdwz.zzhra, 0);

    zzdwp() {
    }

    public static <E> zzdwp<E> zzac(E e2) {
        Object[] objArr = {e2};
        for (int i = 0; i <= 0; i++) {
            zzdww.zzd(objArr[0], 0);
        }
        return zzb(objArr, 1);
    }

    public static <E> zzdwp<E> zzaxo() {
        return (zzdwp<E>) zzdwz.zzhra;
    }

    public static <E> zzdwp<E> zzb(Collection<? extends E> collection) {
        if (collection instanceof zzdwk) {
            zzdwp<E> zzdwpVarZzaxm = ((zzdwk) collection).zzaxm();
            if (!zzdwpVarZzaxm.zzaxn()) {
                return zzdwpVarZzaxm;
            }
            Object[] array = zzdwpVarZzaxm.toArray();
            return zzb(array, array.length);
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            zzdww.zzd(array2[i], i);
        }
        return zzb(array2, array2.length);
    }

    static <E> zzdwp<E> zzc(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    public static <E> zzdwp<E> zzh(Iterable<? extends E> iterable) {
        zzdwd.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return zzb((Collection) iterable);
        }
        Iterator<? extends E> it = iterable.iterator();
        if (!it.hasNext()) {
            return (zzdwp<E>) zzdwz.zzhra;
        }
        E next = it.next();
        if (!it.hasNext()) {
            return zzac(next);
        }
        zzdwo zzdwoVar = (zzdwo) ((zzdwo) new zzdwo().zzaa(next)).zza(it);
        zzdwoVar.zzhql = true;
        return zzb(zzdwoVar.zzhqk, zzdwoVar.size);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        zzdwd.checkNotNull(this);
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i = 0; i < size; i++) {
                        if (zzdvx.equal(get(i), list.get(i))) {
                        }
                    }
                    return true;
                }
                int size2 = size();
                Iterator<E> it = list.iterator();
                int i2 = 0;
                while (true) {
                    if (i2 < size2) {
                        if (!it.hasNext()) {
                            break;
                        }
                        E e2 = get(i2);
                        i2++;
                        if (!zzdvx.equal(e2, it.next())) {
                            break;
                        }
                    } else if (!it.hasNext()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (((iHashCode * 31) + get(i).hashCode()) ^ (-1)) ^ (-1);
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        int i = 0;
        if (obj == null) {
            while (i < size) {
                if (get(i) == null) {
                    return i;
                }
                i++;
            }
        } else {
            while (i < size) {
                if (obj.equals(get(i))) {
                    return i;
                }
                i++;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj == null) {
            for (int size = size() - 1; size >= 0; size--) {
                if (get(size) == null) {
                    return size;
                }
            }
        } else {
            for (int size2 = size() - 1; size2 >= 0; size2--) {
                if (obj.equals(get(size2))) {
                    return size2;
                }
            }
        }
        return -1;
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzdwd.zzt(i, size());
        return isEmpty() ? zzhqm : new zzdwr(this, i);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzaxi */
    public final zzdxg<E> iterator() {
        return (zzdxj) listIterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    public final zzdwp<E> zzaxm() {
        return this;
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: zzu, reason: merged with bridge method [inline-methods] */
    public zzdwp<E> subList(int i, int i2) {
        zzdwd.zzf(i, i2, size());
        int i3 = i2 - i;
        return i3 == size() ? this : i3 == 0 ? (zzdwp<E>) zzdwz.zzhra : new zzdwq(this, i, i3);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzdxj) listIterator(0);
    }

    public static <E> zzdwp<E> zzb(E[] eArr) {
        if (eArr.length == 0) {
            return (zzdwp<E>) zzdwz.zzhra;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            zzdww.zzd(objArr[i], i);
        }
        return zzb(objArr, objArr.length);
    }

    static <E> zzdwp<E> zzb(Object[] objArr, int i) {
        if (i == 0) {
            return (zzdwp<E>) zzdwz.zzhra;
        }
        return new zzdwz(objArr, i);
    }
}
