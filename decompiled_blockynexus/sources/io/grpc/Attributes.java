package io.grpc;

import com.google.common.base.m;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class Attributes {
    public static final Attributes EMPTY = new Attributes();
    private final HashMap<Key<?>, Object> data;

    public static final class Builder {
        private Attributes product;

        public Attributes build() {
            m.b(this.product != null, "Already built");
            Attributes attributes = this.product;
            this.product = null;
            return attributes;
        }

        public <T> Builder set(Key<T> key, T t) {
            this.product.data.put(key, t);
            return this;
        }

        public <T> Builder setAll(Attributes attributes) {
            this.product.data.putAll(attributes.data);
            return this;
        }

        private Builder() {
            this.product = new Attributes();
        }
    }

    public static final class Key<T> {
        private final String name;

        private Key(String str) {
            this.name = str;
        }

        public static <T> Key<T> of(String str) {
            return new Key<>(str);
        }

        public String toString() {
            return this.name;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public <T> T get(Key<T> key) {
        return (T) this.data.get(key);
    }

    public Set<Key<?>> keys() {
        return Collections.unmodifiableSet(this.data.keySet());
    }

    public String toString() {
        return this.data.toString();
    }

    private Attributes() {
        this.data = new HashMap<>();
    }
}
