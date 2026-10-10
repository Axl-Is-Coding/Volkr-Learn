package com.google.common.collect;

import com.alibaba.android.arouter.utils.Consts;
import com.google.common.base.Equivalence;
import com.google.common.base.j;
import com.google.common.collect.MapMakerInternalMap;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class MapMaker extends GenericMapMaker<Object, Object> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f13856b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    MapMakerInternalMap.Strength f13860f;
    MapMakerInternalMap.Strength g;
    RemovalCause j;
    Equivalence<Object> k;
    com.google.common.base.x l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f13857c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f13858d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f13859e = -1;
    long h = -1;
    long i = -1;

    static final class ComputingMapAdapter<K, V> extends ComputingConcurrentHashMap<K, V> implements Serializable {
        private static final long serialVersionUID = 0;

        ComputingMapAdapter(MapMaker mapMaker, com.google.common.base.f<? super K, ? extends V> fVar) {
            super(mapMaker, fVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.MapMakerInternalMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) throws Throwable {
            try {
                V orCompute = getOrCompute(obj);
                if (orCompute != null) {
                    return orCompute;
                }
                throw new NullPointerException(this.computingFunction + " returned null for key " + obj + Consts.DOT);
            } catch (ExecutionException e2) {
                Throwable cause = e2.getCause();
                com.google.common.base.v.a(cause, ComputationException.class);
                throw new ComputationException(cause);
            }
        }
    }

    static final class NullComputingConcurrentMap<K, V> extends NullConcurrentMap<K, V> {
        private static final long serialVersionUID = 0;
        final com.google.common.base.f<? super K, ? extends V> computingFunction;

        NullComputingConcurrentMap(MapMaker mapMaker, com.google.common.base.f<? super K, ? extends V> fVar) {
            super(mapMaker);
            com.google.common.base.m.a(fVar);
            this.computingFunction = fVar;
        }

        private V compute(K k) {
            com.google.common.base.m.a(k);
            try {
                return this.computingFunction.apply(k);
            } catch (ComputationException e2) {
                throw e2;
            } catch (Throwable th) {
                throw new ComputationException(th);
            }
        }

        @Override // com.google.common.collect.MapMaker.NullConcurrentMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            V vCompute = compute(obj);
            com.google.common.base.m.a(vCompute, "%s returned null for key %s.", this.computingFunction, obj);
            notifyRemoval(obj, vCompute);
            return vCompute;
        }
    }

    enum RemovalCause {
        EXPLICIT { // from class: com.google.common.collect.MapMaker.RemovalCause.1
            @Override // com.google.common.collect.MapMaker.RemovalCause
            boolean wasEvicted() {
                return false;
            }
        },
        REPLACED { // from class: com.google.common.collect.MapMaker.RemovalCause.2
            @Override // com.google.common.collect.MapMaker.RemovalCause
            boolean wasEvicted() {
                return false;
            }
        },
        COLLECTED { // from class: com.google.common.collect.MapMaker.RemovalCause.3
            @Override // com.google.common.collect.MapMaker.RemovalCause
            boolean wasEvicted() {
                return true;
            }
        },
        EXPIRED { // from class: com.google.common.collect.MapMaker.RemovalCause.4
            @Override // com.google.common.collect.MapMaker.RemovalCause
            boolean wasEvicted() {
                return true;
            }
        },
        SIZE { // from class: com.google.common.collect.MapMaker.RemovalCause.5
            @Override // com.google.common.collect.MapMaker.RemovalCause
            boolean wasEvicted() {
                return true;
            }
        };

        abstract boolean wasEvicted();
    }

    static final class RemovalNotification<K, V> extends ImmutableEntry<K, V> {
        private static final long serialVersionUID = 0;
        private final RemovalCause cause;

        RemovalNotification(K k, V v, RemovalCause removalCause) {
            super(k, v);
            this.cause = removalCause;
        }

        public RemovalCause getCause() {
            return this.cause;
        }

        public boolean wasEvicted() {
            return this.cause.wasEvicted();
        }
    }

    interface a<K, V> {
        void onRemoval(RemovalNotification<K, V> removalNotification);
    }

    MapMaker a(Equivalence<Object> equivalence) {
        com.google.common.base.m.b(this.k == null, "key equivalence was already set to %s", this.k);
        com.google.common.base.m.a(equivalence);
        this.k = equivalence;
        this.f13856b = true;
        return this;
    }

    public MapMaker b(int i) {
        com.google.common.base.m.b(this.f13857c == -1, "initial capacity was already set to %s", Integer.valueOf(this.f13857c));
        com.google.common.base.m.a(i >= 0);
        this.f13857c = i;
        return this;
    }

    @Deprecated
    MapMaker c(int i) {
        com.google.common.base.m.b(this.f13859e == -1, "maximum size was already set to %s", Integer.valueOf(this.f13859e));
        com.google.common.base.m.a(i >= 0, "maximum size must not be negative");
        this.f13859e = i;
        this.f13856b = true;
        if (this.f13859e == 0) {
            this.j = RemovalCause.SIZE;
        }
        return this;
    }

    long d() {
        long j = this.h;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    int e() {
        int i = this.f13857c;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    Equivalence<Object> f() {
        return (Equivalence) com.google.common.base.j.a(this.k, g().defaultEquivalence());
    }

    MapMakerInternalMap.Strength g() {
        return (MapMakerInternalMap.Strength) com.google.common.base.j.a(this.f13860f, MapMakerInternalMap.Strength.STRONG);
    }

    com.google.common.base.x h() {
        return (com.google.common.base.x) com.google.common.base.j.a(this.l, com.google.common.base.x.b());
    }

    MapMakerInternalMap.Strength i() {
        return (MapMakerInternalMap.Strength) com.google.common.base.j.a(this.g, MapMakerInternalMap.Strength.STRONG);
    }

    public <K, V> ConcurrentMap<K, V> j() {
        return !this.f13856b ? new ConcurrentHashMap(e(), 0.75f, b()) : this.j == null ? new MapMakerInternalMap(this) : new NullConcurrentMap(this);
    }

    public MapMaker k() {
        a(MapMakerInternalMap.Strength.WEAK);
        return this;
    }

    public String toString() {
        j.a aVarA = com.google.common.base.j.a(this);
        int i = this.f13857c;
        if (i != -1) {
            aVarA.a("initialCapacity", i);
        }
        int i2 = this.f13858d;
        if (i2 != -1) {
            aVarA.a("concurrencyLevel", i2);
        }
        int i3 = this.f13859e;
        if (i3 != -1) {
            aVarA.a("maximumSize", i3);
        }
        if (this.h != -1) {
            aVarA.a("expireAfterWrite", this.h + "ns");
        }
        if (this.i != -1) {
            aVarA.a("expireAfterAccess", this.i + "ns");
        }
        MapMakerInternalMap.Strength strength = this.f13860f;
        if (strength != null) {
            aVarA.a("keyStrength", com.google.common.base.b.a(strength.toString()));
        }
        MapMakerInternalMap.Strength strength2 = this.g;
        if (strength2 != null) {
            aVarA.a("valueStrength", com.google.common.base.b.a(strength2.toString()));
        }
        if (this.k != null) {
            aVarA.a("keyEquivalence");
        }
        if (this.f13825a != null) {
            aVarA.a("removalListener");
        }
        return aVarA.toString();
    }

    static class NullConcurrentMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        private final RemovalCause removalCause;
        private final a<K, V> removalListener;

        NullConcurrentMap(MapMaker mapMaker) {
            this.removalListener = mapMaker.a();
            this.removalCause = mapMaker.j;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsValue(Object obj) {
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return Collections.emptySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            return null;
        }

        void notifyRemoval(K k, V v) {
            this.removalListener.onRemoval(new RemovalNotification<>(k, v, this.removalCause));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            com.google.common.base.m.a(k);
            com.google.common.base.m.a(v);
            notifyRemoval(k, v);
            return null;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V putIfAbsent(K k, V v) {
            return put(k, v);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V remove(Object obj) {
            return null;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean remove(Object obj, Object obj2) {
            return false;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public V replace(K k, V v) {
            com.google.common.base.m.a(k);
            com.google.common.base.m.a(v);
            return null;
        }

        @Override // java.util.Map, java.util.concurrent.ConcurrentMap
        public boolean replace(K k, V v, V v2) {
            com.google.common.base.m.a(k);
            com.google.common.base.m.a(v2);
            return false;
        }
    }

    public MapMaker a(int i) {
        com.google.common.base.m.b(this.f13858d == -1, "concurrency level was already set to %s", Integer.valueOf(this.f13858d));
        com.google.common.base.m.a(i > 0);
        this.f13858d = i;
        return this;
    }

    int b() {
        int i = this.f13858d;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    MapMaker b(MapMakerInternalMap.Strength strength) {
        com.google.common.base.m.b(this.g == null, "Value strength was already set to %s", this.g);
        com.google.common.base.m.a(strength);
        this.g = strength;
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f13856b = true;
        }
        return this;
    }

    private void c(long j, TimeUnit timeUnit) {
        com.google.common.base.m.b(this.h == -1, "expireAfterWrite was already set to %s ns", Long.valueOf(this.h));
        com.google.common.base.m.b(this.i == -1, "expireAfterAccess was already set to %s ns", Long.valueOf(this.i));
        com.google.common.base.m.a(j >= 0, "duration cannot be negative: %s %s", Long.valueOf(j), timeUnit);
    }

    MapMaker a(MapMakerInternalMap.Strength strength) {
        com.google.common.base.m.b(this.f13860f == null, "Key strength was already set to %s", this.f13860f);
        com.google.common.base.m.a(strength);
        this.f13860f = strength;
        com.google.common.base.m.a(this.f13860f != MapMakerInternalMap.Strength.SOFT, "Soft keys are not supported");
        if (strength != MapMakerInternalMap.Strength.STRONG) {
            this.f13856b = true;
        }
        return this;
    }

    @Deprecated
    MapMaker b(long j, TimeUnit timeUnit) {
        c(j, timeUnit);
        this.h = timeUnit.toNanos(j);
        if (j == 0 && this.j == null) {
            this.j = RemovalCause.EXPIRED;
        }
        this.f13856b = true;
        return this;
    }

    long c() {
        long j = this.i;
        if (j == -1) {
            return 0L;
        }
        return j;
    }

    @Deprecated
    MapMaker a(long j, TimeUnit timeUnit) {
        c(j, timeUnit);
        this.i = timeUnit.toNanos(j);
        if (j == 0 && this.j == null) {
            this.j = RemovalCause.EXPIRED;
        }
        this.f13856b = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    <K, V> GenericMapMaker<K, V> a(a<K, V> aVar) {
        com.google.common.base.m.b(this.f13825a == null);
        com.google.common.base.m.a(aVar);
        this.f13825a = aVar;
        this.f13856b = true;
        return this;
    }

    @Deprecated
    <K, V> ConcurrentMap<K, V> a(com.google.common.base.f<? super K, ? extends V> fVar) {
        return this.j == null ? new ComputingMapAdapter(this, fVar) : new NullComputingConcurrentMap(this, fVar);
    }
}
