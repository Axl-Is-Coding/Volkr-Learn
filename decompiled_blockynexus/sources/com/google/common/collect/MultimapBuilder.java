package com.google.common.collect;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class MultimapBuilder<K0, V0> {

    /* JADX INFO: Access modifiers changed from: private */
    static final class ArrayListSupplier<V> implements com.google.common.base.u<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        ArrayListSupplier(int i) {
            C2259n.a(i, "expectedValuesPerKey");
            this.expectedValuesPerKey = i;
        }

        @Override // com.google.common.base.u
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class LinkedHashSetSupplier<V> implements com.google.common.base.u<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        LinkedHashSetSupplier(int i) {
            C2259n.a(i, "expectedValuesPerKey");
            this.expectedValuesPerKey = i;
        }

        @Override // com.google.common.base.u
        public Set<V> get() {
            return Aa.b(this.expectedValuesPerKey);
        }
    }

    public static abstract class a<K0, V0> extends MultimapBuilder<K0, V0> {
        a() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> W<K, V> b();
    }

    public static abstract class b<K0> {
        b() {
        }

        public a<K0, Object> a() {
            return a(2);
        }

        public c<K0, Object> b(int i) {
            C2259n.a(i, "expectedValuesPerKey");
            return new la(this, i);
        }

        abstract <K extends K0, V> Map<K, Collection<V>> b();

        public c<K0, Object> c() {
            return b(2);
        }

        public a<K0, Object> a(int i) {
            C2259n.a(i, "expectedValuesPerKey");
            return new ka(this, i);
        }
    }

    public static abstract class c<K0, V0> extends MultimapBuilder<K0, V0> {
        c() {
            super(null);
        }

        public abstract <K extends K0, V extends V0> za<K, V> b();
    }

    /* synthetic */ MultimapBuilder(ia iaVar) {
        this();
    }

    public static b<Object> a() {
        return a(8);
    }

    private MultimapBuilder() {
    }

    public static b<Object> a(int i) {
        C2259n.a(i, "expectedKeys");
        return new ja(i);
    }
}
