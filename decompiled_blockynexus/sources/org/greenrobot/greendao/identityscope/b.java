package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: IdentityScopeLong.java */
/* JADX INFO: loaded from: classes5.dex */
public class b<T> implements a<Long, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.greenrobot.greendao.c.c<Reference<T>> f23635a = new org.greenrobot.greendao.c.c<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantLock f23636b = new ReentrantLock();

    @Override // org.greenrobot.greendao.identityscope.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(Long l, T t) {
        b(l.longValue(), t);
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void clear() {
        this.f23636b.lock();
        try {
            this.f23635a.a();
        } finally {
            this.f23636b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void lock() {
        this.f23636b.lock();
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void unlock() {
        this.f23636b.unlock();
    }

    @Override // org.greenrobot.greendao.identityscope.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T a(Long l) {
        return b(l.longValue());
    }

    @Override // org.greenrobot.greendao.identityscope.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void remove(Long l) {
        this.f23636b.lock();
        try {
            this.f23635a.b(l.longValue());
        } finally {
            this.f23636b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public T get(Long l) {
        return a(l.longValue());
    }

    public T b(long j) {
        Reference<T> referenceA = this.f23635a.a(j);
        if (referenceA != null) {
            return referenceA.get();
        }
        return null;
    }

    public T a(long j) {
        this.f23636b.lock();
        try {
            Reference<T> referenceA = this.f23635a.a(j);
            if (referenceA != null) {
                return referenceA.get();
            }
            return null;
        } finally {
            this.f23636b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    /* JADX INFO: renamed from: b, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void put(Long l, T t) {
        a(l.longValue(), t);
    }

    public void b(long j, T t) {
        this.f23635a.a(j, new WeakReference(t));
    }

    public void a(long j, T t) {
        this.f23636b.lock();
        try {
            this.f23635a.a(j, new WeakReference(t));
        } finally {
            this.f23636b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean b(Long l, T t) {
        boolean z;
        this.f23636b.lock();
        try {
            if (get(l) != t || t == null) {
                z = false;
            } else {
                remove(l);
                z = true;
            }
            return z;
        } finally {
            this.f23636b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void a(Iterable<Long> iterable) {
        this.f23636b.lock();
        try {
            Iterator<Long> it = iterable.iterator();
            while (it.hasNext()) {
                this.f23635a.b(it.next().longValue());
            }
        } finally {
            this.f23636b.unlock();
        }
    }

    @Override // org.greenrobot.greendao.identityscope.a
    public void a(int i) {
        this.f23635a.a(i);
    }
}
