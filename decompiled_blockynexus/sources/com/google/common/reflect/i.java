package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Class f14006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AtomicReference f14007c;

    i(Class cls, AtomicReference atomicReference) {
        this.f14006b = cls;
        this.f14007c = atomicReference;
    }

    @Override // com.google.common.reflect.s
    void a(Class<?> cls) {
    }

    @Override // com.google.common.reflect.s
    void a(GenericArrayType genericArrayType) {
    }

    @Override // com.google.common.reflect.s
    void a(TypeVariable<?> typeVariable) {
        if (typeVariable.getGenericDeclaration() == this.f14006b) {
            this.f14007c.set(Types.c(Object.class));
        }
    }

    @Override // com.google.common.reflect.s
    void a(WildcardType wildcardType) {
    }

    @Override // com.google.common.reflect.s
    void a(ParameterizedType parameterizedType) {
        this.f14007c.set(Types.a(this.f14006b.getEnclosingClass() == null ? parameterizedType.getOwnerType() : TypeToken.replaceTypeVariablesWithWildcard(parameterizedType.getOwnerType(), (Class<?>) this.f14006b.getEnclosingClass()), (Class<?>) parameterizedType.getRawType(), TypeToken.replaceTypeVariablesWithWildcard(parameterizedType.getActualTypeArguments(), (Class<?>) this.f14006b)));
    }
}
