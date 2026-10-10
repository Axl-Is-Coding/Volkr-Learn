package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: IdentityScopeObject.java */
/* JADX INFO: loaded from: classes5.dex */
public class c<K, T> implements a<K, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HashMap<K, Reference<T>> f23637a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantLock f23638b = new ReentrantLock();

    @Override // org.greenrobot.greendao.identityscope.a
    public T a(K k) {
        Reference<T> reference = this.f23637a.get(k);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void a(int i) {
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public boolean b(K k, T t) {
        boolean z;
        this.f23638b.lock();
        try {
            if (get(k) != t || t == null) {
                z = false;
            } else {
                remove(k);
                z = true;
            }
            return z;
        } finally {
            this.f23638b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void clear() {
        this.f23638b.lock();
        try {
            this.f23637a.clear();
        } finally {
            this.f23638b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public T get(K k) {
        this.f23638b.lock();
        try {
            Reference<T> reference = this.f23637a.get(k);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.f23638b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void lock() {
        this.f23638b.lock();
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void put(K k, T t) {
        this.f23638b.lock();
        try {
            this.f23637a.put(k, new WeakReference(t));
        } finally {
            this.f23638b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void remove(K k) {
        this.f23638b.lock();
        try {
            this.f23637a.remove(k);
        } finally {
            this.f23638b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void unlock() {
        this.f23638b.unlock();
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void a(K k, T t) {
        this.f23637a.put(k, new WeakReference(t));
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void a(Iterable<K> iterable) {
        this.f23638b.lock();
        try {
            Iterator<K> it = iterable.iterator();
            while (it.hasNext()) {
                this.f23637a.remove(it.next());
            }
        } finally {
            this.f23638b.unlock();
        }
    }
}
