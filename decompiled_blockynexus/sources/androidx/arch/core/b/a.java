package androidx.arch.core.b;

import androidx.arch.core.b.b;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FastSafeIterableMap.java */
/* JADX INFO: loaded from: classes.dex */
public class a<K, V> extends b<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private HashMap<K, b.c<K, V>> f734e = new HashMap<>();

    @Override // androidx.arch.core.b.b
    protected b.c<K, V> a(K k) {
        return this.f734e.get(k);
    }

    @Override // androidx.arch.core.b.b
    public V b(K k, V v) {
        b.c<K, V> cVarA = a(k);
        if (cVarA != null) {
            return cVarA.f740b;
        }
        this.f734e.put(k, a(k, v));
        return null;
    }

    public boolean contains(K k) {
        return this.f734e.containsKey(k);
    }

    @Override // androidx.arch.core.b.b
    public V remove(K k) {
        V v = (V) super.remove(k);
        this.f734e.remove(k);
        return v;
    }

    public Map.Entry<K, V> b(K k) {
        if (contains(k)) {
            return this.f734e.get(k).f742d;
        }
        return null;
    }
}
