package freemarker.ext.util;

import java.util.AbstractSet;
import java.util.Iterator;

/* JADX INFO: compiled from: IdentityHashMap.java */
/* JADX INFO: loaded from: classes5.dex */
class a extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ IdentityHashMap f21699a;

    a(IdentityHashMap identityHashMap) {
        this.f21699a = identityHashMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f21699a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f21699a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f21699a.getHashIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int i = this.f21699a.count;
        this.f21699a.remove(obj);
        return this.f21699a.count != i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f21699a.count;
    }
}
