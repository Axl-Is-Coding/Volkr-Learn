package androidx.databinding;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface ObservableMap<K, V> extends Map<K, V> {

    public static abstract class a<T extends ObservableMap<K, V>, K, V> {
        public abstract void a(T t, K k);
    }

    void addOnMapChangedCallback(a<? extends ObservableMap<K, V>, K, V> aVar);

    void removeOnMapChangedCallback(a<? extends ObservableMap<K, V>, K, V> aVar);
}
