package com.google.common.collect;

import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: compiled from: Multimaps.java */
/* JADX INFO: loaded from: classes2.dex */
class ma<K> extends Multisets.a<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f13956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ na f13957b;

    ma(na naVar, Map.Entry entry) {
        this.f13957b = naVar;
        this.f13956a = entry;
    }

    @Override // com.google.common.collect.oa.a
    public int getCount() {
        return ((Collection) this.f13956a.getValue()).size();
    }

    @Override // com.google.common.collect.oa.a
    public K getElement() {
        return (K) this.f13956a.getKey();
    }
}
