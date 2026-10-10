package com.google.common.base;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final f<F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    FunctionalEquivalence(f<F, ? extends T> fVar, Equivalence<T> equivalence) {
        m.a(fVar);
        this.function = fVar;
        m.a(equivalence);
        this.resultEquivalence = equivalence;
    }

    @Override // com.google.common.base.Equivalence
    protected boolean doEquivalent(F f2, F f3) {
        return this.resultEquivalence.equivalent(this.function.apply(f2), this.function.apply(f3));
    }

    @Override // com.google.common.base.Equivalence
    protected int doHash(F f2) {
        return this.resultEquivalence.hash(this.function.apply(f2));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        return this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence);
    }

    public int hashCode() {
        return k.a(this.function, this.resultEquivalence);
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
