package com.google.common.collect;

import com.google.common.collect.oa;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: renamed from: com.google.common.collect.g, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractMapBasedMultiset.java */
/* JADX INFO: loaded from: classes2.dex */
class C2251g<E> implements Iterator<oa.a<E>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map.Entry<E, Count> f13941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Iterator f13942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AbstractMapBasedMultiset f13943c;

    C2251g(AbstractMapBasedMultiset abstractMapBasedMultiset, Iterator it) {
        this.f13943c = abstractMapBasedMultiset;
        this.f13942b = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13942b.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        C2259n.a(this.f13941a != null);
        AbstractMapBasedMultiset.access$122(this.f13943c, this.f13941a.getValue().getAndSet(0));
        this.f13942b.remove();
        this.f13941a = null;
    }

    @Override // java.util.Iterator
    public oa.a<E> next() {
        Map.Entry<E, Count> entry = (Map.Entry) this.f13942b.next();
        this.f13941a = entry;
        return new C2249f(this, entry);
    }
}
