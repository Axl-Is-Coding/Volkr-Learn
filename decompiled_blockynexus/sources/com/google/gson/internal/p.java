package com.google.gson.internal;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;

/* JADX INFO: compiled from: ConstructorConstructor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Type, com.google.gson.l<?>> f14229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.internal.a.b f14230b = com.google.gson.internal.a.b.a();

    public p(Map<Type, com.google.gson.l<?>> map) {
        this.f14229a = map;
    }

    private <T> w<T> b(Type type, Class<? super T> cls) {
        return new f(this, cls, type);
    }

    public <T> w<T> a(TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        com.google.gson.l<?> lVar = this.f14229a.get(type);
        if (lVar != null) {
            return new g(this, lVar, type);
        }
        com.google.gson.l<?> lVar2 = this.f14229a.get(rawType);
        if (lVar2 != null) {
            return new h(this, lVar2, type);
        }
        w<T> wVarA = a(rawType);
        if (wVarA != null) {
            return wVarA;
        }
        w<T> wVarA2 = a(type, rawType);
        return wVarA2 != null ? wVarA2 : b(type, rawType);
    }

    public String toString() {
        return this.f14229a.toString();
    }

    private <T> w<T> a(Class<? super T> cls) {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.f14230b.a(declaredConstructor);
            }
            return new i(this, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> w<T> a(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            if (SortedSet.class.isAssignableFrom(cls)) {
                return new j(this);
            }
            if (EnumSet.class.isAssignableFrom(cls)) {
                return new k(this, type);
            }
            if (Set.class.isAssignableFrom(cls)) {
                return new l(this);
            }
            if (Queue.class.isAssignableFrom(cls)) {
                return new m(this);
            }
            return new n(this);
        }
        if (!Map.class.isAssignableFrom(cls)) {
            return null;
        }
        if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            return new o(this);
        }
        if (ConcurrentMap.class.isAssignableFrom(cls)) {
            return new C2272b(this);
        }
        if (SortedMap.class.isAssignableFrom(cls)) {
            return new C2292c(this);
        }
        if ((type instanceof ParameterizedType) && !String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) {
            return new C2293d(this);
        }
        return new C2294e(this);
    }
}
