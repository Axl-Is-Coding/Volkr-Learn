package com.facebook.ads.redexgen.X;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2O, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class C2O<K, V> {
    public static String[] A03;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/2O<TK;TV;>.EntrySet; */
    public C2K A00;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/2O<TK;TV;>.KeySet; */
    public C2L A01;

    /* JADX WARN: Incorrect inner types in field signature: Lcom/facebook/ads/redexgen/X/2O<TK;TV;>.ValuesCollection; */
    public C2N A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"cnftN0nKJ399Diaxmn3tb8gwwrPO2aP4", "GD6Q0W3wC2KuP8ibvS2RtWU8XnqZN0Aj", "FY51T4e3CIDMofRfjaJn97HmoXO", "oFsWTCKeXQMPzJkbzzVFh0WI6lr", "sX7ClejzrEImqIfblQB7OY3eSnYyqYGK", "70PxY4sPYcKp4dj9du2NwnU3Lx25y2ig", "AJxY89BB1aRneGLKwVE9Pufkgncldx4M", "HDwbCIFP6XJ1qJgKvPjZQVX8jvQoDt8b"};
    }

    public abstract int A05();

    public abstract int A06(Object obj);

    public abstract int A07(Object obj);

    public abstract Object A08(int i, int i2);

    public abstract V A09(int i, V v);

    public abstract Map<K, V> A0B();

    public abstract void A0E();

    public abstract void A0F(int i);

    public abstract void A0G(K k, V v);

    public static <K, V> boolean A01(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> boolean A02(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static <K, V> boolean A03(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public static <T> boolean A04(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set<?> s = (Set) obj;
        try {
            if (set.size() == s.size()) {
                if (set.containsAll(s)) {
                    return true;
                }
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        } catch (NullPointerException unused2) {
            return false;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2O != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Collection<V> A0A() {
        if (this.A02 == null) {
            this.A02 = new Collection<V>() { // from class: com.facebook.ads.redexgen.X.2N
                public static String[] A01;

                static {
                    A00();
                }

                public static void A00() {
                    A01 = new String[]{"WaXEENy4Qqf0iZa9rE7K5Tc", "CdcJslr1GuWzD3hgs8KQ2mZhu", "VqX8APEjT5Wjv2WgYqLWWETF9QEoqL89", "1lDdPMX0zjCtSNVsVcyG9UOAfTksMFfY", "Q30AX00aPMLh2Hp2SxjAPSj4hvT3yuLk", "DGZ9hWDjpXQG3w", "JKstht1TU3rAhNk0s2YNIFhF9tCkCvUD", "xnB3F8eRzgUElZJXVWbAPi1tu19rGp71"};
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean add(V v) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean addAll(Collection<? extends V> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final void clear() {
                    this.A00.A0E();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean contains(Object obj) {
                    return this.A00.A07(obj) >= 0;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean containsAll(Collection<?> collection) {
                    Iterator<?> it = collection.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            return false;
                        }
                    }
                    return true;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean isEmpty() {
                    return this.A00.A05() == 0;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection, java.lang.Iterable
                public final Iterator<V> iterator() {
                    return new C2J(this.A00, 1);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean remove(Object obj) {
                    int iA07 = this.A00.A07(obj);
                    if (iA07 >= 0) {
                        this.A00.A0F(iA07);
                        return true;
                    }
                    if (A01[6].charAt(4) == 'M') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[1] = "JaPNh4sPI8rJ5EjhCFrDgKQsA";
                    strArr[5] = "wvLzjGRSTCxgOw";
                    return false;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    int iA05 = this.A00.A05();
                    boolean z = false;
                    int i = 0;
                    while (i < iA05) {
                        if (collection.contains(this.A00.A08(i, 1))) {
                            this.A00.A0F(i);
                            i--;
                            iA05--;
                            z = true;
                        }
                        i++;
                    }
                    return z;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    int iA05 = this.A00.A05();
                    boolean z = false;
                    int i = 0;
                    while (i < iA05) {
                        if (!collection.contains(this.A00.A08(i, 1))) {
                            this.A00.A0F(i);
                            i--;
                            iA05--;
                            z = true;
                        }
                        i++;
                    }
                    return z;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final int size() {
                    return this.A00.A05();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final Object[] toArray() {
                    return this.A00.A0H(1);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$ValuesCollection */
                @Override // java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    return (T[]) this.A00.A0I(tArr, 1);
                }
            };
        }
        return this.A02;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2O != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Set<Map.Entry<K, V>> A0C() {
        if (this.A00 == null) {
            this.A00 = new Set<Map.Entry<K, V>>() { // from class: com.facebook.ads.redexgen.X.2K
                /* JADX INFO: Access modifiers changed from: private */
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
                public final boolean add(Map.Entry<K, V> entry) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
                    int iA05 = this.A00.A05();
                    for (Map.Entry<K, V> entry : collection) {
                        this.A00.A0G(entry.getKey(), entry.getValue());
                    }
                    return iA05 != this.A00.A05();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final void clear() {
                    this.A00.A0E();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean contains(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    int iA06 = this.A00.A06(entry.getKey());
                    if (iA06 < 0) {
                        return false;
                    }
                    return C2H.A04(this.A00.A08(iA06, 1), entry.getValue());
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean containsAll(Collection<?> collection) {
                    Iterator<?> it = collection.iterator();
                    while (it.hasNext()) {
                        if (!contains(it.next())) {
                            return false;
                        }
                    }
                    return true;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean equals(Object obj) {
                    return C2O.A04(this, obj);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final int hashCode() {
                    int i = 0;
                    for (int iA05 = this.A00.A05() - 1; iA05 >= 0; iA05--) {
                        int iHashCode = 0;
                        Object objA08 = this.A00.A08(iA05, 0);
                        Object objA082 = this.A00.A08(iA05, 1);
                        int iHashCode2 = objA08 == null ? 0 : objA08.hashCode();
                        if (objA082 != null) {
                            iHashCode = objA082.hashCode();
                        }
                        i += iHashCode ^ iHashCode2;
                    }
                    return i;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean isEmpty() {
                    return this.A00.A05() == 0;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection, java.lang.Iterable
                public final Iterator<Map.Entry<K, V>> iterator() {
                    return new C2M(this.A00);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean remove(Object obj) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final int size() {
                    return this.A00.A05();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final Object[] toArray() {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2K != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$EntrySet */
                @Override // java.util.Set, java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    throw new UnsupportedOperationException();
                }
            };
        }
        C2K c2k = this.A00;
        if (A03[1].charAt(12) != 'P') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[4] = "9ju5liavVqCXLI9PRLJCuH215nhDnaAN";
        strArr[6] = "X1eenRL1zYDBvWo2ZsNSENOyPnB3gIiL";
        return c2k;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2O != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Set<K> A0D() {
        if (this.A01 == null) {
            this.A01 = new Set<K>() { // from class: com.facebook.ads.redexgen.X.2L
                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean add(K k) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean addAll(Collection<? extends K> collection) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final void clear() {
                    this.A00.A0E();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean contains(Object obj) {
                    return this.A00.A06(obj) >= 0;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean containsAll(Collection<?> collection) {
                    return C2O.A01(this.A00.A0B(), collection);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean equals(Object obj) {
                    return C2O.A04(this, obj);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final int hashCode() {
                    int i = 0;
                    for (int iA05 = this.A00.A05() - 1; iA05 >= 0; iA05--) {
                        int iHashCode = 0;
                        Object obj = this.A00.A08(iA05, 0);
                        if (obj != null) {
                            iHashCode = obj.hashCode();
                        }
                        i += iHashCode;
                    }
                    return i;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean isEmpty() {
                    return this.A00.A05() == 0;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection, java.lang.Iterable
                public final Iterator<K> iterator() {
                    return new C2J(this.A00, 0);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean remove(Object obj) {
                    int iA06 = this.A00.A06(obj);
                    if (iA06 >= 0) {
                        this.A00.A0F(iA06);
                        return true;
                    }
                    return false;
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean removeAll(Collection<?> collection) {
                    return C2O.A02(this.A00.A0B(), collection);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final boolean retainAll(Collection<?> collection) {
                    return C2O.A03(this.A00.A0B(), collection);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final int size() {
                    return this.A00.A05();
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final Object[] toArray() {
                    return this.A00.A0H(0);
                }

                /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2L != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V>$KeySet */
                @Override // java.util.Set, java.util.Collection
                public final <T> T[] toArray(T[] tArr) {
                    return (T[]) this.A00.A0I(tArr, 0);
                }
            };
        }
        return this.A01;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2O != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final Object[] A0H(int i) {
        int i2 = A05();
        Object[] objArr = new Object[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = A08(i3, i);
        }
        return objArr;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2O != com.facebook.ads.internal.androidx.support.v4.util.MapCollections<K, V> */
    public final <T> T[] A0I(T[] tArr, int i) {
        int iA05 = A05();
        if (tArr.length < iA05) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iA05));
        }
        for (int i2 = 0; i2 < iA05; i2++) {
            tArr[i2] = A08(i2, i);
        }
        if (tArr.length > iA05) {
            tArr[iA05] = null;
        }
        return tArr;
    }
}
