package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: renamed from: com.google.common.collect.q, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FluentIterable.java */
/* JADX INFO: loaded from: classes2.dex */
class C2262q<E> extends r<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Iterable f13961b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2262q(Iterable iterable, Iterable iterable2) {
        super(iterable);
        this.f13961b = iterable2;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return this.f13961b.iterator();
    }
}
