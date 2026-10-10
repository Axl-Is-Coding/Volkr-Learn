package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdwk<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzhqj = new Object[0];

    zzdwk() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(Object obj);

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(zzhqj);
    }

    int zza(Object[] objArr, int i) {
        zzdxg zzdxgVar = (zzdxg) iterator();
        while (zzdxgVar.hasNext()) {
            objArr[i] = zzdxgVar.next();
            i++;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzaxi, reason: merged with bridge method [inline-methods] */
    public abstract zzdxg<E> iterator();

    Object[] zzaxj() {
        return null;
    }

    int zzaxk() {
        throw new UnsupportedOperationException();
    }

    int zzaxl() {
        throw new UnsupportedOperationException();
    }

    public zzdwp<E> zzaxm() {
        return isEmpty() ? zzdwp.zzaxo() : zzdwp.zzc(toArray());
    }

    abstract boolean zzaxn();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzdwd.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] objArrZzaxj = zzaxj();
            if (objArrZzaxj != null) {
                return (T[]) Arrays.copyOfRange(objArrZzaxj, zzaxk(), zzaxl(), tArr.getClass());
            }
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }
}
