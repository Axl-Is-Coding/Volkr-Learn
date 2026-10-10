package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.google.common.collect.ga, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes2.dex */
class C2252ga<K, V> extends Fa<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterator f13944a;

    C2252ga(Iterator it) {
        this.f13944a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13944a.hasNext();
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        return Maps.b((Map.Entry) this.f13944a.next());
    }
}
