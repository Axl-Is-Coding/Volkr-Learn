package com.google.common.reflect;

import com.google.common.collect.AbstractC2267w;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.reflect.Types;
import com.google.common.reflect.g;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class TypeToken<T> extends d<T> implements Serializable {
    private final Type runtimeType;
    private transient g typeResolver;

    private final class ClassSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> classes;

        private ClassSet() {
            super();
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) b.f13980b.a().a(TypeToken.this.getRawTypes()));
        }

        /* synthetic */ ClassSet(TypeToken typeToken, i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.AbstractC2267w, com.google.common.collect.AbstractC2263s, com.google.common.collect.AbstractC2266v
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.classes;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetA = com.google.common.collect.r.a(b.f13979a.a().a(TypeToken.this)).a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).a();
            this.classes = immutableSetA;
            return immutableSetA;
        }
    }

    private static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type, null);
        }
    }

    private enum TypeFilter implements com.google.common.base.n<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD { // from class: com.google.common.reflect.TypeToken.TypeFilter.1
            @Override // com.google.common.base.n
            public boolean apply(TypeToken<?> typeToken) {
                return ((((TypeToken) typeToken).runtimeType instanceof TypeVariable) || (((TypeToken) typeToken).runtimeType instanceof WildcardType)) ? false : true;
            }
        },
        INTERFACE_ONLY { // from class: com.google.common.reflect.TypeToken.TypeFilter.2
            @Override // com.google.common.base.n
            public boolean apply(TypeToken<?> typeToken) {
                return typeToken.getRawType().isInterface();
            }
        };

        /* synthetic */ TypeFilter(i iVar) {
            this();
        }
    }

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Type[] f13977a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f13978b;

        a(Type[] typeArr, boolean z) {
            this.f13977a = typeArr;
            this.f13978b = z;
        }

        boolean a(Type type) {
            for (Type type2 : this.f13977a) {
                boolean zIsSubtypeOf = TypeToken.of(type2).isSubtypeOf(type);
                boolean z = this.f13978b;
                if (zIsSubtypeOf == z) {
                    return z;
                }
            }
            return !this.f13978b;
        }

        boolean b(Type type) {
            TypeToken<?> typeTokenOf = TypeToken.of(type);
            for (Type type2 : this.f13977a) {
                boolean zIsSubtypeOf = typeTokenOf.isSubtypeOf(type2);
                boolean z = this.f13978b;
                if (zIsSubtypeOf == z) {
                    return z;
                }
            }
            return !this.f13978b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static abstract class b<K> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b<TypeToken<?>> f13979a = new o();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final b<Class<?>> f13980b = new p();

        /* JADX INFO: Access modifiers changed from: private */
        static class a<K> extends b<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final b<K> f13981c;

            a(b<K> bVar) {
                super(null);
                this.f13981c = bVar;
            }

            @Override // com.google.common.reflect.TypeToken.b
            Class<?> c(K k) {
                return this.f13981c.c(k);
            }

            @Override // com.google.common.reflect.TypeToken.b
            K d(K k) {
                return this.f13981c.d(k);
            }
        }

        private b() {
        }

        final b<K> a() {
            return new q(this, this);
        }

        abstract Iterable<? extends K> b(K k);

        abstract Class<?> c(K k);

        abstract K d(K k);

        /* synthetic */ b(i iVar) {
            this();
        }

        final ImmutableList<K> a(K k) {
            return a((Iterable) ImmutableList.of(k));
        }

        ImmutableList<K> a(Iterable<? extends K> iterable) {
            HashMap mapB = Maps.b();
            Iterator<? extends K> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next(), mapB);
            }
            return a(mapB, Ordering.natural().reverse());
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int a(K k, Map<? super K, Integer> map) {
            Integer num = map.get(this);
            if (num != null) {
                return num.intValue();
            }
            boolean zIsInterface = c(k).isInterface();
            Iterator<? extends K> it = b(k).iterator();
            int iMax = zIsInterface;
            while (it.hasNext()) {
                iMax = Math.max(iMax, a(it.next(), map));
            }
            K kD = d(k);
            int iMax2 = iMax;
            if (kD != null) {
                iMax2 = Math.max(iMax, a(kD, map));
            }
            int i = iMax2 + 1;
            map.put(k, Integer.valueOf(i));
            return i;
        }

        private static <K, V> ImmutableList<K> a(Map<K, V> map, Comparator<? super V> comparator) {
            return (ImmutableList<K>) new r(comparator, map).immutableSortedCopy(map.keySet());
        }
    }

    /* synthetic */ TypeToken(Type type, i iVar) {
        this(type);
    }

    static /* synthetic */ Type[] access$200(TypeToken typeToken, Type[] typeArr) {
        typeToken.resolveInPlace(typeArr);
        return typeArr;
    }

    private static a any(Type[] typeArr) {
        return new a(typeArr, true);
    }

    private TypeToken<? super T> boundAsSuperclass(Type type) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) of(type);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] typeArr) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (Type type : typeArr) {
            TypeToken<?> typeTokenOf = of(type);
            if (typeTokenOf.getRawType().isInterface()) {
                aVarBuilder.a(typeTokenOf);
            }
        }
        return aVarBuilder.a();
    }

    private static a every(Type[] typeArr) {
        return new a(typeArr, false);
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> cls) {
        return (TypeToken<? extends T>) of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(cls.getComponentType()).runtimeType));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> cls) {
        d componentType = getComponentType();
        com.google.common.base.m.a(componentType, "%s isn't a super type of %s", cls, this);
        return (TypeToken<? super T>) of(newArrayClassOrGenericArrayType(((TypeToken) componentType).getSupertype(cls.getComponentType()).runtimeType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        ImmutableSet.a aVarBuilder = ImmutableSet.builder();
        new m(this, aVarBuilder).a(this.runtimeType);
        return aVarBuilder.a();
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> cls, Type[] typeArr) {
        if (typeArr.length > 0) {
            return (TypeToken<? extends T>) of(typeArr[0]).getSubtype(cls);
        }
        throw new IllegalArgumentException(cls + " isn't a subclass of " + this);
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> cls, Type[] typeArr) {
        for (Type type : typeArr) {
            TypeToken<?> typeTokenOf = of(type);
            if (typeTokenOf.isSubtypeOf(cls)) {
                return (TypeToken<? super T>) typeTokenOf.getSupertype(cls);
            }
        }
        throw new IllegalArgumentException(cls + " isn't a super type of " + this);
    }

    private boolean is(Type type) {
        if (this.runtimeType.equals(type)) {
            return true;
        }
        if (!(type instanceof WildcardType)) {
            return false;
        }
        WildcardType wildcardType = (WildcardType) type;
        return every(wildcardType.getUpperBounds()).b(this.runtimeType) && every(wildcardType.getLowerBounds()).a(this.runtimeType);
    }

    private boolean isSubTypeOfArrayType(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (!(type instanceof Class)) {
            if (type instanceof GenericArrayType) {
                return of(((GenericArrayType) type).getGenericComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
            }
            return false;
        }
        Class cls = (Class) type;
        if (cls.isArray()) {
            return of((Class) cls.getComponentType()).isSubtypeOf(genericArrayType.getGenericComponentType());
        }
        return false;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType parameterizedType) {
        Class<? super Object> rawType = of(parameterizedType).getRawType();
        if (!someRawTypeIsSubclassOf(rawType)) {
            return false;
        }
        TypeVariable<Class<? super Object>>[] typeParameters = rawType.getTypeParameters();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (int i = 0; i < typeParameters.length; i++) {
            if (!resolveType(typeParameters[i]).is(actualTypeArguments[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isSuperTypeOfArray(GenericArrayType genericArrayType) {
        Type type = this.runtimeType;
        if (type instanceof Class) {
            Class cls = (Class) type;
            return !cls.isArray() ? cls.isAssignableFrom(Object[].class) : of(genericArrayType.getGenericComponentType()).isSubtypeOf(cls.getComponentType());
        }
        if (type instanceof GenericArrayType) {
            return of(genericArrayType.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        }
        return false;
    }

    private boolean isWrapper() {
        return b.c.b.b.b.a().contains(this.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type type) {
        return Types.JavaVersion.JAVA7.newArrayType(type);
    }

    public static <T> TypeToken<T> of(Class<T> cls) {
        return new SimpleTypeToken(cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type replaceTypeVariablesWithWildcard(Type type, Class<?> cls) {
        com.google.common.base.m.a(cls);
        AtomicReference atomicReference = new AtomicReference();
        atomicReference.set(type);
        new i(cls, atomicReference).a(type);
        return (Type) atomicReference.get();
    }

    private Type[] resolveInPlace(Type[] typeArr) {
        for (int i = 0; i < typeArr.length; i++) {
            typeArr[i] = resolveType(typeArr[i]).getType();
        }
        return typeArr;
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> typeTokenResolveType = resolveType(type);
        typeTokenResolveType.typeResolver = this.typeResolver;
        return typeTokenResolveType;
    }

    private Type resolveTypeArgsForSubclass(Class<?> cls) {
        if (this.runtimeType instanceof Class) {
            return cls;
        }
        TypeToken genericType = toGenericType(cls);
        return new g().a(genericType.getSupertype(getRawType()).runtimeType, this.runtimeType).b(genericType.runtimeType);
    }

    private boolean someRawTypeIsSubclassOf(Class<?> cls) {
        Iterator it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (cls.isAssignableFrom((Class) it.next())) {
                return true;
            }
        }
        return false;
    }

    static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) of(Types.b(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParameters = cls.getTypeParameters();
        Type type = cls.isMemberClass() ? toGenericType(cls.getEnclosingClass()).runtimeType : null;
        return (typeParameters.length > 0 || type != cls.getEnclosingClass()) ? (TypeToken<? extends T>) of(Types.a(type, (Class<?>) cls, (Type[]) typeParameters)) : of((Class) cls);
    }

    public final com.google.common.reflect.b<T, T> constructor(Constructor<?> constructor) {
        com.google.common.base.m.a(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new k(this, constructor);
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) obj).runtimeType);
        }
        return false;
    }

    public final TypeToken<?> getComponentType() {
        Type typeA = Types.a(this.runtimeType);
        if (typeA == null) {
            return null;
        }
        return of(typeA);
    }

    final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) type).getBounds());
        }
        if (type instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) type).getUpperBounds());
        }
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (Type type2 : getRawType().getGenericInterfaces()) {
            aVarBuilder.a(resolveSupertype(type2));
        }
        return aVarBuilder.a();
    }

    final TypeToken<? super T> getGenericSuperclass() {
        Type type = this.runtimeType;
        if (type instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) type).getBounds()[0]);
        }
        if (type instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) type).getUpperBounds()[0]);
        }
        Type genericSuperclass = getRawType().getGenericSuperclass();
        if (genericSuperclass == null) {
            return null;
        }
        return (TypeToken<? super T>) resolveSupertype(genericSuperclass);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final TypeToken<? extends T> getSubtype(Class<?> cls) {
        com.google.common.base.m.a(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        Type type = this.runtimeType;
        if (type instanceof WildcardType) {
            return getSubtypeFromLowerBounds(cls, ((WildcardType) type).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(cls);
        }
        com.google.common.base.m.a(getRawType().isAssignableFrom(cls), "%s isn't a subclass of %s", cls, this);
        return (TypeToken<? extends T>) of(replaceTypeVariablesWithWildcard(resolveTypeArgsForSubclass(cls), cls));
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> cls) {
        com.google.common.base.m.a(someRawTypeIsSubclassOf(cls), "%s is not a super class of %s", cls, this);
        Type type = this.runtimeType;
        return type instanceof TypeVariable ? getSupertypeFromUpperBounds(cls, ((TypeVariable) type).getBounds()) : type instanceof WildcardType ? getSupertypeFromUpperBounds(cls, ((WildcardType) type).getUpperBounds()) : cls.isArray() ? getArraySupertype(cls) : (TypeToken<? super T>) resolveSupertype(toGenericType(cls).runtimeType);
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    @Deprecated
    public final boolean isAssignableFrom(TypeToken<?> typeToken) {
        return isSupertypeOf(typeToken);
    }

    public final boolean isPrimitive() {
        Type type = this.runtimeType;
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    public final boolean isSubtypeOf(TypeToken<?> typeToken) {
        return isSubtypeOf(typeToken.getType());
    }

    public final boolean isSupertypeOf(TypeToken<?> typeToken) {
        return typeToken.isSubtypeOf(getType());
    }

    public final com.google.common.reflect.b<T, Object> method(Method method) {
        com.google.common.base.m.a(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new j(this, method);
    }

    final TypeToken<T> rejectTypeVariables() {
        new l(this).a(this.runtimeType);
        return this;
    }

    public final TypeToken<?> resolveType(Type type) {
        com.google.common.base.m.a(type);
        g gVarA = this.typeResolver;
        if (gVarA == null) {
            gVarA = g.a(this.runtimeType);
            this.typeResolver = gVarA;
        }
        return of(gVarA.b(type));
    }

    public String toString() {
        return Types.e(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        return isWrapper() ? of(b.c.b.b.b.a((Class) this.runtimeType)) : this;
    }

    public final <X> TypeToken<T> where(e<X> eVar, TypeToken<X> typeToken) {
        return new SimpleTypeToken(new g().a(ImmutableMap.of(new g.c(eVar.f13994a), typeToken.runtimeType)).b(this.runtimeType));
    }

    public final TypeToken<T> wrap() {
        return isPrimitive() ? of(b.c.b.b.b.b((Class) this.runtimeType)) : this;
    }

    protected Object writeReplace() {
        return of(new g().b(this.runtimeType));
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class InterfaceSet extends TypeToken<T>.TypeSet {
        private static final long serialVersionUID = 0;
        private final transient TypeToken<T>.TypeSet allTypes;
        private transient ImmutableSet<TypeToken<? super T>> interfaces;

        InterfaceSet(TypeToken<T>.TypeSet typeSet) {
            super();
            this.allTypes = typeSet;
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return com.google.common.collect.r.a(b.f13980b.a(TypeToken.this.getRawTypes())).a(new n(this)).a();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.AbstractC2267w, com.google.common.collect.AbstractC2263s, com.google.common.collect.AbstractC2266v
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.interfaces;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetA = com.google.common.collect.r.a(this.allTypes).a(TypeFilter.INTERFACE_ONLY).a();
            this.interfaces = immutableSetA;
            return immutableSetA;
        }
    }

    public class TypeSet extends AbstractC2267w<TypeToken<? super T>> implements Serializable {
        private static final long serialVersionUID = 0;
        private transient ImmutableSet<TypeToken<? super T>> types;

        TypeSet() {
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet(TypeToken.this, null);
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) b.f13980b.a(TypeToken.this.getRawTypes()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractC2267w, com.google.common.collect.AbstractC2263s, com.google.common.collect.AbstractC2266v
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> immutableSet = this.types;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<TypeToken<? super T>> immutableSetA = com.google.common.collect.r.a(b.f13979a.a(TypeToken.this)).a(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).a();
            this.types = immutableSetA;
            return immutableSetA;
        }
    }

    protected TypeToken() {
        this.runtimeType = capture();
        com.google.common.base.m.b(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
    }

    public static TypeToken<?> of(Type type) {
        return new SimpleTypeToken(type);
    }

    @Deprecated
    public final boolean isAssignableFrom(Type type) {
        return isSupertypeOf(type);
    }

    public final boolean isSubtypeOf(Type type) {
        com.google.common.base.m.a(type);
        if (type instanceof WildcardType) {
            return any(((WildcardType) type).getLowerBounds()).b(this.runtimeType);
        }
        Type type2 = this.runtimeType;
        if (type2 instanceof WildcardType) {
            return any(((WildcardType) type2).getUpperBounds()).a(type);
        }
        if (type2 instanceof TypeVariable) {
            return type2.equals(type) || any(((TypeVariable) this.runtimeType).getBounds()).a(type);
        }
        if (type2 instanceof GenericArrayType) {
            return of(type).isSuperTypeOfArray((GenericArrayType) this.runtimeType);
        }
        if (type instanceof Class) {
            return someRawTypeIsSubclassOf((Class) type);
        }
        if (type instanceof ParameterizedType) {
            return isSubtypeOfParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return isSubTypeOfArrayType((GenericArrayType) type);
        }
        return false;
    }

    public final boolean isSupertypeOf(Type type) {
        return of(type).isSubtypeOf(getType());
    }

    public final <X> TypeToken<T> where(e<X> eVar, Class<X> cls) {
        return where(eVar, of((Class) cls));
    }

    protected TypeToken(Class<?> cls) {
        Type typeCapture = super.capture();
        if (typeCapture instanceof Class) {
            this.runtimeType = typeCapture;
        } else {
            this.runtimeType = of((Class) cls).resolveType(typeCapture).runtimeType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Type[] replaceTypeVariablesWithWildcard(Type[] typeArr, Class<?> cls) {
        Type[] typeArr2 = new Type[typeArr.length];
        for (int i = 0; i < typeArr.length; i++) {
            typeArr2[i] = replaceTypeVariablesWithWildcard(typeArr[i], cls);
        }
        return typeArr2;
    }

    private TypeToken(Type type) {
        com.google.common.base.m.a(type);
        this.runtimeType = type;
    }
}
