package com.bumptech.glide.load.engine.a;

import com.bumptech.glide.load.engine.a.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GroupedLinkedMap.java */
/* JADX INFO: loaded from: classes.dex */
class h<K extends m, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<K, V> f4474a = new a<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<K, a<K, V>> f4475b = new HashMap();

    /* JADX INFO: compiled from: GroupedLinkedMap.java */
    private static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final K f4476a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<V> f4477b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        a<K, V> f4478c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a<K, V> f4479d;

        a() {
            this(null);
        }

        public V a() {
            int iB = b();
            if (iB > 0) {
                return this.f4477b.remove(iB - 1);
            }
            return null;
        }

        public int b() {
            List<V> list = this.f4477b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        a(K k) {
            this.f4479d = this;
            this.f4478c = this;
            this.f4476a = k;
        }

        public void a(V v) {
            if (this.f4477b == null) {
                this.f4477b = new ArrayList();
            }
            this.f4477b.add(v);
        }
    }

    h() {
    }

    private void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f4474a;
        aVar.f4479d = aVar2.f4479d;
        aVar.f4478c = aVar2;
        d(aVar);
    }

    private static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.f4479d;
        aVar2.f4478c = aVar.f4478c;
        aVar.f4478c.f4479d = aVar2;
    }

    private static <K, V> void d(a<K, V> aVar) {
        aVar.f4478c.f4479d = aVar;
        aVar.f4479d.f4478c = aVar;
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.f4475b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.f4475b.put(k, aVar);
        } else {
            k.offer();
        }
        aVar.a(v);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        boolean z = false;
        for (a aVar = this.f4474a.f4478c; !aVar.equals(this.f4474a); aVar = aVar.f4478c) {
            z = true;
            sb.append('{');
            sb.append(aVar.f4476a);
            sb.append(':');
            sb.append(aVar.b());
            sb.append("}, ");
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    public V a(K k) {
        a<K, V> aVar = this.f4475b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.f4475b.put(k, aVar);
        } else {
            k.offer();
        }
        a(aVar);
        return aVar.a();
    }

    public V a() {
        for (a aVar = this.f4474a.f4479d; !aVar.equals(this.f4474a); aVar = aVar.f4479d) {
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            c(aVar);
            this.f4475b.remove(aVar.f4476a);
            ((m) aVar.f4476a).offer();
        }
        return null;
    }

    private void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f4474a;
        aVar.f4479d = aVar2;
        aVar.f4478c = aVar2.f4478c;
        d(aVar);
    }
}
