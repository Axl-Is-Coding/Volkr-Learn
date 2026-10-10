package com.google.common.reflect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;

/* JADX INFO: Add missing generic type declarations: [K] */
/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes2.dex */
class q<K> extends TypeToken.b.a<K> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TypeToken.b f14014d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q(TypeToken.b bVar, TypeToken.b bVar2) {
        super(bVar2);
        this.f14014d = bVar;
    }

    @Override // com.google.common.reflect.TypeToken.b
    ImmutableList<K> a(Iterable<? extends K> iterable) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (K k : iterable) {
            if (!c(k).isInterface()) {
                aVarBuilder.a(k);
            }
        }
        return super.a((Iterable) aVarBuilder.a());
    }

    @Override // com.google.common.reflect.TypeToken.b
    Iterable<? extends K> b(K k) {
        return ImmutableSet.of();
    }
}
