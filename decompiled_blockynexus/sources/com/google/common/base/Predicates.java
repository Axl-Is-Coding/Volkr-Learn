package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;

/* JADX INFO: loaded from: classes2.dex */
public final class Predicates {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final h f13731a = h.a(',');

    private static class InPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        @Override // com.google.common.base.n
        public boolean apply(T t) {
            try {
                return this.target.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        @Override // com.google.common.base.n
        public boolean equals(Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.target + ")";
        }

        private InPredicate(Collection<?> collection) {
            m.a(collection);
            this.target = collection;
        }
    }

    private static class IsEqualToPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final T target;

        @Override // com.google.common.base.n
        public boolean apply(T t) {
            return this.target.equals(t);
        }

        @Override // com.google.common.base.n
        public boolean equals(Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        public int hashCode() {
            return this.target.hashCode();
        }

        public String toString() {
            return "Predicates.equalTo(" + this.target + ")";
        }

        private IsEqualToPredicate(T t) {
            this.target = t;
        }
    }

    private static class NotPredicate<T> implements n<T>, Serializable {
        private static final long serialVersionUID = 0;
        final n<T> predicate;

        NotPredicate(n<T> nVar) {
            m.a(nVar);
            this.predicate = nVar;
        }

        @Override // com.google.common.base.n
        public boolean apply(T t) {
            return !this.predicate.apply(t);
        }

        @Override // com.google.common.base.n
        public boolean equals(Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return this.predicate.hashCode() ^ (-1);
        }

        public String toString() {
            return "Predicates.not(" + this.predicate + ")";
        }
    }

    enum ObjectPredicate implements n<Object> {
        ALWAYS_TRUE { // from class: com.google.common.base.Predicates.ObjectPredicate.1
            @Override // com.google.common.base.n
            public boolean apply(Object obj) {
                return true;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.google.common.base.Predicates.ObjectPredicate.2
            @Override // com.google.common.base.n
            public boolean apply(Object obj) {
                return false;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.3
            @Override // com.google.common.base.n
            public boolean apply(Object obj) {
                return obj == null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.4
            @Override // com.google.common.base.n
            public boolean apply(Object obj) {
                return obj != null;
            }

            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        <T> n<T> withNarrowedType() {
            return this;
        }
    }

    public static <T> n<T> a() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    public static <T> n<T> a(n<T> nVar) {
        return new NotPredicate(nVar);
    }

    public static <T> n<T> a(T t) {
        return t == null ? a() : new IsEqualToPredicate(t);
    }

    public static <T> n<T> a(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }
}
