package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes2.dex */
class C<K, V> extends AbstractC2253h<K, ImmutableSet<V>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f13812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ D f13813b;

    C(D d2, Map.Entry entry) {
        this.f13813b = d2;
        this.f13812a = entry;
    }

    @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
    public K getKey() {
        return (K) this.f13812a.getKey();
    }

    @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
    public ImmutableSet<V> getValue() {
        return ImmutableSet.of(this.f13812a.getValue());
    }
}
