package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: MultimapBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
class ja extends MultimapBuilder.b<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13948a;

    ja(int i) {
        this.f13948a = i;
    }

    @Override // com.google.common.collect.MultimapBuilder.b
    <K, V> Map<K, Collection<V>> b() {
        return Maps.b(this.f13948a);
    }
}
