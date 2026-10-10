package com.google.gson.internal;

import com.google.gson.internal.LinkedTreeMap;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: LinkedTreeMap.java */
/* JADX INFO: loaded from: classes2.dex */
class u<K, V> extends LinkedTreeMap<K, V>.c<Map.Entry<K, V>> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ LinkedTreeMap.a f14238e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    u(LinkedTreeMap.a aVar) {
        super();
        this.f14238e = aVar;
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        return a();
    }
}
