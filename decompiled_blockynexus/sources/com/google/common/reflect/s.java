package com.google.common.reflect;

import com.google.common.collect.Aa;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

/* JADX INFO: compiled from: TypeVisitor.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<Type> f14017a = Aa.a();

    s() {
    }

    void a(Class<?> cls) {
    }

    void a(GenericArrayType genericArrayType) {
    }

    void a(ParameterizedType parameterizedType) {
    }

    abstract void a(TypeVariable<?> typeVariable);

    abstract void a(WildcardType wildcardType);

    public final void a(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.f14017a.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        a((TypeVariable<?>) type);
                    } else if (type instanceof WildcardType) {
                        a((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        a((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        a((Class<?>) type);
                    } else {
                        if (!(type instanceof GenericArrayType)) {
                            throw new AssertionError("Unknown type: " + type);
                        }
                        a((GenericArrayType) type);
                    }
                } catch (Throwable th) {
                    this.f14017a.remove(type);
                    throw th;
                }
            }
        }
    }
}
