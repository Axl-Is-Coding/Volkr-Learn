package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;

/* JADX INFO: Add missing generic type declarations: [K0] */
/* JADX INFO: compiled from: MultimapBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
class ka<K0> extends MultimapBuilder.a<K0, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f13951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MultimapBuilder.b f13952b;

    ka(MultimapBuilder.b bVar, int i) {
        this.f13952b = bVar;
        this.f13951a = i;
    }

    @Override // com.google.common.collect.MultimapBuilder.a
    public <K extends K0, V> W<K, V> b() {
        return Multimaps.a(this.f13952b.b(), new MultimapBuilder.ArrayListSupplier(this.f13951a));
    }
}
