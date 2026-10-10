package org.greenrobot.greendao.identityscope;

/* JADX INFO: compiled from: IdentityScope.java */
/* JADX INFO: loaded from: classes5.dex */
public interface a<K, T> {
    T a(K k);

    void a(int i);

    void a(Iterable<K> iterable);

    void a(K k, T t);

    boolean b(K k, T t);

    void clear();

    T get(K k);

    void lock();

    void put(K k, T t);

    void remove(K k);

    void unlock();
}
