package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.google.common.collect.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes2.dex */
class C2245d<K, V> extends AbstractMapBasedMultimap<K, V>.b<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AbstractMapBasedMultimap f13933f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2245d(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        super();
        this.f13933f = abstractMapBasedMultimap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMapBasedMultimap.b
    public Map.Entry<K, V> a(K k, V v) {
        return Maps.a(k, v);
    }
}
