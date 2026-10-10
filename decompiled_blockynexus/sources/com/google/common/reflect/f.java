package com.google.common.reflect;

import com.google.common.reflect.g;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Map;

/* JADX INFO: compiled from: TypeResolver.java */
/* JADX INFO: loaded from: classes2.dex */
class f extends s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f13995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Type f13996c;

    f(Map map, Type type) {
        this.f13995b = map;
        this.f13996c = type;
    }

    @Override // com.google.common.reflect.s
    void a(TypeVariable<?> typeVariable) {
        this.f13995b.put(new g.c(typeVariable), this.f13996c);
    }

    @Override // com.google.common.reflect.s
    void a(WildcardType wildcardType) {
        WildcardType wildcardType2 = (WildcardType) g.b(WildcardType.class, this.f13996c);
        Type[] upperBounds = wildcardType.getUpperBounds();
        Type[] upperBounds2 = wildcardType2.getUpperBounds();
        Type[] lowerBounds = wildcardType.getLowerBounds();
        Type[] lowerBounds2 = wildcardType2.getLowerBounds();
        com.google.common.base.m.a(upperBounds.length == upperBounds2.length && lowerBounds.length == lowerBounds2.length, "Incompatible type: %s vs. %s", wildcardType, this.f13996c);
        for (int i = 0; i < upperBounds.length; i++) {
            g.b(this.f13995b, upperBounds[i], upperBounds2[i]);
        }
        for (int i2 = 0; i2 < lowerBounds.length; i2++) {
            g.b(this.f13995b, lowerBounds[i2], lowerBounds2[i2]);
        }
    }

    @Override // com.google.common.reflect.s
    void a(ParameterizedType parameterizedType) {
        ParameterizedType parameterizedType2 = (ParameterizedType) g.b(ParameterizedType.class, this.f13996c);
        com.google.common.base.m.a(parameterizedType.getRawType().equals(parameterizedType2.getRawType()), "Inconsistent raw type: %s vs. %s", parameterizedType, this.f13996c);
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        Type[] actualTypeArguments2 = parameterizedType2.getActualTypeArguments();
        com.google.common.base.m.a(actualTypeArguments.length == actualTypeArguments2.length, "%s not compatible with %s", parameterizedType, parameterizedType2);
        for (int i = 0; i < actualTypeArguments.length; i++) {
            g.b(this.f13995b, actualTypeArguments[i], actualTypeArguments2[i]);
        }
    }

    @Override // com.google.common.reflect.s
    void a(GenericArrayType genericArrayType) {
        Type typeA = Types.a(this.f13996c);
        com.google.common.base.m.a(typeA != null, "%s is not an array type.", this.f13996c);
        g.b(this.f13995b, genericArrayType.getGenericComponentType(), typeA);
    }

    @Override // com.google.common.reflect.s
    void a(Class<?> cls) {
        throw new IllegalArgumentException("No type mapping from " + cls);
    }
}
