package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements W<K, V> {
    private static final long serialVersionUID = 0;
    private transient ImmutableListMultimap<V, K> inverse;

    public static final class a<K, V> extends ImmutableMultimap.a<K, V> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* bridge */ /* synthetic */ ImmutableMultimap.a a(Object obj, Object obj2) {
            a(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public /* bridge */ /* synthetic */ ImmutableMultimap.a a(Map.Entry entry) {
            a(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public a<K, V> a(K k, V v) {
            super.a((Object) k, (Object) v);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public a<K, V> a(Map.Entry<? extends K, ? extends V> entry) {
            super.a((Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public a<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.a((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.a
        public ImmutableListMultimap<K, V> a() {
            return (ImmutableListMultimap) super.a();
        }
    }

    ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i) {
        super(immutableMap, i);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(ha<? extends K, ? extends V> haVar) {
        if (haVar.isEmpty()) {
            return of();
        }
        if (haVar instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) haVar;
            if (!immutableListMultimap.isPartialView()) {
                return immutableListMultimap;
            }
        }
        ImmutableMap.a aVar = new ImmutableMap.a(haVar.asMap().size());
        int size = 0;
        for (Map.Entry<? extends K, Collection<? extends V>> entry : haVar.asMap().entrySet()) {
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) entry.getValue());
            if (!immutableListCopyOf.isEmpty()) {
                aVar.a(entry.getKey(), immutableListCopyOf);
                size += immutableListCopyOf.size();
            }
        }
        return new ImmutableListMultimap<>(aVar.a(), size);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> invert() {
        a aVarBuilder = builder();
        for (Map.Entry entry : entries()) {
            aVarBuilder.a(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> immutableListMultimapA = aVarBuilder.a();
        immutableListMultimapA.inverse = this;
        return immutableListMultimapA;
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return EmptyImmutableListMultimap.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int i = objectInputStream.readInt();
        if (i < 0) {
            throw new InvalidObjectException("Invalid key count " + i);
        }
        ImmutableMap.a aVarBuilder = ImmutableMap.builder();
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object object = objectInputStream.readObject();
            int i4 = objectInputStream.readInt();
            if (i4 <= 0) {
                throw new InvalidObjectException("Invalid value count " + i4);
            }
            ImmutableList.a aVarBuilder2 = ImmutableList.builder();
            for (int i5 = 0; i5 < i4; i5++) {
                aVarBuilder2.a(objectInputStream.readObject());
            }
            aVarBuilder.a(object, aVarBuilder2.a());
            i2 += i4;
        }
        try {
            ImmutableMultimap.b.f13839a.a(this, aVarBuilder.a());
            ImmutableMultimap.b.f13840b.a(this, i2);
        } catch (IllegalArgumentException e2) {
            throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        ya.a(this, objectOutputStream);
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v) {
        a aVarBuilder = builder();
        aVarBuilder.a((Object) k, (Object) v);
        return aVarBuilder.a();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.inverse;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> immutableListMultimapInvert = invert();
        this.inverse = immutableListMultimapInvert;
        return immutableListMultimapInvert;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.ha
    public ImmutableList<V> get(K k) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    @Override // com.google.common.collect.ImmutableMultimap
    @Deprecated
    /* JADX INFO: renamed from: removeAll */
    public ImmutableList<V> mo61removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.AbstractC2255j
    @Deprecated
    public ImmutableList<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2) {
        a aVarBuilder = builder();
        aVarBuilder.a((Object) k, (Object) v);
        aVarBuilder.a((Object) k2, (Object) v2);
        return aVarBuilder.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        a aVarBuilder = builder();
        aVarBuilder.a((Object) k, (Object) v);
        aVarBuilder.a((Object) k2, (Object) v2);
        aVarBuilder.a((Object) k3, (Object) v3);
        return aVarBuilder.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a();
        aVar.a((Iterable) iterable);
        return aVar.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        a aVarBuilder = builder();
        aVarBuilder.a((Object) k, (Object) v);
        aVarBuilder.a((Object) k2, (Object) v2);
        aVarBuilder.a((Object) k3, (Object) v3);
        aVarBuilder.a((Object) k4, (Object) v4);
        return aVarBuilder.a();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        a aVarBuilder = builder();
        aVarBuilder.a((Object) k, (Object) v);
        aVarBuilder.a((Object) k2, (Object) v2);
        aVarBuilder.a((Object) k3, (Object) v3);
        aVarBuilder.a((Object) k4, (Object) v4);
        aVarBuilder.a((Object) k5, (Object) v5);
        return aVarBuilder.a();
    }
}
