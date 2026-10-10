package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes2.dex */
class B<K> extends Fa<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fa f13810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImmutableMap f13811b;

    B(ImmutableMap immutableMap, Fa fa) {
        this.f13811b = immutableMap;
        this.f13810a = fa;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13810a.hasNext();
    }

    @Override // java.util.Iterator
    public K next() {
        return (K) ((Map.Entry) this.f13810a.next()).getKey();
    }
}
