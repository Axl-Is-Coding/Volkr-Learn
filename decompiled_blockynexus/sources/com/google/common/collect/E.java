package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: ImmutableMapValues.java */
/* JADX INFO: loaded from: classes2.dex */
class E<V> extends Fa<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Fa<Map.Entry<K, V>> f13820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImmutableMapValues f13821b;

    E(ImmutableMapValues immutableMapValues) {
        this.f13821b = immutableMapValues;
        this.f13820a = this.f13821b.map.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13820a.hasNext();
    }

    @Override // java.util.Iterator
    public V next() {
        return (V) ((Map.Entry) this.f13820a.next()).getValue();
    }
}
