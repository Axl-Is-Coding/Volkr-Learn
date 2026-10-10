package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: Types.java */
/* JADX INFO: loaded from: classes2.dex */
class u extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AtomicReference f14018b;

    u(AtomicReference atomicReference) {
        this.f14018b = atomicReference;
    }

    @Override // com.google.common.reflect.s
    void a(TypeVariable<?> typeVariable) {
        this.f14018b.set(Types.b(typeVariable.getBounds()));
    }

    @Override // com.google.common.reflect.s
    void a(WildcardType wildcardType) {
        this.f14018b.set(Types.b(wildcardType.getUpperBounds()));
    }

    @Override // com.google.common.reflect.s
    void a(GenericArrayType genericArrayType) {
        this.f14018b.set(genericArrayType.getGenericComponentType());
    }

    @Override // com.google.common.reflect.s
    void a(Class<?> cls) {
        this.f14018b.set(cls.getComponentType());
    }
}
