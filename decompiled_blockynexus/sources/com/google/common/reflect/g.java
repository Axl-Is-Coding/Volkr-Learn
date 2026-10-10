package com.google.common.reflect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.reflect.Types;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: TypeResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f13997a;

    /* synthetic */ g(b bVar, f fVar) {
        this(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Map<c, Type> map, Type type, Type type2) {
        if (!type.equals(type2) && (type2 instanceof WildcardType) == (type instanceof WildcardType)) {
            new f(map, type2).a(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: TypeResolver.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ImmutableMap<c, Type> f14000a;

        b() {
            this.f14000a = ImmutableMap.of();
        }

        final b a(Map<c, ? extends Type> map) {
            ImmutableMap.a aVarBuilder = ImmutableMap.builder();
            aVarBuilder.a(this.f14000a);
            for (Map.Entry<c, ? extends Type> entry : map.entrySet()) {
                c key = entry.getKey();
                Type value = entry.getValue();
                com.google.common.base.m.a(!key.a(value), "Type variable %s bound to itself", key);
                aVarBuilder.a(key, value);
            }
            return new b(aVarBuilder.a());
        }

        private b(ImmutableMap<c, Type> immutableMap) {
            this.f14000a = immutableMap;
        }

        final Type a(TypeVariable<?> typeVariable) {
            return a(typeVariable, new h(this, typeVariable, this));
        }

        Type a(TypeVariable<?> typeVariable, b bVar) {
            Type type = this.f14000a.get(new c(typeVariable));
            f fVar = null;
            if (type == null) {
                Type[] bounds = typeVariable.getBounds();
                if (bounds.length == 0) {
                    return typeVariable;
                }
                Type[] typeArrA = new g(bVar, fVar).a(bounds);
                return (Types.a.f13984a && Arrays.equals(bounds, typeArrA)) ? typeVariable : Types.a(typeVariable.getGenericDeclaration(), typeVariable.getName(), typeArrA);
            }
            return new g(bVar, fVar).b(type);
        }
    }

    /* JADX INFO: compiled from: TypeResolver.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TypeVariable<?> f14001a;

        c(TypeVariable<?> typeVariable) {
            com.google.common.base.m.a(typeVariable);
            this.f14001a = typeVariable;
        }

        static Object b(Type type) {
            if (type instanceof TypeVariable) {
                return new c((TypeVariable) type);
            }
            return null;
        }

        boolean a(Type type) {
            if (type instanceof TypeVariable) {
                return a((TypeVariable<?>) type);
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return a(((c) obj).f14001a);
            }
            return false;
        }

        public int hashCode() {
            return com.google.common.base.k.a(this.f14001a.getGenericDeclaration(), this.f14001a.getName());
        }

        public String toString() {
            return this.f14001a.toString();
        }

        private boolean a(TypeVariable<?> typeVariable) {
            return this.f14001a.getGenericDeclaration().equals(typeVariable.getGenericDeclaration()) && this.f14001a.getName().equals(typeVariable.getName());
        }
    }

    /* JADX INFO: compiled from: TypeResolver.java */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f14002a;

        private d() {
            this.f14002a = new AtomicInteger();
        }

        private Type b(Type type) {
            if (type == null) {
                return null;
            }
            return a(type);
        }

        Type a(Type type) {
            com.google.common.base.m.a(type);
            if ((type instanceof Class) || (type instanceof TypeVariable)) {
                return type;
            }
            if (type instanceof GenericArrayType) {
                return Types.b(a(((GenericArrayType) type).getGenericComponentType()));
            }
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                return Types.a(b(parameterizedType.getOwnerType()), (Class<?>) parameterizedType.getRawType(), a(parameterizedType.getActualTypeArguments()));
            }
            if (!(type instanceof WildcardType)) {
                throw new AssertionError("must have been one of the known types");
            }
            WildcardType wildcardType = (WildcardType) type;
            if (wildcardType.getLowerBounds().length != 0) {
                return type;
            }
            return Types.a(d.class, "capture#" + this.f14002a.incrementAndGet() + "-of ? extends " + com.google.common.base.h.a('&').a((Object[]) wildcardType.getUpperBounds()), wildcardType.getUpperBounds());
        }

        /* synthetic */ d(f fVar) {
            this();
        }

        private Type[] a(Type[] typeArr) {
            Type[] typeArr2 = new Type[typeArr.length];
            for (int i = 0; i < typeArr.length; i++) {
                typeArr2[i] = a(typeArr[i]);
            }
            return typeArr2;
        }
    }

    public g() {
        this.f13997a = new b();
    }

    /* JADX INFO: compiled from: TypeResolver.java */
    private static final class a extends s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final d f13998b = new d(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<c, Type> f13999c = Maps.b();

        private a() {
        }

        static ImmutableMap<c, Type> a(Type type) {
            a aVar = new a();
            aVar.a(f13998b.a(type));
            return ImmutableMap.copyOf((Map) aVar.f13999c);
        }

        @Override // com.google.common.reflect.s
        void a(Class<?> cls) {
            a(cls.getGenericSuperclass());
            a(cls.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.s
        void a(ParameterizedType parameterizedType) {
            Class cls = (Class) parameterizedType.getRawType();
            TypeVariable[] typeParameters = cls.getTypeParameters();
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            com.google.common.base.m.b(typeParameters.length == actualTypeArguments.length);
            for (int i = 0; i < typeParameters.length; i++) {
                a(new c(typeParameters[i]), actualTypeArguments[i]);
            }
            a(cls);
            a(parameterizedType.getOwnerType());
        }

        @Override // com.google.common.reflect.s
        void a(TypeVariable<?> typeVariable) {
            a(typeVariable.getBounds());
        }

        @Override // com.google.common.reflect.s
        void a(WildcardType wildcardType) {
            a(wildcardType.getUpperBounds());
        }

        private void a(c cVar, Type type) {
            if (this.f13999c.containsKey(cVar)) {
                return;
            }
            Type type2 = type;
            while (type2 != null) {
                if (cVar.a(type2)) {
                    while (type != null) {
                        type = this.f13999c.remove(c.b(type));
                    }
                    return;
                }
                type2 = this.f13999c.get(c.b(type2));
            }
            this.f13999c.put(cVar, type);
        }
    }

    private g(b bVar) {
        this.f13997a = bVar;
    }

    static g a(Type type) {
        return new g().a(a.a(type));
    }

    public Type b(Type type) {
        com.google.common.base.m.a(type);
        if (type instanceof TypeVariable) {
            return this.f13997a.a((TypeVariable<?>) type);
        }
        if (type instanceof ParameterizedType) {
            return a((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return a((GenericArrayType) type);
        }
        return type instanceof WildcardType ? a((WildcardType) type) : type;
    }

    public g a(Type type, Type type2) {
        HashMap mapB = Maps.b();
        com.google.common.base.m.a(type);
        com.google.common.base.m.a(type2);
        b(mapB, type, type2);
        return a(mapB);
    }

    g a(Map<c, ? extends Type> map) {
        return new g(this.f13997a.a(map));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Type[] a(Type[] typeArr) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = b(typeArr[i]);
        }
        return typeArr2;
    }

    private WildcardType a(WildcardType wildcardType) {
        return new Types.WildcardTypeImpl(a(wildcardType.getLowerBounds()), a(wildcardType.getUpperBounds()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T b(Class<T> cls, Object obj) {
        try {
            return cls.cast(obj);
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException(obj + " is not a " + cls.getSimpleName());
        }
    }

    private Type a(GenericArrayType genericArrayType) {
        return Types.b(b(genericArrayType.getGenericComponentType()));
    }

    private ParameterizedType a(ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        return Types.a(ownerType == null ? null : b(ownerType), (Class<?>) b(parameterizedType.getRawType()), a(parameterizedType.getActualTypeArguments()));
    }
}
