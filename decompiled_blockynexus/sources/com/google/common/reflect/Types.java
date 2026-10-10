package com.google.common.reflect;

import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.L;
import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessControlException;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
final class Types {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.google.common.base.f<Type, String> f13982a = new t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.google.common.base.h f13983b = com.google.common.base.h.a(", ").b("null");

    private enum ClassOwnership {
        OWNED_BY_ENCLOSING_CLASS { // from class: com.google.common.reflect.Types.ClassOwnership.1
            @Override // com.google.common.reflect.Types.ClassOwnership
            Class<?> getOwnerType(Class<?> cls) {
                return cls.getEnclosingClass();
            }
        },
        LOCAL_CLASS_HAS_NO_OWNER { // from class: com.google.common.reflect.Types.ClassOwnership.2
            @Override // com.google.common.reflect.Types.ClassOwnership
            Class<?> getOwnerType(Class<?> cls) {
                if (cls.isLocalClass()) {
                    return null;
                }
                return cls.getEnclosingClass();
            }
        };

        static final ClassOwnership JVM_BEHAVIOR = detectJvmBehavior();

        private static ClassOwnership detectJvmBehavior() {
            new w();
            ParameterizedType parameterizedType = (ParameterizedType) w.class.getGenericSuperclass();
            for (ClassOwnership classOwnership : values()) {
                if (classOwnership.getOwnerType(v.class) == parameterizedType.getOwnerType()) {
                    return classOwnership;
                }
            }
            throw new AssertionError();
        }

        abstract Class<?> getOwnerType(Class<?> cls);

        /* synthetic */ ClassOwnership(t tVar) {
            this();
        }
    }

    private static final class GenericArrayTypeImpl implements Serializable, GenericArrayType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        GenericArrayTypeImpl(Type type) {
            this.componentType = JavaVersion.CURRENT.usedInGenericType(type);
        }

        public boolean equals(Object obj) {
            if (obj instanceof GenericArrayType) {
                return com.google.common.base.k.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
            }
            return false;
        }

        @Override // java.lang.reflect.GenericArrayType
        public Type getGenericComponentType() {
            return this.componentType;
        }

        public int hashCode() {
            return this.componentType.hashCode();
        }

