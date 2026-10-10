package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.google.common.collect.fa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Maps.java */
/* JADX INFO: loaded from: classes2.dex */
class C2250fa<K, V> extends AbstractC2253h<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f13940a;

    C2250fa(Map.Entry entry) {
        this.f13940a = entry;
    }

    @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
    public K getKey() {
        return (K) this.f13940a.getKey();
    }

    @Override // com.google.common.collect.AbstractC2253h, java.util.Map.Entry
    public V getValue() {
        return (V) this.f13940a.getValue();
    }
}
