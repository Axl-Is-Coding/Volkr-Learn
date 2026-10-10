package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements InterfaceC2258m<K, V> {

    private static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        Object readResolve() {
            return createMap(new a());
        }
    }

    public static final class a<K, V> extends ImmutableMap.a<K, V> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.a
        public /* bridge */ /* synthetic */ ImmutableMap.a a(Object obj, Object obj2) {
            a(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* bridge */ /* synthetic */ ImmutableMap.a a(Map.Entry entry) {
            a(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* bridge */ /* synthetic */ ImmutableMap.a a(Iterable iterable) {
            a(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public /* bridge */ /* synthetic */ ImmutableMap.a a(Map map) {
            a(map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public a<K, V> a(K k, V v) {
            super.a((Object) k, (Object) v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public a<K, V> a(Map.Entry<? extends K, ? extends V> entry) {
            super.a((Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public a<K, V> a(Map<? extends K, ? extends V> map) {
            super.a((Map) map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.a((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.a
        public ImmutableBiMap<K, V> a() {
            int i = this.f13834c;
            if (i == 0) {
                return ImmutableBiMap.of();
            }
            if (i != 1) {
                if (this.f13832a != null) {
                    if (this.f13835d) {
                        this.f13833b = (ImmutableMapEntry[]) ra.a((Object[]) this.f13833b, i);
                    }
                    Arrays.sort(this.f13833b, 0, this.f13834c, Ordering.from(this.f13832a).onResultOf(Maps.d()));
                }
                this.f13835d = this.f13834c == this.f13833b.length;
                return RegularImmutableBiMap.fromEntryArray(this.f13834c, this.f13833b);
            }
            return ImmutableBiMap.of((Object) this.f13833b[0].getKey(), (Object) this.f13833b[0].getValue());
        }
    }

    ImmutableBiMap() {
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @Deprecated
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // 
    /* JADX INFO: renamed from: inverse, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableBiMap<V, K> mo60inverse();

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v) {
        return new SingletonImmutableBiMap(k, v);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(k2, v2));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(k2, v2), ImmutableMap.entryOf(k3, v3));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return mo60inverse().keySet();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) L.a((Iterable) iterable, (Object[]) ImmutableMap.EMPTY_ENTRY_ARRAY);
        int length = entryArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return RegularImmutableBiMap.fromEntries(entryArr);
        }
        Map.Entry entry = entryArr[0];
        return of(entry.getKey(), entry.getValue());
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(k2, v2), ImmutableMap.entryOf(k3, v3), ImmutableMap.entryOf(k4, v4));
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return RegularImmutableBiMap.fromEntries(ImmutableMap.entryOf(k, v), ImmutableMap.entryOf(k2, v2), ImmutableMap.entryOf(k3, v3), ImmutableMap.entryOf(k4, v4), ImmutableMap.entryOf(k5, v5));
    }
}
