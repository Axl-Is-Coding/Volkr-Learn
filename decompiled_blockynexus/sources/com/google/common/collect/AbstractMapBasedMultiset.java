package com.google.common.collect;

import com.google.common.collect.oa;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
abstract class AbstractMapBasedMultiset<E> extends AbstractC2256k<E> implements Serializable {
    private static final long serialVersionUID = -2250766705698539974L;
    private transient Map<E, Count> backingMap;
    private transient long size;

    private class a implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator<Map.Entry<E, Count>> f13805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map.Entry<E, Count> f13806b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f13807c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f13808d;

        a() {
            this.f13805a = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13807c > 0 || this.f13805a.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f13807c == 0) {
                this.f13806b = this.f13805a.next();
                this.f13807c = this.f13806b.getValue().get();
            }
            this.f13807c--;
            this.f13808d = true;
            return this.f13806b.getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            C2259n.a(this.f13808d);
            if (this.f13806b.getValue().get() <= 0) {
                throw new ConcurrentModificationException();
            }
            if (this.f13806b.getValue().addAndGet(-1) == 0) {
                this.f13805a.remove();
            }
            AbstractMapBasedMultiset.access$110(AbstractMapBasedMultiset.this);
            this.f13808d = false;
        }
    }

    protected AbstractMapBasedMultiset(Map<E, Count> map) {
        com.google.common.base.m.a(map);
        this.backingMap = map;
        this.size = super.size();
    }

    static /* synthetic */ long access$110(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        long j = abstractMapBasedMultiset.size;
        abstractMapBasedMultiset.size = j - 1;
        return j;
    }

    static /* synthetic */ long access$122(AbstractMapBasedMultiset abstractMapBasedMultiset, long j) {
        long j2 = abstractMapBasedMultiset.size - j;
        abstractMapBasedMultiset.size = j2;
        return j2;
    }

    private static int getAndSet(Count count, int i) {
        if (count == null) {
            return 0;
        }
        return count.getAndSet(i);
    }

    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }

    @Override // com.google.common.collect.AbstractC2256k, com.google.common.collect.oa
    public int add(E e2, int i) {
        int i2;
        if (i == 0) {
            return count(e2);
        }
        com.google.common.base.m.a(i > 0, "occurrences cannot be negative: %s", Integer.valueOf(i));
        Count count = this.backingMap.get(e2);
        if (count == null) {
            this.backingMap.put(e2, new Count(i));
            i2 = 0;
        } else {
            i2 = count.get();
            long j = ((long) i2) + ((long) i);
            com.google.common.base.m.a(j <= 2147483647L, "too many occurrences: %s", Long.valueOf(j));
            count.getAndAdd(i);
        }
        this.size += (long) i;
        return i2;
    }

    @Override // com.google.common.collect.AbstractC2256k, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Iterator<Count> it = this.backingMap.values().iterator();
        while (it.hasNext()) {
            it.next().set(0);
        }
        this.backingMap.clear();
        this.size = 0L;
    }

    @Override // com.google.common.collect.AbstractC2256k, com.google.common.collect.oa
    public int count(Object obj) {
        Count count = (Count) Maps.e(this.backingMap, obj);
        if (count == null) {
            return 0;
        }
        return count.get();
    }

    @Override // com.google.common.collect.AbstractC2256k
    int distinctElements() {
        return this.backingMap.size();
    }

    @Override // com.google.common.collect.AbstractC2256k
    Iterator<oa.a<E>> entryIterator() {
        return new C2251g(this, this.backingMap.entrySet().iterator());
    }

    @Override // com.google.common.collect.AbstractC2256k, com.google.common.collect.oa
    public Set<oa.a<E>> entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractC2256k, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractC2256k, com.google.common.collect.oa
    public int remove(Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        com.google.common.base.m.a(i > 0, "occurrences cannot be negative: %s", Integer.valueOf(i));
        Count count = this.backingMap.get(obj);
        if (count == null) {
            return 0;
        }
        int i2 = count.get();
        if (i2 <= i) {
            this.backingMap.remove(obj);
            i = i2;
        }
        count.addAndGet(-i);
        this.size -= (long) i;
        return i2;
    }

    void setBackingMap(Map<E, Count> map) {
        this.backingMap = map;
    }

    @Override // com.google.common.collect.AbstractC2256k, com.google.common.collect.oa
    public int setCount(E e2, int i) {
        int andSet;
        C2259n.a(i, "count");
        if (i == 0) {
            andSet = getAndSet(this.backingMap.remove(e2), i);
        } else {
            Count count = this.backingMap.get(e2);
            int andSet2 = getAndSet(count, i);
            if (count == null) {
                this.backingMap.put(e2, new Count(i));
            }
            andSet = andSet2;
        }
        this.size += (long) (i - andSet);
        return andSet;
    }

    @Override // com.google.common.collect.AbstractC2256k, java.util.AbstractCollection, java.util.Collection
    public int size() {
        return b.c.b.b.a.a(this.size);
    }
}
