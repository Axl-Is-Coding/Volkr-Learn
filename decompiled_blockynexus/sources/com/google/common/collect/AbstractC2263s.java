package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: com.google.common.collect.s, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ForwardingCollection.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2263s<E> extends AbstractC2266v implements Collection<E> {
    protected AbstractC2263s() {
    }

    @Override // java.util.Collection
    public boolean add(E e2) {
        return delegate().add(e2);
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    @Override // java.util.Collection
    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return delegate().contains(obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    @Override // com.google.common.collect.AbstractC2266v
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.AbstractC2266v
    protected abstract Collection<E> delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    protected boolean standardAddAll(Collection<? extends E> collection) {
        return V.a(this, collection.iterator());
    }

    protected void standardClear() {
        V.a((Iterator<?>) iterator());
    }

    protected boolean standardContains(Object obj) {
        return V.a((Iterator<?>) iterator(), obj);
    }

    protected boolean standardContainsAll(Collection<?> collection) {
        return C2261p.a((Collection<?>) this, collection);
    }

    protected boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    protected boolean standardRemove(Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (com.google.common.base.k.a(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    protected abstract boolean standardRemoveAll(Collection<?> collection);

    protected boolean standardRetainAll(Collection<?> collection) {
        return V.b((Iterator<?>) iterator(), collection);
    }

    protected Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    protected String standardToString() {
        return C2261p.a((Collection<?>) this);
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return delegate().toArray();
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }

    protected <T> T[] standardToArray(T[] tArr) {
        return (T[]) ra.a((Collection<?>) this, (Object[]) tArr);
    }
}
