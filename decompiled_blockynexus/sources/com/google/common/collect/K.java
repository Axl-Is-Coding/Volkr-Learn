package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Iterables.java */
/* JADX INFO: loaded from: classes2.dex */
class K<T> extends r<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Iterable f13851b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.google.common.base.f f13852c;

    K(Iterable iterable, com.google.common.base.f fVar) {
        this.f13851b = iterable;
        this.f13852c = fVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return V.a(this.f13851b.iterator(), this.f13852c);
    }
}