        public String toString() {
            return Types.e(this.componentType) + "[]";
        }
    }

    enum JavaVersion {
        JAVA6 { // from class: com.google.common.reflect.Types.JavaVersion.1
            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                com.google.common.base.m.a(type);
                if (!(type instanceof Class)) {
                    return type;
                }
                Class cls = (Class) type;
                return cls.isArray() ? new GenericArrayTypeImpl(cls.getComponentType()) : type;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.reflect.Types.JavaVersion
            public GenericArrayType newArrayType(Type type) {
                return new GenericArrayTypeImpl(type);
            }
        },
        JAVA7 { // from class: com.google.common.reflect.Types.JavaVersion.2
            @Override // com.google.common.reflect.Types.JavaVersion
            Type newArrayType(Type type) {
                return type instanceof Class ? Types.a((Class<?>) type) : new GenericArrayTypeImpl(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                com.google.common.base.m.a(type);
                return type;
            }
        },
        JAVA8 { // from class: com.google.common.reflect.Types.JavaVersion.3
            @Override // com.google.common.reflect.Types.JavaVersion
            Type newArrayType(Type type) {
                return JavaVersion.JAVA7.newArrayType(type);
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            String typeName(Type type) {
                try {
                    return (String) Type.class.getMethod("getTypeName", new Class[0]).invoke(type, new Object[0]);
                } catch (IllegalAccessException e2) {
                    throw new RuntimeException(e2);
                } catch (NoSuchMethodException unused) {
                    throw new AssertionError("Type.getTypeName should be available in Java 8");
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException(e3);
                }
            }

            @Override // com.google.common.reflect.Types.JavaVersion
            Type usedInGenericType(Type type) {
                return JavaVersion.JAVA7.usedInGenericType(type);
            }
        };

        static final JavaVersion CURRENT;

        static {
            if (AnnotatedElement.class.isAssignableFrom(TypeVariable.class)) {
                CURRENT = JAVA8;
            } else if (new x().capture() instanceof Class) {
                CURRENT = JAVA7;
            } else {
                CURRENT = JAVA6;
            }
        }

        abstract Type newArrayType(Type type);

        String typeName(Type type) {
            return Types.e(type);
        }

        final ImmutableList<Type> usedInGenericType(Type[] typeArr) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            for (Type type : typeArr) {
                aVarBuilder.a(usedInGenericType(type));
            }
            return aVarBuilder.a();
        }

        abstract Type usedInGenericType(Type type);

        /* synthetic */ JavaVersion(t tVar) {
            this();
        }
    }

    private static final class ParameterizedTypeImpl implements Serializable, ParameterizedType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> argumentsList;
        private final Type ownerType;
        private final Class<?> rawType;

        ParameterizedTypeImpl(Type type, Class<?> cls, Type[] typeArr) {
            com.google.common.base.m.a(cls);
            com.google.common.base.m.a(typeArr.length == cls.getTypeParameters().length);
            Types.b(typeArr, "type parameter");
            this.ownerType = type;
            this.rawType = cls;
            this.argumentsList = JavaVersion.CURRENT.usedInGenericType(typeArr);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return getRawType().equals(parameterizedType.getRawType()) && com.google.common.base.k.a(getOwnerType(), parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type[] getActualTypeArguments() {
            return Types.b((Collection<Type>) this.argumentsList);
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getOwnerType() {
            return this.ownerType;
        }

        @Override // java.lang.reflect.ParameterizedType
        public Type getRawType() {
            return this.rawType;
        }

        public int hashCode() {
            Type type = this.ownerType;
            return ((type == null ? 0 : type.hashCode()) ^ this.argumentsList.hashCode()) ^ this.rawType.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            Type type = this.ownerType;
            if (type != null) {
                sb.append(JavaVersion.CURRENT.typeName(type));
                sb.append('.');
            }
            sb.append(this.rawType.getName());
            sb.append('<');
            sb.append(Types.f13983b.a(L.a((Iterable) this.argumentsList, Types.f13982a)));
            sb.append('>');
            return sb.toString();
        }
    }

    static final class WildcardTypeImpl implements Serializable, WildcardType {
        private static final long serialVersionUID = 0;
        private final ImmutableList<Type> lowerBounds;
        private final ImmutableList<Type> upperBounds;

        WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            Types.b(typeArr, "lower bound for wildcard");
            Types.b(typeArr2, "upper bound for wildcard");
            this.lowerBounds = JavaVersion.CURRENT.usedInGenericType(typeArr);
            this.upperBounds = JavaVersion.CURRENT.usedInGenericType(typeArr2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) obj;
            return this.lowerBounds.equals(Arrays.asList(wildcardType.getLowerBounds())) && this.upperBounds.equals(Arrays.asList(wildcardType.getUpperBounds()));
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getLowerBounds() {
            return Types.b((Collection<Type>) this.lowerBounds);
        }

        @Override // java.lang.reflect.WildcardType
        public Type[] getUpperBounds() {
            return Types.b((Collection<Type>) this.upperBounds);
        }

        public int hashCode() {
            return this.lowerBounds.hashCode() ^ this.upperBounds.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("?");
            for (Type type : this.lowerBounds) {
                sb.append(" super ");
                sb.append(JavaVersion.CURRENT.typeName(type));
            }
            for (Type type2 : Types.b((Iterable<Type>) this.upperBounds)) {
                sb.append(" extends ");
                sb.append(JavaVersion.CURRENT.typeName(type2));
            }
            return sb.toString();
        }
    }

    static final class a<X> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final boolean f13984a = !a.class.getTypeParameters()[0].equals(Types.a(a.class, "X", new Type[0]));

        a() {
        }
    }

    private static final class b<D extends GenericDeclaration> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final D f13985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f13986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ImmutableList<Type> f13987c;

        b(D d2, String str, Type[] typeArr) {
            Types.b(typeArr, "bound for type variable");
            com.google.common.base.m.a(d2);
            this.f13985a = d2;
            com.google.common.base.m.a(str);
            this.f13986b = str;
            this.f13987c = ImmutableList.copyOf(typeArr);
        }

        public D a() {
            return this.f13985a;
        }

        public String b() {
            return this.f13986b;
        }

        public boolean equals(Object obj) {
            if (!a.f13984a) {
                if (!(obj instanceof TypeVariable)) {
                    return false;
                }
                TypeVariable typeVariable = (TypeVariable) obj;
                return this.f13986b.equals(typeVariable.getName()) && this.f13985a.equals(typeVariable.getGenericDeclaration());
            }
            if (obj == null || !Proxy.isProxyClass(obj.getClass()) || !(Proxy.getInvocationHandler(obj) instanceof c)) {
                return false;
            }
            b bVar = ((c) Proxy.getInvocationHandler(obj)).f13989b;
            return this.f13986b.equals(bVar.b()) && this.f13985a.equals(bVar.a()) && this.f13987c.equals(bVar.f13987c);
        }

        public int hashCode() {
            return this.f13985a.hashCode() ^ this.f13986b.hashCode();
        }

        public String toString() {
            return this.f13986b;
        }
    }

    private static final class c implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ImmutableMap<String, Method> f13988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b<?> f13989b;

        static {
            ImmutableMap.a aVarBuilder = ImmutableMap.builder();
            for (Method method : b.class.getMethods()) {
                if (method.getDeclaringClass().equals(b.class)) {
                    try {
                        method.setAccessible(true);
                    } catch (AccessControlException unused) {
                    }
                    aVarBuilder.a(method.getName(), method);
                }
            }
            f13988a = aVarBuilder.a();
        }

        c(b<?> bVar) {
            this.f13989b = bVar;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Method method2 = f13988a.get(name);
            if (method2 == null) {
                throw new UnsupportedOperationException(name);
            }
            try {
                return method2.invoke(this.f13989b, objArr);
            } catch (InvocationTargetException e2) {
                throw e2.getCause();
            }
        }
    }

    static WildcardType c(Type type) {
        return new WildcardTypeImpl(new Type[0], new Type[]{type});
    }

    static WildcardType d(Type type) {
        return new WildcardTypeImpl(new Type[]{type}, new Type[]{Object.class});
    }

    static String e(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    static Type b(Type type) {
        if (!(type instanceof WildcardType)) {
            return JavaVersion.CURRENT.newArrayType(type);
        }
        WildcardType wildcardType = (WildcardType) type;
        Type[] lowerBounds = wildcardType.getLowerBounds();
        com.google.common.base.m.a(lowerBounds.length <= 1, "Wildcard cannot have more than one lower bounds.");
        if (lowerBounds.length == 1) {
            return d(b(lowerBounds[0]));
        }
        Type[] upperBounds = wildcardType.getUpperBounds();
        com.google.common.base.m.a(upperBounds.length == 1, "Wildcard should have only one upper bound.");
        return c(b(upperBounds[0]));
    }

    static ParameterizedType a(Type type, Class<?> cls, Type... typeArr) {
        if (type == null) {
            return a(cls, typeArr);
        }
        com.google.common.base.m.a(typeArr);
        com.google.common.base.m.a(cls.getEnclosingClass() != null, "Owner type for unenclosed %s", cls);
        return new ParameterizedTypeImpl(type, cls, typeArr);
    }

    static ParameterizedType a(Class<?> cls, Type... typeArr) {
        return new ParameterizedTypeImpl(ClassOwnership.JVM_BEHAVIOR.getOwnerType(cls), cls, typeArr);
    }

    static <D extends GenericDeclaration> TypeVariable<D> a(D d2, String str, Type... typeArr) {
        if (typeArr.length == 0) {
            typeArr = new Type[]{Object.class};
        }
        return b(d2, str, typeArr);
    }

    static Type a(Type type) {
        com.google.common.base.m.a(type);
        AtomicReference atomicReference = new AtomicReference();
        new u(atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type b(Type[] typeArr) {
        for (Type type : typeArr) {
            Type typeA = a(type);
            if (typeA != null) {
                if (typeA instanceof Class) {
                    Class cls = (Class) typeA;
                    if (cls.isPrimitive()) {
                        return cls;
                    }
                }
                return c(typeA);
            }
        }
        return null;
    }

    static Class<?> a(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    private static <D extends GenericDeclaration> TypeVariable<D> b(D d2, String str, Type[] typeArr) {
        return (TypeVariable) com.google.common.reflect.c.a(TypeVariable.class, new c(new b(d2, str, typeArr)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Type[] b(Collection<Type> collection) {
        return (Type[]) collection.toArray(new Type[collection.size()]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterable<Type> b(Iterable<Type> iterable) {
        return L.b(iterable, Predicates.a(Predicates.a(Object.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Type[] typeArr, String str) {
        for (Type type : typeArr) {
            if (type instanceof Class) {
                com.google.common.base.m.a(!r3.isPrimitive(), "Primitive type '%s' used as %s", (Class) type, str);
            }
        }
    }
}
