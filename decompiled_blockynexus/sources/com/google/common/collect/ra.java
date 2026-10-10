package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: ObjectArrays.java */
/* JADX INFO: loaded from: classes2.dex */
public final class ra {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Object[] f13964a = new Object[0];

    static <T> T[] a(T[] tArr, int i) {
        T[] tArr2 = (T[]) c(tArr, i);
        System.arraycopy(tArr, 0, tArr2, 0, Math.min(tArr.length, i));
        return tArr2;
    }

    static Object[] b(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            a(objArr[i2], i2);
        }
        return objArr;
    }

    public static <T> T[] c(T[] tArr, int i) {
        return (T[]) ua.a(tArr, i);
    }

    static <T> T[] a(Collection<?> collection, T[] tArr) {
        int size = collection.size();
        if (tArr.length < size) {
            tArr = (T[]) c(tArr, size);
        }
        a((Iterable<?>) collection, (Object[]) tArr);
        if (tArr.length > size) {
            tArr[size] = null;
        }
        return tArr;
    }

    private static Object[] a(Iterable<?> iterable, Object[] objArr) {
        Iterator<?> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
        return objArr;
    }

    static void a(Object[] objArr, int i, int i2) {
        Object obj = objArr[i];
        objArr[i] = objArr[i2];
        objArr[i2] = obj;
    }

    static Object[] a(Object... objArr) {
        b(objArr, objArr.length);
        return objArr;
    }

    static Object a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }
}
