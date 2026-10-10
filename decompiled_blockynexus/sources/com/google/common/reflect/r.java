package com.google.common.reflect;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes2.dex */
class r<K> extends Ordering<K> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Comparator f14015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f14016b;

    r(Comparator comparator, Map map) {
        this.f14015a = comparator;
        this.f14016b = map;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(K k, K k2) {
        return this.f14015a.compare(this.f14016b.get(k), this.f14016b.get(k2));
    }
}
