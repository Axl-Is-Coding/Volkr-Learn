package com.google.common.collect;

/* JADX INFO: Add missing generic type declarations: [V] */
/* JADX INFO: compiled from: ImmutableMultimap.java */
/* JADX INFO: loaded from: classes2.dex */
class G<V> extends ImmutableMultimap<K, V>.c<V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ImmutableMultimap f13824e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    G(ImmutableMultimap immutableMultimap) {
        super(immutableMultimap, null);
        this.f13824e = immutableMultimap;
    }

    @Override // com.google.common.collect.ImmutableMultimap.c
    V a(K k, V v) {
        return v;
    }
}
