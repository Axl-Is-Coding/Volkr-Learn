package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: ImmutableMultimap.java */
/* JADX INFO: loaded from: classes2.dex */
class F<K, V> extends ImmutableMultimap<K, V>.c<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ImmutableMultimap f13823e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    F(ImmutableMultimap immutableMultimap) {
        super(immutableMultimap, null);
        this.f13823e = immutableMultimap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMultimap.c
    public Map.Entry<K, V> a(K k, V v) {
        return Maps.a(k, v);
    }
}
