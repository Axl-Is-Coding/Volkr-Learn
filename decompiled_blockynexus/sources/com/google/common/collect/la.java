package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;

/* JADX INFO: Add missing generic type declarations: [K0] */
/* JADX INFO: compiled from: MultimapBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
class la<K0> extends MultimapBuilder.c<K0, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MultimapBuilder.b f13955b;

    la(MultimapBuilder.b bVar, int i) {
        this.f13955b = bVar;
        this.f13954a = i;
    }

    @Override // com.google.common.collect.MultimapBuilder.c
    public <K extends K0, V> za<K, V> b() {
        return Multimaps.b(this.f13955b.b(), new MultimapBuilder.LinkedHashSetSupplier(this.f13954a));
    }
}
