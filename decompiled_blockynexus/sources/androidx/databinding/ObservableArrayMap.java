package androidx.databinding;

import androidx.databinding.ObservableMap;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public class ObservableArrayMap<K, V> extends a.a.b<K, V> implements ObservableMap<K, V> {
    private transient h i;

    @Override // a.a.b
    public boolean a(Collection<?> collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            if (!collection.contains(b(size))) {
                c(size);
                z = true;
            }
        }
        return z;
    }

    @Override // androidx.databinding.ObservableMap
    public void addOnMapChangedCallback(ObservableMap.a<? extends ObservableMap<K, V>, K, V> aVar) {
        if (this.i == null) {
            this.i = new h();
        }
        this.i.a(aVar);
    }

    @Override // a.a.i
    public V c(int i) {
        K kB = b(i);
        V v = (V) super.c(i);
        if (v != null) {
            c(kB);
        }
        return v;
    }

    @Override // a.a.i, java.util.Map
    public void clear() {
        if (isEmpty()) {
            return;
        }
        super.clear();
        c((Object) null);
    }

    @Override // a.a.i, java.util.Map
    public V put(K k, V v) {
        super.put(k, v);
        c(k);
        return v;
    }

    @Override // androidx.databinding.ObservableMap
    public void removeOnMapChangedCallback(ObservableMap.a<? extends ObservableMap<K, V>, K, V> aVar) {
        h hVar = this.i;
        if (hVar != null) {
            hVar.b(aVar);
        }
    }

    private void c(Object obj) {
        h hVar = this.i;
        if (hVar != null) {
            hVar.a(this, 0, obj);
        }
    }

    @Override // a.a.i
    public V a(int i, V v) {
        K kB = b(i);
        V v2 = (V) super.a(i, v);
        c(kB);
        return v2;
    }
}
