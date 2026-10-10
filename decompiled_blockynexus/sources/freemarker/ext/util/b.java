package freemarker.ext.util;

import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX INFO: compiled from: IdentityHashMap.java */
/* JADX INFO: loaded from: classes5.dex */
class b extends AbstractCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ IdentityHashMap f21700a;

    b(IdentityHashMap identityHashMap) {
        this.f21700a = identityHashMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f21700a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f21700a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f21700a.getHashIterator(1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f21700a.count;
    }
}
