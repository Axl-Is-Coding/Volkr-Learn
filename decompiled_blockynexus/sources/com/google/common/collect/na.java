package com.google.common.collect;

import com.google.common.collect.Multimaps;
import com.google.common.collect.oa;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: Multimaps.java */
/* JADX INFO: loaded from: classes2.dex */
class na<K, V> extends Ea<Map.Entry<K, Collection<V>>, oa.a<K>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Multimaps.b f13958b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    na(Multimaps.b bVar, Iterator it) {
        super(it);
        this.f13958b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.Ea
    public oa.a<K> a(Map.Entry<K, Collection<V>> entry) {
        return new ma(this, entry);
    }
}
