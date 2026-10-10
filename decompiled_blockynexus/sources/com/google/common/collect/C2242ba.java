package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.google.common.collect.ba, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes2.dex */
class C2242ba<K, V> extends AbstractC2257l<MapMakerInternalMap.i<K, V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MapMakerInternalMap.d f13928b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2242ba(MapMakerInternalMap.d dVar, MapMakerInternalMap.i iVar) {
        super(iVar);
        this.f13928b = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractC2257l
    public MapMakerInternalMap.i<K, V> a(MapMakerInternalMap.i<K, V> iVar) {
        MapMakerInternalMap.i<K, V> nextEvictable = iVar.getNextEvictable();
        if (nextEvictable == this.f13928b.f13862a) {
            return null;
        }
        return nextEvictable;
    }
}
