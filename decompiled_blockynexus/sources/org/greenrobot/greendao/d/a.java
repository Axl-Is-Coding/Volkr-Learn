package org.greenrobot.greendao.d;

import org.greenrobot.greendao.DaoException;

/* JADX INFO: compiled from: AbstractQuery.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final org.greenrobot.greendao.a<T, ?> f23592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final org.greenrobot.greendao.e<T> f23593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final String f23594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final String[] f23595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final Thread f23596e = Thread.currentThread();

    protected a(org.greenrobot.greendao.a<T, ?> aVar, String str, String[] strArr) {
        this.f23592a = aVar;
        this.f23593b = new org.greenrobot.greendao.e<>(aVar);
        this.f23594c = str;
        this.f23595d = strArr;
    }

    protected static String[] a(Object[] objArr) {
        int length = objArr.length;
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            if (obj != null) {
                strArr[i] = obj.toString();
            } else {
                strArr[i] = null;
            }
        }
        return strArr;
    }

    protected void a() {
        if (Thread.currentThread() != this.f23596e) {
            throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
        }
    }
}
