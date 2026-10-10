package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: LazyField.java */
/* JADX INFO: loaded from: classes2.dex */
public class t extends u {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final x f14380f;

    /* JADX INFO: compiled from: LazyField.java */
    static class a<K> implements Map.Entry<K, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Map.Entry<K, t> f14381a;

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f14381a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            t value = this.f14381a.getValue();
            if (value == null) {
                return null;
            }
            return value.a();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof x) {
                return this.f14381a.getValue().c((x) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        private a(Map.Entry<K, t> entry) {
            this.f14381a = entry;
        }
    }

    /* JADX INFO: compiled from: LazyField.java */
    static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f14382a;

        public b(Iterator<Map.Entry<K, Object>> it) {
            this.f14382a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14382a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f14382a.remove();
        }

        @Override // java.util.Iterator
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f14382a.next();
            return next.getValue() instanceof t ? new a(next) : next;
        }
    }

    public x a() {
        return b(this.f14380f);
    }

    public boolean equals(Object obj) {
        return a().equals(obj);
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        return a().toString();
    }
}
