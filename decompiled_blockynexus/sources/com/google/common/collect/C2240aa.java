package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.google.common.collect.aa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes2.dex */
class C2240aa<K, V> extends MapMakerInternalMap.a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MapMakerInternalMap.i<K, V> f13924a = this;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    MapMakerInternalMap.i<K, V> f13925b = this;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MapMakerInternalMap.d f13926c;

    C2240aa(MapMakerInternalMap.d dVar) {
        this.f13926c = dVar;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public MapMakerInternalMap.i<K, V> getNextEvictable() {
        return this.f13924a;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public MapMakerInternalMap.i<K, V> getPreviousEvictable() {
        return this.f13925b;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public void setNextEvictable(MapMakerInternalMap.i<K, V> iVar) {
        this.f13924a = iVar;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public void setPreviousEvictable(MapMakerInternalMap.i<K, V> iVar) {
        this.f13925b = iVar;
    }
}
