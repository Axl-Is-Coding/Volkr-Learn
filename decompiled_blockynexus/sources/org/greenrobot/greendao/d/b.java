package org.greenrobot.greendao.d;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.greenrobot.greendao.d.a;

/* JADX INFO: compiled from: AbstractQueryData.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class b<T, Q extends a<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f23597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final org.greenrobot.greendao.a<T, ?> f23598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String[] f23599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Map<Long, WeakReference<Q>> f23600d = new HashMap();

    b(org.greenrobot.greendao.a<T, ?> aVar, String str, String[] strArr) {
        this.f23598b = aVar;
        this.f23597a = str;
        this.f23599c = strArr;
    }

    protected abstract Q a();

    Q a(Q q) {
        if (Thread.currentThread() != q.f23596e) {
            return (Q) b();
        }
        String[] strArr = this.f23599c;
        System.arraycopy(strArr, 0, q.f23595d, 0, strArr.length);
        return q;
    }

    Q b() {
        Q q;
        long id = Thread.currentThread().getId();
        synchronized (this.f23600d) {
            WeakReference<Q> weakReference = this.f23600d.get(Long.valueOf(id));
            q = weakReference != null ? weakReference.get() : null;
            if (q == null) {
                c();
                q = (Q) a();
                this.f23600d.put(Long.valueOf(id), new WeakReference<>(q));
            } else {
                System.arraycopy(this.f23599c, 0, q.f23595d, 0, this.f23599c.length);
            }
        }
        return q;
    }

    void c() {
        synchronized (this.f23600d) {
            Iterator<Map.Entry<Long, WeakReference<Q>>> it = this.f23600d.entrySet().iterator();
            while (it.hasNext()) {
                if (it.next().getValue().get() == null) {
                    it.remove();
                }
            }
        }
    }
}
