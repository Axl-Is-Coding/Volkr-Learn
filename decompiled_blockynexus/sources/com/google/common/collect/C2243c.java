package com.google.common.collect;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: renamed from: com.google.common.collect.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AbstractMapBasedMultimap.java */
/* JADX INFO: loaded from: classes2.dex */
class C2243c<V> extends AbstractMapBasedMultimap<K, V>.b<V> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AbstractMapBasedMultimap f13929f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2243c(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        super();
        this.f13929f = abstractMapBasedMultimap;
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap.b
    V a(K k, V v) {
        return v;
    }
}
