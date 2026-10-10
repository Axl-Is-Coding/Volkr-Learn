package com.google.common.reflect;

import com.google.common.collect.ImmutableSet;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* JADX INFO: compiled from: TypeToken.java */
/* JADX INFO: loaded from: classes2.dex */
class m extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ImmutableSet.a f14011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TypeToken f14012c;

    m(TypeToken typeToken, ImmutableSet.a aVar) {
        this.f14012c = typeToken;
        this.f14011b = aVar;
    }

    @Override // com.google.common.reflect.s
    void a(TypeVariable<?> typeVariable) {
        a(typeVariable.getBounds());
    }

    @Override // com.google.common.reflect.s
    void a(WildcardType wildcardType) {
        a(wildcardType.getUpperBounds());
    }

    @Override // com.google.common.reflect.s
    void a(ParameterizedType parameterizedType) {
        this.f14011b.a((Class) parameterizedType.getRawType());
    }

    @Override // com.google.common.reflect.s
    void a(Class<?> cls) {
        this.f14011b.a(cls);
    }

    @Override // com.google.common.reflect.s
    void a(GenericArrayType genericArrayType) {
        this.f14011b.a(Types.a((Class<?>) TypeToken.of(genericArrayType.getGenericComponentType()).getRawType()));
    }
}
