package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Iterables.java */
/* JADX INFO: loaded from: classes2.dex */
class J<T> extends r<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Iterable f13849b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.google.common.base.n f13850c;

    J(Iterable iterable, com.google.common.base.n nVar) {
        this.f13849b = iterable;
        this.f13850c = nVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return V.c(this.f13849b.iterator(), this.f13850c);
    }
}
