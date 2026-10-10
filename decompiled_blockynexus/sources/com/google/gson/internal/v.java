package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: compiled from: LinkedTreeMap.java */
/* JADX INFO: loaded from: classes2.dex */
class v<K> extends LinkedTreeMap<K, V>.c<K> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ LinkedTreeMap.b f14239e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    v(LinkedTreeMap.b bVar) {
        super();
        this.f14239e = bVar;
    }

    @Override // java.util.Iterator
    public K next() {
        return a().f14119f;
    }
}
