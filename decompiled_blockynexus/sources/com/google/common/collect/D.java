package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes2.dex */
class D<K, V> extends Fa<Map.Entry<K, ImmutableSet<V>>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterator f13818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImmutableMap.MapViewOfValuesAsSingletonSets f13819b;

    D(ImmutableMap.MapViewOfValuesAsSingletonSets mapViewOfValuesAsSingletonSets, Iterator it) {
        this.f13819b = mapViewOfValuesAsSingletonSets;
        this.f13818a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13818a.hasNext();
    }

    @Override // java.util.Iterator
    public Map.Entry<K, ImmutableSet<V>> next() {
        return new C(this, (Map.Entry) this.f13818a.next());
    }
}
