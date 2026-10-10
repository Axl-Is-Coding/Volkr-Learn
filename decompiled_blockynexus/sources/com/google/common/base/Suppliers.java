package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class Suppliers {

    private static class SupplierOfInstance<T> implements u<T>, Serializable {
        private static final long serialVersionUID = 0;
        final T instance;

        SupplierOfInstance(T t) {
            this.instance = t;
        }

        public boolean equals(Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return k.a(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // com.google.common.base.u
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return k.a(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + ")";
        }
    }

    public static <T> u<T> a(T t) {
        return new SupplierOfInstance(t);
    }
}
