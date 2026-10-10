package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: renamed from: com.google.common.collect.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes2.dex */
class C2247e<K> implements Iterator<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map.Entry<K, Collection<V>> f13935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Iterator f13936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AbstractMapBasedMultimap.c f13937c;

    C2247e(AbstractMapBasedMultimap.c cVar, Iterator it) {
        this.f13937c = cVar;
        this.f13936b = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13936b.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        this.f13935a = (Map.Entry) this.f13936b.next();
        return this.f13935a.getKey();
    }

    @Override // java.util.Iterator
    public void remove() {
        C2259n.a(this.f13935a != null);
        Collection collection = (Collection) this.f13935a.getValue();
        this.f13936b.remove();
        AbstractMapBasedMultimap.access$220(AbstractMapBasedMultimap.this, collection.size());
        collection.clear();
    }
}
