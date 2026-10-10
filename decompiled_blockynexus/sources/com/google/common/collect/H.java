package com.google.common.collect;

import com.google.common.collect.oa;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: ImmutableMultiset.java */
/* JADX INFO: loaded from: classes2.dex */
class H<E> extends Fa<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    E f13827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Iterator f13828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ImmutableMultiset f13829d;

    H(ImmutableMultiset immutableMultiset, Iterator it) {
        this.f13829d = immutableMultiset;
        this.f13828c = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13826a > 0 || this.f13828c.hasNext();
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.f13826a <= 0) {
            oa.a aVar = (oa.a) this.f13828c.next();
            this.f13827b = (E) aVar.getElement();
            this.f13826a = aVar.getCount();
        }
        this.f13826a--;
        return this.f13827b;
    }
}
