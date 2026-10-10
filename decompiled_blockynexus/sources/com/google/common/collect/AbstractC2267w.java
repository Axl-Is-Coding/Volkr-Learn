package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

/* JADX INFO: renamed from: com.google.common.collect.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ForwardingSet.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2267w<E> extends AbstractC2263s<E> implements Set<E> {
    protected AbstractC2267w() {
    }

    @Override // com.google.common.collect.AbstractC2263s, com.google.common.collect.AbstractC2266v
    protected abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // com.google.common.collect.AbstractC2263s, com.google.common.collect.AbstractC2266v
    protected abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // com.google.common.collect.AbstractC2263s, com.google.common.collect.AbstractC2266v
    protected abstract Set<E> delegate();

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return delegate().hashCode();
    }

    protected boolean standardEquals(Object obj) {
        return Aa.a(this, obj);
    }

    protected int standardHashCode() {
        return Aa.a(this);
    }

    @Override // com.google.common.collect.AbstractC2263s
    protected boolean standardRemoveAll(Collection<?> collection) {
        com.google.common.base.m.a(collection);
        return Aa.a((Set<?>) this, collection);
    }
}
