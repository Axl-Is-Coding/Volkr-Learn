package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.google.common.collect.ca, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes2.dex */
class C2244ca<K, V> extends MapMakerInternalMap.a<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    MapMakerInternalMap.i<K, V> f13930a = this;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    MapMakerInternalMap.i<K, V> f13931b = this;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MapMakerInternalMap.e f13932c;

    C2244ca(MapMakerInternalMap.e eVar) {
        this.f13932c = eVar;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public long getExpirationTime() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public MapMakerInternalMap.i<K, V> getNextExpirable() {
        return this.f13930a;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public MapMakerInternalMap.i<K, V> getPreviousExpirable() {
        return this.f13931b;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public void setExpirationTime(long j) {
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public void setNextExpirable(MapMakerInternalMap.i<K, V> iVar) {
        this.f13930a = iVar;
    }

    @Override // com.google.common.collect.MapMakerInternalMap.a, com.google.common.collect.MapMakerInternalMap.i
    public void setPreviousExpirable(MapMakerInternalMap.i<K, V> iVar) {
        this.f13931b = iVar;
    }
}
