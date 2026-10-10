package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T, F] */
/* JADX INFO: compiled from: Iterators.java */
/* JADX INFO: loaded from: classes2.dex */
class U<F, T> extends Ea<F, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.google.common.base.f f13916b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    U(Iterator it, com.google.common.base.f fVar) {
        super(it);
        this.f13916b = fVar;
    }

    @Override // com.google.common.collect.Ea
    T a(F f2) {
        return (T) this.f13916b.apply(f2);
    }
}
