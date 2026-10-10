package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.google.common.collect.da, reason: case insensitive filesystem */
/* JADX INFO: compiled from: MapMakerInternalMap.java */
/* JADX INFO: loaded from: classes2.dex */
class C2246da<K, V> extends AbstractC2257l<MapMakerInternalMap.i<K, V>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MapMakerInternalMap.e f13934b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C2246da(MapMakerInternalMap.e eVar, MapMakerInternalMap.i iVar) {
        super(iVar);
        this.f13934b = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractC2257l
    public MapMakerInternalMap.i<K, V> a(MapMakerInternalMap.i<K, V> iVar) {
        MapMakerInternalMap.i<K, V> nextExpirable = iVar.getNextExpirable();
        if (nextExpirable == this.f13934b.f13863a) {
            return null;
        }
        return nextExpirable;
    }
}
