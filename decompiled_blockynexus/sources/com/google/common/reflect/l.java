package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes2.dex */
class l extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TypeToken f14010b;

    l(TypeToken typeToken) {
        this.f14010b = typeToken;
    }

    @Override // com.google.common.reflect.s
    void a(TypeVariable<?> typeVariable) {
        throw new IllegalArgumentException(this.f14010b.runtimeType + "contains a type variable and is not safe for the operation");
    }

    @Override // com.google.common.reflect.s
    void a(WildcardType wildcardType) {
        a(wildcardType.getLowerBounds());
        a(wildcardType.getUpperBounds());
    }

    @Override // com.google.common.reflect.s
    void a(ParameterizedType parameterizedType) {
        a(parameterizedType.getActualTypeArguments());
        a(parameterizedType.getOwnerType());
    }

    @Override // com.google.common.reflect.s
    void a(GenericArrayType genericArrayType) {
        a(genericArrayType.getGenericComponentType());
    }
}
