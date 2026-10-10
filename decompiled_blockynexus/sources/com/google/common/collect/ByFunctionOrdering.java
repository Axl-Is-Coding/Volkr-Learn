package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final com.google.common.base.f<F, ? extends T> function;
    final Ordering<T> ordering;

    ByFunctionOrdering(com.google.common.base.f<F, ? extends T> fVar, Ordering<T> ordering) {
        com.google.common.base.m.a(fVar);
        this.function = fVar;
        com.google.common.base.m.a(ordering);
        this.ordering = ordering;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(F f2, F f3) {
        return this.ordering.compare(this.function.apply(f2), this.function.apply(f3));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        return this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering);
    }

    public int hashCode() {
        return com.google.common.base.k.a(this.function, this.ordering);
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
